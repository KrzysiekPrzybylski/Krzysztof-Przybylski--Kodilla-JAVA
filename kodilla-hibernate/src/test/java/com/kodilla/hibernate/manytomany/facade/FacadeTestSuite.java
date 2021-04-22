package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FacadeTestSuite {

    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private Facade facade;

    @Test
    public void shouldReturnEmployeeFacadeTest(){
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        //When
        employeeDao.save(johnSmith);
        int johnSmithId = johnSmith.getId();
        employeeDao.save(stephanieClarckson);
        int stephanieClarcksonId = stephanieClarckson.getId();
        employeeDao.save(lindaKovalsky);
        int lindaKovalskyId = lindaKovalsky.getId();

        List<Employee> findEmployee = facade.saerchingEmployee("th");

        //Then
        assertEquals(1, findEmployee.size());


        //CleanUp
        try {
            employeeDao.deleteById(johnSmithId);
            employeeDao.deleteById(lindaKovalskyId);
            employeeDao.deleteById(stephanieClarcksonId);
        } catch (Exception e) {

        }
    }
    @Test
    public void shouldReturnCompanyFacade() {
        //Given
        Company softwareMachine = new Company("Software Machine");
        Company softSoup = new Company("Soft Soup");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        List<Company> companies = new ArrayList<>();
        companies.add(softwareMachine);
        companies.add(softSoup);
        companies.add(dataMaesters);
        companies.add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(softSoup);
        int softSoupId = softSoup.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        List<Company> findCompany = facade.searchingCompany("sof");

        //then
        assertEquals(2,findCompany.size());

        //CleanUp
        try{
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(softSoupId);
            companyDao.deleteById(dataMaestersId);
            companyDao.deleteById(greyMatterId);
        } catch (Exception e){

        }
    }
}