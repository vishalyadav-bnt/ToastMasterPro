package com.example.ToastMasterPro.Meeting.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.ToastMasterPro.Meeting.model.Meeting;
import com.example.ToastMasterPro.Meeting.service.MeetingService;

@RestController
@RequestMapping("/api/meeting")
@CrossOrigin(origins ="http://localhost:3000")
public class MeetingController {
    @Autowired
    private MeetingService meetingService;

    @GetMapping
    public List<Meeting> getAllMeetings() {
        return meetingService.getAllMeetings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Meeting> getMeetingById(@PathVariable Long id) {
        Optional<Meeting> meeting = meetingService.getMeetingById(id);

        return meeting.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Meeting createMeeting(@RequestBody Meeting meeting) {
        System.out.println(meeting.getEndTime());
        return meetingService.createMeeting(meeting);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Meeting> updateMeeting(@PathVariable Long id,@RequestBody Meeting meetingDetails) {
        Meeting updatedMeeting = meetingService.updateMeeting(id,meetingDetails);

        return updatedMeeting != null ? ResponseEntity.ok(updatedMeeting) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMeeting(@PathVariable Long id) {
        meetingService.deleteMeeting(id);
        return ResponseEntity.noContent().build();
    }

}
