package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.github.mikephil.charting.BuildConfig;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.internal.zzsw;
import com.google.android.gms.internal.zztg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HitBuilders {

    protected static class HitBuilder<T extends HitBuilder> {
        private Map<String, String> zzaaM;
        ProductAction zzaaN;
        Map<String, List<Product>> zzaaO;
        List<Promotion> zzaaP;
        List<Product> zzaaQ;

        protected HitBuilder() {
            this.zzaaM = new HashMap();
            this.zzaaO = new HashMap();
            this.zzaaP = new ArrayList();
            this.zzaaQ = new ArrayList();
        }

        private T zzn(String str, String str2) {
            if (str == null) {
                zzsw.zzbe("HitBuilder.setIfNonNull() called with a null paramName.");
            } else if (str2 != null) {
                this.zzaaM.put(str, str2);
            }
            return this;
        }

        public T addImpression(Product product, String str) {
            if (product == null) {
                zzsw.zzbe("product should be non-null");
            } else {
                Object obj;
                if (str == null) {
                    obj = BuildConfig.FLAVOR;
                }
                if (!this.zzaaO.containsKey(obj)) {
                    this.zzaaO.put(obj, new ArrayList());
                }
                ((List) this.zzaaO.get(obj)).add(product);
            }
            return this;
        }

        public T addProduct(Product product) {
            if (product == null) {
                zzsw.zzbe("product should be non-null");
            } else {
                this.zzaaQ.add(product);
            }
            return this;
        }

        public T addPromotion(Promotion promotion) {
            if (promotion == null) {
                zzsw.zzbe("promotion should be non-null");
            } else {
                this.zzaaP.add(promotion);
            }
            return this;
        }

        public Map<String, String> build() {
            Map<String, String> hashMap = new HashMap(this.zzaaM);
            if (this.zzaaN != null) {
                hashMap.putAll(this.zzaaN.build());
            }
            int i = 1;
            for (Promotion zzbL : this.zzaaP) {
                hashMap.putAll(zzbL.zzbL(zzc.zzar(i)));
                i++;
            }
            i = 1;
            for (Product zzbL2 : this.zzaaQ) {
                hashMap.putAll(zzbL2.zzbL(zzc.zzap(i)));
                i++;
            }
            int i2 = 1;
            for (Entry entry : this.zzaaO.entrySet()) {
                List<Product> list = (List) entry.getValue();
                String zzau = zzc.zzau(i2);
                int i3 = 1;
                for (Product product : list) {
                    String valueOf = String.valueOf(zzau);
                    String valueOf2 = String.valueOf(zzc.zzat(i3));
                    hashMap.putAll(product.zzbL(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)));
                    i3++;
                }
                if (!TextUtils.isEmpty((CharSequence) entry.getKey())) {
                    String valueOf3 = String.valueOf(zzau);
                    String valueOf4 = String.valueOf("nm");
                    hashMap.put(valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3), (String) entry.getKey());
                }
                i2++;
            }
            return hashMap;
        }

        protected String get(String str) {
            return (String) this.zzaaM.get(str);
        }

        public final T set(String str, String str2) {
            if (str != null) {
                this.zzaaM.put(str, str2);
            } else {
                zzsw.zzbe("HitBuilder.set() called with a null paramName.");
            }
            return this;
        }

        public final T setAll(Map<String, String> map) {
            if (map != null) {
                this.zzaaM.putAll(new HashMap(map));
            }
            return this;
        }

        public T setCampaignParamsFromUrl(String str) {
            Object zzcf = zztg.zzcf(str);
            if (!TextUtils.isEmpty(zzcf)) {
                Map zzcd = zztg.zzcd(zzcf);
                zzn("&cc", (String) zzcd.get("utm_content"));
                zzn("&cm", (String) zzcd.get("utm_medium"));
                zzn("&cn", (String) zzcd.get("utm_campaign"));
                zzn("&cs", (String) zzcd.get("utm_source"));
                zzn("&ck", (String) zzcd.get("utm_term"));
                zzn("&ci", (String) zzcd.get("utm_id"));
                zzn("&anid", (String) zzcd.get("anid"));
                zzn("&gclid", (String) zzcd.get("gclid"));
                zzn("&dclid", (String) zzcd.get("dclid"));
                zzn("&aclid", (String) zzcd.get("aclid"));
                zzn("&gmob_t", (String) zzcd.get("gmob_t"));
            }
            return this;
        }

        public T setCustomDimension(int i, String str) {
            set(zzc.zzal(i), str);
            return this;
        }

        public T setCustomMetric(int i, float f) {
            set(zzc.zzan(i), Float.toString(f));
            return this;
        }

        protected T setHitType(String str) {
            set("&t", str);
            return this;
        }

        public T setNewSession() {
            set("&sc", "start");
            return this;
        }

        public T setNonInteraction(boolean z) {
            set("&ni", zztg.zzW(z));
            return this;
        }

        public T setProductAction(ProductAction productAction) {
            this.zzaaN = productAction;
            return this;
        }

        public T setPromotionAction(String str) {
            this.zzaaM.put("&promoa", str);
            return this;
        }
    }

    @Deprecated
    public static class AppViewBuilder extends HitBuilder<AppViewBuilder> {
        public AppViewBuilder() {
            set("&t", "screenview");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }
    }

    public static class EventBuilder extends HitBuilder<EventBuilder> {
        public EventBuilder() {
            set("&t", NotificationCompatApi24.CATEGORY_EVENT);
        }

        public EventBuilder(String str, String str2) {
            this();
            setCategory(str);
            setAction(str2);
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public EventBuilder setAction(String str) {
            set("&ea", str);
            return this;
        }

        public EventBuilder setCategory(String str) {
            set("&ec", str);
            return this;
        }

        public EventBuilder setLabel(String str) {
            set("&el", str);
            return this;
        }

        public EventBuilder setValue(long j) {
            set("&ev", Long.toString(j));
            return this;
        }
    }

    public static class ExceptionBuilder extends HitBuilder<ExceptionBuilder> {
        public ExceptionBuilder() {
            set("&t", "exception");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public ExceptionBuilder setDescription(String str) {
            set("&exd", str);
            return this;
        }

        public ExceptionBuilder setFatal(boolean z) {
            set("&exf", zztg.zzW(z));
            return this;
        }
    }

    @Deprecated
    public static class ItemBuilder extends HitBuilder<ItemBuilder> {
        public ItemBuilder() {
            set("&t", "item");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public ItemBuilder setCategory(String str) {
            set("&iv", str);
            return this;
        }

        public ItemBuilder setCurrencyCode(String str) {
            set("&cu", str);
            return this;
        }

        public ItemBuilder setName(String str) {
            set("&in", str);
            return this;
        }

        public ItemBuilder setPrice(double d) {
            set("&ip", Double.toString(d));
            return this;
        }

        public ItemBuilder setQuantity(long j) {
            set("&iq", Long.toString(j));
            return this;
        }

        public ItemBuilder setSku(String str) {
            set("&ic", str);
            return this;
        }

        public ItemBuilder setTransactionId(String str) {
            set("&ti", str);
            return this;
        }
    }

    public static class ScreenViewBuilder extends HitBuilder<ScreenViewBuilder> {
        public ScreenViewBuilder() {
            set("&t", "screenview");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }
    }

    public static class SocialBuilder extends HitBuilder<SocialBuilder> {
        public SocialBuilder() {
            set("&t", NotificationCompatApi24.CATEGORY_SOCIAL);
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public SocialBuilder setAction(String str) {
            set("&sa", str);
            return this;
        }

        public SocialBuilder setNetwork(String str) {
            set("&sn", str);
            return this;
        }

        public SocialBuilder setTarget(String str) {
            set("&st", str);
            return this;
        }
    }

    public static class TimingBuilder extends HitBuilder<TimingBuilder> {
        public TimingBuilder() {
            set("&t", "timing");
        }

        public TimingBuilder(String str, String str2, long j) {
            this();
            setVariable(str2);
            setValue(j);
            setCategory(str);
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public TimingBuilder setCategory(String str) {
            set("&utc", str);
            return this;
        }

        public TimingBuilder setLabel(String str) {
            set("&utl", str);
            return this;
        }

        public TimingBuilder setValue(long j) {
            set("&utt", Long.toString(j));
            return this;
        }

        public TimingBuilder setVariable(String str) {
            set("&utv", str);
            return this;
        }
    }

    @Deprecated
    public static class TransactionBuilder extends HitBuilder<TransactionBuilder> {
        public TransactionBuilder() {
            set("&t", "transaction");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public TransactionBuilder setAffiliation(String str) {
            set("&ta", str);
            return this;
        }

        public TransactionBuilder setCurrencyCode(String str) {
            set("&cu", str);
            return this;
        }

        public TransactionBuilder setRevenue(double d) {
            set("&tr", Double.toString(d));
            return this;
        }

        public TransactionBuilder setShipping(double d) {
            set("&ts", Double.toString(d));
            return this;
        }

        public TransactionBuilder setTax(double d) {
            set("&tt", Double.toString(d));
            return this;
        }

        public TransactionBuilder setTransactionId(String str) {
            set("&ti", str);
            return this;
        }
    }
}
