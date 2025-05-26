package ResponseAndError;

import DataStructure.Type;

public class RInteger  extends RedisData{
    private final int value;
    
    public RInteger(int val){
        this.value = val;
    }

    @Override
    public Type getType(){
        return Type.INTEGER;
    }

    @Override
    public String getRawValue(){
        return ""+this.value;
    }

    @Override
    public String getFormattedValue(){
        return "(integer) "+this.value+"\r\n";
    }
}
