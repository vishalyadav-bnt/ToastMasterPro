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
import com.example.ToastMasterPro.Meeting.model.MeetingAttendance;
import com.example.ToastMasterPro.Meeting.model.MeetingAttendanceDTO;
import com.example.ToastMasterPro.Meeting.model.MeetingRoleSetupDto;
import com.example.ToastMasterPro.Meeting.model.RoleSetup;
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
    public ResponseEntity<Meeting> getMeetingById(@PathVariable("id") Long id) {
        Optional<Meeting> meeting = meetingService.getMeetingById(id);

        return meeting.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Meeting createMeeting(@RequestBody Meeting meeting) {

        return meetingService.createMeeting(meeting);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Meeting> updateMeeting(@PathVariable("id") Long id,@RequestBody Meeting meetingDetails) {
        Meeting updatedMeeting = meetingService.updateMeeting(id,meetingDetails);

        return updatedMeeting != null ? ResponseEntity.ok(updatedMeeting) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMeeting(@PathVariable("id") Long id) {

        meetingService.deleteMeeting(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/month")
    public List<Meeting> getAllMonthMeetings()
    {
        List<Meeting> listMeetings=meetingService.gettAllMonthMeeting();
        return listMeetings;
    }

    @PostMapping("/rolesetup")
    public void createRoleSetup(@RequestBody RoleSetup roleSetup)
    {
        meetingService.createRoleSetup(roleSetup);
    }

    @GetMapping("/rolesetup_details")
    public List<MeetingRoleSetupDto> fetchMeetingAndRoleSetupDetails()
    {
        return meetingService.fetchMeetingAndRoleSetupDetails();
    }


    @DeleteMapping("/rolesetup/{id}")
    public ResponseEntity<Void> deleteRoleCount(@PathVariable("id") Long id)
    {
        meetingService.deleteRoleCount(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/rolesetup/{id}")
    public ResponseEntity<RoleSetup> updateRoleCount(@PathVariable("id") Long id,@RequestBody RoleSetup roleSetup)
    {
        RoleSetup updateRoleSetp=meetingService.updateRoleCount(id,roleSetup);
        return ResponseEntity.ok(updateRoleSetp);
    }


    @PostMapping("/attendance")
    public ResponseEntity<MeetingAttendance>storeAttendance(@RequestBody MeetingAttendance meetingAttendance)
    {
        System.out.println(meetingAttendance);
        return ResponseEntity.ok(meetingService.storeAttendance(meetingAttendance));
    }


    @GetMapping("/{meetingId}/details")
    public List<MeetingAttendanceDTO> getMeetingDetails(@PathVariable Long meetingId) {
        List<MeetingAttendanceDTO> details = meetingService.getMeetingDetails(meetingId);
        return details;
    }

    @GetMapping("/month/{month}/{year}")
    public List<MeetingAttendanceDTO> getAttendanceByMonthAndYear(@PathVariable("month") int month,@PathVariable("year")int year) {
        
        return meetingService.getMeetingAttendanceByMonthAndYear(month,year);
    }

}
