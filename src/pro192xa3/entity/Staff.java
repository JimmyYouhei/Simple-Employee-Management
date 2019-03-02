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
package pro192xa3.entity;

import pro192xa3.business.AllowanceCalulator;

/**
 *
 * @author hp
 */
public class Staff extends Employee{
    private String department;
    private float noOfWorkingDay;//số ngày công
    private EPosition position;//chức vụ    

    public Staff() {
         
    }

    //Quick constructor for test
    public Staff(String name, String department, String position, float salaryRatio , float noOfWorkingDay){
        this.setFullName(name);
        this.setDepartment(department);
        this.setPosition(EPosition.valueOf(position));
        this.setSalaryRatio(salaryRatio);
        this.setNoOfWorkingDay(noOfWorkingDay);
        float allowance = AllowanceCalulator.calculateAllowance(this);
        this.setAllowance(allowance);

    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public float getNoOfWorkingDay() {
        return noOfWorkingDay;
    }

    public void setNoOfWorkingDay(float noOfWorkingDay) {
        this.noOfWorkingDay = noOfWorkingDay;
    }

    public EPosition getPosition() {
        return position;
    }

    public void setPosition(EPosition position) {
        this.position = position;       
    }
    //sal=Hệ số lương*730+phụ cấp+số ngày công*30;
    @Override
    public float getSalary() {
        float sal;     
        sal = this.getSalaryRatio()*730 +this.getAllowance()+this.noOfWorkingDay*30;
        return sal;
    }
    
    @Override
    public String toString(){
        return this.getFullName()+", "+
                this.getDepartment()+", "+
                this.getPosition()+", "+
                this.getSalaryRatio()+", "+
                this.getAllowance()+", "+
                this.getNoOfWorkingDay()+", "+
                this.getSalary();     
              
    }
    
}
