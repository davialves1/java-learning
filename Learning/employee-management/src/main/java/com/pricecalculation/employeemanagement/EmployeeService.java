package com.pricecalculation.employeemanagement;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class EmployeeService {

	private final EmployeeRepository employeeRepository;

	public Optional<Employee> findById(Long id) {
		return employeeRepository.findById(id);
	}

	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	public Employee create(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Employee employeeDtoToEntity(EmployeeDto employeeDto) {
		return new Employee(
			employeeDto.getFirstName(),
			employeeDto.getLastName(),
			employeeDto.getEmail());
	}

}
