// 
// Decompiled by Procyon v0.6.0
// 

package androidx.fragment.app;

import android.util.Log;
import java.io.Writer;

final class h0 extends Writer
{
    private final String a;
    private StringBuilder b;
    
    h0(final String a) {
        this.b = new StringBuilder(128);
        this.a = a;
    }
    
    private void a() {
        if (this.b.length() > 0) {
            Log.d(this.a, this.b.toString());
            final StringBuilder b = this.b;
            b.delete(0, b.length());
        }
    }
    
    @Override
    public void close() {
        this.a();
    }
    
    @Override
    public void flush() {
        this.a();
    }
    
    @Override
    public void write(final char[] array, final int n, final int n2) {
        for (int i = 0; i < n2; ++i) {
            final char c = array[n + i];
            if (c == '\n') {
                this.a();
            }
            else {
                this.b.append(c);
            }
        }
    }
}
