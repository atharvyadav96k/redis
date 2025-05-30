
package Commands.Lists;

import Commands.CommandHandler;
import DataStructure.RLists;
import ResponseAndError.RedisData;
import ResponseAndError.SimpleString;
import ResponseAndError.ThrowError.WrongNumberOfArguments;
import Database.*;

public class RpushCmd implements CommandHandler{
    @Override
    public RedisData handle(String[] args) throws Exception{
        if(args.length != 3){
            throw new WrongNumberOfArguments("rpush");
        }
        if(!Database.dbExists(args[1])){
            Value value = new Value();
            RLists list = new RLists();
            value.set(list);
            Database.dbSet(args[1], value);
        }
        Value value = Database.dbGet(args[1]);
        RLists list = (RLists) value.get();
        list.rPush(args[2]);
        return new SimpleString("ok");
    }
}