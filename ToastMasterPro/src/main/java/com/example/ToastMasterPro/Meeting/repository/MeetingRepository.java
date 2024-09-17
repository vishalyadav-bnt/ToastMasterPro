package com.example.ToastMasterPro.Meeting.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ToastMasterPro.Meeting.model.Meeting;
import com.example.ToastMasterPro.Meeting.model.MeetingRoleSetupDto;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Long> {

     @Query("SELECT m FROM Meeting m WHERE m.meetingDate BETWEEN :startDate AND :endDate")
     List<Meeting> findMeetingsInMonth(@Param("startDate") String startDate, @Param("endDate") String endDate);

@Query("SELECT new com.example.ToastMasterPro.Meeting.model.MeetingRoleSetupDto(" +
       "m.meetingId, m.startTime, m.endTime, m.location, m.meetingDate, m.theme, " +
       "rs.id, rs.evaluatorCount, rs.roleCount, rs.speakerCount,rs.roles) " +
       "FROM Meeting m JOIN m.roleSetup rs")
List<MeetingRoleSetupDto> fetchMeetingAndRoleSetupDetails();






}
