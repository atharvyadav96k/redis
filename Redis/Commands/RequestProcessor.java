package Commands;

import java.util.Map;
import Commands.String.*;
import ResponseAndError.RedisData;

import java.util.HashMap;

import Commands.Common.*;
import Commands.Hashes.HexistsCmd;
import Commands.Hashes.HgetAllCmd;
import Commands.Hashes.HgetCmd;
import Commands.Hashes.HsetCmd;

public class RequestProcessor {
    private static final Map<String, CommandHandler> handlers = new HashMap<>();    
    static{
        // Common commands
        handlers.put("DEL", new DelCmd());
        handlers.put("EXPIRE", new ExpCmd());

        // String commands
        handlers.put("PING", new PingCmd());
        handlers.put("SET", new SetCmd());
        handlers.put("GET", new GetCmd());
        handlers.put("GETRANGE", new GetRangeCmd());
        handlers.put("GETSET", new GetSetCmd());
        handlers.put("MSET", new MsetCmd());
        handlers.put("MGET", new MgetCmd());
        handlers.put("INCR", new IncrCmd());
        handlers.put("INCRBY", new IncrByCmd());
        handlers.put("DECR", new DecrCmd());
        handlers.put("DECRBY", new DecrByCmd());
        handlers.put("STRLEN", new LenCmd());
        handlers.put("APPEND", new AppendCmd());

        // Hashes
        handlers.put("HSET", new HsetCmd());
        handlers.put("HGET", new HgetCmd());
        handlers.put("HEXISTS", new HexistsCmd());
        handlers.put("HGETALL", new HgetAllCmd());
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
