package com.google.android.gms.internal;

public class zzbmu {
    private final long zzcec;

    public zzbmu(long j) {
        this.zzcec = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.zzcec == ((zzbmu) obj).zzcec;
    }

    public int hashCode() {
        return (int) (this.zzcec ^ (this.zzcec >>> 32));
    }

    public String toString() {
        return "Tag{tagNumber=" + this.zzcec + "}";
    }

    public long zzXB() {
        return this.zzcec;
    }
}
