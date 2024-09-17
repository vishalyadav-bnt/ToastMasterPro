package com.example.ToastMasterPro.Meeting.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ToastMasterPro.Meeting.model.MeetingAttendance;
import com.example.ToastMasterPro.Meeting.model.MeetingAttendanceDTO;

public interface AttendanceRepository extends JpaRepository<MeetingAttendance, Long> {
    @Query("SELECT new com.example.ToastMasterPro.Meeting.model.MeetingAttendanceDTO(m.theme,m.meetingDate,mem.firstName, ma.status) "
            +
            "FROM Meeting m " +
            "JOIN MeetingAttendance ma ON m.meetingId = ma.meeting.meetingId " +
            "JOIN MemberS mem ON ma.member.memberID = mem.memberID " +
            "WHERE m.meetingId = :meetingId")
    List<MeetingAttendanceDTO> findMeetingAttendanceByMeetingId(@Param("meetingId") Long meetingId);

    @Query("SELECT new com.example.ToastMasterPro.Meeting.model.MeetingAttendanceDTO(m.theme,m.meetingDate,mem.firstName, ma.status) "
       + "FROM Meeting m "
       + "JOIN MeetingAttendance ma ON m.meetingId = ma.meeting.meetingId "  // Specify the join condition
       + "JOIN MemberS mem ON ma.member.memberID = mem.memberID "  // Specify the join condition
       + "WHERE ma.date BETWEEN :startDate AND :endDate")
List<MeetingAttendanceDTO> findMeetingAttendanceByDateRange(
    @Param("startDate") String startDate,
    @Param("endDate") String endDate);


}
