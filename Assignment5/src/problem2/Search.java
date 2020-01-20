package problem2;

public class Search {
    int number0 = 0, number1 = 1, number2 = 2;
    
    /**
     * Search element using linear search algo in array
     * 
     * @param linearSearchArray the first {@code int[]} to Search element       
     * @param arrayLength the second {@code int} to Search element       
     * @param searchElement the third {@code int} to Search element        
     * 
     * @return int value 
     */
    public int linearSearch(int linearSearchArray[], int arrayLength, int searchElement){
        if(arrayLength < number0)
            return -number1;
        if(linearSearchArray[arrayLength] == searchElement){
            return arrayLength;
        }
        return linearSearch(linearSearchArray, arrayLength - number1, searchElement);
    }
    
    /**
     * Search element using linear search algo in array
     * 
     * @param binarySearchArray the first {@code int[]} to Search element       
     * @param firstElementIndex the second {@code int} to Search element       
     * @param lastElementIndex the third {@code int} to Search element
     * @param searchElement the fourth {@code int} to Search element
     * 
     * @return int value 
     */
    public int binarySearch(int binarySearchArray[], int firstElementIndex, int lastElementIndex, int searchElement){
        int middelElementIndex = (firstElementIndex +lastElementIndex) / number2;
        if(firstElementIndex > lastElementIndex)
            return -number1;
        else if(searchElement == binarySearchArray[middelElementIndex])
            return middelElementIndex;
        
        else if(searchElement < binarySearchArray[middelElementIndex])
            return binarySearch( binarySearchArray, firstElementIndex, middelElementIndex - number1, searchElement);
        else
            return binarySearch( binarySearchArray, middelElementIndex + number1, lastElementIndex, searchElement);
    }
}
