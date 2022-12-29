package com.rfindustries.core.beans.cache;

import lombok.Data;

@Data
public class CacheValue<DATA> {
    private DATA data;
    private long lastAccessTime;

    public CacheValue(DATA data) {
        this.data = data;
        this.lastAccessTime = System.currentTimeMillis();
    }

    public DATA getAndAudit(){
        this.lastAccessTime = System.currentTimeMillis();
        return data;
    }
}
