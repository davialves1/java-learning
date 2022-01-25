package com.pricecalculation.employeemanagement;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@Log4j2
public class EmployeeController {

	private final EmployeeService employeeService;

	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id) {
		Optional<Employee> employee = employeeService.findById(id);

		if (employee.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(employee.get(), HttpStatus.OK);
		}
	}

	@GetMapping("/get-all")
	public List<Employee> getAll() {
		return employeeService.findAll();
	}
}
