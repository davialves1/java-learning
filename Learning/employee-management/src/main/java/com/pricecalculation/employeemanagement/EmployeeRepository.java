package com.pricecalculation.employeemanagement;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	public List<Employee> findAll();

	public Optional<Employee> findById(Long id);
}
