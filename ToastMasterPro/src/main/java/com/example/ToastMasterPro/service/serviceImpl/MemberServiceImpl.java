package com.example.ToastMasterPro.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ToastMasterPro.model.MemberS;
import com.example.ToastMasterPro.repository.MemberRepo;
import com.example.ToastMasterPro.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepo memberRepository;

    // Create a new member
    public MemberS createMember(MemberS member) {
        return memberRepository.save(member);
    }

    // Get all members
    public List<MemberS> getAllMembers() {
        return memberRepository.findAll();
    }

    // Get a member by ID
    public Optional<MemberS> getMemberById(int id) {
        return memberRepository.findById(id);
    }

    // Update a member
    public Optional<MemberS> updateMember(int id, MemberS memberDetails) {
        return memberRepository.findById(id).map(member -> {
            member.setFirstName(memberDetails.getFirstName());
            member.setLastName(memberDetails.getLastName());
            member.setEmail(memberDetails.getEmail());
            member.setPhone(memberDetails.getPhone());
            return memberRepository.save(member);
        });
    }

    // Delete a member
    public boolean deleteMember(int id) {
        return memberRepository.findById(id).map(member -> {
            memberRepository.delete(member);
            return true;
        }).orElse(false);
    }
}
