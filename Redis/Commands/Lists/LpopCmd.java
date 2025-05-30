package Commands.Lists;

import Commands.CommandHandler;
import DataStructure.RLists;
import ResponseAndError.ThrowError.WrongNumberOfArguments;
import ResponseAndError.RedisData;
import ResponseAndError.SimpleString;
import Database.*;

public class LpopCmd implements CommandHandler{
    @Override
    public RedisData handle(String[] args) throws Exception{
        if(args.length != 2){
            throw new WrongNumberOfArguments("lpop");
        }
        if(!Database.dbExists(args[1])){
            return new SimpleString("(nil)");
        }
        Value value = Database.dbGet(args[1]);
        RLists list = (RLists) value.get();
        if(list != null){
            return new SimpleString(list.lPop());
        }
        return new SimpleString("(nil)");
    }
}
