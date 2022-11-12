// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.accounttransfer;

import java.util.List;
import java.util.Collections;
import java.util.Collection;
import java.util.Iterator;
import com.google.android.gms.common.internal.Objects;
import java.util.ArrayList;
import android.os.Bundle;
import com.google.android.gms.common.api.Api;

public final class zzq implements Optional
{
    public static final zzq b;
    private final Bundle a;
    
    static {
        final Bundle bundle = new Bundle();
        if (!bundle.containsKey("accountTypes")) {
            bundle.putStringArrayList("accountTypes", new ArrayList(0));
        }
        b = new zzq(bundle, null);
    }
    
    zzq(final Bundle a, final c c) {
        this.a = a;
    }
    
    public final Bundle a() {
        return new Bundle(this.a);
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzq)) {
            return false;
        }
        final zzq zzq = (zzq)o;
        final Bundle a = this.a();
        final Bundle a2 = zzq.a();
        if (a.size() != a2.size()) {
            return false;
        }
        for (final String s : a.keySet()) {
            if (!a2.containsKey(s)) {
                return false;
            }
            if (!Objects.b(a.get(s), a2.get(s))) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public final int hashCode() {
        final Bundle a = this.a();
        final int size = a.size();
        final ArrayList list = new ArrayList<String>(size + size);
        final ArrayList list2 = new ArrayList<Object>(a.keySet());
        Collections.sort((List<Comparable>)list2);
        for (int size2 = list2.size(), i = 0; i < size2; ++i) {
            final String s = (String)list2.get(i);
            list.add(s);
            list.add((String)a.get(s));
        }
        return Objects.c(list);
    }
}
