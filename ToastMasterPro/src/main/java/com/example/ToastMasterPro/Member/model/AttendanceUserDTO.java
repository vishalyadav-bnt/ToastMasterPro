package com.example.ToastMasterPro.Member.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AttendanceUserDTO {
    private int userId;
    private String name;
    private String absentDate;
    private String reason;
    private String status;
    private int userUserId;

}
