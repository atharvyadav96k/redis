package Commands;
import java.util.Map;

import Commands.String.*;

import java.util.HashMap;

import Handler.RedisData;

public class RequestProcessor {
    private static final Map<String, CommandHandler> handlers = new HashMap<>();    
    static{
        handlers.put("PING", new PingCmd());
        handlers.put("SET", new SetCmd());
        handlers.put("GET", new GetCmd());
        handlers.put("GETRANGE", new GetRangeCmd());
        handlers.put("GETSET", new GetSetCmd());
        handlers.put("MSET", new MsetCmd());
        handlers.put("MGET", new MgetCmd());
    }
    public static RedisData processRequest(String[] args) throws Exception{
        String cmd = args[0].toUpperCase();
        CommandHandler handle = handlers.get(cmd);
        if(handle == null){
            throw new Exception("Unknown command");
        }
        return handle.handle(args);
    }
}
