package mw.library.lending.patronprofile.model;

import lombok.Value;

import java.util.List;

@Value
class CheckoutsView {
    List<Checkout> currentCheckouts;
}
