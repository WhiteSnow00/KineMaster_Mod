// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.util.Util;
import java.util.UUID;
import com.google.android.exoplayer2.decoder.CryptoConfig;

public final class FrameworkCryptoConfig implements CryptoConfig
{
    public static final boolean d;
    public final UUID a;
    public final byte[] b;
    public final boolean c;
    
    static {
        boolean d3 = false;
        Label_0040: {
            if ("Amazon".equals(Util.c)) {
                final String d2 = Util.d;
                if ("AFTM".equals(d2) || "AFTB".equals(d2)) {
                    d3 = true;
                    break Label_0040;
                }
            }
            d3 = false;
        }
        d = d3;
    }
    
    public FrameworkCryptoConfig(final UUID a, final byte[] b, final boolean c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
