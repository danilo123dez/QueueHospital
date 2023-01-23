package com.queue.hospital.QueueHospital.adapters.rest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.queue.hospital.QueueHospital.adapters.rest.dto.DetalhesHospitalDTO;
import com.queue.hospital.QueueHospital.adapters.rest.dto.HospitalDTO;
import com.queue.hospital.QueueHospital.adapters.rest.handler.ErrorMessage;
import com.queue.hospital.QueueHospital.adapters.rest.request.HospitalRequest;
import com.queue.hospital.QueueHospital.domain.entity.Hospital;
import com.queue.hospital.QueueHospital.domain.entity.RedisEntity;
import com.queue.hospital.QueueHospital.domain.repository.HospitalRepository;
import com.queue.hospital.QueueHospital.domain.repository.RedisRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("hospital")
public class HospitalController {

    @Autowired
    HospitalRepository hospitalRepository;
    @Autowired
    EntityManager entityManager;
    
    @Autowired
	private RedisRepository redisRepository;


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
    
    @GetMapping("/queue")
    public List<RedisEntity> selectAll() {
    	return redisRepository.findAll();
    }
    
    @GetMapping("/queue/{hospital}")
    public Optional<RedisEntity> selectSelecionado(@PathVariable String hospital) {
    	return redisRepository.findById(hospital);
    }
}
