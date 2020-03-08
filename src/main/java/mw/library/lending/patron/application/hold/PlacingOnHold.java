package mw.library.lending.patron.application.hold;

import io.vavr.control.Try;
import mw.library.commons.commands.Result;

public class PlacingOnHold {
    public Try<Result> placeOnHold(PlaceOnHoldCommand command) {
        return Try.success(Result.Success);
    }
}
