package Commands.String;

import Handler.RedisData;
import Handler.SimpleString;
import Database.*;
import DataStructure.RString;
import Commands.CommandHandler;

public class GetRangeCmd implements CommandHandler{
    @Override
    public RedisData handle(String args[]) throws Exception{
        if(args.length != 4){
            throw new Exception("ERR wrong number of arguments for 'get range' command");
        }
        Value val = Database.dbGet(args[1]);
        RString rStr = (RString) val.get();
        String str = rStr.getRange(Integer.parseInt(args[2]), Integer.parseInt(args[3]));
        return new SimpleString(str);
    }
}
