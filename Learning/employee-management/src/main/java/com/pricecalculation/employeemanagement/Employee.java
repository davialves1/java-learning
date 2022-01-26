package com.pricecalculation.employeemanagement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
	name = "employee",
	uniqueConstraints = {
		@UniqueConstraint(name = "employee_email_unique", columnNames = "email")
	}
)
public class Employee {

	public Employee(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	@Id
	@SequenceGenerator(
		name = "employee_sequence",
		sequenceName = "employee_sequence",
		allocationSize = 1
	)
	@GeneratedValue(
		strategy = GenerationType.SEQUENCE,
		generator = "employee_sequence"
	)
	@Column(updatable = false)
	private Long id;

	private String firstName;
	private String lastName;

	@Column(
		updatable = false,
		unique = true,
		nullable = false
	)
	private String email;

}
