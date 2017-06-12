package com.google.android.gms.maps;

import android.graphics.Bitmap;
import android.location.Location;
import android.os.RemoteException;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.IndoorBuilding;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.internal.zzc;
import com.google.android.gms.maps.model.internal.zzd;
import com.google.android.gms.maps.model.internal.zzf;
import com.google.android.gms.maps.model.internal.zzh;

public final class GoogleMap {
    public static final int MAP_TYPE_HYBRID = 4;
    public static final int MAP_TYPE_NONE = 0;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;
    public static final int MAP_TYPE_TERRAIN = 3;
    private final IGoogleMapDelegate zzbmY;
    private UiSettings zzbmZ;

    @Deprecated
    public interface OnCameraChangeListener {
        void onCameraChange(CameraPosition cameraPosition);
    }

    @Deprecated
    public interface OnMyLocationChangeListener {
        void onMyLocationChange(Location location);
    }

    protected GoogleMap(IGoogleMapDelegate iGoogleMapDelegate) {
        this.zzbmY = (IGoogleMapDelegate) zzac.zzw(iGoogleMapDelegate);
    }

    public final Circle addCircle(CircleOptions circleOptions) {
        try {
            return new Circle(this.zzbmY.addCircle(circleOptions));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) {
        try {
            zzc addGroundOverlay = this.zzbmY.addGroundOverlay(groundOverlayOptions);
            return addGroundOverlay != null ? new GroundOverlay(addGroundOverlay) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Marker addMarker(MarkerOptions markerOptions) {
        try {
            zzf addMarker = this.zzbmY.addMarker(markerOptions);
            return addMarker != null ? new Marker(addMarker) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Polygon addPolygon(PolygonOptions polygonOptions) {
        try {
            return new Polygon(this.zzbmY.addPolygon(polygonOptions));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Polyline addPolyline(PolylineOptions polylineOptions) {
        try {
            return new Polyline(this.zzbmY.addPolyline(polylineOptions));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final TileOverlay addTileOverlay(TileOverlayOptions tileOverlayOptions) {
        try {
            zzh addTileOverlay = this.zzbmY.addTileOverlay(tileOverlayOptions);
            return addTileOverlay != null ? new TileOverlay(addTileOverlay) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate cameraUpdate) {
        try {
            this.zzbmY.animateCamera(cameraUpdate.zzIy());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate cameraUpdate, int i, CancelableCallback cancelableCallback) {
        try {
            this.zzbmY.animateCameraWithDurationAndCallback(cameraUpdate.zzIy(), i, cancelableCallback == null ? null : new zza(cancelableCallback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate cameraUpdate, CancelableCallback cancelableCallback) {
        try {
            this.zzbmY.animateCameraWithCallback(cameraUpdate.zzIy(), cancelableCallback == null ? null : new zza(cancelableCallback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void clear() {
        try {
            this.zzbmY.clear();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final CameraPosition getCameraPosition() {
        try {
            return this.zzbmY.getCameraPosition();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public IndoorBuilding getFocusedBuilding() {
        try {
            zzd focusedBuilding = this.zzbmY.getFocusedBuilding();
            return focusedBuilding != null ? new IndoorBuilding(focusedBuilding) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int getMapType() {
        try {
            return this.zzbmY.getMapType();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getMaxZoomLevel() {
        try {
            return this.zzbmY.getMaxZoomLevel();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getMinZoomLevel() {
        try {
            return this.zzbmY.getMinZoomLevel();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Deprecated
    public final Location getMyLocation() {
        try {
            return this.zzbmY.getMyLocation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Projection getProjection() {
        try {
            return new Projection(this.zzbmY.getProjection());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final UiSettings getUiSettings() {
        try {
            if (this.zzbmZ == null) {
                this.zzbmZ = new UiSettings(this.zzbmY.getUiSettings());
            }
            return this.zzbmZ;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isBuildingsEnabled() {
        try {
            return this.zzbmY.isBuildingsEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isIndoorEnabled() {
        try {
            return this.zzbmY.isIndoorEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isMyLocationEnabled() {
        try {
            return this.zzbmY.isMyLocationEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isTrafficEnabled() {
        try {
            return this.zzbmY.isTrafficEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void moveCamera(CameraUpdate cameraUpdate) {
        try {
            this.zzbmY.moveCamera(cameraUpdate.zzIy());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void resetMinMaxZoomPreference() {
        try {
            this.zzbmY.resetMinMaxZoomPreference();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setBuildingsEnabled(boolean z) {
        try {
            this.zzbmY.setBuildingsEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setContentDescription(String str) {
        try {
            this.zzbmY.setContentDescription(str);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean setIndoorEnabled(boolean z) {
        try {
            return this.zzbmY.setIndoorEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setInfoWindowAdapter(InfoWindowAdapter infoWindowAdapter) {
        if (infoWindowAdapter == null) {
            try {
                this.zzbmY.setInfoWindowAdapter(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzbmY.setInfoWindowAdapter(new 7(this, infoWindowAdapter));
    }

    public void setLatLngBoundsForCameraTarget(LatLngBounds latLngBounds) {
        try {
            this.zzbmY.setLatLngBoundsForCameraTarget(latLngBounds);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setLocationSource(LocationSource locationSource) {
        if (locationSource == null) {
            try {
                this.zzbmY.setLocationSource(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzbmY.setLocationSource(new 12(this, locationSource));
    }

    public boolean setMapStyle(MapStyleOptions mapStyleOptions) {
        try {
            return this.zzbmY.setMapStyle(mapStyleOptions);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setMapType(int i) {
        try {
            this.zzbmY.setMapType(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setMaxZoomPreference(float f) {
        try {
            this.zzbmY.setMaxZoomPreference(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setMinZoomPreference(float f) {
        try {
            this.zzbmY.setMinZoomPreference(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public final void setMyLocationEnabled(boolean z) {
        try {
            this.zzbmY.setMyLocationEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Deprecated
    public final void setOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener) {
        if (onCameraChangeListener == null) {
            try {
                this.zzbmY.setOnCameraChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzbmY.setOnCameraChangeListener(new 18(this, onCameraChangeListener));
    }

    public final void setOnCameraIdleListener(OnCameraIdleListener onCameraIdleListener) {
        if (onCameraIdleListener == null) {
            try {
                this.zzbmY.setOnCameraIdleListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzbmY.setOnCameraIdleListener(new 22(this, onCameraIdleListener));
    }

    public final void setOnCameraMoveCanceledListener(OnCameraMoveCanceledListener onCameraMoveCanceledListener) {
        if (onCameraMoveCanceledListener == null) {
            try {
                this.zzbmY.setOnCameraMoveCanceledListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzbmY.setOnCameraMoveCanceledListener(new 21(this, onCameraMoveCanceledListener));
    }

    public final void setOnCameraMoveListener(OnCameraMoveListener onCameraMoveListener) {
        if (onCameraMoveListener == null) {
            try {
                this.zzbmY.setOnCameraMoveListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzbmY.setOnCameraMoveListener(new 20(this, onCameraMoveListener));
    }

    public final void setOnCameraMoveStartedListener(OnCameraMoveStartedListener onCameraMoveStartedListener) {
        if (onCameraMoveStartedListener == null) {
            try {
                this.zzbmY.setOnCameraMoveStartedListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzbmY.setOnCameraMoveStartedListener(new 19(this, onCameraMoveStartedListener));
    }

    public final void setOnCircleClickListener(OnCircleClickListener onCircleClickListener) {
        if (onCircleClickListener == null) {
            try {
                this.zzbmY.setOnCircleClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzbmY.setOnCircleClickListener(new 13(this, onCircleClickListener));
    }

    public final void setOnGroundOverlayClickListener(OnGroundOverlayClickListener onGroundOverlayClickListener) {
        if (onGroundOverlayClickListener == null) {
            try {
                this.zzbmY.setOnGroundOverlayClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzbmY.setOnGroundOverlayClickListener(new 11(this, onGroundOverlayClickListener));
    }

    public final void setOnIndoorStateChangeListener(OnIndoorStateChangeListener onIndoorStateChangeListener) {
        if (onIndoorStateChangeListener == null) {
            try {
                this.zzbmY.setOnIndoorStateChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzbmY.setOnIndoorStateChangeListener(new 1(this, onIndoorStateChangeListener));
    }

    public final void setOnInfoWindowClickListener(OnInfoWindowClickListener onInfoWindowClickListener) {
        if (onInfoWindowClickListener == null) {
            try {
                this.zzbmY.setOnInfoWindowClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzbmY.setOnInfoWindowClickListener(new 4(this, onInfoWindowClickListener));
    }

    public final void setOnInfoWindowCloseListener(OnInfoWindowCloseListener onInfoWindowCloseListener) {
        if (onInfoWindowCloseListener == null) {
            try {
                this.zzbmY.setOnInfoWindowCloseListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzbmY.setOnInfoWindowCloseListener(new 6(this, onInfoWindowCloseListener));
    }

    public final void setOnInfoWindowLongClickListener(OnInfoWindowLongClickListener onInfoWindowLongClickListener) {
        if (onInfoWindowLongClickListener == null) {
            try {
                this.zzbmY.setOnInfoWindowLongClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzbmY.setOnInfoWindowLongClickListener(new 5(this, onInfoWindowLongClickListener));
    }

    public final void setOnMapClickListener(OnMapClickListener onMapClickListener) {
        if (onMapClickListener == null) {
            try {
                this.zzbmY.setOnMapClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzbmY.setOnMapClickListener(new 23(this, onMapClickListener));
    }

    public void setOnMapLoadedCallback(OnMapLoadedCallback onMapLoadedCallback) {
        if (onMapLoadedCallback == null) {
            try {
                this.zzbmY.setOnMapLoadedCallback(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzbmY.setOnMapLoadedCallback(new 10(this, onMapLoadedCallback));
    }

    public final void setOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) {
        if (onMapLongClickListener == null) {
            try {
                this.zzbmY.setOnMapLongClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzbmY.setOnMapLongClickListener(new 24(this, onMapLongClickListener));
    }

    public final void setOnMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
        if (onMarkerClickListener == null) {
            try {
                this.zzbmY.setOnMarkerClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzbmY.setOnMarkerClickListener(new 2(this, onMarkerClickListener));
    }

    public final void setOnMarkerDragListener(OnMarkerDragListener onMarkerDragListener) {
        if (onMarkerDragListener == null) {
            try {
                this.zzbmY.setOnMarkerDragListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzbmY.setOnMarkerDragListener(new 3(this, onMarkerDragListener));
    }

    public final void setOnMyLocationButtonClickListener(OnMyLocationButtonClickListener onMyLocationButtonClickListener) {
        if (onMyLocationButtonClickListener == null) {
            try {
                this.zzbmY.setOnMyLocationButtonClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzbmY.setOnMyLocationButtonClickListener(new 9(this, onMyLocationButtonClickListener));
    }

    @Deprecated
    public final void setOnMyLocationChangeListener(OnMyLocationChangeListener onMyLocationChangeListener) {
        if (onMyLocationChangeListener == null) {
            try {
                this.zzbmY.setOnMyLocationChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzbmY.setOnMyLocationChangeListener(new 8(this, onMyLocationChangeListener));
    }

    public final void setOnPoiClickListener(OnPoiClickListener onPoiClickListener) {
        if (onPoiClickListener == null) {
            try {
                this.zzbmY.setOnPoiClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzbmY.setOnPoiClickListener(new 17(this, onPoiClickListener));
    }

    public final void setOnPolygonClickListener(OnPolygonClickListener onPolygonClickListener) {
        if (onPolygonClickListener == null) {
            try {
                this.zzbmY.setOnPolygonClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzbmY.setOnPolygonClickListener(new 14(this, onPolygonClickListener));
    }

    public final void setOnPolylineClickListener(OnPolylineClickListener onPolylineClickListener) {
        if (onPolylineClickListener == null) {
            try {
                this.zzbmY.setOnPolylineClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzbmY.setOnPolylineClickListener(new 15(this, onPolylineClickListener));
    }

    public final void setPadding(int i, int i2, int i3, int i4) {
        try {
            this.zzbmY.setPadding(i, i2, i3, i4);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setTrafficEnabled(boolean z) {
        try {
            this.zzbmY.setTrafficEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void snapshot(SnapshotReadyCallback snapshotReadyCallback) {
        snapshot(snapshotReadyCallback, null);
    }

    public final void snapshot(SnapshotReadyCallback snapshotReadyCallback, Bitmap bitmap) {
        try {
            this.zzbmY.snapshot(new 16(this, snapshotReadyCallback), (zze) (bitmap != null ? zze.zzA(bitmap) : null));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void stopAnimation() {
        try {
            this.zzbmY.stopAnimation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
