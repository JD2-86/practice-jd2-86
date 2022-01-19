package by.zhigalko.hibernate.mapping.dal.dao;

import by.zhigalko.hibernate.mapping.dal.entity.Employee;

public class EmployeeDaoImpl extends BaseDaoImpl<Employee> {
    public EmployeeDaoImpl(){
        super(Employee.class);
    }
}
