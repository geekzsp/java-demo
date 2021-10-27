package xyz.moss.designpatterns.chapter62.demo6;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

/**
 * @author zhangshipeng
 * @date 2021/4/26
 */
public class Java8DateTime {
    public static void main(String[] args) {
        LocalDateTime localDate1 = LocalDate.of(1996, 8, 8).atStartOfDay();
        LocalDateTime localDate2 = LocalDate.now().atStartOfDay();
        System.out.println(ChronoUnit.YEARS.between(localDate1, localDate2));
        System.out.println(ChronoUnit.MONTHS.between(localDate1, localDate2));
        System.out.println(ChronoUnit.DAYS.between(localDate1, localDate2));
        System.out.println(Duration.between(localDate1, localDate2).toDays());
        System.out.println(ChronoUnit.MINUTES.between(localDate1, localDate2));
        System.out.println(Duration.between(localDate1, localDate2).toMinutes());
        System.out.println(ChronoUnit.SECONDS.between(localDate1, localDate2));
        System.out.println(Duration.between(localDate1, localDate2).getSeconds());
        System.out.println(ChronoUnit.MILLIS.between(localDate1, localDate2));
        System.out.println(Duration.between(localDate1, localDate2).toMinutes());

        System.out.println(ChronoUnit.DAYS.getDuration().toDays());
        Duration duration = Duration.between(localDate1, localDate2);
        System.out.println(duration.getSeconds());
        System.out.println(duration.toNanos());
        System.out.println(duration.toDays());
        //
        //Period period=Period.between(localDate1,localDate2);
        //System.out.println(period.getDays());
        //System.out.println(period.getMonths());
        System.out.println(Instant.now().getEpochSecond());
        System.out.println(Instant.now().toEpochMilli());
        System.out.println(System.currentTimeMillis());

        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("M月d日HH点场")));
        System.out.println(LocalDateTime.of(2021,11,21,7,21,32).format(DateTimeFormatter.ofPattern("M月d日H点场")));

    }
}
