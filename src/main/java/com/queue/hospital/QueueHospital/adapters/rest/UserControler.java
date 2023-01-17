package com.queue.hospital.QueueHospital.adapters.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserControler {

    @PostMapping
    public String storeUser(String body){
        return "111";
    }

}
