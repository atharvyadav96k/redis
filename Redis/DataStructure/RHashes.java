package DataStructure;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import DataStructure.Increment.IncrementDecrement;;

public class RHashes {
    private HashMap<String, String> map = new HashMap<>();

    public void set(String key, String value) {
        this.map.put(key, value);
    }

    public Type getType() {
        return Type.HASHES;
    }

    public String get(String key) {
        return this.map.get(key);
    }

    public String[] getKeys() {
        Set<String> keys = this.map.keySet();
        return keys.toArray(new String[0]);
    }

    public String[] getValues() {
        Collection<String> values = this.map.values();
        return values.toArray(new String[0]);
    }

    public int len() {
        return this.map.size();
    }

    public int incr(String key) throws Exception {
        return this.incrBy(key, 1);
    }

    public int incrBy(String key, int incr) throws Exception {
        String value = this.map.get(key);
        int val = IncrementDecrement.incrBy(value, incr);
        this.map.put(key, Integer.toString(val));
        return val;
    }

    public float incrByFloat(String key, float incr) throws Exception {
        String value = this.map.get(key);
        float val = IncrementDecrement.incrByFloat(value, incr);
        this.map.put(key, Float.toString(val));
        return val;
    }

    public int exists(String key) {
        return this.map.containsKey(key) ? 1 : 0;
    }

}
