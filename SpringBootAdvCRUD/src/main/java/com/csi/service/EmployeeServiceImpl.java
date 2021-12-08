package com.csi.service;

import com.csi.dao.EmployeeDao;
import com.csi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeDao employeeDao;

    @Override
    public void signUp(Employee employee) {
        employeeDao.signUp(employee);

    }

    @Override
    public boolean signIn(String empEmailId, String empPassword) {
        return employeeDao.signIn(empEmailId,empPassword);
    }

    @Override
    public void saveAllData(List<Employee> employees) {
        employeeDao.saveAllData(employees);

    }

    @Override
    public List<Employee> getAllData() {
        return employeeDao.getAllData();
    }

    @Override
    public Employee getDataById(int empId) {
        return employeeDao.getDataById(empId);
    }

    @Override
    public Employee getDataByName(String empName) {
        return employeeDao.getDataByName(empName);
    }

    @Override
    public void updateData(int empId, Employee employee) {

        employeeDao.updateData(empId,employee);
    }

    @Override
    public void deleteData(int empId) {
        employeeDao.deleteData(empId);

    }

    @Override
    public void deleteAllData() {
        employeeDao.deleteAllData();

    }
}
