package com.queue.hospital.QueueHospital.adapters.rest.controller;

import com.queue.hospital.QueueHospital.usecases.SendInfoQueueHospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserControler {

    @Autowired
    SendInfoQueueHospital sendInfoQueueHospital;
    @PostMapping
    public String storeUser(@RequestBody String body){
        System.out.print("request user post " + body);
        sendInfoQueueHospital.send(body);
        return "111";
    }

}
