package Commands.String;

import Commands.CommandHandler;
import Handler.RInteger;
import Handler.RedisData;
import DataStructure.RString;
import Database.*;

public class LenCmd implements CommandHandler {
    @Override
    public RedisData handle(String[] args) throws Exception{
        if(args.length != 2){
            throw new Exception("Err wrong number of arguments for 'len' command");
        }
        if(!Database.dbExists(args[1])){
            return new RInteger(0);
        }
        Value val = Database.dbGet(args[1]);
        RString rStr = (RString) val.get();
        return new RInteger(rStr.len());
    }
}
