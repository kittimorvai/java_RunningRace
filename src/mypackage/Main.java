package mypackage;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
//    public static final int MINUTESTOSEC = 60;
//    public static final int HOURSTOMINUTESTOSEC = 3600;

    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<String> result = new ArrayList<>();

        try (Scanner s = new Scanner(new FileReader("C:\\Users\\Kitti\\Documents\\JavaPrograms\\RunningRace\\src\\mypackage\\results.txt"))) {
            int numberOfRunners = s.nextInt();
            s.nextLine();
            while (s.hasNext()) {
                result.add(s.nextLine());
            }
        } catch (IOException e) {
            e.getStackTrace();
        }

        // Checking runtime

//        long startTime = System.nanoTime();
//        calculateBest(result);
//        long endTime   = System.nanoTime();
//        long totalTime = endTime - startTime;
//        System.out.println(totalTime);
    }

    public static void calculateBest(ArrayList<String> results) {
        String[] bestResult = new String[results.get(0).length()];

        for (int i = 0; i < results.size(); i++) {
            String[] currentTime = results.get(i).split(":");

            if (i == 0) {
                bestResult = currentTime;
            }

            if (currentTime[0].compareTo(bestResult[0]) < 0) {
                bestResult = currentTime;
                continue;
            }
            if (currentTime[0].compareTo(bestResult[0]) == 0) {
                if (currentTime[1].compareTo(bestResult[1]) < 0) {
                    bestResult = currentTime;
                    continue;
                }
            }
            if (currentTime[0].compareTo(bestResult[0]) == 0) {
                if (currentTime[1].compareTo(bestResult[1]) == 0) {
                    if (currentTime[2].compareTo(bestResult[2]) < 0) {
                        bestResult = currentTime;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(bestResult));
    }




  //=======================================================================================
    //Conclusion: && requires a longer runtime than several if statements

//    public static void calculateBest(ArrayList<String> results) {
//        String[] bestResult = new String[results.get(0).length()];
//
//        for (int i = 0; i < results.size(); i++) {
//            String[] currentTime = results.get(i).split(":");
//
//            if (i == 0) {
//                bestResult = currentTime;
//            }
//
//            if (currentTime[0].compareTo(bestResult[0]) < 0) {
//                bestResult = currentTime;
//                continue;
//            }
//            if (currentTime[0].compareTo(bestResult[0]) == 0 && currentTime[1].compareTo(bestResult[1]) < 0) {
//                    bestResult = currentTime;
//                    continue;
//            }
//            if (currentTime[0].compareTo(bestResult[0]) == 0 && currentTime[1].compareTo(bestResult[1]) == 0 && currentTime[2].compareTo(bestResult[2]) < 0) {
//                        bestResult = currentTime;
//            }
//        }
//        System.out.println(Arrays.toString(bestResult));
//    }
// =======================================================================================






//=======================================================================================
//Conclusion: System.out in the convert method requires a long runtime

//    public static void calculateBest (ArrayList<String> results){
//        int sumOfSeconds = 0;
//        for (int i = 0; i < results.size(); i++) {
//            int currentSum = 0;
//            String[] currentTime = results.get(i).split(":");
//            currentSum = (Integer.parseInt(currentTime[0]) * HOURSTOMINUTESTOSEC) + (Integer.parseInt(currentTime[1]) * MINUTESTOSEC) + Integer.parseInt(currentTime[2]);
//            if(i == 0){
//                sumOfSeconds = currentSum;
//            }
//            if(currentSum < sumOfSeconds){
//                sumOfSeconds = currentSum;
//            }
//        }
//        convertBackToString(sumOfSeconds);
//    }
//    //Still needs to be formatted under 10 to show as eg. '02:32:57'
//    private static void convertBackToString (int sumOfSeconds){
//        int hour = sumOfSeconds / HOURSTOMINUTESTOSEC;
//        int minute = sumOfSeconds / MINUTESTOSEC - hour * MINUTESTOSEC;
//        int second = sumOfSeconds % MINUTESTOSEC;
//
//        System.out.println(hour + ":" + minute + ":" + second);
//    }
//=======================================================================================

}
