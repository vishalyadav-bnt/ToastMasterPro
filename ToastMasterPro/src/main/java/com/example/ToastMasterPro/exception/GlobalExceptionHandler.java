// package com.example.ToastMasterPro.exception;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.ErrorResponse;
// import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// public class GlobalExceptionHandler {

//     @ExceptionHandler(MemberObjectIsNull.class)
//     public ResponseEntity<ErrorResponse> handleMemberObjectIsNull(MemberObjectIsNull e) {
//         ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), HttpStatus.CONFLICT.value());
//         return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
//     }

// }
