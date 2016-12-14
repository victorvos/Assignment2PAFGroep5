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
		String dateTimeNow = dtf.format(now);
		return dateTimeNow;
	}

    public String makeLog(String dateTimeNow, String type, String command) throws IOException {
        BufferedWriter output = new BufferedWriter(new FileWriter("log.txt", true));
        String logLine = dateTimeNow +""+ type +""+ command;
        output.append(logLine);
        output.newLine();
        output.close();
        return "done";
    }
	
	public String makeLog(String dateTimeNow, String type, String command){
		return command;
		
	}

}
