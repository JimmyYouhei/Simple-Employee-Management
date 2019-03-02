/*
 * MIT License
 *
 * Copyright (c) 2019. Jimmy Youhei (Quan Nguyen)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro192xa3.ui;

import pro192xa3.Interface.Degree;
import pro192xa3.Interface.GetInput;
import pro192xa3.Interface.Position;
import pro192xa3.business.AllowanceCalulator;
import pro192xa3.business.EmployeeManagement;
import pro192xa3.entity.Employee;
import pro192xa3.entity.Staff;
import pro192xa3.entity.Teacher;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author hp
 */
public class PRO192xA3 {

    //create an employee by inputing it's attribute values from keyboard
    // also add exception handle
    static Employee createNewImployee() {
        System.out.print("Do you want to create a Staff or a Teacher (enter S for Staff, otherwise for Teacher)?");
        //accept Staff or Teacher details from keyboard
        Scanner scan = new Scanner(System.in);
        String choice = scan.nextLine();
        if (choice.equalsIgnoreCase("s")) {
            Staff s = new Staff();
            //input staff details
            //your code
            try {
                s.setFullName(GetInput.getString("Name: "));
                s.setSalaryRatio(GetInput.getFloat("Salary ratio: "));
                s.setDepartment(GetInput.getString("Department: "));
                s.setPosition(Position.getPosition());
                s.setNoOfWorkingDay(GetInput.getInt("Number of working days: "));
            } catch (Exception e) {
                System.out.println(e);
            }
            return s;

        } else {
            Teacher t = new Teacher();
            //inputs Teacher details
            //your code
            try {
                t.setFullName(GetInput.getString("Name: "));
                t.setSalaryRatio(GetInput.getFloat("Salary ratio: "));
                t.setFaculty(GetInput.getString("Faculty:"));
                t.setDegree(Degree.getDegree());
                t.setTeachingHours(GetInput.getInt("Number of teaching hours: "));
            } catch (Exception e) {
                System.out.println(e);
            }
            return t;
        }

    }

    //display a list of employee
    static void display(ArrayList<Employee> listE) {
        System.out.println("Results:");
        System.out.println("Name, Fac/Dept, Deg/Pos, Sal Ratio, Allowance, T.Hours/W.Days, Salary");
        for (Employee e : listE) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        // create employee management object
        EmployeeManagement empMan = new EmployeeManagement();
        //menu
        Scanner scan = new Scanner(System.in);
        boolean keepRunning = true;
        //read from file (if any)
        empMan.readFromFile("data.txt");
        while (keepRunning) {
            System.out.println("University Staff Management 1.0");
            System.out.println("\t1.Add staff");
            System.out.println("\t2.Search staff by name");
            System.out.println("\t3.Search staff by department/faculty");
            System.out.println("\t4.Display all staff");
            System.out.println("\t5.Exit");
            System.out.println("\t6.Bonus: change employee details by name ");
            System.out.println("\t7.Bonus: change employee details by department/faculty");
            System.out.print("Select function (1,2,3,4 , 5 or 6 or 7): ");
            int choice = scan.nextInt();
            switch (choice) {
                case 1://add staff/teacher    
                    Employee emp = createNewImployee();
                    float allowance = AllowanceCalulator.calculateAllowance(emp);
                    emp.setAllowance(allowance);
                    empMan.addEmployee(emp);
                    empMan.writeToFile("PRO192xA3 - Skeleton/data.txt");
                    break;
                case 2://search by name                    
                    System.out.print("\tEnter name to search: ");
                    scan = new Scanner(System.in);
                    String name = scan.nextLine();
                    ArrayList<Employee> foundByName = empMan.searchByName(name);
                    display(foundByName);
                    break;
                case 3://search by dept
                    System.out.print("\tEnter dept/fac to search: ");
                    scan = new Scanner(System.in);
                    String dept = scan.nextLine();
                    ArrayList<Employee> foundByDept = empMan.searchByDept(dept);
                    display(foundByDept);
                    break;
                case 4://display all
                    ArrayList<Employee> listE = empMan.listAll();
                    display(listE);
                    break;
                case 5://exit
                    keepRunning = false;
                    break;
                // Find employee by name
                case 6:
                    // name of the employee??
                    String nameOfEmployee = GetInput.getString("Please input the name of the Employee " +
                            "you want to change: ");
                    // list of employee same name
                    ArrayList<Employee> nameToChangeArray = empMan.searchByName(nameOfEmployee);
                    try {
                        // if no employee found throw exception
                        if (nameToChangeArray.size() == 0){
                            throw new Exception("error name not found");
                        // if 1 employee found
                        } else if(nameToChangeArray.size() ==1 ){
                            //display the detail of the employee
                            System.out.println("only 1 found please see the detail below:");
                            display(nameToChangeArray);
                            //ask want to change or not?
                            String toChangeOrNotToChange = GetInput.getString("Is this the employee you want to " +
                                    "change?(Y for Yes , N for no):");
                            // if yes ask for new detail and replace old detail
                            if (toChangeOrNotToChange.equalsIgnoreCase("y")){
                                System.out.println("please input the new info below:");
                                Employee changedEmployee = createNewImployee();
                                float newAllowance = AllowanceCalulator.calculateAllowance(changedEmployee);
                                changedEmployee.setAllowance(newAllowance);
                                empMan.replaceEmployee(empMan.indexOfEmployee(nameToChangeArray.get(0)), changedEmployee);
                                empMan.writeToFile("PRO192xA3 - Skeleton/data.txt");
                            // if no escape
                            } else if (toChangeOrNotToChange.equalsIgnoreCase("n")){
                                break;
                            // if type wrong (not N or Y) throw exception
                            } else{
                                throw new Exception("please only input Y or N");
                            }
                        //if more than 1 are found
                        } else {
                            // display all were found
                            System.out.println("several name match please see the detail below:");
                            display(nameToChangeArray);
                            //ask for department
                            String whatDepartment = GetInput.getString("Please input the Department or " +
                                    "Faculty");
                            // make the details found above become EmployeeManagement list to use search easily
                            EmployeeManagement lastArray = new EmployeeManagement();
                            for (Employee anEmployee:nameToChangeArray){
                                lastArray.addEmployee(anEmployee);
                            }
                            // find employee
                            ArrayList<Employee> lastFind = lastArray.searchByDept(whatDepartment);
                            // if no found throw exception
                            if (lastFind.size()==0){
                                throw new Exception("no Employee like that");
                            // if 1 found
                            } else if (lastFind.size() == 1){
                                // display the detail
                                System.out.println("only 1 found please see the detail below:");
                                display(lastFind);
                                // ask if want to change or not?
                                String toChangeOrNotTochange = GetInput.getString("Is this the employee you want to " +
                                        "change?(Y for Yes , N for no):");
                                // if want to change ask for new detail and replace the old detail
                                if (toChangeOrNotTochange.equalsIgnoreCase("y")){
                                    System.out.println("please input the new info below:");
                                    Employee changedEmployee = createNewImployee();
                                    float newAllowance = AllowanceCalulator.calculateAllowance(changedEmployee);
                                    changedEmployee.setAllowance(newAllowance);
                                    empMan.replaceEmployee(empMan.indexOfEmployee(lastFind.get(0)), changedEmployee);
                                    empMan.writeToFile("PRO192xA3 - Skeleton/data.txt");
                                // if dont want to change escape
                                } else if (toChangeOrNotTochange.equalsIgnoreCase("n")){
                                    break;
                                // wrong typo (Not N or Y) throw exception
                                } else{
                                    throw new Exception("please only input Y or N");
                                }
                            // if more than 1 still found throw duplicate exception
                            } else {
                                throw new Exception("duplicate found;");
                            }
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                //search by Department/faculty at first expect several found at first
                case 7:
                    try {
                        // ask for the department
                        String whatDepartment = GetInput.getString("Please input the employee " +
                                "department/faculty: ");
                        ArrayList<Employee> foundByThisDepartment = empMan.searchByDept(whatDepartment);
                        //if no employee found throw exception
                        if (foundByThisDepartment.size() ==0){
                            throw new Exception("error no employee found by this department/faculty");
                        // if only 1 employee found
                        } else if (foundByThisDepartment.size() ==1){
                            //display the employee detail
                            System.out.println("only 1 employee found please see the detail below: ");
                            display(foundByThisDepartment);
                            // ask if want to change or not
                            String toChangeOrNotToChange = GetInput.getString("is this the employee you " +
                                    "wish to change? Y for yes and N for no");
                            // if yes ask for new detail and replace the old detail
                            if (toChangeOrNotToChange.equalsIgnoreCase("y")){
                                System.out.println("please input the new info below:");
                                Employee changedEmployee = createNewImployee();
                                float newAllowance = AllowanceCalulator.calculateAllowance(changedEmployee);
                                changedEmployee.setAllowance(newAllowance);
                                empMan.replaceEmployee(empMan.indexOfEmployee(foundByThisDepartment.get(0)), changedEmployee);
                                empMan.writeToFile("PRO192xA3 - Skeleton/data.txt");
                            // if no escape
                            } else if (toChangeOrNotToChange.equalsIgnoreCase("n")){
                                break;
                            // typo error(not Y or N) throw exception
                            } else{
                                throw new Exception("please only input Y or N");
                            }
                        // if several employees found
                        } else{
                            // display those employee
                            System.out.println("several employee found please check the detail: ");
                            display(foundByThisDepartment);
                            // ask for the name of the employee
                            String nameToChange = GetInput.getString("Please input the name of the " +
                                    "employee");
                            // make found arraylist become EmployeeManagement to use search easily
                            EmployeeManagement lastFind = new EmployeeManagement();
                            for(Employee e: foundByThisDepartment){
                                lastFind.addEmployee(e);
                            }
                            // search
                            ArrayList<Employee> lastFindArray = lastFind.searchByName(nameToChange);
                            // if no found throw new exception
                            if (lastFindArray.size() ==0){
                                throw new Exception("No Employee found");
                            // if only 1 found
                            } if (lastFindArray.size() ==1){
                                // display employee detail
                                System.out.println("1 employee found please see the detail below:");
                                display(lastFindArray);
                                // ask change or not?
                                String toChangeOrNotToChange = GetInput.getString("is this the employee you " +
                                        "wish to change? Y for yes and N for no");
                                // if yes ask for new detail and replace the old employee detail
                                if (toChangeOrNotToChange.equalsIgnoreCase("y")){
                                    System.out.println("please input the new info below:");
                                    Employee changedEmployee = createNewImployee();
                                    float newAllowance = AllowanceCalulator.calculateAllowance(changedEmployee);
                                    changedEmployee.setAllowance(newAllowance);
                                    empMan.replaceEmployee(empMan.indexOfEmployee(lastFindArray.get(0)), changedEmployee);
                                    empMan.writeToFile("PRO192xA3 - Skeleton/data.txt");
                                // if no escape
                                } else if (toChangeOrNotToChange.equalsIgnoreCase("n")){
                                    break;
                                // wrong typo (not Y or N)
                                } else{
                                    throw new Exception("please only input Y or N");
                                }
                            // if several employee are still found throw duplicate error
                            } else {
                                throw new Exception("duplicate found");
                            }
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
            }
        }
    }
}
