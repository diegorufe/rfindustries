package com.rfindustries.core.constansts;

public final class SchedulingConstants {

    public  static  final long TIME_CLEAR_CACHE = 3600000;

    public static final String SPRING_CRON_JOB_CLEAR_CACHE = "${scheduling.clearCache}";

    private SchedulingConstants(){
        // NOT implemented
    }

}
