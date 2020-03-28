package Question3;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
            Main main = new Main();
            try {
                    main.userInput();
            } catch (Exception exception) {
                    System.out.println(exception.getMessage());
            }
    }

    private void userInput() throws NumberFormatException, IOException {
            MolecularWeight.getMolecularWeight("C2(ch2)2Ho2");
    }

}
