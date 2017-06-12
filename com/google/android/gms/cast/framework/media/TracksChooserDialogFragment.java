package com.google.android.gms.cast.framework.media;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;
import com.github.mikephil.charting.BuildConfig;
import com.google.android.gms.C0473R;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaTrack;
import com.google.android.gms.cast.MediaTrack.Builder;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import java.util.ArrayList;
import java.util.List;

public class TracksChooserDialogFragment extends DialogFragment {
    private Dialog mDialog;
    private long[] zzany;
    private List<MediaTrack> zzarN;
    private List<MediaTrack> zzarO;

    /* renamed from: com.google.android.gms.cast.framework.media.TracksChooserDialogFragment.1 */
    class C06231 implements OnClickListener {
        final /* synthetic */ TracksChooserDialogFragment zzarP;

        C06231(TracksChooserDialogFragment tracksChooserDialogFragment) {
            this.zzarP = tracksChooserDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (this.zzarP.mDialog != null) {
                this.zzarP.mDialog.cancel();
                this.zzarP.mDialog = null;
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.framework.media.TracksChooserDialogFragment.2 */
    class C06242 implements OnClickListener {
        final /* synthetic */ TracksChooserDialogFragment zzarP;
        final /* synthetic */ zzf zzarQ;
        final /* synthetic */ zzf zzarR;

        C06242(TracksChooserDialogFragment tracksChooserDialogFragment, zzf com_google_android_gms_cast_framework_media_zzf, zzf com_google_android_gms_cast_framework_media_zzf2) {
            this.zzarP = tracksChooserDialogFragment;
            this.zzarQ = com_google_android_gms_cast_framework_media_zzf;
            this.zzarR = com_google_android_gms_cast_framework_media_zzf2;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.zzarP.zza(this.zzarQ, this.zzarR);
        }
    }

    public static TracksChooserDialogFragment newInstance(MediaInfo mediaInfo, long[] jArr) {
        if (mediaInfo == null) {
            return null;
        }
        List mediaTracks = mediaInfo.getMediaTracks();
        if (mediaTracks == null) {
            return null;
        }
        ArrayList zza = zza(mediaTracks, 2);
        ArrayList zza2 = zza(mediaTracks, 1);
        if (zza.isEmpty() && zza2.isEmpty()) {
            return null;
        }
        TracksChooserDialogFragment tracksChooserDialogFragment = new TracksChooserDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("extra_tracks_type_audio", zza);
        bundle.putParcelableArrayList("extra_tracks_type_text", zza2);
        bundle.putLongArray("extra_active_track_ids", jArr);
        tracksChooserDialogFragment.setArguments(bundle);
        return tracksChooserDialogFragment;
    }

    private static int zza(List<MediaTrack> list, long[] jArr, int i) {
        if (jArr == null || list == null) {
            return i;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            for (long j : jArr) {
                if (j == ((MediaTrack) list.get(i2)).getId()) {
                    return i2;
                }
            }
        }
        return i;
    }

    @NonNull
    private static ArrayList<MediaTrack> zza(List<MediaTrack> list, int i) {
        ArrayList<MediaTrack> arrayList = new ArrayList();
        if (list != null) {
            for (MediaTrack mediaTrack : list) {
                if (mediaTrack.getType() == i) {
                    arrayList.add(mediaTrack);
                }
            }
        }
        return arrayList;
    }

    private void zza(View view, zzf com_google_android_gms_cast_framework_media_zzf, zzf com_google_android_gms_cast_framework_media_zzf2) {
        ListView listView = (ListView) view.findViewById(C0473R.id.text_list_view);
        ListView listView2 = (ListView) view.findViewById(C0473R.id.audio_list_view);
        TextView textView = (TextView) view.findViewById(C0473R.id.text_empty_message);
        TextView textView2 = (TextView) view.findViewById(C0473R.id.audio_empty_message);
        listView.setAdapter(com_google_android_gms_cast_framework_media_zzf);
        listView2.setAdapter(com_google_android_gms_cast_framework_media_zzf2);
        TabHost tabHost = (TabHost) view.findViewById(C0473R.id.tab_host);
        tabHost.setup();
        TabSpec newTabSpec = tabHost.newTabSpec("textTab");
        if (com_google_android_gms_cast_framework_media_zzf.getCount() == 0) {
            listView.setVisibility(4);
            newTabSpec.setContent(C0473R.id.text_empty_message);
        } else {
            textView.setVisibility(4);
            newTabSpec.setContent(C0473R.id.text_list_view);
        }
        newTabSpec.setIndicator(getActivity().getString(C0473R.string.cast_tracks_chooser_dialog_subtitles));
        tabHost.addTab(newTabSpec);
        TabSpec newTabSpec2 = tabHost.newTabSpec("audioTab");
        if (com_google_android_gms_cast_framework_media_zzf2.getCount() == 0) {
            listView2.setVisibility(4);
            newTabSpec2.setContent(C0473R.id.audio_empty_message);
        } else {
            textView2.setVisibility(4);
            newTabSpec2.setContent(C0473R.id.audio_list_view);
        }
        newTabSpec2.setIndicator(getActivity().getString(C0473R.string.cast_tracks_chooser_dialog_audio));
        tabHost.addTab(newTabSpec2);
    }

    private void zza(zzf com_google_android_gms_cast_framework_media_zzf, zzf com_google_android_gms_cast_framework_media_zzf2) {
        List arrayList = new ArrayList();
        MediaTrack zztn = com_google_android_gms_cast_framework_media_zzf.zztn();
        if (zztn.getId() != -1) {
            arrayList.add(zztn);
        }
        zztn = com_google_android_gms_cast_framework_media_zzf2.zztn();
        if (zztn != null) {
            arrayList.add(zztn);
        }
        CastSession currentCastSession = CastContext.getSharedInstance(getContext()).getSessionManager().getCurrentCastSession();
        if (currentCastSession != null && currentCastSession.isConnected()) {
            RemoteMediaClient remoteMediaClient = currentCastSession.getRemoteMediaClient();
            if (remoteMediaClient != null) {
                long[] jArr = new long[arrayList.size()];
                for (int i = 0; i < arrayList.size(); i++) {
                    jArr[i] = ((MediaTrack) arrayList.get(i)).getId();
                }
                remoteMediaClient.setActiveMediaTracks(jArr);
            }
        }
        if (this.mDialog != null) {
            this.mDialog.cancel();
            this.mDialog = null;
        }
    }

    private MediaTrack zztm() {
        return new Builder(-1, 1).setName(getActivity().getString(C0473R.string.cast_tracks_chooser_dialog_none)).setSubtype(2).setContentId(BuildConfig.FLAVOR).build();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        this.zzarN = getArguments().getParcelableArrayList("extra_tracks_type_text");
        this.zzarN.add(0, zztm());
        this.zzarO = getArguments().getParcelableArrayList("extra_tracks_type_audio");
        this.zzany = getArguments().getLongArray("extra_active_track_ids");
    }

    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        int zza = zza(this.zzarN, this.zzany, 0);
        int zza2 = zza(this.zzarO, this.zzany, -1);
        zzf com_google_android_gms_cast_framework_media_zzf = new zzf(getActivity(), this.zzarN, zza);
        zzf com_google_android_gms_cast_framework_media_zzf2 = new zzf(getActivity(), this.zzarO, zza2);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View inflate = getActivity().getLayoutInflater().inflate(C0473R.layout.cast_tracks_chooser_dialog_layout, null);
        zza(inflate, com_google_android_gms_cast_framework_media_zzf, com_google_android_gms_cast_framework_media_zzf2);
        builder.setView(inflate).setPositiveButton(getActivity().getString(C0473R.string.cast_tracks_chooser_dialog_ok), new C06242(this, com_google_android_gms_cast_framework_media_zzf, com_google_android_gms_cast_framework_media_zzf2)).setNegativeButton(C0473R.string.cast_tracks_chooser_dialog_cancel, new C06231(this));
        if (this.mDialog != null) {
            this.mDialog.cancel();
            this.mDialog = null;
        }
        this.mDialog = builder.create();
        return this.mDialog;
    }

    public void onDestroyView() {
        if (getDialog() != null && getRetainInstance()) {
            getDialog().setDismissMessage(null);
        }
        super.onDestroyView();
    }
}
