package pro192xa3.ui;

import pro192xa3.business.EmployeeManagement;
import pro192xa3.entity.Staff;
import pro192xa3.entity.Teacher;
/*
This is to quickly print an data.txt file for test.Please use it for test purpose only otherwise dont run it
 */

public class PrintFileForTest {
    public static void main(String[] args) {
        EmployeeManagement employeeListTest = new EmployeeManagement();

        Staff firstStaffTest = new Staff("Nguyen Hong Quan", "IT", "HEAD", (float) 3.5, 22);
        Staff secondStaffTest = new Staff("Bui Tran Quang", "Marketing", "VICE_HEAD", (float) 22.4, 24);
        Staff thirdStaffTest = new Staff("Dao Tieu Dao", "PR", "STAFF", (float) 4.5, 28);
        Teacher firstTeacherTest = new Teacher("Mai Nhu Thao", "Eng", "BACHELOR", (float) 22.4, 300);
        Teacher secondTeacherTest = new Teacher("Dang Thao Mai", "History", "MASTER", (float) 10.4, 250);
        Teacher thirdTeacherTest = new Teacher("Luu Binh Dang", "Math", "DOCTOR", (float) 13.5, 200);
        Staff sameDepartTestItViceHead = new Staff("Dao Dao Dao" , "IT", "VICE_HEAD" , 4.1f , 24);
        Staff sameDepartTestItStaff = new Staff("Khai Hoan Hoa" , "IT", "STAFF", 12.4f , 27);
        Teacher sameFacultyTestEngDoctor = new Teacher("Lo Song Hau" , "Eng" , "DOCTOR", 16.5f , 150);
        Teacher sameFacultyTestEngMaster = new Teacher("Mu Binh Dang" , "Eng" , "MASTER" , 18.2f , 225);
        Staff sameNameButDifferentDepartment = new Staff("Nguyen Hong Quan" , "Marketing" , "HEAD" , 25.0f , 15);
        Teacher sameNameButDifferentFaculty = new Teacher("Mai Nhu Thao" , "Math", "BACHELOR" , 41f ,300);

        employeeListTest.addEmployee(firstStaffTest);
        employeeListTest.addEmployee(secondStaffTest);
        employeeListTest.addEmployee(thirdStaffTest);
        employeeListTest.addEmployee(firstTeacherTest);
        employeeListTest.addEmployee(secondTeacherTest);
        employeeListTest.addEmployee(thirdTeacherTest);
        employeeListTest.addEmployee(sameDepartTestItStaff);
        employeeListTest.addEmployee(sameDepartTestItViceHead);
        employeeListTest.addEmployee(sameFacultyTestEngDoctor);
        employeeListTest.addEmployee(sameFacultyTestEngMaster);
        employeeListTest.addEmployee(sameNameButDifferentDepartment);
        employeeListTest.addEmployee(sameNameButDifferentFaculty);

        
        employeeListTest.writeToFile("PRO192xA3 - Skeleton/data.txt");
    }
}
