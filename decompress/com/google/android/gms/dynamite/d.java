// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.dynamite;

import android.content.Context;

final class d implements IVersions
{
    @Override
    public final int a(final Context context, final String s, final boolean b) throws LoadingException {
        return DynamiteModule.f(context, s, b);
    }
    
    @Override
    public final int b(final Context context, final String s) {
        return DynamiteModule.a(context, s);
    }
}
