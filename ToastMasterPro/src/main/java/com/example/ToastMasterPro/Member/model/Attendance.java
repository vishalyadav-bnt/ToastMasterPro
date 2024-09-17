package com.example.ToastMasterPro.Member.model;

import com.example.ToastMasterPro.Security.model.User;

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
@Table(name="Attendance_Track")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status = "Available"; // Default value

    private String absentDate ="Available";

    private String reason="Personal Reason";

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
