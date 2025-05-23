package Commands.String;

import Handler.RedisData;
import Handler.SimpleString;
import DataStructure.RString;
import Database.Database;
import Commands.CommandHandler;
import Database.Value;

public class GetCmd implements CommandHandler {
    @Override
    public RedisData handle(String[] args) throws Exception {
        if (args.length != 2) {
            throw new Exception("ERR wrong number of arguments for 'get' command");
        }

        Value value = Database.dbGet(args[1]);
        if (value == null) {
            return new SimpleString("(nil)");
        }

        RString str = (RString) value.get();
        return new SimpleString(str.get());
    }
}
