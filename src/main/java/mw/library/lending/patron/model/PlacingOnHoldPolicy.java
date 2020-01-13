package mw.library.lending.patron.model;

import lombok.Value;

public class PlacingOnHoldPolicy {


}

@Value
class Rejection{

    @Value
   static class Reason{
        String reason;
    }


    Reason reason;

    static Rejection withReason(String reason){
        return new Rejection(new Reason(reason));
    }

}
