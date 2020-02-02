package mw.library.lending.patron.model;

import io.vavr.collection.List;
import mw.library.lending.book.model.BookOnHold;
import mw.library.lending.librarybranch.model.LibraryBranchId;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

import static mw.library.lending.patron.model.PatronType.Regular;
import static mw.library.lending.patron.model.PatronType.Researcher;

public class PatronFixture {
    public static PatronId anyPatronId() {
        return new PatronId(UUID.randomUUID());
    }

    public static Patron researcherPatronWithPolicy(PatronId patronId, PlacingOnHoldPolicy policy) {
        return patronWithPolicy(patronId, Researcher, policy);
    }

    private static Patron patronWithPolicy(PatronId patronId, PatronType type, PlacingOnHoldPolicy policy) {
        return new Patron(patronInformation(patronId, type), List.of(policy), new OverdueCheckouts(Collections.emptyMap()), noHolds());
    }

    private static PatronHolds noHolds() {
        return new PatronHolds(new HashSet<>());
    }

    private static PatronInformation patronInformation(PatronId patronId, PatronType type) {
        return new PatronInformation(patronId, type);
    }

    public static Patron regularPatronWithPolicy(PatronId patronId, PlacingOnHoldPolicy policy) {
        return patronWithPolicy(patronId, Regular, policy);
    }

    public static Patron regularPatronWithHolds(int numberOfHolds) {
        return new Patron(
                patronInformation(anyPatronId(), Regular),
                List.of(PlacingOnHoldPolicy.regularPatronMaximumNumberOfHoldsPolicy),
                new OverdueCheckouts(Collections.emptyMap()),
                new PatronHolds(BookFixture.booksOnHold(numberOfHolds))
        );
    }

    public static Patron researcherPatronWithHolds(int numberOfHolds) {
        return new Patron(
                patronInformation(anyPatronId(), Researcher),
                List.of(PlacingOnHoldPolicy.regularPatronMaximumNumberOfHoldsPolicy),
                new OverdueCheckouts(Collections.emptyMap()),
                new PatronHolds(BookFixture.booksOnHold(numberOfHolds))
        );
    }

    public static Patron regularPatronWithCheckoutsAt(int numberOfCheckouts, LibraryBranchId libraryBranchId) {
        return new Patron(
                patronInformation(anyPatronId(), Regular),
                List.of(PlacingOnHoldPolicy.overdueCheckoutsRejectionPolicy),
                new OverdueCheckouts(BookFixture.overdueCheckoutsAtBranch(numberOfCheckouts,libraryBranchId)),
                new PatronHolds(new HashSet<>())
        );
    }



    public static Patron regularPatronWithHold(BookOnHold bookOnHold) {
        var patron = regularPatronWith(new Hold(bookOnHold.getBookInformation().getBookId(), bookOnHold.getLibraryBranchId()));
        return patron;
    }

    private static Patron regularPatronWith(Hold hold) {

        var patron = new Patron(
                new PatronInformation(anyPatronId(), Regular),
                PlacingOnHoldPolicy.allCurrentPolicies(),
                new OverdueCheckouts(new HashMap<>()),
                new PatronHolds(Collections.singleton(hold))
        );
        return patron;
    }

    public static Patron regularPatron() {
        return new Patron(
                patronInformation(anyPatronId(), Regular),
                PlacingOnHoldPolicy.allCurrentPolicies(),
                new OverdueCheckouts(new HashMap<>()),
                new PatronHolds(new HashSet<>())
        );
    }
}
