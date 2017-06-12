package com.google.ads.mediation;

import android.location.Location;
import com.google.ads.AdRequest.Gender;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@Deprecated
public class MediationAdRequest {
    private final Date zzcQ;
    private final Gender zzcR;
    private final Set<String> zzcS;
    private final boolean zzcT;
    private final Location zzcU;

    public MediationAdRequest(Date date, Gender gender, Set<String> set, boolean z, Location location) {
        this.zzcQ = date;
        this.zzcR = gender;
        this.zzcS = set;
        this.zzcT = z;
        this.zzcU = location;
    }

    public Integer getAgeInYears() {
        if (this.zzcQ == null) {
            return null;
        }
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance.setTime(this.zzcQ);
        Integer valueOf = Integer.valueOf(instance2.get(1) - instance.get(1));
        return (instance2.get(2) < instance.get(2) || (instance2.get(2) == instance.get(2) && instance2.get(5) < instance.get(5))) ? Integer.valueOf(valueOf.intValue() - 1) : valueOf;
    }

    public Date getBirthday() {
        return this.zzcQ;
    }

    public Gender getGender() {
        return this.zzcR;
    }

    public Set<String> getKeywords() {
        return this.zzcS;
    }

    public Location getLocation() {
        return this.zzcU;
    }

    public boolean isTesting() {
        return this.zzcT;
    }
}
