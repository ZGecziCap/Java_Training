package DependencyTut;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
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
