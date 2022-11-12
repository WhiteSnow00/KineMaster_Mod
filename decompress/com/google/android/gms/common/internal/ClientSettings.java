// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import androidx.collection.b;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import java.util.Iterator;
import java.util.Collection;
import java.util.HashSet;
import java.util.Collections;
import com.google.android.gms.signin.SignInOptions;
import android.view.View;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import android.accounts.Account;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
@VisibleForTesting
public final class ClientSettings
{
    @Nullable
    private final Account a;
    private final Set b;
    private final Set c;
    private final Map d;
    private final int e;
    @Nullable
    private final View f;
    private final String g;
    private final String h;
    private final SignInOptions i;
    private Integer j;
    
    public ClientSettings(@Nullable final Account a, Set b, final Map map, final int e, @Nullable final View f, final String g, final String h, @Nullable final SignInOptions signInOptions, final boolean b2) {
        this.a = a;
        if (b == null) {
            b = Collections.emptySet();
        }
        else {
            b = Collections.unmodifiableSet((Set<?>)b);
        }
        this.b = (Set)b;
        Map<Object, Object> emptyMap = map;
        if (map == null) {
            emptyMap = (Map<Object, Object>)Collections.emptyMap();
        }
        this.d = emptyMap;
        this.f = f;
        this.e = e;
        this.g = g;
        this.h = h;
        SignInOptions j;
        if ((j = signInOptions) == null) {
            j = SignInOptions.j;
        }
        this.i = j;
        final HashSet set = new HashSet((Collection)b);
        final Iterator<Object> iterator = (Iterator<Object>)emptyMap.values().iterator();
        while (iterator.hasNext()) {
            set.addAll(iterator.next().a);
        }
        this.c = Collections.unmodifiableSet((Set<?>)set);
    }
    
    @KeepForSdk
    public Account a() {
        return this.a;
    }
    
    @Deprecated
    @KeepForSdk
    public String b() {
        final Account a = this.a;
        if (a != null) {
            return a.name;
        }
        return null;
    }
    
    @KeepForSdk
    public Account c() {
        final Account a = this.a;
        if (a != null) {
            return a;
        }
        return new Account("<<default account>>", "com.google");
    }
    
    @KeepForSdk
    public Set<Scope> d() {
        return this.c;
    }
    
    @KeepForSdk
    public Set<Scope> e(final Api<?> api) {
        final zab zab = this.d.get(api);
        if (zab != null && !zab.a.isEmpty()) {
            final HashSet set = new HashSet(this.b);
            set.addAll(zab.a);
            return set;
        }
        return this.b;
    }
    
    @KeepForSdk
    public String f() {
        return this.g;
    }
    
    @KeepForSdk
    public Set<Scope> g() {
        return this.b;
    }
    
    public final SignInOptions h() {
        return this.i;
    }
    
    public final Integer i() {
        return this.j;
    }
    
    public final String j() {
        return this.h;
    }
    
    public final Map k() {
        return this.d;
    }
    
    public final void l(final Integer j) {
        this.j = j;
    }
    
    @KeepForSdk
    public static final class Builder
    {
        @Nullable
        private Account a;
        private b b;
        private String c;
        private String d;
        private SignInOptions e;
        
        public Builder() {
            this.e = SignInOptions.j;
        }
        
        @KeepForSdk
        public ClientSettings a() {
            return new ClientSettings(this.a, this.b, null, 0, null, this.c, this.d, this.e, false);
        }
        
        @KeepForSdk
        @CanIgnoreReturnValue
        public Builder b(final String c) {
            this.c = c;
            return this;
        }
        
        @CanIgnoreReturnValue
        public final Builder c(final Collection collection) {
            if (this.b == null) {
                this.b = new b();
            }
            this.b.addAll(collection);
            return this;
        }
        
        @CanIgnoreReturnValue
        public final Builder d(@Nullable final Account a) {
            this.a = a;
            return this;
        }
        
        @CanIgnoreReturnValue
        public final Builder e(final String d) {
            this.d = d;
            return this;
        }
    }
}
