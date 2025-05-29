package Commands.String;

import Database.*;
import ResponseAndError.RedisData;
import ResponseAndError.SimpleString;
import ResponseAndError.ThrowError.WrongNumberOfArguments;
import ResponseAndError.ThrowError.WrongTypeInteger;
import DataStructure.RString;
import Commands.CommandHandler;

public class GetRangeCmd implements CommandHandler{
    @Override
    public RedisData handle(String args[]) throws Exception{
        if(args.length != 4){
            new WrongNumberOfArguments("getrange");
        }
        try{
            Value val = Database.dbGet(args[1]);
            RString rStr = (RString) val.get();
            String str = rStr.getRange(Integer.parseInt(args[2]), Integer.parseInt(args[3]));
            return new SimpleString(str);
        }catch(Exception e){
            throw new WrongTypeInteger();
        }
    }
}
