// 
// Decompiled by Procyon v0.6.0
// 

package u2;

import java.security.MessageDigest;
import c2.b;

public final class c implements b
{
    private static final c b;
    
    static {
        b = new c();
    }
    
    private c() {
    }
    
    public static c c() {
        return c.b;
    }
    
    @Override
    public void b(final MessageDigest messageDigest) {
    }
    
    @Override
    public String toString() {
        return "EmptySignature";
    }
}
