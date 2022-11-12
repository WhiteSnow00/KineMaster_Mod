// 
// Decompiled by Procyon v0.6.0
// 

package b4;

import com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource;

public final class a implements Runnable
{
    public final SsMediaSource a;
    
    public a(final SsMediaSource a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        SsMediaSource.p0(this.a);
    }
}
