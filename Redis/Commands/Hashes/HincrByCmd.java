package Commands.Hashes;

import Commands.CommandHandler;
import DataStructure.RHashes;
import ResponseAndError.RInteger;
import ResponseAndError.RedisData;
import ResponseAndError.ThrowError.WrongNumberOfArguements;
import Database.Database;
import Database.Value;

public class HincrByCmd implements CommandHandler{
    @Override
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
        int incrVal = hash.incrBy(args[2], Integer.parseInt(args[3]));
        value.set(hash);
        Database.dbSet(args[1], value);
        return new RInteger(incrVal);
    }
}
