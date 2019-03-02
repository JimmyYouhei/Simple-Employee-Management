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

/**
 *
 * @author hp
 */
public class AllowanceCalulator {
     /*
    for teacher:
    bachelor/cử nhân 300
    master/thạc sĩ 500
    doctor/tiến sĩ 1000
    
    for staff:
    head/trưởng phòng 2000
    vice-head/phó phòng 1000
    staff/nhân viên 500
    */
    public static float calculateAllowance(Employee emp){        
        float allowance=0;
        if(emp instanceof Staff){
            Staff s = (Staff) emp;
            //head/trưởng phòng 2000
            if(s.getPosition()==EPosition.HEAD) allowance = 2000;
            
            //vice-head/phó phòng 1000
            //your code
            if(s.getPosition()==EPosition.VICE_HEAD) allowance = 1000;
            
            //staff/nhân viên 500  
            //your code
            if(s.getPosition() == EPosition.STAFF) allowance = 500;
            
        }
        if(emp instanceof Teacher){
            Teacher t = (Teacher) emp;
           //your code
            if(t.getDegree() == EDegree.DOCTOR) allowance = 1000;

            if (t.getDegree() == EDegree.MASTER) allowance = 500;

            if (t.getDegree() == EDegree.BACHELOR) allowance = 300;
        }
        return allowance;
    }
}
