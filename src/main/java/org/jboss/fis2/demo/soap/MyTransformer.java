/*
 * Copyright 2016 Red Hat, Inc.
 * <p>
 * Red Hat licenses this file to you under the Apache License, version
 * 2.0 (the "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.  See the License for the specific language governing
 * permissions and limitations under the License.
 *
 */
package org.jboss.fis2.demo.soap;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Body;
import org.apache.camel.ExchangeProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * A sample transform
 */
@Component(value = "myTransformer")
public class MyTransformer {
	
	Logger LOGGER = LoggerFactory.getLogger(MyTransformer.class);

    public String transform() {
        // lets return a random string
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 3; i++) {
            int number = (int) (Math.round(Math.random() * 1000) % 10);
            char letter = (char) ('0' + number);
            buffer.append(letter);
        }
        return buffer.toString();
    }
    
    public void putPhoneList(
    		@ExchangeProperty(value="employee") Employee employee,
    		@Body List<Phone> phoneList
    		) {
    	
    	LOGGER.info(""+(employee == null));
    	LOGGER.info(""+(phoneList == null));
    	employee.setPhoneList(phoneList);
    }
    
    public EmployeeList createEmployeeList(
    		) {
    	EmployeeList eList = new EmployeeList();
    	return eList;
    }
    
    public void putEmployeeList(
    		@ExchangeProperty(value="employeeList") EmployeeList employeelist,
    		@Body List<Employee> employeeL
    		
    		) {
    	employeelist.setEmployeeList(employeeL);
    }
    
    public List<Employee> dummyEmployeeList(
    		) {
    	
    	List<Employee> employeeList = new ArrayList<Employee>();
    	Employee emp = new Employee();
    	emp.setId(4);
    	emp.setName("aditya");
    	employeeList.add(emp);
    	return employeeList;
    }

}
