package com.csi.controller;

import com.csi.model.Employee;
import com.csi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/signup")
    public String signUp(@RequestBody Employee employee){
        employeeService.signUp(employee);
        return "Employee SignUp Successfully";
    }
    @GetMapping("/signin/{empEmailId}/{empPassword}")
    public boolean signIn(@PathVariable String empEmailId,String empPassword){
       return employeeService.signIn(empEmailId,empPassword);

    }
    @GetMapping("/getalldata")
    public List<Employee> getAllData(){
        return employeeService.getAllData();
    }
    @GetMapping("/getdatabyempid/{empId}")
    public Employee getDataById(@PathVariable int empId ){
        return employeeService.getDataById(empId);
    }
    @GetMapping("/getdatabyempname")
    public Employee getDataByName(@PathVariable String  empName){
        return employeeService.getDataByName(empName);
    }
    @PostMapping("/savealldata")
    public String saveAllData(@RequestBody List<Employee> employees){
        employeeService.saveAllData(employees);

        return "All data save successfully";
    }
    @PutMapping("/updatedata/{empId}")
    public String updateData(@PathVariable int empId, @RequestBody Employee employee){
        employeeService.updateData(empId,employee);
        return "Data updated";
    }
    @DeleteMapping("/deletedata/{empId}")
    public String deleteData(@PathVariable int empId)
    {
  employeeService.deleteData(empId);
  return  "data deleted";
    }
    @DeleteMapping("/deletealldata")
    public String deleteAllData(){
        employeeService.deleteAllData();
        return "All Data Deleted";
    }
}
