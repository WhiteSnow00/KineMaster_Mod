// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import android.os.Bundle;

public interface Bundleable
{
    Bundle toBundle();
    
    public interface Creator<T extends Bundleable>
    {
        T a(final Bundle p0);
    }
}
