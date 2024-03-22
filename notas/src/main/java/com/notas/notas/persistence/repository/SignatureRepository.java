package com.notas.notas.persistence.repository;

import com.notas.notas.persistence.entity.Signature;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignatureRepository extends CrudRepository<Signature, Long> {
}
