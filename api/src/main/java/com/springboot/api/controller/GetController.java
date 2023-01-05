package com.springboot.api.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.api.dto.MemberDTO;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/v1/get-api")
@Log4j2
public class GetController {

    
    @GetMapping("/hello")
    @Operation(summary = "swagger hello",description = "시험중")
    public String getHello(){
        log.trace("trace_getHello가 출력되었습니다.");
        log.debug("debug_getHello가 출력되었습니다.");
        log.info("info_getHello가 출력되었습니다.");
        log.error("error_getHello가 출력되었습니다.");
        return "Hello World";
    }
    
    @GetMapping("/variable1/{var}")
    public String getVariable1(@PathVariable("var") String va1r){
        log.info("@Pathvariable value: " + va1r);
        return va1r;
    }

    @GetMapping("/request1")
    public String getRequestParam(
                        @RequestParam String name,
                        @RequestParam String email,
                        @RequestParam String organization){
        return name + " " + email + " " + organization;
    }

    @GetMapping("/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param){
        StringBuilder sb = new StringBuilder();

        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + ": " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    @GetMapping("/request3")
    public String getRequestParam3(MemberDTO memberDTO){
        return memberDTO.toString();
    }
}
