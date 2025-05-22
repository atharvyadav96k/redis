package DataStructure;

public class RString {
    private String str;
    
    RString(){
        this.str = new String("(nil)");
    }
    
    
    public void set(String str){
        this.str = str;
    }
    
    
    public String get(){
        return this.str;
    }
    
    
    public String getRange(int start, int end){
        return this.str.substring(start, end);
    }
    
    
    public String getSet(String str){
        String old = this.str;
        this.str = str;
        return old;
    }
    
    
    public int len(String str){
        return str.equals("(nil)") ? 0 : str.length();
    }
    
    
    public int incr() throws Exception{
        return incrBy(1);
    }
    
    
    public int incrBy(int val) throws Exception{
        int num;
        try{
            num = Integer.parseInt(str);
        }catch(Exception e){
            throw new Exception("ERR value is not an integer or out of range");
        }
        num+=val;
        str = Integer.toString(num);
        return num;
    }
    
    
    public float incrByFloat(float val) throws Exception{
        float num;
        try{
            num  = Float.parseFloat(str);
        }catch(Exception e){
            throw new Exception("ERR value is not an Float or out of range");
        }
        num+=val;
        str = Float.toString(num);
        return num;
    }
    
    
    public int decr() throws Exception{
        return decrBy(1);
    }
    
    
    public int decrBy(int val) throws Exception{
        int num;
        try{
            num = Integer.parseInt(str);
        }catch(Exception e){
            throw new Exception("ERR value in not integer or out of range");
        }
        num+=val;
        str = Integer.toString(num);
        return num;
    }
}
