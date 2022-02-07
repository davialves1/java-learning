package com.pricecalculation.employeemanagement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class EmployeeControllerTest {

	@InjectMocks
	private EmployeeController employeeController;

	@Mock
	private Employee employee;

	@Mock
	private EmployeeService employeeService;

	@Mock
	private EmployeeMapper employeeMapper;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void contextLoads() throws Exception {
		assertThat(employeeController).isNotNull();
	}

	@Test
	void itShouldGetAnEmployeeSuccessfully() {
		//given
		long employeeId = 1L;
		when(employeeService.findById(employeeId)).thenReturn(Optional.of(employee));

		//when
		ResponseEntity<Employee> employee1 = employeeController.getEmployee(employeeId);

		//then
		assertThat(employee1.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(employee1).isNotNull();
		assertThat(employee1.getClass()).hasSameClassAs(Employee.class);
	}

	@Test
	void itShouldGetAllEmployeesSuccessfully() {
		//given
		Employee mockedEmployee1 = new Employee("John", "Doe", "john.doe@vw.de");
		Employee mockedEmployee2 = new Employee("Doe", "John", "doe.john@vw.de");
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(mockedEmployee1);
		employeeList.add(mockedEmployee2);
		when(employeeService.findAll()).thenReturn(employeeList);

		//when
		ResponseEntity<List<Employee>> mockedEmployeeList = employeeController.getAllEmployees();

		//then
		assertThat(mockedEmployeeList.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(mockedEmployeeList).isNotNull();
		assertThat(mockedEmployeeList.getBody().size()).isEqualTo(2);
		assertThat(mockedEmployeeList.getBody()).containsExactly(mockedEmployee1, mockedEmployee2);
	}

	@Test
	void itShouldCreateAnEmployeeSuccessfully() {
		//given
		Employee newEmployee = new Employee("John", "Doe", "john.doe@vw.de");

		//when
		when(employeeService.create(newEmployee)).thenReturn(newEmployee);
		EmployeeDto employeeDto = employeeMapper.employeeEntityToDto(newEmployee);
		ResponseEntity<Employee> employee1 = employeeController.createEmployee(employeeDto);

		//then
		assertThat(employee1).isNotNull();
		assertThat(employee1.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
}
