package DependencyTut;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service
public class LoggerService implements ApplicationListener<EmployeeHasCreatedEvent> {

    @Override
    public void onApplicationEvent(EmployeeHasCreatedEvent employeeHasCreatedEvent) {
        System.out.println("Event has arrived: " + employeeHasCreatedEvent.getName());
    }
}
