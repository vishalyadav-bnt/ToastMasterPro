package com.example.ToastMasterPro.role.service.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ToastMasterPro.role.model.MeetingRole;
import com.example.ToastMasterPro.role.model.RoleAllocation;
import com.example.ToastMasterPro.role.repository.MeetingRoleRepo;
import com.example.ToastMasterPro.role.repository.RoleAllocationRepo;
import com.example.ToastMasterPro.role.service.MeetingRoleService;

@Service
public class MeetingRoleServiceImpl implements MeetingRoleService {

    @Autowired
    private MeetingRoleRepo meetingRoleRepo;

    @Autowired
    private RoleAllocationRepo roleAllocationRepo;

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
    public MeetingRole updateRole(int id, MeetingRole meetingRole) {
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

    @Override
    public List<RoleAllocation> createRoleAllocation(List<RoleAllocation> roleAllocations) {
       return roleAllocationRepo.saveAll(roleAllocations);
    }

    @Override
    public List<Object[]> getRole(Long id) {
       return roleAllocationRepo.fetchMemberNameAndRole(id);
    }

    @Override
    public void deleteRoleAllocation(Long roleAssignmentID) {
       roleAllocationRepo.deleteById(roleAssignmentID);
    }

    @Override
    public RoleAllocation updateRoleAllocation(Long roleAssignmentId, Long memberID) {
       Optional<RoleAllocation> newRoleAllocation=roleAllocationRepo.findById(roleAssignmentId);
       if(!newRoleAllocation.isPresent())
       {
         return null;
       }
       RoleAllocation newRoleAllocationn=newRoleAllocation.get();
       newRoleAllocationn.setMemberID(memberID);
       roleAllocationRepo.save(newRoleAllocationn);
       return newRoleAllocationn;
    }

    @Override
    public String getMemberRole(Long meetingId, int memberID) {
        RoleAllocation member = roleAllocationRepo.findByMeetingIdAndMemberID(meetingId, memberID);
        return (member != null) ? member.getRole() : null;
    }

  
}
