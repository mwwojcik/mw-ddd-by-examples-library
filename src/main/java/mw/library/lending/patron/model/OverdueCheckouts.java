package mw.library.lending.patron.model;

import mw.library.catalogue.BookId;
import mw.library.lending.librarybranch.model.LibraryBranchId;

import java.util.Map;
import java.util.Set;

import static java.util.Collections.emptySet;

public class OverdueCheckouts {
    static int MAX_COUNT_OF_OVERDUE_RESOURCES = 2;

    Map<LibraryBranchId, Set<BookId>> overdueCheckouts;

    int countAt(LibraryBranchId libraryBranchId) {
        return overdueCheckouts.getOrDefault(libraryBranchId, emptySet()).size();
    }
}
