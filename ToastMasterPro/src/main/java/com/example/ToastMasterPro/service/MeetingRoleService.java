package com.example.ToastMasterPro.service;

import java.util.List;

import com.example.ToastMasterPro.model.MeetingRole;

public interface MeetingRoleService {

    public MeetingRole addRole(MeetingRole meetingRole);
    public List<MeetingRole> getAllRoles();
    public void deleteRole(int id);
    public MeetingRole updateRole(MeetingRole meetingRole);

}
