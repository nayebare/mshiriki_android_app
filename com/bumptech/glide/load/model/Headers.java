package com.bumptech.glide.load.model;

import com.bumptech.glide.load.model.LazyHeaders.Builder;
import java.util.Collections;
import java.util.Map;

public interface Headers {
    public static final Headers DEFAULT;
    @Deprecated
    public static final Headers NONE;

    /* renamed from: com.bumptech.glide.load.model.Headers.1 */
    static class C04431 implements Headers {
        C04431() {
        }

        public Map<String, String> getHeaders() {
            return Collections.emptyMap();
        }
    }

    Map<String, String> getHeaders();

    static {
        NONE = new C04431();
        DEFAULT = new Builder().build();
    }
}
