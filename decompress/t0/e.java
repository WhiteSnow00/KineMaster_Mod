// 
// Decompiled by Procyon v0.6.0
// 

package t0;

public class e
{
    public static void a(final Exception ex) {
        b(ex);
    }
    
    private static <E extends Throwable> void b(final Throwable t) throws E, Throwable {
        throw t;
    }
}
