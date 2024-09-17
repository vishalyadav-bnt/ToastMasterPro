package com.example.ToastMasterPro.Member.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.example.ToastMasterPro.Member.model.Attendance;
import com.example.ToastMasterPro.Member.model.AttendanceUserDTO;
import com.example.ToastMasterPro.Member.model.MemberS;
import com.example.ToastMasterPro.Member.service.MemberService;
import com.example.ToastMasterPro.response.MemberResponse;

@RestController
@RequestMapping("/api/member")
@CrossOrigin(origins ="http://localhost:3000")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping
    public ResponseEntity<MemberResponse> createMember(@RequestBody MemberS member) {
        MemberS newMember = memberService.createMember(member);
        return ResponseEntity.ok(new MemberResponse(newMember, "Member Added Successfully", HttpStatus.OK.value()));
    }

    @GetMapping
    public ResponseEntity<List<MemberS>> getAllMembers() {
        List<MemberS> members = memberService.getAllMembers();
        return ResponseEntity.ok(members);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberResponse> getMemberById(@PathVariable("id") int id) {
        Optional<MemberS> memberOpt = memberService.getMemberById(id);
        return memberOpt
                .map(member -> ResponseEntity.ok(new MemberResponse(member, "Member Found", HttpStatus.OK.value())))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new MemberResponse(null, "Member Not Found", HttpStatus.NOT_FOUND.value())));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberResponse> updateMember(@PathVariable("id") int id, @RequestBody MemberS memberDetails) {
        Optional<MemberS> memberOpt = memberService.updateMember(id, memberDetails);
        return memberOpt
                .map(member -> ResponseEntity
                        .ok(new MemberResponse(member, "Member Updated Successfully", HttpStatus.OK.value())))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new MemberResponse(null, "Member Not Found", HttpStatus.NOT_FOUND.value())));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MemberResponse> deleteMember(@PathVariable("id") int id) {
        boolean isDeleted = memberService.deleteMember(id);
        return isDeleted
                ? ResponseEntity.ok(new MemberResponse(null, "Member Deleted Successfully", HttpStatus.OK.value()))
                : ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new MemberResponse(null, "Member Not Found", HttpStatus.NOT_FOUND.value()));
    }


    @PostMapping("/attendance")
    public ResponseEntity<Attendance> trackAttendance(@RequestBody Attendance attendance)
    {
        Attendance attendanceUpdated=memberService.trackAttendance(attendance);
        return ResponseEntity.ok(attendanceUpdated);
    }

    @GetMapping("/attendance")
    public List<AttendanceUserDTO>findAvailablityWithUserDetails()
    {
        return memberService.findAvailablityWithUserDetails();
    }
}
