package com.trongphu.ticketmovie.controller.user;

import com.trongphu.ticketmovie.util.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Trong Phu on 6/5/2024 14:45:34
 *
 * @author Trong Phu
 */
@RestController
public class EmailController {
    @Autowired
    private EmailUtil emailService;

    @GetMapping("/sendEmail")
    public String sendEmail(
            @RequestParam String to
            , @RequestParam String subject
            , @RequestParam String text) {
        emailService.sendBookingEmail(to, subject, text);
        return "Email sent successfully";
    }
}
