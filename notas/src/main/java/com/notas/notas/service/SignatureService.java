package com.notas.notas.service;

import com.notas.notas.controller.dto.SignatureDTO;
import com.notas.notas.persistence.entity.Signature;
import com.notas.notas.persistence.entity.Student;
import com.notas.notas.persistence.repository.SignatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SignatureService {

    @Autowired
    private SignatureRepository signatureRepository;

    public Signature postSignature(SignatureDTO signatureDTO){
        if(signatureDTO.getSignature().isBlank()) throw new RuntimeException("");
        return signatureRepository.save(Signature.builder().id(signatureDTO.getId()).signature(signatureDTO.getSignature()).build());
    }

    public Signature getSignatureById(Long id){
        return signatureRepository.findById(id).orElseThrow();
    }

    public List<Student> getAllStudentBySignature(Long id){
        Optional<Signature> signature = signatureRepository.findById(id);
        return signature.get().getStudentList();
    }

    public double average(Long id){
        List<Student> studentList = signatureRepository.findById(id).get().getStudentList();
        double sum = studentList.stream().mapToDouble(Student::getValue).sum();
        return sum/ studentList.size();
    }

    public List<Student> sort(Long id){
        List<Student> studentList = signatureRepository.findById(id).get().getStudentList();
        return studentList.stream().sorted(Comparator.comparingDouble(Student::getValue)).collect(Collectors.toList());
    }

    public String getMaxMin(Long id){
        List<Student> studentList = sort(id);
        String min = "name: " + studentList.get(0).getName() + " value: " + studentList.get(0).getValue();
        String max = "name: " + studentList.get(studentList.size()-1).getName() + " value: " + studentList.get(studentList.size()-1).getValue();
        return "student with min value, " + min + " and max value, " + max;
    }

    public short getTotalStudent(Long id, double value){
        List<Student> studentList = sort(id);
        return (short) studentList.stream().filter(student -> student.getValue()>=value).count();
    }

    public short getSupAverageStudent(Long id){
        double average = average(id);
        return getTotalStudent(id, average);
    }

    public double getPercentAprob(Long id){
        double aprob = getTotalStudent(id, 6);
        if(signatureRepository.findById(id).isEmpty()) throw new RuntimeException("signature isn't exist");
        List<Student> studentList = signatureRepository.findById(id).get().getStudentList();
        return aprob/studentList.size()*100;
    }

}
