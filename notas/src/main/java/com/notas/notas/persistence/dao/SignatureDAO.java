package com.notas.notas.persistence.dao;

import com.notas.notas.persistence.entity.Signature;

import java.util.Optional;

public interface SignatureDAO {

    Signature createSignature(Signature signature);
    Optional<Signature> getSignature(Long id);
}
