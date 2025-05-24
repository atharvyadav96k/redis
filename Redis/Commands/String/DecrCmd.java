package Commands.String;

import Commands.CommandHandler;
import DataStructure.RString;
import Handler.RInteger;
import Handler.RedisData;
import Database.*;

public class DecrCmd implements CommandHandler{
    @Override
    public RedisData handle(String[] args) throws Exception{
        if(args.length != 2){
            throw new Exception("ERR wrong number of arguments for 'decr' command");
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
        int val = rStr.decr();
        value.set(rStr);
        return new RInteger(val);
    }
}
