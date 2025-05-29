package ResponseAndError.ThrowError;

public class WrongNumberOfArguments extends Exception{
    public WrongNumberOfArguments(String cmd) throws Exception{
        super("ERR wrong number of arguments for "+cmd+" command");
    }
}