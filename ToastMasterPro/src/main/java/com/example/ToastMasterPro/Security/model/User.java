package com.example.ToastMasterPro.Security.model;

import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="login_details")
public class User   {

    @Id
    private int id;

    @NotNull
    @Size(min = 1, max = 20)
    @Builder.Default
    private String role = "member";

    @NotBlank
    @Size(min = 1, max = 100)
    private String name;

    @NotBlank
    @Size(min = 1, max = 50)
    private String username;

    @NotBlank
    @Size(min = 6, max = 100)
    private String password;

    @NotNull
    private LocalDate registrationDate;

    @PrePersist
    protected void onCreate() {
        if (registrationDate == null) {
            registrationDate = LocalDate.now();
        }
    }

    // @ManyToOne
    // @JoinColumn(name = "member_id", nullable = false)
    // private MemberS member;

}
