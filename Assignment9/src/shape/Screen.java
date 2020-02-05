package shape;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Screen{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private List<Shape> shapeList = new ArrayList<Shape>();
    public static Screen zo = new Screen(); 
    
    
    //private Screen(){}
    
    /**
     * this function use to return single object   
     * 
     * @param no parameter        
     * @return Screen object
     */
    public static Screen getInstance(){
        return zo;
    }
    
    /**add the shape object in list
     * 
     * @param shapeObject
     * @return
     */
    public boolean addShape(Shape shapeObject){
        shapeList.add(shapeObject);
        return true;
    }
    
    /**show the list of object
     * 
     * @return integer value
     * @throws Exception
     */
    public int show()throws Exception{
        System.out.println(String.format("%15s %15s %15s","Shape","XCoordinate","XCoordinate"));
        for(Shape list : shapeList)
            System.out.println(String.format("%15s %15s %15s",list.getName(),
                    list.getOrigin().getXCoordinate(),list.getOrigin().getYCoordinate()));
        System.out.print("Select serial no. : ");
        return Integer.parseInt(br.readLine());
    }
    
    /**delete the shape object
     * 
     * @param shapeObject
     * @return boolean value
     * @throws Exception
     */
    public boolean delete(Shape shapeObject) throws Exception{
        for(Shape s : shapeList){
            if(shapeObject.getName().equals(s.getName())){ 
                shapeList.remove(shapeList.indexOf(s));
                 return true;
            }
        }
        return false;
    }
    
    /**delete all object of shape 
     * 
     * @return boolean value
     */
    public boolean deleteAll(){
        shapeList.removeAll(shapeList);
        return true;
    }
    
    /**return list of shape object
     * 
     * @return boolean value
     */
    public List<Shape> listOfShape(){
        return shapeList;
    }
    
    public List<Shape> sortByArea(){
        if(shapeList.size() == 0){
            throw new AssertionError("List is empty");
        }
        List<Shape> sortedListByArea = new ArrayList<Shape>(shapeList);
        Collections.sort(sortedListByArea, ShapeSort.sortByArea);
        return sortedListByArea;
    }
    
    public List<Shape> sortByParimeter(){
        if(shapeList.size() == 0){
            throw new AssertionError("List is empty");
        }
        List<Shape> sortedListByParimeter = new ArrayList<Shape>(shapeList);
        Collections.sort(sortedListByParimeter, ShapeSort.sortByPerimeter);
        return sortedListByParimeter;
    }
    
}
