package Commands.Hashes;

import Commands.CommandHandler;
import DataStructure.RHashes;
import ResponseAndError.RInteger;
import ResponseAndError.RedisData;
import ResponseAndError.ThrowError.WrongNumberOfArguments;
import Database.*;

public class HlenCmd implements CommandHandler{
    @Override
    public RedisData handle(String[] args) throws Exception{
        if(args.length != 2){
            new WrongNumberOfArguments("hlen");
        }
        if(!Database.dbExists(args[1])){
            return new RInteger(0);
        }
        Value value = Database.dbGet(args[1]);
        RHashes hash = (RHashes) value.get();
        return new RInteger(hash.len());
    }
}
