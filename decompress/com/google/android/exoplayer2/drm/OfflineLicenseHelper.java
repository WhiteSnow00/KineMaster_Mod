// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.Format;

public final class OfflineLicenseHelper
{
    private static final Format a;
    
    static {
        a = new Format.Builder().M(new DrmInitData(new DrmInitData.SchemeData[0])).E();
    }
}
