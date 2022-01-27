package com.pricecalculation.employeemanagement;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@Log4j2
public class EmployeeController {

	private final EmployeeService employeeService;
	private final EmployeeMapper employeeMapper;

	/**
	 * Reads the employee by id.
	 *
	 * @param id The requested id of the employee.
	 * @return The found employee entity.
	 */
	@GetMapping("/by-id/{id}")
	@ApiOperation(value = "Returns an employee by id")
	@ApiResponses(
		value = {
			@ApiResponse(code = 200, message = "Successfully returned an employee"),
			@ApiResponse(code = 404, message = "Failed to find the requested employee")
		}
	)
	@ResponseBody
	public ResponseEntity<Employee> getEmployee(
		@ApiParam(value = "Id of the employee", required = true)
		@PathVariable("id") Long id) {
		Optional<Employee> employee = employeeService.findById(id);

		if (employee.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(employee.get(), HttpStatus.OK);
		}
	}

	/**
	 * Reads all employees
	 *
	 * @return The list of all employees.
	 */
	@GetMapping("/get-all")
	@ApiOperation(value = "Returns all employees")
	@ApiResponses(
		value = {
			@ApiResponse(code = 200, message = "Successfully returned all employees"),
			@ApiResponse(code = 404, message = "Failed to return all employees")
		}
	)
	public List<Employee> getAllEmployees() {
		return employeeService.findAll();
	}

	/**
	 * Creates a new employee entry.
	 * @return The created employee entry.
	 */
	@PostMapping(value = "/new-employee")
	@ApiOperation(value = "Creates a new employee entry")
	@ApiResponses(
		value = {
			@ApiResponse(code = 201, message = "Successfully created a new employee entry"),
			@ApiResponse(code = 400, message = "Failed to create a new employee entry")
		}
	)
	public ResponseEntity<Employee> createEmployee(
		@ApiParam(value = "Employee data to be created", required = true) @RequestBody EmployeeDto employeeDto) {
		Employee employee = employeeMapper.employeeDtoToEntity(employeeDto);
		employeeService.create(employee);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
}
