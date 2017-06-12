package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.Exclude;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.PropertyName;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class zzbqi {
    private static final ConcurrentMap<Class<?>, zza<?>> zzciE;

    private static class zza<T> {
        private final Class<T> zzciF;
        private final Constructor<T> zzciG;
        private final boolean zzciH;
        private final boolean zzciI;
        private final Map<String, String> zzciJ;
        private final Map<String, Method> zzciK;
        private final Map<String, Method> zzciL;
        private final Map<String, Field> zzciM;

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public zza(java.lang.Class<T> r11) {
            /*
            r10 = this;
            r1 = 1;
            r2 = 0;
            r10.<init>();
            r10.zzciF = r11;
            r0 = com.google.firebase.database.ThrowOnExtraProperties.class;
            r0 = r11.isAnnotationPresent(r0);
            r10.zzciH = r0;
            r0 = com.google.firebase.database.IgnoreExtraProperties.class;
            r0 = r11.isAnnotationPresent(r0);
            if (r0 != 0) goto L_0x007f;
        L_0x0017:
            r0 = r1;
        L_0x0018:
            r10.zzciI = r0;
            r0 = new java.util.HashMap;
            r0.<init>();
            r10.zzciJ = r0;
            r0 = new java.util.HashMap;
            r0.<init>();
            r10.zzciL = r0;
            r0 = new java.util.HashMap;
            r0.<init>();
            r10.zzciK = r0;
            r0 = new java.util.HashMap;
            r0.<init>();
            r10.zzciM = r0;
            r0 = 0;
            r0 = new java.lang.Class[r0];	 Catch:{ NoSuchMethodException -> 0x0081 }
            r0 = r11.getDeclaredConstructor(r0);	 Catch:{ NoSuchMethodException -> 0x0081 }
            r3 = 1;
            r0.setAccessible(r3);	 Catch:{ NoSuchMethodException -> 0x0081 }
        L_0x0041:
            r10.zzciG = r0;
            r3 = r11.getMethods();
            r4 = r3.length;
            r0 = r2;
        L_0x0049:
            if (r0 >= r4) goto L_0x0092;
        L_0x004b:
            r5 = r3[r0];
            r6 = zza(r5);
            if (r6 == 0) goto L_0x008f;
        L_0x0053:
            r6 = zzc(r5);
            r10.zzjs(r6);
            r5.setAccessible(r1);
            r7 = r10.zzciK;
            r7 = r7.containsKey(r6);
            if (r7 == 0) goto L_0x008a;
        L_0x0065:
            r1 = new com.google.firebase.database.DatabaseException;
            r2 = "Found conflicting getters for name: ";
            r0 = r5.getName();
            r0 = java.lang.String.valueOf(r0);
            r3 = r0.length();
            if (r3 == 0) goto L_0x0084;
        L_0x0077:
            r0 = r2.concat(r0);
        L_0x007b:
            r1.<init>(r0);
            throw r1;
        L_0x007f:
            r0 = r2;
            goto L_0x0018;
        L_0x0081:
            r0 = move-exception;
            r0 = 0;
            goto L_0x0041;
        L_0x0084:
            r0 = new java.lang.String;
            r0.<init>(r2);
            goto L_0x007b;
        L_0x008a:
            r7 = r10.zzciK;
            r7.put(r6, r5);
        L_0x008f:
            r0 = r0 + 1;
            goto L_0x0049;
        L_0x0092:
            r3 = r11.getFields();
            r4 = r3.length;
            r0 = r2;
        L_0x0098:
            if (r0 >= r4) goto L_0x00ac;
        L_0x009a:
            r5 = r3[r0];
            r6 = zza(r5);
            if (r6 == 0) goto L_0x00a9;
        L_0x00a2:
            r5 = zzb(r5);
            r10.zzjs(r5);
        L_0x00a9:
            r0 = r0 + 1;
            goto L_0x0098;
        L_0x00ac:
            r3 = r11;
        L_0x00ad:
            r5 = r3.getDeclaredMethods();
            r6 = r5.length;
            r4 = r2;
        L_0x00b3:
            if (r4 >= r6) goto L_0x017c;
        L_0x00b5:
            r7 = r5[r4];
            r0 = zzb(r7);
            if (r0 == 0) goto L_0x0107;
        L_0x00bd:
            r8 = zzc(r7);
            r0 = r10.zzciJ;
            r9 = r8.toLowerCase();
            r0 = r0.get(r9);
            r0 = (java.lang.String) r0;
            if (r0 == 0) goto L_0x0107;
        L_0x00cf:
            r0 = r0.equals(r8);
            if (r0 != 0) goto L_0x00f5;
        L_0x00d5:
            r1 = new com.google.firebase.database.DatabaseException;
            r2 = "Found setter with invalid case-sensitive name: ";
            r0 = r7.getName();
            r0 = java.lang.String.valueOf(r0);
            r3 = r0.length();
            if (r3 == 0) goto L_0x00ef;
        L_0x00e7:
            r0 = r2.concat(r0);
        L_0x00eb:
            r1.<init>(r0);
            throw r1;
        L_0x00ef:
            r0 = new java.lang.String;
            r0.<init>(r2);
            goto L_0x00eb;
        L_0x00f5:
            r0 = r10.zzciL;
            r0 = r0.get(r8);
            r0 = (java.lang.reflect.Method) r0;
            if (r0 != 0) goto L_0x010b;
        L_0x00ff:
            r7.setAccessible(r1);
            r0 = r10.zzciL;
            r0.put(r8, r7);
        L_0x0107:
            r0 = r4 + 1;
            r4 = r0;
            goto L_0x00b3;
        L_0x010b:
            r8 = zza(r7, r0);
            if (r8 != 0) goto L_0x0107;
        L_0x0111:
            r1 = new com.google.firebase.database.DatabaseException;
            r2 = r7.getName();
            r2 = java.lang.String.valueOf(r2);
            r3 = r0.getName();
            r3 = java.lang.String.valueOf(r3);
            r0 = r0.getDeclaringClass();
            r0 = r0.getName();
            r0 = java.lang.String.valueOf(r0);
            r4 = new java.lang.StringBuilder;
            r5 = java.lang.String.valueOf(r2);
            r5 = r5.length();
            r5 = r5 + 69;
            r6 = java.lang.String.valueOf(r3);
            r6 = r6.length();
            r5 = r5 + r6;
            r6 = java.lang.String.valueOf(r0);
            r6 = r6.length();
            r5 = r5 + r6;
            r4.<init>(r5);
            r5 = "Found a conflicting setters with name: ";
            r4 = r4.append(r5);
            r2 = r4.append(r2);
            r4 = " (conflicts with ";
            r2 = r2.append(r4);
            r2 = r2.append(r3);
            r3 = " defined on ";
            r2 = r2.append(r3);
            r0 = r2.append(r0);
            r2 = ")";
            r0 = r0.append(r2);
            r0 = r0.toString();
            r1.<init>(r0);
            throw r1;
        L_0x017c:
            r4 = r3.getDeclaredFields();
            r5 = r4.length;
            r0 = r2;
        L_0x0182:
            if (r0 >= r5) goto L_0x01a9;
        L_0x0184:
            r6 = r4[r0];
            r7 = zzb(r6);
            r8 = r10.zzciJ;
            r9 = r7.toLowerCase();
            r8 = r8.containsKey(r9);
            if (r8 == 0) goto L_0x01a6;
        L_0x0196:
            r8 = r10.zzciM;
            r8 = r8.containsKey(r7);
            if (r8 != 0) goto L_0x01a6;
        L_0x019e:
            r6.setAccessible(r1);
            r8 = r10.zzciM;
            r8.put(r7, r6);
        L_0x01a6:
            r0 = r0 + 1;
            goto L_0x0182;
        L_0x01a9:
            r0 = r3.getSuperclass();
            if (r0 == 0) goto L_0x01b7;
        L_0x01af:
            r3 = java.lang.Object.class;
            r3 = r0.equals(r3);
            if (r3 == 0) goto L_0x01e0;
        L_0x01b7:
            r0 = r10.zzciJ;
            r0 = r0.isEmpty();
            if (r0 == 0) goto L_0x01df;
        L_0x01bf:
            r1 = new com.google.firebase.database.DatabaseException;
            r2 = "No properties to serialize found on class ";
            r0 = r11.getName();
            r0 = java.lang.String.valueOf(r0);
            r3 = r0.length();
            if (r3 == 0) goto L_0x01d9;
        L_0x01d1:
            r0 = r2.concat(r0);
        L_0x01d5:
            r1.<init>(r0);
            throw r1;
        L_0x01d9:
            r0 = new java.lang.String;
            r0.<init>(r2);
            goto L_0x01d5;
        L_0x01df:
            return;
        L_0x01e0:
            r3 = r0;
            goto L_0x00ad;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzbqi.zza.<init>(java.lang.Class):void");
        }

        private static String zza(AccessibleObject accessibleObject) {
            return accessibleObject.isAnnotationPresent(PropertyName.class) ? ((PropertyName) accessibleObject.getAnnotation(PropertyName.class)).value() : null;
        }

        private Type zza(Type type, Map<TypeVariable<Class<T>>, Type> map) {
            if (!(type instanceof TypeVariable)) {
                return type;
            }
            Type type2 = (Type) map.get(type);
            if (type2 != null) {
                return type2;
            }
            String valueOf = String.valueOf(type);
            throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 23).append("Could not resolve type ").append(valueOf).toString());
        }

        private static boolean zza(Field field) {
            return (field.getDeclaringClass().equals(Object.class) || !Modifier.isPublic(field.getModifiers()) || Modifier.isStatic(field.getModifiers()) || Modifier.isTransient(field.getModifiers()) || field.isAnnotationPresent(Exclude.class)) ? false : true;
        }

        private static boolean zza(Method method) {
            return ((!method.getName().startsWith("get") && !method.getName().startsWith("is")) || method.getDeclaringClass().equals(Object.class) || !Modifier.isPublic(method.getModifiers()) || Modifier.isStatic(method.getModifiers()) || method.getReturnType().equals(Void.TYPE) || method.getParameterTypes().length != 0 || method.isAnnotationPresent(Exclude.class)) ? false : true;
        }

        private static boolean zza(Method method, Method method2) {
            zzbqg.zzb(method.getDeclaringClass().isAssignableFrom(method2.getDeclaringClass()), "Expected override from a base class");
            zzbqg.zzb(method.getReturnType().equals(Void.TYPE), "Expected void return type");
            zzbqg.zzb(method2.getReturnType().equals(Void.TYPE), "Expected void return type");
            Class[] parameterTypes = method.getParameterTypes();
            Class[] parameterTypes2 = method2.getParameterTypes();
            zzbqg.zzb(parameterTypes.length == 1, "Expected exactly one parameter");
            zzbqg.zzb(parameterTypes2.length == 1, "Expected exactly one parameter");
            return method.getName().equals(method2.getName()) && parameterTypes[0].equals(parameterTypes2[0]);
        }

        private static String zzb(Field field) {
            String zza = zza((AccessibleObject) field);
            return zza != null ? zza : field.getName();
        }

        private static boolean zzb(Method method) {
            return method.getName().startsWith("set") && !method.getDeclaringClass().equals(Object.class) && !Modifier.isStatic(method.getModifiers()) && method.getReturnType().equals(Void.TYPE) && method.getParameterTypes().length == 1 && !method.isAnnotationPresent(Exclude.class);
        }

        private static String zzc(Method method) {
            String zza = zza((AccessibleObject) method);
            return zza != null ? zza : zzjt(method.getName());
        }

        private void zzjs(String str) {
            String str2 = (String) this.zzciJ.put(str.toLowerCase(), str);
            if (str2 != null && !str.equals(str2)) {
                String str3 = "Found two getters or fields with conflicting case sensitivity for property: ";
                str2 = String.valueOf(str.toLowerCase());
                throw new DatabaseException(str2.length() != 0 ? str3.concat(str2) : new String(str3));
            }
        }

        private static String zzjt(String str) {
            String[] strArr = new String[]{"get", "set", "is"};
            String str2 = null;
            int i = 0;
            while (i < 3) {
                String str3 = strArr[i];
                if (!str.startsWith(str3)) {
                    str3 = str2;
                }
                i++;
                str2 = str3;
            }
            if (str2 == null) {
                String str4 = "Unknown Bean prefix for method: ";
                str3 = String.valueOf(str);
                throw new IllegalArgumentException(str3.length() != 0 ? str4.concat(str3) : new String(str4));
            }
            char[] toCharArray = str.substring(str2.length()).toCharArray();
            int i2 = 0;
            while (i2 < toCharArray.length && Character.isUpperCase(toCharArray[i2])) {
                toCharArray[i2] = Character.toLowerCase(toCharArray[i2]);
                i2++;
            }
            return new String(toCharArray);
        }

        public Map<String, Object> zzaF(T t) {
            if (this.zzciF.isAssignableFrom(t.getClass())) {
                Map<String, Object> hashMap = new HashMap();
                for (String str : this.zzciJ.values()) {
                    String str2;
                    Object invoke;
                    if (this.zzciK.containsKey(str2)) {
                        try {
                            invoke = ((Method) this.zzciK.get(str2)).invoke(t, new Object[0]);
                        } catch (Throwable e) {
                            throw new RuntimeException(e);
                        } catch (Throwable e2) {
                            throw new RuntimeException(e2);
                        }
                    }
                    Field field = (Field) this.zzciM.get(str2);
                    if (field == null) {
                        String str3 = "Bean property without field or getter:";
                        str2 = String.valueOf(str2);
                        throw new IllegalStateException(str2.length() != 0 ? str3.concat(str2) : new String(str3));
                    }
                    try {
                        invoke = field.get(t);
                    } catch (Throwable e22) {
                        throw new RuntimeException(e22);
                    }
                    hashMap.put(str2, zzbqi.zzax(invoke));
                }
                return hashMap;
            }
            String valueOf = String.valueOf(t.getClass());
            str3 = String.valueOf(this.zzciF);
            throw new IllegalArgumentException(new StringBuilder((String.valueOf(valueOf).length() + 59) + String.valueOf(str3).length()).append("Can't serialize object of class ").append(valueOf).append(" with BeanMapper for class ").append(str3).toString());
        }

        public T zzaG(Map<String, Object> map) {
            return zze(map, Collections.emptyMap());
        }

        public T zze(Map<String, Object> map, Map<TypeVariable<Class<T>>, Type> map2) {
            if (this.zzciG == null) {
                String valueOf = String.valueOf(this.zzciF.getName());
                throw new DatabaseException(new StringBuilder(String.valueOf(valueOf).length() + 49).append("Class ").append(valueOf).append(" is missing a constructor with no arguments").toString());
            }
            try {
                T newInstance = this.zzciG.newInstance(new Object[0]);
                for (Entry entry : map.entrySet()) {
                    valueOf = (String) entry.getKey();
                    if (this.zzciL.containsKey(valueOf)) {
                        Method method = (Method) this.zzciL.get(valueOf);
                        Type[] genericParameterTypes = method.getGenericParameterTypes();
                        if (genericParameterTypes.length != 1) {
                            throw new IllegalStateException("Setter does not have exactly one parameter");
                        }
                        Object zzb = zzbqi.zza(entry.getValue(), zza(genericParameterTypes[0], (Map) map2));
                        try {
                            method.invoke(newInstance, new Object[]{zzb});
                        } catch (Throwable e) {
                            throw new RuntimeException(e);
                        } catch (Throwable e2) {
                            throw new RuntimeException(e2);
                        }
                    } else if (this.zzciM.containsKey(valueOf)) {
                        Field field = (Field) this.zzciM.get(valueOf);
                        try {
                            field.set(newInstance, zzbqi.zza(entry.getValue(), zza(field.getGenericType(), (Map) map2)));
                        } catch (Throwable e22) {
                            throw new RuntimeException(e22);
                        }
                    } else {
                        String valueOf2 = String.valueOf(this.zzciF.getName());
                        valueOf2 = new StringBuilder((String.valueOf(valueOf).length() + 36) + String.valueOf(valueOf2).length()).append("No setter/field for ").append(valueOf).append(" found on class ").append(valueOf2).toString();
                        if (this.zzciJ.containsKey(valueOf.toLowerCase())) {
                            valueOf2 = String.valueOf(valueOf2).concat(" (fields/setters are case sensitive!)");
                        }
                        if (this.zzciH) {
                            throw new DatabaseException(valueOf2);
                        } else if (this.zzciI) {
                            Log.w("ClassMapper", valueOf2);
                        }
                    }
                }
                return newInstance;
            } catch (Throwable e222) {
                throw new RuntimeException(e222);
            } catch (Throwable e2222) {
                throw new RuntimeException(e2222);
            } catch (Throwable e22222) {
                throw new RuntimeException(e22222);
            }
        }
    }

    static {
        zzciE = new ConcurrentHashMap();
    }

    public static <T> T zza(Object obj, GenericTypeIndicator<T> genericTypeIndicator) {
        Type genericSuperclass = genericTypeIndicator.getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            if (parameterizedType.getRawType().equals(GenericTypeIndicator.class)) {
                return zza(obj, parameterizedType.getActualTypeArguments()[0]);
            }
            String valueOf = String.valueOf(genericSuperclass);
            throw new DatabaseException(new StringBuilder(String.valueOf(valueOf).length() + 47).append("Not a direct subclass of GenericTypeIndicator: ").append(valueOf).toString());
        }
        valueOf = String.valueOf(genericSuperclass);
        throw new DatabaseException(new StringBuilder(String.valueOf(valueOf).length() + 47).append("Not a direct subclass of GenericTypeIndicator: ").append(valueOf).toString());
    }

    public static <T> T zza(Object obj, Class<T> cls) {
        return zzb(obj, (Class) cls);
    }

    private static <T> T zza(Object obj, ParameterizedType parameterizedType) {
        Class cls = (Class) parameterizedType.getRawType();
        if (List.class.isAssignableFrom(cls)) {
            Type type = parameterizedType.getActualTypeArguments()[0];
            if (obj instanceof List) {
                List<Object> list = (List) obj;
                T arrayList = new ArrayList(list.size());
                for (Object zza : list) {
                    arrayList.add(zza(zza, type));
                }
                return arrayList;
            }
            String valueOf = String.valueOf(obj.getClass());
            throw new DatabaseException(new StringBuilder(String.valueOf(valueOf).length() + 47).append("Expected a List while deserializing, but got a ").append(valueOf).toString());
        } else if (Map.class.isAssignableFrom(cls)) {
            Object obj2 = parameterizedType.getActualTypeArguments()[0];
            Type type2 = parameterizedType.getActualTypeArguments()[1];
            if (obj2.equals(String.class)) {
                Map zzay = zzay(obj);
                T hashMap = new HashMap();
                for (Entry entry : zzay.entrySet()) {
                    hashMap.put((String) entry.getKey(), zza(entry.getValue(), type2));
                }
                return hashMap;
            }
            String valueOf2 = String.valueOf(obj2);
            throw new DatabaseException(new StringBuilder(String.valueOf(valueOf2).length() + 70).append("Only Maps with string keys are supported, but found Map with key type ").append(valueOf2).toString());
        } else if (Collection.class.isAssignableFrom(cls)) {
            throw new DatabaseException("Collections are not supported, please use Lists instead");
        } else {
            Map zzay2 = zzay(obj);
            zza zzi = zzi(cls);
            Map hashMap2 = new HashMap();
            TypeVariable[] typeParameters = zzi.zzciF.getTypeParameters();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            if (actualTypeArguments.length != typeParameters.length) {
                throw new IllegalStateException("Mismatched lengths for type variables and actual types");
            }
            for (int i = 0; i < typeParameters.length; i++) {
                hashMap2.put(typeParameters[i], actualTypeArguments[i]);
            }
            return zzi.zze(zzay2, hashMap2);
        }
    }

    private static <T> T zza(Object obj, Type type) {
        if (obj == null) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            return zza(obj, (ParameterizedType) type);
        }
        if (type instanceof Class) {
            return zzb(obj, (Class) type);
        }
        if (type instanceof WildcardType) {
            throw new DatabaseException("Generic wildcard types are not supported");
        } else if (type instanceof GenericArrayType) {
            throw new DatabaseException("Generic Arrays are not supported, please use Lists instead");
        } else {
            String valueOf = String.valueOf(type);
            throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 26).append("Unknown type encountered: ").append(valueOf).toString());
        }
    }

    private static Long zzaA(Object obj) {
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).longValue());
        }
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof Double) {
            Double d = (Double) obj;
            if (d.doubleValue() >= -9.223372036854776E18d && d.doubleValue() <= 9.223372036854776E18d) {
                return Long.valueOf(d.longValue());
            }
            String valueOf = String.valueOf(d);
            throw new DatabaseException(new StringBuilder(String.valueOf(valueOf).length() + 89).append("Numeric value out of 64-bit long range: ").append(valueOf).append(". Did you mean to use a double instead of a long?").toString());
        }
        valueOf = String.valueOf(obj.getClass().getName());
        throw new DatabaseException(new StringBuilder(String.valueOf(valueOf).length() + 42).append("Failed to convert a value of type ").append(valueOf).append(" to long").toString());
    }

    private static Double zzaB(Object obj) {
        if (obj instanceof Integer) {
            return Double.valueOf(((Integer) obj).doubleValue());
        }
        String valueOf;
        if (obj instanceof Long) {
            Long l = (Long) obj;
            Double valueOf2 = Double.valueOf(((Long) obj).doubleValue());
            if (valueOf2.longValue() == l.longValue()) {
                return valueOf2;
            }
            valueOf = String.valueOf(obj);
            throw new DatabaseException(new StringBuilder(String.valueOf(valueOf).length() + 97).append("Loss of precision while converting number to double: ").append(valueOf).append(". Did you mean to use a 64-bit long instead?").toString());
        } else if (obj instanceof Double) {
            return (Double) obj;
        } else {
            valueOf = String.valueOf(obj.getClass().getName());
            throw new DatabaseException(new StringBuilder(String.valueOf(valueOf).length() + 44).append("Failed to convert a value of type ").append(valueOf).append(" to double").toString());
        }
    }

    private static Boolean zzaC(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        String valueOf = String.valueOf(obj.getClass().getName());
        throw new DatabaseException(new StringBuilder(String.valueOf(valueOf).length() + 43).append("Failed to convert value of type ").append(valueOf).append(" to boolean").toString());
    }

    private static String zzaD(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        String valueOf = String.valueOf(obj.getClass().getName());
        throw new DatabaseException(new StringBuilder(String.valueOf(valueOf).length() + 42).append("Failed to convert value of type ").append(valueOf).append(" to String").toString());
    }

    public static Map<String, Object> zzaF(Map<String, Object> map) {
        Object zzax = zzax(map);
        zzbqg.zzaW(zzax instanceof Map);
        return (Map) zzax;
    }

    public static Object zzaw(Object obj) {
        return zzax(obj);
    }

    private static <T> Object zzax(T t) {
        if (t == null) {
            return null;
        }
        if (t instanceof Number) {
            if (t instanceof Float) {
                return Double.valueOf(((Float) t).doubleValue());
            }
            if (t instanceof Short) {
                throw new DatabaseException("Shorts are not supported, please use int or long");
            } else if (!(t instanceof Byte)) {
                return t;
            } else {
                throw new DatabaseException("Bytes are not supported, please use int or long");
            }
        } else if ((t instanceof String) || (t instanceof Boolean)) {
            return t;
        } else {
            if (t instanceof Character) {
                throw new DatabaseException("Characters are not supported, please strings");
            } else if (t instanceof Map) {
                Map hashMap = new HashMap();
                for (Entry entry : ((Map) t).entrySet()) {
                    Object key = entry.getKey();
                    if (key instanceof String) {
                        hashMap.put((String) key, zzax(entry.getValue()));
                    } else {
                        throw new DatabaseException("Maps with non-string keys are not supported");
                    }
                }
                return hashMap;
            } else if (t instanceof Collection) {
                if (t instanceof List) {
                    List<Object> list = (List) t;
                    List arrayList = new ArrayList(list.size());
                    for (Object zzax : list) {
                        arrayList.add(zzax(zzax));
                    }
                    return arrayList;
                }
                throw new DatabaseException("Serializing Collections is not supported, please use Lists instead");
            } else if (!t.getClass().isArray()) {
                return t instanceof Enum ? ((Enum) t).name() : zzi(t.getClass()).zzaF(t);
            } else {
                throw new DatabaseException("Serializing Arrays is not supported, please use Lists instead");
            }
        }
    }

    private static Map<String, Object> zzay(Object obj) {
        if (obj instanceof Map) {
            return (Map) obj;
        }
        String valueOf = String.valueOf(obj.getClass());
        throw new DatabaseException(new StringBuilder(String.valueOf(valueOf).length() + 46).append("Expected a Map while deserializing, but got a ").append(valueOf).toString());
    }

    private static Integer zzaz(Object obj) {
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            double doubleValue = ((Number) obj).doubleValue();
            if (doubleValue >= -2.147483648E9d && doubleValue <= 2.147483647E9d) {
                return Integer.valueOf(((Number) obj).intValue());
            }
            throw new DatabaseException(new StringBuilder(MetadataChangeSet.CUSTOM_PROPERTY_SIZE_LIMIT_BYTES).append("Numeric value out of 32-bit integer range: ").append(doubleValue).append(". Did you mean to use a long or double instead of an int?").toString());
        }
        String valueOf = String.valueOf(obj.getClass().getName());
        throw new DatabaseException(new StringBuilder(String.valueOf(valueOf).length() + 41).append("Failed to convert a value of type ").append(valueOf).append(" to int").toString());
    }

    private static <T> T zzb(Object obj, Class<T> cls) {
        if (obj == null) {
            return null;
        }
        if (cls.isPrimitive() || Number.class.isAssignableFrom(cls) || Boolean.class.isAssignableFrom(cls) || Character.class.isAssignableFrom(cls)) {
            return zzc(obj, cls);
        }
        if (String.class.isAssignableFrom(cls)) {
            return zzaD(obj);
        }
        if (cls.isArray()) {
            throw new DatabaseException("Converting to Arrays is not supported, please use Listsinstead");
        } else if (cls.getTypeParameters().length <= 0) {
            return !cls.equals(Object.class) ? cls.isEnum() ? zzd(obj, cls) : zze(obj, cls) : obj;
        } else {
            String valueOf = String.valueOf(cls.getName());
            throw new DatabaseException(new StringBuilder(String.valueOf(valueOf).length() + 75).append("Class ").append(valueOf).append(" has generic type parameters, please use GenericTypeIndicator instead").toString());
        }
    }

    private static <T> T zzc(Object obj, Class<T> cls) {
        if (Integer.class.isAssignableFrom(cls) || Integer.TYPE.isAssignableFrom(cls)) {
            return zzaz(obj);
        }
        if (Boolean.class.isAssignableFrom(cls) || Boolean.TYPE.isAssignableFrom(cls)) {
            return zzaC(obj);
        }
        if (Double.class.isAssignableFrom(cls) || Double.TYPE.isAssignableFrom(cls)) {
            return zzaB(obj);
        }
        if (Long.class.isAssignableFrom(cls) || Long.TYPE.isAssignableFrom(cls)) {
            return zzaA(obj);
        }
        if (Float.class.isAssignableFrom(cls) || Float.TYPE.isAssignableFrom(cls)) {
            return Float.valueOf(zzaB(obj).floatValue());
        }
        if (Short.class.isAssignableFrom(cls) || Short.TYPE.isAssignableFrom(cls)) {
            throw new DatabaseException("Deserializing to shorts is not supported");
        } else if (Byte.class.isAssignableFrom(cls) || Byte.TYPE.isAssignableFrom(cls)) {
            throw new DatabaseException("Deserializing to bytes is not supported");
        } else if (Character.class.isAssignableFrom(cls) || Character.TYPE.isAssignableFrom(cls)) {
            throw new DatabaseException("Deserializing to char is not supported");
        } else {
            String valueOf = String.valueOf(cls);
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 24).append("Unknown primitive type: ").append(valueOf).toString());
        }
    }

    private static <T> T zzd(Object obj, Class<T> cls) {
        if (obj instanceof String) {
            String str = (String) obj;
            try {
                return Enum.valueOf(cls, str);
            } catch (IllegalArgumentException e) {
                String valueOf = String.valueOf(cls.getName());
                throw new DatabaseException(new StringBuilder((String.valueOf(valueOf).length() + 42) + String.valueOf(str).length()).append("Could not find enum value of ").append(valueOf).append(" for value \"").append(str).append("\"").toString());
            }
        }
        valueOf = String.valueOf(cls);
        String valueOf2 = String.valueOf(obj.getClass());
        throw new DatabaseException(new StringBuilder((String.valueOf(valueOf).length() + 57) + String.valueOf(valueOf2).length()).append("Expected a String while deserializing to enum ").append(valueOf).append(" but got a ").append(valueOf2).toString());
    }

    private static <T> T zze(Object obj, Class<T> cls) {
        zza zzi = zzi(cls);
        if (obj instanceof Map) {
            return zzi.zzaG(zzay(obj));
        }
        String valueOf = String.valueOf(obj.getClass().getName());
        String valueOf2 = String.valueOf(cls.getName());
        throw new DatabaseException(new StringBuilder((String.valueOf(valueOf).length() + 38) + String.valueOf(valueOf2).length()).append("Can't convert object of type ").append(valueOf).append(" to type ").append(valueOf2).toString());
    }

    private static <T> zza<T> zzi(Class<T> cls) {
        zza<T> com_google_android_gms_internal_zzbqi_zza_T = (zza) zzciE.get(cls);
        if (com_google_android_gms_internal_zzbqi_zza_T != null) {
            return com_google_android_gms_internal_zzbqi_zza_T;
        }
        com_google_android_gms_internal_zzbqi_zza_T = new zza(cls);
        zzciE.put(cls, com_google_android_gms_internal_zzbqi_zza_T);
        return com_google_android_gms_internal_zzbqi_zza_T;
    }
}
