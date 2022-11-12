// 
// Decompiled by Procyon v0.6.0
// 

package androidx.fragment.app;

import android.content.IntentSender$SendIntentException;
import androidx.core.app.b;
import android.content.IntentSender;
import androidx.core.content.a;
import android.os.Bundle;
import android.content.Intent;
import android.view.LayoutInflater;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import android.view.View;
import androidx.core.util.h;
import android.os.Handler;
import android.content.Context;
import android.app.Activity;

public abstract class m<E> extends j
{
    private final Activity a;
    private final Context b;
    private final Handler c;
    private final int d;
    final FragmentManager e;
    
    m(final Activity a, final Context context, final Handler handler, final int d) {
        this.e = new w();
        this.a = a;
        this.b = h.h(context, "context == null");
        this.c = h.h(handler, "handler == null");
        this.d = d;
    }
    
    m(final androidx.fragment.app.h h) {
        this(h, (Context)h, new Handler(), 0);
    }
    
    @Override
    public View c(final int n) {
        return null;
    }
    
    @Override
    public boolean d() {
        return true;
    }
    
    Activity e() {
        return this.a;
    }
    
    Context f() {
        return this.b;
    }
    
    public Handler g() {
        return this.c;
    }
    
    public void h(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
    }
    
    public abstract E i();
    
    public LayoutInflater j() {
        return LayoutInflater.from(this.b);
    }
    
    @Deprecated
    public void k(final Fragment fragment, final String[] array, final int n) {
    }
    
    public boolean l(final String s) {
        return false;
    }
    
    public void m(final Fragment fragment, final Intent intent, final int n, final Bundle bundle) {
        if (n == -1) {
            androidx.core.content.a.startActivity(this.b, intent, bundle);
            return;
        }
        throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
    }
    
    @Deprecated
    public void n(final Fragment fragment, final IntentSender intentSender, final int n, final Intent intent, final int n2, final int n3, final int n4, final Bundle bundle) throws IntentSender$SendIntentException {
        if (n == -1) {
            androidx.core.app.b.l(this.a, intentSender, n, intent, n2, n3, n4, bundle);
            return;
        }
        throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
    }
    
    public void o() {
    }
}
