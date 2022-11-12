// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import javax.annotation.Nullable;
import java.util.List;

public class RequestConfiguration
{
    public static final List e;
    private final int a;
    private final int b;
    @Nullable
    private final String c;
    private final List d;
    
    static {
        e = Arrays.asList("MA", "T", "PG", "G");
    }
    
    RequestConfiguration(final int a, final int b, final String c, final List d, final zze zze) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public String a() {
        String c;
        if ((c = this.c) == null) {
            c = "";
        }
        return c;
    }
    
    public int b() {
        return this.a;
    }
    
    public int c() {
        return this.b;
    }
    
    public List<String> d() {
        return new ArrayList<String>(this.d);
    }
    
    public static class Builder
    {
        private int a;
        private int b;
        @Nullable
        private String c;
        private final List d;
        
        public Builder() {
            this.a = -1;
            this.b = -1;
            this.c = null;
            this.d = new ArrayList();
        }
        
        public RequestConfiguration a() {
            return new RequestConfiguration(this.a, this.b, this.c, this.d, null);
        }
    }
    
    @Retention(RetentionPolicy.SOURCE)
    public @interface MaxAdContentRating {
    }
    
    @Retention(RetentionPolicy.SOURCE)
    public @interface TagForChildDirectedTreatment {
    }
    
    @Retention(RetentionPolicy.SOURCE)
    public @interface TagForUnderAgeOfConsent {
    }
}
