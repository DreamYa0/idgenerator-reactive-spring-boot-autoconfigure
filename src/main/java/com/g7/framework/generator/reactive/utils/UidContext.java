package com.g7.framework.generator.reactive.utils;

import java.io.Serializable;

/**
 * @author dreamyao
 * @title
 * @date 2020/8/30 12:38 PM
 * @since 1.0.0
 */
public class UidContext implements Serializable {

    private static final long serialVersionUID = 8325955912430775020L;

    private long uid;
    private String timestamp;
    private long workerId;
    private long sequence;

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public long getWorkerId() {
        return workerId;
    }

    public void setWorkerId(long workerId) {
        this.workerId = workerId;
    }

    public long getSequence() {
        return sequence;
    }

    public void setSequence(long sequence) {
        this.sequence = sequence;
    }

    @Override
    public String toString() {
        return "UidContext{" +
                "uid=" + uid +
                ", timestamp='" + timestamp + '\'' +
                ", workerId=" + workerId +
                ", sequence=" + sequence +
                '}';
    }
}
