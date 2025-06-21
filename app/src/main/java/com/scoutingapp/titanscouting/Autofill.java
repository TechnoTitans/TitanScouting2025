package com.scoutingapp.titanscouting;

public class Autofill {

    //use first/tba api later

    // set to number of matches
    private final int numMatches = 126;

    // Copy entire table for qualification matches
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

    private final int[] red1 = new int[numMatches];
    private final int[] red2 = new int[numMatches];
    private final int[] red3 = new int[numMatches];
    private final int[] blue1 = new int[numMatches];
    private final int[] blue2 = new int[numMatches];
    private final int[] blue3 = new int[numMatches];

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
    }

    // Method to get a specific team's number from the parsed schedule
    public int getTeamNumberFromTable(int matchNumber, String position) {
        // Ensure matchNumber is within bounds
        if (matchNumber < 0 || matchNumber > numMatches) {
            return 0;
        }

        // Check position and return the corresponding team number
        if (position != null) {
            if (position.equals("R1")) {
                return red1[matchNumber];
            } else if (position.equals("R2")) {
                return red2[matchNumber];
            } else if (position.equals("R3")) {
                return red3[matchNumber];
            } else if (position.equals("B1")) {
                return blue1[matchNumber];
            } else if (position.equals("B2")) {
                return blue2[matchNumber];
            } else if (position.equals("B3")) {
                return blue3[matchNumber];
            } else {
                return -1;  // Return -1 for invalid position, shouldn't ever happen
            }
        } else {
            System.out.println("Position is null!");
            return 0;  // Return 0 for null position
        }
    }
}