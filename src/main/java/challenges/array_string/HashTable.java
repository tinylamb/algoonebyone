package challenges.array_string;

/**
 * Created by samo on 2017/4/25.
 *
 * @author samo
 * @date 2017/04/25
 */

/**
 * Implement a hash table with set, get, and remove methods
 */
public class HashTable {
    private String[] items;

    public HashTable() {
        this.items = new String[10];
    }

    public void setVal(int index, String val) {
        items[index] = val;
    }

    public String getVal(int index) {
        return items[index];
    }

    public void mvVal(int index) {
        items[index] = null;
    }
}
