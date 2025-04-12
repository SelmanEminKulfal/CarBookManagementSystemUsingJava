package com.sellandrent.repository_tier;

import com.sellandrent.model_tier.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Customer_Repository {
    private Connection connection;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    private void close(AutoCloseable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                e.printStackTrace();
                // Loglama eklenebilir
            }
        }
    }

    public Customer getCustomerById(int id) throws SQLException {
        String query = "SELECT * FROM customers WHERE id = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getInt("id"));
                customer.setName(resultSet.getString("name"));
                customer.setSurname(resultSet.getString("surname"));
                customer.setEmail(resultSet.getString("email"));
                customer.setPhone(resultSet.getString("phone"));
                customer.setPassword(resultSet.getString("password"));
                return customer;
            }
            return null;
        } finally {
            close(resultSet);
            close(statement);
        }
    }

    public Customer getCustomerByEmail(String email) throws SQLException {
        String query = "SELECT * FROM customers WHERE email = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, email);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getInt("id"));
                customer.setName(resultSet.getString("name"));
                customer.setSurname(resultSet.getString("surname"));
                customer.setEmail(resultSet.getString("email"));
                customer.setPhone(resultSet.getString("phone"));
                customer.setPassword(resultSet.getString("password"));
                return customer;
            }
            return null;
        } finally {
            close(resultSet);
            close(statement);
        }
    }

    public List<Customer> getAllCustomers() throws SQLException {
        String query = "SELECT * FROM customers";
        Statement statement = null;
        ResultSet resultSet = null;
        List<Customer> customers = new ArrayList<>();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getInt("id"));
                customer.setName(resultSet.getString("name"));
                customer.setSurname(resultSet.getString("surname"));
                customer.setEmail(resultSet.getString("email"));
                customer.setPhone(resultSet.getString("phone"));
                customer.setPassword(resultSet.getString("password"));
                customers.add(customer);
            }
            return customers;
        } finally {
            close(resultSet);
            close(statement);
        }
    }

    public boolean addCustomer(Customer customer) throws SQLException {
        String query = "INSERT INTO customers (name, surname, email, phone, password) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getSurname());
            statement.setString(3, customer.getEmail());
            statement.setString(4, customer.getPhone());
            statement.setString(5, customer.getPassword());
            int affectedRows = statement.executeUpdate();
            return affectedRows > 0;
        } finally {
            close(statement);
        }
    }

    public boolean deleteCustomer(int customerId) throws SQLException {
        String query = "DELETE FROM customers WHERE id = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1, customerId);
            int affectedRows = statement.executeUpdate();
            return affectedRows > 0; // Silinen satır sayısı 0'dan büyükse true döner
        } finally {
            close(statement);
        }
    }

    public boolean updateCustomer(Customer customer) throws SQLException {
        String query = "UPDATE customers SET name = ?, surname = ?, email = ?, password = ? WHERE id = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getSurname());
            statement.setString(3, customer.getEmail());
            statement.setString(4, customer.getPassword());
            statement.setInt(5, customer.getId());
            int affectedRows = statement.executeUpdate();
            return affectedRows > 0;
        } finally {
            close(statement);
        }
    }


    public boolean updatePassword(int customerId, String newPassword) throws SQLException {
        String query = "UPDATE customers SET password = ? WHERE id = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, newPassword);
            statement.setInt(2, customerId);
            int affectedRows = statement.executeUpdate();
            return affectedRows > 0;
        } finally {
            close(statement);
        }
    }
}