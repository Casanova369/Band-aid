package br.com.csi.ufsm.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserControl {
    
    @GetMapping("/welcome")
    public String hello() {
        return "Hello World!";
    }
    
    @GetMapping("/private")
    public String locked() {
        return "Locked Endpoint";
    }
    
}
