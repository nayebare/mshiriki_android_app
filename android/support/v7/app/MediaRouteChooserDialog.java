package android.support.v7.app;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.media.MediaRouteSelector;
import android.support.v7.media.MediaRouter;
import android.support.v7.media.MediaRouter.Callback;
import android.support.v7.media.MediaRouter.RouteGroup;
import android.support.v7.media.MediaRouter.RouteInfo;
import android.support.v7.mediarouter.C0308R;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.github.mikephil.charting.BuildConfig;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class MediaRouteChooserDialog extends Dialog {
    private static final String TAG = "MediaRouteChooserDialog";
    private RouteAdapter mAdapter;
    private boolean mAttachedToWindow;
    private final MediaRouterCallback mCallback;
    private ListView mListView;
    private AsyncTask<Void, Void, Void> mOnItemClickTask;
    private AsyncTask<Void, Void, Void> mRefreshRoutesTask;
    private final MediaRouter mRouter;
    private ArrayList<RouteInfo> mRoutes;
    private MediaRouteSelector mSelector;

    /* renamed from: android.support.v7.app.MediaRouteChooserDialog.1 */
    class C02631 extends AsyncTask<Void, Void, Void> {
        private ArrayList<RouteInfo> mNewRoutes;

        C02631() {
        }

        protected void onPreExecute() {
            this.mNewRoutes = new ArrayList(MediaRouteChooserDialog.this.mRouter.getRoutes());
            MediaRouteChooserDialog.this.onFilterRoutes(this.mNewRoutes);
        }

        protected Void doInBackground(Void... params) {
            synchronized (MediaRouteChooserDialog.this) {
                if (!isCancelled()) {
                    RouteComparator.getInstance(MediaRouteChooserDialog.this.getContext()).loadRouteUsageScores(this.mNewRoutes);
                }
            }
            return null;
        }

        protected void onPostExecute(Void params) {
            MediaRouteChooserDialog.this.mRoutes.clear();
            MediaRouteChooserDialog.this.mRoutes.addAll(this.mNewRoutes);
            Collections.sort(MediaRouteChooserDialog.this.mRoutes, RouteComparator.sInstance);
            MediaRouteChooserDialog.this.mAdapter.notifyDataSetChanged();
            MediaRouteChooserDialog.this.mRefreshRoutesTask = null;
        }
    }

    private final class MediaRouterCallback extends Callback {
        private MediaRouterCallback() {
        }

        public void onRouteAdded(MediaRouter router, RouteInfo info) {
            MediaRouteChooserDialog.this.refreshRoutes();
        }

        public void onRouteRemoved(MediaRouter router, RouteInfo info) {
            MediaRouteChooserDialog.this.refreshRoutes();
        }

        public void onRouteChanged(MediaRouter router, RouteInfo info) {
            MediaRouteChooserDialog.this.refreshRoutes();
        }

        public void onRouteSelected(MediaRouter router, RouteInfo route) {
            MediaRouteChooserDialog.this.dismiss();
        }
    }

    private final class RouteAdapter extends ArrayAdapter<RouteInfo> implements OnItemClickListener {
        private final Drawable mDefaultIcon;
        private final LayoutInflater mInflater;
        private final Drawable mSpeakerGroupIcon;
        private final Drawable mSpeakerIcon;
        private final Drawable mTvIcon;

        /* renamed from: android.support.v7.app.MediaRouteChooserDialog.RouteAdapter.1 */
        class C02641 extends AsyncTask<Void, Void, Void> {
            final /* synthetic */ RouteInfo val$route;

            C02641(RouteInfo routeInfo) {
                this.val$route = routeInfo;
            }

            protected void onPreExecute() {
                this.val$route.select();
            }

            protected Void doInBackground(Void... params) {
                RouteComparator.getInstance(RouteAdapter.this.getContext()).storeRouteUsageScores(this.val$route.getId());
                return null;
            }

            protected void onPostExecute(Void params) {
                MediaRouteChooserDialog.this.dismiss();
                MediaRouteChooserDialog.this.mOnItemClickTask = null;
            }
        }

        public RouteAdapter(Context context, List<RouteInfo> routes) {
            super(context, 0, routes);
            this.mInflater = LayoutInflater.from(context);
            TypedArray styledAttributes = getContext().obtainStyledAttributes(new int[]{C0308R.attr.mediaRouteDefaultIconDrawable, C0308R.attr.mediaRouteTvIconDrawable, C0308R.attr.mediaRouteSpeakerIconDrawable, C0308R.attr.mediaRouteSpeakerGroupIconDrawable});
            this.mDefaultIcon = styledAttributes.getDrawable(0);
            this.mTvIcon = styledAttributes.getDrawable(1);
            this.mSpeakerIcon = styledAttributes.getDrawable(2);
            this.mSpeakerGroupIcon = styledAttributes.getDrawable(3);
            styledAttributes.recycle();
        }

        public boolean areAllItemsEnabled() {
            return false;
        }

        public boolean isEnabled(int position) {
            return ((RouteInfo) getItem(position)).isEnabled();
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            boolean isConnectedOrConnecting = true;
            View view = convertView;
            if (view == null) {
                view = this.mInflater.inflate(C0308R.layout.mr_chooser_list_item, parent, false);
            }
            RouteInfo route = (RouteInfo) getItem(position);
            TextView text1 = (TextView) view.findViewById(C0308R.id.mr_chooser_route_name);
            TextView text2 = (TextView) view.findViewById(C0308R.id.mr_chooser_route_desc);
            text1.setText(route.getName());
            String description = route.getDescription();
            if (!(route.getConnectionState() == 2 || route.getConnectionState() == 1)) {
                isConnectedOrConnecting = false;
            }
            if (!isConnectedOrConnecting || TextUtils.isEmpty(description)) {
                text1.setGravity(16);
                text2.setVisibility(8);
                text2.setText(BuildConfig.FLAVOR);
            } else {
                text1.setGravity(80);
                text2.setVisibility(0);
                text2.setText(description);
            }
            view.setEnabled(route.isEnabled());
            ImageView iconView = (ImageView) view.findViewById(C0308R.id.mr_chooser_route_icon);
            if (iconView != null) {
                iconView.setImageDrawable(getIconDrawable(route));
            }
            return view;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            RouteInfo route = (RouteInfo) getItem(position);
            if (route.isEnabled() && MediaRouteChooserDialog.this.mOnItemClickTask == null) {
                MediaRouteChooserDialog.this.mOnItemClickTask = new C02641(route).execute(new Void[0]);
            }
        }

        private Drawable getIconDrawable(RouteInfo route) {
            Uri iconUri = route.getIconUri();
            if (iconUri != null) {
                try {
                    Drawable drawable = Drawable.createFromStream(getContext().getContentResolver().openInputStream(iconUri), null);
                    if (drawable != null) {
                        return drawable;
                    }
                } catch (IOException e) {
                    Log.w(MediaRouteChooserDialog.TAG, "Failed to load " + iconUri, e);
                }
            }
            return getDefaultIconDrawable(route);
        }

        private Drawable getDefaultIconDrawable(RouteInfo route) {
            switch (route.getDeviceType()) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    return this.mTvIcon;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    return this.mSpeakerIcon;
                default:
                    if (route instanceof RouteGroup) {
                        return this.mSpeakerGroupIcon;
                    }
                    return this.mDefaultIcon;
            }
        }
    }

    private static final class RouteComparator implements Comparator<RouteInfo> {
        private static final float MIN_USAGE_SCORE = 0.1f;
        private static final String PREF_ROUTE_IDS = "android.support.v7.app.MediaRouteChooserDialog_route_ids";
        private static final String PREF_USAGE_SCORE_PREFIX = "android.support.v7.app.MediaRouteChooserDialog_route_usage_score_";
        private static final float USAGE_SCORE_DECAY_FACTOR = 0.95f;
        private static RouteComparator sInstance;
        private final SharedPreferences mPreferences;
        private final HashMap<String, Float> mRouteUsageScoreMap;

        public static RouteComparator getInstance(Context context) {
            if (sInstance == null) {
                sInstance = new RouteComparator(context);
            }
            return sInstance;
        }

        private RouteComparator(Context context) {
            this.mRouteUsageScoreMap = new HashMap();
            this.mPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        }

        public int compare(RouteInfo lhs, RouteInfo rhs) {
            if (lhs == null) {
                if (rhs == null) {
                    return 0;
                }
                return -1;
            } else if (rhs == null) {
                return 1;
            } else {
                Float lhsUsageScore = (Float) this.mRouteUsageScoreMap.get(lhs.getId());
                if (lhsUsageScore == null) {
                    lhsUsageScore = Float.valueOf(0.0f);
                }
                Float rhsUsageScore = (Float) this.mRouteUsageScoreMap.get(rhs.getId());
                if (rhsUsageScore == null) {
                    rhsUsageScore = Float.valueOf(0.0f);
                }
                if (lhsUsageScore.equals(rhsUsageScore)) {
                    return lhs.getName().compareTo(rhs.getName());
                }
                if (lhsUsageScore.floatValue() <= rhsUsageScore.floatValue()) {
                    return 1;
                }
                return -1;
            }
        }

        private void loadRouteUsageScores(List<RouteInfo> routes) {
            for (RouteInfo route : routes) {
                if (this.mRouteUsageScoreMap.get(route.getId()) == null) {
                    this.mRouteUsageScoreMap.put(route.getId(), Float.valueOf(this.mPreferences.getFloat(PREF_USAGE_SCORE_PREFIX + route.getId(), 0.0f)));
                }
            }
        }

        private void storeRouteUsageScores(String selectedRouteId) {
            Editor prefEditor = this.mPreferences.edit();
            List<String> routeIds = new ArrayList(Arrays.asList(this.mPreferences.getString(PREF_ROUTE_IDS, BuildConfig.FLAVOR).split(",")));
            if (!routeIds.contains(selectedRouteId)) {
                routeIds.add(selectedRouteId);
            }
            StringBuilder routeIdsBuilder = new StringBuilder();
            for (String routeId : routeIds) {
                String routeUsageScoreKey = PREF_USAGE_SCORE_PREFIX + routeId;
                float newUsageScore = this.mPreferences.getFloat(routeUsageScoreKey, 0.0f) * USAGE_SCORE_DECAY_FACTOR;
                if (selectedRouteId.equals(routeId)) {
                    newUsageScore += TextTrackStyle.DEFAULT_FONT_SCALE;
                }
                if (newUsageScore < MIN_USAGE_SCORE) {
                    this.mRouteUsageScoreMap.remove(routeId);
                    prefEditor.remove(routeId);
                } else {
                    this.mRouteUsageScoreMap.put(routeId, Float.valueOf(newUsageScore));
                    prefEditor.putFloat(routeUsageScoreKey, newUsageScore);
                    if (routeIdsBuilder.length() > 0) {
                        routeIdsBuilder.append(',');
                    }
                    routeIdsBuilder.append(routeId);
                }
            }
            prefEditor.putString(PREF_ROUTE_IDS, routeIdsBuilder.toString());
            prefEditor.commit();
        }
    }

    public MediaRouteChooserDialog(Context context) {
        this(context, 0);
    }

    public MediaRouteChooserDialog(Context context, int theme) {
        super(MediaRouterThemeHelper.createThemedContext(context, theme), theme);
        this.mSelector = MediaRouteSelector.EMPTY;
        this.mRouter = MediaRouter.getInstance(getContext());
        this.mCallback = new MediaRouterCallback();
    }

    @NonNull
    public MediaRouteSelector getRouteSelector() {
        return this.mSelector;
    }

    public void setRouteSelector(@NonNull MediaRouteSelector selector) {
        if (selector == null) {
            throw new IllegalArgumentException("selector must not be null");
        } else if (!this.mSelector.equals(selector)) {
            this.mSelector = selector;
            if (this.mAttachedToWindow) {
                this.mRouter.removeCallback(this.mCallback);
                this.mRouter.addCallback(selector, this.mCallback, 1);
            }
            refreshRoutes();
        }
    }

    public void onFilterRoutes(@NonNull List<RouteInfo> routes) {
        int i = routes.size();
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                return;
            }
            if (onFilterRoute((RouteInfo) routes.get(i2))) {
                i = i2;
            } else {
                routes.remove(i2);
                i = i2;
            }
        }
    }

    public boolean onFilterRoute(@NonNull RouteInfo route) {
        return !route.isDefaultOrBluetooth() && route.isEnabled() && route.matchesSelector(this.mSelector);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0308R.layout.mr_chooser_dialog);
        setTitle(C0308R.string.mr_chooser_title);
        this.mRoutes = new ArrayList();
        this.mAdapter = new RouteAdapter(getContext(), this.mRoutes);
        this.mListView = (ListView) findViewById(C0308R.id.mr_chooser_list);
        this.mListView.setAdapter(this.mAdapter);
        this.mListView.setOnItemClickListener(this.mAdapter);
        this.mListView.setEmptyView(findViewById(16908292));
        updateLayout();
    }

    void updateLayout() {
        getWindow().setLayout(MediaRouteDialogHelper.getDialogWidth(getContext()), -2);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mAttachedToWindow = true;
        this.mRouter.addCallback(this.mSelector, this.mCallback, 1);
        refreshRoutes();
    }

    public void onDetachedFromWindow() {
        this.mAttachedToWindow = false;
        this.mRouter.removeCallback(this.mCallback);
        super.onDetachedFromWindow();
    }

    public void refreshRoutes() {
        if (this.mAttachedToWindow) {
            if (this.mRefreshRoutesTask != null) {
                this.mRefreshRoutesTask.cancel(true);
                this.mRefreshRoutesTask = null;
            }
            this.mRefreshRoutesTask = new C02631().execute(new Void[0]);
        }
    }
}
