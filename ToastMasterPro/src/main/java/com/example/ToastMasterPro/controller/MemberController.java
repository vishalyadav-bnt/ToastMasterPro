package com.example.ToastMasterPro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ToastMasterPro.model.MemberS;
import com.example.ToastMasterPro.response.MemberResponse;
import com.example.ToastMasterPro.service.MemberService;

@RestController
@RequestMapping("/api/member")
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
    public ResponseEntity<MemberResponse> getMemberById(@PathVariable int id) {
        Optional<MemberS> memberOpt = memberService.getMemberById(id);
        return memberOpt
                .map(member -> ResponseEntity.ok(new MemberResponse(member, "Member Found", HttpStatus.OK.value())))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new MemberResponse(null, "Member Not Found", HttpStatus.NOT_FOUND.value())));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberResponse> updateMember(@PathVariable int id, @RequestBody MemberS memberDetails) {
        Optional<MemberS> memberOpt = memberService.updateMember(id, memberDetails);
        return memberOpt
                .map(member -> ResponseEntity
                        .ok(new MemberResponse(member, "Member Updated Successfully", HttpStatus.OK.value())))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new MemberResponse(null, "Member Not Found", HttpStatus.NOT_FOUND.value())));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MemberResponse> deleteMember(@PathVariable int id) {
        boolean isDeleted = memberService.deleteMember(id);
        return isDeleted
                ? ResponseEntity.ok(new MemberResponse(null, "Member Deleted Successfully", HttpStatus.OK.value()))
                : ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new MemberResponse(null, "Member Not Found", HttpStatus.NOT_FOUND.value()));
    }
}
