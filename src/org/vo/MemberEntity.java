package org.vo;

import java.sql.Timestamp;

/**
 * Created by wz on 2016/6/14.
 */
public class MemberEntity {
    private int id;
    private Timestamp memTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getMemTime() {
        return memTime;
    }

    public void setMemTime(Timestamp memTime) {
        this.memTime = memTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MemberEntity that = (MemberEntity) o;

        if (id != that.id) return false;
        if (memTime != null ? !memTime.equals(that.memTime) : that.memTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (memTime != null ? memTime.hashCode() : 0);
        return result;
    }
}
