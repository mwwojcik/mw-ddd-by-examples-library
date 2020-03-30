package mw.library.lending.dailysheet.model;


import lombok.Value;
import mw.library.lending.patron.model.PatronEvent;

import java.util.List;
import java.util.stream.Stream;

@Value
public class CheckoutsToOverdueSheet {
    List<OverdueCheckout> checkouts;

    public Stream<PatronEvent.OverdueCheckoutRegistered> toStreamOfEvents(){
        return checkouts.stream().map(OverdueCheckout::toEvent);
    }

    public int count() {
        return checkouts.size();
    }
}
