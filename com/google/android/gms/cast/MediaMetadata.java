package com.google.android.gms.cast;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.internal.zzyz;
import com.google.android.gms.plus.PlusShare;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class MediaMetadata extends com.google.android.gms.common.internal.safeparcel.zza {
    public static final Creator<MediaMetadata> CREATOR;
    public static final String KEY_ALBUM_ARTIST = "com.google.android.gms.cast.metadata.ALBUM_ARTIST";
    public static final String KEY_ALBUM_TITLE = "com.google.android.gms.cast.metadata.ALBUM_TITLE";
    public static final String KEY_ARTIST = "com.google.android.gms.cast.metadata.ARTIST";
    public static final String KEY_BROADCAST_DATE = "com.google.android.gms.cast.metadata.BROADCAST_DATE";
    public static final String KEY_COMPOSER = "com.google.android.gms.cast.metadata.COMPOSER";
    public static final String KEY_CREATION_DATE = "com.google.android.gms.cast.metadata.CREATION_DATE";
    public static final String KEY_DISC_NUMBER = "com.google.android.gms.cast.metadata.DISC_NUMBER";
    public static final String KEY_EPISODE_NUMBER = "com.google.android.gms.cast.metadata.EPISODE_NUMBER";
    public static final String KEY_HEIGHT = "com.google.android.gms.cast.metadata.HEIGHT";
    public static final String KEY_LOCATION_LATITUDE = "com.google.android.gms.cast.metadata.LOCATION_LATITUDE";
    public static final String KEY_LOCATION_LONGITUDE = "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE";
    public static final String KEY_LOCATION_NAME = "com.google.android.gms.cast.metadata.LOCATION_NAME";
    public static final String KEY_RELEASE_DATE = "com.google.android.gms.cast.metadata.RELEASE_DATE";
    public static final String KEY_SEASON_NUMBER = "com.google.android.gms.cast.metadata.SEASON_NUMBER";
    public static final String KEY_SERIES_TITLE = "com.google.android.gms.cast.metadata.SERIES_TITLE";
    public static final String KEY_STUDIO = "com.google.android.gms.cast.metadata.STUDIO";
    public static final String KEY_SUBTITLE = "com.google.android.gms.cast.metadata.SUBTITLE";
    public static final String KEY_TITLE = "com.google.android.gms.cast.metadata.TITLE";
    public static final String KEY_TRACK_NUMBER = "com.google.android.gms.cast.metadata.TRACK_NUMBER";
    public static final String KEY_WIDTH = "com.google.android.gms.cast.metadata.WIDTH";
    public static final int MEDIA_TYPE_GENERIC = 0;
    public static final int MEDIA_TYPE_MOVIE = 1;
    public static final int MEDIA_TYPE_MUSIC_TRACK = 3;
    public static final int MEDIA_TYPE_PHOTO = 4;
    public static final int MEDIA_TYPE_TV_SHOW = 2;
    public static final int MEDIA_TYPE_USER = 100;
    private static final String[] zzanl;
    private static final zza zzanm;
    private final int mVersionCode;
    private final List<WebImage> zzFT;
    final Bundle zzann;
    private int zzano;

    private static class zza {
        private final Map<String, String> zzanp;
        private final Map<String, String> zzanq;
        private final Map<String, Integer> zzanr;

        public zza() {
            this.zzanp = new HashMap();
            this.zzanq = new HashMap();
            this.zzanr = new HashMap();
        }

        public zza zzc(String str, String str2, int i) {
            this.zzanp.put(str, str2);
            this.zzanq.put(str2, str);
            this.zzanr.put(str, Integer.valueOf(i));
            return this;
        }

        public String zzcF(String str) {
            return (String) this.zzanp.get(str);
        }

        public String zzcG(String str) {
            return (String) this.zzanq.get(str);
        }

        public int zzcH(String str) {
            Integer num = (Integer) this.zzanr.get(str);
            return num != null ? num.intValue() : MediaMetadata.MEDIA_TYPE_GENERIC;
        }
    }

    static {
        zzanl = new String[]{null, "String", "int", "double", "ISO-8601 date String"};
        CREATOR = new zzj();
        zzanm = new zza().zzc(KEY_CREATION_DATE, "creationDateTime", MEDIA_TYPE_PHOTO).zzc(KEY_RELEASE_DATE, "releaseDate", MEDIA_TYPE_PHOTO).zzc(KEY_BROADCAST_DATE, "originalAirdate", MEDIA_TYPE_PHOTO).zzc(KEY_TITLE, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, MEDIA_TYPE_MOVIE).zzc(KEY_SUBTITLE, "subtitle", MEDIA_TYPE_MOVIE).zzc(KEY_ARTIST, "artist", MEDIA_TYPE_MOVIE).zzc(KEY_ALBUM_ARTIST, "albumArtist", MEDIA_TYPE_MOVIE).zzc(KEY_ALBUM_TITLE, "albumName", MEDIA_TYPE_MOVIE).zzc(KEY_COMPOSER, "composer", MEDIA_TYPE_MOVIE).zzc(KEY_DISC_NUMBER, "discNumber", MEDIA_TYPE_TV_SHOW).zzc(KEY_TRACK_NUMBER, "trackNumber", MEDIA_TYPE_TV_SHOW).zzc(KEY_SEASON_NUMBER, "season", MEDIA_TYPE_TV_SHOW).zzc(KEY_EPISODE_NUMBER, "episode", MEDIA_TYPE_TV_SHOW).zzc(KEY_SERIES_TITLE, "seriesTitle", MEDIA_TYPE_MOVIE).zzc(KEY_STUDIO, "studio", MEDIA_TYPE_MOVIE).zzc(KEY_WIDTH, "width", MEDIA_TYPE_TV_SHOW).zzc(KEY_HEIGHT, "height", MEDIA_TYPE_TV_SHOW).zzc(KEY_LOCATION_NAME, "location", MEDIA_TYPE_MOVIE).zzc(KEY_LOCATION_LATITUDE, "latitude", MEDIA_TYPE_MUSIC_TRACK).zzc(KEY_LOCATION_LONGITUDE, "longitude", MEDIA_TYPE_MUSIC_TRACK);
    }

    public MediaMetadata() {
        this(MEDIA_TYPE_GENERIC);
    }

    public MediaMetadata(int i) {
        this(MEDIA_TYPE_MOVIE, new ArrayList(), new Bundle(), i);
    }

    MediaMetadata(int i, List<WebImage> list, Bundle bundle, int i2) {
        this.mVersionCode = i;
        this.zzFT = list;
        this.zzann = bundle;
        this.zzano = i2;
    }

    private void zza(JSONObject jSONObject, String... strArr) {
        try {
            int length = strArr.length;
            for (int i = MEDIA_TYPE_GENERIC; i < length; i += MEDIA_TYPE_MOVIE) {
                String str = strArr[i];
                if (this.zzann.containsKey(str)) {
                    switch (zzanm.zzcH(str)) {
                        case MEDIA_TYPE_MOVIE /*1*/:
                        case MEDIA_TYPE_PHOTO /*4*/:
                            jSONObject.put(zzanm.zzcF(str), this.zzann.getString(str));
                            break;
                        case MEDIA_TYPE_TV_SHOW /*2*/:
                            jSONObject.put(zzanm.zzcF(str), this.zzann.getInt(str));
                            break;
                        case MEDIA_TYPE_MUSIC_TRACK /*3*/:
                            jSONObject.put(zzanm.zzcF(str), this.zzann.getDouble(str));
                            break;
                        default:
                            break;
                    }
                }
            }
            for (String str2 : this.zzann.keySet()) {
                if (!str2.startsWith("com.google.")) {
                    Object obj = this.zzann.get(str2);
                    if (obj instanceof String) {
                        jSONObject.put(str2, obj);
                    } else if (obj instanceof Integer) {
                        jSONObject.put(str2, obj);
                    } else if (obj instanceof Double) {
                        jSONObject.put(str2, obj);
                    }
                }
            }
        } catch (JSONException e) {
        }
    }

    private void zzb(JSONObject jSONObject, String... strArr) {
        Set hashSet = new HashSet(Arrays.asList(strArr));
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                if (!"metadataType".equals(str)) {
                    String zzcG = zzanm.zzcG(str);
                    if (zzcG == null) {
                        Object obj = jSONObject.get(str);
                        if (obj instanceof String) {
                            this.zzann.putString(str, (String) obj);
                        } else if (obj instanceof Integer) {
                            this.zzann.putInt(str, ((Integer) obj).intValue());
                        } else if (obj instanceof Double) {
                            this.zzann.putDouble(str, ((Double) obj).doubleValue());
                        }
                    } else if (hashSet.contains(zzcG)) {
                        try {
                            Object obj2 = jSONObject.get(str);
                            if (obj2 != null) {
                                switch (zzanm.zzcH(zzcG)) {
                                    case MEDIA_TYPE_MOVIE /*1*/:
                                        if (!(obj2 instanceof String)) {
                                            break;
                                        }
                                        this.zzann.putString(zzcG, (String) obj2);
                                        break;
                                    case MEDIA_TYPE_TV_SHOW /*2*/:
                                        if (!(obj2 instanceof Integer)) {
                                            break;
                                        }
                                        this.zzann.putInt(zzcG, ((Integer) obj2).intValue());
                                        break;
                                    case MEDIA_TYPE_MUSIC_TRACK /*3*/:
                                        if (!(obj2 instanceof Double)) {
                                            break;
                                        }
                                        this.zzann.putDouble(zzcG, ((Double) obj2).doubleValue());
                                        break;
                                    case MEDIA_TYPE_PHOTO /*4*/:
                                        if (!(obj2 instanceof String)) {
                                            break;
                                        }
                                        if (zzyz.zzcV((String) obj2) == null) {
                                            break;
                                        }
                                        this.zzann.putString(zzcG, (String) obj2);
                                        break;
                                    default:
                                        break;
                                }
                            }
                        } catch (JSONException e) {
                        }
                    }
                }
            }
        } catch (JSONException e2) {
        }
    }

    private boolean zzb(Bundle bundle, Bundle bundle2) {
        if (bundle.size() != bundle2.size()) {
            return false;
        }
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            Object obj2 = bundle2.get(str);
            if ((obj instanceof Bundle) && (obj2 instanceof Bundle) && !zzb((Bundle) obj, (Bundle) obj2)) {
                return false;
            }
            if (obj == null) {
                if (obj2 != null || !bundle2.containsKey(str)) {
                    return false;
                }
            } else if (!obj.equals(obj2)) {
                return false;
            }
        }
        return true;
    }

    private void zzg(String str, int i) throws IllegalArgumentException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("null and empty keys are not allowed");
        }
        int zzcH = zzanm.zzcH(str);
        if (zzcH != i && zzcH != 0) {
            String valueOf = String.valueOf(zzanl[i]);
            throw new IllegalArgumentException(new StringBuilder((String.valueOf(str).length() + 21) + String.valueOf(valueOf).length()).append("Value for ").append(str).append(" must be a ").append(valueOf).toString());
        }
    }

    public void addImage(WebImage webImage) {
        this.zzFT.add(webImage);
    }

    public void clear() {
        this.zzann.clear();
        this.zzFT.clear();
    }

    public void clearImages() {
        this.zzFT.clear();
    }

    public boolean containsKey(String str) {
        return this.zzann.containsKey(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaMetadata)) {
            return false;
        }
        MediaMetadata mediaMetadata = (MediaMetadata) obj;
        return zzb(this.zzann, mediaMetadata.zzann) && this.zzFT.equals(mediaMetadata.zzFT);
    }

    public Calendar getDate(String str) {
        zzg(str, MEDIA_TYPE_PHOTO);
        String string = this.zzann.getString(str);
        return string != null ? zzyz.zzcV(string) : null;
    }

    public String getDateAsString(String str) {
        zzg(str, MEDIA_TYPE_PHOTO);
        return this.zzann.getString(str);
    }

    public double getDouble(String str) {
        zzg(str, MEDIA_TYPE_MUSIC_TRACK);
        return this.zzann.getDouble(str);
    }

    public List<WebImage> getImages() {
        return this.zzFT;
    }

    public int getInt(String str) {
        zzg(str, MEDIA_TYPE_TV_SHOW);
        return this.zzann.getInt(str);
    }

    public int getMediaType() {
        return this.zzano;
    }

    public String getString(String str) {
        zzg(str, MEDIA_TYPE_MOVIE);
        return this.zzann.getString(str);
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean hasImages() {
        return (this.zzFT == null || this.zzFT.isEmpty()) ? false : true;
    }

    public int hashCode() {
        int i = 17;
        for (String str : this.zzann.keySet()) {
            i *= 31;
            i = this.zzann.get(str).hashCode() + i;
        }
        return (i * 31) + this.zzFT.hashCode();
    }

    public Set<String> keySet() {
        return this.zzann.keySet();
    }

    public void putDate(String str, Calendar calendar) {
        zzg(str, MEDIA_TYPE_PHOTO);
        this.zzann.putString(str, zzyz.zza(calendar));
    }

    public void putDouble(String str, double d) {
        zzg(str, MEDIA_TYPE_MUSIC_TRACK);
        this.zzann.putDouble(str, d);
    }

    public void putInt(String str, int i) {
        zzg(str, MEDIA_TYPE_TV_SHOW);
        this.zzann.putInt(str, i);
    }

    public void putString(String str, String str2) {
        zzg(str, MEDIA_TYPE_MOVIE);
        this.zzann.putString(str, str2);
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("metadataType", this.zzano);
        } catch (JSONException e) {
        }
        zzyz.zza(jSONObject, this.zzFT);
        String[] strArr;
        switch (this.zzano) {
            case MEDIA_TYPE_GENERIC /*0*/:
                strArr = new String[MEDIA_TYPE_PHOTO];
                strArr[MEDIA_TYPE_GENERIC] = KEY_TITLE;
                strArr[MEDIA_TYPE_MOVIE] = KEY_ARTIST;
                strArr[MEDIA_TYPE_TV_SHOW] = KEY_SUBTITLE;
                strArr[MEDIA_TYPE_MUSIC_TRACK] = KEY_RELEASE_DATE;
                zza(jSONObject, strArr);
                break;
            case MEDIA_TYPE_MOVIE /*1*/:
                strArr = new String[MEDIA_TYPE_PHOTO];
                strArr[MEDIA_TYPE_GENERIC] = KEY_TITLE;
                strArr[MEDIA_TYPE_MOVIE] = KEY_STUDIO;
                strArr[MEDIA_TYPE_TV_SHOW] = KEY_SUBTITLE;
                strArr[MEDIA_TYPE_MUSIC_TRACK] = KEY_RELEASE_DATE;
                zza(jSONObject, strArr);
                break;
            case MEDIA_TYPE_TV_SHOW /*2*/:
                zza(jSONObject, KEY_TITLE, KEY_SERIES_TITLE, KEY_SEASON_NUMBER, KEY_EPISODE_NUMBER, KEY_BROADCAST_DATE);
                break;
            case MEDIA_TYPE_MUSIC_TRACK /*3*/:
                zza(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_ALBUM_TITLE, KEY_ALBUM_ARTIST, KEY_COMPOSER, KEY_TRACK_NUMBER, KEY_DISC_NUMBER, KEY_RELEASE_DATE);
                break;
            case MEDIA_TYPE_PHOTO /*4*/:
                zza(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_LOCATION_NAME, KEY_LOCATION_LATITUDE, KEY_LOCATION_LONGITUDE, KEY_WIDTH, KEY_HEIGHT, KEY_CREATION_DATE);
                break;
            default:
                zza(jSONObject, new String[MEDIA_TYPE_GENERIC]);
                break;
        }
        return jSONObject;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzj.zza(this, parcel, i);
    }

    public void zzn(JSONObject jSONObject) {
        clear();
        this.zzano = MEDIA_TYPE_GENERIC;
        try {
            this.zzano = jSONObject.getInt("metadataType");
        } catch (JSONException e) {
        }
        zzyz.zza(this.zzFT, jSONObject);
        String[] strArr;
        switch (this.zzano) {
            case MEDIA_TYPE_GENERIC /*0*/:
                strArr = new String[MEDIA_TYPE_PHOTO];
                strArr[MEDIA_TYPE_GENERIC] = KEY_TITLE;
                strArr[MEDIA_TYPE_MOVIE] = KEY_ARTIST;
                strArr[MEDIA_TYPE_TV_SHOW] = KEY_SUBTITLE;
                strArr[MEDIA_TYPE_MUSIC_TRACK] = KEY_RELEASE_DATE;
                zzb(jSONObject, strArr);
            case MEDIA_TYPE_MOVIE /*1*/:
                strArr = new String[MEDIA_TYPE_PHOTO];
                strArr[MEDIA_TYPE_GENERIC] = KEY_TITLE;
                strArr[MEDIA_TYPE_MOVIE] = KEY_STUDIO;
                strArr[MEDIA_TYPE_TV_SHOW] = KEY_SUBTITLE;
                strArr[MEDIA_TYPE_MUSIC_TRACK] = KEY_RELEASE_DATE;
                zzb(jSONObject, strArr);
            case MEDIA_TYPE_TV_SHOW /*2*/:
                zzb(jSONObject, KEY_TITLE, KEY_SERIES_TITLE, KEY_SEASON_NUMBER, KEY_EPISODE_NUMBER, KEY_BROADCAST_DATE);
            case MEDIA_TYPE_MUSIC_TRACK /*3*/:
                zzb(jSONObject, KEY_TITLE, KEY_ALBUM_TITLE, KEY_ARTIST, KEY_ALBUM_ARTIST, KEY_COMPOSER, KEY_TRACK_NUMBER, KEY_DISC_NUMBER, KEY_RELEASE_DATE);
            case MEDIA_TYPE_PHOTO /*4*/:
                zzb(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_LOCATION_NAME, KEY_LOCATION_LATITUDE, KEY_LOCATION_LONGITUDE, KEY_WIDTH, KEY_HEIGHT, KEY_CREATION_DATE);
            default:
                zzb(jSONObject, new String[MEDIA_TYPE_GENERIC]);
        }
    }
}
