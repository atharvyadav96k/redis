package Commands;
import Handler.RedisData;

public interface CommandHandler {
    RedisData handle(String[] args)throws Exception;
}
