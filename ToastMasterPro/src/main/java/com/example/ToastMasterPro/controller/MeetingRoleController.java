package com.example.ToastMasterPro.controller;

import java.util.List;

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

import com.example.ToastMasterPro.model.MeetingRole;
import com.example.ToastMasterPro.service.MeetingRoleService;

@RestController
@RequestMapping("/api/roles")
@CrossOrigin(origins ="http://localhost:3000")
public class MeetingRoleController {

    @Autowired
    private MeetingRoleService meetingRoleService;

    @PostMapping
    public ResponseEntity<String> createRole(@RequestBody MeetingRole meetingRole) {
    @SuppressWarnings("unused")
    MeetingRole newRole=meetingRoleService.addRole(meetingRole);
     return ResponseEntity.ok("Role submitted successfully!");
    }

    @GetMapping
    public List<MeetingRole> getRoles() {
        return meetingRoleService.getAllRoles();
    }

    @DeleteMapping("/{id}")
    public String deleteRole(@PathVariable int id)
    {
       meetingRoleService.deleteRole(id);
       return "Roles Is Deleted";
    }

    @PutMapping
    public MeetingRole updateRole(@RequestBody MeetingRole meetingRole)
    {
        return meetingRoleService.updateRole(meetingRole);
    }
    
    

}
