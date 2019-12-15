package convertTime;

import log.Logger;

public class TimeStringToIntArray {
    public static Integer[] convertTime(String duration) {
        int h = 0, m, s;
        String[] units = duration.split(":");
        assert (units.length == 2 || units.length == 3);
        switch (units.length) {
            case 2:
                // mm:ss
                m = Integer.parseInt(units[0]);
                s = Integer.parseInt(units[1]);
                break;

            case 3:
                // hh:mm:ss
                h = Integer.parseInt(units[0]);
                m = Integer.parseInt(units[1]);
                s = Integer.parseInt(units[2]);
                break;

            default:
                Logger.log("ERROR: parseTimeString failed: " + duration);
                throw new NumberFormatException("parseTimeString failed: " + duration);
        }
        if (m < 0 || m > 59 || s < 0 || s > 59 || h < 0 || h > 23) {
            Logger.log("ERROR: parseTimeString range error: " + duration);
            throw new NumberFormatException("parseTimeString range error: " + duration);
        }
        return new Integer[]{h, m, s};
    }
}
