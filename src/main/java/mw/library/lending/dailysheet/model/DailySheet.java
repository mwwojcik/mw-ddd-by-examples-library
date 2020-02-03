package mw.library.lending.dailysheet.model;

import mw.library.lending.patron.model.PatronEvent;

public interface DailySheet {
    CheckoutsToOverdueSheet queryForCheckoutsToOverdue();

    HoldsToExpireSheet gqueryForHoldsToExpireSheet();

    void handle(PatronEvent.BookPlacedOnHold event);

    void handle(PatronEvent.BookHoldCanceled event);

    //void handle(BookHoldExpired event);
    void handle(PatronEvent.BookCheckedOut event);
    //void handle(PatronEvent.BookReturned event);

}
