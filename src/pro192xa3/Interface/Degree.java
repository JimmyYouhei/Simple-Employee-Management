package pro192xa3.Interface;

import pro192xa3.entity.EDegree;

public interface Degree {

    // return enum Degreee
    static EDegree getDegree (){
        int input = GetInput.getInt("Degree (1=BACHELOR; 2 = MASTER; 3=DOCTOR): ");
        switch (input){
            case 1:
                return EDegree.BACHELOR;

            case 2:
                return EDegree.MASTER;

            case 3:
                return EDegree.DOCTOR;

            default:
                return null;
        }
    }
}
