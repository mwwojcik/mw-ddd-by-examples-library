package mw.library.lending.patron.model;

import lombok.Value;

import java.time.Instant;

@Value
public class CheckoutDuration {
    static final int MAX_CHECKOUT_DURATION=60;
    NumberOfDays noOfDays;
    Instant from;
}
