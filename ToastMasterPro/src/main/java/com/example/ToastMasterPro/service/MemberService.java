package com.example.ToastMasterPro.service;

import java.util.List;
import java.util.Optional;


import com.example.ToastMasterPro.model.MemberS;

public interface MemberService {

    public MemberS createMember(MemberS member);
    List<MemberS> getAllMembers();
    Optional<MemberS> getMemberById(int id);
    Optional<MemberS> updateMember(int id, MemberS memberDetails);
    boolean deleteMember(int id);

}
