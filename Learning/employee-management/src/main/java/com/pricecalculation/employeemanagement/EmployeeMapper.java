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

	public EmployeeDto employeeEntityToDto(Employee employee) {
		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.setFirstName(employee.getFirstName());
		employeeDto.setLastName(employee.getLastName());
		employeeDto.setEmail(employee.getEmail());
		return employeeDto;
	}
}
