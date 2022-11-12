// 
// Decompiled by Procyon v0.6.0
// 

package c2;

import java.security.MessageDigest;
import java.nio.charset.Charset;

public interface b
{
    public static final Charset a = Charset.forName("UTF-8");
    
    void b(final MessageDigest p0);
    
    boolean equals(final Object p0);
    
    int hashCode();
}
