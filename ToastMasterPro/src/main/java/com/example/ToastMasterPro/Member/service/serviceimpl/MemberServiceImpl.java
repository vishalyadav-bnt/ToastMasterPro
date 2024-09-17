package com.example.ToastMasterPro.Member.service.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ToastMasterPro.Member.model.Attendance;
import com.example.ToastMasterPro.Member.model.AttendanceUserDTO;
import com.example.ToastMasterPro.Member.model.MemberS;
import com.example.ToastMasterPro.Member.repositiory.AttendanceRepo;
import com.example.ToastMasterPro.Member.repositiory.MemberRepo;
import com.example.ToastMasterPro.Member.service.MemberService;
import com.example.ToastMasterPro.Security.model.User;
import com.example.ToastMasterPro.Security.repository.UserRepository;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepo memberRepository;

    @Autowired
    AttendanceRepo attendanceRepo;

    @Autowired
    private UserRepository userRepository;

    // @Autowired
    // private EmailService emailService;

    public MemberS createMember(MemberS member) {
        MemberS savedMember = memberRepository.save(member);
        User user = User.builder()
                .id(savedMember.getMemberID())
                .username(savedMember.getEmail())
                .name(savedMember.getFirstName())
                .password(savedMember.getPhone())
                .role("member")
                .build();
        userRepository.save(user);

        // emailService.sendEmail(savedMember.getEmail(), user.getUsername(), user.getPassword(), "Welcome to the system",
        //         "Your account has been created successfully.");
        return savedMember;

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
            // member.setLastName(memberDetails.getLastName());
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

    @Override
    public Attendance trackAttendance(Attendance attendance) {
        return attendanceRepo.save(attendance);
    }

    @Override
    public List<AttendanceUserDTO> findAvailablityWithUserDetails() {
        return attendanceRepo.findAvailablityWithUserDetails();
    }
}
