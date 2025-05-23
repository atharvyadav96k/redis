package Commands.String;

import Handler.RedisData;
import Handler.SimpleString;
import DataStructure.RString;
import Database.Database;
import Commands.CommandHandler;
import Database.Value;

public class SetCmd implements CommandHandler {
    @Override
    public RedisData handle(String[] args) throws Exception {
        if (args.length != 3) {
            throw new Exception("ERR wrong number of arguments for 'set' command");
        }

        RString str = new RString();
        str.set(args[2]);

        Value val = new Value();
        val.set(str);
        
        Database.dbSet(args[1], val);
        return new SimpleString("OK");
    }
}
