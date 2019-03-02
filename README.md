# Simple-Employee-Management
It is a Java SE project for simple Employee management for a University but without GUI. This project is for my learning purpose 
## Version
-	written using IntelliJ IDEA Community Edition 2018.1 x64
-	JDK version 9.0. By the time, this project was being made only IntelliJ IDEA can properly work with JDK 9.0 while NetBeans and Eclipse are not yet stable 
## How to install
If you use IntelliJ IDEA use new -> Project From Version Control -> Git and paste https://github.com/JimmyYouhei/Simple-Employee-Management.git
## How to use
-	Start “PRO192xA3” class inside the “ui” package and follow the instruction
-	Use the “PrintFileForTest” class inside the “ui” package to make a test file with some data to begin with using if you want to take a quick look at the project
-	Use the “PRO192xA3Test” class inside the “test” to see the test case. The class is intended to use JUnit for testing 
## Features 
-	At start will try to find data.txt to read the data from. If no file is found will ask the user to input the file destination. If still not found, will start with no data
-	Can create, search Employees or change Employee detail by Department or by Name and display all Employees 
-	After creating or modifying any employees then all data will be written to a data.txt file 
-	Have a class to quickly print a data.txt file to test 
-	Have ways to reusable code as much as possible 
-	Junit was used for testing . However Junit4 was used not JUnit 5. 
During the time the project was being made(early 2018) Junit 5 was new and combine with my lack of skill and lack of ability 
to understanding and exploring more about Java and JUnit. Junit 5 was not used. Now I did use Junit 5 for practicing and testing 
when using [codewars](https://www.codewars.com/)
## Possible Issue
Not tested when importing to other IDE outside IntelliJ IDEA. By the time, the project was being made (early 2018) NetBeans and Eclipse cannot work properly with JDK 9. After the project was finished NetBeans still cannot work with JDK 9 therefore the project fails to work on NetBeans . Eclipse was not tested due to low hope of working 
## Known Issue
No Gui and don’t plan to make one with GUI because I may or may not work with Java GUI in the future or there maybe newer version at that time . when the project finished, I also considered to make GUI by either Java Swing or JavaFX but I decided to stop to make time for other more important projects 
## Special Note
-	The Project Skeleton is provided by my University at the time: Funix. However most of the code is written by me and I also added more features 
-	I did some Java SE projects before this one. But due to my early day with Java and transition from JavaScript to Java, those projects have code that I consider low quality. So I will not post them 
-	Before learning Java , I was able to write code in JavaScript fairy comfortable. But when transitioning to Java I found myself horribly making a lot of bugs due to my JavaScript mindset. JavaScript is very free in term of coding. And combining many steps of code to 1 line is fairy easy and quick. But Java is very strict and if you are writing Java freely like JavaScript it is not very different than walking on a minefield. You will bomb yourselves here and there due to combining steps.
-	However, Java also has its own beauty. It is not as complex as C but still helps me understanding many basic concepts (example for the difference between String “1” and int “1”). On this JavaScript does not offer this learning capability (for example everything is just “var”)
-	Java 10 now also accept “var” like JavaScript. But I think it should only be used by people who are comfortable with Java. Using the primitives frequently will make us understand more the basic of Computer Science 
-	To be honest, Java is growing too quickly now. When I started learning Java the latest JDK was 9. Now it is already 11. This is both bad and good on its own 

