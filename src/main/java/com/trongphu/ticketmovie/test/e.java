package com.trongphu.ticketmovie.test;
import java.net.InetAddress;
import java.net.UnknownHostException;
/**
 * Created by Trong Phu on 6/2/2024 23:32:44
 *
 * @author Trong Phu
 */


public class e {
    public static void main(String[] args) {
        try {
            // Nhập tên miền của trang web bạn muốn lấy địa chỉ IP
            String domain = "vi.xhamster19.com";

            // Lấy đối tượng InetAddress từ tên miền
            InetAddress inetAddress = InetAddress.getByName(domain);

            // Lấy địa chỉ IP dưới dạng chuỗi
            String ipAddress = inetAddress.getHostAddress();

            // In địa chỉ IP ra màn hình
            System.out.println("IP Address of " + domain + ": " + ipAddress);


        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}

