package Commands.Lists;

import Commands.CommandHandler;
import DataStructure.RLists;
import ResponseAndError.RError;
import ResponseAndError.RedisData;
import ResponseAndError.SimpleString;
import ResponseAndError.ThrowError.WrongNumberOfArguments;
import ResponseAndError.ThrowError.WrongTypeInteger;
import Database.*;

public class LsetCmd implements CommandHandler{
    @Override
    public RedisData handle(String[] args) throws Exception{
        if(args.length != 4){
            throw new WrongNumberOfArguments("lset");
        }
        if(!Database.dbExists(args[1])){
            return new RError("ERR no such key");
        }
        try{
            Value value = Database.dbGet(args[1]);
            RLists list = (RLists) value.get();
            list.lSet(Integer.parseInt(args[2]), args[3]);
            return new SimpleString("ok");
        }catch(Exception e){
            throw new WrongTypeInteger();
        }
    }
}
