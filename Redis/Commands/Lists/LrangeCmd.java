package Commands.Lists;

import Commands.CommandHandler;
import DataStructure.RLists;
import ResponseAndError.BulkString;
import ResponseAndError.RedisData;
import ResponseAndError.SimpleString;
import ResponseAndError.ThrowError.WrongNumberOfArguments;
import ResponseAndError.ThrowError.WrongTypeInteger;
import Database.*;

public class LrangeCmd implements CommandHandler{
    @Override
    public RedisData handle(String[] args) throws Exception{
        if(args.length != 4){
            throw new WrongNumberOfArguments("lrange");
        }
        if(!Database.dbExists(args[1])){
            return new SimpleString("(nil)");
        }
        Value value = Database.dbGet(args[1]);
        RLists list = (RLists) value.get();
        try{
            return new BulkString(list.lRange(Integer.parseInt(args[2]), Integer.parseInt(args[3])));
        }catch(Exception e){
            throw new WrongTypeInteger();
        }
    }
}
