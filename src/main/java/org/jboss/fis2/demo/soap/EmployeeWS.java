package org.jboss.fis2.demo.soap;

import java.util.List;

public interface EmployeeWS {

	public Employee addEmployee(Employee employee);
	public Employee getEmployee(Integer id);
	public EmployeeList getEmployeeAll();
	public EmployeeList getEmployeeList(String name);
	public EmployeeList addEmployeeBulk(EmployeeList employeeList);
	
}
