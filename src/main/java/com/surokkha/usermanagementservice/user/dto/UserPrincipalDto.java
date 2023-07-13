package com.surokkha.usermanagementservice.user.dto;

import com.surokkha.usermanagementservice.user.model.UserRole;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class UserPrincipalDto {
	
	private String name;
	private Date dob;
	private String phone;
	private String nid;
	private String birthCertificateId;
	private UserRole userRole;
}
