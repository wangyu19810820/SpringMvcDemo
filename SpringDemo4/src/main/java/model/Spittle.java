package model;

import java.util.Date;


/**
 * Created by admin on 2017/5/18.
 */
public class Spittle {
    protected Long id;

    protected String message;

    protected Date time;

    public Spittle(Long id) {
        this.id = id;
    }

    public Spittle(Long id, String message, Date time) {
        this.id = id;
        this.message = message;
        this.time = time;
    }

    public Spittle(String message, Date time) {
        this.message = message;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Spittle)) return false;

        Spittle spittle = (Spittle) o;

        if (id != null ? !id.equals(spittle.id) : spittle.id != null) return false;
        if (message != null ? !message.equals(spittle.message) : spittle.message != null) return false;
        return time != null ? time.equals(spittle.time) : spittle.time == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Spittle{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", time=" + time +
                '}';
    }


}
