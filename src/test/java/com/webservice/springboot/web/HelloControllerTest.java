package com.webservice.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@RunWith(SpringRunner.class) // 테스트 진행시에 JUnit에 내장된 실행자 외에 다른 실행자를 실행 시킴 -> 스프링부트 테스트와 JUnit 사이의 연결자 역할
@WebMvcTest(controllers = HelloController.class) // Web에 집중할 수있는 어노테이션 @service, @Component 등은 사용 불가
public class HelloControllerTest {

    @Autowired // Bean 주입
    private MockMvc mvc; // 웹 API를 테스트할 때 사용 / HTTP GET, POST 등에 대한 API테스트를 할 수 있음

    @Test
    public void hello_리턴() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")) // MockMvc를 통해 /hello 주소로 HTTP GET 요청
                .andExpect(status().isOk()) // mvc.perform 결과 검증, HTTP Header 의 Status를 검증(200인지 아닌지)
                .andExpect(content().string(hello)); //리턴 값이 헬로인지 검증
    }
    @Test
    public void helloDTO_리턴() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name",name) // API테스트 시 사용될 요청 파라미터를 설정, String 만 허용이므로 다른 타입의 데이터는 변환해야함
                        .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is(name))) //jsonPath : JSON 응답 값을 필드별로 검증할수 있는 메소드, $를 기준으로 필드명을 명시
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
