package by.home.dartlen.dindindon.pendingalarms.util;

import androidx.room.Entity;

@Entity
public class Alarm {

    public Alarm(long time) {
        this.time = time;
    }

    private long time;


    public Alarm() {
    }


    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }


}
