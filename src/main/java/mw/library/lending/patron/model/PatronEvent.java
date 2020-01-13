package mw.library.lending.patron.model;

import io.vavr.collection.List;
import io.vavr.control.Option;
import lombok.Value;
import mw.library.catalogue.BookId;
import mw.library.catalogue.BookType;
import mw.library.commons.events.DomainEvent;
import mw.library.lending.librarybranch.model.LibraryBranchId;
import org.apache.tomcat.jni.Library;

import java.time.Instant;
import java.util.UUID;

interface PatronEvent extends DomainEvent {
    default PatronId patronId(){
        return new PatronId(getPatronId());
    }

    UUID getPatronId();

    default UUID getAggregateId(){
        return getPatronId();
    }

    default List<DomainEvent> normalize(){
        return List.of(this);
    }

    @Value
    class PatronCreated implements PatronEvent{
        UUID eventId=UUID.randomUUID();
        Instant when;
        UUID patronId;
        PatronType patronType;

        public static PatronCreated now(PatronId patronId,PatronType type){
            return new PatronCreated(Instant.now(),patronId.getPatronId(),type);
        }
    }

    @Value
    class BookPlacedOnHold implements PatronEvent{
        UUID eventId=UUID.randomUUID();
        Instant when;
        UUID patronId;
        UUID bookId;
        BookType bookType;
        UUID libraryBranchId;
        Instant holdFrom;
        Instant holdTill;

        public static BookPlacedOnHold bookPlacedOnHoldNow(BookId bookId, BookType bookType,
                                       LibraryBranchId libraryBranchId,
                                       PatronId paronId,
                                       HoldDuration holdDuration){
            return new BookPlacedOnHold(
                    Instant.now(),
                    paronId.getPatronId(),
                    bookId.getBookId(),
                    bookType,
                    libraryBranchId.getLibraryBranchId(),
                    holdDuration.getFrom(),
                    holdDuration.getTo().getOrNull()
            ) ;
        }

    }

    @Value
    class BookPlacedOnHoldEvents implements PatronEvent{
        UUID eventId=UUID.randomUUID();
        UUID patronId;
        BookPlacedOnHold bookPlacedOnHold;
        Option<MaximumNumberOfHoldsReached> maximumNumberOfHoldsReached;

        @Override
        public Instant getWhen() {
            return bookPlacedOnHold.getWhen();
        }

        public static BookPlacedOnHoldEvents events(BookPlacedOnHold bookPlacedOnHold){
            return new BookPlacedOnHoldEvents(bookPlacedOnHold.getPatronId(),bookPlacedOnHold,Option.none());
        }

        public static BookPlacedOnHoldEvents events(BookPlacedOnHold bookPlaceOnHold, MaximumNumberOfHoldsReached maximumNumberOfHoldsReached){
            return new BookPlacedOnHoldEvents(bookPlaceOnHold.getPatronId(),bookPlaceOnHold,Option.of(maximumNumberOfHoldsReached));
        }

        public List<DomainEvent> normalize(){
            return List.<DomainEvent>of(bookPlacedOnHold).appendAll(maximumNumberOfHoldsReached.toList());
        }
    }

    @Value
    class MaximumNumberOfHoldsReached implements PatronEvent{
        UUID eventId=UUID.randomUUID();
        Instant when;
        UUID patronId;
        int numberOfHolds;

        public static MaximumNumberOfHoldsReached now(PatronInformation patronInformation, int numberOfHolds){
            return new MaximumNumberOfHoldsReached(Instant.now(),
                    patronInformation.getPatronId().getPatronId(),
                    numberOfHolds);
        }
    }

    @Value
    class BookHoldFailed implements PatronEvent{
        UUID eventId=UUID.randomUUID();
        String reason;
        Instant when;
        UUID patronId;
        UUID bookId;
        UUID libraryBranchId;

        static BookHoldFailed now(Rejection rejection, BookId bookId, LibraryBranchId libraryBranchId,PatronInformation patronInformation){
            return null;
        }
    }
}
