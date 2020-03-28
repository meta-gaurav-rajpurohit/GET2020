package Question2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class UniqueCharacter {

    private static HashMap<String, Integer> enteredStrings;

    static {
        enteredStrings = new HashMap<String, Integer>();
    }

    public int countUniqueCharacters(String inputString) throws Exception {
        if (inputString.trim().length() == 0) {
            throw new Exception("Invalid string");
        }
        if (enteredStrings.containsKey(inputString)) {
            return enteredStrings.get(inputString);
        }

        int uniqueCharacters = 0;
        Set<Character> hashSet = new HashSet<Character>();
        for (int iterator = 0; iterator < inputString.length(); iterator++) {
            hashSet.add(inputString.charAt(iterator));
        }
        uniqueCharacters = hashSet.size();
        enteredStrings.put(inputString, uniqueCharacters);
        return uniqueCharacters;
    }

}
