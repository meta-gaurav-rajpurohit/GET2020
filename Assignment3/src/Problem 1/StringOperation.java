public class StringOperation {
    public int number0 = 0, number1 = 1;
    
    /**
     * Compare 2 string
     *
     * @param  fname the first {@code String} to compare
     * @param  sname the second {@code String} to compare
     * @return the integer 0 or 1 value 
     */
    public int compareString(String fname, String sname) {
        int flength, slength, flag = number0;

        flength = fname.length();
        slength = sname.length();

        if (flength == slength) {
            for (int i = number0; i < flength; i++) {
                if (fname.charAt(i) == sname.charAt(i))
                    flag = number1;
                else {
                    flag = number0;
                    break;
                }
            }
            if (flag == number1)
                return 1;
            else
                return number0;
        } else
            return number0;
    }
    
    /**
     * Reverse the string
     *
     * @param  name the first {@code String} to reverse
     * @return the string value 
     */
    public String reverseString(String name) {
        int fname;
        String reverString = "";

        fname = name.length();

        for (int i = number0; i < fname; i++) {
            reverString = name.charAt(i) + reverString;
        }
        return reverString;
    }
    
    /**
     * Change character case in string
     *
     * @param  fname the first {@code String} to Change character case
     * @return the string value 
     */
    public String changeCharCase(String name) {
        int fname, convertValue = 32;
        String reverseString = "";
        
        fname = name.length();

        for (int i = number0; i < fname; i++) {
            if(name.charAt(i) >= 'a' &&  name.charAt(i) <='z')
                reverseString += ((char)(name.charAt(i) - convertValue )) ;
            if(name.charAt(i) >= 'A' &&  name.charAt(i) <= 'Z')
                reverseString += ((char)(name.charAt(i) + convertValue )) ;
        }
        return reverseString;
    }

    /**
     * Find largest length string
     *
     * @param  fname the first {@code String} to Find largest length string
     * @param  sname the second {@code String} to Find largest length string
     * @return the string value 
     */
    public String largestWordString(String fname, String sname) {
        int flength, slength;

        flength = fname.length();
        slength = sname.length();
        if(flength == slength || flength < slength)
            return sname;
        
        else
            return fname;
    }
}
