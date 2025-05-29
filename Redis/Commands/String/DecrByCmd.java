package Commands.String;

import Commands.CommandHandler;
import DataStructure.RString;
import Database.*;
import ResponseAndError.RInteger;
import ResponseAndError.RedisData;
import ResponseAndError.ThrowError.WrongNumberOfArguments;
import ResponseAndError.ThrowError.WrongTypeInteger;

public class DecrByCmd  implements CommandHandler{
    @Override
    public RedisData handle(String[] args) throws Exception{
        if(args.length != 3){
            new WrongNumberOfArguments("decrby");
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
        try{
            int val = rStr.decrBy(Integer.parseInt(args[2]));
            value.set(rStr);
            return new RInteger(val);
        }catch(Exception e){
            throw new WrongTypeInteger();
        }
    }
}
