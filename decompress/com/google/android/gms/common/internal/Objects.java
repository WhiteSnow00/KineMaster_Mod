// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.Collection;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class Objects
{
    private Objects() {
        throw new AssertionError((Object)"Uninstantiable");
    }
    
    @KeepForSdk
    public static boolean a(final Bundle bundle, final Bundle bundle2) {
        if (bundle == null || bundle2 == null) {
            return bundle == bundle2;
        }
        if (bundle.size() != bundle2.size()) {
            return false;
        }
        final Set keySet = bundle.keySet();
        if (!keySet.containsAll(bundle2.keySet())) {
            return false;
        }
        for (final String s : keySet) {
            if (!b(bundle.get(s), bundle2.get(s))) {
                return false;
            }
        }
        return true;
    }
    
    @KeepForSdk
    public static boolean b(final Object o, final Object o2) {
        boolean b = false;
        if (o != o2) {
            if (o == null) {
                return b;
            }
            if (!o.equals(o2)) {
                return false;
            }
        }
        b = true;
        return b;
    }
    
    @KeepForSdk
    public static int c(final Object... array) {
        return Arrays.hashCode(array);
    }
    
    @KeepForSdk
    public static ToStringHelper d(final Object o) {
        return new ToStringHelper(o, null);
    }
    
    @KeepForSdk
    public static final class ToStringHelper
    {
        private final List a;
        private final Object b;
        
        ToStringHelper(final Object b, final zzah zzah) {
            Preconditions.k(b);
            this.b = b;
            this.a = new ArrayList();
        }
        
        @KeepForSdk
        @CanIgnoreReturnValue
        public ToStringHelper a(final String s, final Object o) {
            final List a = this.a;
            Preconditions.k(s);
            final String value = String.valueOf(o);
            final StringBuilder sb = new StringBuilder();
            sb.append(s);
            sb.append("=");
            sb.append(value);
            a.add(sb.toString());
            return this;
        }
        
        @KeepForSdk
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder(100);
            sb.append(this.b.getClass().getSimpleName());
            sb.append('{');
            for (int size = this.a.size(), i = 0; i < size; ++i) {
                sb.append((String)this.a.get(i));
                if (i < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append('}');
            return sb.toString();
        }
    }
}
