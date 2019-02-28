package pro192xa3.Interface;

import pro192xa3.entity.EPosition;

public interface Position {
    //return enum Position
    static EPosition getPosition (){
        int input = GetInput.getInt("Position (1=HEAD; 2=VICE HEAD ; 3=STAFF) : ");
        switch(input){
            case 1:
                return EPosition.HEAD;

            case 2:
                 return EPosition.VICE_HEAD;

            case 3:
                return EPosition.STAFF;

            default:
                return null;
        }
    }
    
}
