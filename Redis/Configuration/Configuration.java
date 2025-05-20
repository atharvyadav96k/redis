package Configuration;

import java.io.*;

/* Here we are storing data into binary file 
if file is not there create file with some default settings
set configuration and get configuration */

public class Configuration {
    private static final String FILE_PATH = "./bin/config.redis";
    private static Config config;

    private static class Config implements Serializable {
        private static final long serialVersionUID = 1L;
        int port = 5000, maxMemory, userConnections = 10000;
        private boolean isConnectionLimit = false;
        boolean aof = false;
    }

    public Configuration() {
        config = loadConfig();
    }

    public static int getPort() {
        return config != null ? config.port : -1;
    }

    public static void setPort(int port) {
        config.port = port;
        saveChanges();
        System.exit(0);
    }

    public static boolean isConnectionLimit(){
        return config != null ? config.isConnectionLimit : false;
    }

    public static int getConnections(){
        return config != null ? config.userConnections : 10000;
    }

    public static void setConnection(int connections){
        config.userConnections = connections;
        config.isConnectionLimit = true;
        saveChanges();
    }

    private static void saveChanges() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(FILE_PATH)));
            out.writeObject(config);
            out.close();
        } catch (Exception e) {
            System.err.println("-Error failed to save changes");
        }
    }

    private Config loadConfig() {
        File file = new File(FILE_PATH);
        try {
            if (!file.exists()) {
                Config c = new Config();
                try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
                    out.writeObject(c);
                }
                return c;
            }
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                return (Config) in.readObject();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
