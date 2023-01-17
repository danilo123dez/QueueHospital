package com.queue.hospital.QueueHospital.adapters.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/queue-hospital")
public class HospitalController {

    @GetMapping("/near")
    public String nearHospital(){
        return "lista de hospital";
    }

    @GetMapping("/{hospital}")
    public String speciftHospital(@PathVariable int hospital){
        return "hospital: " + hospital;
    }

}
