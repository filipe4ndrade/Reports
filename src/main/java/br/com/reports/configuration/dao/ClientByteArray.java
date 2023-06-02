package br.com.reports.configuration.dao;

import br.com.reports.configuration.ConnectionFactory;
import br.com.reports.configuration.exception.DbException;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ClientByteArray {

    private Connection conn;

    public ClientByteArray() {
        this.conn = ConnectionFactory.getConnection();
    }


    public ByteArrayOutputStream findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            st = conn.prepareStatement("SELECT clients.*, addresses.* FROM clients " +
                    "JOIN addresses ON clients.address_id = addresses.id " +
                    "WHERE clients.id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            while (rs.next()) {

                byte[] clientId = rs.getBytes("id");
                byte[] name = rs.getBytes("name");
                byte[] identity = rs.getBytes("identity");
                byte[] contract = rs.getBytes("contract");
                byte[] email = rs.getBytes("email");
                byte[] password = rs.getBytes("password");
                byte[] contractNumber = rs.getBytes("contract_Number");
                byte[] street = rs.getBytes("street");
                byte[] number = rs.getBytes("number");
                byte[] city = rs.getBytes("city");
                byte[] state = rs.getBytes("state");
                byte[] complement = rs.getBytes("complement");

                outputStream.write(clientId);
                outputStream.write(',');
                outputStream.write(name);
                outputStream.write(',');
                outputStream.write(identity);
                outputStream.write(',');
                outputStream.write(contract);
                outputStream.write(',');
                outputStream.write(email);
                outputStream.write(',');
                outputStream.write(password);
                outputStream.write(',');
                outputStream.write(contractNumber);
                outputStream.write(',');
                outputStream.write(street);
                outputStream.write(',');
                outputStream.write(number);
                outputStream.write(',');
                outputStream.write(city);
                outputStream.write(',');
                outputStream.write(state);
                outputStream.write(',');
                outputStream.write(complement);
                outputStream.write('\n');


            }
            return outputStream;
        } catch (SQLException | IOException e) {
            throw new DbException(e.getMessage());
        } finally {
            try {
                rs.close();
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public ByteArrayOutputStream findAllClients() {
        PreparedStatement st = null;
        ResultSet rs = null;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            st = conn.prepareStatement("SELECT clients.*, addresses.* FROM clients " +
                                            "JOIN addresses ON clients.address_id = addresses.id");
            rs = st.executeQuery();

            while (rs.next()) {
                byte[] clientId = rs.getBytes("id");
                byte[] name = rs.getBytes("name");
                byte[] identity = rs.getBytes("identity");
                byte[] contract = rs.getBytes("contract");
                byte[] email = rs.getBytes("email");
                byte[] password = rs.getBytes("password");
                byte[] contractNumber = rs.getBytes("contract_Number");
                byte[] street = rs.getBytes("street");
                byte[] number = rs.getBytes("number");
                byte[] city = rs.getBytes("city");
                byte[] state = rs.getBytes("state");
                byte[] complement = rs.getBytes("complement");

                outputStream.write(clientId);
                outputStream.write(',');
                outputStream.write(name);
                outputStream.write(',');
                outputStream.write(identity);
                outputStream.write(',');
                outputStream.write(contract);
                outputStream.write(',');
                outputStream.write(email);
                outputStream.write(',');
                outputStream.write(password);
                outputStream.write(',');
                outputStream.write(contractNumber);
                outputStream.write(',');
                outputStream.write(street);
                outputStream.write(',');
                outputStream.write(number);
                outputStream.write(',');
                outputStream.write(city);
                outputStream.write(',');
                outputStream.write(state);
                outputStream.write(',');
                outputStream.write(complement);
                outputStream.write('\n');
            }

            return outputStream;
        } catch (SQLException | IOException e) {
            throw new DbException(e.getMessage());
        } finally {
            try {
                rs.close();
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
