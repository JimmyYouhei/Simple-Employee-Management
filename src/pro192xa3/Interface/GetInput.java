package pro192xa3.Interface;

import java.util.Scanner;


public interface GetInput {

    //Get input String
    static String getString (String prompt){
            Scanner scanner = new Scanner(System.in);
            System.out.print(prompt);
            return scanner.next();
    }

    //Get input float
    static float getFloat (String prompt){
            Scanner scanner = new Scanner(System.in);
            System.out.print(prompt);
            return scanner.nextFloat();
    }

    //Get input int
    static int getInt (String prompt){
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextInt();
    }

}
