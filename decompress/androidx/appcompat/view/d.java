// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.view;

import d.i;
import android.content.res.AssetManager;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.content.res.Resources$Theme;
import android.content.res.Configuration;
import android.content.ContextWrapper;

public class d extends ContextWrapper
{
    private static Configuration f;
    private int a;
    private Resources$Theme b;
    private LayoutInflater c;
    private Configuration d;
    private Resources e;
    
    public d() {
        super((Context)null);
    }
    
    public d(final Context context, final int a) {
        super(context);
        this.a = a;
    }
    
    public d(final Context context, final Resources$Theme b) {
        super(context);
        this.b = b;
    }
    
    private Resources b() {
        if (this.e == null) {
            final Configuration d = this.d;
            if (d != null && !e(d)) {
                this.e = androidx.appcompat.view.d.a.a(this, this.d).getResources();
            }
            else {
                this.e = super.getResources();
            }
        }
        return this.e;
    }
    
    private void d() {
        final boolean b = this.b == null;
        if (b) {
            this.b = this.getResources().newTheme();
            final Resources$Theme theme = this.getBaseContext().getTheme();
            if (theme != null) {
                this.b.setTo(theme);
            }
        }
        this.f(this.b, this.a, b);
    }
    
    private static boolean e(final Configuration configuration) {
        if (configuration == null) {
            return true;
        }
        if (d.f == null) {
            final Configuration f = new Configuration();
            f.fontScale = 0.0f;
            d.f = f;
        }
        return configuration.equals(d.f);
    }
    
    public void a(final Configuration configuration) {
        if (this.e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.d == null) {
            this.d = new Configuration(configuration);
            return;
        }
        throw new IllegalStateException("Override configuration has already been set");
    }
    
    protected void attachBaseContext(final Context context) {
        super.attachBaseContext(context);
    }
    
    public int c() {
        return this.a;
    }
    
    protected void f(final Resources$Theme resources$Theme, final int n, final boolean b) {
        resources$Theme.applyStyle(n, true);
    }
    
    public AssetManager getAssets() {
        return this.getResources().getAssets();
    }
    
    public Resources getResources() {
        return this.b();
    }
    
    public Object getSystemService(final String s) {
        if ("layout_inflater".equals(s)) {
            if (this.c == null) {
                this.c = LayoutInflater.from(this.getBaseContext()).cloneInContext((Context)this);
            }
            return this.c;
        }
        return this.getBaseContext().getSystemService(s);
    }
    
    public Resources$Theme getTheme() {
        final Resources$Theme b = this.b;
        if (b != null) {
            return b;
        }
        if (this.a == 0) {
            this.a = i.d;
        }
        this.d();
        return this.b;
    }
    
    public void setTheme(final int a) {
        if (this.a != a) {
            this.a = a;
            this.d();
        }
    }
    
    static class a
    {
        static Context a(final d d, final Configuration configuration) {
            return d.createConfigurationContext(configuration);
        }
    }
}
