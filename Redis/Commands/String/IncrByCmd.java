package Commands.String;

import Commands.CommandHandler;
import DataStructure.RString;
import Database.*;
import Handler.RInteger;
import Handler.RedisData;


public class IncrByCmd implements CommandHandler{
    @Override
    public RedisData handle(String[] args) throws Exception{
        if(args.length != 3){
            throw new Exception("ERR wrong number of arguments for 'incr by' command");
        }
        if(!Database.dbExists(args[1])){
            RString rStr = new RString();
            Value val = new Value();
            rStr.set("0");
            val.set(rStr);
            Database.dbSet(args[1], val);
        }
        Value value = Database.dbGet(args[1]);
        RString rStr = (RString) value.get();
        int val = rStr.incrBy(Integer.parseInt(args[2]));
        value.set(rStr);
        return new RInteger(val);
    }
}
