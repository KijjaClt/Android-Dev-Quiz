package com.kijja.quizookbee.quiz2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Quiz2 {
    public static void main(String[] args) {
        String startDate1 = "19960503";
        String endDate1 = "20200304";
        String startDate2 = "19740203";
        String endDate2 = "20230506";

        try {
            boolean isOverlapped = IsOverlapped(startDate1, endDate1, startDate2, endDate2);
            System.out.print(isOverlapped);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static boolean IsOverlapped(String start1, String end1, String start2, String end2) throws ParseException {
        boolean isOverlapped = false;

        SimpleDateFormat sdformat = new SimpleDateFormat("yyyyMMdd");
        Date startDate1 = sdformat.parse(start1);
        Date endDate1 = sdformat.parse(end1);
        Date startDate2 = sdformat.parse(start2);
        Date endDate2 = sdformat.parse(end2);

        if (endDate1.compareTo(startDate2) >= 0 && startDate1.compareTo(endDate2) <= 0) {
            isOverlapped = true;
        }

        if (endDate2.compareTo(startDate1) >= 0 && startDate2.compareTo(endDate1) <= 0) {
            isOverlapped = true;
        }

        return isOverlapped;
    }
}
