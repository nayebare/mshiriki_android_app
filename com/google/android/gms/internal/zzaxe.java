package com.google.android.gms.internal;

import android.support.v4.view.MotionEventCompat;
import com.google.android.gms.games.request.GameRequest;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Pattern;

class zzaxe {
    private static final Inet4Address zzbBA;
    private static final Pattern zzbBy;
    private static final Inet4Address zzbBz;

    static {
        zzbBy = Pattern.compile("[.]");
        zzbBz = (Inet4Address) zzgF("127.0.0.1");
        zzbBA = (Inet4Address) zzgF("0.0.0.0");
    }

    private static InetAddress zzG(byte[] bArr) {
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException e) {
            throw new AssertionError(e);
        }
    }

    private static int zza(byte b, byte b2, byte b3, byte b4) {
        return (((b << 24) | ((b2 & MotionEventCompat.ACTION_MASK) << 16)) | ((b3 & MotionEventCompat.ACTION_MASK) << 8)) | (b4 & MotionEventCompat.ACTION_MASK);
    }

    static String zza(InetAddress inetAddress) {
        if (inetAddress instanceof Inet4Address) {
            return inetAddress.getHostAddress();
        }
        byte[] address = inetAddress.getAddress();
        int[] iArr = new int[8];
        for (int i = 0; i < 8; i++) {
            iArr[i] = zza((byte) 0, (byte) 0, address[i * 2], address[(i * 2) + 1]);
        }
        zzd(iArr);
        return zze(iArr);
    }

    private static void zzd(int[] iArr) {
        int i = 0;
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        while (i < iArr.length + 1) {
            if (i >= iArr.length || iArr[i] != 0) {
                if (i2 >= 0) {
                    int i5 = i - i2;
                    if (i5 > i3) {
                        i3 = i5;
                    } else {
                        i2 = i4;
                    }
                    i4 = i2;
                    i2 = -1;
                }
            } else if (i2 < 0) {
                i2 = i;
            }
            i++;
        }
        if (i3 >= 2) {
            Arrays.fill(iArr, i4, i4 + i3, -1);
        }
    }

    private static String zze(int[] iArr) {
        StringBuilder stringBuilder = new StringBuilder(39);
        int i = 0;
        Object obj = null;
        while (i < iArr.length) {
            Object obj2 = iArr[i] >= 0 ? 1 : null;
            if (obj2 != null) {
                if (obj != null) {
                    stringBuilder.append(':');
                }
                stringBuilder.append(Integer.toHexString(iArr[i]));
            } else if (i == 0 || obj != null) {
                stringBuilder.append("::");
            }
            i++;
            obj = obj2;
        }
        return stringBuilder.toString();
    }

    private static String zzgA(String str) {
        int lastIndexOf = str.lastIndexOf(58);
        String substring = str.substring(0, lastIndexOf + 1);
        byte[] zzgB = zzgB(str.substring(lastIndexOf + 1));
        if (zzgB == null) {
            return null;
        }
        String toHexString = Integer.toHexString(((zzgB[0] & MotionEventCompat.ACTION_MASK) << 8) | (zzgB[1] & MotionEventCompat.ACTION_MASK));
        String toHexString2 = Integer.toHexString((zzgB[3] & MotionEventCompat.ACTION_MASK) | ((zzgB[2] & MotionEventCompat.ACTION_MASK) << 8));
        return new StringBuilder(((String.valueOf(substring).length() + 1) + String.valueOf(toHexString).length()) + String.valueOf(toHexString2).length()).append(substring).append(toHexString).append(":").append(toHexString2).toString();
    }

    private static byte[] zzgB(String str) {
        int i = 0;
        byte[] bArr = new byte[4];
        try {
            String[] split = zzbBy.split(str, 4);
            int length = split.length;
            int i2 = 0;
            while (i < length) {
                int i3 = i2 + 1;
                bArr[i2] = zzgC(split[i]);
                i++;
                i2 = i3;
            }
            return i2 != 4 ? null : bArr;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private static byte zzgC(String str) {
        int parseInt = Integer.parseInt(str);
        if (parseInt <= MotionEventCompat.ACTION_MASK && (!str.startsWith("0") || str.length() <= 1)) {
            return (byte) parseInt;
        }
        throw new NumberFormatException();
    }

    private static byte[] zzgD(String str) {
        String[] split = str.split(":", 10);
        if (split.length < 3 || split.length > 9) {
            return null;
        }
        int i;
        int length;
        int i2 = -1;
        for (i = 1; i < split.length - 1; i++) {
            if (split[i].length() == 0) {
                if (i2 >= 0) {
                    return null;
                }
                i2 = i;
            }
        }
        if (i2 >= 0) {
            length = (split.length - i2) - 1;
            if (split[0].length() == 0) {
                i = i2 - 1;
                if (i != 0) {
                    return null;
                }
            }
            i = i2;
            if (split[split.length - 1].length() == 0) {
                length--;
                if (length != 0) {
                    return null;
                }
            }
            int i3 = length;
            length = i;
            i = i3;
        } else {
            length = split.length;
            i = 0;
        }
        int i4 = 8 - (length + i);
        if (!i2 < 0 ? i4 >= 1 : i4 == 0) {
            return null;
        }
        ByteBuffer allocate = ByteBuffer.allocate(16);
        int i5 = 0;
        while (i5 < length) {
            try {
                allocate.putShort(zzgE(split[i5]));
                i5++;
            } catch (NumberFormatException e) {
                return null;
            }
        }
        for (i5 = 0; i5 < i4; i5++) {
            allocate.putShort((short) 0);
        }
        while (i > 0) {
            allocate.putShort(zzgE(split[split.length - i]));
            i--;
        }
        return allocate.array();
    }

    private static short zzgE(String str) {
        int parseInt = Integer.parseInt(str, 16);
        if (parseInt <= GameRequest.TYPE_ALL) {
            return (short) parseInt;
        }
        throw new NumberFormatException();
    }

    static InetAddress zzgF(String str) {
        byte[] zzgz = zzgz(str);
        if (zzgz != null) {
            return zzG(zzgz);
        }
        throw zzh("'%s' is not an IP string literal.", str);
    }

    static boolean zzgy(String str) {
        return zzgz(str) != null;
    }

    private static byte[] zzgz(String str) {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt == '.') {
                i2 = 1;
            } else if (charAt == ':') {
                if (i2 != 0) {
                    return null;
                }
                i3 = 1;
            } else if (Character.digit(charAt, 16) == -1) {
                return null;
            }
            i++;
        }
        if (i3 == 0) {
            return i2 != 0 ? zzgB(str) : null;
        } else {
            if (i2 != 0) {
                str = zzgA(str);
                if (str == null) {
                    return null;
                }
            }
            return zzgD(str);
        }
    }

    private static IllegalArgumentException zzh(String str, Object... objArr) {
        return new IllegalArgumentException(String.format(Locale.ROOT, str, objArr));
    }
}
