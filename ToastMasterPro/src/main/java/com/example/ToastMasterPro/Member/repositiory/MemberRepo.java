package com.example.ToastMasterPro.Member.repositiory;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ToastMasterPro.Member.model.MemberS;
@Repository
public interface MemberRepo extends JpaRepository<MemberS,Integer> {

}
