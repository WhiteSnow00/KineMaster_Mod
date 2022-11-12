// 
// Decompiled by Procyon v0.6.0
// 

package androidx.preference;

import androidx.core.content.res.i;
import android.util.AttributeSet;
import android.content.Context;

public final class PreferenceScreen extends PreferenceGroup
{
    private boolean j0;
    
    public PreferenceScreen(final Context context, final AttributeSet set) {
        super(context, set, androidx.core.content.res.i.a(context, m.g, 16842891));
        this.j0 = true;
    }
    
    @Override
    protected void Z() {
        if (this.q() == null && this.o() == null) {
            if (this.b1() != 0) {
                final j.b g = this.C().g();
                if (g != null) {
                    g.q1(this);
                }
            }
        }
    }
    
    @Override
    protected boolean c1() {
        return false;
    }
    
    public boolean j1() {
        return this.j0;
    }
}
