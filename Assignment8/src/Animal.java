import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class Animal {
    protected String name;
    protected String type;
    protected int age;
    protected int weight;
    protected String ID;
    protected String zone;
    protected String animalCatagory;
    
    /**
     * constructor initialize animal feature   
     * 
     * @param name the first {@code String}       
     * @param age the second {@code int}       
     * @param weight the third {@code int}
     * @param type the fourth {@code String}       
     * @param ID the fifth {@code String}       
     * @param zone the sixth {@code String}
     * @param animalCatagory the seventh {@code String}    
     */
    public Animal(String name, int age, int weight, String type, String ID,  String zone, String animalCatagory) throws Exception{
        if(zone.equals(null))
            System.exit(0);
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.type = type;
        this.ID = ID;
        this.zone = zone;
        this.animalCatagory = animalCatagory;
        this.fileWrite(ID+"\t\t"+name+"\t\t"+age+"\t"+weight+"\t"+type+"\t\t"+zone, animalCatagory);
    }
    
    public void fileWrite(String input, String animalCatagory) throws Exception {

        try {

            String tempFile = "C:\\Users\\Gaurav\\Desktop\\workspace\\Assignment8\\src\\"
                    + animalCatagory + ".txt";
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile, true));
            System.out.println(input);
            pw.println(input);
            pw.close();
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
