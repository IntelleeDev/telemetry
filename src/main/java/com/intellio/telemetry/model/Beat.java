package com.intellio.telemetry.model;

public class Beat {

    private String author;

    private long timeFrame;

    public Beat() {
        this(null, System.currentTimeMillis());
    }

    public Beat(String author, long timeFrame) {
        this.author = author;
        this.timeFrame = timeFrame;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getTimeFrame() {
        return timeFrame;
    }

    public void setTimeFrame(long timeFrame) {
        this.timeFrame = timeFrame;
    }
}
