// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.app;

import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.content.res.Configuration;
import androidx.core.app.j;
import android.content.Intent;
import androidx.appcompat.widget.v0;
import android.view.MenuInflater;
import android.app.Activity;
import android.view.ViewGroup$LayoutParams;
import android.view.View;
import android.view.KeyEvent;
import androidx.lifecycle.r0;
import androidx.lifecycle.t0;
import androidx.lifecycle.r;
import androidx.lifecycle.s0;
import android.content.Context;
import b.b;
import android.os.Bundle;
import u0.c;
import android.content.res.Resources;
import androidx.core.app.v;
import androidx.fragment.app.h;

public class d extends h implements e, v.b
{
    private static final String DELEGATE_TAG = "androidx:appcompat";
    private androidx.appcompat.app.f mDelegate;
    private Resources mResources;
    
    public d() {
        this.initDelegate();
    }
    
    public d(final int n) {
        super(n);
        this.initDelegate();
    }
    
    private void initDelegate() {
        this.getSavedStateRegistry().h("androidx:appcompat", (c.c)new c.c(this) {
            final d a;
            
            @Override
            public Bundle saveState() {
                final Bundle bundle = new Bundle();
                this.a.getDelegate().v(bundle);
                return bundle;
            }
        });
        this.addOnContextAvailableListener(new b(this) {
            final d a;
            
            @Override
            public void onContextAvailable(final Context context) {
                final androidx.appcompat.app.f delegate = this.a.getDelegate();
                delegate.o();
                delegate.r(this.a.getSavedStateRegistry().b("androidx:appcompat"));
            }
        });
    }
    
    private void initViewTreeOwners() {
        s0.a(this.getWindow().getDecorView(), this);
        t0.a(this.getWindow().getDecorView(), this);
        u0.f.a(this.getWindow().getDecorView(), this);
    }
    
    private boolean performMenuItemShortcut(final KeyEvent keyEvent) {
        return false;
    }
    
    @Override
    public void addContentView(final View view, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        this.initViewTreeOwners();
        this.getDelegate().d(view, viewGroup$LayoutParams);
    }
    
    protected void attachBaseContext(final Context context) {
        super.attachBaseContext(this.getDelegate().f(context));
    }
    
    public void closeOptionsMenu() {
        final a supportActionBar = this.getSupportActionBar();
        if (this.getWindow().hasFeature(0) && (supportActionBar == null || !supportActionBar.f())) {
            super.closeOptionsMenu();
        }
    }
    
    @Override
    public boolean dispatchKeyEvent(final KeyEvent keyEvent) {
        final int keyCode = keyEvent.getKeyCode();
        final a supportActionBar = this.getSupportActionBar();
        return (keyCode == 82 && supportActionBar != null && supportActionBar.o(keyEvent)) || super.dispatchKeyEvent(keyEvent);
    }
    
    public <T extends View> T findViewById(final int n) {
        return this.getDelegate().i(n);
    }
    
    public androidx.appcompat.app.f getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = androidx.appcompat.app.f.g(this, this);
        }
        return this.mDelegate;
    }
    
    public b getDrawerToggleDelegate() {
        return this.getDelegate().k();
    }
    
    public MenuInflater getMenuInflater() {
        return this.getDelegate().m();
    }
    
    public Resources getResources() {
        if (this.mResources == null && v0.d()) {
            this.mResources = new v0((Context)this, super.getResources());
        }
        Resources resources;
        if ((resources = this.mResources) == null) {
            resources = super.getResources();
        }
        return resources;
    }
    
    public a getSupportActionBar() {
        return this.getDelegate().n();
    }
    
    @Override
    public Intent getSupportParentActivityIntent() {
        return androidx.core.app.j.a(this);
    }
    
    public void invalidateOptionsMenu() {
        this.getDelegate().p();
    }
    
    @Override
    public void onConfigurationChanged(final Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.getDelegate().q(configuration);
        if (this.mResources != null) {
            this.mResources.updateConfiguration(super.getResources().getConfiguration(), super.getResources().getDisplayMetrics());
        }
    }
    
    public void onContentChanged() {
        this.onSupportContentChanged();
    }
    
    public void onCreateSupportNavigateUpTaskStack(final v v) {
        v.e(this);
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.getDelegate().s();
    }
    
    public boolean onKeyDown(final int n, final KeyEvent keyEvent) {
        return this.performMenuItemShortcut(keyEvent) || super.onKeyDown(n, keyEvent);
    }
    
    @Override
    public final boolean onMenuItemSelected(final int n, final MenuItem menuItem) {
        if (super.onMenuItemSelected(n, menuItem)) {
            return true;
        }
        final a supportActionBar = this.getSupportActionBar();
        return menuItem.getItemId() == 16908332 && supportActionBar != null && (supportActionBar.i() & 0x4) != 0x0 && this.onSupportNavigateUp();
    }
    
    public boolean onMenuOpened(final int n, final Menu menu) {
        return super.onMenuOpened(n, menu);
    }
    
    protected void onNightModeChanged(final int n) {
    }
    
    @Override
    public void onPanelClosed(final int n, final Menu menu) {
        super.onPanelClosed(n, menu);
    }
    
    protected void onPostCreate(final Bundle bundle) {
        super.onPostCreate(bundle);
        this.getDelegate().t(bundle);
    }
    
    @Override
    protected void onPostResume() {
        super.onPostResume();
        this.getDelegate().u();
    }
    
    public void onPrepareSupportNavigateUpTaskStack(final v v) {
    }
    
    @Override
    protected void onStart() {
        super.onStart();
        this.getDelegate().w();
    }
    
    @Override
    protected void onStop() {
        super.onStop();
        this.getDelegate().x();
    }
    
    @Override
    public void onSupportActionModeFinished(final androidx.appcompat.view.b b) {
    }
    
    @Override
    public void onSupportActionModeStarted(final androidx.appcompat.view.b b) {
    }
    
    @Deprecated
    public void onSupportContentChanged() {
    }
    
    public boolean onSupportNavigateUp() {
        final Intent supportParentActivityIntent = this.getSupportParentActivityIntent();
        if (supportParentActivityIntent != null) {
            if (this.supportShouldUpRecreateTask(supportParentActivityIntent)) {
                final v g = v.g((Context)this);
                this.onCreateSupportNavigateUpTaskStack(g);
                this.onPrepareSupportNavigateUpTaskStack(g);
                g.p();
                try {
                    androidx.core.app.b.b(this);
                }
                catch (final IllegalStateException ex) {
                    this.finish();
                }
            }
            else {
                this.supportNavigateUpTo(supportParentActivityIntent);
            }
            return true;
        }
        return false;
    }
    
    protected void onTitleChanged(final CharSequence charSequence, final int n) {
        super.onTitleChanged(charSequence, n);
        this.getDelegate().H(charSequence);
    }
    
    @Override
    public androidx.appcompat.view.b onWindowStartingSupportActionMode(final b.a a) {
        return null;
    }
    
    public void openOptionsMenu() {
        final a supportActionBar = this.getSupportActionBar();
        if (this.getWindow().hasFeature(0) && (supportActionBar == null || !supportActionBar.p())) {
            super.openOptionsMenu();
        }
    }
    
    @Override
    public void setContentView(final int n) {
        this.initViewTreeOwners();
        this.getDelegate().C(n);
    }
    
    @Override
    public void setContentView(final View view) {
        this.initViewTreeOwners();
        this.getDelegate().D(view);
    }
    
    @Override
    public void setContentView(final View view, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        this.initViewTreeOwners();
        this.getDelegate().E(view, viewGroup$LayoutParams);
    }
    
    public void setSupportActionBar(final Toolbar toolbar) {
        this.getDelegate().F(toolbar);
    }
    
    @Deprecated
    public void setSupportProgress(final int n) {
    }
    
    @Deprecated
    public void setSupportProgressBarIndeterminate(final boolean b) {
    }
    
    @Deprecated
    public void setSupportProgressBarIndeterminateVisibility(final boolean b) {
    }
    
    @Deprecated
    public void setSupportProgressBarVisibility(final boolean b) {
    }
    
    public void setTheme(final int theme) {
        super.setTheme(theme);
        this.getDelegate().G(theme);
    }
    
    public androidx.appcompat.view.b startSupportActionMode(final b.a a) {
        return this.getDelegate().I(a);
    }
    
    @Override
    public void supportInvalidateOptionsMenu() {
        this.getDelegate().p();
    }
    
    public void supportNavigateUpTo(final Intent intent) {
        androidx.core.app.j.e(this, intent);
    }
    
    public boolean supportRequestWindowFeature(final int n) {
        return this.getDelegate().A(n);
    }
    
    public boolean supportShouldUpRecreateTask(final Intent intent) {
        return androidx.core.app.j.f(this, intent);
    }
}
