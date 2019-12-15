package convertTime;

import log.Logger;

public class TimeToSeconds {
    public static Integer parseTime(String duration) {
        if (duration.isEmpty()) {
            Logger.log("ERROR: parseTimeString empty duration");
            throw new NullPointerException("parseTimeString empty duration");
        }
        Integer[] time = TimeStringToIntArray.convertTime(duration);
        //h * 3600 + m * 60 + s
        return time[0] * 3600 + time[1] * 60 + time[2];
    }
}

