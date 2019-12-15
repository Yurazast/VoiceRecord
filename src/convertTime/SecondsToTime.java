package convertTime;

import log.Logger;

public class SecondsToTime {
    public static String parseTime(int duration) throws NumberFormatException {
        if (duration < 0 || duration > 86399) {
            Logger.log("ERROR: parseTimeInt range error: " + duration);
            throw new NumberFormatException("parseTimeInt range error: " + duration);
        }
        int h = 0, m = 0, s = 0;

        while (duration - 3600 >= 0) {
            duration -= 3600;
            h++;
        }
        while (duration - 60 >= 0) {
            duration -= 60;
            m++;
        }
        s = duration;
        //hh:mm:ss
        return String.format("%02d:%02d:%02d", h, m, s);
    }
}
