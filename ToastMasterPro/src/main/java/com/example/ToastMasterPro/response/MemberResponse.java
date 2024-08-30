package com.example.ToastMasterPro.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberResponse {
    private Object object;
    private String msg;
    private int statusCode;

}
