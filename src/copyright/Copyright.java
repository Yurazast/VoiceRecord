package copyright;

import email.EmailSender;
import log.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Copyright {
    private static char[] copyright;

    static {
        try {
            copyright = ("Copyright (c) 2019 by Yurii Zastavnyi\n\n" +
                    "Program: VoiceRecord v4.2.6\n" +
                    "Last changed: " + new SimpleDateFormat("dd/MM/yyy HH:mm").format(Files.getLastModifiedTime(Paths.get("../VoiceRecord"), LinkOption.NOFOLLOW_LINKS).toMillis()) +
                    "\n\nAll rights reserved.\n" +
                    "Permission is hereby granted, free of charge, to any person obtaining a\n" +
                    "copy of this software and associated documentation files, to deal in the\n" +
                    "VoiceRecord without restriction, including without limitation the rights\n" +
                    "to use, copy, modify, merge, publish, distribute, sublicense, and/or sell\n" +
                    "copies of the VoiceRecord, and to permit persons to whom the VoiceRecord\n" +
                    "is furnished to do so, subject to the following condition:\n\n" +
                    "The above copyright notice shall be included in all copies or substantial\n" +
                    "portions of the VoiceRecord.").toCharArray();
        } catch (IOException e) {
            Logger.log("ERROR: " + e.getMessage() + "\n" + Arrays.stream(e.getStackTrace()).map(i -> i + "\n").collect(Collectors.joining()));
            EmailSender.sendError("ERROR: " + e.getMessage() + "\n" + Arrays.stream(e.getStackTrace()).map(i -> i + "\n").collect(Collectors.joining()));
            try {
                throw new NoSuchFileException("cannot find directory 'VoiceRecord'");
            } catch (NoSuchFileException ex) {
                ex.printStackTrace();
            }
        }
    }

    static String lastExecutionResult;

    public static void print() throws InterruptedException {
        System.out.println("\n-------------------------------------------------------------------------");
        lastExecutionResult = "\n-------------------------------------------------------------------------\n";
        for (char c : copyright) {
            System.out.print(c);
            lastExecutionResult += c;
            if (c == '\n') Thread.sleep(450);
            Thread.sleep(50);
        }
        System.out.println("\n-------------------------------------------------------------------------");
        lastExecutionResult += "\n-------------------------------------------------------------------------\n";
        Thread.sleep(2000);
    }
}
