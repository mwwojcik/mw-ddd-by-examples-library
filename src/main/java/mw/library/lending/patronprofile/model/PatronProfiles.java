package mw.library.lending.patronprofile.model;

import mw.library.lending.patron.model.PatronId;

public interface PatronProfiles {
    PatronProfile fetchFor(PatronId patron);
}
