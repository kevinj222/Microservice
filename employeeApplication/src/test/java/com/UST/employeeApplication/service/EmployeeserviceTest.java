package com.UST.employeeApplication.service;

import com.UST.employeeApplication.entity.Employee;
import com.UST.employeeApplication.repo.Employeerepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeserviceTest {

    @Mock
    private Employeerepo mockRepo;

    @InjectMocks
    private Employeeservice employeeserviceUnderTest;

    @Test
    void testCreateEmployee() {
        // Setup
        final Employee employee = new Employee(0L, "empId", "empname", "empemailid", "designation", "emphr");
        final Employee expectedResult = new Employee(0L, "empId", "empname", "empemailid", "designation", "emphr");

        // Configure Employeerepo.save(...).
        final Employee employee1 = new Employee(0L, "empId", "empname", "empemailid", "designation", "emphr");
        when(mockRepo.save(new Employee(0L, "empId", "empname", "empemailid", "designation", "emphr")))
                .thenReturn(employee1);

        // Run the test
        final Employee result = employeeserviceUnderTest.createEmployee(employee);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetALLEmployee() {
        // Setup
        final List<Employee> expectedResult = List.of(
                new Employee(0L, "empId", "empname", "empemailid", "designation", "emphr"));

        // Configure Employeerepo.findAll(...).
        final List<Employee> employees = List.of(
                new Employee(0L, "empId", "empname", "empemailid", "designation", "emphr"));
        when(mockRepo.findAll()).thenReturn(employees);

        // Run the test
        final List<Employee> result = employeeserviceUnderTest.getALLEmployee();

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetALLEmployee_EmployeerepoReturnsNoItems() {
        // Setup
        when(mockRepo.findAll()).thenReturn(Collections.emptyList());

        // Run the test
        final List<Employee> result = employeeserviceUnderTest.getALLEmployee();

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void testGetEmployeeByempId() {
        // Setup
        final Employee expectedResult = new Employee(0L, "empId", "empname", "empemailid", "designation", "emphr");

        // Configure Employeerepo.findByempId(...).
        final Employee employee = new Employee(0L, "empId", "empname", "empemailid", "designation", "emphr");
        when(mockRepo.findByempId("empId")).thenReturn(employee);

        // Run the test
        final Employee result = employeeserviceUnderTest.getEmployeeByempId("empId");

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testDeleteEmployeeByempId() {
        // Setup
        // Run the test
        final String result = employeeserviceUnderTest.deleteEmployeeByempId("empId");

        // Verify the results
        assertThat(result).isEqualTo("employee deleted");
        verify(mockRepo).deleteByempId("empId");
    }

    @Test
    void testUpdateEmployee() {
        // Setup
        final Employee employee = new Employee(0L, "empId", "empname", "empemailid", "designation", "emphr");
        final Employee expectedResult = new Employee(0L, "empId", "empname", "empemailid", "designation", "emphr");

        // Configure Employeerepo.findById(...).
        final Optional<Employee> employee1 = Optional.of(
                new Employee(0L, "empId", "empname", "empemailid", "designation", "emphr"));
        when(mockRepo.findById("empId")).thenReturn(employee1);

        // Configure Employeerepo.save(...).
        final Employee employee2 = new Employee(0L, "empId", "empname", "empemailid", "designation", "emphr");
        when(mockRepo.save(new Employee(0L, "empId", "empname", "empemailid", "designation", "emphr")))
                .thenReturn(employee2);

        // Run the test
        final Employee result = employeeserviceUnderTest.updateEmployee("empId", employee);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testUpdateEmployee_EmployeerepoFindByIdReturnsAbsent() {
        // Setup
        final Employee employee = new Employee(0L, "empId", "empname", "empemailid", "designation", "emphr");
        when(mockRepo.findById("empId")).thenReturn(Optional.empty());

        // Run the test
        final Employee result = employeeserviceUnderTest.updateEmployee("empId", employee);

        // Verify the results
        assertThat(result).isNull();
    }
}
