package Handler;

import DataStructure.Type;

public class RError extends RedisData{
    private final String value;

    public RError(String val){
        this.value = val;
    }
    @Override
    public Type getType(){
        return Type.ERROR;
    }

    @Override
    public String getRawValue(){
        return this.value;
    }

    @Override
    public String getFormattedValue(){
        return "-Error "+this.value+"\r\n";
    }

}
