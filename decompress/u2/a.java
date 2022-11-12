// 
// Decompiled by Procyon v0.6.0
// 

package u2;

import v2.l;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import android.content.Context;
import c2.b;

public final class a implements b
{
    private final int b;
    private final b c;
    
    private a(final int b, final b c) {
        this.b = b;
        this.c = c;
    }
    
    public static b c(final Context context) {
        return new a(context.getResources().getConfiguration().uiMode & 0x30, u2.b.c(context));
    }
    
    @Override
    public void b(final MessageDigest messageDigest) {
        this.c.b(messageDigest);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.b).array());
    }
    
    @Override
    public boolean equals(final Object o) {
        final boolean b = o instanceof a;
        boolean b3;
        final boolean b2 = b3 = false;
        if (b) {
            final a a = (a)o;
            b3 = b2;
            if (this.b == a.b) {
                b3 = b2;
                if (this.c.equals(a.c)) {
                    b3 = true;
                }
            }
        }
        return b3;
    }
    
    @Override
    public int hashCode() {
        return l.p(this.c, this.b);
    }
}
