package com.example.ToastMasterPro.role.service;

import java.util.List;

import com.example.ToastMasterPro.role.model.MeetingRole;
import com.example.ToastMasterPro.role.model.RoleAllocation;

public interface MeetingRoleService {

    public MeetingRole addRole(MeetingRole meetingRole);
    public List<MeetingRole> getAllRoles();
    public void deleteRole(int id);
    public MeetingRole updateRole(int id,MeetingRole meetingRole);
    public List<RoleAllocation> createRoleAllocation(List<RoleAllocation> roleAllocations);
    public List<Object[]>getRole(Long Id);
    public void deleteRoleAllocation(Long roleAssignmentID);
    public RoleAllocation updateRoleAllocation(Long roleAssignmentId,Long memberID);
    public String getMemberRole(Long meetingId,int memberID);

}
