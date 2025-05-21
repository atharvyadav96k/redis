import java.util.HashMap;
import java.util.Map;

public class Database {
    static Map<String, Object> store = new HashMap<>();

    static Object get(String key){
        return store.get(key);
    }

    static void set(String key, Object value){
        store.put(key, value);
    }

    static void del(String key){
        store.remove(key);
    }
}
