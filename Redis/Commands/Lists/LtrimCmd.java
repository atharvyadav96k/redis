package Commands.Lists;

import Commands.CommandHandler;
import DataStructure.RLists;
import ResponseAndError.RError;
import ResponseAndError.RedisData;
import ResponseAndError.SimpleString;
import ResponseAndError.ThrowError.WrongNumberOfArguments;
import ResponseAndError.ThrowError.WrongTypeInteger;
import Database.*;

public class LtrimCmd implements CommandHandler{
    @Override
    public RedisData handle(String[] args) throws Exception{
        if(args.length != 4){
            throw new WrongNumberOfArguments("ltrim");
        }
        if(!Database.dbExists(args[1])){
            return new RError("ERR no sucj key");
        }
        try{
            Value value = Database.dbGet(args[1]);
            RLists list = (RLists) value.get();
            list.lTrim(Integer.parseInt(args[2]), Integer.parseInt(args[3]));
            return new SimpleString("ok");
        }catch(Exception e){
            throw new WrongTypeInteger();
        }
    }
}
