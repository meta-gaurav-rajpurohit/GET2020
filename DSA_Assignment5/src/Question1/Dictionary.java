package Question1;

import java.util.Map;

public interface Dictionary {

    String getValue(int key) throws Exception;

    void put(int key, String value);

    String delete(int key) throws Exception;

    Map<Integer, String> sort();

    Map<Integer, String> sort(int key1, int key2);
}