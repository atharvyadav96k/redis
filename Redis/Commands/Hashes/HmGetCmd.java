package Commands.Hashes;

import java.util.ArrayList;
import java.util.List;
import Commands.CommandHandler;
import DataStructure.RHashes;
import Database.*;
import ResponseAndError.BulkString;
import ResponseAndError.RedisData;
import ResponseAndError.SimpleString;
import ResponseAndError.ThrowError.WrongNumberOfArguements;

public class HmGetCmd implements CommandHandler {
    @Override
    public RedisData handle(String[] args) throws Exception {
        if (args.length <= 2) {
            WrongNumberOfArguements.throwError("hmget");
        }
        if (!Database.dbExists(args[1])) {
            return new SimpleString("(nil)");
        }
        Value value = Database.dbGet(args[1]);
        RHashes hash = (RHashes) value.get();
        List<String> strs = new ArrayList<>();
        for (int i = 2; i < args.length; i++) {
            strs.add(hash.get(args[i]));
        }
        return new BulkString(strs.toArray(new String[0]));
    }
}
