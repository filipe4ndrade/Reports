package br.com.reports.configuration;


import br.com.reports.entities.enums.ContractTypeEnum;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;
import java.util.UUID;



public record ClientDTO(

        Long id,
        UUID UUID,


        String name,


        String identity,

        ContractTypeEnum contract,


        String email,


        String password,


        AddressDTO address,

        Long contractNumber,

        List<Long> purchases) {


}
