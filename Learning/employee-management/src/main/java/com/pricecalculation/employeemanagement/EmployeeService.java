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

	public Optional<EmployeeEntity> findById(Long id) {
		return employeeRepository.findById(id);
	}

	public List<EmployeeEntity> findAll() {
		return employeeRepository.findAll();
	}

}
