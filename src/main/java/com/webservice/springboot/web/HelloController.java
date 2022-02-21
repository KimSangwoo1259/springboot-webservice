package com.webservice.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어줌 / @ResponseBody 를 각 메소드 마다 선언 할 필요가 없음
public class HelloController {

    @GetMapping("/hello") // HTTP의 Method 인 Get의 요청을 받을 수 있는 API를 생성해줌
    public String hello(){
        return "hello";
    }
}
