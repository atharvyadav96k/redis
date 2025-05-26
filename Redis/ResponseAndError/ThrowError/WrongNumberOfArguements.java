package ResponseAndError.ThrowError;

public class WrongNumberOfArguements {
    public static void throwError(String cmd) throws Exception{
        throw new Exception("ERR wrong number of arguments for "+cmd+" command");
    }
}