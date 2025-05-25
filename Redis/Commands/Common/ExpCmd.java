package Commands.Common;

import Commands.CommandHandler;
import Handler.RError;
import Handler.RInteger;
import Handler.RedisData;
import Database.*;

public class ExpCmd implements CommandHandler {
    @Override
    public RedisData handle(String[] args) {
        if (args.length != 3) {
            return new RError("ERR wrong number of arguments for 'expire' command");
        }
        if (!Database.dbExists(args[1])) {
            return new RInteger(0);
        }
        Value val = Database.dbGet(args[1]);
        val.setExp(Integer.parseInt(args[2]));
        return new RInteger(1);
    }
}
