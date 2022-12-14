package com.rfindustries.accounting.scheduling;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SyncData {

    @Scheduled(cron = "${scheduling.syncData}")
    public void syncData(){
        // TODO sync taxes
    }

}
