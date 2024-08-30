package com.example.ToastMasterPro.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ToastMasterPro.model.MeetingRole;
import com.example.ToastMasterPro.repository.MeetingRoleRepo;
import com.example.ToastMasterPro.service.MeetingRoleService;

@Service
public class MeetingRoleServiceImpl implements MeetingRoleService {

    @Autowired
    private MeetingRoleRepo meetingRoleRepo;

    @Override
    public MeetingRole addRole(MeetingRole meetingRole) {
        if (meetingRole == null) {
            System.out.println("Error");
        }
        MeetingRole newMeetingRole = meetingRoleRepo.save(meetingRole);
        return newMeetingRole;
    }

    @Override
    public List<MeetingRole> getAllRoles() {
        List<MeetingRole> allMeetingRoles = meetingRoleRepo.findAll();
        return allMeetingRoles;
    }

    @Override
    public void deleteRole(int id) {
        meetingRoleRepo.deleteById(id);
    }

    @Override
    public MeetingRole updateRole(MeetingRole meetingRole) {
        int id = meetingRole.getRoleId();
        Optional<MeetingRole> roleOptional = meetingRoleRepo.findById(id);
        if (roleOptional.isPresent()) {
            MeetingRole newMeetingRole = roleOptional.get();
            newMeetingRole.setRoleName(meetingRole.getRoleName());
            newMeetingRole.setDescription(meetingRole.getDescription());
            MeetingRole updatedRole = meetingRoleRepo.save(newMeetingRole);
            return updatedRole;
        } else {
            return null;
        }

    }
}
