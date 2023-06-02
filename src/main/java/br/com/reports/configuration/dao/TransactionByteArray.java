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
public class TransactionByteArray {

    private Connection conn;

    public TransactionByteArray(){
        this.conn = ConnectionFactory.getConnection();
    }

    public ByteArrayOutputStream findById(Integer id){

        PreparedStatement st = null;
        ResultSet rs = null;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            st = conn.prepareStatement("SELECT * FROM transactions t " +
                                            "JOIN purchases p ON t.purchase_id = p.id " +
                                            "JOIN purchase_client pc ON p.id = pc.purchase_id "+
                                            "WHERE pc.client_id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            while (rs.next()) {
                byte[] idBytes = rs.getBytes("id");
                byte[] paymentTypeBytes = rs.getBytes("payment_type");
                byte[] statusBytes = rs.getBytes("status");
                byte[] authorizationCodeBytes = rs.getBytes("authorization_code");
                byte[] installmentBytes = rs.getBytes("installment");

                outputStream.write(idBytes);
                outputStream.write(',');
                outputStream.write(paymentTypeBytes);
                outputStream.write(',');
                outputStream.write(statusBytes);
                outputStream.write(',');
                outputStream.write(authorizationCodeBytes);
                outputStream.write(',');
                outputStream.write(installmentBytes);
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


