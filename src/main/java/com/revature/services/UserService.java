package com.revature.services;

import com.revature.models.Employee;
import com.revature.repos.UserRepo;

import java.util.List;

public class UserService {

   private final UserRepo userRepo;

   public UserService() {
      userRepo = new UserRepo();
   }

   public UserService(UserRepo userRepo) {
      this.userRepo = userRepo;
   }

   // create
   public int create(Employee user) {
      return userRepo.create(user);
   }

   // read all
   public List<Employee> getAllUsers() {
      return userRepo.getAll();
   }

   // read byID

   public Employee getById(int id) {
      return userRepo.getById(id);
   }

   // update

   public Employee updateUser(Employee user) {
      return userRepo.update(user);
   }

   // delete
   public boolean deleteUser(Employee user) {
      return userRepo.delete(user);
   }

}
