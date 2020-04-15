package DependencyTut;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeDao employeeDao;

    private final ApplicationEventPublisher publisher;

    //egyik megoldás
    private final Environment env;
    //másik, ebben az esetben még a proerties file-ban látszik is ha van használatban az adott érték, vagyis van @Value
    private final boolean uppercaseEnabled;

    public EmployeeService(EmployeeDao employeeDao, ApplicationEventPublisher publisher,Environment env, @Value("${uppercase.enabled}") boolean uppercaseEnabled) {
        this.employeeDao = employeeDao;
        this.publisher = publisher;
        this.env = env;
        this.uppercaseEnabled = uppercaseEnabled;
    }

    public void saveEmployee(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name can not be empty");
        }

        var upperCase = name;
        if (Boolean.parseBoolean(env.getProperty("uppercase.enabled"))) {
            upperCase = name.toUpperCase();
        }

        employeeDao.saveEmployee(upperCase);

        publisher.publishEvent(new EmployeeHasCreatedEvent(this, name));
    }
}
