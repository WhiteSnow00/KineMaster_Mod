// 
// Decompiled by Procyon v0.6.0
// 

package androidx.preference;

import android.os.Build$VERSION;
import androidx.core.content.res.i;
import android.util.AttributeSet;
import android.content.Context;

public class PreferenceCategory extends PreferenceGroup
{
    public PreferenceCategory(final Context context, final AttributeSet set) {
        this(context, set, androidx.core.content.res.i.a(context, m.e, 16842892));
    }
    
    public PreferenceCategory(final Context context, final AttributeSet set, final int n) {
        this(context, set, n, 0);
    }
    
    public PreferenceCategory(final Context context, final AttributeSet set, final int n, final int n2) {
        super(context, set, n, n2);
    }
    
    @Override
    public boolean N() {
        return false;
    }
    
    @Override
    public boolean P0() {
        return super.N() ^ true;
    }
    
    @Override
    public void Y(final l l) {
        super.Y(l);
        if (Build$VERSION.SDK_INT >= 28) {
            l.itemView.setAccessibilityHeading(true);
        }
    }
}
