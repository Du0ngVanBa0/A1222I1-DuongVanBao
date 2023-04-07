package ss4_lop_va_doi_tuong_trong_java.bai_tap.stop_watch;

import java.util.Date;

public class StopWatch {
    long startTime, endTime;

    public StopWatch() {
        startTime = (new Date()).getTime();
    }

    public void start(){
        setStartTime((new Date()).getTime());
    }

    public void stop(){
        setEndTime((new Date()).getTime());
    }

    public long getElapsedTime(){
        return (getEndTime() - getStartTime());
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }
}
