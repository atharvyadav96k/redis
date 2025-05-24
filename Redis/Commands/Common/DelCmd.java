package Commands.Common;

import Commands.CommandHandler;
import Handler.RInteger;
import Handler.RedisData;
import Database.*;

public class DelCmd implements CommandHandler{
    @Override
    public RedisData handle(String[] args) throws Exception{
        if(args.length != 2){
            throw new Exception("ERR wrong number of arguments for 'del' command");
        }
        if(!Database.dbExists(args[1])){
            return new RInteger(0);
        }
        Database.dbDel(args[1]);
        return new RInteger(1);
    }
}
