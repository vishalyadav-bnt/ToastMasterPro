package com.example.ToastMasterPro.Member.model;

import java.sql.Date;
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
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Member")
public class MemberS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberID;

    @Column(name = "FirstName", length = 50, nullable = false)
    private String firstName;

    // @Column(name = "LastName", length = 50, nullable = false)
    // private String lastName;

    @Column(name = "Email", length = 100, nullable = false, unique = true)
    private String email;

    @Column(name = "Phone", length = 20)
    private String phone;

    @Column(name = "JoinDate")
    @Temporal(TemporalType.DATE)
    private Date joinDate;

    @Column(name = "MembershipType", length = 20)
    private String membershipType;

    @Column(name = "Status", length = 10)
    private String status;

    @OneToMany(mappedBy = "member" ,cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<RoleAllocation> roles;
}
