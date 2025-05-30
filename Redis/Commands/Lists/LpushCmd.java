package Commands.Lists;

import Commands.CommandHandler;
import DataStructure.RLists;
import ResponseAndError.RInteger;
import ResponseAndError.RedisData;
import ResponseAndError.ThrowError.WrongNumberOfArguments;
import Database.*;

public class LpushCmd implements CommandHandler{
    @Override
    public RedisData handle(String[] args) throws Exception{
        if(args.length < 3){
            throw new WrongNumberOfArguments("lpush");
        }
        if(!Database.dbExists(args[1])){
            Value value = new Value();
            RLists list = new RLists();
            value.set(list);
            Database.dbSet(args[1], value);
        }
        Value value = Database.dbGet(args[1]);
        RLists list = (RLists) value.get();
        int count = 0;
        for(int i=2;i<args.length;i++){
            list.lPush(args[i]);
            count++;
        }
        return new RInteger(count);
    }
}
