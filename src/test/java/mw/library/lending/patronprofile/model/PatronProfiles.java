package mw.library.lending.patronprofile.model;

import mw.library.lending.patron.model.PatronId;
import org.springframework.web.bind.annotation.PatchMapping;

interface PatronProfiles {
    PatronProfile fetchFor(PatronId patron);
}
