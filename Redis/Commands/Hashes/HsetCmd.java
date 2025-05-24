package Commands.Hashes;

import Commands.CommandHandler;
import Database.*;
import Handler.RInteger;
import DataStructure.RHashes;
import Handler.RedisData;

public class HsetCmd implements CommandHandler{
    @Override
    public RedisData handle(String[] args) throws Exception{
        if(args.length < 4 && args.length % 2 != 0){
            throw new Exception("ERR wrong number of argument for 'hset' command");
        }
        Value value = new Value();
        RHashes hash = new RHashes();
        int count = 0;
        for(int i=2;i<args.length;i+=2){
            hash.set(args[i], args[i+1]);
            count++;
        }
        value.set(hash);
        Database.dbSet(args[1], value);
        return new RInteger(count);
    }
}
