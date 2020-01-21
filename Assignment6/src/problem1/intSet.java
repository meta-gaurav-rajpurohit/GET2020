package problem1;

public final class intSet {

    private final int number0 = 0;
    private final int set[];

    /**
     * Set the set array to null
     * 
     * @param no parameter required
     */
    public intSet() {
        set = null;
    }

    /**
     * set the array value using parameterize constructor
     * 
     * @param temporary the first {@code int[]} to set the array value      
     * 
     */
    public intSet(int temporary[]) {
        int count = 0;
        int temp = 0;

        int temp1[] = new int[temporary.length];
        for (int i = 0; i < temporary.length-1; i++) {
            for (int j = 0; j < temporary.length-i-1; j++){ 
                if (temporary[j] > temporary[j+1]) 
                { 
                    int swap = temporary[j]; 
                    temporary[j] = temporary[j+1]; 
                    temporary[j+1] = swap; 
                    
                } 
            }
        }
        
        for(int i=0;i<temporary.length-1;i++){
            temp=i;
            if(temporary[i] == temporary[i+1]){
                temp1[count] = temporary[i];
                count++; 
            }
        }
        temp1[count] = temporary[temp++];
        count++;
        
        set = temporary;
    }

    /**
     * find that Element present or not in set
     * 
     * @param Element the first {@code int} to find the element      
     * 
     * @return boolean value
     */
    public boolean isMember(int Element) {
        for (int i = number0; i < this.size(); i++) {
            if (set[i] == Element) {
                return true;
            }
        }
        return false;
    }

    /**
     * find the size of set
     * 
     * @param no parameter      
     *
     * @return int value
     */
    public int size() {
        int setSize = number0;
        for (int i : this.set) {
            setSize++;
        }
        return setSize;
    }

    /**
     * find the set is subset or not
     * 
     * @param subset the first {@code intSet} to find the subset      
     * 
     * @return boolean value
     */
    public boolean isSubSet(intSet subset) {
        boolean flag = false;
        for (int i = number0; i < subset.size(); i++) {
            flag = false;
            for (int j = number0; j < this.size(); j++) {
                if (subset.set[i] == this.set[j]) {
                    flag = true;
                    break;
                }
            }
            if (!flag)
                return false;
        }
        return flag;
    }

    /**
     * find complement of set where universal set range 1 to 10
     * 
     * @param no parameter      
     * 
     * @return integer value array 
     */
    public int[] getComplement() {
        int firstElement = 1, lastElement = 10, j = 0;
        boolean flag = false;
        int temporaryArray[] = new int[lastElement - this.size()];
        for (; firstElement <= lastElement; firstElement++) {
            flag = false;
            for (int i = 0; i < this.size(); i++) {
                if (firstElement == this.set[i]) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                temporaryArray[j] = firstElement;
                j++;
                System.out.println(firstElement + " ");
            }
        }
        return temporaryArray;
    }

    /**
     * union two sets
     * 
     * @param firstSubset the first {@code intSet} to union two sets      
     * @param secondSubset the second {@code intSet} to union two sets
     * 
     * @return integer value array 
     */
    public int[] union(intSet firstSubset, intSet secondSubset) {
        int firstSubsetLength = firstSubset.size();
        int secondSubsetLength = secondSubset.size();
        int temporaryArray[] = new int[firstSubsetLength + secondSubsetLength];
        int temporaryArrayLength = firstSubsetLength + secondSubsetLength - 1, i;
        System.out.println(temporaryArrayLength);
        for (i = 0; i < firstSubsetLength; i++) {
            temporaryArray[temporaryArrayLength] = firstSubset.set[i];
            temporaryArrayLength--;
        }
        for (i = 0; i < secondSubsetLength; i++) {
            temporaryArray[temporaryArrayLength] = secondSubset.set[i];
            temporaryArrayLength--;
        }
        return temporaryArray;
    }

}
