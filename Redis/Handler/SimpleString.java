package Handler;

import DataStructure.Type;

public class SimpleString extends RedisData{
    private final String value;
    
    public SimpleString(String value){
        this.value = value;
    }

    @Override
    public Type getType(){
        return Type.STRING;
    }

    @Override
    public String getRawValue(){
        return this.value;
    }
    
    @Override
    public String getFormattedValue(){
        return "+"+this.value+"\r\n";
    }
}
