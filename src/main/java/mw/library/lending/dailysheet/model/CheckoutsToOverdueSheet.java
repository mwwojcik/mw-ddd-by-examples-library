package mw.library.lending.dailysheet.model;

import io.vavr.collection.List;
import io.vavr.collection.Stream;
import lombok.Value;
import mw.library.lending.patron.model.PatronEvent;

@Value
public class CheckoutsToOverdueSheet {
    List<OverdueCheckout> checkouts;

    public Stream<PatronEvent.OverdueCheckoutRegistered> toStreamOfEvents(){
        return checkouts.toStream().map(OverdueCheckout::toEvent);
    }

    public int count() {
        return checkouts.size();
    }
}
