package com.google.android.gms.fitness.data;

import android.support.v7.mediarouter.C0308R;
import com.google.ads.AdSize;
import com.google.android.gms.C0473R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.fitness.data.DataType.zza;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import org.apache.http.protocol.HTTP;

public class zzl {
    public static final DataType[] zzaRE;
    public static final DataType[] zzaRF;

    static {
        zzaRE = new DataType[]{DataType.zzaRt, DataType.TYPE_WORKOUT_EXERCISE, DataType.TYPE_ACTIVITY_SAMPLE, DataType.TYPE_ACTIVITY_SAMPLES, DataType.TYPE_ACTIVITY_SEGMENT, DataType.AGGREGATE_ACTIVITY_SUMMARY, zzs.zzaSE, zzs.zzaSO, zzs.zzaSB, zzs.zzaSL, zzs.zzaSA, zzs.zzaSK, DataType.TYPE_BODY_FAT_PERCENTAGE, DataType.AGGREGATE_BODY_FAT_PERCENTAGE_SUMMARY, DataType.zzaRx, DataType.zzaRz, zzs.zzaSD, zzs.zzaSN, DataType.zzaRw, DataType.zzaRA, DataType.TYPE_BASAL_METABOLIC_RATE, DataType.AGGREGATE_BASAL_METABOLIC_RATE_SUMMARY, DataType.TYPE_CALORIES_CONSUMED, DataType.TYPE_CALORIES_EXPENDED, zzs.zzaSF, zzs.zzaSG, DataType.TYPE_CYCLING_PEDALING_CADENCE, DataType.TYPE_CYCLING_PEDALING_CUMULATIVE, DataType.TYPE_CYCLING_WHEEL_REVOLUTION, DataType.TYPE_CYCLING_WHEEL_RPM, DataType.TYPE_DISTANCE_CUMULATIVE, DataType.TYPE_DISTANCE_DELTA, DataType.zzaRs, DataType.zzaRy, DataType.TYPE_HEART_RATE_BPM, DataType.AGGREGATE_HEART_RATE_SUMMARY, DataType.TYPE_HEIGHT, DataType.AGGREGATE_LOCATION_BOUNDING_BOX, DataType.TYPE_LOCATION_SAMPLE, DataType.TYPE_LOCATION_TRACK, zzs.zzaSH, DataType.TYPE_NUTRITION, DataType.TYPE_HYDRATION, DataType.AGGREGATE_NUTRITION_SUMMARY, zzs.zzaSI, zzs.zzaSC, zzs.zzaSM, DataType.TYPE_POWER_SAMPLE, DataType.AGGREGATE_POWER_SUMMARY, DataType.zzaRv, DataType.zzaRu, DataType.TYPE_SPEED, DataType.AGGREGATE_SPEED_SUMMARY, DataType.TYPE_STEP_COUNT_CADENCE, DataType.zzaRr, DataType.TYPE_STEP_COUNT_CUMULATIVE, DataType.TYPE_STEP_COUNT_DELTA, zzs.zzaSJ, DataType.TYPE_WEIGHT, DataType.AGGREGATE_WEIGHT_SUMMARY};
        zzaRF = new DataType[]{zzs.zzaSE, zzs.zzaSO, zzs.zzaSB, zzs.zzaSL, zzs.zzaSA, zzs.zzaSK, zzs.zzaSD, zzs.zzaSN, zzs.zzaSF, zzs.zzaSG, zzs.zzaSH, zzs.zzaSI, zzs.zzaSC, zzs.zzaSM, zzs.zzaSJ};
    }

    public static DataType zzeb(String str) {
        Object obj = -1;
        switch (str.hashCode()) {
            case -2060095039:
                if (str.equals("com.google.cycling.wheel_revolution.rpm")) {
                    obj = 29;
                    break;
                }
                break;
            case -2027664088:
                if (str.equals("com.google.calories.consumed")) {
                    obj = 22;
                    break;
                }
                break;
            case -2023954015:
                if (str.equals("com.google.location.bounding_box")) {
                    obj = 37;
                    break;
                }
                break;
            case -1939429191:
                if (str.equals("com.google.blood_glucose.summary")) {
                    obj = 10;
                    break;
                }
                break;
            case -1783842905:
                if (str.equals("com.google.accelerometer")) {
                    obj = null;
                    break;
                }
                break;
            case -1757812901:
                if (str.equals("com.google.location.sample")) {
                    obj = 38;
                    break;
                }
                break;
            case -1659958877:
                if (str.equals("com.google.menstruation")) {
                    obj = 40;
                    break;
                }
                break;
            case -1487055015:
                if (str.equals("com.google.body.temperature.basal.summary")) {
                    obj = 7;
                    break;
                }
                break;
            case -1466904157:
                if (str.equals("com.google.floor_change.summary")) {
                    obj = 33;
                    break;
                }
                break;
            case -1248818137:
                if (str.equals("com.google.distance.delta")) {
                    obj = 31;
                    break;
                }
                break;
            case -1196687875:
                if (str.equals("com.google.internal.session.v2")) {
                    obj = 53;
                    break;
                }
                break;
            case -1102520626:
                if (str.equals("com.google.step_count.delta")) {
                    obj = 57;
                    break;
                }
                break;
            case -1099695423:
                if (str.equals("com.google.activity.sample")) {
                    obj = 2;
                    break;
                }
                break;
            case -1091068721:
                if (str.equals("com.google.height")) {
                    obj = 36;
                    break;
                }
                break;
            case -922976890:
                if (str.equals("com.google.cycling.pedaling.cumulative")) {
                    obj = 27;
                    break;
                }
                break;
            case -900592674:
                if (str.equals("com.google.cycling.pedaling.cadence")) {
                    obj = 26;
                    break;
                }
                break;
            case -886569606:
                if (str.equals("com.google.location.track")) {
                    obj = 39;
                    break;
                }
                break;
            case -777285735:
                if (str.equals("com.google.heart_rate.summary")) {
                    obj = 35;
                    break;
                }
                break;
            case -661631456:
                if (str.equals("com.google.weight")) {
                    obj = 60;
                    break;
                }
                break;
            case -424876584:
                if (str.equals("com.google.weight.summary")) {
                    obj = 61;
                    break;
                }
                break;
            case -362418992:
                if (str.equals("com.google.body.temperature")) {
                    obj = 16;
                    break;
                }
                break;
            case -217611775:
                if (str.equals("com.google.blood_glucose")) {
                    obj = 9;
                    break;
                }
                break;
            case -185830635:
                if (str.equals("com.google.power.summary")) {
                    obj = 48;
                    break;
                }
                break;
            case -177293656:
                if (str.equals("com.google.nutrition.summary")) {
                    obj = 43;
                    break;
                }
                break;
            case -164586193:
                if (str.equals("com.google.activity.exercise")) {
                    obj = 1;
                    break;
                }
                break;
            case -98150574:
                if (str.equals("com.google.heart_rate.bpm")) {
                    obj = 34;
                    break;
                }
                break;
            case -56824761:
                if (str.equals("com.google.calories.bmr")) {
                    obj = 20;
                    break;
                }
                break;
            case -43729332:
                if (str.equals("com.google.body.hip.circumference")) {
                    obj = 14;
                    break;
                }
                break;
            case 2484093:
                if (str.equals("com.google.body.waist.circumference")) {
                    obj = 18;
                    break;
                }
                break;
            case 53773386:
                if (str.equals("com.google.blood_pressure.summary")) {
                    obj = 12;
                    break;
                }
                break;
            case 269180370:
                if (str.equals("com.google.activity.samples")) {
                    obj = 3;
                    break;
                }
                break;
            case 295793957:
                if (str.equals("com.google.sensor.events")) {
                    obj = 50;
                    break;
                }
                break;
            case 296250623:
                if (str.equals("com.google.calories.bmr.summary")) {
                    obj = 21;
                    break;
                }
                break;
            case 324760871:
                if (str.equals("com.google.step_count.cadence")) {
                    obj = 55;
                    break;
                }
                break;
            case 378060028:
                if (str.equals("com.google.activity.segment")) {
                    obj = 4;
                    break;
                }
                break;
            case 529727579:
                if (str.equals("com.google.power.sample")) {
                    obj = 47;
                    break;
                }
                break;
            case 634821360:
                if (str.equals("com.google.sensor.const_rate_events")) {
                    obj = 49;
                    break;
                }
                break;
            case 657433501:
                if (str.equals("com.google.step_count.cumulative")) {
                    obj = 56;
                    break;
                }
                break;
            case 682891187:
                if (str.equals("com.google.body.fat.percentage")) {
                    obj = 8;
                    break;
                }
                break;
            case 841663855:
                if (str.equals("com.google.activity.summary")) {
                    obj = 5;
                    break;
                }
                break;
            case 877955159:
                if (str.equals("com.google.speed.summary")) {
                    obj = 54;
                    break;
                }
                break;
            case 899666941:
                if (str.equals("com.google.calories.expended")) {
                    obj = 23;
                    break;
                }
                break;
            case 936279698:
                if (str.equals("com.google.blood_pressure")) {
                    obj = 11;
                    break;
                }
                break;
            case 946706510:
                if (str.equals("com.google.hydration")) {
                    obj = 42;
                    break;
                }
                break;
            case 946938859:
                if (str.equals("com.google.stride_model")) {
                    obj = 58;
                    break;
                }
                break;
            case 1098265835:
                if (str.equals("com.google.floor_change")) {
                    obj = 32;
                    break;
                }
                break;
            case 1111714923:
                if (str.equals("com.google.body.fat.percentage.summary")) {
                    obj = 13;
                    break;
                }
                break;
            case 1214093899:
                if (str.equals("com.google.vaginal_spotting")) {
                    obj = 59;
                    break;
                }
                break;
            case 1404118825:
                if (str.equals("com.google.oxygen_saturation")) {
                    obj = 45;
                    break;
                }
                break;
            case 1439932546:
                if (str.equals("com.google.ovulation_test")) {
                    obj = 44;
                    break;
                }
                break;
            case 1483133089:
                if (str.equals("com.google.body.temperature.basal")) {
                    obj = 6;
                    break;
                }
                break;
            case 1524007137:
                if (str.equals("com.google.cycling.wheel_revolution.cumulative")) {
                    obj = 28;
                    break;
                }
                break;
            case 1633152752:
                if (str.equals("com.google.nutrition")) {
                    obj = 41;
                    break;
                }
                break;
            case 1674865156:
                if (str.equals("com.google.body.hip.circumference.summary")) {
                    obj = 15;
                    break;
                }
                break;
            case 1819660853:
                if (str.equals("com.google.body.waist.circumference.summary")) {
                    obj = 19;
                    break;
                }
                break;
            case 1921738212:
                if (str.equals("com.google.distance.cumulative")) {
                    obj = 30;
                    break;
                }
                break;
            case 1925848149:
                if (str.equals("com.google.cervical_position")) {
                    obj = 25;
                    break;
                }
                break;
            case 1975902189:
                if (str.equals("com.google.cervical_mucus")) {
                    obj = 24;
                    break;
                }
                break;
            case 1980033842:
                if (str.equals("com.google.internal.session.debug")) {
                    obj = 52;
                    break;
                }
                break;
            case 2051843553:
                if (str.equals("com.google.oxygen_saturation.summary")) {
                    obj = 46;
                    break;
                }
                break;
            case 2053496735:
                if (str.equals("com.google.speed")) {
                    obj = 51;
                    break;
                }
                break;
            case 2131809416:
                if (str.equals("com.google.body.temperature.summary")) {
                    obj = 17;
                    break;
                }
                break;
        }
        switch (obj) {
            case MessageApi.FILTER_LITERAL /*0*/:
                return DataType.zzaRt;
            case MessageApi.FILTER_PREFIX /*1*/:
                return DataType.TYPE_WORKOUT_EXERCISE;
            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                return DataType.TYPE_ACTIVITY_SAMPLE;
            case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                return DataType.TYPE_ACTIVITY_SAMPLES;
            case Dimension.UNIT_IN /*4*/:
                return DataType.TYPE_ACTIVITY_SEGMENT;
            case Dimension.UNIT_MM /*5*/:
                return DataType.AGGREGATE_ACTIVITY_SUMMARY;
            case BuyButtonText.LOGO_ONLY /*6*/:
                return zzs.zzaSE;
            case BuyButtonText.DONATE_WITH /*7*/:
                return zzs.zzaSO;
            case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                return DataType.TYPE_BODY_FAT_PERCENTAGE;
            case HTTP.HT /*9*/:
                return zzs.zzaSB;
            case HTTP.LF /*10*/:
                return zzs.zzaSL;
            case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                return zzs.zzaSA;
            case C0473R.styleable.MapAttrs_uiZoomGestures /*12*/:
                return zzs.zzaSK;
            case HTTP.CR /*13*/:
                return DataType.AGGREGATE_BODY_FAT_PERCENTAGE_SUMMARY;
            case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                return DataType.zzaRx;
            case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                return DataType.zzaRz;
            case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                return zzs.zzaSD;
            case ConnectionResult.SIGN_IN_FAILED /*17*/:
                return zzs.zzaSN;
            case ConnectionResult.SERVICE_UPDATING /*18*/:
                return DataType.zzaRw;
            case ConnectionResult.SERVICE_MISSING_PERMISSION /*19*/:
                return DataType.zzaRA;
            case ConnectionResult.RESTRICTED_PROFILE /*20*/:
                return DataType.TYPE_BASAL_METABOLIC_RATE;
            case C0473R.styleable.MapAttrs_latLngBoundsNorthEastLatitude /*21*/:
                return DataType.AGGREGATE_BASAL_METABOLIC_RATE_SUMMARY;
            case C0473R.styleable.MapAttrs_latLngBoundsNorthEastLongitude /*22*/:
                return DataType.TYPE_CALORIES_CONSUMED;
            case C0308R.styleable.Toolbar_collapseContentDescription /*23*/:
                return DataType.TYPE_CALORIES_EXPENDED;
            case C0308R.styleable.Toolbar_navigationIcon /*24*/:
                return zzs.zzaSF;
            case C0308R.styleable.Toolbar_navigationContentDescription /*25*/:
                return zzs.zzaSG;
            case C0308R.styleable.Toolbar_logoDescription /*26*/:
                return DataType.TYPE_CYCLING_PEDALING_CADENCE;
            case C0308R.styleable.Toolbar_titleTextColor /*27*/:
                return DataType.TYPE_CYCLING_PEDALING_CUMULATIVE;
            case C0308R.styleable.Toolbar_subtitleTextColor /*28*/:
                return DataType.TYPE_CYCLING_WHEEL_REVOLUTION;
            case C0308R.styleable.AppCompatTheme_actionModeBackground /*29*/:
                return DataType.TYPE_CYCLING_WHEEL_RPM;
            case MetadataChangeSet.MAX_PUBLIC_PROPERTIES_PER_RESOURCE /*30*/:
                return DataType.TYPE_DISTANCE_CUMULATIVE;
            case C0308R.styleable.AppCompatTheme_actionModeCloseDrawable /*31*/:
                return DataType.TYPE_DISTANCE_DELTA;
            case HTTP.SP /*32*/:
                return DataType.zzaRs;
            case C0308R.styleable.AppCompatTheme_actionModeCopyDrawable /*33*/:
                return DataType.zzaRy;
            case C0308R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                return DataType.TYPE_HEART_RATE_BPM;
            case C0308R.styleable.AppCompatTheme_actionModeSelectAllDrawable /*35*/:
                return DataType.AGGREGATE_HEART_RATE_SUMMARY;
            case C0308R.styleable.AppCompatTheme_actionModeShareDrawable /*36*/:
                return DataType.TYPE_HEIGHT;
            case C0308R.styleable.AppCompatTheme_actionModeFindDrawable /*37*/:
                return DataType.AGGREGATE_LOCATION_BOUNDING_BOX;
            case C0308R.styleable.AppCompatTheme_actionModeWebSearchDrawable /*38*/:
                return DataType.TYPE_LOCATION_SAMPLE;
            case C0308R.styleable.AppCompatTheme_actionModePopupWindowStyle /*39*/:
                return DataType.TYPE_LOCATION_TRACK;
            case C0308R.styleable.AppCompatTheme_textAppearanceLargePopupMenu /*40*/:
                return zzs.zzaSH;
            case C0308R.styleable.AppCompatTheme_textAppearanceSmallPopupMenu /*41*/:
                return DataType.TYPE_NUTRITION;
            case C0308R.styleable.AppCompatTheme_textAppearancePopupMenuHeader /*42*/:
                return DataType.TYPE_HYDRATION;
            case C0308R.styleable.AppCompatTheme_dialogTheme /*43*/:
                return DataType.AGGREGATE_NUTRITION_SUMMARY;
            case C0308R.styleable.AppCompatTheme_dialogPreferredPadding /*44*/:
                return zzs.zzaSI;
            case C0308R.styleable.AppCompatTheme_listDividerAlertDialog /*45*/:
                return zzs.zzaSC;
            case C0308R.styleable.AppCompatTheme_actionDropDownStyle /*46*/:
                return zzs.zzaSM;
            case C0308R.styleable.AppCompatTheme_dropdownListPreferredItemHeight /*47*/:
                return DataType.TYPE_POWER_SAMPLE;
            case C0308R.styleable.AppCompatTheme_spinnerDropDownItemStyle /*48*/:
                return DataType.AGGREGATE_POWER_SUMMARY;
            case C0308R.styleable.AppCompatTheme_homeAsUpIndicator /*49*/:
                return DataType.zzaRv;
            case AdSize.PORTRAIT_AD_HEIGHT /*50*/:
                return DataType.zzaRu;
            case C0308R.styleable.AppCompatTheme_buttonBarStyle /*51*/:
                return DataType.TYPE_SPEED;
            case C0308R.styleable.AppCompatTheme_buttonBarButtonStyle /*52*/:
                return zza.zzaRC;
            case C0308R.styleable.AppCompatTheme_selectableItemBackground /*53*/:
                return zza.zzaRD;
            case C0308R.styleable.AppCompatTheme_selectableItemBackgroundBorderless /*54*/:
                return DataType.AGGREGATE_SPEED_SUMMARY;
            case C0308R.styleable.AppCompatTheme_borderlessButtonStyle /*55*/:
                return DataType.TYPE_STEP_COUNT_CADENCE;
            case C0308R.styleable.AppCompatTheme_dividerVertical /*56*/:
                return DataType.TYPE_STEP_COUNT_CUMULATIVE;
            case C0308R.styleable.AppCompatTheme_dividerHorizontal /*57*/:
                return DataType.TYPE_STEP_COUNT_DELTA;
            case C0308R.styleable.AppCompatTheme_activityChooserViewStyle /*58*/:
                return DataType.zzaRr;
            case C0308R.styleable.AppCompatTheme_toolbarStyle /*59*/:
                return zzs.zzaSJ;
            case C0308R.styleable.AppCompatTheme_toolbarNavigationButtonStyle /*60*/:
                return DataType.TYPE_WEIGHT;
            case C0308R.styleable.AppCompatTheme_popupMenuStyle /*61*/:
                return DataType.AGGREGATE_WEIGHT_SUMMARY;
            default:
                return null;
        }
    }
}
