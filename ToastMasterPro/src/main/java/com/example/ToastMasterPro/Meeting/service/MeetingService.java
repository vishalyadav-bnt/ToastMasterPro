package com.example.ToastMasterPro.Meeting.service;

import java.util.List;
import java.util.Optional;

import com.example.ToastMasterPro.Meeting.model.Meeting;

public interface MeetingService {
    List<Meeting> getAllMeetings();
    Optional<Meeting> getMeetingById(Long meetingId);
    Meeting createMeeting(Meeting meeting);
    Meeting updateMeeting(Long id,Meeting meetingDetails);
    void deleteMeeting(Long meetingId);

}
