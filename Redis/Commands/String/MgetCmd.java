package Commands.String;

import java.util.ArrayList;
import java.util.List;
import Commands.CommandHandler;
import DataStructure.RString;
import Database.*;
import ResponseAndError.BulkString;
import ResponseAndError.RedisData;
import ResponseAndError.ThrowError.WrongNumberOfArguements;

public class MgetCmd implements CommandHandler {
    @Override
    public RedisData handle(String[] args) throws Exception {
        if (args.length < 2) {
            WrongNumberOfArguements.throwError("mget");
        }

        List<String> values = new ArrayList<>();
        for (int i = 1; i < args.length; i++) {
            Value value = Database.dbGet(args[i]); 
            if (value == null || value.get() == null) {
                values.add("(nil)");
            } else {
                RString str = (RString) value.get();
                values.add(str.get());
            }
        }

        return new BulkString(values.toArray(new String[0]));
    }
}
