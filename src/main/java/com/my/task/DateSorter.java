package com.my.task;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DateSorter implements IDateSorter {
    @Override
    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {

        List<LocalDate> sortedDates = new ArrayList<>(unsortedDates);

        sortedDates.sort((o1, o2) -> { // using functional interface comparator for creating custom sort
            boolean o1ContainsLetterR = containsLetterR(o1.getMonth());
            boolean o2ContainsLetterR = containsLetterR(o2.getMonth());

            if(o1ContainsLetterR ^ o2ContainsLetterR) { // checks if one date has 'r', but second one doesn't
                return o1ContainsLetterR ? -1 : 1; // date with 'r' should be before
            }
            return o1ContainsLetterR ? o1.compareTo(o2) : o2.compareTo(o1); // simple comparison (considering asc/desc)
        });

        return sortedDates;
    }

    private static boolean containsLetterR(Month month) {
        return switch (month) {
            case JANUARY, FEBRUARY, MARCH, APRIL, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER -> true;
            case MAY, JUNE, JULY, AUGUST -> false;
        };
    }

}
