package Commands.String;

import DataStructure.RString;
import Database.Database;
import Commands.CommandHandler;
import Database.Value;
import ResponseAndError.RedisData;
import ResponseAndError.SimpleString;
import ResponseAndError.ThrowError.WrongNumberOfArguments;

public class SetCmd implements CommandHandler {
    @Override
    public RedisData handle(String[] args) throws Exception {
        if (args.length != 3) {
            new WrongNumberOfArguments("set");
        }

        RString str = new RString();
        str.set(args[2]);

        Value val = new Value();
        val.set(str);
        
        Database.dbSet(args[1], val);
        return new SimpleString("OK");
    }
}
