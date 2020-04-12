package com.michaelhefner;

import java.time.*;
import java.util.TimeZone;

public class Main {

    public static void main(String[] args) {

        LocalDate parisDate = LocalDate.now();
        LocalTime parisTime = LocalTime.now();
        ZoneId paris = ZoneId.of("Europe/Paris");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(parisDate,parisTime,paris);
        System.out.println(zonedDateTime);
        ZoneId localZone = ZoneId.of(TimeZone.getDefault().getID());

        Instant parisToGMTInstant = zonedDateTime.toInstant();
        System.out.println(parisToGMTInstant);

        ZonedDateTime parisToLocalZDT = zonedDateTime.withZoneSameInstant(localZone);
        System.out.println(parisToLocalZDT);

        ZonedDateTime gmtToLocalZDT = parisToGMTInstant.atZone(localZone);
        System.out.println(gmtToLocalZDT);

        System.out.println(ZonedDateTime.now());
    }
}
