package com.odtech.test.repository;

import com.odtech.test.entity.Identification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IdentificationRepository extends JpaRepository<Identification, Identification> {

    @Query("select id from Identification where id_type = :idType and id_number = :idNumber")
    Long findById(String idType, String idNumber);
}
