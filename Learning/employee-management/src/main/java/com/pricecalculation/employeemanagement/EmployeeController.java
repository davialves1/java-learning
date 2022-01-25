package com.pricecalculation.employeemanagement;

import java.util.List;
import java.util.Optional;
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

	private EmployeeService employeeService;

	@GetMapping("/test")
	public String test(){
		return "it works";
	}

	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<EmployeeEntity> getEmployee(@PathVariable("id") Long id) {
		Optional<EmployeeEntity> employee = employeeService.findById(id);

		if (employee.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(employee.get());
	}

	@GetMapping("/get-all")
	public List<EmployeeEntity> getAll() {
		return employeeService.findAll();
	}
}
