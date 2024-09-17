package com.example.ToastMasterPro.role.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ToastMasterPro.role.model.MeetingRole;
import com.example.ToastMasterPro.role.model.RoleAllocation;
import com.example.ToastMasterPro.role.service.MeetingRoleService;

@RestController
@RequestMapping("/api/roles")
@CrossOrigin(origins = "http://localhost:3000")
public class MeetingRoleController {

    @Autowired
    private MeetingRoleService meetingRoleService;

    @PostMapping
    public ResponseEntity<String> createRole(@RequestBody MeetingRole meetingRole) {
        @SuppressWarnings("unused")
        MeetingRole newRole = meetingRoleService.addRole(meetingRole);
        return ResponseEntity.ok("Role submitted successfully!");
    }

    @GetMapping
    public List<MeetingRole> getRoles() {
        return meetingRoleService.getAllRoles();
    }

    @DeleteMapping("/{id}")
    public String deleteRole(@PathVariable("id") int id) {
        meetingRoleService.deleteRole(id);
        return "Roles Is Deleted";
    }

    @PutMapping("/{id}")
    public MeetingRole updateRole(@PathVariable("id") int id, @RequestBody MeetingRole meetingRole) {
        return meetingRoleService.updateRole(id, meetingRole);
    }

    // Role Allocation
    @PostMapping("/roleallocation")
    public String createRoleAllocation(@RequestBody List<RoleAllocation> roleAllocations) {
        List<RoleAllocation> result = meetingRoleService.createRoleAllocation(roleAllocations);
        return result.isEmpty() ? "Select The Roles" : "Roles Added successfully";
    }

    @GetMapping("/getrole/{meetingId}")
    public List<Object[]> getRole(@PathVariable("meetingId") Long id) {
        return meetingRoleService.getRole(id);
    }

    @DeleteMapping("/roleAllocation/{roleAssignmentID}")
    public void deleteRoleAllocation(@PathVariable("roleAssignmentID") Long roleAssignmentID) {
        meetingRoleService.deleteRoleAllocation(roleAssignmentID);
    }

    @PatchMapping("/roleAllocation/{roleAssignmentId}/{memberID}")
    public ResponseEntity<RoleAllocation> updateRoleAllocation(@PathVariable("roleAssignmentId") Long roleAssignmentId,
            @PathVariable("memberID") Long memberID) {
        return ResponseEntity.ok(meetingRoleService.updateRoleAllocation(roleAssignmentId, memberID));
    }

    @GetMapping("/getrole/{meetingId}/{memberID}")
    public String getMemberRole(@PathVariable("meetingId")Long meetingId,@PathVariable("memberID")int memberID)
    {
        return meetingRoleService.getMemberRole(meetingId,memberID);
    }

}
