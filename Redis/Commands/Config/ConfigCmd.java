package Commands.Config;

import Commands.CommandHandler;
import ResponseAndError.RedisData;
import ResponseAndError.SimpleString;
import ResponseAndError.ThrowError.WrongNumberOfArguments;
import ResponseAndError.ThrowError.WrongTypeInteger;
import Configuration.Configuration;

public class ConfigCmd implements CommandHandler{
    @Override
    public RedisData handle(String[] args) throws Exception{
        System.out.println("config");
        if(args.length != 3){
            throw new WrongNumberOfArguments("config");
        }
        if(args[1].equals("--port")){
            try{
                Configuration.setPort(Integer.parseInt(args[2]));
            }catch(Exception e){
                throw new WrongTypeInteger();
            }
            return new SimpleString("OK");
        }
        throw new Exception("Invalid command");
    }
}
