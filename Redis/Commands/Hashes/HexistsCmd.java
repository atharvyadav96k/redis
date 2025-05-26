package Commands.Hashes;

import Commands.CommandHandler;
import DataStructure.RHashes;
import ResponseAndError.RInteger;
import ResponseAndError.RedisData;
import ResponseAndError.ThrowError.WrongNumberOfArguements;
import Database.*;

public class HexistsCmd implements CommandHandler{
    @Override
    public RedisData handle(String[] args) throws Exception{
        if(args.length != 3){
            WrongNumberOfArguements.throwError("hexits");
        }
        if(!Database.dbExists(args[1])){
            return new RInteger(0);
        }
        Value value = Database.dbGet(args[1]);
        RHashes hashes = (RHashes) value.get();
        return new RInteger(hashes.exists(args[2]));
    }
}