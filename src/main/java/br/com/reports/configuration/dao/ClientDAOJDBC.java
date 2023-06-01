package br.com.reports.configuration.dao;

import br.com.reports.configuration.AddressDTO;
import br.com.reports.configuration.ClientDTO;
import br.com.reports.configuration.ConnectionFactory;
import br.com.reports.configuration.exception.DbException;
import br.com.reports.entities.enums.ContractTypeEnum;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

@Component
public class ClientDAOJDBC {

    private Connection conn;

    public ClientDAOJDBC() {
        this.conn = ConnectionFactory.getConnection();
    }

    public ClientDTO findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM clients WHERE id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                AddressDTO addressDTO = new AddressDTO(
                        rs.getString("street"),
                        rs.getString("number"),
                        rs.getString("city"),
                        rs.getString("state"),
                        rs.getString("complement")
                );
                return new ClientDTO(
                        rs.getLong("id"),
                        UUID.fromString(rs.getString("uuid")),
                        rs.getString("name"),
                        rs.getString("identity"),
                        ContractTypeEnum.valueOf(rs.getString("contract")),
                        rs.getString("email"),
                        rs.getString("password"),
                        addressDTO,
                        rs.getLong("contractNumber"),
                        new ArrayList<>()
                );
            }
            return null;
        } catch (SQLException e) {
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
