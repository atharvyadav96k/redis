package Handler;

import DataStructure.Type;

public class BulkString extends RedisData {
    private final String[] value;

    public BulkString(String[] values) {
        this.value = values;
    }

    @Override
    public Type getType(){
        return Type.STRING;
    }

    @Override
    public String getRawValue() {
        StringBuilder str = new StringBuilder("");
        str.append("[");
        for (int i = 0; i < this.value.length; i++) {
            str.append(this.value[i]);
            str.append(",");
        }
        str.append("]");
        return str.toString();
    }

    @Override
    public String getFormattedValue() {
        StringBuilder str = new StringBuilder("");
        for(int i=0;i<this.value.length;i++){
            str.append((i+1)+")");
            str.append(this.value[i]+"\r\n");
        }
        return str.toString();
    }
}
