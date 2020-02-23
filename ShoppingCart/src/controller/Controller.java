package controller;

import java.io.IOException;
import java.sql.SQLException;

import facade.ShpingCardOperation;

public class Controller {

    public void selectOperation(int parseInt) throws SQLException, NumberFormatException, IOException {
        ShpingCardOperation operation = new ShpingCardOperation();
        
        switch(parseInt){
        case 1 : operation.addition(); 
            break;
        case 2 : operation.edit();
            break;
        case 3 : operation.show();
            break;
        case 4 : operation.genrateBill();
            break;
        case 5 : System.exit(0);
            break;
        default :
            System.out.println("Wrong Input try agaian...");
        }
    }

}
