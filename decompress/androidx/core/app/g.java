// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.app;

import androidx.lifecycle.e0;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import android.view.View;
import android.view.Window$Callback;
import android.view.KeyEvent;
import android.os.Build$VERSION;
import androidx.lifecycle.t;
import androidx.lifecycle.r;
import android.app.Activity;

public class g extends Activity implements r, androidx.core.view.g.a
{
    private androidx.collection.g<Class<? extends a>, a> mExtraDataMap;
    private t mLifecycleRegistry;
    
    public g() {
        this.mExtraDataMap = new androidx.collection.g<Class<? extends a>, a>();
        this.mLifecycleRegistry = new t(this);
    }
    
    private static boolean shouldSkipDump(final String[] array) {
        final boolean b = false;
        final boolean b2 = false;
        boolean b3 = b;
        if (array != null) {
            b3 = b;
            if (array.length > 0) {
                final String s = array[0];
                s.hashCode();
                int n = -1;
                switch (s) {
                    case "--autofill": {
                        n = 2;
                        break;
                    }
                    case "--contentcapture": {
                        n = 1;
                        break;
                    }
                    case "--translation": {
                        n = 0;
                        break;
                    }
                    default:
                        break;
                }
                switch (n) {
                    default: {
                        b3 = b;
                        break;
                    }
                    case 2: {
                        return true;
                    }
                    case 1: {
                        boolean b4 = b2;
                        if (Build$VERSION.SDK_INT >= 29) {
                            b4 = true;
                        }
                        return b4;
                    }
                    case 0: {
                        b3 = b;
                        if (Build$VERSION.SDK_INT >= 31) {
                            b3 = true;
                            break;
                        }
                        break;
                    }
                }
            }
        }
        return b3;
    }
    
    public boolean dispatchKeyEvent(final KeyEvent keyEvent) {
        final View decorView = this.getWindow().getDecorView();
        return (decorView != null && androidx.core.view.g.d(decorView, keyEvent)) || androidx.core.view.g.e((androidx.core.view.g.a)this, decorView, (Window$Callback)this, keyEvent);
    }
    
    public boolean dispatchKeyShortcutEvent(final KeyEvent keyEvent) {
        final View decorView = this.getWindow().getDecorView();
        return (decorView != null && androidx.core.view.g.d(decorView, keyEvent)) || super.dispatchKeyShortcutEvent(keyEvent);
    }
    
    @Deprecated
    public <T extends a> T getExtraData(final Class<T> clazz) {
        return (T)this.mExtraDataMap.get(clazz);
    }
    
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }
    
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        e0.g(this);
    }
    
    protected void onSaveInstanceState(final Bundle bundle) {
        this.mLifecycleRegistry.j(Lifecycle.State.CREATED);
        super.onSaveInstanceState(bundle);
    }
    
    @Deprecated
    public void putExtraData(final a a) {
        this.mExtraDataMap.put(a.getClass(), a);
    }
    
    protected final boolean shouldDumpInternalState(final String[] array) {
        return shouldSkipDump(array) ^ true;
    }
    
    public boolean superDispatchKeyEvent(final KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }
    
    @Deprecated
    public static class a
    {
    }
}
