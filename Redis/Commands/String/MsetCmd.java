package Commands.String;

import Commands.CommandHandler;
import DataStructure.RString;
import Database.*;
import ResponseAndError.RInteger;
import ResponseAndError.RedisData;
import ResponseAndError.ThrowError.WrongNumberOfArguments;

public class MsetCmd implements CommandHandler {
    @Override
    public RedisData handle(String[] args) throws Exception {
        if (args.length % 2 == 0) {
            new WrongNumberOfArguments("mset");
        }
        int totalSets = 0;
        for (int i = 1; i < args.length - 1; i+=2) {
            RString str = new RString();
            str.set(args[i+1]);

            Value val = new Value();
            val.set(str);
            
            Database.dbSet(args[i], val);
            totalSets++;
        }
        return new RInteger(totalSets);
    }
}
