package com.google.android.gms.internal;

import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.zzk;
import com.google.android.gms.drive.metadata.internal.zzl;
import com.google.android.gms.drive.metadata.internal.zzn;
import com.google.android.gms.drive.metadata.internal.zzq;
import com.google.android.gms.drive.metadata.internal.zzr;
import com.google.android.gms.drive.metadata.internal.zzs;
import com.google.android.gms.plus.PlusShare;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class zzalh {
    public static final MetadataField<DriveId> zzaNA;
    public static final MetadataField<String> zzaNB;
    public static final zza zzaNC;
    public static final MetadataField<String> zzaND;
    public static final MetadataField<String> zzaNE;
    public static final MetadataField<String> zzaNF;
    public static final MetadataField<Long> zzaNG;
    public static final MetadataField<String> zzaNH;
    public static final MetadataField<Boolean> zzaNI;
    public static final MetadataField<String> zzaNJ;
    public static final MetadataField<Boolean> zzaNK;
    public static final MetadataField<Boolean> zzaNL;
    public static final MetadataField<Boolean> zzaNM;
    public static final MetadataField<Boolean> zzaNN;
    public static final MetadataField<Boolean> zzaNO;
    public static final zzb zzaNP;
    public static final MetadataField<Boolean> zzaNQ;
    public static final MetadataField<Boolean> zzaNR;
    public static final MetadataField<Boolean> zzaNS;
    public static final MetadataField<Boolean> zzaNT;
    public static final MetadataField<Boolean> zzaNU;
    public static final MetadataField<Boolean> zzaNV;
    public static final MetadataField<Boolean> zzaNW;
    public static final zzc zzaNX;
    public static final MetadataField<String> zzaNY;
    public static final com.google.android.gms.drive.metadata.zzb<String> zzaNZ;
    public static final zzs zzaOa;
    public static final zzs zzaOb;
    public static final zzn zzaOc;
    public static final zzd zzaOd;
    public static final zzf zzaOe;
    public static final MetadataField<BitmapTeleporter> zzaOf;
    public static final zzg zzaOg;
    public static final zzh zzaOh;
    public static final MetadataField<String> zzaOi;
    public static final MetadataField<String> zzaOj;
    public static final MetadataField<String> zzaOk;
    public static final com.google.android.gms.drive.metadata.internal.zzb zzaOl;
    public static final MetadataField<String> zzaOm;
    public static final MetadataField<String> zzaOn;
    public static final zze zzaOo;
    public static final MetadataField<String> zzaOp;
    public static final MetadataField<Boolean> zzaOq;

    /* renamed from: com.google.android.gms.internal.zzalh.1 */
    class C09551 extends com.google.android.gms.drive.metadata.internal.zzb {
        C09551(String str, Collection collection, Collection collection2, int i) {
            super(str, collection, collection2, i);
        }

        protected /* synthetic */ Object zzc(DataHolder dataHolder, int i, int i2) {
            return zze(dataHolder, i, i2);
        }

        protected Boolean zze(DataHolder dataHolder, int i, int i2) {
            return Boolean.valueOf(dataHolder.zzc("trashed", i, i2) == 2);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzalh.2 */
    class C09562 extends zzl<BitmapTeleporter> {
        C09562(String str, Collection collection, Collection collection2, int i) {
            super(str, collection, collection2, i);
        }

        protected /* synthetic */ Object zzc(DataHolder dataHolder, int i, int i2) {
            return zzk(dataHolder, i, i2);
        }

        protected BitmapTeleporter zzk(DataHolder dataHolder, int i, int i2) {
            throw new IllegalStateException("Thumbnail field is write only");
        }
    }

    public static class zza extends zzali implements SearchableMetadataField<AppVisibleCustomProperties> {
        public zza(int i) {
            super(i);
        }
    }

    public static class zzb extends com.google.android.gms.drive.metadata.internal.zzb implements SearchableMetadataField<Boolean> {
        public zzb(String str, int i) {
            super(str, i);
        }
    }

    public static class zzc extends zzr implements SearchableMetadataField<String> {
        public zzc(int i) {
            super("mimeType", i);
        }
    }

    public static class zzd extends com.google.android.gms.drive.metadata.internal.zzh implements SortableMetadataField<Long> {
        public zzd(String str, int i) {
            super(str, i);
        }
    }

    public static class zze extends zzk<DriveSpace> {
        public zze(int i) {
            super("spaces", Arrays.asList(new String[]{"inDriveSpace", "isAppData", "inGooglePhotosSpace"}), Collections.emptySet(), i);
        }

        protected /* synthetic */ Object zzc(DataHolder dataHolder, int i, int i2) {
            return zzd(dataHolder, i, i2);
        }

        protected Collection<DriveSpace> zzd(DataHolder dataHolder, int i, int i2) {
            Collection arrayList = new ArrayList();
            if (dataHolder.zze("inDriveSpace", i, i2)) {
                arrayList.add(DriveSpace.zzaJz);
            }
            if (dataHolder.zze("isAppData", i, i2)) {
                arrayList.add(DriveSpace.zzaJA);
            }
            if (dataHolder.zze("inGooglePhotosSpace", i, i2)) {
                arrayList.add(DriveSpace.zzaJB);
            }
            return arrayList;
        }
    }

    public static class zzf extends com.google.android.gms.drive.metadata.internal.zzb implements SearchableMetadataField<Boolean> {
        public zzf(String str, int i) {
            super(str, i);
        }
    }

    public static class zzg extends zzr implements SearchableMetadataField<String>, SortableMetadataField<String> {
        public zzg(String str, int i) {
            super(str, i);
        }
    }

    public static class zzh extends com.google.android.gms.drive.metadata.internal.zzb implements SearchableMetadataField<Boolean> {
        public zzh(String str, int i) {
            super(str, i);
        }

        protected /* synthetic */ Object zzc(DataHolder dataHolder, int i, int i2) {
            return zze(dataHolder, i, i2);
        }

        protected Boolean zze(DataHolder dataHolder, int i, int i2) {
            return Boolean.valueOf(dataHolder.zzc(getName(), i, i2) != 0);
        }
    }

    static {
        zzaNA = zzalk.zzaOy;
        zzaNB = new zzr("alternateLink", 4300000);
        zzaNC = new zza(5000000);
        zzaND = new zzr(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 4300000);
        zzaNE = new zzr("embedLink", 4300000);
        zzaNF = new zzr("fileExtension", 4300000);
        zzaNG = new com.google.android.gms.drive.metadata.internal.zzh("fileSize", 4300000);
        zzaNH = new zzr("folderColorRgb", 7500000);
        zzaNI = new com.google.android.gms.drive.metadata.internal.zzb("hasThumbnail", 4300000);
        zzaNJ = new zzr("indexableText", 4300000);
        zzaNK = new com.google.android.gms.drive.metadata.internal.zzb("isAppData", 4300000);
        zzaNL = new com.google.android.gms.drive.metadata.internal.zzb("isCopyable", 4300000);
        zzaNM = new com.google.android.gms.drive.metadata.internal.zzb("isEditable", 4100000);
        zzaNN = new C09551("isExplicitlyTrashed", Collections.singleton("trashed"), Collections.emptySet(), 7000000);
        zzaNO = new com.google.android.gms.drive.metadata.internal.zzb("isLocalContentUpToDate", 7800000);
        zzaNP = new zzb("isPinned", 4100000);
        zzaNQ = new com.google.android.gms.drive.metadata.internal.zzb("isOpenable", 7200000);
        zzaNR = new com.google.android.gms.drive.metadata.internal.zzb("isRestricted", 4300000);
        zzaNS = new com.google.android.gms.drive.metadata.internal.zzb("isShared", 4300000);
        zzaNT = new com.google.android.gms.drive.metadata.internal.zzb("isGooglePhotosFolder", 7000000);
        zzaNU = new com.google.android.gms.drive.metadata.internal.zzb("isGooglePhotosRootFolder", 7000000);
        zzaNV = new com.google.android.gms.drive.metadata.internal.zzb("isTrashable", 4400000);
        zzaNW = new com.google.android.gms.drive.metadata.internal.zzb("isViewed", 4300000);
        zzaNX = new zzc(4100000);
        zzaNY = new zzr("originalFilename", 4300000);
        zzaNZ = new zzq("ownerNames", 4300000);
        zzaOa = new zzs("lastModifyingUser", 6000000);
        zzaOb = new zzs("sharingUser", 6000000);
        zzaOc = new zzn(4100000);
        zzaOd = new zzd("quotaBytesUsed", 4300000);
        zzaOe = new zzf("starred", 4100000);
        zzaOf = new C09562("thumbnail", Collections.emptySet(), Collections.emptySet(), 4400000);
        zzaOg = new zzg(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, 4100000);
        zzaOh = new zzh("trashed", 4100000);
        zzaOi = new zzr("webContentLink", 4300000);
        zzaOj = new zzr("webViewLink", 4300000);
        zzaOk = new zzr("uniqueIdentifier", 5000000);
        zzaOl = new com.google.android.gms.drive.metadata.internal.zzb("writersCanShare", 6000000);
        zzaOm = new zzr("role", 6000000);
        zzaOn = new zzr("md5Checksum", 7000000);
        zzaOo = new zze(7000000);
        zzaOp = new zzr("recencyReason", 8000000);
        zzaOq = new com.google.android.gms.drive.metadata.internal.zzb("subscribed", 8000000);
    }
}
