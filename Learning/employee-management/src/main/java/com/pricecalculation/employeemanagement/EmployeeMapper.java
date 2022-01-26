package com.pricecalculation.employeemanagement;

import org.springframework.stereotype.Service;

@Service
public class EmployeeMapper {

	public Employee employeeDtoToEntity(EmployeeDto employeeDto) {
		return new Employee(
			employeeDto.getFirstName(),
			employeeDto.getLastName(),
			employeeDto.getEmail());
	}
}
