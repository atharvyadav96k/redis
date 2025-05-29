package Commands.String;

import DataStructure.RString;
import Database.Database;
import Commands.CommandHandler;
import Database.Value;
import ResponseAndError.RedisData;
import ResponseAndError.SimpleString;
import ResponseAndError.ThrowError.WrongNumberOfArguments;

public class GetCmd implements CommandHandler {
    @Override
    public RedisData handle(String[] args) throws Exception {
        if (args.length != 2) {
            new WrongNumberOfArguments("get");
        }

        Value value = Database.dbGet(args[1]);
        if (value == null) {
            return new SimpleString("(nil)");
        }

        RString str = (RString) value.get();
        return new SimpleString(str.get());
    }
}
