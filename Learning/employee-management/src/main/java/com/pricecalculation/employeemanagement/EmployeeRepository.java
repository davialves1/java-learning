package com.pricecalculation.employeemanagement;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

	public List<EmployeeEntity> findAll();

	public Optional<EmployeeEntity> findById(Long id);
}
