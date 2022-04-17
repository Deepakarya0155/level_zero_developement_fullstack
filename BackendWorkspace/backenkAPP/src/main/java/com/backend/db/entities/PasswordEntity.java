package com.backend.db.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
public class PasswordEntity {
	
	@CreationTimestamp
	LocalDateTime createDate;
	
	@UpdateTimestamp
	LocalDateTime updateDate;
	
	@Column(length = 500)
	String discription;

	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	Long passwordId;
	

	String userID;
	String username;
	String password;
}
