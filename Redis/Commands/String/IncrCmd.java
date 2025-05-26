package Commands.String;

import Commands.CommandHandler;
import Database.*;
import ResponseAndError.RInteger;
import ResponseAndError.RedisData;
import ResponseAndError.ThrowError.WrongNumberOfArguements;
import DataStructure.RString;

public class IncrCmd implements CommandHandler {
    @Override
    public RedisData handle(String[] args) throws Exception{
        if(args.length != 2){
            WrongNumberOfArguements.throwError("incr");
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
