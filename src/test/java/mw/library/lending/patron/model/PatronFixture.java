package mw.library.lending.patron.model;

import io.vavr.collection.List;

import java.util.HashSet;
import java.util.UUID;

import static mw.library.lending.patron.model.PatronType.Researcher;

class PatronFixture {
    public static PatronId anyPatronId() {
        return new PatronId(UUID.randomUUID());
    }

    public static Patron researcherPatronWithPolicy(PatronId patronId, PlacingOnHoldPolicy onlyResearcherPatronsCanPlaceOpenEndedHolds) {
        return patronWithPolicy(patronId,Researcher,onlyResearcherPatronsCanPlaceOpenEndedHolds);
    }

    private static Patron patronWithPolicy(PatronId patronId, PatronType type, PlacingOnHoldPolicy policy) {
        return new Patron(patronInformation(patronId,type), List.of(policy),new OverdueCheckouts(),noHolds());
    }

    private static PatronHolds noHolds() {
        return new PatronHolds(new HashSet<>());
    }

    private static PatronInformation patronInformation(PatronId patronId, PatronType type) {
        return new PatronInformation(patronId,type);
    }
}
