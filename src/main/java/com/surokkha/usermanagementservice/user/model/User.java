package com.surokkha.usermanagementservice.user.model;

import lombok.*;

import jakarta.persistence.*;

import java.util.Date;

import static jakarta.persistence.EnumType.STRING;

@Entity
@Table (name = "user", schema = "public")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
	
	@Id
	@Column (nullable = false)
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private String id;
	
	@Column (nullable = false)
	private String name;
	
	@Column (nullable = false)
	private Date dob;
	
	@Column (nullable = false)
	private String email;
	
	@Column
	private String nid;
	
	@Column
	private String birthCertificateId;
	
	@Column
	private String password;
	
	@Column (nullable = false)
	@Enumerated (STRING)
	private UserRole userRole;
}
