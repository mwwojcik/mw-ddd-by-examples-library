package mw.library.lending.dailysheet.model;

import io.vavr.collection.List;
import io.vavr.collection.Stream;
import lombok.Value;
import mw.library.lending.patron.model.PatronEvent;
import org.springframework.context.event.EventListener;

@Value
public class HoldsToExpireSheet {
    List<ExpiredHold> expiredHolds;

    @EventListener
    public Stream<PatronEvent.BookHoldExpired> toStreamOfEvents() {
        return expiredHolds.toStream().map(ExpiredHold::toEvent);
    }

    public int count() {
        return expiredHolds.size();
    }

}
