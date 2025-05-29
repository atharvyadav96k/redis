package Commands.Hashes;

import Commands.CommandHandler;
import DataStructure.RHashes;
import Database.*;
import ResponseAndError.RedisData;
import ResponseAndError.SimpleString;
import ResponseAndError.ThrowError.WrongNumberOfArguments;

public class HgetCmd implements CommandHandler{
    @Override
    public RedisData handle(String[] args) throws Exception{
        if(args.length != 3){
            new WrongNumberOfArguments("hget");
        }
        if(!Database.dbExists(args[1])){
            return new SimpleString("(nil)");
        }
        Value value = Database.dbGet(args[1]);
        RHashes hash = (RHashes) value.get();
        return new SimpleString(hash.get(args[2]));
    }
}
