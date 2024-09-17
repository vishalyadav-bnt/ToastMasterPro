package com.example.ToastMasterPro.Meeting.model;

import java.time.LocalDate;

import com.example.ToastMasterPro.Member.model.MemberS;

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
@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table
public class MeetingAttendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long AID;
    @ManyToOne()
    @JoinColumn(name = "meetingId")
    private Meeting meeting;
    @ManyToOne()
    @JoinColumn(name = "memberID")
    private MemberS member;

    private String status;
    private String date = LocalDate.now().toString();




}
