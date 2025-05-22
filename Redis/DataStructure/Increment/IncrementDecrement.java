package DataStructure.Increment;

public class IncrementDecrement {
    public static int incrBy(String str, int val) throws Exception {
        int num;
        try {
            num = Integer.parseInt(str);
        } catch (Exception e) {
            throw new Exception("ERR value is not an integer or out of range");
        }
        return num + val;
    }

    public static float incrByFloat(String str, float val) throws Exception {
        float num;
        try {
            num = Float.parseFloat(str);
        } catch (Exception e) {
            throw new Exception("ERR value is not a float or out of range");
        }
        return num + val;
    }

    public static int decrBy(String str, int val) throws Exception {
        int num;
        try {
            num = Integer.parseInt(str);
        } catch (Exception e) {
            throw new Exception("ERR value is not an integer or out of range");
        }
        return num - val;
    }
}
