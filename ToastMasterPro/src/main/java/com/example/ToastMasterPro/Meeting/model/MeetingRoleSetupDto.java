package com.example.ToastMasterPro.Meeting.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MeetingRoleSetupDto {
    private Long meetingId;
    private String startTime;
    private String endTime;
    private String location;
    private String meetingDate;
    
    private String theme;
    private Long id;
    private int evaluatorCount;
    private int roleCount;
    private int speakerCount;
    private List<String>roles;
}
