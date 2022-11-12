// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads;

import com.google.android.gms.common.internal.Preconditions;
import android.content.Context;

public final class AdView extends BaseAdView
{
    public AdView(final Context context) {
        super(context, 0);
        Preconditions.l(context, "Context cannot be null");
    }
    
    public final VideoController e() {
        return super.a.i();
    }
}
