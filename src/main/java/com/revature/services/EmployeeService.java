package com.revature.services;

import com.revature.models.Employee;
import com.revature.repos.EmployeeRepo;

import java.util.List;

public class EmployeeService {

   private final EmployeeRepo employeeRepo;

   public EmployeeService() {
      employeeRepo = new EmployeeRepo();
   }

   public EmployeeService(EmployeeRepo employeeRepo) {
      this.employeeRepo = employeeRepo;
   }

   // create
   public int create(Employee employee) {
      return employeeRepo.create(employee);
   }

   // read all
   public List<Employee> getAllEmployees() {
      return employeeRepo.getAll();
   }

   // read byID

   public Employee getById(int id) {
      return employeeRepo.getById(id);
   }

   // update

   public Employee updateEmployee(Employee employee) {
      return employeeRepo.update(employee);
   }

   // delete
   public boolean deleteEmployee(Employee employee) {
      return employeeRepo.delete(employee);
   }

}
