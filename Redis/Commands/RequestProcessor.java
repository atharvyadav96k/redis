package Commands;

import java.util.Map;
import Commands.String.*;
import ResponseAndError.RedisData;

import java.util.HashMap;

import Commands.Common.*;
import Commands.Config.ConfigCmd;
import Commands.Hashes.*;
import Commands.Lists.LIndexCmd;
import Commands.Lists.LlenCmd;
import Commands.Lists.LpopCmd;
import Commands.Lists.LpushCmd;
import Commands.Lists.LrangeCmd;
import Commands.Lists.LremoveCmd;
import Commands.Lists.LsetCmd;


public class RequestProcessor {
    private static final Map<String, CommandHandler> handlers = new HashMap<>();    
    static{
        // Configuration command
        handlers.put("CONFIG", new ConfigCmd());

        // Common command
        handlers.put("PING", new PingCmd());
        handlers.put("DEL", new DelCmd());
        handlers.put("EXPIRE", new ExpCmd());

        // String commands
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
        handlers.put("HINCRBY", new HincrByCmd());
        handlers.put("HINCRBYFLOAT", new HincrbyFloatCmd());
        handlers.put("HKEYS", new HkeysCmd());
        handlers.put("HLEN", new HlenCmd());
        handlers.put("HMGET", new HmGetCmd());
        handlers.put("HVALS", new HvalusCmd());

        // Lists
        handlers.put("LPUSH", new LpushCmd());
        handlers.put("LINDEX", new LIndexCmd());
        handlers.put("LLEN", new LlenCmd());
        handlers.put("LPOP", new LpopCmd());
        handlers.put("LRANGE", new LrangeCmd());
        handlers.put("LREM", new LremoveCmd());
        handlers.put("LSET", new LsetCmd());
                

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
