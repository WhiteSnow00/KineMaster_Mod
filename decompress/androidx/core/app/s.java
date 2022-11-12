// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.app;

import android.content.res.Configuration;

public final class s
{
    private final boolean a;
    private final Configuration b;
    
    public s(final boolean a) {
        this.a = a;
        this.b = null;
    }
    
    public s(final boolean a, final Configuration b) {
        this.a = a;
        this.b = b;
    }
    
    public boolean a() {
        return this.a;
    }
}
