package kodillapatterns2.adapter.company;

import kodillapatterns2.adapter.company.newhrsystem.CompanyProcessorSalary;
import kodillapatterns2.adapter.company.newhrsystem.Employee;
import kodillapatterns2.adapter.company.newhrsystem.SalaryProcessor;

import java.math.BigDecimal;
import java.util.List;

public class SalaryAdaptee implements SalaryProcessor {

    @Override
    public BigDecimal calculateSalaries(List<Employee> employees) {
        CompanyProcessorSalary theProcessor = new CompanyProcessorSalary();
        return theProcessor.calculateSalaries(employees);
    }
}
