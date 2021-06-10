package com.returnorder.portal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.returnorder.portal.model.LoginModel;

@Repository
public interface LoginRepo extends JpaRepository<LoginModel, String> {

}
