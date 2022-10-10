package com.revature.repos;

import com.revature.models.Ticket;
import com.revature.utils.CRUDDaoInterface;
import com.revature.utils.ConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketsRepo implements CRUDDaoInterface<Ticket> {
    public Connection connection;
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeRepo.class);

    public TicketsRepo() {

        try {
            connection = ConnectionManager.getConnection();
        } catch (SQLException sqlException) {

            System.out.println(sqlException.getMessage());
            LOGGER.error(sqlException.getMessage());
        }

    }

    // ! needs testing
    @Override
    public int create(Ticket ticket) {
        String sql = "INSERT INTO tickets (id, amount, employee_id, description) VALUES(default,?,?,?); ";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setDouble(1, ticket.getAmount());
            // pstmt.setString(2, ticket.getDate());
            pstmt.setInt(2, ticket.getEmployee_id());
            pstmt.setString(3, ticket.getDescription());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            rs.next();

            return rs.getInt("id");

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return 0;
    }

    // ! needs testing
    @Override
    public List<Ticket> getAll() {

        List<Ticket> tickets = new ArrayList<>();

        try {
            String sql = "SELECT * FROM tickets";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                Ticket ticket = new Ticket();

                ticket.setId(rs.getInt("id"));
                ticket.setAmount(rs.getDouble("amount"));
//                ticket.setDate(rs.getString("submission_date"));
                ticket.setEmployee_id(rs.getInt("employee_id"));
                ticket.setDescription(rs.getString("description"));

                tickets.add(ticket);
            }

            return tickets;

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return null;
    }

    // ! needs testing
    // todo gets ticket by employee id
    @Override
    public Ticket getById(int employee_id) {

        try {
            String sql = "SELECT * FROM tickets WHERE employee_id = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, employee_id);

            ResultSet rs = pstmt.executeQuery();

            // Returns a ticket therefore a new instance of a ticket from database has
            // to be created
            Ticket ticket = new Ticket();

            while (rs.next()) {
                ticket.setId(rs.getInt("id"));
                ticket.setAmount(rs.getDouble("amount"));
//                ticket.setDate(rs.getString("submission_date"));
                ticket.setDescription(rs.getString("description"));

            }

            return ticket;

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return null;
    }

    // ! needs testing
    // todo ticket by status
    public Ticket getByStatus(String status) {

        try {
            String sql = "SELECT * FROM tickets WHERE status = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, status);

            ResultSet rs = pstmt.executeQuery();

            // Returns a ticket therefore a new instance of a ticket from database has
            // to be created
            Ticket ticket = new Ticket();

            while (rs.next()) {
                ticket.setStatus(rs.getString("status"));

            }

            return ticket;

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return null;
    }

    // ! needs testing
    // THIS ONLY UPDATES THE AMOUNT
    @Override
    public Ticket update(Ticket ticket) {

        try {

            String sql = "UPDATE tickets SET amount = ? WHERE id = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setDouble(1, ticket.getAmount());
            pstmt.setInt(2, ticket.getId());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();

            while (rs.next()) {
                ticket.setAmount(rs.getDouble("amount"));
            }

            return ticket;

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());

        }
        return null;
    }

    // ! needs testing
    @Override
    public boolean delete(Ticket ticket) {
        try {
            String sql = "DELETE FROM tickets WHERE id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, ticket.getId());
            ResultSet rs = pstmt.executeQuery();
            return true;

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }

        return false;
    }

    // delete by id

    public boolean deleteById(int id) {
        return delete(getById(id));
    }
}
