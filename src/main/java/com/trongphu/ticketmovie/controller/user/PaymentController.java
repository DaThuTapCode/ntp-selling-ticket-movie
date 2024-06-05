package com.trongphu.ticketmovie.controller.user;

import com.trongphu.ticketmovie.dto.request.BookingDTO;
import com.trongphu.ticketmovie.dto.respone.PaymentResDTO;
import com.trongphu.ticketmovie.dto.respone.ResponseData;
import com.trongphu.ticketmovie.dto.respone.ResponseError;
import com.trongphu.ticketmovie.exception.DataNotFoundException;
import com.trongphu.ticketmovie.model.Booking;
import com.trongphu.ticketmovie.service.BookingService;
import com.trongphu.ticketmovie.config.ConfigVNPAY;
import com.trongphu.ticketmovie.util.EmailUtil;
import com.trongphu.ticketmovie.util.StatusBooking;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Trong Phu on 6/2/2024 22:48:15
 *
 * @author Trong Phu
 */
@RestController
@RequestMapping("${api.prefix}/payment")
@RequiredArgsConstructor
public class PaymentController {

private  final BookingService bookingService;
private final EmailUtil emailUtil;

/**
 * API tạo 1 giao dịch mới trả về đường dẫn đến trang thanh toán giao dịch*/
    @GetMapping("create-payment")
    public ResponseData createPayment(
           // HttpServletRequest req
            @PathParam("price") long price
           , @PathParam("id_booking") Long id_booking
    ) throws UnsupportedEncodingException {
        System.out.println(id_booking);
        System.out.println(price);
        String orderType = "other";
        long amount = price * 100;
        String bankCode = "NCB";
        String vnp_TxnRef = ConfigVNPAY.getRandomNumber(8);
        String vnp_IpAddr = "127.0.0.1";
//        185.207.236.10
        String vnp_TmnCode = ConfigVNPAY.vnp_TmnCode;
        Map<String, String> vnp_Params = new HashMap<>();
        vnp_Params.put("vnp_Version", ConfigVNPAY.vnp_Version);
        vnp_Params.put("vnp_Command", ConfigVNPAY.vnp_Command);
        vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
        vnp_Params.put("vnp_Amount", String.valueOf(amount));
        vnp_Params.put("vnp_CurrCode", "VND");
//        vnp_Params.put("vnp_BankCode", "");
        vnp_Params.put("vnp_Locale", "vn");
        vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
        vnp_Params.put("vnp_OrderInfo", "Thanh toan don hang:" + vnp_TxnRef);
        vnp_Params.put("vnp_OrderType", orderType);
        vnp_Params.put("vnp_IpAddr", vnp_IpAddr);
        vnp_Params.put("vnp_ReturnUrl", ConfigVNPAY.vnp_ReturnUrl + "?id_booking=" + id_booking);

        Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String vnp_CreateDate = formatter.format(cld.getTime());
        vnp_Params.put("vnp_CreateDate", vnp_CreateDate);

        cld.add(Calendar.MINUTE, 4);
        String vnp_ExpireDate = formatter.format(cld.getTime());
        vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);

        List fieldNames = new ArrayList(vnp_Params.keySet());
        Collections.sort(fieldNames);
        StringBuilder hashData = new StringBuilder();
        StringBuilder query = new StringBuilder();
        Iterator itr = fieldNames.iterator();
        while (itr.hasNext()) {
            String fieldName = (String) itr.next();
            String fieldValue = (String) vnp_Params.get(fieldName);
            if ((fieldValue != null) && (fieldValue.length() > 0)) {
                //Build hash data
                hashData.append(fieldName);
                hashData.append('=');
                hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                //Build query
                query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
                query.append('=');
                query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                if (itr.hasNext()) {
                    query.append('&');
                    hashData.append('&');
                }
            }
        }
        String queryUrl = query.toString();
        String vnp_SecureHash = ConfigVNPAY.hmacSHA512(ConfigVNPAY.secretKey, hashData.toString());
        queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
        String paymentUrl = ConfigVNPAY.vnp_PayUrl + "?" + queryUrl;
//            com.google.gson.JsonObject job = new JsonObject();
//            job.addProperty("code", "00");
//            job.addProperty("message", "success");
//            job.addProperty("data", paymentUrl);
//            Gson gson = new Gson();
//            resp.getWriter().write(gson.toJson(job));
        PaymentResDTO paymentResDTO = PaymentResDTO
                .builder()
                .status("OK")
                .message("Successfully!")
                .URL(paymentUrl)
                .build();
        return new ResponseData(HttpStatus.OK.value(), "Ok", paymentUrl);
    }
/**
 * http://localhost:8080/vnpay_jsp/vnpay_return.jsp
 * ?vnp_Amount=1000000
 * &vnp_BankCode=NCB
 * &vnp_BankTranNo=VNP14442184
 * &vnp_CardType=ATM
 * &vnp_OrderInfo=Thanh+toan+don+hang%3A33424064
 * &vnp_PayDate=20240603214412&vnp_ResponseCode=00
 * &vnp_TmnCode=4VAC8KP2
 * &vnp_TransactionNo=14442184&vnp_TransactionStatus=00
 * &vnp_TxnRef=33424064
 * &vnp_SecureHash=15e677934bd211e99ba1bc9584b5c239bae173a022cbeea4511ab65b7eb1b6e87c2d0c863d048635b6ed49b71563ccf1078512cb0b16ec3131d4ed30e41d697f
 * */


/**
 * API được gọi sau khi giao dịch được kết thúc
 * */
    @GetMapping("payment-callback")
    public ResponseData callback(
            @RequestParam Map<String, String> queryParams
            , HttpServletRequest resp
    ) throws DataNotFoundException {
        String vnp_ResponseCode = queryParams.get("vnp_ResponseCode");
        String id_booking = queryParams.get("id_booking");

        if(id_booking != null && !id_booking.isEmpty()){
            if("00".equals(vnp_ResponseCode)){
                //Giao dịch thành công
                Booking booking = bookingService.finById(Long.parseLong(id_booking)).orElseThrow(() -> new DataNotFoundException("Không tồn tại booking này!!"));
                booking.setStatus(StatusBooking.CONFIRMED);
                bookingService.save(booking);
                Map<String, Object> model = new HashMap<>();
                model.put("booking", booking);

                try {
                    emailUtil.sendPaymentConfirmationEmail((String) booking.getUser().getEmail(), "Xác nhận thanh toán", model);
                    //return "Email sent successfully";
                } catch (MessagingException e) {
                    e.printStackTrace();
                    //return "Failed to send email";
                }
                return new ResponseData(HttpStatus.OK.value(), "Thanh toán thành công!", BookingDTO.convertoBookingDTO(booking));
            }else {
                //Giao dịch thất bại
                return new ResponseError(HttpStatus.BAD_REQUEST.value(), "Thanh toán thất bại");
            }
        }
        return new ResponseError(HttpStatus.BAD_REQUEST.value(), "Dữ liệu đầu vào không hợp lệ!");
    }
}

