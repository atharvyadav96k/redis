package Commands.Lists;

import Commands.CommandHandler;
import DataStructure.RLists;
import ResponseAndError.RedisData;
import ResponseAndError.SimpleString;
import ResponseAndError.ThrowError.WrongNumberOfArguments;
import ResponseAndError.ThrowError.WrongTypeInteger;
import Database.*;

public class LIndexCmd implements CommandHandler{
    @Override
    public RedisData handle(String[] args) throws Exception{
        if(args.length != 3){
            new WrongNumberOfArguments("lindex");
        }
        if(!Database.dbExists(args[1])){
            return new SimpleString("(nil)");
        }
        Value value = Database.dbGet(args[1]);
        RLists list = (RLists) value.get();
        try{
            return new SimpleString(list.getValueByIdx(Integer.parseInt(args[2])));
        }catch(Exception e){
            throw new WrongTypeInteger();
        }
    }
}
