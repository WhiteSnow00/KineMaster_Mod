// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.rtsp;

import java.io.IOException;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSourceUtil;

final class y implements Factory
{
    private final long a;
    
    public y(final long a) {
        this.a = a;
    }
    
    @Override
    public RtpDataChannel a(int n) throws IOException {
        final x x = new x(this.a);
        final x x2 = new x(this.a);
        n = 0;
        try {
            x.b(RtpUtils.a(0));
            int d = x.d();
            if (d % 2 == 0) {
                n = 1;
            }
            if (n != 0) {
                ++d;
            }
            else {
                --d;
            }
            x2.b(RtpUtils.a(d));
            if (n != 0) {
                x.j(x2);
                return x;
            }
            x2.j(x);
            return x2;
        }
        catch (final IOException ex) {
            DataSourceUtil.a(x);
            DataSourceUtil.a(x2);
            throw ex;
        }
    }
    
    @Override
    public Factory b() {
        return new w(this.a);
    }
}
