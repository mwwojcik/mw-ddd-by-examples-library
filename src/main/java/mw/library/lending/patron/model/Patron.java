package mw.library.lending.patron.model;

import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(of = "patron")
public class Patron {
    private PatronInformation patron;

    private List<PlacingOnHoldPolicy> placingOnHoldPolicies;

    private OverdueCheckouts overdueCheckouts;

    private PatronHolds patronHolds;

//TODO
}
