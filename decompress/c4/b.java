// 
// Decompiled by Procyon v0.6.0
// 

package c4;

import com.google.android.exoplayer2.text.CueGroup;
import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;

public final class b implements Creator
{
    public static final b a;
    
    static {
        a = new b();
    }
    
    private b() {
    }
    
    @Override
    public final Bundleable a(final Bundle bundle) {
        return CueGroup.a(bundle);
    }
}
