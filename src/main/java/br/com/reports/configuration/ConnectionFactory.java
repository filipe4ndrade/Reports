package br.com.reports.configuration;

import br.com.reports.configuration.exception.DbException;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


@Component
public class ConnectionFactory {

    @Bean
    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Mudar@2023");
            System.out.println("Conexão estabelecida com sucesso!");
            return conn;
        } catch (SQLException e) {
            System.err.println("Erro ao Estabelecer Conexão");
            throw new DbException(e.getMessage());
        }
    }
}