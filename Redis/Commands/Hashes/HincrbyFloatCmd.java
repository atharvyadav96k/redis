package Commands.Hashes;

import Commands.CommandHandler;
import DataStructure.RHashes;
import ResponseAndError.RInteger;
import ResponseAndError.RedisData;
import ResponseAndError.SimpleString;
import ResponseAndError.ThrowError.WrongNumberOfArguements;
import Database.Database;
import Database.Value;

public class HincrbyFloatCmd implements CommandHandler{
    public RedisData handle(String[] args) throws Exception{
        if(args.length != 4){
            WrongNumberOfArguements.throwError("hincrby");     
        }
        if(!Database.dbExists(args[1])){
            Value value = new Value();
            RHashes hash = new RHashes();
            value.set(hash);
            Database.dbSet(args[1], value);
        }
        Value value = Database.dbGet(args[1]);
        RHashes hash = (RHashes) value.get();
        if(hash.exists(args[2]) == 0){
            hash.set(args[2], "0");
        }
        float incrVal = hash.incrByFloat(args[2], Float.parseFloat(args[3]));
        value.set(hash);
        Database.dbSet(args[1], value);
        return new SimpleString(Float.toString(incrVal));
    }
}