package com.my.task;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DateSorterTest {

    DateSorter dateSorter = new DateSorter();

    @Test
    public void testDefaultCases1() {
        List<LocalDate> unsortedDates = new ArrayList<>();

        LocalDate date1 = LocalDate.of(2005, 7, 1);
        LocalDate date2 = LocalDate.of(2005, 1, 2);
        LocalDate date3 = LocalDate.of(2005, 1, 1);
        LocalDate date4 = LocalDate.of(2005, 5, 3);
        unsortedDates.add(date1);
        unsortedDates.add(date2);
        unsortedDates.add(date3);
        unsortedDates.add(date4);

        List<LocalDate> expected = List.of(date3, date2, date1, date4);

        assertThat(dateSorter.sortDates(unsortedDates))
                .isEqualTo(expected);

    }

    @Test
    public void testDefaultCases2() {
        List<LocalDate> unsortedDates = new ArrayList<>();

        LocalDate date1 = LocalDate.of(2001, 1, 1);
        LocalDate date2 = LocalDate.of(2002, 2, 2);
        LocalDate date3 = LocalDate.of(2003, 3, 1);
        LocalDate date4 = LocalDate.of(2004, 4, 3);
        LocalDate date5 = LocalDate.of(2005, 5, 1);
        LocalDate date6 = LocalDate.of(2006, 6, 2);
        LocalDate date7 = LocalDate.of(2007, 8, 1);
        LocalDate date8 = LocalDate.of(2008, 9, 3);
        LocalDate date9 = LocalDate.of(2008, 10, 3);
        unsortedDates.add(date1);
        unsortedDates.add(date2);
        unsortedDates.add(date3);
        unsortedDates.add(date4);
        unsortedDates.add(date5);
        unsortedDates.add(date6);
        unsortedDates.add(date7);
        unsortedDates.add(date8);
        unsortedDates.add(date9);

        List<LocalDate> expected = List.of(
                date1,
                date2,
                date3,
                date4,
                date8,
                date9,
                date7,
                date6,
                date5
        );

        assertThat(dateSorter.sortDates(unsortedDates))
                .isEqualTo(expected);

    }

    @Test
    public void testDefaultCases3() {
        List<LocalDate> unsortedDates = new ArrayList<>();

        LocalDate date1 = LocalDate.of(2006, 8, 1);
        LocalDate date2 = LocalDate.of(2006, 8, 31);
        LocalDate date3 = LocalDate.of(2006, 5, 1);
        LocalDate date4 = LocalDate.of(2006, 4, 30);
        unsortedDates.add(date1);
        unsortedDates.add(date2);
        unsortedDates.add(date3);
        unsortedDates.add(date4);

        List<LocalDate> expected = List.of(date4, date2, date1, date3);

        assertThat(dateSorter.sortDates(unsortedDates))
                .isEqualTo(expected);

    }

    @Test
    public void testNoMonthsWithoutRCase() {
        List<LocalDate> unsortedDates = new ArrayList<>();

        LocalDate date1 = LocalDate.of(2003, 2, 12);
        LocalDate date2 = LocalDate.of(2004, 9, 15);
        LocalDate date3 = LocalDate.of(2004, 9, 14);
        LocalDate date4 = LocalDate.of(2006, 12, 21);
        unsortedDates.add(date1);
        unsortedDates.add(date2);
        unsortedDates.add(date3);
        unsortedDates.add(date4);

        List<LocalDate> expected = List.of(date1, date3, date2, date4);

        assertThat(dateSorter.sortDates(unsortedDates))
                .isEqualTo(expected);

    }

    @Test
    public void testNoMonthsWithRCase() {
        List<LocalDate> unsortedDates = new ArrayList<>();

        LocalDate date1 = LocalDate.of(2006, 7, 15);
        LocalDate date2 = LocalDate.of(2006, 7, 4);
        LocalDate date3 = LocalDate.of(2006, 5, 1);
        LocalDate date4 = LocalDate.of(2006, 6, 30);
        unsortedDates.add(date1);
        unsortedDates.add(date2);
        unsortedDates.add(date3);
        unsortedDates.add(date4);

        List<LocalDate> expected = List.of(date1, date2, date4, date3);

        assertThat(dateSorter.sortDates(unsortedDates))
                .isEqualTo(expected);

    }

}
