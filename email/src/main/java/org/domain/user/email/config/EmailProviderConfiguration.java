package org.domain.user.email.config;

import com.sendgrid.SendGrid;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailProviderConfiguration {

    @Bean
    public SendGrid sendGrid(EmailProviderConfigurationProperties properties){
        return new SendGrid(properties.getSendgridApiKey());
    }
}
