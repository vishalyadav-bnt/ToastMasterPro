package com.example.ToastMasterPro.Meeting.service.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ToastMasterPro.Meeting.model.Meeting;
import com.example.ToastMasterPro.Meeting.repository.MeetingRepository;
import com.example.ToastMasterPro.Meeting.service.MeetingService;

@Service
public class MeetingServiceImpl implements MeetingService {
    @Autowired
    private MeetingRepository meetingRepository;

    @Override
    public List<Meeting> getAllMeetings() {
        return meetingRepository.findAll();
    }

    @Override
    public Optional<Meeting> getMeetingById(Long meetingId) {
        return meetingRepository.findById(meetingId);
    }

    @Override
    public Meeting createMeeting(Meeting meeting) {
        return meetingRepository.save(meeting);
    }

    @Override
    public Meeting updateMeeting(Long id,Meeting meetingDetails) {
        Optional<Meeting> optionalMeeting = meetingRepository.findById(id);

        if (optionalMeeting.isPresent()) {
            Meeting meeting = optionalMeeting.get();
            meeting.setMeetingDate(meetingDetails.getMeetingDate());
            meeting.setStartTime(meetingDetails.getStartTime());
            meeting.setEndTime(meetingDetails.getEndTime());
            meeting.setLocation(meetingDetails.getLocation());
            meeting.setTheme(meetingDetails.getTheme());
            return meetingRepository.save(meeting);
        }

        return null; // Handle this case appropriately
    }

    @Override
    public void deleteMeeting(Long meetingId) {
        meetingRepository.deleteById(meetingId);
    }

}
