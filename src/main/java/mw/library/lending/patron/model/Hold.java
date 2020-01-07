package mw.library.lending.patron.model;

import lombok.Value;
import mw.library.catalogue.BookId;
import mw.library.lending.librarybranch.model.LibraryBranchId;

@Value
public class Hold {
    BookId bookId;
    LibraryBranchId libraryBranch;
}
