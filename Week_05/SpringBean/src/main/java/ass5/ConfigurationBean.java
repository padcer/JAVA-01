package ass5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationBean {

    @Bean
    public StudentBean5 getBean() {
        return new StudentBean5();
    }
}
