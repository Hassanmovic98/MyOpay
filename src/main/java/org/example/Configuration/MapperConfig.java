package org.example.Configuration;



import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.example.data.model.Account;
import org.example.dto.response.CreateAccountResponse;
import org.example.dto.response.GetAccountResponse;
import org.example.dto.response.UpdateAccountResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        configureGlobalSettings(modelMapper);
        configureAccountMappings(modelMapper);

        return modelMapper;
    }

    private void configureGlobalSettings(ModelMapper modelMapper) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setSkipNullEnabled(true)
                .setAmbiguityIgnored(false);
    }

    private void configureAccountMappings(ModelMapper modelMapper) {
        modelMapper.createTypeMap(Account.class, GetAccountResponse.class)
                .addMappings(mapper -> {
                    mapper.skip(GetAccountResponse::setMessage);
                });

        modelMapper.createTypeMap(Account.class, CreateAccountResponse.class)
                .addMappings(mapper -> {
                    mapper.skip(CreateAccountResponse::setMessage);
                });

        modelMapper.createTypeMap(Account.class, UpdateAccountResponse.class)
                .addMappings(mapper -> {
                    mapper.skip(UpdateAccountResponse::setMessage);
                });
    }
}
