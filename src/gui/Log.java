package gui;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;

/**
 * Created by Eigenaar on 14-12-2016.
 */
public class Log{
	
	public String logDate(){
        LocalTime now = LocalTime.now();
        return now.toString();
	}

    public String makeLog(String Output) throws IOException {
        BufferedWriter output = new BufferedWriter(new FileWriter("log.txt", true));
        String logLine = logDate() + " " + Output;
        output.append(logLine);
        output.newLine();
        output.close();
        return "Log created!";
    }
}
