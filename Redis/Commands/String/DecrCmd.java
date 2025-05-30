package Commands.String;

import Commands.CommandHandler;
import DataStructure.RString;
import Database.*;
import ResponseAndError.RInteger;
import ResponseAndError.RedisData;
import ResponseAndError.ThrowError.WrongNumberOfArguments;

public class DecrCmd implements CommandHandler{
    @Override
    public RedisData handle(String[] args) throws Exception{
        if(args.length != 2){
            new WrongNumberOfArguments("decr");
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
