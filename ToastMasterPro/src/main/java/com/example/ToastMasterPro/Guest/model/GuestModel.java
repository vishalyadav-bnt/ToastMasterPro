package com.example.ToastMasterPro.Guest.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="Guest")
public class GuestModel {
    @Id
    @Column(name = "GuestID")
    private int guestId;

    @Column(name = "FirstName", nullable = false, length = 50)
    private String firstName;

    @Column(name = "LastName", nullable = false, length = 50)
    private String lastName;

    @Column(name = "Email", nullable = false, length = 100)
    private String email;

    @Column(name = "Phone", nullable = true, length = 20)
    private String phone;

    @Column(name = "VisitDate", nullable = false)
    private Date visitDate;

    @Column(name = "ConvertedToMember", nullable = false)
    private boolean convertedToMember;

}
