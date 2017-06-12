package com.google.android.gms.cast;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.view.accessibility.CaptioningManager;
import android.view.accessibility.CaptioningManager.CaptionStyle;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.util.zzp;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.internal.zzym;
import org.json.JSONException;
import org.json.JSONObject;

public final class TextTrackStyle extends zza {
    public static final int COLOR_UNSPECIFIED = 0;
    public static final Creator<TextTrackStyle> CREATOR;
    public static final float DEFAULT_FONT_SCALE = 1.0f;
    public static final int EDGE_TYPE_DEPRESSED = 4;
    public static final int EDGE_TYPE_DROP_SHADOW = 2;
    public static final int EDGE_TYPE_NONE = 0;
    public static final int EDGE_TYPE_OUTLINE = 1;
    public static final int EDGE_TYPE_RAISED = 3;
    public static final int EDGE_TYPE_UNSPECIFIED = -1;
    public static final int FONT_FAMILY_CASUAL = 4;
    public static final int FONT_FAMILY_CURSIVE = 5;
    public static final int FONT_FAMILY_MONOSPACED_SANS_SERIF = 1;
    public static final int FONT_FAMILY_MONOSPACED_SERIF = 3;
    public static final int FONT_FAMILY_SANS_SERIF = 0;
    public static final int FONT_FAMILY_SERIF = 2;
    public static final int FONT_FAMILY_SMALL_CAPITALS = 6;
    public static final int FONT_FAMILY_UNSPECIFIED = -1;
    public static final int FONT_STYLE_BOLD = 1;
    public static final int FONT_STYLE_BOLD_ITALIC = 3;
    public static final int FONT_STYLE_ITALIC = 2;
    public static final int FONT_STYLE_NORMAL = 0;
    public static final int FONT_STYLE_UNSPECIFIED = -1;
    public static final int WINDOW_TYPE_NONE = 0;
    public static final int WINDOW_TYPE_NORMAL = 1;
    public static final int WINDOW_TYPE_ROUNDED = 2;
    public static final int WINDOW_TYPE_UNSPECIFIED = -1;
    private int mBackgroundColor;
    private final int mVersionCode;
    String zzalH;
    private JSONObject zzalI;
    private float zzaoE;
    private int zzaoF;
    private int zzaoG;
    private int zzaoH;
    private int zzaoI;
    private int zzaoJ;
    private int zzaoK;
    private String zzaoL;
    private int zzaoM;
    private int zzaoN;

    static {
        CREATOR = new zzn();
    }

    public TextTrackStyle() {
        this(WINDOW_TYPE_NORMAL, DEFAULT_FONT_SCALE, WINDOW_TYPE_NONE, WINDOW_TYPE_NONE, WINDOW_TYPE_UNSPECIFIED, WINDOW_TYPE_NONE, WINDOW_TYPE_UNSPECIFIED, WINDOW_TYPE_NONE, WINDOW_TYPE_NONE, null, WINDOW_TYPE_UNSPECIFIED, WINDOW_TYPE_UNSPECIFIED, null);
    }

    TextTrackStyle(int i, float f, int i2, int i3, int i4, int i5, int i6, int i7, int i8, String str, int i9, int i10, String str2) {
        this.mVersionCode = i;
        this.zzaoE = f;
        this.zzaoF = i2;
        this.mBackgroundColor = i3;
        this.zzaoG = i4;
        this.zzaoH = i5;
        this.zzaoI = i6;
        this.zzaoJ = i7;
        this.zzaoK = i8;
        this.zzaoL = str;
        this.zzaoM = i9;
        this.zzaoN = i10;
        this.zzalH = str2;
        if (this.zzalH != null) {
            try {
                this.zzalI = new JSONObject(this.zzalH);
                return;
            } catch (JSONException e) {
                this.zzalI = null;
                this.zzalH = null;
                return;
            }
        }
        this.zzalI = null;
    }

    @TargetApi(19)
    public static TextTrackStyle fromSystemSettings(Context context) {
        TextTrackStyle textTrackStyle = new TextTrackStyle();
        if (!zzs.zzyF()) {
            return textTrackStyle;
        }
        CaptioningManager captioningManager = (CaptioningManager) context.getSystemService("captioning");
        textTrackStyle.setFontScale(captioningManager.getFontScale());
        CaptionStyle userStyle = captioningManager.getUserStyle();
        textTrackStyle.setBackgroundColor(userStyle.backgroundColor);
        textTrackStyle.setForegroundColor(userStyle.foregroundColor);
        switch (userStyle.edgeType) {
            case WINDOW_TYPE_NORMAL /*1*/:
                textTrackStyle.setEdgeType(WINDOW_TYPE_NORMAL);
                break;
            case WINDOW_TYPE_ROUNDED /*2*/:
                textTrackStyle.setEdgeType(WINDOW_TYPE_ROUNDED);
                break;
            default:
                textTrackStyle.setEdgeType(WINDOW_TYPE_NONE);
                break;
        }
        textTrackStyle.setEdgeColor(userStyle.edgeColor);
        Typeface typeface = userStyle.getTypeface();
        if (typeface != null) {
            if (Typeface.MONOSPACE.equals(typeface)) {
                textTrackStyle.setFontGenericFamily(WINDOW_TYPE_NORMAL);
            } else if (Typeface.SANS_SERIF.equals(typeface)) {
                textTrackStyle.setFontGenericFamily(WINDOW_TYPE_NONE);
            } else if (Typeface.SERIF.equals(typeface)) {
                textTrackStyle.setFontGenericFamily(WINDOW_TYPE_ROUNDED);
            } else {
                textTrackStyle.setFontGenericFamily(WINDOW_TYPE_NONE);
            }
            boolean isBold = typeface.isBold();
            boolean isItalic = typeface.isItalic();
            if (isBold && isItalic) {
                textTrackStyle.setFontStyle(FONT_STYLE_BOLD_ITALIC);
            } else if (isBold) {
                textTrackStyle.setFontStyle(WINDOW_TYPE_NORMAL);
            } else if (isItalic) {
                textTrackStyle.setFontStyle(WINDOW_TYPE_ROUNDED);
            } else {
                textTrackStyle.setFontStyle(WINDOW_TYPE_NONE);
            }
        }
        return textTrackStyle;
    }

    private String zzZ(int i) {
        Object[] objArr = new Object[FONT_FAMILY_CASUAL];
        objArr[WINDOW_TYPE_NONE] = Integer.valueOf(Color.red(i));
        objArr[WINDOW_TYPE_NORMAL] = Integer.valueOf(Color.green(i));
        objArr[WINDOW_TYPE_ROUNDED] = Integer.valueOf(Color.blue(i));
        objArr[FONT_STYLE_BOLD_ITALIC] = Integer.valueOf(Color.alpha(i));
        return String.format("#%02X%02X%02X%02X", objArr);
    }

    private int zzcI(String str) {
        int i = WINDOW_TYPE_NONE;
        if (str != null && str.length() == 9 && str.charAt(i) == '#') {
            try {
                i = Color.argb(Integer.parseInt(str.substring(7, 9), 16), Integer.parseInt(str.substring(WINDOW_TYPE_NORMAL, FONT_STYLE_BOLD_ITALIC), 16), Integer.parseInt(str.substring(FONT_STYLE_BOLD_ITALIC, FONT_FAMILY_CURSIVE), 16), Integer.parseInt(str.substring(FONT_FAMILY_CURSIVE, 7), 16));
            } catch (NumberFormatException e) {
            }
        }
        return i;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextTrackStyle)) {
            return false;
        }
        TextTrackStyle textTrackStyle = (TextTrackStyle) obj;
        if ((this.zzalI == null ? WINDOW_TYPE_NORMAL : false) != (textTrackStyle.zzalI == null ? WINDOW_TYPE_NORMAL : false)) {
            return false;
        }
        if (this.zzalI != null && textTrackStyle.zzalI != null && !zzp.zzf(this.zzalI, textTrackStyle.zzalI)) {
            return false;
        }
        if (!(this.zzaoE == textTrackStyle.zzaoE && this.zzaoF == textTrackStyle.zzaoF && this.mBackgroundColor == textTrackStyle.mBackgroundColor && this.zzaoG == textTrackStyle.zzaoG && this.zzaoH == textTrackStyle.zzaoH && this.zzaoI == textTrackStyle.zzaoI && this.zzaoK == textTrackStyle.zzaoK && zzym.zza(this.zzaoL, textTrackStyle.zzaoL) && this.zzaoM == textTrackStyle.zzaoM && this.zzaoN == textTrackStyle.zzaoN)) {
            z = false;
        }
        return z;
    }

    public int getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public JSONObject getCustomData() {
        return this.zzalI;
    }

    public int getEdgeColor() {
        return this.zzaoH;
    }

    public int getEdgeType() {
        return this.zzaoG;
    }

    public String getFontFamily() {
        return this.zzaoL;
    }

    public int getFontGenericFamily() {
        return this.zzaoM;
    }

    public float getFontScale() {
        return this.zzaoE;
    }

    public int getFontStyle() {
        return this.zzaoN;
    }

    public int getForegroundColor() {
        return this.zzaoF;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int getWindowColor() {
        return this.zzaoJ;
    }

    public int getWindowCornerRadius() {
        return this.zzaoK;
    }

    public int getWindowType() {
        return this.zzaoI;
    }

    public int hashCode() {
        return zzaa.hashCode(Float.valueOf(this.zzaoE), Integer.valueOf(this.zzaoF), Integer.valueOf(this.mBackgroundColor), Integer.valueOf(this.zzaoG), Integer.valueOf(this.zzaoH), Integer.valueOf(this.zzaoI), Integer.valueOf(this.zzaoJ), Integer.valueOf(this.zzaoK), this.zzaoL, Integer.valueOf(this.zzaoM), Integer.valueOf(this.zzaoN), String.valueOf(this.zzalI));
    }

    public void setBackgroundColor(int i) {
        this.mBackgroundColor = i;
    }

    public void setCustomData(JSONObject jSONObject) {
        this.zzalI = jSONObject;
    }

    public void setEdgeColor(int i) {
        this.zzaoH = i;
    }

    public void setEdgeType(int i) {
        if (i < 0 || i > FONT_FAMILY_CASUAL) {
            throw new IllegalArgumentException("invalid edgeType");
        }
        this.zzaoG = i;
    }

    public void setFontFamily(String str) {
        this.zzaoL = str;
    }

    public void setFontGenericFamily(int i) {
        if (i < 0 || i > FONT_FAMILY_SMALL_CAPITALS) {
            throw new IllegalArgumentException("invalid fontGenericFamily");
        }
        this.zzaoM = i;
    }

    public void setFontScale(float f) {
        this.zzaoE = f;
    }

    public void setFontStyle(int i) {
        if (i < 0 || i > FONT_STYLE_BOLD_ITALIC) {
            throw new IllegalArgumentException("invalid fontStyle");
        }
        this.zzaoN = i;
    }

    public void setForegroundColor(int i) {
        this.zzaoF = i;
    }

    public void setWindowColor(int i) {
        this.zzaoJ = i;
    }

    public void setWindowCornerRadius(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("invalid windowCornerRadius");
        }
        this.zzaoK = i;
    }

    public void setWindowType(int i) {
        if (i < 0 || i > WINDOW_TYPE_ROUNDED) {
            throw new IllegalArgumentException("invalid windowType");
        }
        this.zzaoI = i;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fontScale", (double) this.zzaoE);
            if (this.zzaoF != 0) {
                jSONObject.put("foregroundColor", zzZ(this.zzaoF));
            }
            if (this.mBackgroundColor != 0) {
                jSONObject.put("backgroundColor", zzZ(this.mBackgroundColor));
            }
            switch (this.zzaoG) {
                case WINDOW_TYPE_NONE /*0*/:
                    jSONObject.put("edgeType", "NONE");
                    break;
                case WINDOW_TYPE_NORMAL /*1*/:
                    jSONObject.put("edgeType", "OUTLINE");
                    break;
                case WINDOW_TYPE_ROUNDED /*2*/:
                    jSONObject.put("edgeType", "DROP_SHADOW");
                    break;
                case FONT_STYLE_BOLD_ITALIC /*3*/:
                    jSONObject.put("edgeType", "RAISED");
                    break;
                case FONT_FAMILY_CASUAL /*4*/:
                    jSONObject.put("edgeType", "DEPRESSED");
                    break;
            }
            if (this.zzaoH != 0) {
                jSONObject.put("edgeColor", zzZ(this.zzaoH));
            }
            switch (this.zzaoI) {
                case WINDOW_TYPE_NONE /*0*/:
                    jSONObject.put("windowType", "NONE");
                    break;
                case WINDOW_TYPE_NORMAL /*1*/:
                    jSONObject.put("windowType", "NORMAL");
                    break;
                case WINDOW_TYPE_ROUNDED /*2*/:
                    jSONObject.put("windowType", "ROUNDED_CORNERS");
                    break;
            }
            if (this.zzaoJ != 0) {
                jSONObject.put("windowColor", zzZ(this.zzaoJ));
            }
            if (this.zzaoI == WINDOW_TYPE_ROUNDED) {
                jSONObject.put("windowRoundedCornerRadius", this.zzaoK);
            }
            if (this.zzaoL != null) {
                jSONObject.put("fontFamily", this.zzaoL);
            }
            switch (this.zzaoM) {
                case WINDOW_TYPE_NONE /*0*/:
                    jSONObject.put("fontGenericFamily", "SANS_SERIF");
                    break;
                case WINDOW_TYPE_NORMAL /*1*/:
                    jSONObject.put("fontGenericFamily", "MONOSPACED_SANS_SERIF");
                    break;
                case WINDOW_TYPE_ROUNDED /*2*/:
                    jSONObject.put("fontGenericFamily", "SERIF");
                    break;
                case FONT_STYLE_BOLD_ITALIC /*3*/:
                    jSONObject.put("fontGenericFamily", "MONOSPACED_SERIF");
                    break;
                case FONT_FAMILY_CASUAL /*4*/:
                    jSONObject.put("fontGenericFamily", "CASUAL");
                    break;
                case FONT_FAMILY_CURSIVE /*5*/:
                    jSONObject.put("fontGenericFamily", "CURSIVE");
                    break;
                case FONT_FAMILY_SMALL_CAPITALS /*6*/:
                    jSONObject.put("fontGenericFamily", "SMALL_CAPITALS");
                    break;
            }
            switch (this.zzaoN) {
                case WINDOW_TYPE_NONE /*0*/:
                    jSONObject.put("fontStyle", "NORMAL");
                    break;
                case WINDOW_TYPE_NORMAL /*1*/:
                    jSONObject.put("fontStyle", "BOLD");
                    break;
                case WINDOW_TYPE_ROUNDED /*2*/:
                    jSONObject.put("fontStyle", "ITALIC");
                    break;
                case FONT_STYLE_BOLD_ITALIC /*3*/:
                    jSONObject.put("fontStyle", "BOLD_ITALIC");
                    break;
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
        zzn.zza(this, parcel, i);
    }

    public void zzn(JSONObject jSONObject) throws JSONException {
        String string;
        this.zzaoE = (float) jSONObject.optDouble("fontScale", 1.0d);
        this.zzaoF = zzcI(jSONObject.optString("foregroundColor"));
        this.mBackgroundColor = zzcI(jSONObject.optString("backgroundColor"));
        if (jSONObject.has("edgeType")) {
            string = jSONObject.getString("edgeType");
            if ("NONE".equals(string)) {
                this.zzaoG = WINDOW_TYPE_NONE;
            } else if ("OUTLINE".equals(string)) {
                this.zzaoG = WINDOW_TYPE_NORMAL;
            } else if ("DROP_SHADOW".equals(string)) {
                this.zzaoG = WINDOW_TYPE_ROUNDED;
            } else if ("RAISED".equals(string)) {
                this.zzaoG = FONT_STYLE_BOLD_ITALIC;
            } else if ("DEPRESSED".equals(string)) {
                this.zzaoG = FONT_FAMILY_CASUAL;
            }
        }
        this.zzaoH = zzcI(jSONObject.optString("edgeColor"));
        if (jSONObject.has("windowType")) {
            string = jSONObject.getString("windowType");
            if ("NONE".equals(string)) {
                this.zzaoI = WINDOW_TYPE_NONE;
            } else if ("NORMAL".equals(string)) {
                this.zzaoI = WINDOW_TYPE_NORMAL;
            } else if ("ROUNDED_CORNERS".equals(string)) {
                this.zzaoI = WINDOW_TYPE_ROUNDED;
            }
        }
        this.zzaoJ = zzcI(jSONObject.optString("windowColor"));
        if (this.zzaoI == WINDOW_TYPE_ROUNDED) {
            this.zzaoK = jSONObject.optInt("windowRoundedCornerRadius", WINDOW_TYPE_NONE);
        }
        this.zzaoL = jSONObject.optString("fontFamily", null);
        if (jSONObject.has("fontGenericFamily")) {
            string = jSONObject.getString("fontGenericFamily");
            if ("SANS_SERIF".equals(string)) {
                this.zzaoM = WINDOW_TYPE_NONE;
            } else if ("MONOSPACED_SANS_SERIF".equals(string)) {
                this.zzaoM = WINDOW_TYPE_NORMAL;
            } else if ("SERIF".equals(string)) {
                this.zzaoM = WINDOW_TYPE_ROUNDED;
            } else if ("MONOSPACED_SERIF".equals(string)) {
                this.zzaoM = FONT_STYLE_BOLD_ITALIC;
            } else if ("CASUAL".equals(string)) {
                this.zzaoM = FONT_FAMILY_CASUAL;
            } else if ("CURSIVE".equals(string)) {
                this.zzaoM = FONT_FAMILY_CURSIVE;
            } else if ("SMALL_CAPITALS".equals(string)) {
                this.zzaoM = FONT_FAMILY_SMALL_CAPITALS;
            }
        }
        if (jSONObject.has("fontStyle")) {
            string = jSONObject.getString("fontStyle");
            if ("NORMAL".equals(string)) {
                this.zzaoN = WINDOW_TYPE_NONE;
            } else if ("BOLD".equals(string)) {
                this.zzaoN = WINDOW_TYPE_NORMAL;
            } else if ("ITALIC".equals(string)) {
                this.zzaoN = WINDOW_TYPE_ROUNDED;
            } else if ("BOLD_ITALIC".equals(string)) {
                this.zzaoN = FONT_STYLE_BOLD_ITALIC;
            }
        }
        this.zzalI = jSONObject.optJSONObject("customData");
    }
}
