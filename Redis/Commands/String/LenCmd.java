package Commands.String;

import Commands.CommandHandler;
import DataStructure.RString;
import Database.*;
import ResponseAndError.RInteger;
import ResponseAndError.RedisData;
import ResponseAndError.ThrowError.WrongNumberOfArguements;

public class LenCmd implements CommandHandler {
    @Override
    public RedisData handle(String[] args) throws Exception{
        if(args.length != 2){
            WrongNumberOfArguements.throwError("strlen");
        }
        if(!Database.dbExists(args[1])){
            return new RInteger(0);
        }
        Value val = Database.dbGet(args[1]);
        RString rStr = (RString) val.get();
        return new RInteger(rStr.len());
    }
}
