package com.example.ToastMasterPro.Meeting.service;

import java.util.List;
import java.util.Optional;

import com.example.ToastMasterPro.Meeting.model.Meeting;
import com.example.ToastMasterPro.Meeting.model.MeetingAttendance;
import com.example.ToastMasterPro.Meeting.model.MeetingAttendanceDTO;
import com.example.ToastMasterPro.Meeting.model.MeetingRoleSetupDto;
import com.example.ToastMasterPro.Meeting.model.RoleSetup;

public interface MeetingService {
    List<Meeting> getAllMeetings();
    Optional<Meeting> getMeetingById(Long meetingId);
    Meeting createMeeting(Meeting meeting);
    Meeting updateMeeting(Long id,Meeting meetingDetails);
    void deleteMeeting(Long meetingId);
    public List<Meeting>gettAllMonthMeeting();
    public void createRoleSetup(RoleSetup roleSetup);
    public List<MeetingRoleSetupDto> fetchMeetingAndRoleSetupDetails();
    public void deleteRoleCount(Long id);
    public RoleSetup updateRoleCount(Long id,RoleSetup roleSetup);
    public MeetingAttendance storeAttendance(MeetingAttendance meetingAttendance);
    public List<MeetingAttendanceDTO>getMeetingDetails(Long meetingId);
    public List<MeetingAttendanceDTO>getMeetingAttendanceByMonthAndYear(int month,int year);
    
}
