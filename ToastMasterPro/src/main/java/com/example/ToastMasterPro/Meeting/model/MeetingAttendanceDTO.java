package com.example.ToastMasterPro.Meeting.model;



import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MeetingAttendanceDTO {
    private String theme;
    private String meetingDate;
    private String firstName;
    private String status;
   
}
