package com.scoutingapp.titanscouting.database;

public class TeamNumberFinder {

    // set to number of matches
    private final int numMatches = 90;

    // Copy entire table for qualification matches
    private final String matchSchedule =
            "Quals 1\n" +
            "1683\t5074\t2415\t5293\t4468\t3344\t115\t96\n" +
            "Quals 2\n" +
            "4112\t832\t2974\t1261\t8080\t4026\t150\t157\n" +
            "Quals 3\n" +
            "4188\t6705\t5219\t10376\t9477\t1414\t54\t57\n" +
            "Quals 4\n" +
            "7451\t5109\t6944\t1648\t6340\t6829\t140\t147\n" +
            "Quals 5\n" +
            "9480\t6925\t1833\t9522\t3318\t8866\t137\t45\n" +
            "Quals 6\n" +
            "10482\t9260\t3329\t8849\t6023\t3635\t104\t65\n" +
            "Quals 7\n" +
            "6919\t5900\t1771\t7538\t8736\t8865\t185\t100\n" +
            "Quals 8\n" +
            "8100\t1002\t2415\t9477\t3344\t5608\t44\t79\n" +
            "Quals 9\n" +
            "6340\t5293\t8080\t6705\t4468\t4112\t149\t55\n" +
            "Quals 10\n" +
            "1683\t9480\t3318\t6829\t5219\t832\t121\t15\n" +
            "Quals 11\n" +
            "8866\t1261\t1833\t8849\t4188\t10376\t123\t29\n" +
            "Quals 12\n" +
            "3329\t9522\t3635\t10482\t5109\t6919\t92\t124\n" +
            "Quals 13\n" +
            "6925\t6944\t8100\t5074\t2974\t7451\t119\t178\n" +
            "Quals 14\n" +
            "1414\t4026\t7538\t8736\t9260\t5608\t90\t112\n" +
            "Quals 15\n" +
            "1648\t1771\t8865\t5900\t6023\t1002\t155\t115\n" +
            "Quals 16\n" +
            "2415\t3318\t4468\t1683\t8849\t5219\t74\t109\n" +
            "Quals 17\n" +
            "9480\t5109\t3344\t1833\t10376\t5293\t96\t123\n" +
            "Quals 18\n" +
            "8866\t3635\t4112\t9477\t6919\t6944\t111\t157\n" +
            "Quals 19\n" +
            "6829\t6705\t8736\t2974\t1261\t10482\t63\t194\n" +
            "Quals 20\n" +
            "1771\t4188\t7451\t1414\t8080\t3329\t156\t118\n" +
            "Quals 21\n" +
            "9260\t8865\t1002\t5608\t1648\t6925\t141\t133\n" +
            "Quals 22\n" +
            "4026\t8100\t9522\t5900\t5074\t7538\t109\t66\n" +
            "Quals 23\n" +
            "832\t6023\t6919\t5109\t2415\t6340\t112\t123\n" +
            "Quals 24\n" +
            "2974\t1833\t8849\t4112\t5219\t9477\t186\t123\n" +
            "Quals 25\n" +
            "3344\t1683\t8866\t1771\t10482\t8736\t125\t153\n" +
            "Quals 26\n" +
            "5608\t3329\t6705\t8080\t6944\t1648\t110\t126\n" +
            "Quals 27\n" +
            "10376\t4026\t4468\t7451\t7538\t6925\t81\t78\n" +
            "Quals 28\n" +
            "5900\t832\t9522\t9260\t6829\t4188\t67\t129\n" +
            "Quals 29\n" +
            "5074\t1414\t6340\t1002\t3635\t9480\t115\t146\n" +
            "Quals 30\n" +
            "1261\t5293\t3318\t6023\t8100\t8865\t118\t82\n" +
            "Quals 31\n" +
            "3344\t4112\t3329\t8866\t1648\t8736\t99\t134\n" +
            "Quals 32\n" +
            "5109\t8849\t7538\t6925\t6705\t10482\t98\t90\n" +
            "Quals 33\n" +
            "4468\t5900\t6829\t5608\t2974\t2415\t64\t142\n" +
            "Quals 34\n" +
            "8080\t7451\t9260\t5219\t6919\t5074\t177\t90\n" +
            "Quals 35\n" +
            "832\t9480\t1261\t6944\t1002\t1771\t159\t182\n" +
            "Quals 36\n" +
            "1833\t8100\t9477\t3635\t5293\t1414\t197\t115\n" +
            "Quals 37\n" +
            "4188\t4026\t1683\t8865\t6340\t3318\t152\t112\n" +
            "Quals 38\n" +
            "9522\t6023\t4468\t10376\t2974\t6705\t103\t153\n" +
            "Quals 39\n" +
            "8736\t5074\t8849\t8080\t5900\t5109\t71\t87\n" +
            "Quals 40\n" +
            "6829\t8866\t1002\t2415\t9260\t6944\t127\t115\n" +
            "Quals 41\n" +
            "6919\t1414\t6925\t1648\t3344\t1261\t141\t144\n" +
            "Quals 42\n" +
            "9477\t3635\t4026\t5219\t1771\t5293\t137\t158\n" +
            "Quals 43\n" +
            "1683\t7451\t6023\t7538\t9480\t9522\t135\t86\n" +
            "Quals 44\n" +
            "3318\t5608\t8100\t3329\t10376\t6340\t88\t128\n" +
            "Quals 45\n" +
            "8865\t1833\t832\t4112\t4188\t10482\t149\t137\n" +
            "Quals 46\n" +
            "8866\t1414\t9260\t2974\t4468\t5109\t101\t146\n" +
            "Quals 47\n" +
            "9477\t1261\t2415\t5074\t8080\t3635\t117\t108\n" +
            "Quals 48\n" +
            "5219\t9522\t7451\t6023\t8736\t3344\t92\t141\n" +
            "Quals 49\n" +
            "1648\t5900\t8849\t5293\t8100\t1683\t64\t137\n" +
            "Quals 50\n" +
            "6829\t8865\t10376\t1002\t3329\t4026\t83\t134\n" +
            "Quals 51\n" +
            "9480\t10482\t5608\t6340\t6925\t4112\t116\t119\n" +
            "Quals 52\n" +
            "832\t6944\t7538\t6919\t1833\t4188\t103\t187\n" +
            "Quals 53\n" +
            "3318\t1771\t9260\t6705\t2415\t7451\t159\t87\n" +
            "Quals 54\n" +
            "1414\t1648\t5109\t4468\t9477\t1683\t81\t160\n" +
            "Quals 55\n" +
            "8100\t8866\t8080\t9522\t8865\t1261\t96\t133\n" +
            "Quals 56\n" +
            "5608\t6340\t6023\t8849\t4112\t5293\t170\t139\n" +
            "Quals 57\n" +
            "1002\t6925\t5219\t1833\t10482\t5900\t101\t175\n" +
            "Quals 58\n" +
            "6944\t8736\t3635\t10376\t6919\t3318\t104\t118\n" +
            "Quals 59\n" +
            "3344\t4026\t6705\t3329\t9480\t4188\t119\t133\n" +
            "Quals 60\n" +
            "7538\t6829\t2974\t1771\t5074\t832\t62\t153\n" +
            "Quals 61\n" +
            "8865\t5293\t9477\t7451\t8849\t1261\t96\t146\n" +
            "Quals 62\n" +
            "8080\t5608\t5219\t5109\t1002\t9522\t80\t146\n" +
            "Quals 63\n" +
            "6944\t4112\t10376\t5900\t1683\t1414\t126\t100\n" +
            "Quals 64\n" +
            "4468\t6919\t9480\t10482\t3318\t6023\t88\t88\n" +
            "Quals 65\n" +
            "6705\t1833\t5074\t4026\t8866\t832\t122\t108\n" +
            "Quals 66\n" +
            "6340\t3635\t9260\t3344\t7538\t1771\t135\t157\n" +
            "Quals 67\n" +
            "6925\t4188\t2974\t2415\t1648\t3329\t177\t136\n" +
            "Quals 68\n" +
            "5109\t10376\t8736\t4112\t6829\t8100\t96\t63\n" +
            "Quals 69\n" +
            "1261\t4468\t6944\t8865\t5219\t9480\t137\t71\n" +
            "Quals 70\n" +
            "6023\t9477\t6705\t4026\t5608\t6919\t134\t127\n" +
            "Quals 71\n" +
            "6340\t3344\t5900\t832\t3318\t8080\t96\t117\n" +
            "Quals 72\n" +
            "2974\t1683\t1648\t3635\t7451\t1833\t170\t208\n" +
            "Quals 73\n" +
            "1414\t1771\t6829\t6925\t9522\t8849\t170\t109\n" +
            "Quals 74\n" +
            "8736\t2415\t4188\t8100\t9260\t5074\t96\t102\n" +
            "Quals 75\n" +
            "5293\t10482\t1002\t7538\t3329\t8866\t93\t103\n" +
            "Quals 76\n" +
            "3318\t4112\t5900\t6705\t1261\t5109\t83\t157\n" +
            "Quals 77\n" +
            "6919\t3344\t8080\t1833\t1683\t5608\t147\t183\n" +
            "Quals 78\n" +
            "3635\t832\t10376\t8849\t1414\t8865\t102\t85\n" +
            "Quals 79\n" +
            "8736\t2974\t9477\t1771\t6340\t9480\t191\t221\n" +
            "Quals 80\n" +
            "5219\t7538\t8100\t4468\t3329\t6925\t70\t84\n" +
            "Quals 81\n" +
            "6023\t6829\t5293\t4188\t6944\t8866\t148\t164\n" +
            "Quals 82\n" +
            "9522\t2415\t10482\t4026\t7451\t1648\t69\t186\n" +
            "Quals 83\n" +
            "5074\t1002\t4112\t9260\t6705\t1683\t115\t150\n" +
            "Quals 84\n" +
            "1261\t5608\t1414\t3318\t5109\t1833\t97\t158\n" +
            "Quals 85\n" +
            "3329\t9477\t1771\t8100\t832\t4468\t181\t97\n" +
            "Quals 86\n" +
            "4188\t8080\t6023\t3635\t6925\t6829\t124\t132\n" +
            "Quals 87\n" +
            "2415\t8849\t3344\t6944\t8865\t4026\t77\t143\n" +
            "Quals 88\n" +
            "7451\t8866\t6340\t9260\t5219\t5900\t166\t91\n" +
            "Quals 89\n" +
            "10482\t7538\t1648\t9480\t10376\t5074\t107\t75\n" +
            "Quals 90\n" +
            "5293\t9522\t2974\t1002\t8736\t6919\t137\t175\n";


    private final int[] red1 = new int[numMatches];
    private final int[] red2 = new int[numMatches];
    private final int[] red3 = new int[numMatches];
    private final int[] blue1 = new int[numMatches];
    private final int[] blue2 = new int[numMatches];
    private final int[] blue3 = new int[numMatches];

    public TeamNumberFinder() {
        String[] lines = matchSchedule.split("\n");

        int matchIndex = 0;  // To keep track of which match we are on

        // Iterate through the lines and process each match
        for (int i = 0; i < lines.length; i++) {
            // Look for match lines like "Quals 1", "Quals 2", etc.
            if (lines[i].contains("Quals")) {
                // The next line contains the team numbers for that match
                String[] columns = lines[i + 1].split("\t");  // Split by tab

                // Assign the team numbers to the corresponding arrays
                red1[matchIndex] = Integer.parseInt(columns[0]);
                red2[matchIndex] = Integer.parseInt(columns[1]);
                red3[matchIndex] = Integer.parseInt(columns[2]);
                blue1[matchIndex] = Integer.parseInt(columns[3]);
                blue2[matchIndex] = Integer.parseInt(columns[4]);
                blue3[matchIndex] = Integer.parseInt(columns[5]);

                matchIndex++;  // Increment match index for the next match
            }
        }
    }

    // Method to get a specific team's number from the parsed schedule
    public int getTeamNumberFromTable(int matchNumber, String position) {
        // Ensure matchNumber is within bounds
        if (matchNumber < 0 || matchNumber > numMatches) {
            System.out.println("Invalid match number!");
            return -1;  // Return -1 for invalid match
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
                System.out.println("Invalid position!");
                return -1;  // Return -1 for invalid position
            }
        } else {
            System.out.println("Position is null!");
            return -1;  // Return -1 for null position
        }
    }
}