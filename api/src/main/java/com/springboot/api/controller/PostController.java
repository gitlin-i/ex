package com.springboot.api.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.api.dto.MemberDTO;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {
    
    @PostMapping("/domain")
    public String postExample(){
        return "Hello post API";
    }

    @PostMapping("/member")
    public String postMember(@RequestBody Map<String, Object> postData){
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map -> {
            sb.append(map.getKey() + ": " + map.getValue()+"\n");
        });

        return sb.toString();
    }

    @PostMapping("/member2")
    public String postMemberDTO(@RequestBody MemberDTO memberDTO){
        return memberDTO.toString();
    }
}
