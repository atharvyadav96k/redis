package Commands.String;

import Commands.CommandHandler;
import Handler.RInteger;
import Handler.RedisData;
import Database.*;
import DataStructure.RString;

public class IncrCmd implements CommandHandler {
    @Override
    public RedisData handle(String[] args) throws Exception{
        if(args.length != 2){
            throw new Exception("ERR wrong number of argument for 'incr' command");
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
        int val = rStr.incr();
        value.set(rStr);
        Database.dbSet(args[1], value);
        return new RInteger(val);
    }
}
