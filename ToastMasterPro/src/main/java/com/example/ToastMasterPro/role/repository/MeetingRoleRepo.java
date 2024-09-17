package com.example.ToastMasterPro.role.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ToastMasterPro.role.model.MeetingRole;

@Repository
public interface MeetingRoleRepo extends JpaRepository<MeetingRole,Integer> {

}
