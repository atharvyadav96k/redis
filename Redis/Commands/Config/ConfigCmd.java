package Commands.Config;

import Commands.CommandHandler;
import ResponseAndError.RedisData;
import ResponseAndError.SimpleString;
import ResponseAndError.ThrowError.WrongNumberOfArguements;
import Configuration.Configuration;

public class ConfigCmd implements CommandHandler{
    @Override
    public RedisData handle(String[] args) throws Exception{
        System.out.println("config");
        if(args.length != 3){
            WrongNumberOfArguements.throwError("config");
        }
        if(args[1].equals("--port")){
            Configuration.setPort(Integer.parseInt(args[2]));
            return new SimpleString("OK");
        }
        throw new Exception("Invalid command");
    }
}
