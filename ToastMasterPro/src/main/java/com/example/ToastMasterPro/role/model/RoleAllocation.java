package com.example.ToastMasterPro.role.model;

import com.example.ToastMasterPro.Meeting.model.Meeting;
import com.example.ToastMasterPro.Member.model.MemberS;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Role_Allocation")
public class RoleAllocation {

   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleAssignmentID;

    private String role;

    @Column(name = "meeting_id",nullable = false)
    private Long meetingId;

    // Here is the raw member_id column
    @Column(name = "memberid",nullable = false)
    private Long memberID;
    // This establishes a foreign key relationship to Meeting
    @ManyToOne()
    @JoinColumn(name = "meeting_id", insertable = false, updatable = false)
    private Meeting meeting;

    // This establishes a foreign key relationship to Member
    @ManyToOne()
    @JoinColumn(name = "memberid", insertable = false, updatable = false)
    private MemberS member;

   
   

}
