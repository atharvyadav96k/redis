package Commands;
import Handler.RedisData;
import Handler.SimpleString;

public class PingCmd implements CommandHandler{
    @Override
    public RedisData handle(String[] args) throws Exception{
        if(args.length > 2){
            throw new Exception("ERR wrong number of arguments for 'ping' command");
        }
        if(args.length == 2){
            return new SimpleString(args[1]);
        }
        return new SimpleString("PONG");
    }
}