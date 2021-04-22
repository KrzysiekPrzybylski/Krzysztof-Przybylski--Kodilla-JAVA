package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Facade {

    private final CompanyDao companyDao;
    private final EmployeeDao employeeDao;

    @Autowired
    public Facade(CompanyDao companyDao, EmployeeDao employeeDao) {
        this.companyDao = companyDao;
        this.employeeDao = employeeDao;
    }

    public List<Company> searchingCompany(String pieceOfCompanyName) {
        return companyDao.retrieveCompanyNameLike(PartOfTheWord.word(pieceOfCompanyName));
    }
    public List<Employee> saerchingEmployee(String pieceofEmployeeName) {
        return employeeDao.retrieveEmployeesByLastnamePiece(PartOfTheWord.word(pieceofEmployeeName));
    }
}
