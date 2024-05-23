package org.sopt.kakaopay.controller;

import org.sopt.kakaopay.controller.dto.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "합동 세미나 테스트 API 입니다!!";
    }

    @GetMapping("/test/json")
    public ApiResponse testJson() {
        return ApiResponse.create("합동 세미나 API - JSON");
    }
}
