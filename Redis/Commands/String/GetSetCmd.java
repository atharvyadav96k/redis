package Commands.String;

import Database.*;
import ResponseAndError.RedisData;
import ResponseAndError.SimpleString;
import ResponseAndError.ThrowError.WrongNumberOfArguements;
import Commands.CommandHandler;
import DataStructure.RString;

public class GetSetCmd implements CommandHandler{
    @Override
    public RedisData handle(String[] args) throws Exception{
        if(args.length != 3){
            WrongNumberOfArguements.throwError("getset");
        }
        if(!Database.dbExists(args[1])){
            RString str = new RString();
            Value newVal = new Value();
            newVal.set(str);
            Database.dbSet(args[1], newVal);
        }
        Value val = Database.dbGet(args[1]);
        RString rStr = (RString) val.get();
        String str = rStr.getSet(args[2]);
        return new SimpleString(str);
    }
}
