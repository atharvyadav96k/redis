package Workers;

import java.util.Arrays;

import Database.*;

public class ExpireWorker extends Thread{
    protected String[] keys;
    public void run(){
        while(true){
            this.getValues();
            if(this.keys == null) continue;
            for(String key : this.keys){
                if(!Database.dbExists(key)) continue;
                Value value = Database.dbGet(key);
                if(value.isExp()){
                    try{
                        Database.dbDel(key);
                    }catch(Exception e){
                        System.out.println("Key Might get deleted by someone else");
                    }
                }else{
                    System.out.println(key+" Not Expired");
                }
                try{    
                    Thread.sleep(5000);
                }catch(Exception e){
                    System.out.println("Expire Worker Interrupted");
                    break;
                }
            }
        }
    }
    protected void getValues(){
        this.keys = Database.getKeys();
        if(this.keys.length > 0){
            System.out.println(Arrays.toString(keys));
        }
    }
}
