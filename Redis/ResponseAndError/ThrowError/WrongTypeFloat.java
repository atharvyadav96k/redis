package ResponseAndError.ThrowError;

public class WrongTypeFloat  extends Exception{
    public WrongTypeFloat(){
        super("ERR value is not an float or out of range");
    }
}
