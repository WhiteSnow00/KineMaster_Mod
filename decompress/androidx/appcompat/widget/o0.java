// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import android.content.res.AssetManager;
import android.content.Context;
import android.content.res.Resources$Theme;
import android.content.res.Resources;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import android.content.ContextWrapper;

public class o0 extends ContextWrapper
{
    private static final Object c;
    private static ArrayList<WeakReference<o0>> d;
    private final Resources a;
    private final Resources$Theme b;
    
    static {
        c = new Object();
    }
    
    private o0(final Context context) {
        super(context);
        if (v0.d()) {
            final v0 a = new v0((Context)this, context.getResources());
            this.a = a;
            (this.b = a.newTheme()).setTo(context.getTheme());
        }
        else {
            this.a = new q0((Context)this, context.getResources());
            this.b = null;
        }
    }
    
    private static boolean a(final Context context) {
        final boolean b = context instanceof o0;
        boolean b3;
        final boolean b2 = b3 = false;
        if (!b) {
            b3 = b2;
            if (!(context.getResources() instanceof q0)) {
                if (context.getResources() instanceof v0) {
                    b3 = b2;
                }
                else {
                    b3 = b2;
                    if (v0.d()) {
                        b3 = true;
                    }
                }
            }
        }
        return b3;
    }
    
    public static Context b(final Context context) {
        if (a(context)) {
            synchronized (o0.c) {
                final ArrayList<WeakReference<o0>> d = o0.d;
                if (d == null) {
                    o0.d = new ArrayList<WeakReference<o0>>();
                }
                else {
                    for (int i = d.size() - 1; i >= 0; --i) {
                        final WeakReference weakReference = o0.d.get(i);
                        if (weakReference == null || weakReference.get() == null) {
                            o0.d.remove(i);
                        }
                    }
                    for (int j = o0.d.size() - 1; j >= 0; --j) {
                        final WeakReference weakReference2 = o0.d.get(j);
                        ContextWrapper contextWrapper;
                        if (weakReference2 != null) {
                            contextWrapper = (o0)weakReference2.get();
                        }
                        else {
                            contextWrapper = null;
                        }
                        if (contextWrapper != null && contextWrapper.getBaseContext() == context) {
                            return (Context)contextWrapper;
                        }
                    }
                }
                final o0 o0 = new o0(context);
                androidx.appcompat.widget.o0.d.add(new WeakReference<o0>(o0));
                return (Context)o0;
            }
        }
        return context;
    }
    
    public AssetManager getAssets() {
        return this.a.getAssets();
    }
    
    public Resources getResources() {
        return this.a;
    }
    
    public Resources$Theme getTheme() {
        Resources$Theme resources$Theme;
        if ((resources$Theme = this.b) == null) {
            resources$Theme = super.getTheme();
        }
        return resources$Theme;
    }
    
    public void setTheme(final int theme) {
        final Resources$Theme b = this.b;
        if (b == null) {
            super.setTheme(theme);
        }
        else {
            b.applyStyle(theme, true);
        }
    }
}
