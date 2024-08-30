package com.example.ToastMasterPro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ToastMasterPro.model.MeetingRole;

@Repository
public interface MeetingRoleRepo extends JpaRepository<MeetingRole,Integer> {

}
