package com.csi.dao;

import com.csi.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmploeeDaoImpl implements EmployeeDao{

    private static SessionFactory factory= new AnnotationConfiguration().configure().buildSessionFactory();

    @Override
    public void signUp(Employee employee) {
        Session session= factory.openSession();

        Transaction transaction= session.beginTransaction();

        session.save(employee);
        transaction.commit();

    }

    @Override
    public boolean signIn(String empEmailId, String empPassword) {
        boolean flag= false;

        Session session= factory.openSession();
        List<Employee> empList= session.createQuery("from Employee").list();
        for (Employee employee : empList){
            if(employee.getEmpEmailId().equals(empEmailId) && employee.getEmpPassword().equals(empPassword) )
            {
                flag =true;
            }
        }
        return flag;
    }

    @Override
    public void saveAllData(List<Employee> employees) {
        Session session=factory.openSession();
        for (Employee e: employees)
        {
            Transaction transaction=session.beginTransaction();
            session.save(e);
            transaction.commit();
        }

    }

    @Override
    public List<Employee> getAllData() {
        Session session= factory.openSession();
        List<Employee> employeeList=session.createQuery("from Employee").list();
        return employeeList;
    }

    @Override
    public Employee getDataById(int empId) {
        Session session= factory.openSession();
        Employee e1= (Employee) session.get(Employee.class,empId);
        return e1;
    }

    @Override
    public Employee getDataByName(String empName) {
        Session session= factory.openSession();
        Employee e1= (Employee) session.get(Employee.class,empName);
        return e1;
    }

    @Override
    public void updateData(int empId, Employee employee) {
        Session session= factory.openSession();
        Transaction transaction= session.beginTransaction();

        Employee employee1= (Employee) session.get(Employee.class, empId);
        if(employee1.getEmpId()==empId)
        {
            employee1.setEmpName(employee.getEmpName());
            employee1.setEmpAddress(employee.getEmpAddress());
            employee1.setEmpSalary(employee.getEmpSalary());
            employee1.setEmpDOB(employee.getEmpDOB());
            employee1.setEmpEmailId(employee.getEmpEmailId());
            employee1.setEmpPassword(employee.getEmpPassword());

            session.save(employee1);
            transaction.commit();
        }


    }

    @Override
    public void deleteData(int empId) {
        Session session= factory.openSession();
        Transaction transaction= session.beginTransaction();

        Employee employee1= (Employee) session.get(Employee.class, empId);
        if(employee1.getEmpId()==empId)
        {
            session.save(employee1);
            transaction.commit();
        }

    }

    @Override
    public void deleteAllData() {

        Session session= factory.openSession();

        List<Employee> employeeList= session.createQuery("fromEmployee").list();
        for (Employee e2: employeeList){
            Transaction transaction= session.beginTransaction();
            session.delete(e2);
            transaction.commit();
        }
    }
}
