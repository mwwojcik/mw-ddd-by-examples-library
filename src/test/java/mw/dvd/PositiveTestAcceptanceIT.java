package mw.dvd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositiveTestAcceptanceIT {

    @DisplayName("Positive test acceptance - rental dvd movie")
    @Test
    void positiveRental()
            throws Exception {
        // given inventory with three films added
        // "Clerks" (type=old), "Frozen" (type="regular"), "Toy Story 4" (type=new)

        // when 'I go /films'
        // then 'I can see all 3 films'

        // when 'I go /points'
        // then 'I can see no points'

        //when 'I post /price with all movies for standard period 2 days'
        //then 'I can see: Clerks (price=10),Frozen(price=20), Toy Story 4 (price=30), Total=60 '

        //when 'I go /reservation'
        //then 'I can see empty list'

        //when 'I post /reservation with all movies for standard period 2 days'
        //then 'I have reserved all movies'

        //when 'I go /reservation'
        //then 'I can see three position list'

        //when 'I go /rental'
        //then 'I can see empty list'

        //when 'I post /rental with three films for standard 2 days'
        //then 'I rent three films'

        //when 'I go /rental'
        //then 'I can see three position list'

        //when 'I go /points'
        //then 'I can see 3 points'

        //when 'I go /review'
        //then 'I can see empty list'

        //when 'I post /review with my comment for Clerks'
        //then 'My review was added'

        //when 'I go /review'
        //then 'I can see list with one position'

        //when 'I go /points'
        //then 'I can see 8 points'
    }
}