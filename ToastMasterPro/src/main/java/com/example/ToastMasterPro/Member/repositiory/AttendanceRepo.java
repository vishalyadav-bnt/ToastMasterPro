package com.example.ToastMasterPro.Member.repositiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.ToastMasterPro.Member.model.Attendance;
import com.example.ToastMasterPro.Member.model.AttendanceUserDTO;

public interface AttendanceRepo extends JpaRepository<Attendance, Long> {
    @Query("SELECT new com.example.ToastMasterPro.Member.model.AttendanceUserDTO(" +
            "u.id, u.name, a.absentDate, a.reason, a.status, a.user.id) " +
            "FROM Attendance a " +
            "JOIN a.user u")

    List<AttendanceUserDTO> findAvailablityWithUserDetails();
}
