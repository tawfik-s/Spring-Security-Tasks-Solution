package com.shalash.task8;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@Slf4j
public class HelloController {


    @GetMapping("/")
    public String hello() {
        return "index.html";
    }


    @PostMapping("/ts")
    public String checkCanDoPost(){
        log.info("checkCanDoPost called");
        return "index.html";
    }


}
