package com.targetindia.programs;

import com.targetindia.entity.Employee;
import com.targetindia.exceptions.BlankNameException;
import com.targetindia.exceptions.InvalidIdException;
import com.targetindia.exceptions.LowSalaryException;
import com.targetindia.exceptions.NullNameException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreateEmployee {
    public static void main(String[] args) {

        Employee e1;

        e1 = new Employee();

        try {
            e1.setId(30);
            e1.setName("Kishore");
            e1.setSalary(45000);

            log.trace("e1 = {}", e1);
        }
        catch (LowSalaryException e){
            log.warn("Salary was low");
        }
        catch(NullNameException e){
            log.warn("Name was null");
        }
        catch (BlankNameException e){
            log.warn("Name was blank");
        }
        catch (InvalidIdException e){
            log.warn("Invalid id");
        }


    }
}
