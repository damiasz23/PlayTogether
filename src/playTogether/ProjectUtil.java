package playTogether;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ProjectUtil {
    private final static String zoneId = "Europe/Warsaw";

    public static ZonedDateTime parseDateFromCalendar(String date){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(date, dateTimeFormatter).atStartOfDay(ZoneId.of(zoneId));
    }
}
