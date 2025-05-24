package Commands.String;

import Commands.CommandHandler;
import DataStructure.RString;
import Handler.RInteger;
import Handler.RedisData;
import Database.*;

public class DecrByCmd  implements CommandHandler{
    @Override
    public RedisData handle(String[] args) throws Exception{
        if(args.length != 3){
            throw new Exception("ERR wrong number of argument for 'decr by' command");
        }
        if(!Database.dbExists(args[1])){
            Value value = new Value();
            RString rStr = new RString();
            rStr.set("0");
            value.set(rStr);
            Database.dbSet(args[1], value);
        }
        Value value = Database.dbGet(args[1]);
        RString rStr = (RString) value.get();
        int val = rStr.decrBy(Integer.parseInt(args[2]));
        value.set(rStr);
        return new RInteger(val);
    }
}
