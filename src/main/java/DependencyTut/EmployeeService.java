package DependencyTut;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeDao employeeDao;

    private final ApplicationEventPublisher publisher;

    public EmployeeService(EmployeeDao employeeDao, ApplicationEventPublisher publisher) {
        this.employeeDao = employeeDao;
        this.publisher = publisher;
    }

    public void saveEmployee(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name can not be empty");
        }
        var upperCase = name.toUpperCase();
        employeeDao.saveEmployee(upperCase);

        publisher.publishEvent(new EmployeeHasCreatedEvent(this, name));
    }
}
