// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream.cache;

import java.io.IOException;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Assertions;
import java.io.OutputStream;
import java.io.BufferedOutputStream;

final class e extends BufferedOutputStream
{
    private boolean a;
    
    public e(final OutputStream outputStream) {
        super(outputStream);
    }
    
    public e(final OutputStream outputStream, final int n) {
        super(outputStream, n);
    }
    
    public void a(final OutputStream out) {
        Assertions.g(this.a);
        super.out = out;
        super.count = 0;
        this.a = false;
    }
    
    @Override
    public void close() throws IOException {
        this.a = true;
        try {
            this.flush();
        }
        finally {}
        Throwable t = null;
        try {
            super.out.close();
        }
        finally {
            final Throwable t2;
            t = t2;
            if (t2 == null) {
                final Throwable t3;
                t = t3;
            }
        }
        if (t != null) {
            Util.R0(t);
        }
    }
}
