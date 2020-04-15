package DependencyTut;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void saveEmployee(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name can not be empty");
        }
        var upperCase = name.toUpperCase();
        employeeDao.saveEmployee(upperCase);
    }
}
