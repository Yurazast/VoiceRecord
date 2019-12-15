/******************************************************************************
 * Copyright © 2019 by Yurii Zastavnyi                                        *
 *                                                                            *
 * Program: VoiceRecord v4.2.7                                                *
 * Last changed: 15/12/2019, 19:34                                            *
 *                                                                            *
 * All rights reserved.                                                       *
 * Permission is hereby granted, free of charge, to any person obtaining a    *
 * copy of this software and associated documentation files, to deal in the   *
 * VoiceRecord without restriction, including without limitation the rights   *
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell  *
 * copies of the VoiceRecord, and to permit persons to whom the VoiceRecord   *
 * is furnished to do so, subject to the following condition:                 *
 *                                                                            *
 * The above copyright notice shall be included in all copies or substantial  *
 * portions of the VoiceRecord.                                               *
 ******************************************************************************/

import copyright.Copyright;
import menu.Menu;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<String> array = Arrays.asList("yes", "YES", "y", "Y", "agree", "AGREE", "accept", "ACCEPT", "skip", "SKIP");
    private static String input = "";

    public static void main(String[] args) throws InterruptedException {
        if (args.length == 0 || !array.contains(args[0]))
            Copyright.print();
        if (args.length >= 2) {
            for (int i = 1; i < args.length; i++)
                input += args[i] + '\n';
            new Menu().run(new Scanner(input));
        } else
            new Menu().run(new Scanner(System.in));
    }
}