package mw.library.lending.patronprofile.model;

import lombok.Value;

import java.util.List;

@Value
public class HoldsView {
    List<Hold> currentHolds;
}
