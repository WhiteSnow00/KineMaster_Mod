// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Scope;
import java.util.Comparator;

final class a implements Comparator
{
    @Override
    public final /* bridge */ int compare(final Object o, final Object o2) {
        return ((Scope)o).K1().compareTo(((Scope)o2).K1());
    }
}
