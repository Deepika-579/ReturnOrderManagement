package com.returnorder.portal.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.returnorder.portal.model.ProcessRequest;

@Repository
public interface ProcessRequestRepo extends JpaRepository<ProcessRequest, String> {

}
