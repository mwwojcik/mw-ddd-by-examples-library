package mw.library.lending.patronprofile.model;

import mw.library.lending.patron.model.PatronId;

interface PatronProfiles {
    PatronProfile fetchFor(PatronId patron);
}
