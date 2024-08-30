package com.example.ToastMasterPro.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ToastMasterPro.model.MemberS;
@Repository
public interface MemberRepo extends JpaRepository<MemberS,Integer> {

}
