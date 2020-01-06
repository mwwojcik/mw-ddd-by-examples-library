package mw.library.lending.patron.model;

import lombok.Value;

@Value
public class NumberOfDays {
    int days;

    private NumberOfDays(int days) {
        if (days <= 0) {
            throw new IllegalArgumentException("Cannot use negative integers.");
        }
        this.days = days;
    }

    public static NumberOfDays of(int day) {
        return new NumberOfDays(day);
    }

    public boolean isGreaterThan(int days) {
        return this.days > days;
    }
}
