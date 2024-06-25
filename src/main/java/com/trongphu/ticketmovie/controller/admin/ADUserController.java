package com.trongphu.ticketmovie.controller.admin;

import com.trongphu.ticketmovie.dto.respone.ResponseData;
import com.trongphu.ticketmovie.dto.respone.ResponsePageData;
import com.trongphu.ticketmovie.model.User;
import com.trongphu.ticketmovie.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Trong Phu on 6/25/2024 10:34:11
 *
 * @author Trong Phu
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("${api.prefix}/admin/user")
public class ADUserController {

    private final UserService userService;

    @RequestMapping("get-page")
    public ResponseEntity<ResponseData> getPagetUser(
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "0") int page
    ){
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
        Page<User> userPage = userService.findPageAllUser(pageable);
        return new ResponseEntity<>(new ResponsePageData(HttpStatus.OK.value(), String.format("Get user page = %s size =%s", page, size), userPage.getContent(), userPage.getTotalPages()), HttpStatus.OK);
    }



}
