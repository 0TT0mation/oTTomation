package base;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class log {

    //Initialize Log4j instance
    private static Logger Log = LogManager.getLogger();

    //We can use it when starting tests
    public static void startLog (){
        Log.info("Test is Starting...");
    }

    //We can use it when ending tests
    public static void endLog (){
        Log.info("Test is Ending...");
    }

    //Info Level Logs
    public static void info (String message) {
        Log.info(message);
    }

    //Warn Level Logs
    public static void warn (String message) {
        Log.warn(message);
    }

    //Error Level Logs
    public static void error (String message) {
        Log.error(message);
    }

    //Fatal Level Logs
    public static void fatal (String message) {
        Log.fatal(message);
    }

    //Debug Level Logs
    public static void debug (String message) {
        Log.debug(message);
    }
}
