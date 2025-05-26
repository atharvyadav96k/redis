package Commands.Hashes;

import Commands.CommandHandler;
import Database.*;
import ResponseAndError.RInteger;
import ResponseAndError.RedisData;
import ResponseAndError.ThrowError.WrongNumberOfArguements;
import DataStructure.RHashes;

public class HsetCmd implements CommandHandler {
    @Override
    public RedisData handle(String[] args) throws Exception {
        if (args.length < 4 && args.length % 2 != 0) {
            WrongNumberOfArguements.throwError("hget");
        }
        if (!Database.dbExists(args[1])) {
            Value value = new Value();
            RHashes hash = new RHashes();
            value.set(hash);
            Database.dbSet(args[1], value);
        }

        Value value = Database.dbGet(args[1]);
        RHashes hash = (RHashes) value.get();
        
        int count = 0;
        for (int i = 2; i < args.length; i += 2) {
            hash.set(args[i], args[i + 1]);
            count++;
        }
        
        value.set(hash);
        Database.dbSet(args[1], value);
        return new RInteger(count);
    }
}
