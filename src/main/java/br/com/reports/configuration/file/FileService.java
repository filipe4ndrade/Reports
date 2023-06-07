package br.com.reports.configuration.file;

import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;

@Component
public class FileService {

    public void generateFileTransaction(Object obj) {


        try {
            FileWriter file = new FileWriter("RELATORIO_TRANSACTION.xls");
            file.write("Id,Payment Type,Status,Authorization Code, Installment,Purchase_id\n");
            file.write(obj.toString());
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Generating transaction file reports...");
        }
    }

    public void generateFileClient(Object obj){

        try {
            FileWriter file = new FileWriter("RELATORIO_CLIENT.xls");
            file.write("Id, Name, Identity, Contract, Email, Password, Street, Number, City, State, Complement, ContractNumber\n");
            file.write(obj.toString());
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            System.out.println("Generating client file reports...");
        }
    }

}
