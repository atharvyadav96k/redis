package Commands.Common;

import Commands.CommandHandler;
import Database.*;
import ResponseAndError.RError;
import ResponseAndError.RInteger;
import ResponseAndError.RedisData;
import ResponseAndError.ThrowError.WrongTypeInteger;

public class ExpCmd implements CommandHandler {
    @Override
    public RedisData handle(String[] args) throws Exception{
        if (args.length != 3) {
            return new RError("ERR wrong number of arguments for 'expire' command");
        }
        if (!Database.dbExists(args[1])) {
            return new RInteger(0);
        }
        Value val = Database.dbGet(args[1]);
        try{
            val.setExp(Integer.parseInt(args[2]));
        }catch(Exception e){
            throw new WrongTypeInteger();
        }
        return new RInteger(1);
    }
}
