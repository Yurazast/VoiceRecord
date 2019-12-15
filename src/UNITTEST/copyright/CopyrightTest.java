package copyright;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CopyrightTest {

    @org.junit.Test
    public void printTest() {
        String expected;
        try {
            expected = "\n-------------------------------------------------------------------------\n" +
                    "Copyright (c) 2019 by Yurii Zastavnyi\n\n" +
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
                    "portions of the VoiceRecord.\n" +
                    "-------------------------------------------------------------------------\n";
            Copyright.print();
            assertEquals(expected, Copyright.lastExecutionResult);
        } catch (IOException | AssertionError | InterruptedException e) {
            fail(e.getLocalizedMessage());
        }
    }
}