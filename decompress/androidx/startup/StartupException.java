// 
// Decompiled by Procyon v0.6.0
// 

package androidx.startup;

public final class StartupException extends RuntimeException
{
    public StartupException(final String s) {
        super(s);
    }
    
    public StartupException(final String s, final Throwable t) {
        super(s, t);
    }
    
    public StartupException(final Throwable t) {
        super(t);
    }
}
