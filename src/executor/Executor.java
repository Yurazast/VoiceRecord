package executor;

import convertTime.TimeStringToIntArray;
import email.EmailSender;
import log.Logger;
import music.Disc;
import music.MusicTrack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Executor {
    public String lastExecutionResult;
    Disc disc;

    public Executor(Disc disc) {
        this.disc = disc;
    }

    private static <T> T returnFirst(T first, T second) {
        return first;
    }

    private static String checkCount(int count) {
        if (count == 0)
            return ("No matches found.");
        else if (count == 1)
            return ("1 match found:");
        else
            return (count + " matches found:");
    }

    private static String checkCounter(int count) {
        if (count == 0)
            return ("no music tracks.");
        else if (count == 1)
            return ("1 music track.");
        else
            return (count + " music tracks.");
    }

    public void getMusicTracksFromInput(Scanner scanner) {
        Logger.log("Started input from keyboard...");
        int counter = 0;
        while (true) {
            System.out.print("Enter name of a track ('n' to stop input): ");
            String name = scanner.next();
            if (name.equals("n"))
                break;
            System.out.print("Enter style of the track: ");
            String style = scanner.next();
            System.out.print("Enter duration of the track or track length: ");
            if (scanner.hasNextInt()) {
                Integer duration = scanner.nextInt();
                disc.addMusicTrack(new MusicTrack(name, duration, style));
            } else {
                String length = scanner.next();
                disc.addMusicTrack(new MusicTrack(name, length, style));
            }
            counter++;
        }
        Logger.log("Created " + checkCounter(counter));
        Logger.log("Ended input.");
    }

    public void getMusicTracksFromFile() {
        Logger.log("Started input from file...");
        Scanner scanner;
        int counter = 0;
        try {
            scanner = new Scanner(new File("/" + System.getProperty("user.name") + "/IdeaProjects/VoiceRecord/src/MusicTracks.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File 'MusicTracks.txt' not found");
            Logger.log("ERROR: " + e.getMessage() + "\n" + Arrays.stream(e.getStackTrace()).map(i -> i + "\n").collect(Collectors.joining()));
            EmailSender.sendError("ERROR: " + e.getMessage() + "\n" + Arrays.stream(e.getStackTrace()).map(i -> i + "\n").collect(Collectors.joining()));
            return;
        }
        while (scanner.hasNext()) {
            String name = scanner.next();
            if (scanner.hasNextInt()) {
                Integer duration = scanner.nextInt();
                String style = scanner.next();
                disc.addMusicTrack(new MusicTrack(name, duration, style));
            } else {
                String length = scanner.next();
                String style = scanner.next();
                disc.addMusicTrack(new MusicTrack(name, length, style));
            }
            counter++;
        }
        Logger.log("Created " + checkCounter(counter));
        Logger.log("Ended input.");
    }

    public List<MusicTrack> findTrackLengthInRange(Scanner scanner) {
        if (disc.isDiskEmpty()) {
            System.out.println("No music tracks");
            return disc.getDisc();
        }
        List<MusicTrack> matches = new ArrayList<>();
        int count = 0;
        System.out.print("\nEnter search range: ");
        if (scanner.hasNextInt()) {
            Integer start = scanner.nextInt(), end = scanner.nextInt();
            if (start > end)
                start = returnFirst(end, end = start);

            System.out.println("Search range: (" + start + ", " + end + ')');
            for (MusicTrack mc : disc.getDisc()) {
                if (mc.isInRange(start, end)) {
                    matches.add(mc);
                    count++;
                }
            }
            Logger.log("Started a search in range: (" + start + ", " + end + ")");
            Logger.log(checkCount(count).replaceFirst(".$", "."));
        } else {
            String durationStart = scanner.next();
            String durationEnd = scanner.next();
            durationStart = MusicTrack.checkTrackLength(durationStart);
            durationEnd = MusicTrack.checkTrackLength(durationEnd);
            if (durationStart.compareTo(durationEnd) > 0)
                durationStart = returnFirst(durationEnd, durationEnd = durationStart);

            System.out.println("Search range: (" + durationStart + ", " + durationEnd + ')');
            Integer[] timeStart = TimeStringToIntArray.convertTime(durationStart);
            Integer[] timeEnd = TimeStringToIntArray.convertTime(durationEnd);
            for (MusicTrack mc : disc.getDisc()) {
                if (mc.isInRange(timeStart[0] * 3600 + timeStart[1] * 60 + timeStart[2], timeEnd[0] * 3600 + timeEnd[1] * 60 + timeEnd[2])) {
                    matches.add(mc);
                    count++;
                }
            }
            Logger.log("Started a search in range: (" + durationStart + ", " + durationEnd + ')');
            Logger.log(checkCount(count).replaceFirst(".$", "."));
        }

        System.out.println('\n' + checkCount(count) + '\n');
        return matches;
    }

    public void sortDisc(Function... f) {
        if (f.length == 0) {
            Logger.log("ERROR: sortDisc empty sort comparators");
            EmailSender.sendError("ERROR: sortDisc empty sort comparators");
            throw new ArrayIndexOutOfBoundsException("sortDisc empty sort comparators");
        }
        Comparator<MusicTrack> byStyle = Comparator.comparing(f[0]);
        if (f.length != 1)
            byStyle = byStyle.thenComparing(f[1]);
        disc.getDisc().sort(byStyle);
    }

    public void printDisk() {
        if (this.disc.isDiskEmpty())
            System.out.println("No music tracks");
        else {
            Logger.log("Printing music tracks...");
            System.out.println("\nDisc has those music tracks:\n");
            print(this.disc.getDisc());
            Logger.log("Printed.");
        }
    }

    public void print(List<MusicTrack> disk) {
        if (disk.isEmpty())
            return;
        lastExecutionResult = "";
        System.out.println(" N |\t\t\t  Name  \t\t\t| Track length | Duration(sec) | \t  Style");
        System.out.println("--------------------------------------------------------------------------------------");
        AtomicInteger count = new AtomicInteger();
        disk.forEach(mc -> System.out.println(" " + count.incrementAndGet() + mc));
        count.set(0);
        disk.forEach(mc -> lastExecutionResult += (" " + count.incrementAndGet() + mc + '\n'));
    }
}