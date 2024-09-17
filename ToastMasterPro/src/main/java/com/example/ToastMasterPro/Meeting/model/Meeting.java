package com.example.ToastMasterPro.Meeting.model;


import java.util.List;

import com.example.ToastMasterPro.role.model.RoleAllocation;
import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "Meeting")
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long meetingId;

    @Column(name = "meeting_date")
    private String meetingDate;

    @Column(name = "start_time")
    private String startTime;

    @Column(name = "end_time")
    private String endTime;

    @Column(name = "location")
    private String location;

    @Column(name = "theme")
    private String theme;

    @OneToOne(mappedBy = "meeting")
    @JsonIgnore
    private RoleSetup roleSetup;

    @OneToMany(mappedBy = "meeting" ,cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<RoleAllocation> roles;

}
