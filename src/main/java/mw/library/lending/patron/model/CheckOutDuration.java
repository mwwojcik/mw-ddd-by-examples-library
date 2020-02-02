package mw.library.lending.patron.model;

import lombok.Value;

import java.time.Duration;
import java.time.Instant;

@Value
public class CheckOutDuration {
    static final int MAX_CHECKOUT_DURATION = 60;
    NumberOfDays noOfDays;
    Instant from;

    private CheckOutDuration(NumberOfDays noOfDays, Instant from) {
        if (noOfDays.isGreaterThan(MAX_CHECKOUT_DURATION)) {
            throw new IllegalArgumentException(String.format("Cannot checkout for more than %s days!", MAX_CHECKOUT_DURATION));
        }
        this.noOfDays = noOfDays;
        this.from = from;
    }

    public static CheckOutDuration forNoOfDays(int noOfDays) {
        return forNoOfDays(noOfDays, Instant.now());
    }

    public static CheckOutDuration forNoOfDays(int noOfDays, Instant from) {
        return new CheckOutDuration(NumberOfDays.of(noOfDays), from);
    }

    public static CheckOutDuration maxDuration() {
        return forNoOfDays(MAX_CHECKOUT_DURATION);
    }

    public Instant to(int numOfDays) {
        return from.plus(Duration.ofDays(noOfDays.getDays()));
      }
}
