package com.pricecalculation.employeemanagement;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class EmployeeControllerIntegrationTest {

	@Autowired
	MockMvc mockMvc;

	@BeforeEach
	void setUp() {
	}

	@Test
	void itShouldGetAnEmployeeSuccessfully() throws Exception {
		// Given
		RequestBuilder request = MockMvcRequestBuilders.get("/by-id/1");

		// When
		MvcResult result;
		try {
			result = mockMvc.perform(request).andReturn();
		} catch (Exception exception) {
			throw new RuntimeException(exception);
		}

		// Then
		assertThat(result).isNotNull();
	}

	@Test
	void itShouldGetAllEmployeesSuccessfully() throws Exception {
		// Given
		RequestBuilder request = MockMvcRequestBuilders.get("/get-all");

		// When
		MvcResult result;
		try {
			result = mockMvc.perform(request).andReturn();
		} catch (Exception exception) {
			throw new RuntimeException(exception);
		}

		// Then
		assertThat(result).isNotNull();
		assertThat(result.getResponse().getStatus()).isEqualTo(200);
	}

	@Test
	void itShouldCreateAnEmployeeSuccessfully() throws Exception {
		// Given
		Employee newEmployee = new Employee("John", "Doe", "john.doe@vw.de");
		String newEmployeeAsString = new ObjectMapper().writeValueAsString(newEmployee);
		RequestBuilder request = MockMvcRequestBuilders
			.post("/new-employee")
			.contentType(MediaType.APPLICATION_JSON)
			.content(newEmployeeAsString);

		// When
		MvcResult result;
		try {
			result = mockMvc.perform(request).andReturn();
		} catch (Exception exception) {
			throw new RuntimeException(exception);
		}

		// Then
		assertThat(result).isNotNull();
		assertThat(result.getResponse().getStatus()).isEqualTo(200);
	}
}
