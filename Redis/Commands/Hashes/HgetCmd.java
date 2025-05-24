package Commands.Hashes;

import Commands.CommandHandler;
import DataStructure.RHashes;
import Handler.RedisData;
import Handler.SimpleString;
import Database.*;

public class HgetCmd implements CommandHandler{
    @Override
    public RedisData handle(String[] args) throws Exception{
        if(args.length != 3){
            throw new Exception("ERR wrong number of argument for 'hget' command");
        }
        if(!Database.dbExists(args[1])){
            return new SimpleString("(nil)");
        }
        Value value = Database.dbGet(args[1]);
        RHashes hash = (RHashes) value.get();
        return new SimpleString(hash.get(args[2]));
    }
}
