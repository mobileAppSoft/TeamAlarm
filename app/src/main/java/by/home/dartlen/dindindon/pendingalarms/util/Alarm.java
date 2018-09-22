package by.home.dartlen.dindindon.pendingalarms.util;

import androidx.room.Entity;

@Entity
public class Alarm {


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
