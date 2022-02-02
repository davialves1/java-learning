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
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class EmployeeControllerTest {

	@InjectMocks
	private EmployeeController employeeController;

	@Mock
	private EmployeeRepository employeeRepository;

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
	void getEmployee() throws Exception {
		//given
		long employeeId = 1L;
		Mockito.when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(employee));

		//when
		when(employeeService.findById(employeeId)).thenReturn(Optional.of(employee));
		Optional<Employee> employee1 = employeeService.findById(employeeId);

		//then
		assertThat(employee1).isNotNull();
	}

	@Test
	void getAllEmployees() {
		//given
		Employee mockedEmployee1 = new Employee("John", "Doe", "john.doe@vw.de");
		Employee mockedEmployee2 = new Employee("Doe", "John", "doe.john@vw.de");
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(mockedEmployee1);
		employeeList.add(mockedEmployee2);
		Mockito.when(employeeRepository.findAll()).thenReturn(employeeList);

		//when
		when(employeeController.getAllEmployees()).thenReturn(employeeList);
		List<Employee> mockEmployeeList = employeeController.getAllEmployees();

		//then
		assertThat(mockEmployeeList).isNotNull();
		assertThat(mockEmployeeList.size()).isEqualTo(2);
	}

	@Test
	void createEmployee() {
		//given
		Employee newEmployee = new Employee("John", "Doe", "john.doe@vw.de");
		Mockito.when(employeeRepository.save(newEmployee)).thenReturn(newEmployee);

		//when
		when(employeeService.create(newEmployee)).thenReturn(newEmployee);
		EmployeeDto employeeDto = employeeMapper.employeeEntityToDto(newEmployee);
		ResponseEntity<Employee> employee1 = employeeController.createEmployee(employeeDto);

		//then
		assertThat(employee1).isNotNull();
		assertThat(employee1.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
}
