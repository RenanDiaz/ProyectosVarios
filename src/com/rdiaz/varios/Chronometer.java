package com.rdiaz.varios;

final class Chronometer{
    private long begin, end;
 
    void start(){
        begin = System.currentTimeMillis();
    }
 
    void stop(){
        end = System.currentTimeMillis();
    }
 
    long getTime() {
        return end - begin;
    }
 
    public long getMilliseconds() {
        return end - begin;
    }
 
    public double getSeconds() {
        return (end - begin) / 1000.0;
    }
 
    public double getMinutes() {
        return (end - begin) / 60000.0;
    }
 
    public double getHours() {
        return (end - begin) / 3600000.0;
    }
}