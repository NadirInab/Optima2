package com.recurciumoptima.services;

import com.recurciumoptima.module.Employee;
import com.recurciumoptima.repository.EmployeeRepo;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService {
    private final EmployeeRepo employeeRepo;
    private final EntityManagerFactory entityManagerFactory;

    public EmployeeService() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("default");
        this.employeeRepo = new EmployeeRepo(entityManagerFactory);
    }
    //    add Employee
    public void addEmlpoyee(Employee employee) {
        employeeRepo.saveEmployee(employee);
    }
    //    login
    public Object userLogin(Employee employee){
        return employeeRepo.auth(employee);
    }
    //    get All Employees
    public List<Employee> getEmployees(){
        List<Employee> employeeList=employeeRepo.getAllEmployees();
        return employeeList;
    }

    public void deleteEmp(String userId) {
        employeeRepo.deleteEmployee(userId);
    }
}
