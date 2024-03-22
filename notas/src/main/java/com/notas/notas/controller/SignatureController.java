package com.notas.notas.controller;

import com.notas.notas.controller.dto.SignatureDTO;
import com.notas.notas.persistence.entity.Signature;
import com.notas.notas.service.SignatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/signature")
public class SignatureController {

    @Autowired
    private SignatureService signatureService;

    @PostMapping
    public ResponseEntity<?> postSignature(@RequestBody SignatureDTO signatureDTO){ return ResponseEntity.ok(signatureService.postSignature(signatureDTO));}

    @GetMapping("/{id}")
    public ResponseEntity<?> getSignatureById(@PathVariable Long id){ return  ResponseEntity.ok(signatureService.getSignatureById(id));}


    @GetMapping("/students/{id}")
    public ResponseEntity<?> getStudentsById(@PathVariable Long id){ return ResponseEntity.ok(signatureService.getAllStudentBySignature(id));}

    @GetMapping("/average/{id}")
    public ResponseEntity<?> getAverage(@PathVariable Long id){ return ResponseEntity.ok(signatureService.average(id));}

    @GetMapping("/sort/{id}")
    public ResponseEntity<?> getSortedNotesStudent(@PathVariable Long id){ return ResponseEntity.ok(signatureService.sort(id));}

    @GetMapping("/minmax/{id}")
    public ResponseEntity<?> getMaxAndMinValue(@PathVariable Long id){ return  ResponseEntity.ok(signatureService.getMaxMin(id));}

    @GetMapping("gettotalstudents/{id}")
    public ResponseEntity<?> getTotalStudentsByValue(@PathVariable Long id, @RequestBody double value){ return ResponseEntity.ok(signatureService.getTotalStudent(id, value));}

    @GetMapping("getstudentsaverage/{id}")
    public ResponseEntity<?> getTotalStudentsSupAverage(@PathVariable Long id){ return ResponseEntity.ok(signatureService.getSupAverageStudent(id));}

    @GetMapping("getpercent/{id}")
    public ResponseEntity<?> getPercentStudentsAprob(@PathVariable Long id){ return ResponseEntity.ok(signatureService.getPercentAprob(id));}
}

