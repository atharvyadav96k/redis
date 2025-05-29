package Commands.Hashes;

import Commands.CommandHandler;
import DataStructure.RHashes;
import ResponseAndError.SimpleString;
import Database.*;
import ResponseAndError.BulkString;
import ResponseAndError.RedisData;
import ResponseAndError.ThrowError.WrongNumberOfArguments;
import java.util.List;
import java.util.ArrayList;

public class HgetAllCmd implements CommandHandler {
    @Override
    public RedisData handle(String[] args) throws Exception {
        if (args.length != 2) {
            new WrongNumberOfArguments("hgetall");
        }
        
        if (!Database.dbExists(args[1])) {
            return new SimpleString("(empty array)");
        }

        Value value = Database.dbGet(args[1]);
        RHashes hashes = (RHashes) value.get();
        String[] keys = hashes.getKeys();
        String[] values = hashes.getValues();
        if (keys == null)
            keys = new String[0];
        if (values == null)
            values = new String[0];

        List<String> l = new ArrayList<>();
        int maxLength = Math.max(keys.length, values.length);
        for (int i = 0; i < maxLength; i++) {
            l.add(i < keys.length ? keys[i] : null);
            l.add(i < values.length ? values[i] : null);
        }   

        return new BulkString(l.toArray(new String[0]));
    }
}
