package Workers;

import Database.*;

public class PassiveCleaner {
    public static void deleteOnExpire(String[] args){
        if(args.length >= 2 && Database.dbExists(args[1])){
            return;
        }
        Value value = Database.dbGet(args[1]);
        if(value != null &&  value.isExp()){
            Database.dbDel(args[1]);
        }
    }
}
