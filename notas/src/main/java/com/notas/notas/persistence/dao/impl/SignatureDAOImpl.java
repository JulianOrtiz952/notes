package com.notas.notas.persistence.dao.impl;

import com.notas.notas.persistence.dao.SignatureDAO;
import com.notas.notas.persistence.entity.Signature;
import com.notas.notas.persistence.repository.SignatureRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class SignatureDAOImpl implements SignatureDAO {

    @Autowired
    private SignatureRepository signatureRepository;

    @Override
    public Signature createSignature(Signature signature) {
        return signatureRepository.save(signature);
    }

    @Override
    public Optional<Signature> getSignature(Long id) {
        return signatureRepository.findById(id);
    }
}
