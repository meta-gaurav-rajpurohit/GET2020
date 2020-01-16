package problem;

public class ArrOperation {
    private int number0 = 0, number1 = 1, number2 = 2;

    /**
     * Find largest mirror section
     *
     * @param maxMirror the first {@code int} to Find largest mirror section
     *        maxMirror array contain number of Integer
     *        
     *        assert error throw : when array is empty
     *        
     * @return int value 
     */
    public int largMirrorSection(int maxMirror[]) {

        int arrayLength = maxMirror.length;
        int maxpattern = number0;
        
        assert(arrayLength != 0):"Array Empty";
        
        // 1 2 3 2 1 3 2 1
        // 0 1 2 3 4 5 6 7
        for (int i = number0; i < arrayLength; i++) {
            int count = number0;
            for (int j = arrayLength - 1; (j >= number0)
                    && (i + count) < maxMirror.length; j--) {
                if (maxMirror[i + count] == maxMirror[j]) {
                    System.out.println("C " + count + " "
                            + maxMirror[i + count] + " " + maxMirror[j] + " "
                            + i + " " + j);
                    count++;
                } else {
                    if (count > maxpattern)
                        maxpattern = count;
                    System.out.println("M " + maxpattern + " "
                            + maxMirror[i + count] + " " + maxMirror[j] + " "
                            + i + " " + j);
                    count = 0;
                    System.out.println();
                }
            }
            System.out.println("\n********************");
            if (count > maxpattern) {
                maxpattern = count;
                System.out.println("\n-------------------------");
            }
        }
        return maxpattern;
    }

    /**
     * Count clumps in integer array
     *
     * @param countClumpsArray the first {@code int} to Count clumps
     *        countClumpsArray array contain number of Integer
     *        
     *        assert error throw : when array is empty
     *        
     * @return int value 
     */
    public int countClumps(int countClumpsArray[]) {

        int arrayLength = countClumpsArray.length;
        int flag = number0;
        int j = number0, count = number0;
        
        assert(arrayLength != 0):"Array Empty";
        
        for (int i = number1; (i < arrayLength); i++) {
            j = i - number1;
            if (countClumpsArray[i] == countClumpsArray[j]) {
                flag = number1;
                if (i == arrayLength - number1)
                    count++;
            } else if (countClumpsArray[i] != countClumpsArray[j]) {
                if (flag == number1) 
                    count++;
                flag = number0;
            }

        }
        return count;
    }

    /**
     * Fix the x and y position where y place just after x. 
     *
     * @param fixXYArray the first {@code int} to fix the x and y position
     *        fixXYArray array contain number of Integer
     * @param x the second {@code int} to fix the x and y position
     * @param y the second {@code int} to fix the x and y position
     * 
     *          assert error throw : when array is empty
     *                               when two adjacent x are place
     *                               when last position of array contain x
     *                               when frequency of x and y are not equal
     * @return integer array which contain fix position of x and y  
     */
    public int[] fixXY(int fixXYArray[], int x, int y) {

        int arrayLength = fixXYArray.length;
        int temporary, i, j, countX = number0, countY = number0;
        
        assert(arrayLength != 0):"Array Empty";
        
        //count frequency of x and y in fixXYArray
        for (i = number0; i < arrayLength; i++) {
            if (fixXYArray[i] == x)
                countX++;
            else if (fixXYArray[i] == y)
                countY++;
        }
        for (i = number0; i < arrayLength; i++) {
            if (fixXYArray[i] == x) {
                
                assert (fixXYArray[i + 1] != x) : "Error two continues " + x
                        + " " + "on position " + (i + number1) + " and " + (i + number2);
                assert (fixXYArray[arrayLength - 1] != x) : "Error " + x
                        + " at the last possition";
                assert (countX == countY) : "Error " + "number " + x
                        + " and number " + y + " frequency are not equal";
                
                //swap the position of y after x
                for (j = number0; j < arrayLength; j++) {
                    if ((fixXYArray[j] == y) && (j == number0)) {
                        temporary = fixXYArray[i + number1];
                        fixXYArray[i + number1] = fixXYArray[j];
                        fixXYArray[j] = temporary;
                    } else if ((fixXYArray[j] == y) && (fixXYArray[j - number1] != x)) {
                        temporary = fixXYArray[i + number1];
                        fixXYArray[i + number1] = fixXYArray[j];
                        fixXYArray[j] = temporary;
                    }
                }
            }
        }
        return fixXYArray;
    }

    /**
     * Split array so that the sum of the numbers on one side is equal 
     * to the sum of the numbers on the other side
     *
     * @param splitArray the first {@code int} to Split array
     *        splitArray array contain number of Integer
     *        
     *        assert error throw : when array is empty
     *        
     * @return int value 
     */
    public int split(int splitArray[]) {

        int arrayLength = splitArray.length;
        int temporary = number0, arrayElementAddition = number0, i, halfArrayElementAddition;
        
        assert(arrayLength != 0):"Array Empty";
        
        for (i = number0; i < arrayLength; i++)
            arrayElementAddition += splitArray[i];

        if (arrayElementAddition % number2 == number0) {
            halfArrayElementAddition = arrayElementAddition / number2;
            for (i = number0; i < arrayLength; i++) {
                temporary += splitArray[i];
                if (temporary == halfArrayElementAddition)
                    return i + number1;
            }
        } else
            return -number1;

        return -number1;
    }
}
