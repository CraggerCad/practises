package com.progressive.htmlescape.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

@RestController
public class CokkieDemo {

    @GetMapping("/setCookie")
    public String setCookie(HttpServletResponse response){
        Cookie cookie = new Cookie("name", "kappa123");
        cookie.setHttpOnly(true);
//        cookie.setSecure(true);
        response.addCookie(cookie);
        return "cookie added";
    }

    @GetMapping("/getCookie")
    public String getCookie(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        Arrays.stream(cookies).forEach(cookie -> {
            System.out.println(cookie.getName()+" "+cookie.getValue());
        });
        return cookies[0].getName()+" "+cookies[0].getValue();
    }
}
