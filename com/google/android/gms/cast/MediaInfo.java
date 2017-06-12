package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.util.zzp;
import com.google.android.gms.internal.zzym;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaInfo extends zza implements ReflectedParcelable {
    public static final Creator<MediaInfo> CREATOR;
    public static final int STREAM_TYPE_BUFFERED = 1;
    public static final int STREAM_TYPE_INVALID = -1;
    public static final int STREAM_TYPE_LIVE = 2;
    public static final int STREAM_TYPE_NONE = 0;
    public static final long UNKNOWN_DURATION = -1;
    private final int mVersionCode;
    String zzalH;
    private JSONObject zzalI;
    private final String zzanb;
    private int zzanc;
    private String zzand;
    private MediaMetadata zzane;
    private long zzanf;
    private List<MediaTrack> zzang;
    private TextTrackStyle zzanh;
    private List<AdBreakInfo> zzani;
    private List<AdBreakClipInfo> zzanj;

    public static class Builder {
        private final MediaInfo zzank;

        public Builder(String str) throws IllegalArgumentException {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Content ID cannot be empty");
            }
            this.zzank = new MediaInfo(str);
        }

        public MediaInfo build() throws IllegalArgumentException {
            this.zzank.zzrZ();
            return this.zzank;
        }

        public Builder setContentType(String str) throws IllegalArgumentException {
            this.zzank.setContentType(str);
            return this;
        }

        public Builder setCustomData(JSONObject jSONObject) {
            this.zzank.setCustomData(jSONObject);
            return this;
        }

        public Builder setMediaTracks(List<MediaTrack> list) {
            this.zzank.zzx(list);
            return this;
        }

        public Builder setMetadata(MediaMetadata mediaMetadata) {
            this.zzank.zza(mediaMetadata);
            return this;
        }

        public Builder setStreamDuration(long j) throws IllegalArgumentException {
            this.zzank.zzB(j);
            return this;
        }

        public Builder setStreamType(int i) throws IllegalArgumentException {
            this.zzank.setStreamType(i);
            return this;
        }

        public Builder setTextTrackStyle(TextTrackStyle textTrackStyle) {
            this.zzank.setTextTrackStyle(textTrackStyle);
            return this;
        }
    }

    static {
        CREATOR = new zzi();
    }

    MediaInfo(int i, String str, int i2, String str2, MediaMetadata mediaMetadata, long j, List<MediaTrack> list, TextTrackStyle textTrackStyle, String str3, List<AdBreakInfo> list2, List<AdBreakClipInfo> list3) {
        this.mVersionCode = i;
        this.zzanb = str;
        this.zzanc = i2;
        this.zzand = str2;
        this.zzane = mediaMetadata;
        this.zzanf = j;
        this.zzang = list;
        this.zzanh = textTrackStyle;
        this.zzalH = str3;
        if (this.zzalH != null) {
            try {
                this.zzalI = new JSONObject(this.zzalH);
            } catch (JSONException e) {
                this.zzalI = null;
                this.zzalH = null;
            }
        } else {
            this.zzalI = null;
        }
        this.zzani = list2;
        this.zzanj = list3;
    }

    MediaInfo(String str) throws IllegalArgumentException {
        this(STREAM_TYPE_LIVE, str, STREAM_TYPE_INVALID, null, null, UNKNOWN_DURATION, null, null, null, null, null);
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("content ID cannot be null or empty");
        }
    }

    MediaInfo(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray;
        int i;
        int i2 = STREAM_TYPE_NONE;
        this(STREAM_TYPE_LIVE, jSONObject.getString("contentId"), STREAM_TYPE_INVALID, null, null, UNKNOWN_DURATION, null, null, null, null, null);
        String string = jSONObject.getString("streamType");
        if ("NONE".equals(string)) {
            this.zzanc = STREAM_TYPE_NONE;
        } else if ("BUFFERED".equals(string)) {
            this.zzanc = STREAM_TYPE_BUFFERED;
        } else if ("LIVE".equals(string)) {
            this.zzanc = STREAM_TYPE_LIVE;
        } else {
            this.zzanc = STREAM_TYPE_INVALID;
        }
        this.zzand = jSONObject.getString("contentType");
        if (jSONObject.has("metadata")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("metadata");
            this.zzane = new MediaMetadata(jSONObject2.getInt("metadataType"));
            this.zzane.zzn(jSONObject2);
        }
        this.zzanf = UNKNOWN_DURATION;
        if (jSONObject.has("duration") && !jSONObject.isNull("duration")) {
            double optDouble = jSONObject.optDouble("duration", 0.0d);
            if (!(Double.isNaN(optDouble) || Double.isInfinite(optDouble))) {
                this.zzanf = zzym.zzf(optDouble);
            }
        }
        if (jSONObject.has("tracks")) {
            this.zzang = new ArrayList();
            jSONArray = jSONObject.getJSONArray("tracks");
            for (i = STREAM_TYPE_NONE; i < jSONArray.length(); i += STREAM_TYPE_BUFFERED) {
                this.zzang.add(new MediaTrack(jSONArray.getJSONObject(i)));
            }
        } else {
            this.zzang = null;
        }
        if (jSONObject.has("textTrackStyle")) {
            jSONObject2 = jSONObject.getJSONObject("textTrackStyle");
            TextTrackStyle textTrackStyle = new TextTrackStyle();
            textTrackStyle.zzn(jSONObject2);
            this.zzanh = textTrackStyle;
        } else {
            this.zzanh = null;
        }
        if (jSONObject.has("breaks")) {
            jSONArray = jSONObject.getJSONArray("breaks");
            this.zzani = new ArrayList(jSONArray.length());
            i = STREAM_TYPE_NONE;
            while (i < jSONArray.length()) {
                AdBreakInfo zzl = AdBreakInfo.zzl(jSONArray.getJSONObject(i));
                if (zzl == null) {
                    this.zzani.clear();
                    break;
                } else {
                    this.zzani.add(zzl);
                    i += STREAM_TYPE_BUFFERED;
                }
            }
        }
        if (jSONObject.has("breakClips")) {
            JSONArray jSONArray2 = jSONObject.getJSONArray("breakClips");
            this.zzanj = new ArrayList(jSONArray2.length());
            while (i2 < jSONArray2.length()) {
                AdBreakClipInfo zzk = AdBreakClipInfo.zzk(jSONArray2.getJSONObject(i2));
                if (zzk == null) {
                    this.zzanj.clear();
                    break;
                } else {
                    this.zzanj.add(zzk);
                    i2 += STREAM_TYPE_BUFFERED;
                }
            }
        }
        this.zzalI = jSONObject.optJSONObject("customData");
    }

    private void zzrZ() throws IllegalArgumentException {
        if (TextUtils.isEmpty(this.zzanb)) {
            throw new IllegalArgumentException("content ID cannot be null or empty");
        } else if (TextUtils.isEmpty(this.zzand)) {
            throw new IllegalArgumentException("content type cannot be null or empty");
        } else if (this.zzanc == STREAM_TYPE_INVALID) {
            throw new IllegalArgumentException("a valid stream type must be specified");
        }
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaInfo)) {
            return false;
        }
        MediaInfo mediaInfo = (MediaInfo) obj;
        if ((this.zzalI == null ? STREAM_TYPE_BUFFERED : false) != (mediaInfo.zzalI == null ? STREAM_TYPE_BUFFERED : false)) {
            return false;
        }
        if (this.zzalI != null && mediaInfo.zzalI != null && !zzp.zzf(this.zzalI, mediaInfo.zzalI)) {
            return false;
        }
        if (!(zzym.zza(this.zzanb, mediaInfo.zzanb) && this.zzanc == mediaInfo.zzanc && zzym.zza(this.zzand, mediaInfo.zzand) && zzym.zza(this.zzane, mediaInfo.zzane) && this.zzanf == mediaInfo.zzanf && zzym.zza(this.zzang, mediaInfo.zzang) && zzym.zza(this.zzanh, mediaInfo.zzanh) && zzym.zza(this.zzani, mediaInfo.zzani) && zzym.zza(this.zzanj, mediaInfo.zzanj))) {
            z = false;
        }
        return z;
    }

    public List<AdBreakClipInfo> getAdBreakClips() {
        return this.zzanj == null ? null : Collections.unmodifiableList(this.zzanj);
    }

    public List<AdBreakInfo> getAdBreaks() {
        return this.zzani == null ? null : Collections.unmodifiableList(this.zzani);
    }

    public String getContentId() {
        return this.zzanb;
    }

    public String getContentType() {
        return this.zzand;
    }

    public JSONObject getCustomData() {
        return this.zzalI;
    }

    public List<MediaTrack> getMediaTracks() {
        return this.zzang;
    }

    public MediaMetadata getMetadata() {
        return this.zzane;
    }

    public long getStreamDuration() {
        return this.zzanf;
    }

    public int getStreamType() {
        return this.zzanc;
    }

    public TextTrackStyle getTextTrackStyle() {
        return this.zzanh;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzanb, Integer.valueOf(this.zzanc), this.zzand, this.zzane, Long.valueOf(this.zzanf), String.valueOf(this.zzalI), this.zzang, this.zzanh, this.zzani, this.zzanj);
    }

    void setContentType(String str) throws IllegalArgumentException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("content type cannot be null or empty");
        }
        this.zzand = str;
    }

    void setCustomData(JSONObject jSONObject) {
        this.zzalI = jSONObject;
    }

    void setStreamType(int i) throws IllegalArgumentException {
        if (i < STREAM_TYPE_INVALID || i > STREAM_TYPE_LIVE) {
            throw new IllegalArgumentException("invalid stream type");
        }
        this.zzanc = i;
    }

    public void setTextTrackStyle(TextTrackStyle textTrackStyle) {
        this.zzanh = textTrackStyle;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            Object obj;
            jSONObject.put("contentId", this.zzanb);
            switch (this.zzanc) {
                case STREAM_TYPE_BUFFERED /*1*/:
                    obj = "BUFFERED";
                    break;
                case STREAM_TYPE_LIVE /*2*/:
                    obj = "LIVE";
                    break;
                default:
                    obj = "NONE";
                    break;
            }
            jSONObject.put("streamType", obj);
            if (this.zzand != null) {
                jSONObject.put("contentType", this.zzand);
            }
            if (this.zzane != null) {
                jSONObject.put("metadata", this.zzane.toJson());
            }
            if (this.zzanf <= UNKNOWN_DURATION) {
                jSONObject.put("duration", JSONObject.NULL);
            } else {
                jSONObject.put("duration", zzym.zzF(this.zzanf));
            }
            if (this.zzang != null) {
                JSONArray jSONArray = new JSONArray();
                for (MediaTrack toJson : this.zzang) {
                    jSONArray.put(toJson.toJson());
                }
                jSONObject.put("tracks", jSONArray);
            }
            if (this.zzanh != null) {
                jSONObject.put("textTrackStyle", this.zzanh.toJson());
            }
            if (this.zzalI != null) {
                jSONObject.put("customData", this.zzalI);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public void writeToParcel(Parcel parcel, int i) {
        this.zzalH = this.zzalI == null ? null : this.zzalI.toString();
        zzi.zza(this, parcel, i);
    }

    void zzB(long j) throws IllegalArgumentException {
        if (j >= 0 || j == UNKNOWN_DURATION) {
            this.zzanf = j;
            return;
        }
        throw new IllegalArgumentException("Invalid stream duration");
    }

    void zza(MediaMetadata mediaMetadata) {
        this.zzane = mediaMetadata;
    }

    void zzx(List<MediaTrack> list) {
        this.zzang = list;
    }

    public void zzy(List<AdBreakInfo> list) {
        this.zzani = list;
    }
}
