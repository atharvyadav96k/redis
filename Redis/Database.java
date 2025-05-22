import java.util.HashMap;
import java.util.Map;

public class Database {
    private class Value{
        public Object obj;
        public int exp;
    }
    private static Map<String, Value> store = new HashMap<>();

    static Object dbGet(String key){
        return store.get(key);
    }

    static void dbSet(String key, Value value){
        store.put(key, value);
    }

    static void dbDel(String key){
        store.remove(key);
    }

    static void exp(String key, int exp){
        Value val = store.get(key);
        val.exp = exp;
        store.put(key, val);
    }
}
