// 
// Decompiled by Procyon v0.6.0
// 

package androidx.activity;

import android.content.IntentSender;
import android.view.MenuItem;
import android.view.Menu;
import androidx.lifecycle.e0;
import java.util.Iterator;
import android.app.Application;
import androidx.lifecycle.i0;
import android.view.ViewGroup$LayoutParams;
import u0.f;
import androidx.lifecycle.t0;
import androidx.lifecycle.s0;
import androidx.lifecycle.SavedStateHandleSupport;
import android.view.View;
import android.view.Window;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.o;
import android.os.Bundle;
import java.io.Serializable;
import android.content.IntentSender$SendIntentException;
import androidx.activity.result.IntentSenderRequest;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.r;
import androidx.lifecycle.q0;
import u0.d;
import androidx.core.app.s;
import android.content.Intent;
import androidx.core.app.i;
import android.content.res.Configuration;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import androidx.core.view.m;
import androidx.lifecycle.t;
import androidx.lifecycle.o0;
import b.a;
import androidx.activity.result.ActivityResultRegistry;
import androidx.core.view.j;
import androidx.core.app.q;
import androidx.core.app.p;
import androidx.core.content.b;
import androidx.activity.result.c;
import u0.e;
import androidx.lifecycle.k;
import androidx.lifecycle.r0;
import androidx.core.app.g;

public class ComponentActivity extends g implements r0, k, e, h, androidx.activity.result.c, b, androidx.core.content.c, p, q, j
{
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private final ActivityResultRegistry mActivityResultRegistry;
    private int mContentLayoutId;
    final b.a mContextAwareHelper;
    private o0.b mDefaultFactory;
    private final t mLifecycleRegistry;
    private final m mMenuHostHelper;
    private final AtomicInteger mNextLocalRequestCode;
    private final OnBackPressedDispatcher mOnBackPressedDispatcher;
    private final CopyOnWriteArrayList<androidx.core.util.a<Configuration>> mOnConfigurationChangedListeners;
    private final CopyOnWriteArrayList<androidx.core.util.a<i>> mOnMultiWindowModeChangedListeners;
    private final CopyOnWriteArrayList<androidx.core.util.a<Intent>> mOnNewIntentListeners;
    private final CopyOnWriteArrayList<androidx.core.util.a<s>> mOnPictureInPictureModeChangedListeners;
    private final CopyOnWriteArrayList<androidx.core.util.a<Integer>> mOnTrimMemoryListeners;
    final u0.d mSavedStateRegistryController;
    private q0 mViewModelStore;
    
    public ComponentActivity() {
        this.mContextAwareHelper = new b.a();
        this.mMenuHostHelper = new m(new androidx.activity.c(this));
        this.mLifecycleRegistry = new t(this);
        final u0.d a = u0.d.a(this);
        this.mSavedStateRegistryController = a;
        this.mOnBackPressedDispatcher = new OnBackPressedDispatcher(new Runnable() {
            final ComponentActivity a;
            
            @Override
            public void run() {
                try {
                    ComponentActivity.access$001(this.a);
                }
                catch (final IllegalStateException ex) {
                    if (!TextUtils.equals((CharSequence)ex.getMessage(), (CharSequence)"Can not perform this action after onSaveInstanceState")) {
                        throw ex;
                    }
                }
            }
        });
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mActivityResultRegistry = new ActivityResultRegistry() {
            final ComponentActivity i;
            
            @Override
            public <I, O> void f(final int n, final c.a<I, O> a, final I n2, final androidx.core.app.c c) {
                final ComponentActivity i = this.i;
                final c.a.a<O> synchronousResult = a.getSynchronousResult((Context)i, n2);
                if (synchronousResult != null) {
                    new Handler(Looper.getMainLooper()).post((Runnable)new Runnable(this, n, synchronousResult) {
                        final int a;
                        final c.a.a b;
                        final ComponentActivity$b c;
                        
                        @Override
                        public void run() {
                            this.c.c(this.a, this.b.a());
                        }
                    });
                    return;
                }
                final Intent intent = a.createIntent((Context)i, n2);
                Bundle bundle = null;
                if (intent.getExtras() != null && intent.getExtras().getClassLoader() == null) {
                    intent.setExtrasClassLoader(i.getClassLoader());
                }
                if (intent.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
                    bundle = intent.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                    intent.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                }
                else if (c != null) {
                    bundle = c.b();
                }
                if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(intent.getAction())) {
                    String[] stringArrayExtra;
                    if ((stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS")) == null) {
                        stringArrayExtra = new String[0];
                    }
                    androidx.core.app.b.g(i, stringArrayExtra, n);
                }
                else if ("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(intent.getAction())) {
                    final IntentSenderRequest intentSenderRequest = (IntentSenderRequest)intent.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
                    try {
                        androidx.core.app.b.l(i, intentSenderRequest.d(), n, intentSenderRequest.a(), intentSenderRequest.b(), intentSenderRequest.c(), 0, bundle);
                    }
                    catch (final IntentSender$SendIntentException ex) {
                        new Handler(Looper.getMainLooper()).post((Runnable)new Runnable(this, n, ex) {
                            final int a;
                            final IntentSender$SendIntentException b;
                            final ComponentActivity$b c;
                            
                            @Override
                            public void run() {
                                this.c.b(this.a, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", (Serializable)this.b));
                            }
                        });
                    }
                }
                else {
                    androidx.core.app.b.k(i, intent, n, bundle);
                }
            }
        };
        this.mOnConfigurationChangedListeners = new CopyOnWriteArrayList<androidx.core.util.a<Configuration>>();
        this.mOnTrimMemoryListeners = new CopyOnWriteArrayList<androidx.core.util.a<Integer>>();
        this.mOnNewIntentListeners = new CopyOnWriteArrayList<androidx.core.util.a<Intent>>();
        this.mOnMultiWindowModeChangedListeners = new CopyOnWriteArrayList<androidx.core.util.a<i>>();
        this.mOnPictureInPictureModeChangedListeners = new CopyOnWriteArrayList<androidx.core.util.a<s>>();
        if (this.getLifecycle() != null) {
            this.getLifecycle().a(new o(this) {
                final ComponentActivity a;
                
                @Override
                public void f(final r r, final Lifecycle.Event event) {
                    if (event == Lifecycle.Event.ON_STOP) {
                        final Window window = this.a.getWindow();
                        View peekDecorView;
                        if (window != null) {
                            peekDecorView = window.peekDecorView();
                        }
                        else {
                            peekDecorView = null;
                        }
                        if (peekDecorView != null) {
                            c.a(peekDecorView);
                        }
                    }
                }
            });
            this.getLifecycle().a(new o(this) {
                final ComponentActivity a;
                
                @Override
                public void f(final r r, final Lifecycle.Event event) {
                    if (event == Lifecycle.Event.ON_DESTROY) {
                        this.a.mContextAwareHelper.b();
                        if (!this.a.isChangingConfigurations()) {
                            this.a.getViewModelStore().a();
                        }
                    }
                }
            });
            this.getLifecycle().a(new o(this) {
                final ComponentActivity a;
                
                @Override
                public void f(final r r, final Lifecycle.Event event) {
                    this.a.ensureViewModelStore();
                    this.a.getLifecycle().c(this);
                }
            });
            a.c();
            SavedStateHandleSupport.c(this);
            this.getSavedStateRegistry().h("android:support:activity-result", (u0.c.c)new androidx.activity.d(this));
            this.addOnContextAvailableListener(new androidx.activity.b(this));
            return;
        }
        throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
    }
    
    public ComponentActivity(final int mContentLayoutId) {
        this();
        this.mContentLayoutId = mContentLayoutId;
    }
    
    static void access$001(final ComponentActivity componentActivity) {
        componentActivity.onBackPressed();
    }
    
    private void initViewTreeOwners() {
        s0.a(this.getWindow().getDecorView(), this);
        t0.a(this.getWindow().getDecorView(), this);
        f.a(this.getWindow().getDecorView(), this);
        androidx.activity.j.a(this.getWindow().getDecorView(), this);
    }
    
    public static void k(final ComponentActivity componentActivity, final Context context) {
        componentActivity.lambda$new$1(context);
    }
    
    public static Bundle l(final ComponentActivity componentActivity) {
        return componentActivity.lambda$new$0();
    }
    
    private Bundle lambda$new$0() {
        final Bundle bundle = new Bundle();
        this.mActivityResultRegistry.h(bundle);
        return bundle;
    }
    
    private void lambda$new$1(final Context context) {
        final Bundle b = this.getSavedStateRegistry().b("android:support:activity-result");
        if (b != null) {
            this.mActivityResultRegistry.g(b);
        }
    }
    
    public void addContentView(final View view, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        this.initViewTreeOwners();
        super.addContentView(view, viewGroup$LayoutParams);
    }
    
    @Override
    public void addMenuProvider(final androidx.core.view.o o) {
        this.mMenuHostHelper.c(o);
    }
    
    public void addMenuProvider(final androidx.core.view.o o, final r r) {
        this.mMenuHostHelper.d(o, r);
    }
    
    public void addMenuProvider(final androidx.core.view.o o, final r r, final Lifecycle.State state) {
        this.mMenuHostHelper.e(o, r, state);
    }
    
    @Override
    public final void addOnConfigurationChangedListener(final androidx.core.util.a<Configuration> a) {
        this.mOnConfigurationChangedListeners.add(a);
    }
    
    public final void addOnContextAvailableListener(final b.b b) {
        this.mContextAwareHelper.a(b);
    }
    
    @Override
    public final void addOnMultiWindowModeChangedListener(final androidx.core.util.a<i> a) {
        this.mOnMultiWindowModeChangedListeners.add(a);
    }
    
    public final void addOnNewIntentListener(final androidx.core.util.a<Intent> a) {
        this.mOnNewIntentListeners.add(a);
    }
    
    @Override
    public final void addOnPictureInPictureModeChangedListener(final androidx.core.util.a<s> a) {
        this.mOnPictureInPictureModeChangedListeners.add(a);
    }
    
    @Override
    public final void addOnTrimMemoryListener(final androidx.core.util.a<Integer> a) {
        this.mOnTrimMemoryListeners.add(a);
    }
    
    void ensureViewModelStore() {
        if (this.mViewModelStore == null) {
            final d d = (d)this.getLastNonConfigurationInstance();
            if (d != null) {
                this.mViewModelStore = d.b;
            }
            if (this.mViewModelStore == null) {
                this.mViewModelStore = new q0();
            }
        }
    }
    
    @Override
    public final ActivityResultRegistry getActivityResultRegistry() {
        return this.mActivityResultRegistry;
    }
    
    @Override
    public k0.a getDefaultViewModelCreationExtras() {
        final k0.d d = new k0.d();
        if (this.getApplication() != null) {
            d.c(o0.a.h, this.getApplication());
        }
        d.c(SavedStateHandleSupport.a, this);
        d.c(SavedStateHandleSupport.b, this);
        if (this.getIntent() != null && this.getIntent().getExtras() != null) {
            d.c(SavedStateHandleSupport.c, this.getIntent().getExtras());
        }
        return d;
    }
    
    @Override
    public o0.b getDefaultViewModelProviderFactory() {
        if (this.mDefaultFactory == null) {
            final Application application = this.getApplication();
            Bundle extras;
            if (this.getIntent() != null) {
                extras = this.getIntent().getExtras();
            }
            else {
                extras = null;
            }
            this.mDefaultFactory = new i0(application, this, extras);
        }
        return this.mDefaultFactory;
    }
    
    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        final d d = (d)this.getLastNonConfigurationInstance();
        Object a;
        if (d != null) {
            a = d.a;
        }
        else {
            a = null;
        }
        return a;
    }
    
    @Override
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }
    
    @Override
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.mOnBackPressedDispatcher;
    }
    
    @Override
    public final u0.c getSavedStateRegistry() {
        return this.mSavedStateRegistryController.b();
    }
    
    @Override
    public q0 getViewModelStore() {
        if (this.getApplication() != null) {
            this.ensureViewModelStore();
            return this.mViewModelStore;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }
    
    public void invalidateMenu() {
        this.invalidateOptionsMenu();
    }
    
    @Deprecated
    protected void onActivityResult(final int n, final int n2, final Intent intent) {
        if (!this.mActivityResultRegistry.b(n, n2, intent)) {
            super.onActivityResult(n, n2, intent);
        }
    }
    
    public void onBackPressed() {
        this.mOnBackPressedDispatcher.d();
    }
    
    public void onConfigurationChanged(final Configuration configuration) {
        super.onConfigurationChanged(configuration);
        final Iterator<androidx.core.util.a<Configuration>> iterator = this.mOnConfigurationChangedListeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().accept(configuration);
        }
    }
    
    @Override
    protected void onCreate(final Bundle bundle) {
        this.mSavedStateRegistryController.d(bundle);
        this.mContextAwareHelper.c((Context)this);
        super.onCreate(bundle);
        e0.g(this);
        final int mContentLayoutId = this.mContentLayoutId;
        if (mContentLayoutId != 0) {
            this.setContentView(mContentLayoutId);
        }
    }
    
    public boolean onCreatePanelMenu(final int n, final Menu menu) {
        if (n == 0) {
            super.onCreatePanelMenu(n, menu);
            this.mMenuHostHelper.h(menu, this.getMenuInflater());
        }
        return true;
    }
    
    public boolean onMenuItemSelected(final int n, final MenuItem menuItem) {
        return super.onMenuItemSelected(n, menuItem) || (n == 0 && this.mMenuHostHelper.j(menuItem));
    }
    
    public void onMultiWindowModeChanged(final boolean b) {
        final Iterator<androidx.core.util.a<i>> iterator = this.mOnMultiWindowModeChangedListeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().accept(new i(b));
        }
    }
    
    public void onMultiWindowModeChanged(final boolean b, final Configuration configuration) {
        final Iterator<androidx.core.util.a<i>> iterator = this.mOnMultiWindowModeChangedListeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().accept(new i(b, configuration));
        }
    }
    
    protected void onNewIntent(final Intent intent) {
        super.onNewIntent(intent);
        final Iterator<androidx.core.util.a<Intent>> iterator = this.mOnNewIntentListeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().accept(intent);
        }
    }
    
    public void onPanelClosed(final int n, final Menu menu) {
        this.mMenuHostHelper.i(menu);
        super.onPanelClosed(n, menu);
    }
    
    public void onPictureInPictureModeChanged(final boolean b) {
        final Iterator<androidx.core.util.a<s>> iterator = this.mOnPictureInPictureModeChangedListeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().accept(new s(b));
        }
    }
    
    public void onPictureInPictureModeChanged(final boolean b, final Configuration configuration) {
        final Iterator<androidx.core.util.a<s>> iterator = this.mOnPictureInPictureModeChangedListeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().accept(new s(b, configuration));
        }
    }
    
    public boolean onPreparePanel(final int n, final View view, final Menu menu) {
        if (n == 0) {
            super.onPreparePanel(n, view, menu);
            this.mMenuHostHelper.k(menu);
        }
        return true;
    }
    
    @Deprecated
    public void onRequestPermissionsResult(final int n, final String[] array, final int[] array2) {
        if (!this.mActivityResultRegistry.b(n, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", array).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", array2))) {
            super.onRequestPermissionsResult(n, array, array2);
        }
    }
    
    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }
    
    public final Object onRetainNonConfigurationInstance() {
        final Object onRetainCustomNonConfigurationInstance = this.onRetainCustomNonConfigurationInstance();
        q0 b;
        final q0 q0 = b = this.mViewModelStore;
        if (q0 == null) {
            final d d = (d)this.getLastNonConfigurationInstance();
            b = q0;
            if (d != null) {
                b = d.b;
            }
        }
        if (b == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        final d d2 = new d();
        d2.a = onRetainCustomNonConfigurationInstance;
        d2.b = b;
        return d2;
    }
    
    @Override
    protected void onSaveInstanceState(final Bundle bundle) {
        final Lifecycle lifecycle = this.getLifecycle();
        if (lifecycle instanceof t) {
            ((t)lifecycle).o(Lifecycle.State.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.e(bundle);
    }
    
    public void onTrimMemory(final int n) {
        super.onTrimMemory(n);
        final Iterator<androidx.core.util.a<Integer>> iterator = this.mOnTrimMemoryListeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().accept(n);
        }
    }
    
    public Context peekAvailableContext() {
        return this.mContextAwareHelper.d();
    }
    
    public final <I, O> androidx.activity.result.b<I> registerForActivityResult(final c.a<I, O> a, final ActivityResultRegistry activityResultRegistry, final androidx.activity.result.a<O> a2) {
        final StringBuilder sb = new StringBuilder();
        sb.append("activity_rq#");
        sb.append(this.mNextLocalRequestCode.getAndIncrement());
        return activityResultRegistry.i(sb.toString(), this, a, a2);
    }
    
    public final <I, O> androidx.activity.result.b<I> registerForActivityResult(final c.a<I, O> a, final androidx.activity.result.a<O> a2) {
        return this.registerForActivityResult(a, this.mActivityResultRegistry, a2);
    }
    
    @Override
    public void removeMenuProvider(final androidx.core.view.o o) {
        this.mMenuHostHelper.l(o);
    }
    
    @Override
    public final void removeOnConfigurationChangedListener(final androidx.core.util.a<Configuration> a) {
        this.mOnConfigurationChangedListeners.remove(a);
    }
    
    public final void removeOnContextAvailableListener(final b.b b) {
        this.mContextAwareHelper.e(b);
    }
    
    @Override
    public final void removeOnMultiWindowModeChangedListener(final androidx.core.util.a<i> a) {
        this.mOnMultiWindowModeChangedListeners.remove(a);
    }
    
    public final void removeOnNewIntentListener(final androidx.core.util.a<Intent> a) {
        this.mOnNewIntentListeners.remove(a);
    }
    
    @Override
    public final void removeOnPictureInPictureModeChangedListener(final androidx.core.util.a<s> a) {
        this.mOnPictureInPictureModeChangedListeners.remove(a);
    }
    
    @Override
    public final void removeOnTrimMemoryListener(final androidx.core.util.a<Integer> a) {
        this.mOnTrimMemoryListeners.remove(a);
    }
    
    public void reportFullyDrawn() {
        try {
            if (y0.a.d()) {
                y0.a.a("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
        }
        finally {
            y0.a.b();
        }
    }
    
    public void setContentView(final int contentView) {
        this.initViewTreeOwners();
        super.setContentView(contentView);
    }
    
    public void setContentView(final View contentView) {
        this.initViewTreeOwners();
        super.setContentView(contentView);
    }
    
    public void setContentView(final View view, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        this.initViewTreeOwners();
        super.setContentView(view, viewGroup$LayoutParams);
    }
    
    @Deprecated
    public void startActivityForResult(final Intent intent, final int n) {
        super.startActivityForResult(intent, n);
    }
    
    @Deprecated
    public void startActivityForResult(final Intent intent, final int n, final Bundle bundle) {
        super.startActivityForResult(intent, n, bundle);
    }
    
    @Deprecated
    public void startIntentSenderForResult(final IntentSender intentSender, final int n, final Intent intent, final int n2, final int n3, final int n4) throws IntentSender$SendIntentException {
        super.startIntentSenderForResult(intentSender, n, intent, n2, n3, n4);
    }
    
    @Deprecated
    public void startIntentSenderForResult(final IntentSender intentSender, final int n, final Intent intent, final int n2, final int n3, final int n4, final Bundle bundle) throws IntentSender$SendIntentException {
        super.startIntentSenderForResult(intentSender, n, intent, n2, n3, n4, bundle);
    }
    
    static class c
    {
        static void a(final View view) {
            view.cancelPendingInputEvents();
        }
    }
    
    static final class d
    {
        Object a;
        q0 b;
    }
}
