package Question2;

public class Main {

        public static void main(String[] args){
                Main mainObject = new Main();
                try{
                        mainObject.userInput();
                }
                catch (Exception exception){
                        System.out.println(exception.getMessage());
                }
        }

        private void userInput() throws Exception {
                UniqueCharacter character1 = new UniqueCharacter();
                System.out.println(character1.countUniqueCharacters("saras"));
                System.out.println(character1.countUniqueCharacters("xyzxyzl"));
                UniqueCharacter character2 = new UniqueCharacter();
                System.out.println(character2.countUniqueCharacters("saras"));
        }
}
