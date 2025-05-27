package Commands.Hashes;

import Commands.CommandHandler;
import DataStructure.RHashes;
import ResponseAndError.BulkString;
import ResponseAndError.RedisData;
import ResponseAndError.SimpleString;
import ResponseAndError.ThrowError.WrongNumberOfArguements;
import Database.*;

public class HkeysCmd implements CommandHandler{
    @Override
    public RedisData handle(String[] args) throws Exception{
        if(args.length != 2){
            WrongNumberOfArguements.throwError("hkeys");
        }
        if(!Database.dbExists(args[1])){
            return new SimpleString("(empty array)");
        }
        Value value = Database.dbGet(args[1]);
        RHashes hash =  (RHashes) value.get();
        return new BulkString(hash.getKeys());
    }
}
