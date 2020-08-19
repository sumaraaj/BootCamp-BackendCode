package com.capgemini.placeanorder.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.placeanorder.entity.CustomerInfo;
@Repository
public interface CustomerDao extends JpaRepository<CustomerInfo, Integer>{

}
