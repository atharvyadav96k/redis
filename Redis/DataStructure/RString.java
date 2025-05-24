package DataStructure;

import DataStructure.Increment.IncrementDecrement;

public class RString {
    private String str;

    public RString() {
        this.str = "(nil)";
    }

    public Type getType() {
        return Type.STRING;
    }

    public void set(String str) {
        this.str = str;
    }

    public String get() {
        return this.str;
    }

    public String getRange(int start, int end) {
        if (end == -1) {
            return this.str.substring(start);
        }
        return this.str.substring(start, end);
    }

    public String getSet(String str) {
        String old = this.str;
        this.str = str;
        return old;
    }

    public int append(String str){
        if(this.str == "(nil)"){
            this.str = "";
        }
        this.str+=str;
        return len();
    }

    public int len() {
        return this.str.equals("(nil)") ? 0 : this.str.length();
    }

    public int incr() throws Exception {
        return incrBy(1);
    }

    public int incrBy(int incr) throws Exception {
        int val = IncrementDecrement.incrBy(this.str, incr);
        this.str = Integer.toString(val);
        return val;
    }

    public float incrByFloat(float incr) throws Exception {
        float val = IncrementDecrement.incrByFloat(this.str, incr);
        this.str = Float.toString(val);
        return val;
    }

    public int decr() throws Exception {
        return this.decrBy(1);
    }

    public int decrBy(int decr) throws Exception {
        int val = IncrementDecrement.decrBy(this.str, decr);
        this.str = Integer.toString(val);
        return val;
    }
}
