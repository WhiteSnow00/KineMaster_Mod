// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime;

import com.google.auto.value.AutoValue$Builder;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class EventInternal
{
    public static Builder a() {
        return new a.b().f(new HashMap<String, String>());
    }
    
    public final String b(String s) {
        if ((s = this.c().get(s)) == null) {
            s = "";
        }
        return s;
    }
    
    protected abstract Map<String, String> c();
    
    public abstract Integer d();
    
    public abstract EncodedPayload e();
    
    public abstract long f();
    
    public final int g(String s) {
        s = this.c().get(s);
        int intValue;
        if (s == null) {
            intValue = 0;
        }
        else {
            intValue = Integer.valueOf(s);
        }
        return intValue;
    }
    
    public final long h(String s) {
        s = this.c().get(s);
        long longValue;
        if (s == null) {
            longValue = 0L;
        }
        else {
            longValue = Long.valueOf(s);
        }
        return longValue;
    }
    
    public final Map<String, String> i() {
        return Collections.unmodifiableMap((Map<? extends String, ? extends String>)this.c());
    }
    
    public abstract String j();
    
    public abstract long k();
    
    public Builder l() {
        return new a.b().j(this.j()).g(this.d()).h(this.e()).i(this.f()).k(this.k()).f(new HashMap<String, String>(this.c()));
    }
    
    @AutoValue$Builder
    public abstract static class Builder
    {
        public final Builder a(final String s, final int n) {
            this.e().put(s, String.valueOf(n));
            return this;
        }
        
        public final Builder b(final String s, final long n) {
            this.e().put(s, String.valueOf(n));
            return this;
        }
        
        public final Builder c(final String s, final String s2) {
            this.e().put(s, s2);
            return this;
        }
        
        public abstract EventInternal d();
        
        protected abstract Map<String, String> e();
        
        protected abstract Builder f(final Map<String, String> p0);
        
        public abstract Builder g(final Integer p0);
        
        public abstract Builder h(final EncodedPayload p0);
        
        public abstract Builder i(final long p0);
        
        public abstract Builder j(final String p0);
        
        public abstract Builder k(final long p0);
    }
}
