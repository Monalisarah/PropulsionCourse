package Uebungen;

public class Config implements IConfig {
	
	DBConfig dbConfig = new DBConfig();
	ConsoleConfig consoleConfig;
	
    public int LoadVar() {
    	// DB Zugriff
    	return 17;
    }
}
