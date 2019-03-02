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
public class Teacher extends Employee {

    private String faculty;//khoa
    private EDegree degree;//trình độ
    private int teachingHours;//số tiết dạy

    public Teacher() {
        float allowance = AllowanceCalulator.calculateAllowance((this));
        this.setAllowance(allowance);
    }

    //Quick constructor for test
    public Teacher(String name , String faculty, String degree , float salaryRatio , int teachingHours){
        this.setFullName(name);
        this.setFaculty(faculty);
        this.setDegree(EDegree.valueOf(degree));
        this.setSalaryRatio(salaryRatio);
        this.setTeachingHours(teachingHours);
        float allowance = AllowanceCalulator.calculateAllowance((this));
        this.setAllowance(allowance);
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public EDegree getDegree() {
        return degree;
    }

    public void setDegree(EDegree degree) {
        this.degree = degree;
    }

    public int getTeachingHours() {
        return teachingHours;
    }

    public void setTeachingHours(int teachingHours) {
        this.teachingHours = teachingHours;
    }
    //sal=Hệ số lương*730+phụ cấp+số tiết dạy*45.
    @Override
    public float getSalary() {
        float sal;
        sal = this.getSalaryRatio() * 730 + this.getAllowance() + this.teachingHours * 45;
        return sal;
    }
    @Override
    public String toString(){
        return  this.getFullName()+", "+
                this.getFaculty()+", "+
                this.getDegree()+", "+
                this.getSalaryRatio()+", "+
                this.getAllowance()+", "+
                this.getTeachingHours()+", "+
                this.getSalary();                
    }

}
