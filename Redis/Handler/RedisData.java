package Handler;

import DataStructure.Type;

public abstract class RedisData {
    public abstract Type getType();
    public abstract String getRawValue();
    public abstract String getFormattedValue();
}