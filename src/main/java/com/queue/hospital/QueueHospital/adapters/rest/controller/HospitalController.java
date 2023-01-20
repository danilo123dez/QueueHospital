package com.queue.hospital.QueueHospital.adapters.rest.controller;

import com.queue.hospital.QueueHospital.adapters.rest.dto.DetalhesHospitalDTO;
import com.queue.hospital.QueueHospital.adapters.rest.dto.HospitalDTO;
import com.queue.hospital.QueueHospital.adapters.rest.handler.ErrorMessage;
import com.queue.hospital.QueueHospital.adapters.rest.request.HospitalRequest;
import com.queue.hospital.QueueHospital.domain.entity.Hospital;
import com.queue.hospital.QueueHospital.domain.repository.HospitalRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("queue-hospital")
public class HospitalController {

    @Autowired
    HospitalRepository hospitalRepository;
    @Autowired
    EntityManager entityManager;


    @GetMapping("/near")
    public String nearHospital(){
        return "lista de hospital";
    }

    @GetMapping("/all")
    public ResponseEntity<List<HospitalDTO>> allHospital(){
        List<Hospital> hospitais = hospitalRepository.findAll();
        return ResponseEntity.ok(HospitalDTO.convert(hospitais));
    }
    @GetMapping("/{hospital}")
    public ResponseEntity<?> speciftHospital(@PathVariable Long hospital){
        Optional<Hospital> hosp = hospitalRepository.findById(hospital);
        if(!hosp.isPresent()){
            List<String> erro = new ArrayList<>();
            erro.add("Hospital informado não existe no banco.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMessage(erro));
        }
        return ResponseEntity.ok(new DetalhesHospitalDTO(hosp.get()));
    }
    @PostMapping
    @Transactional
    public ResponseEntity<HospitalDTO> createHospital(@RequestBody @Valid HospitalRequest request){
        Hospital hospital = request.get();
        entityManager.persist(hospital);
        return ResponseEntity.status(HttpStatus.CREATED).body(new HospitalDTO(hospital));
    }
    @DeleteMapping("/{hospital}")
    @Transactional
    public ResponseEntity<?> deleteHospital(@PathVariable Long hospital){
        Optional<Hospital> hosp = hospitalRepository.findById(hospital);
        if(!hosp.isPresent()){
            List<String> erro = new ArrayList<>();
            erro.add("Hospital informado não existe no banco.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMessage(erro));
        }
        hospitalRepository.deleteById(hospital);
        return ResponseEntity.ok("Hospital deletado com sucesso!");
    }
    @PatchMapping("/{hospital}")
    @Transactional
    public ResponseEntity<HospitalDTO> updateHospital(@PathVariable Long hospital, @RequestBody @Valid HospitalRequest request){
        Hospital hosp = entityManager.find(Hospital.class, hospital);
        hosp.update(request.get());
        return ResponseEntity.ok().body(new HospitalDTO(hosp));
    }
}
