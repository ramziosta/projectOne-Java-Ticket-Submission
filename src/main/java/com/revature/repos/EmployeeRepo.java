package com.revature.repos;

import com.revature.utils.CRUDDaoInterface;
import com.revature.models.Employee;
import com.revature.utils.ConnectionManager;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepo implements CRUDDaoInterface<Employee> {

    public Connection connection;

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeRepo.class);

    public EmployeeRepo() {

        try {
            connection = ConnectionManager.getConnection();
        } catch (SQLException sqlException) {

            System.out.println(sqlException.getMessage());
            LOGGER.error(sqlException.getMessage());
        }

    }

    // tested word fine
    @Override
    public int create(Employee employee) {
        String sql = "INSERT INTO employees (id, first_name, last_name, email, pass_word, is_manager) VALUES(default,?,?,?,?,?); ";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, employee.getFirstName());
            pstmt.setString(2, employee.getLastName());
            pstmt.setString(3, employee.getEmail());
            pstmt.setString(4, employee.getPassword());
            pstmt.setBoolean(5, employee.getIsManager());
            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            rs.next();

            return rs.getInt("id");

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
            LOGGER.error(sqlException.getMessage());
        }
        return 0;
    }

    // ! needs testing
    @Override
    public List<Employee> getAll() {

        List<Employee> employees = new ArrayList<>();

        try {
            String sql = "SELECT * FROM employees";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setFirstName(rs.getString("first_name"));
                employee.setLastName(rs.getString("last_name"));
                employee.setEmail(rs.getString("email"));
                employee.setPassword(rs.getString("pass_word"));
                employees.add(employee);
            }

            return employees;
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return null;
    }

    // ! needs testing
    @Override
    public Employee getById(int id) {
        try {
            String sql = "SELECT * FROM employees WHERE id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            Employee employee = new Employee();

            while (rs.next()) {
                employee.setId(rs.getInt("id"));
                employee.setFirstName(rs.getString("first_name"));
                employee.setLastName(rs.getString("last_name"));
                employee.setEmail(rs.getString("email"));
                employee.setPassword(rs.getString("pass_word"));

            }

            return employee;
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return null;
    }

    // !needs testing
    @Override
    public Employee update(Employee employee) {

        try {

            String sql = "UPDATE employees SET email = ? WHERE id = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, employee.getEmail());
            pstmt.setInt(2, employee.getId());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();

            while (rs.next()) {
                employee.setEmail(rs.getString("email"));
            }

            return employee;

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return null;
    }

    // ! needs testing
    @Override
    public boolean delete(Employee employee) {

        try {
            String sql = "DELETE FROM employees WHERE id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, employee.getId());
            pstmt.execute();
            return true;
            // pstmt.execute() specifically returns false

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }

        return false;
    }


    // tested works fine 
        public Employee login(Employee employee) {

        try {

            String sql = "UPDATE employees SET logged_in = true WHERE email = ? AND pass_word = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, employee.getEmail());
            pstmt.setString(2, employee.getPassword());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();

            while (rs.next()) {
                employee.setEmail(rs.getString("email"));
            }

            return employee;

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return null;
    }

    }

