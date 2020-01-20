package problem1;

public class Mathematical {
    private int number0 = 0;

    /**
     * Find Highest Common Factor(HCF)
     * 
     * @param firstNumber the first {@code int} to Find Highest Common Factor      
     * @param secondNumber the second {@code int} to Find Highest Common Factor        
     * 
     * @return int value 
     */
    public int highestCommonFactor(int firstNumber, int secondNumber) {
        if (secondNumber == number0)
            return firstNumber;
        return highestCommonFactor(secondNumber, firstNumber % secondNumber);
    }

    /**
     * Find Least Common Multiple(LCM)
     * 
     * @param firstNumber the first {@code int} to Find Least Common Multiple       
     * @param secondNumber the second {@code int} to Find Least Common Multiple        
     * 
     * @return int value 
     */
    public int leastCommonMultiple(int firstNumber, int secondNumber) {
        return (firstNumber * secondNumber) / highestCommonFactor(firstNumber, secondNumber);
    }

}
