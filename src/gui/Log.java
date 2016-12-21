package gui;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Eigenaar on 14-12-2016.
 */
public class Log{
	
	public String logDate(){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		String curDate = dtf.format(now);
		return curDate;
	}

    public String makeLog(String curDate, String Output) throws IOException {
        BufferedWriter output = new BufferedWriter(new FileWriter("log.txt", true));
        String logLine = curDate + " " + Output;
        output.append(logLine);
        output.newLine();
        output.close();
        return "done";
    }
}
