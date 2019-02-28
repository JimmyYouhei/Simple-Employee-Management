package pro192xa3.ui;

import org.junit.Test;
import pro192xa3.business.EmployeeManagement;
import pro192xa3.entity.Staff;
import pro192xa3.entity.Teacher;

import static org.junit.Assert.assertEquals;

public class PRO192xA3Test {

        private EmployeeManagement employeeListTest = new EmployeeManagement();

        private Staff firstStaffTest = new Staff("Nguyen Hong Quan", "IT", "HEAD", (float) 3.5, 22);
        private Staff secondStaffTest = new Staff("Bui Tran Quang", "Marketing", "VICE_HEAD", (float) 22.4, 24);
        private Staff thirdStaffTest = new Staff("Dao Tieu Dao", "PR", "STAFF", (float) 4.5, 28);
        private Teacher firstTeacherTest = new Teacher("Mai Nhu Thao", "Eng", "BACHELOR", (float) 22.4, 300);
        private Teacher secondTeacherTest = new Teacher("Dang Thao Mai", "History", "MASTER", (float) 10.4, 250);
        private Teacher thirdTeacherTest = new Teacher("Luu Binh Dang", "Math", "DOCTOR", (float) 13.5, 200);
        private Staff sameDepartTestItViceHead = new Staff("Dao Dao Dao" , "IT", "VICE_HEAD" , 4.1f , 24);
        private Staff sameDepartTestItStaff = new Staff("Khai Hoan Hoa" , "IT", "STAFF", 12.4f , 27);
        private Teacher sameFacultyTestEngDoctor = new Teacher("Lo Song Hau" , "Eng" , "DOCTOR", 16.5f , 150);
        private Teacher sameFacultyTestEngMaster = new Teacher("Mu Binh Dang" , "Eng" , "MASTER" , 18.2f , 225);
        private Staff sameNameButDifferentDepartment = new Staff("Nguyen Hong Quan" , "Marketing" , "HEAD" , 25.0f , 15);
        private Teacher sameNameButDifferentFaculty = new Teacher("Mai Nhu Thao" , "Math", "BACHELOR" , 41f ,300);

    /*
    Test to ensure the right method was used . Due to name and department/faculty play no role in the test so only each
    case of the position/degree was test
    Note: somehow the project 4 description tell about the teaching Periods *45 instead of teaching Hours * 45 . However
    due to the calculation already used in project 3 used teaching Hours so I just went with the wind here
     */
        @Test
    public void testSalaryByMethod() throws Exception{
            // test HEAD position
            assertEquals(  firstStaffTest.getSalaryRatio()*730+firstStaffTest.getAllowance()+
                            firstStaffTest.getNoOfWorkingDay()*30 ,
                    firstStaffTest.getSalary() , 0.0f);
            // test VICE_HEAD position
            assertEquals(secondStaffTest.getSalaryRatio()*730 + secondStaffTest.getAllowance()+
                    secondStaffTest.getNoOfWorkingDay()*30 ,
                    secondStaffTest.getSalary(), 0.0f);
            // test STAFF position
            assertEquals(thirdStaffTest.getSalaryRatio()*730 + thirdStaffTest.getAllowance()+
                    thirdStaffTest.getNoOfWorkingDay()*30 ,
                    thirdStaffTest.getSalary(),0.0f);
            // test BACHELOR degree
            assertEquals(firstTeacherTest.getSalaryRatio()*730 + firstTeacherTest.getAllowance() +
            firstTeacherTest.getTeachingHours()*45 , firstTeacherTest.getSalary() , 0.0f);
            // test MASTER degree
            assertEquals(secondTeacherTest.getSalaryRatio()*730 + secondTeacherTest.getAllowance() +
            secondTeacherTest.getTeachingHours()*45 , secondTeacherTest.getSalary() , 0.0f);
            // test DOCTOR degree
            assertEquals(thirdTeacherTest.getSalaryRatio()*730 + thirdTeacherTest.getAllowance() +
            thirdTeacherTest.getTeachingHours()*45 , thirdTeacherTest.getSalary() , 0.0f);
        }

        /*
        same test as above but this time with number already calculated
         */
        @Test
    public void tesSalaryByNumber() throws Exception{
                //test HEAD
                assertEquals(5215f, firstStaffTest.getSalary() , 0.0f);
                //test VICE_HEAD
                assertEquals(18072f,secondStaffTest.getSalary(), 0.0f);
                //test STAFF
                assertEquals(4625f , thirdStaffTest.getSalary(), 0.0f);
                //test BACHELOR
                assertEquals(30152f , firstTeacherTest.getSalary() , 0.0f);
                // test MASTER
                assertEquals(19342f , secondTeacherTest.getSalary(), 0.0f);
                // test DOCTOR
                assertEquals(19855, thirdTeacherTest.getSalary(), 0.0f);
        }

        /*
        test searchByName to ensure the right method
        due to only name matter so the test condition that two people have the same name but different department/faculty
        is considered in these tests however it is quite rare. Also just to make sure all of the Enum also included in
        the test
        for the case of two people with same name and same department/faculty , this case will be considered as
        duplication so it will not be tested
         */
        @Test
        public void testSearchNameMethod() throws Exception{
                // add employee to make complete list
                employeeListTest.addEmployee(firstStaffTest);
                employeeListTest.addEmployee(secondStaffTest);
                employeeListTest.addEmployee(thirdStaffTest);
                employeeListTest.addEmployee(firstTeacherTest);
                employeeListTest.addEmployee(secondTeacherTest);
                employeeListTest.addEmployee(thirdTeacherTest);
                employeeListTest.addEmployee(sameNameButDifferentDepartment);
                employeeListTest.addEmployee(sameNameButDifferentFaculty);

                //test for 2 people with the same name but different department
                assertEquals( firstStaffTest.getFullName() ,
                        employeeListTest.searchByName(firstStaffTest.getFullName()).get(0).getFullName());

                assertEquals(firstStaffTest.getFullName() ,
                        employeeListTest.searchByName(firstStaffTest.getFullName()).get(1).getFullName());

                assertEquals(sameNameButDifferentDepartment.getFullName() ,
                        employeeListTest.searchByName(sameNameButDifferentDepartment.getFullName()).get(0).getFullName());

                assertEquals(sameNameButDifferentDepartment.getFullName(),
                        employeeListTest.searchByName(sameNameButDifferentDepartment.getFullName()).get(1).getFullName());

                //test Staff extra VICE_HEAD
                assertEquals(secondStaffTest.getFullName() ,
                        employeeListTest.searchByName(secondStaffTest.getFullName()).get(0).getFullName());

                //test Staff extra STAFF
                assertEquals(thirdStaffTest.getFullName() ,
                        employeeListTest.searchByName(thirdStaffTest.getFullName()).get(0).getFullName());

                // test Teacher with same name but different faculty
                assertEquals(firstTeacherTest.getFullName() ,
                        employeeListTest.searchByName(firstTeacherTest.getFullName()).get(0).getFullName());

                assertEquals(firstTeacherTest.getFullName(),
                        employeeListTest.searchByName(firstTeacherTest.getFullName()).get(1).getFullName());

                assertEquals(sameNameButDifferentFaculty.getFullName() ,
                        employeeListTest.searchByName(sameNameButDifferentFaculty.getFullName()).get(0).getFullName());

                assertEquals(sameNameButDifferentFaculty.getFullName(),
                        employeeListTest.searchByName(sameNameButDifferentFaculty.getFullName()).get(1).getFullName());

                // test Teacher extra MASTER
                assertEquals(secondTeacherTest.getFullName() ,
                        employeeListTest.searchByName(secondTeacherTest.getFullName()).get(0).getFullName());

                //test Teacher extra DOCTOR
                assertEquals(thirdTeacherTest.getFullName() ,
                        employeeListTest.searchByName(thirdTeacherTest.getFullName()).get(0).getFullName());

        }


        /*
        this is the same with above with the String name to ensure right value
         */
        @Test
        public void testSearchNameExactName() throws Exception {
                employeeListTest.addEmployee(firstStaffTest);
                employeeListTest.addEmployee(secondStaffTest);
                employeeListTest.addEmployee(thirdStaffTest);
                employeeListTest.addEmployee(firstTeacherTest);
                employeeListTest.addEmployee(secondTeacherTest);
                employeeListTest.addEmployee(thirdTeacherTest);
                employeeListTest.addEmployee(sameNameButDifferentDepartment);
                employeeListTest.addEmployee(sameNameButDifferentFaculty);


                //test for 2 people with same name but different department
                assertEquals("Nguyen Hong Quan" ,
                        employeeListTest.searchByName("Nguyen Hong Quan").get(0).getFullName());
                assertEquals("Nguyen Hong Quan" ,
                        employeeListTest.searchByName("Nguyen Hong Quan").get(0).getFullName());
                //test Staff extra VICE_HEAD
                assertEquals("Bui Tran Quang" ,
                        employeeListTest.searchByName("Bui Tran Quang").get(0).getFullName());
                //test Staff extra STAFF
                assertEquals("Dao Tieu Dao" ,
                        employeeListTest.searchByName("Dao Tieu Dao").get(0).getFullName());
                //test for 2 people with same name but different faculty
                assertEquals("Mai Nhu Thao" ,
                        employeeListTest.searchByName("Mai Nhu Thao").get(0).getFullName());
                assertEquals("Mai Nhu Thao" ,
                        employeeListTest.searchByName("Mai Nhu Thao").get(0).getFullName());
                // test Teacher extra MASTER
                assertEquals("Dang Thao Mai",
                        employeeListTest.searchByName("Dang Thao Mai").get(0).getFullName());
                //test Teacher extra DOCTOR
                assertEquals("Luu Binh Dang" ,
                        employeeListTest.searchByName("Luu Binh Dang").get(0).getFullName());
        }

        /*
        The test will test the searchByDept to ensure the right method
        due to the department/faculty will be the most importance so most of the case there will be several people on
        a department/faculty . As a result to demonstrate that a department or a faculty with full position
        (a HEAD , a VICE_HEAD and a STAFF) or full degree (a BACHELOR , a MASTER and a DOCTOR) will be considered
        and test just to demonstrate that the search
        for people that have same name and department/faculty will be considered as duplicate and will not be test
         */
        @Test
        public void testSearchDeptMethod() throws Exception{
            employeeListTest.addEmployee(firstStaffTest);
            employeeListTest.addEmployee(secondStaffTest);
            employeeListTest.addEmployee(thirdStaffTest);
            employeeListTest.addEmployee(firstTeacherTest);
            employeeListTest.addEmployee(secondTeacherTest);
            employeeListTest.addEmployee(thirdTeacherTest);
            employeeListTest.addEmployee(sameDepartTestItViceHead);
            employeeListTest.addEmployee(sameDepartTestItStaff);
            employeeListTest.addEmployee(sameFacultyTestEngDoctor);
            employeeListTest.addEmployee(sameFacultyTestEngMaster);

            // test HEAD , VICE_HEAD and STAFF inside a same department

            assertEquals(firstStaffTest.getDepartment() ,
                    ((Staff)  employeeListTest.searchByDept(firstStaffTest.getDepartment()).get(0)).getDepartment());
            assertEquals(firstStaffTest.getDepartment() ,
                    ((Staff)  employeeListTest.searchByDept(firstStaffTest.getDepartment()).get(1)).getDepartment());
            assertEquals(firstStaffTest.getDepartment() ,
                    ((Staff)  employeeListTest.searchByDept(firstStaffTest.getDepartment()).get(2)).getDepartment());

            assertEquals(sameDepartTestItViceHead.getDepartment() ,
                    ((Staff)  employeeListTest.searchByDept(sameDepartTestItViceHead.getDepartment()).get(0)).getDepartment());
            assertEquals(sameDepartTestItViceHead.getDepartment() ,
                    ((Staff)  employeeListTest.searchByDept(sameDepartTestItViceHead.getDepartment()).get(1)).getDepartment());
            assertEquals(sameDepartTestItViceHead.getDepartment() ,
                    ((Staff)  employeeListTest.searchByDept(sameDepartTestItViceHead.getDepartment()).get(2)).getDepartment());

            assertEquals(sameDepartTestItStaff.getDepartment() ,
                    ((Staff)  employeeListTest.searchByDept(sameDepartTestItStaff.getDepartment()).get(0)).getDepartment());
            assertEquals(sameDepartTestItStaff.getDepartment() ,
                    ((Staff)  employeeListTest.searchByDept(sameDepartTestItStaff.getDepartment()).get(1)).getDepartment());
            assertEquals(sameDepartTestItStaff.getDepartment() ,
                    ((Staff)  employeeListTest.searchByDept(sameDepartTestItStaff.getDepartment()).get(2)).getDepartment());

            // test BACHELOR , MASTER and DOCTOR inside a same faculty
            assertEquals(firstTeacherTest.getFaculty() ,
                    ((Teacher) employeeListTest.searchByDept(firstTeacherTest.getFaculty()).get(0)).getFaculty());
            assertEquals(firstTeacherTest.getFaculty() ,
                    ((Teacher) employeeListTest.searchByDept(firstTeacherTest.getFaculty()).get(1)).getFaculty());
            assertEquals(firstTeacherTest.getFaculty() ,
                    ((Teacher) employeeListTest.searchByDept(firstTeacherTest.getFaculty()).get(2)).getFaculty());

            assertEquals(sameFacultyTestEngMaster.getFaculty() ,
                    ((Teacher) employeeListTest.searchByDept(sameFacultyTestEngMaster.getFaculty()).get(0)).getFaculty());
            assertEquals(sameFacultyTestEngMaster.getFaculty() ,
                    ((Teacher) employeeListTest.searchByDept(sameFacultyTestEngMaster.getFaculty()).get(1)).getFaculty());
            assertEquals(sameFacultyTestEngMaster.getFaculty() ,
                    ((Teacher) employeeListTest.searchByDept(sameFacultyTestEngMaster.getFaculty()).get(2)).getFaculty());

            assertEquals(sameFacultyTestEngDoctor.getFaculty() ,
                    ((Teacher) employeeListTest.searchByDept(sameFacultyTestEngDoctor.getFaculty()).get(0)).getFaculty());
            assertEquals(sameFacultyTestEngDoctor.getFaculty() ,
                    ((Teacher) employeeListTest.searchByDept(sameFacultyTestEngDoctor.getFaculty()).get(1)).getFaculty());
            assertEquals(sameFacultyTestEngDoctor.getFaculty() ,
                    ((Teacher) employeeListTest.searchByDept(sameFacultyTestEngDoctor.getFaculty()).get(2)).getFaculty());

            // test Staff extra
            assertEquals(secondStaffTest.getDepartment() ,
                    ((Staff)  employeeListTest.searchByDept(secondStaffTest.getDepartment()).get(0)).getDepartment());
            assertEquals(thirdStaffTest.getDepartment() ,
                    ((Staff)  employeeListTest.searchByDept(thirdStaffTest.getDepartment()).get(0)).getDepartment());

            //test Teacher extra:
            assertEquals(secondTeacherTest.getFaculty() ,
                    ((Teacher) employeeListTest.searchByDept(secondTeacherTest.getFaculty()).get(0)).getFaculty());
            assertEquals(thirdTeacherTest.getFaculty() ,
                    ((Teacher) employeeListTest.searchByDept(thirdTeacherTest.getFaculty()).get(0)).getFaculty());
        }
        /*
        the test will be just like the above but just to make sure it have the right value
         */
        public void testSearchDeptValue() throws Exception {
            employeeListTest.addEmployee(firstStaffTest);
            employeeListTest.addEmployee(secondStaffTest);
            employeeListTest.addEmployee(thirdStaffTest);
            employeeListTest.addEmployee(firstTeacherTest);
            employeeListTest.addEmployee(secondTeacherTest);
            employeeListTest.addEmployee(thirdTeacherTest);
            employeeListTest.addEmployee(sameDepartTestItViceHead);
            employeeListTest.addEmployee(sameDepartTestItStaff);
            employeeListTest.addEmployee(sameFacultyTestEngDoctor);
            employeeListTest.addEmployee(sameFacultyTestEngMaster);

            // test HEAD , VICE_HEAD and STAFF inside a same department
            assertEquals("IT" ,
                    ((Staff)employeeListTest.searchByDept("IT").get(0)).getDepartment());
            assertEquals("IT" ,
                    ((Staff)employeeListTest.searchByDept("IT").get(1)).getDepartment());
            assertEquals("IT" ,
                    ((Staff)employeeListTest.searchByDept("IT").get(2)).getDepartment());

            // test BACHELOR , MASTER and DOCTOR inside a same faculty
            assertEquals("Eng",
                    ((Teacher) employeeListTest.searchByDept("Eng").get(0)).getFaculty());
            assertEquals("Eng",
                    ((Teacher) employeeListTest.searchByDept("Eng").get(1)).getFaculty());
            assertEquals("Eng",
                    ((Teacher) employeeListTest.searchByDept("Eng").get(2)).getFaculty());

            //test Staff extra
            assertEquals("Marketing",
                    ((Teacher) employeeListTest.searchByDept("Marketing").get(0)).getFaculty());
            assertEquals("PR",
                    ((Teacher) employeeListTest.searchByDept("PR").get(0)).getFaculty());

            // test Teacher extra
            assertEquals("History",
                    ((Teacher) employeeListTest.searchByDept("History").get(0)).getFaculty());
            assertEquals("Math",
                    ((Teacher) employeeListTest.searchByDept("Math").get(0)).getFaculty());

        }
}