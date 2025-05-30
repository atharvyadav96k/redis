package Commands.Lists;

import Commands.CommandHandler;
import DataStructure.RLists;
import ResponseAndError.RInteger;
import ResponseAndError.RedisData;
import ResponseAndError.SimpleString;
import ResponseAndError.ThrowError.WrongNumberOfArguments;
import Database.*;

public class LlenCmd implements CommandHandler{
    @Override
    public RedisData handle(String[] args) throws Exception{
        if(args.length != 2){
            throw new WrongNumberOfArguments("llen");
        }
        if(!Database.dbExists(args[1])){
            return new SimpleString("(nil)");
        }
        Value value = Database.dbGet(args[1]);
        RLists list = (RLists) value.get();
        return new RInteger(list.len());
    }
}
