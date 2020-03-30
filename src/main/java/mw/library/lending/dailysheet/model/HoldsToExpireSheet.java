package mw.library.lending.dailysheet.model;

import lombok.Value;
import mw.library.lending.patron.model.PatronEvent;
import org.springframework.context.event.EventListener;

import java.util.List;
import java.util.stream.Stream;

@Value
public class HoldsToExpireSheet {
  List<ExpiredHold> expiredHolds;

  @EventListener
  public Stream<PatronEvent.BookHoldExpired> toStreamOfEvents() {
    return expiredHolds.stream().map(ExpiredHold::toEvent);
  }

  public int count() {
    return expiredHolds.size();
  }
}
