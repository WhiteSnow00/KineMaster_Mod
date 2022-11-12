// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import com.google.android.gms.common.R;
import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class StringResourceValueReader
{
    private final Resources a;
    private final String b;
    
    public StringResourceValueReader(final Context context) {
        Preconditions.k(context);
        final Resources resources = context.getResources();
        this.a = resources;
        this.b = resources.getResourcePackageName(R.string.a);
    }
    
    @KeepForSdk
    public String a(final String s) {
        final int identifier = this.a.getIdentifier(s, "string", this.b);
        if (identifier == 0) {
            return null;
        }
        return this.a.getString(identifier);
    }
}
