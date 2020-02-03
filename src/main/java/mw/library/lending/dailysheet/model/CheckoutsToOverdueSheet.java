package mw.library.lending.dailysheet.model;

import io.vavr.collection.List;
import lombok.Value;

@Value
public class CheckoutsToOverdueSheet {
    List<OverdueCheckout> checkouts;

}
