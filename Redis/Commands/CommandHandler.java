package Commands;
import ResponseAndError.RedisData;

public interface CommandHandler {
    RedisData handle(String[] args)throws Exception;
}
