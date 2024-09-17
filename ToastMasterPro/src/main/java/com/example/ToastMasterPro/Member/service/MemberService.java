package com.example.ToastMasterPro.Member.service;

import java.util.List;
import java.util.Optional;

import com.example.ToastMasterPro.Member.model.Attendance;
import com.example.ToastMasterPro.Member.model.AttendanceUserDTO;
import com.example.ToastMasterPro.Member.model.MemberS;

public interface MemberService {

    public MemberS createMember(MemberS member);
    List<MemberS> getAllMembers();
    Optional<MemberS> getMemberById(int id);
    Optional<MemberS> updateMember(int id, MemberS memberDetails);
    boolean deleteMember(int id);
    public Attendance trackAttendance(Attendance attendance);
    public List<AttendanceUserDTO>findAvailablityWithUserDetails();

}
