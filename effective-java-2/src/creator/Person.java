package creator;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author AndrewElvis
 * @date 2021-03-03-14:00
 * @description
 */
public class Person {
    private final Date birthDate;

    private static final Date BOOM_START;
    private static final Date BOOM_END;

    static {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        calendar.set(1946, Calendar.JANUARY, 1, 0, 0);
        BOOM_START = calendar.getTime();
        calendar.set(1964, Calendar.JANUARY, 1, 0, 0);
        BOOM_END = calendar.getTime();
    }

    public Person(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isBabyBoomer() {
        return birthDate.compareTo(BOOM_START) >= 0 &&
                birthDate.compareTo(BOOM_END) < 0;
    }


}
