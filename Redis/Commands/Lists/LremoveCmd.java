package Commands.Lists;

import Commands.CommandHandler;
import DataStructure.RLists;
import ResponseAndError.RInteger;
import ResponseAndError.RedisData;
import ResponseAndError.ThrowError.WrongNumberOfArguments;
import Database.*;

public class LremoveCmd implements CommandHandler{
    @Override
    public RedisData handle(String[] args) throws Exception{
        if(args.length != 3){
            throw new WrongNumberOfArguments("lrem");
        }
        if(!Database.dbExists(args[1])){
            return new RInteger(0);
        }
        Value value = Database.dbGet(args[1]);
        RLists list = (RLists) value.get();
        int i = list.lRemove(args[2]);
        return new RInteger(i);
    }
}
