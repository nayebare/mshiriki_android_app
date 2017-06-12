package com.google.android.gms.fitness.data;

public final class zzs {
    public static final DataType zzaSA;
    public static final DataType zzaSB;
    public static final DataType zzaSC;
    public static final DataType zzaSD;
    public static final DataType zzaSE;
    public static final DataType zzaSF;
    public static final DataType zzaSG;
    public static final DataType zzaSH;
    public static final DataType zzaSI;
    public static final DataType zzaSJ;
    public static final DataType zzaSK;
    public static final DataType zzaSL;
    public static final DataType zzaSM;
    public static final DataType zzaSN;
    public static final DataType zzaSO;

    static {
        zzaSA = new DataType("com.google.blood_pressure", zzt.zzaSP, zzt.zzaST, zzt.zzaSX, zzt.zzaSY);
        zzaSB = new DataType("com.google.blood_glucose", zzt.zzaSZ, zzt.zzaTa, Field.FIELD_MEAL_TYPE, zzt.zzaTb, zzt.zzaTc);
        zzaSC = new DataType("com.google.oxygen_saturation", zzt.zzaTd, zzt.zzaTh, zzt.zzaTl, zzt.zzaTm, zzt.zzaTn);
        zzaSD = new DataType("com.google.body.temperature", zzt.zzaTo, zzt.zzaTp);
        zzaSE = new DataType("com.google.body.temperature.basal", zzt.zzaTo, zzt.zzaTp);
        zzaSF = new DataType("com.google.cervical_mucus", zzt.zzaTq, zzt.zzaTr);
        zzaSG = new DataType("com.google.cervical_position", zzt.zzaTs, zzt.zzaTt, zzt.zzaTu);
        zzaSH = new DataType("com.google.menstruation", zzt.zzaTv);
        zzaSI = new DataType("com.google.ovulation_test", zzt.zzaTw);
        zzaSJ = new DataType("com.google.vaginal_spotting", Field.zzaSa);
        zzaSK = new DataType("com.google.blood_pressure.summary", zzt.zzaSQ, zzt.zzaSS, zzt.zzaSR, zzt.zzaSU, zzt.zzaSW, zzt.zzaSV, zzt.zzaSX, zzt.zzaSY);
        zzaSL = new DataType("com.google.blood_glucose.summary", Field.FIELD_AVERAGE, Field.FIELD_MAX, Field.FIELD_MIN, zzt.zzaTa, Field.FIELD_MEAL_TYPE, zzt.zzaTb, zzt.zzaTc);
        zzaSM = new DataType("com.google.oxygen_saturation.summary", zzt.zzaTe, zzt.zzaTg, zzt.zzaTf, zzt.zzaTi, zzt.zzaTk, zzt.zzaTj, zzt.zzaTl, zzt.zzaTm, zzt.zzaTn);
        zzaSN = new DataType("com.google.body.temperature.summary", Field.FIELD_AVERAGE, Field.FIELD_MAX, Field.FIELD_MIN, zzt.zzaTp);
        zzaSO = new DataType("com.google.body.temperature.basal.summary", Field.FIELD_AVERAGE, Field.FIELD_MAX, Field.FIELD_MIN, zzt.zzaTp);
    }
}
