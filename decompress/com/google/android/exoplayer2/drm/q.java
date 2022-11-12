// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.drm;

import android.media.MediaDrm;
import android.media.MediaDrm$OnEventListener;

public final class q implements MediaDrm$OnEventListener
{
    public final FrameworkMediaDrm a;
    public final ExoMediaDrm.OnEventListener b;
    
    public q(final FrameworkMediaDrm a, final ExoMediaDrm.OnEventListener b) {
        this.a = a;
        this.b = b;
    }
    
    public final void onEvent(final MediaDrm mediaDrm, final byte[] array, final int n, final int n2, final byte[] array2) {
        FrameworkMediaDrm.p(this.a, this.b, mediaDrm, array, n, n2, array2);
    }
}
