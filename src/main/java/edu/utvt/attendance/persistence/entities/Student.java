package edu.utvt.attendance.persistence.entities;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import edu.utvt.attendance.persistence.common.StudentType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "te_students")
public class Student implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6406146723064574603L;

	@Id
	@Column(length = 20)
	private String id;
	
	@Column(length = 50, nullable = false)
	private String firstName;
	
	@Column(length = 100, nullable = false)
	private String lastName;
	
	@Column(length = 50, nullable = false)
	private String email;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private StudentType type;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(nullable = false, columnDefinition = "DATE")
	private Date birthDate;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	@Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP")
	@CreationTimestamp
	private Date createdOn;
	

}
