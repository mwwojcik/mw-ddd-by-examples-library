package mw.library.lending.patron.application.hold;

import mw.library.commons.commands.Result;

public class PlacingOnHold {
  public Result placeOnHold(PlaceOnHoldCommand command) {
    return Result.Success;
  }
}
