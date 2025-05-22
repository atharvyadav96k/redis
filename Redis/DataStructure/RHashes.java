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

    public String get(String key) {
        return this.map.get(key);
    }

    public String getKeys() {
        Set<String> keys = this.map.keySet();
        StringBuffer result = new StringBuffer();
        int i = 1;
        for (String str : keys) {
            result.append(i + ") " + str + "\n");
            i++;
        }
        return result.toString();
    }

    public String getValues(){
        Collection<String> values = this.map.values();
        StringBuffer result = new StringBuffer();
        int i = 1;
        for(String str: values){
            result.append(i+")"+str+"\n");
            i++;
        }
        return result.toString();
    }

    public int len(){
        return this.map.size();
    }

    public int incr(String key) throws Exception{
        return this.incrBy(key, 1);
    }

    public int incrBy(String key, int incr) throws Exception{
        String value = this.map.get(key);
        int val = IncrementDecrement.incrBy(value, incr);
        this.map.put(key, Integer.toString(val));
        return val;
    }

    public float incrByFloat(String key, float incr) throws Exception{
        String value = this.map.get(key);
        float val = IncrementDecrement.incrByFloat(value, incr);
        this.map.put(key, Float.toString(val));
        return val;
    }

    public int exists(String key){
        return this.map.containsKey(key) ? 1 : 0;
    }
    
}
