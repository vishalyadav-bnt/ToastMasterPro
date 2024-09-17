package com.example.ToastMasterPro.Meeting.model;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="role_setup")
public class RoleSetup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer evaluatorCount;
    private Integer roleCount;
    private Integer speakerCount;
    private List<String> roles;
   // private List<String>roles;

    @ManyToOne
    @JoinColumn(name = "meetingId", nullable = false)
    @JsonBackReference
    private Meeting meeting;

}

