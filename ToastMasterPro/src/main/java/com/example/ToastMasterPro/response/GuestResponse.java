package com.example.ToastMasterPro.response;

import com.example.ToastMasterPro.Guest.model.GuestModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GuestResponse { 
    private GuestModel guestModel;
    private String msg;
    private int statusCode;
}
