package music;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Disc {
    private List<MusicTrack> disc;

    public Disc() {
        disc = new ArrayList<>();
    }

    public List<MusicTrack> getDisc() {
        return disc;
    }

    public void setDisc(List<MusicTrack> disc) {
        this.disc = new ArrayList<>();
        this.disc.addAll(disc);
    }

    public void addMusicTrack(MusicTrack mt) {
        disc.add(mt);
    }

    public int getDiscSize() {
        return disc.size();
    }

    public boolean isDiskEmpty() {
        return disc.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disc disc1 = (Disc) o;
        return Objects.equals(disc, disc1.disc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(disc);
    }
}
