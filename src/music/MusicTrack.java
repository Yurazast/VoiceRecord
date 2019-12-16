package music;

import convertTime.SecondsToTime;
import convertTime.TimeStringToIntArray;
import convertTime.TimeToSeconds;

import java.util.Objects;

public class MusicTrack {
    private String name;
    private String trackLength;
    private Integer durationInSeconds;
    private String style;

    public MusicTrack(String name, String trackLength, String style) {
        this.name = name;
        this.trackLength = trackLength;
        this.style = style;
        checkTrackLength();
        calcDuration();
    }

    public MusicTrack(String name, Integer durationInSeconds, String style) {
        this.name = name;
        this.durationInSeconds = durationInSeconds;
        this.style = style;
        calcDuration();
    }

    public static String checkTrackLength(String track) {
        if (track.length() != 8) {
            Integer[] time = TimeStringToIntArray.convertTime(track);
            return (String.format("%02d:%02d:%02d", time[0], time[1], time[2]));
        }
        return track;
    }

    public String getName() {
        return name;
    }

    public String getStyle() {
        return style;
    }

    public String getTrackLength() {
        return trackLength;
    }

    public void setTrackLength(String trackLength) {
        this.trackLength = trackLength;
    }

    public Integer getDurationInSeconds() {
        return durationInSeconds;
    }

    public void setDurationInSeconds(Integer durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }

    private void calcDuration() {
        if (this.getTrackLength() == null)
            this.setTrackLength(SecondsToTime.parseTime(this.getDurationInSeconds()));
        else
            this.setDurationInSeconds(TimeToSeconds.parseTime(this.getTrackLength()));
    }

    private void checkTrackLength() {
        this.setTrackLength(checkTrackLength(this.getTrackLength()));
    }

    public boolean isInRange(Integer start, Integer end) {
        return this.getDurationInSeconds() >= start && this.getDurationInSeconds() <= end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MusicTrack that = (MusicTrack) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(trackLength, that.trackLength) &&
                Objects.equals(durationInSeconds, that.durationInSeconds) &&
                Objects.equals(style, that.style);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, trackLength, durationInSeconds, style);
    }

    @Override
    public String toString() {
        return String.format(" | %-30s | %-12s | %-13s | %s", centerAlign(name, 30), centerAlign(trackLength, 12), centerAlign(durationInSeconds.toString(), 13), centerAlign(style, 16));
    }

    private String centerAlign(String s, int width) {
        return String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s);
    }
}
