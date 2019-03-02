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
package pro192xa3.business;

import pro192xa3.entity.*;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author hp
 */
public class EmployeeManagement {

    //store all staff/teacher
    ArrayList<Employee> listE;

    public EmployeeManagement() {        
        listE = new ArrayList<>();
    }

    public void addEmployee(Employee emp) {
        //add emp to listE
        //your code
        listE.add(emp);

    }

    //replace employee details
    public void replaceEmployee (int index , Employee newEmployee){
        listE.set(index , newEmployee);
    }

    //return the index of the employee
    public int indexOfEmployee(Employee theEmployee){
        return listE.indexOf(theEmployee);
    }

    //search by staff/teacher's name
    public ArrayList<Employee> searchByName(String name) {
        //store all matching staff or teacher
        ArrayList<Employee> empFound = new ArrayList<>();

        for(Employee aEmployee : listE){
            if(name.equalsIgnoreCase(aEmployee.getFullName())){
                empFound.add(aEmployee);
            }
        }
        //your code
        return empFound;
    }
    //search by staff/teacher's department/faculty
    public ArrayList<Employee> searchByDept(String dept) {
        ArrayList<Employee> empFound = new ArrayList<>();
        //your code
        for (Employee aEmployee : listE){
            if (aEmployee instanceof Staff){
                if (dept.equalsIgnoreCase(((Staff) aEmployee).getDepartment())){
                    empFound.add(aEmployee);
                }
            } else if(aEmployee instanceof Teacher){
                if (dept.equalsIgnoreCase(((Teacher) aEmployee).getFaculty())){
                    empFound.add(aEmployee);
                }
            }
        }
        return empFound;
    }

    public ArrayList<Employee> listAll() {
        //sort the list of staff/teacher before return
        //        //your code
        Collections.sort(listE);
        return listE;
    }

    //write employee details to file
    public void writeToFile (String filePath) {
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for (Employee e : listE){
                // write Staff if the employee is a staff
                if (e instanceof Staff){
                    printWriter.print("Staff, ");
                    printWriter.println(e);
                    //write Teacher if the employee is a teacher
                } else {
                    printWriter.print("Teacher, ");
                    printWriter.println(e);
                }
            }
            printWriter.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    //Read old file
    public void readFromFile(String filePath){
        try{
            File file = new File(filePath);
            // if file not exist ask for old file path
            if(file.exists() == false){
                Scanner scanner = new Scanner(System.in);
                System.out.print("data.txt not found please input file location(type anything for none): ");
                filePath = scanner.next();
                file = new File(filePath);
                // if the file path still not exists throw exception
                if (file.exists() == false){
                    throw new Exception("*****Load data: data.txt file not found");
                }
            }
            //read file
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                // split the detail of the employee to read file
                String fileRead = scanner.nextLine();
                String[] stringArray = fileRead.split(", ");
                // create employee mold to add detail later
                Employee anEmployeeRead = new Employee() {
                    @Override
                    public float getSalary() {
                        return 0;
                    }
                };
                // add each detail to employee mold
                for (int i = 0; i < 8; i++) {
                    switch (i){
                        // Staff or Teacher?
                        case 0:
                            if (stringArray[i].equals("Staff")){
                                anEmployeeRead = new Staff();
                            }else if (stringArray[i].equals("Teacher")){
                                anEmployeeRead = new Teacher();
                            } else {
                               // wrong throw exception
                                throw new Exception("error , Employee type unrecognized ");
                            }
                            break;

                        //Name?
                        case 1:
                            anEmployeeRead.setFullName(stringArray[i]);
                            break;

                        //Department/Faculty?
                        case 2:
                            if (anEmployeeRead instanceof Staff){
                                ((Staff) anEmployeeRead).setDepartment(stringArray[i]);
                            } else if (anEmployeeRead instanceof Teacher){
                                ((Teacher) anEmployeeRead).setFaculty(stringArray[i]);
                            } else {
                                //wrong throw exception
                                throw new Exception("error , department/faculty unrecognized");
                            }
                            break;

                        //Position/Degree?
                        case 3:
                            if (anEmployeeRead instanceof Staff){
                                ((Staff) anEmployeeRead).setPosition(EPosition.valueOf(stringArray[i]));
                            }else if (anEmployeeRead instanceof Teacher){
                                ((Teacher) anEmployeeRead).setDegree(EDegree.valueOf(stringArray[i]));
                            } else {
                                // wrong throw exception
                                throw new Exception("error, Employee position/degree unrecognized");
                            }
                            break;

                        //Salary Ratio?
                        case 4:
                            anEmployeeRead.setSalaryRatio(Float.parseFloat(stringArray[i]));
                            break;

                        //Allowance?
                        case 5:
                            anEmployeeRead.setAllowance(Float.parseFloat(stringArray[i]));
                            // compare if the allowance is true???
                            if(anEmployeeRead.getAllowance() != AllowanceCalulator.calculateAllowance(anEmployeeRead)){
                                throw new Exception("error, allowance does not match");
                            }
                            break;

                        //working days/teaching hours?
                        case 6:
                            if (anEmployeeRead instanceof Staff){
                                ((Staff) anEmployeeRead).setNoOfWorkingDay(Float.parseFloat(stringArray[i]));
                            } else  if (anEmployeeRead instanceof Teacher){
                                ((Teacher) anEmployeeRead).setTeachingHours(Integer.parseInt(stringArray[i]));
                            } else{
                                // wrong throw exception
                                throw new Exception("error , working days/teaching hour unrecognized");
                            }
                            break;

                        //Salary?
                        case 7:
                            // check if ok
                            if(Float.parseFloat(stringArray[i]) != anEmployeeRead.getSalary()){
                                throw new Exception("error , Salary does not match");
                            }
                    }
                }
                listE.add(anEmployeeRead);
            }

        } catch (Exception e){
            System.out.println(e);
        }

    }


}
