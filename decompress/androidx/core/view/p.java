// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.view;

import android.view.MotionEvent;

public final class p
{
    public static boolean a(final MotionEvent motionEvent, final int n) {
        return (motionEvent.getSource() & n) == n;
    }
}
