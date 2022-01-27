package com.pricecalculation.employeemanagement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Defines the DTO object of the {@link Employee} Entity.
 */
@ApiModel
@Data
@NoArgsConstructor
@ToString
public class EmployeeDto {

	public static final String FIRST_NAME = "firstName";
	public static final String LAST_NAME = "lastName";
	public static final String E_MAIL = "email";

	@ApiModelProperty(value = "First name of the employee")
	private String firstName;

	@ApiModelProperty(value = "Last name of the employee")
	private String lastName;

	@ApiModelProperty(value = "Email of the employee")
	private String email;
}
