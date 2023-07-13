package com.surokkha.usermanagementservice.user;

import com.surokkha.usermanagementservice.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {
	
	Optional<User> findByNid(String nid);
	
	Optional<User> findByBirthCertificateId(String birthCertificateId);
	
	Optional<User> findByEmail(String email);
	
}