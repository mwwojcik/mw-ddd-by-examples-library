package mw.library.lending.librarybranch.model;

import lombok.EqualsAndHashCode;
import lombok.Value;

import java.util.UUID;

@Value
@EqualsAndHashCode(of="libraryBranchId")
public class LibraryBranchId {
    private UUID libraryBranchId;
}
