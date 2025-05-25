package Database;

public class Value{
        private Object obj;
        private long exp = -1;
        public void set(Object val){
            this.obj = val;
        }
        public Object get(){
            return this.obj;
        }
        public boolean isExp(){
            if(exp == -1){
                return false;
            }
            return System.currentTimeMillis() >= this.exp;
        }
        public void setExp(int duration){
            this.exp = System.currentTimeMillis() + duration;
        }
}