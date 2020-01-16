package mw.library.lending.patron.model;

import lombok.Value;
import mw.library.lending.book.model.AvailableBook;

import java.util.Set;

@Value
public class PatronHolds {
    public static final int MAX_NUMBER_OF_HOLDS = 5;

    Set<Hold> resourcesOnHold;

    int count(){
        return resourcesOnHold.size();
    }

    boolean maximumHoldsAfterHolding(AvailableBook book) {
        return count() + 1 == MAX_NUMBER_OF_HOLDS;
    }
}
