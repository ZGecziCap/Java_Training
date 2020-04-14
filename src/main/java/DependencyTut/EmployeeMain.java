package DependencyTut;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class EmployeeMain {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(EmployeesConfig.class);

        try (context) {
            var employeeService = context.getBean(EmployeeService.class);

            employeeService.saveEmployee("John Doe");

            System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
        }
    }
}
