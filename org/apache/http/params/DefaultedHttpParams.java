package org.apache.http.params;

import java.util.HashSet;
import java.util.Set;

public final class DefaultedHttpParams extends AbstractHttpParams {
    private final HttpParams defaults;
    private final HttpParams local;

    public DefaultedHttpParams(HttpParams local, HttpParams defaults) {
        if (local == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        this.local = local;
        this.defaults = defaults;
    }

    @Deprecated
    public HttpParams copy() {
        return new DefaultedHttpParams(this.local.copy(), this.defaults);
    }

    public Object getParameter(String name) {
        Object obj = this.local.getParameter(name);
        if (obj != null || this.defaults == null) {
            return obj;
        }
        return this.defaults.getParameter(name);
    }

    public boolean removeParameter(String name) {
        return this.local.removeParameter(name);
    }

    public HttpParams setParameter(String name, Object value) {
        return this.local.setParameter(name, value);
    }

    @Deprecated
    public HttpParams getDefaults() {
        return this.defaults;
    }

    public Set<String> getNames() {
        Set<String> combined = new HashSet(getNames(this.defaults));
        combined.addAll(getNames(this.local));
        return combined;
    }

    public Set<String> getDefaultNames() {
        return new HashSet(getNames(this.defaults));
    }

    public Set<String> getLocalNames() {
        return new HashSet(getNames(this.local));
    }

    private Set<String> getNames(HttpParams params) {
        if (params instanceof HttpParamsNames) {
            return ((HttpParamsNames) params).getNames();
        }
        throw new UnsupportedOperationException("HttpParams instance does not implement HttpParamsNames");
    }
}
