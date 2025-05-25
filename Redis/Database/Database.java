package Database;

import java.util.HashMap;
import java.util.Map;

public class Database {
    private static Map<String, Value> store = new HashMap<>();

    public static String[] getKeys(){
        return store.keySet().toArray(new String[0]);
    }

    public static Value dbGet(String key){
        return store.get(key) ;
    }

    public static void dbSet(String key, Value value){
        store.put(key, value);
    }

    public static void dbDel(String key){
        store.remove(key);
    }

    public static boolean dbExists(String key){
        return store.containsKey(key);
    }
    public static void exp(String key, int exp){
        Value val = store.get(key);
        val.set(exp);
        store.put(key, val);
    }
    public static boolean isExp(String key){
        Value val = store.get(key);
        return val.isExp();
    }
}
