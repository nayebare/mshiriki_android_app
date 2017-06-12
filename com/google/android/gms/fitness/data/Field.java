package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v7.mediarouter.C0308R;
import com.google.ads.AdSize;
import com.google.android.gms.C0473R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import org.apache.http.protocol.HTTP;

public final class Field extends com.google.android.gms.common.internal.safeparcel.zza {
    public static final Creator<Field> CREATOR;
    public static final Field FIELD_ACCURACY;
    public static final Field FIELD_ACTIVITY;
    public static final Field FIELD_ACTIVITY_CONFIDENCE;
    public static final Field FIELD_ALTITUDE;
    public static final Field FIELD_AVERAGE;
    public static final Field FIELD_BPM;
    public static final Field FIELD_CALORIES;
    public static final Field FIELD_CIRCUMFERENCE;
    public static final Field FIELD_CONFIDENCE;
    public static final Field FIELD_DISTANCE;
    public static final Field FIELD_DURATION;
    public static final Field FIELD_EXERCISE;
    public static final Field FIELD_FOOD_ITEM;
    public static final Field FIELD_HEIGHT;
    public static final Field FIELD_HIGH_LATITUDE;
    public static final Field FIELD_HIGH_LONGITUDE;
    public static final Field FIELD_LATITUDE;
    public static final Field FIELD_LONGITUDE;
    public static final Field FIELD_LOW_LATITUDE;
    public static final Field FIELD_LOW_LONGITUDE;
    public static final Field FIELD_MAX;
    public static final Field FIELD_MEAL_TYPE;
    public static final Field FIELD_MIN;
    public static final Field FIELD_NUM_SEGMENTS;
    public static final Field FIELD_NUTRIENTS;
    public static final Field FIELD_PERCENTAGE;
    public static final Field FIELD_REPETITIONS;
    public static final Field FIELD_RESISTANCE;
    public static final Field FIELD_RESISTANCE_TYPE;
    public static final Field FIELD_REVOLUTIONS;
    public static final Field FIELD_RPM;
    public static final Field FIELD_SPEED;
    public static final Field FIELD_STEPS;
    public static final Field FIELD_VOLUME;
    public static final Field FIELD_WATTS;
    public static final Field FIELD_WEIGHT;
    public static final int FORMAT_FLOAT = 2;
    public static final int FORMAT_INT32 = 1;
    public static final int FORMAT_MAP = 4;
    public static final int FORMAT_STRING = 3;
    public static final int MEAL_TYPE_BREAKFAST = 1;
    public static final int MEAL_TYPE_DINNER = 3;
    public static final int MEAL_TYPE_LUNCH = 2;
    public static final int MEAL_TYPE_SNACK = 4;
    public static final int MEAL_TYPE_UNKNOWN = 0;
    public static final String NUTRIENT_CALCIUM = "calcium";
    public static final String NUTRIENT_CALORIES = "calories";
    public static final String NUTRIENT_CHOLESTEROL = "cholesterol";
    public static final String NUTRIENT_DIETARY_FIBER = "dietary_fiber";
    public static final String NUTRIENT_IRON = "iron";
    public static final String NUTRIENT_MONOUNSATURATED_FAT = "fat.monounsaturated";
    public static final String NUTRIENT_POLYUNSATURATED_FAT = "fat.polyunsaturated";
    public static final String NUTRIENT_POTASSIUM = "potassium";
    public static final String NUTRIENT_PROTEIN = "protein";
    public static final String NUTRIENT_SATURATED_FAT = "fat.saturated";
    public static final String NUTRIENT_SODIUM = "sodium";
    public static final String NUTRIENT_SUGAR = "sugar";
    public static final String NUTRIENT_TOTAL_CARBS = "carbs.total";
    public static final String NUTRIENT_TOTAL_FAT = "fat.total";
    public static final String NUTRIENT_TRANS_FAT = "fat.trans";
    public static final String NUTRIENT_UNSATURATED_FAT = "fat.unsaturated";
    public static final String NUTRIENT_VITAMIN_A = "vitamin_a";
    public static final String NUTRIENT_VITAMIN_C = "vitamin_c";
    public static final int RESISTANCE_TYPE_BARBELL = 1;
    public static final int RESISTANCE_TYPE_BODY = 6;
    public static final int RESISTANCE_TYPE_CABLE = 2;
    public static final int RESISTANCE_TYPE_DUMBBELL = 3;
    public static final int RESISTANCE_TYPE_KETTLEBELL = 4;
    public static final int RESISTANCE_TYPE_MACHINE = 5;
    public static final int RESISTANCE_TYPE_UNKNOWN = 0;
    public static final Field zzaRP;
    public static final Field zzaRQ;
    public static final Field zzaRR;
    public static final Field zzaRS;
    public static final Field zzaRT;
    public static final Field zzaRU;
    public static final Field zzaRV;
    public static final Field zzaRW;
    public static final Field zzaRX;
    public static final Field zzaRY;
    public static final Field zzaRZ;
    public static final Field zzaSa;
    public static final Field zzaSb;
    public static final Field zzaSc;
    public static final Field zzaSd;
    public static final Field zzaSe;
    public static final Field zzaSf;
    public static final Field zzaSg;
    public static final Field zzaSh;
    private final int format;
    private final String name;
    private final int versionCode;
    private final Boolean zzaSi;

    public static class zza {
        public static final Field zzaSj;
        public static final Field zzaSk;
        public static final Field zzaSl;
        public static final Field zzaSm;
        public static final Field zzaSn;

        static {
            zzaSj = Field.zzef("x");
            zzaSk = Field.zzef("y");
            zzaSl = Field.zzef("z");
            zzaSm = Field.zzem("debug_session");
            zzaSn = Field.zzem("google.android.fitness.SessionV2");
        }
    }

    static {
        FIELD_ACTIVITY = zzed("activity");
        FIELD_CONFIDENCE = zzef("confidence");
        FIELD_ACTIVITY_CONFIDENCE = zzei("activity_confidence");
        FIELD_STEPS = zzed("steps");
        FIELD_DURATION = zzed("duration");
        zzaRP = zzee("duration");
        zzaRQ = zzei("activity_duration");
        zzaRR = zzei("activity_duration.ascending");
        zzaRS = zzei("activity_duration.descending");
        FIELD_BPM = zzef("bpm");
        FIELD_LATITUDE = zzef("latitude");
        FIELD_LONGITUDE = zzef("longitude");
        FIELD_ACCURACY = zzef("accuracy");
        FIELD_ALTITUDE = zzeg("altitude");
        FIELD_DISTANCE = zzef("distance");
        FIELD_HEIGHT = zzef("height");
        FIELD_WEIGHT = zzef("weight");
        FIELD_CIRCUMFERENCE = zzef("circumference");
        FIELD_PERCENTAGE = zzef("percentage");
        FIELD_SPEED = zzef("speed");
        FIELD_RPM = zzef("rpm");
        zzaRT = zzel("google.android.fitness.StrideModel");
        FIELD_REVOLUTIONS = zzed("revolutions");
        FIELD_CALORIES = zzef(NUTRIENT_CALORIES);
        FIELD_WATTS = zzef("watts");
        FIELD_VOLUME = zzef(MediaRouteProviderProtocol.CLIENT_DATA_VOLUME);
        FIELD_MEAL_TYPE = zzed("meal_type");
        FIELD_FOOD_ITEM = zzeh("food_item");
        FIELD_NUTRIENTS = zzei("nutrients");
        zzaRU = zzef("elevation.change");
        zzaRV = zzei("elevation.gain");
        zzaRW = zzei("elevation.loss");
        zzaRX = zzef("floors");
        zzaRY = zzei("floor.gain");
        zzaRZ = zzei("floor.loss");
        FIELD_EXERCISE = zzeh("exercise");
        FIELD_REPETITIONS = zzed("repetitions");
        FIELD_RESISTANCE = zzef("resistance");
        FIELD_RESISTANCE_TYPE = zzed("resistance_type");
        FIELD_NUM_SEGMENTS = zzed("num_segments");
        FIELD_AVERAGE = zzef("average");
        FIELD_MAX = zzef("max");
        FIELD_MIN = zzef("min");
        FIELD_LOW_LATITUDE = zzef("low_latitude");
        FIELD_LOW_LONGITUDE = zzef("low_longitude");
        FIELD_HIGH_LATITUDE = zzef("high_latitude");
        FIELD_HIGH_LONGITUDE = zzef("high_longitude");
        zzaSa = zzed("occurrences");
        zzaSb = zzed("sensor_type");
        zzaSc = zzed("sensor_types");
        zzaSd = zzej("timestamps");
        zzaSe = zzed("sample_period");
        zzaSf = zzed("num_samples");
        zzaSg = zzed("num_dimensions");
        zzaSh = zzek("sensor_values");
        CREATOR = new zzp();
    }

    Field(int i, String str, int i2, Boolean bool) {
        this.versionCode = i;
        this.name = (String) zzac.zzw(str);
        this.format = i2;
        this.zzaSi = bool;
    }

    private Field(String str, int i) {
        this(RESISTANCE_TYPE_CABLE, str, i, null);
    }

    private Field(String str, int i, Boolean bool) {
        this(RESISTANCE_TYPE_CABLE, str, i, bool);
    }

    public static Field zza(String str, int i, Boolean bool) {
        Object obj = -1;
        switch (str.hashCode()) {
            case -2131707655:
                if (str.equals("accuracy")) {
                    obj = null;
                    break;
                }
                break;
            case -2083865430:
                if (str.equals("debug_session")) {
                    obj = 91;
                    break;
                }
                break;
            case -2006370880:
                if (str.equals("body_temperature_measurement_location")) {
                    obj = 21;
                    break;
                }
                break;
            case -1992012396:
                if (str.equals("duration")) {
                    obj = 32;
                    break;
                }
                break;
            case -1859447186:
                if (str.equals("blood_glucose_level")) {
                    obj = 8;
                    break;
                }
                break;
            case -1655966961:
                if (str.equals("activity")) {
                    obj = RESISTANCE_TYPE_BARBELL;
                    break;
                }
                break;
            case -1595712862:
                if (str.equals("cervical_dilation")) {
                    obj = 24;
                    break;
                }
                break;
            case -1579612127:
                if (str.equals("floor.gain")) {
                    obj = 37;
                    break;
                }
                break;
            case -1579449403:
                if (str.equals("floor.loss")) {
                    obj = 38;
                    break;
                }
                break;
            case -1569430471:
                if (str.equals("num_segments")) {
                    obj = 54;
                    break;
                }
                break;
            case -1531570079:
                if (str.equals("elevation.change")) {
                    obj = 33;
                    break;
                }
                break;
            case -1440707631:
                if (str.equals("oxygen_saturation")) {
                    obj = 58;
                    break;
                }
                break;
            case -1439978388:
                if (str.equals("latitude")) {
                    obj = 44;
                    break;
                }
                break;
            case -1352492506:
                if (str.equals("num_dimensions")) {
                    obj = 52;
                    break;
                }
                break;
            case -1271636505:
                if (str.equals("floors")) {
                    obj = 39;
                    break;
                }
                break;
            case -1248595573:
                if (str.equals("supplemental_oxygen_flow_rate_average")) {
                    obj = 71;
                    break;
                }
                break;
            case -1221029593:
                if (str.equals("height")) {
                    obj = 41;
                    break;
                }
                break;
            case -1220952307:
                if (str.equals("blood_pressure_measurement_location")) {
                    obj = 14;
                    break;
                }
                break;
            case -1133736764:
                if (str.equals("activity_duration")) {
                    obj = RESISTANCE_TYPE_DUMBBELL;
                    break;
                }
                break;
            case -1129337776:
                if (str.equals("num_samples")) {
                    obj = 53;
                    break;
                }
                break;
            case -1110756780:
                if (str.equals("food_item")) {
                    obj = 40;
                    break;
                }
                break;
            case -921832806:
                if (str.equals("percentage")) {
                    obj = 74;
                    break;
                }
                break;
            case -918978307:
                if (str.equals("cervical_position")) {
                    obj = 28;
                    break;
                }
                break;
            case -810883302:
                if (str.equals(MediaRouteProviderProtocol.CLIENT_DATA_VOLUME)) {
                    obj = 85;
                    break;
                }
                break;
            case -803244749:
                if (str.equals("blood_pressure_systolic")) {
                    obj = 15;
                    break;
                }
                break;
            case -791592328:
                if (str.equals("weight")) {
                    obj = 87;
                    break;
                }
                break;
            case -631448035:
                if (str.equals("average")) {
                    obj = 7;
                    break;
                }
                break;
            case -626344110:
                if (str.equals("high_longitude")) {
                    obj = 43;
                    break;
                }
                break;
            case -619868540:
                if (str.equals("low_longitude")) {
                    obj = 47;
                    break;
                }
                break;
            case -511934137:
                if (str.equals("sensor_values")) {
                    obj = 69;
                    break;
                }
                break;
            case -494782871:
                if (str.equals("high_latitude")) {
                    obj = 42;
                    break;
                }
                break;
            case -437053898:
                if (str.equals("meal_type")) {
                    obj = 49;
                    break;
                }
                break;
            case -277306353:
                if (str.equals("circumference")) {
                    obj = 29;
                    break;
                }
                break;
            case -266093204:
                if (str.equals("nutrients")) {
                    obj = 55;
                    break;
                }
                break;
            case -228366862:
                if (str.equals("oxygen_saturation_measurement_method")) {
                    obj = 61;
                    break;
                }
                break;
            case -168965370:
                if (str.equals(NUTRIENT_CALORIES)) {
                    obj = 23;
                    break;
                }
                break;
            case -126538880:
                if (str.equals("resistance_type")) {
                    obj = 77;
                    break;
                }
                break;
            case -28590302:
                if (str.equals("ovulation_test_result")) {
                    obj = 57;
                    break;
                }
                break;
            case 120:
                if (str.equals("x")) {
                    obj = 88;
                    break;
                }
                break;
            case 121:
                if (str.equals("y")) {
                    obj = 89;
                    break;
                }
                break;
            case 122:
                if (str.equals("z")) {
                    obj = 90;
                    break;
                }
                break;
            case 97759:
                if (str.equals("bpm")) {
                    obj = 22;
                    break;
                }
                break;
            case 107876:
                if (str.equals("max")) {
                    obj = 48;
                    break;
                }
                break;
            case 108114:
                if (str.equals("min")) {
                    obj = 51;
                    break;
                }
                break;
            case 113135:
                if (str.equals("rpm")) {
                    obj = 79;
                    break;
                }
                break;
            case 66639641:
                if (str.equals("temporal_relation_to_sleep")) {
                    obj = 84;
                    break;
                }
                break;
            case 109641799:
                if (str.equals("speed")) {
                    obj = 80;
                    break;
                }
                break;
            case 109761319:
                if (str.equals("steps")) {
                    obj = 81;
                    break;
                }
                break;
            case 112903913:
                if (str.equals("watts")) {
                    obj = 86;
                    break;
                }
                break;
            case 120904628:
                if (str.equals("sensor_types")) {
                    obj = 68;
                    break;
                }
                break;
            case 137365935:
                if (str.equals("longitude")) {
                    obj = 45;
                    break;
                }
                break;
            case 198162679:
                if (str.equals("low_latitude")) {
                    obj = 46;
                    break;
                }
                break;
            case 220648413:
                if (str.equals("blood_pressure_diastolic_average")) {
                    obj = 11;
                    break;
                }
                break;
            case 248891292:
                if (str.equals("blood_glucose_specimen_source")) {
                    obj = 9;
                    break;
                }
                break;
            case 286612066:
                if (str.equals("activity_duration.descending")) {
                    obj = RESISTANCE_TYPE_MACHINE;
                    break;
                }
                break;
            case 288459765:
                if (str.equals("distance")) {
                    obj = 31;
                    break;
                }
                break;
            case 306600408:
                if (str.equals("google.android.fitness.SessionV2")) {
                    obj = 92;
                    break;
                }
                break;
            case 320627489:
                if (str.equals("cervical_mucus_texture")) {
                    obj = 27;
                    break;
                }
                break;
            case 455965230:
                if (str.equals("activity_duration.ascending")) {
                    obj = RESISTANCE_TYPE_KETTLEBELL;
                    break;
                }
                break;
            case 475560024:
                if (str.equals("blood_pressure_systolic_max")) {
                    obj = 17;
                    break;
                }
                break;
            case 475560262:
                if (str.equals("blood_pressure_systolic_min")) {
                    obj = 18;
                    break;
                }
                break;
            case 581888402:
                if (str.equals("cervical_mucus_amount")) {
                    obj = 26;
                    break;
                }
                break;
            case 623947695:
                if (str.equals("oxygen_saturation_average")) {
                    obj = 59;
                    break;
                }
                break;
            case 738210934:
                if (str.equals("google.android.fitness.StrideModel")) {
                    obj = 82;
                    break;
                }
                break;
            case 784486594:
                if (str.equals("occurrences")) {
                    obj = 56;
                    break;
                }
                break;
            case 811264586:
                if (str.equals("revolutions")) {
                    obj = 78;
                    break;
                }
                break;
            case 815736413:
                if (str.equals("oxygen_saturation_system")) {
                    obj = 63;
                    break;
                }
                break;
            case 829251210:
                if (str.equals("confidence")) {
                    obj = 30;
                    break;
                }
                break;
            case 833248065:
                if (str.equals("temporal_relation_to_meal")) {
                    obj = 83;
                    break;
                }
                break;
            case 883161687:
                if (str.equals("body_temperature")) {
                    obj = 20;
                    break;
                }
                break;
            case 984367650:
                if (str.equals("repetitions")) {
                    obj = 75;
                    break;
                }
                break;
            case 998412730:
                if (str.equals("activity_confidence")) {
                    obj = RESISTANCE_TYPE_CABLE;
                    break;
                }
                break;
            case 1136011766:
                if (str.equals("sample_period")) {
                    obj = 66;
                    break;
                }
                break;
            case 1276952063:
                if (str.equals("blood_pressure_diastolic")) {
                    obj = 10;
                    break;
                }
                break;
            case 1284575222:
                if (str.equals("oxygen_saturation_max")) {
                    obj = 60;
                    break;
                }
                break;
            case 1284575460:
                if (str.equals("oxygen_saturation_min")) {
                    obj = 62;
                    break;
                }
                break;
            case 1403812644:
                if (str.equals("blood_pressure_diastolic_max")) {
                    obj = 12;
                    break;
                }
                break;
            case 1403812882:
                if (str.equals("blood_pressure_diastolic_min")) {
                    obj = 13;
                    break;
                }
                break;
            case 1527920799:
                if (str.equals("sensor_type")) {
                    obj = 67;
                    break;
                }
                break;
            case 1708915229:
                if (str.equals("timestamps")) {
                    obj = 65;
                    break;
                }
                break;
            case 1857734768:
                if (str.equals("elevation.gain")) {
                    obj = 34;
                    break;
                }
                break;
            case 1857897492:
                if (str.equals("elevation.loss")) {
                    obj = 35;
                    break;
                }
                break;
            case 1863800889:
                if (str.equals("resistance")) {
                    obj = 76;
                    break;
                }
                break;
            case 1880897007:
                if (str.equals("oxygen_therapy_administration_mode")) {
                    obj = 64;
                    break;
                }
                break;
            case 1892583496:
                if (str.equals("menstrual_flow")) {
                    obj = 50;
                    break;
                }
                break;
            case 1958191058:
                if (str.equals("supplemental_oxygen_flow_rate_max")) {
                    obj = 72;
                    break;
                }
                break;
            case 1958191296:
                if (str.equals("supplemental_oxygen_flow_rate_min")) {
                    obj = 73;
                    break;
                }
                break;
            case 1983072038:
                if (str.equals("body_position")) {
                    obj = 19;
                    break;
                }
                break;
            case 2020153105:
                if (str.equals("blood_pressure_systolic_average")) {
                    obj = 16;
                    break;
                }
                break;
            case 2036550306:
                if (str.equals("altitude")) {
                    obj = RESISTANCE_TYPE_BODY;
                    break;
                }
                break;
            case 2056323544:
                if (str.equals("exercise")) {
                    obj = 36;
                    break;
                }
                break;
            case 2072582505:
                if (str.equals("cervical_firmness")) {
                    obj = 25;
                    break;
                }
                break;
            case 2078370221:
                if (str.equals("supplemental_oxygen_flow_rate")) {
                    obj = 70;
                    break;
                }
                break;
        }
        switch (obj) {
            case MEAL_TYPE_UNKNOWN /*0*/:
                return FIELD_ACCURACY;
            case RESISTANCE_TYPE_BARBELL /*1*/:
                return FIELD_ACTIVITY;
            case RESISTANCE_TYPE_CABLE /*2*/:
                return FIELD_ACTIVITY_CONFIDENCE;
            case RESISTANCE_TYPE_DUMBBELL /*3*/:
                return zzaRQ;
            case RESISTANCE_TYPE_KETTLEBELL /*4*/:
                return zzaRR;
            case RESISTANCE_TYPE_MACHINE /*5*/:
                return zzaRS;
            case RESISTANCE_TYPE_BODY /*6*/:
                return FIELD_ALTITUDE;
            case BuyButtonText.DONATE_WITH /*7*/:
                return FIELD_AVERAGE;
            case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                return zzt.zzaSZ;
            case HTTP.HT /*9*/:
                return zzt.zzaTc;
            case HTTP.LF /*10*/:
                return zzt.zzaST;
            case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                return zzt.zzaSU;
            case C0473R.styleable.MapAttrs_uiZoomGestures /*12*/:
                return zzt.zzaSW;
            case HTTP.CR /*13*/:
                return zzt.zzaSV;
            case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                return zzt.zzaSY;
            case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                return zzt.zzaSP;
            case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                return zzt.zzaSQ;
            case ConnectionResult.SIGN_IN_FAILED /*17*/:
                return zzt.zzaSS;
            case ConnectionResult.SERVICE_UPDATING /*18*/:
                return zzt.zzaSR;
            case ConnectionResult.SERVICE_MISSING_PERMISSION /*19*/:
                return zzt.zzaSX;
            case ConnectionResult.RESTRICTED_PROFILE /*20*/:
                return zzt.zzaTo;
            case C0473R.styleable.MapAttrs_latLngBoundsNorthEastLatitude /*21*/:
                return zzt.zzaTp;
            case C0473R.styleable.MapAttrs_latLngBoundsNorthEastLongitude /*22*/:
                return FIELD_BPM;
            case C0308R.styleable.Toolbar_collapseContentDescription /*23*/:
                return FIELD_CALORIES;
            case C0308R.styleable.Toolbar_navigationIcon /*24*/:
                return zzt.zzaTt;
            case C0308R.styleable.Toolbar_navigationContentDescription /*25*/:
                return zzt.zzaTu;
            case C0308R.styleable.Toolbar_logoDescription /*26*/:
                return zzt.zzaTr;
            case C0308R.styleable.Toolbar_titleTextColor /*27*/:
                return zzt.zzaTq;
            case C0308R.styleable.Toolbar_subtitleTextColor /*28*/:
                return zzt.zzaTs;
            case C0308R.styleable.AppCompatTheme_actionModeBackground /*29*/:
                return FIELD_CIRCUMFERENCE;
            case MetadataChangeSet.MAX_PUBLIC_PROPERTIES_PER_RESOURCE /*30*/:
                return FIELD_CONFIDENCE;
            case C0308R.styleable.AppCompatTheme_actionModeCloseDrawable /*31*/:
                return FIELD_DISTANCE;
            case HTTP.SP /*32*/:
                return (bool == null || !bool.booleanValue()) ? FIELD_DURATION : zzaRP;
            case C0308R.styleable.AppCompatTheme_actionModeCopyDrawable /*33*/:
                return zzaRU;
            case C0308R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                return zzaRV;
            case C0308R.styleable.AppCompatTheme_actionModeSelectAllDrawable /*35*/:
                return zzaRW;
            case C0308R.styleable.AppCompatTheme_actionModeShareDrawable /*36*/:
                return FIELD_EXERCISE;
            case C0308R.styleable.AppCompatTheme_actionModeFindDrawable /*37*/:
                return zzaRY;
            case C0308R.styleable.AppCompatTheme_actionModeWebSearchDrawable /*38*/:
                return zzaRZ;
            case C0308R.styleable.AppCompatTheme_actionModePopupWindowStyle /*39*/:
                return zzaRX;
            case C0308R.styleable.AppCompatTheme_textAppearanceLargePopupMenu /*40*/:
                return FIELD_FOOD_ITEM;
            case C0308R.styleable.AppCompatTheme_textAppearanceSmallPopupMenu /*41*/:
                return FIELD_HEIGHT;
            case C0308R.styleable.AppCompatTheme_textAppearancePopupMenuHeader /*42*/:
                return FIELD_HIGH_LATITUDE;
            case C0308R.styleable.AppCompatTheme_dialogTheme /*43*/:
                return FIELD_HIGH_LONGITUDE;
            case C0308R.styleable.AppCompatTheme_dialogPreferredPadding /*44*/:
                return FIELD_LATITUDE;
            case C0308R.styleable.AppCompatTheme_listDividerAlertDialog /*45*/:
                return FIELD_LONGITUDE;
            case C0308R.styleable.AppCompatTheme_actionDropDownStyle /*46*/:
                return FIELD_LOW_LATITUDE;
            case C0308R.styleable.AppCompatTheme_dropdownListPreferredItemHeight /*47*/:
                return FIELD_LOW_LONGITUDE;
            case C0308R.styleable.AppCompatTheme_spinnerDropDownItemStyle /*48*/:
                return FIELD_MAX;
            case C0308R.styleable.AppCompatTheme_homeAsUpIndicator /*49*/:
                return FIELD_MEAL_TYPE;
            case AdSize.PORTRAIT_AD_HEIGHT /*50*/:
                return zzt.zzaTv;
            case C0308R.styleable.AppCompatTheme_buttonBarStyle /*51*/:
                return FIELD_MIN;
            case C0308R.styleable.AppCompatTheme_buttonBarButtonStyle /*52*/:
                return zzaSg;
            case C0308R.styleable.AppCompatTheme_selectableItemBackground /*53*/:
                return zzaSf;
            case C0308R.styleable.AppCompatTheme_selectableItemBackgroundBorderless /*54*/:
                return FIELD_NUM_SEGMENTS;
            case C0308R.styleable.AppCompatTheme_borderlessButtonStyle /*55*/:
                return FIELD_NUTRIENTS;
            case C0308R.styleable.AppCompatTheme_dividerVertical /*56*/:
                return zzaSa;
            case C0308R.styleable.AppCompatTheme_dividerHorizontal /*57*/:
                return zzt.zzaTw;
            case C0308R.styleable.AppCompatTheme_activityChooserViewStyle /*58*/:
                return zzt.zzaTd;
            case C0308R.styleable.AppCompatTheme_toolbarStyle /*59*/:
                return zzt.zzaTe;
            case C0308R.styleable.AppCompatTheme_toolbarNavigationButtonStyle /*60*/:
                return zzt.zzaTg;
            case C0308R.styleable.AppCompatTheme_popupMenuStyle /*61*/:
                return zzt.zzaTn;
            case C0308R.styleable.AppCompatTheme_popupWindowStyle /*62*/:
                return zzt.zzaTf;
            case Notifications.NOTIFICATION_TYPES_ALL /*63*/:
                return zzt.zzaTm;
            case C0308R.styleable.AppCompatTheme_editTextBackground /*64*/:
                return zzt.zzaTl;
            case C0308R.styleable.AppCompatTheme_imageButtonStyle /*65*/:
                return zzaSd;
            case C0308R.styleable.AppCompatTheme_textAppearanceSearchResultTitle /*66*/:
                return zzaSe;
            case C0308R.styleable.AppCompatTheme_textAppearanceSearchResultSubtitle /*67*/:
                return zzaSb;
            case C0308R.styleable.AppCompatTheme_textColorSearchUrl /*68*/:
                return zzaSc;
            case C0308R.styleable.AppCompatTheme_searchViewStyle /*69*/:
                return zzaSh;
            case C0308R.styleable.AppCompatTheme_listPreferredItemHeight /*70*/:
                return zzt.zzaTh;
            case C0308R.styleable.AppCompatTheme_listPreferredItemHeightSmall /*71*/:
                return zzt.zzaTi;
            case C0308R.styleable.AppCompatTheme_listPreferredItemHeightLarge /*72*/:
                return zzt.zzaTk;
            case C0308R.styleable.AppCompatTheme_listPreferredItemPaddingLeft /*73*/:
                return zzt.zzaTj;
            case C0308R.styleable.AppCompatTheme_listPreferredItemPaddingRight /*74*/:
                return FIELD_PERCENTAGE;
            case C0308R.styleable.AppCompatTheme_dropDownListViewStyle /*75*/:
                return FIELD_REPETITIONS;
            case C0308R.styleable.AppCompatTheme_listPopupWindowStyle /*76*/:
                return FIELD_RESISTANCE;
            case C0308R.styleable.AppCompatTheme_textAppearanceListItem /*77*/:
                return FIELD_RESISTANCE_TYPE;
            case C0308R.styleable.AppCompatTheme_textAppearanceListItemSmall /*78*/:
                return FIELD_REVOLUTIONS;
            case C0308R.styleable.AppCompatTheme_panelBackground /*79*/:
                return FIELD_RPM;
            case C0308R.styleable.AppCompatTheme_panelMenuListWidth /*80*/:
                return FIELD_SPEED;
            case C0308R.styleable.AppCompatTheme_panelMenuListTheme /*81*/:
                return FIELD_STEPS;
            case C0308R.styleable.AppCompatTheme_listChoiceBackgroundIndicator /*82*/:
                return zzaRT;
            case C0308R.styleable.AppCompatTheme_colorPrimary /*83*/:
                return zzt.zzaTa;
            case C0308R.styleable.AppCompatTheme_colorPrimaryDark /*84*/:
                return zzt.zzaTb;
            case C0308R.styleable.AppCompatTheme_colorAccent /*85*/:
                return FIELD_VOLUME;
            case C0308R.styleable.AppCompatTheme_colorControlNormal /*86*/:
                return FIELD_WATTS;
            case C0308R.styleable.AppCompatTheme_colorControlActivated /*87*/:
                return FIELD_WEIGHT;
            case C0308R.styleable.AppCompatTheme_colorControlHighlight /*88*/:
                return zza.zzaSj;
            case C0308R.styleable.AppCompatTheme_colorButtonNormal /*89*/:
                return zza.zzaSk;
            case AdSize.LARGE_AD_HEIGHT /*90*/:
                return zza.zzaSl;
            case C0308R.styleable.AppCompatTheme_controlBackground /*91*/:
                return zza.zzaSm;
            case C0308R.styleable.AppCompatTheme_colorBackgroundFloating /*92*/:
                return zza.zzaSn;
            default:
                return new Field(str, i, bool);
        }
    }

    private boolean zza(Field field) {
        return this.name.equals(field.name) && this.format == field.format;
    }

    static Field zzed(String str) {
        return new Field(str, RESISTANCE_TYPE_BARBELL);
    }

    static Field zzee(String str) {
        return new Field(str, RESISTANCE_TYPE_BARBELL, Boolean.valueOf(true));
    }

    static Field zzef(String str) {
        return new Field(str, RESISTANCE_TYPE_CABLE);
    }

    static Field zzeg(String str) {
        return new Field(str, RESISTANCE_TYPE_CABLE, Boolean.valueOf(true));
    }

    static Field zzeh(String str) {
        return new Field(str, RESISTANCE_TYPE_DUMBBELL);
    }

    static Field zzei(String str) {
        return new Field(str, RESISTANCE_TYPE_KETTLEBELL);
    }

    static Field zzej(String str) {
        return new Field(str, RESISTANCE_TYPE_MACHINE);
    }

    static Field zzek(String str) {
        return new Field(str, RESISTANCE_TYPE_BODY);
    }

    static Field zzel(String str) {
        return new Field(str, 7);
    }

    static Field zzem(String str) {
        return new Field(str, 7, Boolean.valueOf(true));
    }

    public static Field zzn(String str, int i) {
        return zza(str, i, null);
    }

    public boolean equals(Object obj) {
        return this == obj ? true : (obj instanceof Field) && zza((Field) obj);
    }

    public int getFormat() {
        return this.format;
    }

    public String getName() {
        return this.name;
    }

    int getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public Boolean isOptional() {
        return this.zzaSi;
    }

    public String toString() {
        String str = "%s(%s)";
        Object[] objArr = new Object[RESISTANCE_TYPE_CABLE];
        objArr[MEAL_TYPE_UNKNOWN] = this.name;
        objArr[RESISTANCE_TYPE_BARBELL] = this.format == RESISTANCE_TYPE_BARBELL ? "i" : "f";
        return String.format(str, objArr);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzp.zza(this, parcel, i);
    }
}
