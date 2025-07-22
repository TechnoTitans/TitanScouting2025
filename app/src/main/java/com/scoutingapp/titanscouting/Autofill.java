package com.scoutingapp.titanscouting;

import android.app.Application;

import androidx.lifecycle.ViewModelProvider;

import com.scoutingapp.titanscouting.database.MatchRepository;
import com.scoutingapp.titanscouting.database.MatchViewModel;

public class Autofill {

    // set to number of matches. no problems with having extra
    private final int numMatches = 126;

    // copy entire table from TBA for qualification matches
    private final String matchSchedule =
            "Quals 1\n" +
                    "5940\t254\t1318\t1942\t5614\t3414\t174\t120\n" +
                    "Quals 2\n" +
                    "4152\t910\t6002\t2337\t3006\t4122\t182\t88\n" +
                    "Quals 3\n" +
                    "5895\t118\t324\t3015\t3674\t3310\t200\t137\n" +
                    "Quals 4\n" +
                    "2137\t7407\t8592\t1683\t503\t3604\t125\t204\n" +
                    "Quals 5\n" +
                    "1942\t5614\t3414\t3006\t2337\t4122\t97\t155\n" +
                    "Quals 6\n" +
                    "3674\t3015\t3310\t503\t1683\t3604\t140\t166\n" +
                    "Quals 7\n" +
                    "5940\t254\t1318\t910\t4152\t6002\t133\t172\n" +
                    "Quals 8\n" +
                    "118\t5895\t324\t7407\t2137\t8592\t206\t237\n" +
                    "Quals 9\n" +
                    "254\t5940\t1318\t503\t1683\t3604\t136\t202\n" +
                    "Quals 10\n" +
                    "7407\t2137\t8592\t3006\t2337\t4122\t216\t192\n" +
                    "Quals 11\n" +
                    "254\t7056\t10337\t5572\t9029\t7153\t203\t105\n" +
                    "Quals 12\n" +
                    "8020\t1318\t4152\t2337\t118\t5089\t185\t240\n" +
                    "Quals 13\n" +
                    "9024\t957\t2881\t876\t3006\t9105\t138\t156\n" +
                    "Quals 14\n" +
                    "5895\t1086\t10021\t217\t5800\t4122\t223\t125\n" +
                    "Quals 15\n" +
                    "8393\t5614\t1816\t456\t2720\t2145\t146\t171\n" +
                    "Quals 16\n" +
                    "910\t1477\t6002\t587\t5665\t4069\t213\t182\n";

    // copy chart from google sheets. if in quotes, it'll automatically add the \t and stuff
    private final String scouterSchedule = "Match #\tMatch Time ★\tBlue 1\tBlue 2\tBlue 3\tRed 1\tRed 2 \tRed 3\n" +
            "1 - 10\t9:15 AM\tSailee Gokhale\tKenneth Kung\tBhumi Patel\tEmerson Segraves\tEric Kung\tGrace Li\n" +
            "11 - 20\t10:35 AM\tKaitlyn Mak\tJiayu Wang\tLily Stauffer\tAnirudh Vijay\tSaathvik Sundaram\tSahil Desai\n" +
            "21 - 30\t11:55 AM\tAn Nguyen\tRithvik Mylarapu\tVedha Tamilinian\tArnav Paturkar\tRhea Deshpande\tSeth Humphries\n" +
            "31 - 40\t1:15 PM\tSailee Gokhale\tKenneth Kung\tBhumi Patel\tEmerson Segraves\tEric Kung\tGrace Li\n" +
            "41 - 50\t4:09 PM\tKaitlyn Mak\tJiayu Wang\tLily Stauffer\tAnirudh Vijay\tSaathvik Sundaram\tSahil Desai\n" +
            "51 - 60\t5:29 PM\tAn Nguyen\tRithvik Mylarapu\tVedha Tamilinian\tArnav Paturkar\tRhea Deshpande\tSeth Humphries\n" +
            "61 - 70\t6:49 PM\tSailee Gokhale\tKenneth Kung\tBhumi Patel\tEmerson Segraves\tEric Kung\tGrace Li\n" +
            "71 - 80\t9:51 AM\tKaitlyn Mak\tJiayu Wang\tLily Stauffer\tAnirudh Vijay\tSaathvik Sundaram\tSahil Desai\n" +
            "81 - 90\t11:19 AM\tAn Nguyen\tRithvik Mylarapu\tVedha Tamilinian\tArnav Paturkar\tRhea Deshpande\tSeth Humphries\n" +
            "91 - 100\t2:22 PM\tSailee Gokhale\tKenneth Kung\tBhumi Patel\tAnirudh Vijay\tEric Kung\tGrace Li\n" +
            "101 - 110\t3:42 PM\tKaitlyn Mak\tJiayu Wang\tLily Stauffer\tEmerson Segraves\tSaathvik Sundaram\tSahil Desai\n" +
            "111 - 120\t5:02 PM\tSailee Gokhale\tRithvik Mylarapu\tVedha Tamilinian\tArnav Paturkar\tRhea Deshpande\tSeth Humphries\n" +
            "121 - 125\t6:14 PM\tAn Nguyen\tKenneth Kung\tBhumi Patel\tEmerson Segraves\tEric Kung\tGrace Li";
    private final int[] red1 = new int[numMatches];
    private final int[] red2 = new int[numMatches];
    private final int[] red3 = new int[numMatches];
    private final int[] blue1 = new int[numMatches];
    private final int[] blue2 = new int[numMatches];
    private final int[] blue3 = new int[numMatches];

    String[] r1Scouter = new String[numMatches];
    String[] r2Scouter = new String[numMatches];
    String[] r3Scouter = new String[numMatches];
    String[] b1Scouter = new String[numMatches];
    String[] b2Scouter = new String[numMatches];
    String[] b3Scouter = new String[numMatches];

    public Autofill() {
        String[] lines = matchSchedule.split("\n");

        int matchIndex = 1;
        //implementation code uses index starting at 1

        // iterate through the lines and process each match
        for (int i = 0; i < lines.length; i++) {
            // look for match lines like "Quals 1", "Quals 2", etc.
            if (lines[i].contains("Quals")) {
                // The next line contains the team numbers for that match
                String[] columns = lines[i + 1].split("\t");  // Split by tab

                // assign the team numbers to the corresponding arrays
                red1[matchIndex] = Integer.parseInt(columns[0]);
                red2[matchIndex] = Integer.parseInt(columns[1]);
                red3[matchIndex] = Integer.parseInt(columns[2]);
                blue1[matchIndex] = Integer.parseInt(columns[3]);
                blue2[matchIndex] = Integer.parseInt(columns[4]);
                blue3[matchIndex] = Integer.parseInt(columns[5]);

                matchIndex++;  // increment match index for the next match
            }
        }

        String[] schedule = scouterSchedule.split("\n");

        for (int i = 1; i < schedule.length; i++) {
            String[] columns = schedule[i].split("\t");

            String[] matchRange = columns[0].replace(" ", "").split("-");
            int start = Integer.parseInt(matchRange[0]);
            int end = Integer.parseInt(matchRange[1]);

            String b1 = columns[2];
            String b2 = columns[3];
            String b3 = columns[4];
            String r1 = columns[5];
            String r2 = columns[6];
            String r3 = columns[7];

            for (int j = start; j <= end; j++) {
                b1Scouter[j] = b1;
                b2Scouter[j] = b2;
                b3Scouter[j] = b3;
                r1Scouter[j] = r1;
                r2Scouter[j] = r2;
                r3Scouter[j] = r3;
            }
        }
    }

    // Method to get a specific team's number from the parsed schedule
    public int getTeamNumberFromTable(int matchNumber, String position) {
        // Ensure matchNumber is within bounds
        if (matchNumber < 0 || matchNumber > numMatches) {
            return 0;
        }

        // Check position and return the corresponding team number
        if (position != null) {
            switch (position) {
                case "R1":
                    return red1[matchNumber];
                case "R2":
                    return red2[matchNumber];
                case "R3":
                    return red3[matchNumber];
                case "B1":
                    return blue1[matchNumber];
                case "B2":
                    return blue2[matchNumber];
                case "B3":
                    return blue3[matchNumber];
                default:
                    return -1;  // Return -1 for invalid position, shouldn't ever happen
            }
        } else {
            System.out.println("Position is null!");
            return 0;  // Return 0 for null position
        }
    }

    public String getScouterName(int matchNumber, String position) {
        if (matchNumber < 0 || matchNumber > numMatches) {
            return "Error0";
        }

        if (position != null) {
            switch (position) {
                case "R1":
                    return r1Scouter[matchNumber];
                case "R2":
                    return r2Scouter[matchNumber];
                case "R3":
                    return r3Scouter[matchNumber];
                case "B1":
                    return b1Scouter[matchNumber];
                case "B2":
                    return b2Scouter[matchNumber];
                case "B3":
                    return b3Scouter[matchNumber];
                default:
                    return "Error1";
            }
        } else {
            System.out.println("Position is null!");
            return "";  // Return 0 for null position
        }
    }

    public int getNextMatch() {
        // not implemented yet
        return 0;
    }
}