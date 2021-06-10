package com.returnorder.portal.repo;

import com.returnorder.portal.model.ProcessResponse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProcessResponseRepo extends JpaRepository<ProcessResponse, String> {
    
}
