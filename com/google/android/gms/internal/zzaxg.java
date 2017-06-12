package com.google.android.gms.internal;

import android.net.Uri;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import com.github.mikephil.charting.BuildConfig;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.protocol.HTTP;

public class zzaxg {
    private static final String TAG;
    private static final char[] zzbBC;
    private static final Pattern zzbBD;
    private static final Pattern zzbBE;
    private static final Pattern zzbBF;
    private static final Pattern zzbBG;
    private final String mPath;
    private final String zzD;
    private final String zzbBH;
    private final String zzbBI;
    private final int zzbBJ;
    private final String zzuv;

    private static class zza {
        private static final String[] zzbBK;
        private final String zzagi;
        private final String zzbBH;
        private final Uri zzbBL;
        private final URI zzbBM;
        private final Boolean zzbBN;
        private final Integer zzbBO;

        static {
            zzbBK = new String[]{"http", "https", "ftp"};
        }

        private zza(String str) {
            this.zzagi = str;
            this.zzbBL = Uri.parse(this.zzagi);
            try {
                URI uri = new URI(this.zzagi);
            } catch (URISyntaxException e) {
            } finally {
                this.zzbBM = null;
            }
            this.zzbBH = getScheme();
            this.zzbBN = Boolean.valueOf(zzNY());
            this.zzbBO = Integer.valueOf(zzNX());
        }

        private int getPort() {
            return this.zzbBO.intValue();
        }

        private String getScheme() {
            if (this.zzbBH != null) {
                return this.zzbBH;
            }
            String scheme = this.zzbBL != null ? this.zzbBL.getScheme() : null;
            TextUtils.isEmpty(scheme);
            if (TextUtils.isEmpty(scheme) && !TextUtils.isEmpty(this.zzagi)) {
                int indexOf = this.zzagi.indexOf(":");
                if (indexOf != -1) {
                    String toLowerCase = this.zzagi.substring(0, indexOf).toLowerCase(Locale.US);
                    if (zzgO(toLowerCase)) {
                        scheme = toLowerCase;
                    }
                }
                if (TextUtils.isEmpty(scheme)) {
                    scheme = this.zzagi.startsWith("www.") ? "http" : "http";
                }
            }
            return scheme != null ? scheme.toLowerCase(Locale.US) : null;
        }

        private int zzNX() {
            if (this.zzbBO != null) {
                return this.zzbBO.intValue();
            }
            if (this.zzbBL != null) {
                int port = this.zzbBL.getPort();
                if (port != -1) {
                    return port;
                }
            }
            return -1;
        }

        private boolean zzNY() {
            return this.zzbBN != null ? this.zzbBN.booleanValue() : zzgO(this.zzbBH);
        }

        private static boolean zzgO(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            for (String equals : zzbBK) {
                if (equals.equals(str)) {
                    return true;
                }
            }
            return false;
        }
    }

    static {
        TAG = zzaxg.class.getSimpleName();
        zzbBC = "0123456789ABCDEF".toCharArray();
        zzbBD = Pattern.compile("/\\.\\.");
        zzbBE = Pattern.compile("0[1-7][0-7]*");
        zzbBF = Pattern.compile("0x[0-9a-f]*", 2);
        zzbBG = Pattern.compile("^((?:0x[0-9a-f]+|[0-9\\\\.])+)$", 2);
    }

    public zzaxg(String str) {
        if (zzgK(str)) {
            String replaceAll = str.replaceAll("^\\s+", BuildConfig.FLAVOR).replaceAll("\\s+$", BuildConfig.FLAVOR).replaceAll("[\\t\\n\\r]", BuildConfig.FLAVOR);
            int indexOf = replaceAll.indexOf(35);
            if (indexOf != -1) {
                replaceAll = replaceAll.substring(0, indexOf);
            }
            zza com_google_android_gms_internal_zzaxg_zza = new zza(null);
            if (com_google_android_gms_internal_zzaxg_zza.zzNY()) {
                String str2;
                this.zzbBH = com_google_android_gms_internal_zzaxg_zza.getScheme();
                this.zzbBJ = com_google_android_gms_internal_zzaxg_zza.getPort();
                if (this.zzbBH != null) {
                    str2 = this.zzbBH;
                    replaceAll = replaceAll.replaceAll(new StringBuilder(String.valueOf(str2).length() + 2).append("^").append(str2).append(":").toString(), BuildConfig.FLAVOR);
                }
                str2 = zzgM(replaceAll.replaceAll("^/+", BuildConfig.FLAVOR));
                int indexOf2 = str2.indexOf(63);
                if (indexOf2 != -1) {
                    int i = indexOf2 + 1;
                    replaceAll = i < str2.length() ? str2.substring(i) : BuildConfig.FLAVOR;
                    str2 = str2.substring(0, indexOf2);
                } else {
                    replaceAll = null;
                }
                Object zzgG = zzgG(str2);
                if (TextUtils.isEmpty(zzgG)) {
                    this.zzD = null;
                    this.zzbBI = null;
                    this.mPath = null;
                    this.zzuv = null;
                    return;
                }
                String zzgJ = zzgJ(str2);
                this.zzbBI = zzgL(zzgG);
                this.mPath = zzgL(zzgJ);
                if (!TextUtils.isEmpty(replaceAll)) {
                    replaceAll = zzgL(replaceAll);
                }
                this.zzuv = replaceAll;
                this.zzD = str2;
                return;
            }
            this.zzD = null;
            this.zzbBH = null;
            this.zzbBI = null;
            this.zzbBJ = -1;
            this.mPath = null;
            this.zzuv = null;
            return;
        }
        this.zzD = null;
        this.zzbBH = null;
        this.zzbBI = null;
        this.zzbBJ = -1;
        this.mPath = null;
        this.zzuv = null;
    }

    private static boolean isHexDigit(char c) {
        return (c >= '0' && c <= '9') || ((c >= 'A' && c <= 'F') || (c >= 'a' && c <= 'f'));
    }

    private List<String> zzNV() {
        if (TextUtils.isEmpty(this.zzbBI)) {
            return null;
        }
        List<String> arrayList = new ArrayList();
        char[] toCharArray = this.zzbBI.toCharArray();
        Object obj = null;
        for (int length = toCharArray.length - 2; length > 0 && arrayList.size() < 4; length--) {
            if (toCharArray[length] == '.') {
                if (obj != null) {
                    arrayList.add(this.zzbBI.substring(length + 1));
                } else {
                    obj = 1;
                }
            }
        }
        arrayList.add(this.zzbBI);
        return arrayList;
    }

    private List<String> zzNW() {
        if (TextUtils.isEmpty(this.mPath)) {
            return null;
        }
        List<String> arrayList = new ArrayList();
        char[] toCharArray = this.mPath.toCharArray();
        for (int i = 0; i < toCharArray.length && arrayList.size() < 4; i++) {
            if (toCharArray[i] == '/') {
                arrayList.add(this.mPath.substring(0, i + 1));
            }
        }
        if (!(arrayList.isEmpty() || ((String) arrayList.get(arrayList.size() - 1)).equals(this.mPath))) {
            arrayList.add(this.mPath);
        }
        if (!TextUtils.isEmpty(this.zzuv)) {
            String str = this.mPath;
            String str2 = this.zzuv;
            arrayList.add(new StringBuilder((String.valueOf(str).length() + 1) + String.valueOf(str2).length()).append(str).append("?").append(str2).toString());
        }
        return arrayList;
    }

    private static Byte zzc(byte[] bArr, int i) {
        if (i + 2 >= bArr.length || ((char) (bArr[i] & MotionEventCompat.ACTION_MASK)) != '%') {
            return null;
        }
        char c = (char) (bArr[i + 1] & MotionEventCompat.ACTION_MASK);
        char c2 = (char) (bArr[i + 2] & MotionEventCompat.ACTION_MASK);
        return (isHexDigit(c) && isHexDigit(c2)) ? Byte.valueOf((byte) ((Integer.parseInt(c, 16) * 16) + Integer.parseInt(c2, 16))) : null;
    }

    private String zzgG(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf(47);
        if (indexOf != -1) {
            str = str.substring(0, indexOf);
        }
        indexOf = str.indexOf(64);
        if (indexOf != -1) {
            str = str.substring(indexOf + 1);
        }
        if (this.zzbBJ != -1) {
            str = str.replaceAll(":" + this.zzbBJ + "$", BuildConfig.FLAVOR);
        }
        String replaceAll = str.replaceAll("^\\.*", BuildConfig.FLAVOR).replaceAll("\\.*$", BuildConfig.FLAVOR).replaceAll("\\.+", ".");
        String zzgH = zzgH(replaceAll);
        if (zzgH == null) {
            zzgH = replaceAll;
        }
        return zzgH.toLowerCase(Locale.getDefault());
    }

    private static String zzgH(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        CharSequence replaceAll = str.replaceAll("^\\[", BuildConfig.FLAVOR).replaceAll("\\]$", BuildConfig.FLAVOR);
        String zza;
        if (zzaxe.zzgy(replaceAll)) {
            zza = zzaxe.zza(zzaxe.zzgF(replaceAll));
            if (!zza.contains(":")) {
                return zza;
            }
            return String.format("[%s]", new Object[]{zza});
        } else if (TextUtils.isDigitsOnly(str)) {
            replaceAll = zzgI(str);
            return !TextUtils.isEmpty(replaceAll) ? replaceAll : null;
        } else if (!zzbBG.matcher(replaceAll).find()) {
            return null;
        } else {
            Matcher matcher = zzbBE.matcher(replaceAll);
            StringBuffer stringBuffer = new StringBuffer();
            while (matcher.find()) {
                matcher.appendReplacement(stringBuffer, Integer.parseInt(matcher.group(), 8));
            }
            matcher.appendTail(stringBuffer);
            matcher = zzbBF.matcher(stringBuffer.toString());
            stringBuffer = new StringBuffer();
            while (matcher.find()) {
                matcher.appendReplacement(stringBuffer, Integer.parseInt(matcher.group().substring(2), 16));
            }
            matcher.appendTail(stringBuffer);
            zza = stringBuffer.toString();
            if (!zza.contains(":")) {
                return zza;
            }
            return String.format("[%s]", new Object[]{zza});
        }
    }

    private static String zzgI(String str) {
        int i = 0;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            BigInteger bigInteger = new BigInteger(str);
            byte[] toByteArray = bigInteger.toByteArray();
            if (toByteArray.length < 4) {
                return null;
            }
            if (bigInteger.equals(new BigInteger(new byte[]{(byte) 0, r4[0], r4[1], r4[2], Arrays.copyOfRange(toByteArray, toByteArray.length - 4, toByteArray.length)[3]}))) {
                return Inet4Address.getByAddress(Arrays.copyOfRange(toByteArray, toByteArray.length - 4, toByteArray.length)).getHostAddress();
            }
            byte[] copyOfRange;
            if (toByteArray.length >= 16) {
                copyOfRange = Arrays.copyOfRange(toByteArray, toByteArray.length - 16, toByteArray.length);
            } else {
                copyOfRange = new byte[16];
                int length = 16 - toByteArray.length;
                int i2 = 1;
                int i3 = 0;
                while (i2 <= length) {
                    int i4 = i3 + 1;
                    copyOfRange[i3] = (byte) 0;
                    i2++;
                    i3 = i4;
                }
                while (i < toByteArray.length) {
                    i2 = i3 + 1;
                    copyOfRange[i3] = toByteArray[i];
                    i++;
                    i3 = i2;
                }
            }
            return String.format("[%s]", new Object[]{Inet6Address.getByAddress(copyOfRange).getHostAddress()});
        } catch (NumberFormatException e) {
            return null;
        } catch (ArrayIndexOutOfBoundsException e2) {
            return null;
        } catch (UnknownHostException e3) {
            return null;
        }
    }

    private String zzgJ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf(47);
        String replaceAll = (indexOf != -1 ? str.substring(indexOf) : "/").replaceAll("/\\./", "/").replaceAll("/\\.$", "/");
        if (zzbBD.matcher(replaceAll).find()) {
            try {
                replaceAll = new URI(this.zzbBH, "host", replaceAll, null).normalize().getRawPath();
            } catch (URISyntaxException e) {
            }
        }
        return replaceAll.replaceAll("/+", "/");
    }

    private static boolean zzgK(String str) {
        return !TextUtils.isEmpty(str);
    }

    private static String zzgL(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] bytes = str.getBytes(HTTP.UTF_8);
            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : bytes) {
                char c = (char) (b & MotionEventCompat.ACTION_MASK);
                if (c <= ' ' || c > '~' || c == '#' || c == '%') {
                    stringBuilder.append("%");
                    stringBuilder.append(zzbBC[c >>> 4]);
                    stringBuilder.append(zzbBC[c & 15]);
                } else {
                    stringBuilder.append(c);
                }
            }
            return stringBuilder.toString();
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    private static String zzgM(String str) {
        Object obj = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int i = 0;
        String str2 = str;
        while (!str2.equals(obj) && i < AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT) {
            i++;
            String str3 = str2;
            str2 = zzgN(str2);
        }
        return str2;
    }

    private static String zzgN(String str) {
        try {
            byte[] bytes = str.replace("\\x", "%").getBytes(HTTP.UTF_8);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bytes.length);
            int i = 0;
            while (i < bytes.length) {
                byte b = bytes[i];
                if (((char) (b & MotionEventCompat.ACTION_MASK)) >= '\u0080') {
                    byteArrayOutputStream.write(b);
                } else {
                    Byte zzc = zzc(bytes, i);
                    if (zzc != null) {
                        byteArrayOutputStream.write(zzc.byteValue());
                        i += 2;
                    } else {
                        byteArrayOutputStream.write(b);
                    }
                }
                i++;
            }
            try {
                return new String(byteArrayOutputStream.toByteArray(), HTTP.UTF_8);
            } catch (UnsupportedEncodingException e) {
                return null;
            }
        } catch (UnsupportedEncodingException e2) {
            return null;
        }
    }

    public List<String> zzNT() {
        if (TextUtils.isEmpty(this.zzD)) {
            return null;
        }
        String zzgH = zzgH(this.zzbBI);
        List arrayList;
        if (zzgH != null) {
            arrayList = new ArrayList();
            arrayList.add(zzgH);
        } else {
            arrayList = zzNV();
        }
        if (r0 == null || r0.isEmpty()) {
            return null;
        }
        List<String> zzNW = zzNW();
        if (zzNW == null || zzNW.isEmpty()) {
            return null;
        }
        List<String> linkedList = new LinkedList();
        for (String str : r0) {
            for (String zzgH2 : zzNW) {
                String valueOf = String.valueOf(str);
                zzgH2 = String.valueOf(zzgH2);
                linkedList.add(zzgH2.length() != 0 ? valueOf.concat(zzgH2) : new String(valueOf));
            }
        }
        return !linkedList.isEmpty() ? linkedList : null;
    }

    public List<zzaxd> zzNU() {
        List<String> zzNT = zzNT();
        if (zzNT == null || zzNT.isEmpty()) {
            return null;
        }
        MessageDigest instance;
        try {
            instance = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            instance = null;
        }
        if (instance == null) {
            return null;
        }
        List<zzaxd> arrayList = new ArrayList(zzNT.size());
        for (String str : zzNT) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    arrayList.add(new zzaxd(instance.digest(str.getBytes(HTTP.UTF_8))));
                } catch (UnsupportedEncodingException e2) {
                }
                instance.reset();
            }
        }
        return !arrayList.isEmpty() ? arrayList : null;
    }
}
