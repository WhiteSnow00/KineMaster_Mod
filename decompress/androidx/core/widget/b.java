// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.widget;

import android.os.Build$VERSION;

public interface b
{
    public static final boolean k = Build$VERSION.SDK_INT >= 27;
    
    void setAutoSizeTextTypeUniformWithConfiguration(final int p0, final int p1, final int p2, final int p3) throws IllegalArgumentException;
}
