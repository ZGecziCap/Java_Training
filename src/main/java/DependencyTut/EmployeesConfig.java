package DependencyTut;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
public class EmployeesConfig {
/*
    @Bean
    public EmployeeDao employeeDao() {
        return new EmployeeDao();
    }

    @Bean
    public EmployeeService employeeService() {
        return new EmployeeService(employeeDao());
    }
*/
}
