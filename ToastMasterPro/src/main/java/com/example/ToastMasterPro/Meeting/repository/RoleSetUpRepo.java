package com.example.ToastMasterPro.Meeting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ToastMasterPro.Meeting.model.RoleSetup;

@Repository
public interface RoleSetUpRepo extends JpaRepository<RoleSetup,Long> {

}
