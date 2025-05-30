
package Commands.Lists;

import Commands.CommandHandler;
import DataStructure.RLists;
import ResponseAndError.RedisData;
import ResponseAndError.SimpleString;
import ResponseAndError.ThrowError.WrongNumberOfArguments;
import Database.*;

public class RpopCmd implements CommandHandler{
    @Override
    public RedisData handle(String[] args) throws Exception{
        if(args.length != 2){
            throw new WrongNumberOfArguments("rpop");
        }
        if(!Database.dbExists(args[1])){
            return new SimpleString("ok");
        }
        Value value = Database.dbGet(args[1]);
        RLists list = (RLists) value.get();
        list.rPop();
        return new SimpleString("ok");
    }    
}