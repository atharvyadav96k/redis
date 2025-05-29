package ResponseAndError.ThrowError;

public class WrongTypeInteger extends Exception {
    public WrongTypeInteger(){
        super("ERR value is not an integer or out of range");
    }
}
