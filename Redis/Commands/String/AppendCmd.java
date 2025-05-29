package Commands.String;

import Commands.CommandHandler;
import DataStructure.RString;
import Database.*;
import ResponseAndError.RInteger;
import ResponseAndError.RedisData;
import ResponseAndError.ThrowError.WrongNumberOfArguments;

public class AppendCmd implements CommandHandler{
    @Override
    public RedisData handle(String[] args) throws Exception{
        if(args.length != 3){
            new WrongNumberOfArguments("append");
        }
        if(!Database.dbExists(args[1])){
            Value val = new Value();
            RString rStr = new RString();
            val.set(val);
            Database.dbSet(args[1], val);
        }
        Value val = Database.dbGet(args[1]);
        RString rStr = (RString) val.get();
        int len =  rStr.append(args[2]);
        return new RInteger(len);
    }
}
