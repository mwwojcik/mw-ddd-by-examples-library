package mw.library.lending.patron.model;

import lombok.Value;

@Value
public class PatronInformation {
    PatronId patronId;
    PatronType patronType;
    boolean isRegular(){return patronType.equals(PatronType.Regular);
    }
}
