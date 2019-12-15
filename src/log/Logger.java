package log;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    private static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
    private static String FileName;
    private static File f = null;

    public static void log(String commandName) {
        Date date = new Date();
        if (f == null) {
            do {
                FileName = "/" + System.getProperty("user.name") + "/IdeaProjects/VoiceRecord/logs/log" + new SimpleDateFormat("_dd.MM.yyy_HH-mm-ss").format(date) + ".log";
                f = new File(FileName);
                try {
                    Files.write(Paths.get(FileName), ("Date: " + new SimpleDateFormat("yyy-MM-dd (EEE MMM yyy) 'UTC'Z").format(date) + "\n-----------------------------------------------------------------------------------------------------------------------------\n" + sdf.format(date) + "   |   " + commandName + "\n").getBytes(), StandardOpenOption.CREATE_NEW);
                } catch (NullPointerException | IOException e) {
                    System.out.println("Cannot write to log file");
                }
            } while (!f.exists());
            return;
        }
        try {
            Files.write(Paths.get(FileName), (sdf.format(date) + "   |   " + commandName + "\n").getBytes(), StandardOpenOption.APPEND);
        } catch (NullPointerException | IOException e) {
            System.out.println("Cannot write to log file");
        }
    }
}