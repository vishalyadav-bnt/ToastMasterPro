package com.example.ToastMasterPro.role.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ToastMasterPro.role.model.RoleAllocation;

public interface RoleAllocationRepo extends JpaRepository<RoleAllocation,Long>{
    @Query("SELECT m.firstName,m.email,r.roleAssignmentID,r.role,r.memberID " +
    "FROM MemberS m " +
    "JOIN RoleAllocation r ON m.memberID = r.memberID " +
    "WHERE r.meetingId = :meetingId")
    List<Object[]> fetchMemberNameAndRole(@Param("meetingId") Long meetingId);

    RoleAllocation findByMeetingIdAndMemberID(Long meetingId, int memberID);

}
