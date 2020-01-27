import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class AnimalMain {
    static int  number0 = 0,number1 = 1, number2 = 2, number3 = 3, number4 = 4, countID;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    /**
     * this function show the data of animal   
     * 
     * @param no parameter       
     * @return no return type
     */
    public static void showStatus()throws Exception{
        boolean flag = true;
        BufferedReader file ;
        int temp1, temp2;
        String line = null;
        String filePath = "C:\\Users\\Gaurav\\Desktop\\workspace\\Assignment8\\src\\";
        
        System.out.println("Show status of : \n 1) Mammal \n 2) Reptile \n "
                + "3) Bird \n 4) All");
        do{
            System.out.println("Select your option : ");
            temp1 = Integer.parseInt(br.readLine());
            
            if(temp1 == number4){
                temp2 = number1;
                System.out.println("ZOO MANAGEMENT SYSTEM");
            }
            else
                temp2 = temp1;
            
            switch(temp2){
            case 1 : 
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println("MAMMAL : ");
                System.out.println("-------------------------------------------------------------------------------");
                file = new BufferedReader(new FileReader(filePath+"Mammal.txt"));
                
              //print file data on console
                while ((line = file.readLine()) != null) 
                    System.out.println(line);
                System.out.println("================================================================================\n");
                if(temp1 != number4){
                    flag = false;
                    break;
                }
            case 2 : 
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println("REPTILE : ");
                System.out.println("-------------------------------------------------------------------------------");
                file = new BufferedReader(new FileReader(filePath+"Reptile.txt"));
                
              //print file data on console
                while ((line = file.readLine()) != null) 
                    System.out.println(line);
                System.out.println("================================================================================\n");
                if(temp1 != number4){
                    flag = false;
                    break;
                }
            case 3 : 
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println("BIRD : ");
                System.out.println("-------------------------------------------------------------------------------");
                file = new BufferedReader(new FileReader(filePath+"Bird.txt"));
                
                //print file data on console
                while ((line = file.readLine()) != null) 
                    System.out.println(line);
                System.out.println("================================================================================\n");
                flag = false;
                break;
            default :
                System.out.println("Wrong input.... try again");
            }
        }while(flag);
    }
    
    /**
     * this function use to delete animal data   
     * 
     * @param no parameter       
     * @return no return type
     */
    public static void delete() throws Exception{
        //Sno is define serial number
        int SNo = number0;
        boolean flag = true;
        BufferedReader filePrint, file;
        File temporaryFile, inputFile;
        String fileName = null, line = null;
        String filePath = "C:\\Users\\Gaurav\\Desktop\\workspace\\Assignment8\\src\\";
        
        System.out.println("Show status of : \n 1) Mammal \n 2) Reptile \n "
                + "3) Bird \n 4) Exit");
        do{
            System.out.println("Select your option : ");
            
            //select file name
            switch (Integer.parseInt(br.readLine())) {
            case 1: 
                fileName = "Mammal.txt";
                flag = false;
                break;

            case 2:
                fileName = "Reptile.txt";
                flag = false;
                break;

            case 3:
                fileName = "Bird.txt";
                flag = false;
                break;
            case 4:
                System.exit(number0);
            default:
                System.out.println("Wrong input.... try again");
            }
        }while(flag);
        
        inputFile = new File(filePath+fileName);
        temporaryFile = new File(inputFile.getAbsolutePath() + ".tmp");
        filePrint = new BufferedReader(new FileReader(filePath+fileName));
        file = new BufferedReader(new FileReader(filePath+fileName));
        PrintWriter pw = new PrintWriter(new FileWriter(temporaryFile));
        
        //show file data on console
        while ((line = filePrint.readLine()) != null) {
            SNo++;
            System.out.println(SNo+" "+line);
        }
        
        //select line number which user want to delete
        System.out.println("Chose line sno.");
        int select = Integer.parseInt(br.readLine());
        
        //close the file which show on console
        filePrint.close();
        SNo= number0;
        
        //write data from input file to temporary file
        while ((line = file.readLine()) != null) {
            SNo++;
            if ((select != SNo)) {
                pw.println(line);
                pw.flush();
            }
        }
        pw.close();
        file.close();

        // Delete the original file
        if(!inputFile.delete()){
            System.out.println("Could not delete file");
            return;
        }
        // Rename the new file to the filename the original file had.
        if(!temporaryFile.renameTo(inputFile)){
            System.out.println("Could not rename file");
            return;
        }
    }

    /**
     * take name of animal   
     * 
     * @param no parameter       
     * @return String value
     */
    public static String name() throws IOException {
        System.out.print("Enter name of animal : ");
        return br.readLine();
    }

    /**
     * take age of animal   
     * 
     * @param no parameter       
     * @return int value
     */
    public static int age() throws IOException {
        do {
            try {
                System.out.print("Enter age of animal : ");
                return Integer.parseInt(br.readLine());
            } catch (NumberFormatException e) {
                System.out.println("Number Format Exception " + e.getMessage());
            }
        } while (true);
    }

    /**
     * take weight of animal   
     * 
     * @param no parameter       
     * @return int value
     */
    public static int weight() throws IOException {
        do {
            try {
                System.out.print("Enter weight of animal : ");
                return Integer.parseInt(br.readLine());
            } catch (NumberFormatException e) {
                System.out.println("Number Format Exception " + e.getMessage());
            }
        } while (true);
    }

    /**
     * give random ID of animal   
     * 
     * @param no parameter       
     * @return String value
     */
    public static String id(String animalCatagory, String animalType) {
        Random random = new Random(); 
        return animalCatagory + animalType + random.nextInt(2000);
    }
    
    /**
     * check zone have space to add animal or not  
     * 
     * @param animalCatagory is the first {@code String}
     * @param type is the first {@code String}
     * 
     * @return String value
     */
    public static String zone(String animalCatagory, String type) throws IOException{
        int serialNumber = number0;

        //contain zone list
        List<String> list = new ArrayList<String>();
        
        //in this hashmap string contain category and list<String> contain zone
        for(HashMap.Entry<String, List<String>> entry : Zone.zoo.entrySet()){
            if(animalCatagory.equalsIgnoreCase(entry.getKey())){
                for(String s : entry.getValue()){
                    serialNumber++;
                    System.out.println(String.format("%-5s%-10s",serialNumber,s));
                    list.add(s);
                }
                do {
                    try {

                        String s = list
                                .get(Integer.parseInt(br.readLine()) - number1);
                        switch (s.charAt(s.length() - number1)) {
                        case '1':
                            ZoneOne z1 = ZoneOne.getInstance();
                            return z1.set(type);
                            
                        case '2':
                            ZoneTwo z2 = ZoneTwo.getInstance();
                            return z2.set(type);
                            
                        case '3':
                            ZoneThird z3 = ZoneThird.getInstance();
                            return z3.set(type);
                            
                        case '4':
                            ZoneFour z4 = ZoneFour.getInstance();
                            return z4.set(type);
                            
                        case '5':
                            ZoneFive z5 = ZoneFive.getInstance();
                            return z5.set(type);
                            
                        default:
                            System.out.println("Wrong input.. try again");
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("Number Format Exception "
                                + e.getMessage());
                    }
                } while (true);
            }
        }
        return null;
    }
   
    /**
     * this function use to create mammal category animal object 
     * 
     * @param no parameter
     * @return no return value
     */
    public static void selectMammal() throws Exception {

        boolean flag = true;

        System.out.print("Select animal type : \n1) Lion "
                + "\n2) Bear \n3) Tiger\n");
        do {
            System.out.print("Select Your Option : ");
            switch (Integer.parseInt(br.readLine())) {
            case 1:
                new Lion(name(), age(), weight(), "Lion", zone("Mammal", "Lion"), id("M", "Lion"));
                flag = false;
                break;
            case 2:
                new Bear(name(), age(), weight(), "Bear", zone("Mammal", "Bear"), id("M", "Bear"));
                flag = false;
                break;
            case 3:
                new Tiger(name(), age(), weight(), "Tiger", zone("Mammal", "Tiger"), id("M", "Tiger"));
                flag = false;
                break;
            default:
                System.out.println("Wrong input.... Try again");
            }
        } while (flag);
    }
    
    /**
     * this function use to create reptile category animal object 
     * 
     * @param no parameter
     * @return no return value
     */
    public static void selectReptile() throws Exception {

        boolean flag = true;

        System.out.print("Select animal type : \n1) Crocodiles "
                + "\n2) Alligators \n3) Lizards\n");
        do {
            System.out.print("Select Your Option : ");
            switch (Integer.parseInt(br.readLine())) {
            case 1:
                new Crocodiles(name(), age(), weight(), "Crocodiles", zone("Reptile", "Crocodiles"), id("R", "Crocodiles"));
                flag = false;
                break;
            case 2:
                new Alligators(name(), age(), weight(), "Alligators", zone("Reptile", "Alligators"), id("R", "Alligators"));
                flag = false;
                break;
            case 3:
                new Lizards(name(), age(), weight(), "Lizards", zone("Reptile", "Lizards"), id("R", "Lizards"));
                flag = false;
                break;
            default:
                System.out.println("Wrong input.... Try again");
            }
        } while (flag);
    }
    
    /**
     * this function use to create bird category animal object 
     * 
     * @param no parameter
     * @return no return value
     */
    public static void selectBird() throws Exception {

        boolean flag = true;

        System.out.print("Select animal type : \n1) Owl "
                + "\n2) Alligators \n3) Lizards\n");
        do {
            System.out.print("Select Your Option : ");
            switch (Integer.parseInt(br.readLine())) {
            case 1:
                new Owl(name(), age(), weight(), "Owl", zone("Bird", "Owl"), id("B", "Owl"));
                flag = false;
                break;
            case 2:
                new Parrot(name(), age(), weight(), "Parrot", zone("Bird", "Parrot"), id("B", "Parrot"));
                flag = false;
                break;
            case 3:
                new Peacock(name(), age(), weight(), "Peacock", zone("Bird", "Peacock"), id("B", "Peacock"));
                flag = false;
                break;
            default:
                System.out.println("Wrong input.... Try again");
            }
        } while (flag);
    }
    
    /**
     * this function use to select which type of category select 
     * 
     * @param no parameter
     * @return String value
     */
    public static void addition()throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;

        System.out.println("Select animal type : \n1) Mammal "
                + "\n2) Reptile \n3) Bird");
        do {
            System.out.print("Select Your Option : ");
            switch (Integer.parseInt(br.readLine())) {
            case 1:
                selectMammal();
                flag = false;
                break;
            case 2:
                selectReptile();
                flag = false;
                break;
            case 3:
                selectBird();
                flag = false;
                break;
            default:
                System.out.println("Wrong input.... Try again");
            }
        } while (flag);
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;

        do{
        System.out.print("Main menu : \n1) Added Animal \n2) Delete Animal "
                + "\n3) Show Zoo Status \n4) Exit\n");

            System.out.print("Select Your Option : ");
            switch (Integer.parseInt(br.readLine())) {
            case 1:
                addition();
                break;
            case 2:
                delete();
                break;
            case 3:
                showStatus();
                break;
            case 4:
                flag = false;
                break;    
            default:
                System.out.println("Wrong input.... Try again");
            }
        }while(flag);
    }
}
