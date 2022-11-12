// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.app;

import androidx.core.graphics.drawable.IconCompat;
import android.os.Parcelable;
import android.os.Bundle;

class n
{
    private static final Object a;
    private static final Object b;
    
    static {
        a = new Object();
        b = new Object();
    }
    
    static Bundle a(final l.a a) {
        final Bundle bundle = new Bundle();
        final IconCompat d = a.d();
        int i;
        if (d != null) {
            i = d.i();
        }
        else {
            i = 0;
        }
        bundle.putInt("icon", i);
        bundle.putCharSequence("title", a.h());
        bundle.putParcelable("actionIntent", (Parcelable)a.a());
        Bundle bundle2;
        if (a.c() != null) {
            bundle2 = new Bundle(a.c());
        }
        else {
            bundle2 = new Bundle();
        }
        bundle2.putBoolean("android.support.allowGeneratedReplies", a.b());
        bundle.putBundle("extras", bundle2);
        bundle.putParcelableArray("remoteInputs", (Parcelable[])c(a.e()));
        bundle.putBoolean("showsUserInterface", a.g());
        bundle.putInt("semanticAction", a.f());
        return bundle;
    }
    
    private static Bundle b(final t t) {
        new Bundle();
        throw null;
    }
    
    private static Bundle[] c(final t[] array) {
        if (array == null) {
            return null;
        }
        final Bundle[] array2 = new Bundle[array.length];
        for (int i = 0; i < array.length; ++i) {
            final t t = array[i];
            array2[i] = b(null);
        }
        return array2;
    }
}
