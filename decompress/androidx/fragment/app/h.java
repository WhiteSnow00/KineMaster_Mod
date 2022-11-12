// 
// Decompiled by Procyon v0.6.0
// 

package androidx.fragment.app;

import android.view.LayoutInflater;
import androidx.lifecycle.q0;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResultRegistry;
import android.view.Window;
import androidx.core.app.s;
import androidx.core.app.i;
import androidx.core.view.o;
import androidx.core.view.j;
import androidx.lifecycle.r0;
import androidx.core.app.q;
import androidx.core.app.p;
import android.content.IntentSender$SendIntentException;
import android.content.IntentSender;
import android.app.Activity;
import androidx.core.app.u;
import android.view.MenuItem;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import android.util.AttributeSet;
import android.view.View;
import java.util.Iterator;
import android.content.Context;
import androidx.lifecycle.Lifecycle;
import android.os.Bundle;
import android.content.Intent;
import android.content.res.Configuration;
import androidx.core.util.a;
import u0.c;
import androidx.lifecycle.r;
import androidx.lifecycle.t;
import androidx.core.app.b;
import androidx.activity.ComponentActivity;

public class h extends ComponentActivity implements b.e
{
    static final String LIFECYCLE_TAG = "android:support:lifecycle";
    boolean mCreated;
    final t mFragmentLifecycleRegistry;
    final androidx.fragment.app.k mFragments;
    boolean mResumed;
    boolean mStopped;
    
    public h() {
        this.mFragments = androidx.fragment.app.k.b(new a());
        this.mFragmentLifecycleRegistry = new t(this);
        this.mStopped = true;
        this.init();
    }
    
    public h(final int n) {
        super(n);
        this.mFragments = androidx.fragment.app.k.b(new a());
        this.mFragmentLifecycleRegistry = new t(this);
        this.mStopped = true;
        this.init();
    }
    
    private void init() {
        this.getSavedStateRegistry().h("android:support:lifecycle", (c.c)new g(this));
        this.addOnConfigurationChangedListener(new e(this));
        this.addOnNewIntentListener(new d(this));
        this.addOnContextAvailableListener(new androidx.fragment.app.f(this));
    }
    
    private Bundle lambda$init$0() {
        this.markFragmentsCreated();
        this.mFragmentLifecycleRegistry.h(Lifecycle.Event.ON_STOP);
        return new Bundle();
    }
    
    private void lambda$init$1(final Configuration configuration) {
        this.mFragments.m();
    }
    
    private void lambda$init$2(final Intent intent) {
        this.mFragments.m();
    }
    
    private void lambda$init$3(final Context context) {
        this.mFragments.a(null);
    }
    
    public static void m(final h h, final Intent intent) {
        h.lambda$init$2(intent);
    }
    
    private static boolean markState(final FragmentManager fragmentManager, final Lifecycle.State state) {
        final Iterator<Object> iterator = fragmentManager.z0().iterator();
        int n = 0;
        while (iterator.hasNext()) {
            final Fragment fragment = iterator.next();
            if (fragment == null) {
                continue;
            }
            boolean b = n != 0;
            if (fragment.getHost() != null) {
                b = ((n | (markState(fragment.getChildFragmentManager(), state) ? 1 : 0)) != 0x0);
            }
            final g0 mViewLifecycleOwner = fragment.mViewLifecycleOwner;
            n = (b ? 1 : 0);
            if (mViewLifecycleOwner != null) {
                n = (b ? 1 : 0);
                if (mViewLifecycleOwner.getLifecycle().b().isAtLeast(Lifecycle.State.STARTED)) {
                    fragment.mViewLifecycleOwner.f(state);
                    n = (true ? 1 : 0);
                }
            }
            if (!fragment.mLifecycleRegistry.b().isAtLeast(Lifecycle.State.STARTED)) {
                continue;
            }
            fragment.mLifecycleRegistry.o(state);
            n = (true ? 1 : 0);
        }
        return n != 0;
    }
    
    public static void n(final h h, final Configuration configuration) {
        h.lambda$init$1(configuration);
    }
    
    public static void o(final h h, final Context context) {
        h.lambda$init$3(context);
    }
    
    public static Bundle p(final h h) {
        return h.lambda$init$0();
    }
    
    final View dispatchFragmentsOnCreateView(final View view, final String s, final Context context, final AttributeSet set) {
        return this.mFragments.n(view, s, context, set);
    }
    
    public void dump(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        super.dump(s, fileDescriptor, printWriter, array);
        if (!this.shouldDumpInternalState(array)) {
            return;
        }
        printWriter.print(s);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        final StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append("  ");
        final String string = sb.toString();
        printWriter.print(string);
        printWriter.print("mCreated=");
        printWriter.print(this.mCreated);
        printWriter.print(" mResumed=");
        printWriter.print(this.mResumed);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        if (this.getApplication() != null) {
            androidx.loader.app.a.b(this).a(string, fileDescriptor, printWriter, array);
        }
        this.mFragments.l().Z(s, fileDescriptor, printWriter, array);
    }
    
    public FragmentManager getSupportFragmentManager() {
        return this.mFragments.l();
    }
    
    @Deprecated
    public androidx.loader.app.a getSupportLoaderManager() {
        return androidx.loader.app.a.b(this);
    }
    
    void markFragmentsCreated() {
        while (markState(this.getSupportFragmentManager(), Lifecycle.State.CREATED)) {}
    }
    
    @Override
    protected void onActivityResult(final int n, final int n2, final Intent intent) {
        this.mFragments.m();
        super.onActivityResult(n, n2, intent);
    }
    
    @Deprecated
    public void onAttachFragment(final Fragment fragment) {
    }
    
    @Override
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.mFragmentLifecycleRegistry.h(Lifecycle.Event.ON_CREATE);
        this.mFragments.e();
    }
    
    public View onCreateView(final View view, final String s, final Context context, final AttributeSet set) {
        final View dispatchFragmentsOnCreateView = this.dispatchFragmentsOnCreateView(view, s, context, set);
        if (dispatchFragmentsOnCreateView == null) {
            return super.onCreateView(view, s, context, set);
        }
        return dispatchFragmentsOnCreateView;
    }
    
    public View onCreateView(final String s, final Context context, final AttributeSet set) {
        final View dispatchFragmentsOnCreateView = this.dispatchFragmentsOnCreateView(null, s, context, set);
        if (dispatchFragmentsOnCreateView == null) {
            return super.onCreateView(s, context, set);
        }
        return dispatchFragmentsOnCreateView;
    }
    
    protected void onDestroy() {
        super.onDestroy();
        this.mFragments.f();
        this.mFragmentLifecycleRegistry.h(Lifecycle.Event.ON_DESTROY);
    }
    
    @Override
    public boolean onMenuItemSelected(final int n, final MenuItem menuItem) {
        return super.onMenuItemSelected(n, menuItem) || (n == 6 && this.mFragments.d(menuItem));
    }
    
    protected void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.g();
        this.mFragmentLifecycleRegistry.h(Lifecycle.Event.ON_PAUSE);
    }
    
    protected void onPostResume() {
        super.onPostResume();
        this.onResumeFragments();
    }
    
    @Override
    public void onRequestPermissionsResult(final int n, final String[] array, final int[] array2) {
        this.mFragments.m();
        super.onRequestPermissionsResult(n, array, array2);
    }
    
    protected void onResume() {
        this.mFragments.m();
        super.onResume();
        this.mResumed = true;
        this.mFragments.k();
    }
    
    protected void onResumeFragments() {
        this.mFragmentLifecycleRegistry.h(Lifecycle.Event.ON_RESUME);
        this.mFragments.h();
    }
    
    protected void onStart() {
        this.mFragments.m();
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            this.mFragments.c();
        }
        this.mFragments.k();
        this.mFragmentLifecycleRegistry.h(Lifecycle.Event.ON_START);
        this.mFragments.i();
    }
    
    public void onStateNotSaved() {
        this.mFragments.m();
    }
    
    protected void onStop() {
        super.onStop();
        this.mStopped = true;
        this.markFragmentsCreated();
        this.mFragments.j();
        this.mFragmentLifecycleRegistry.h(Lifecycle.Event.ON_STOP);
    }
    
    public void setEnterSharedElementCallback(final u u) {
        b.h(this, u);
    }
    
    public void setExitSharedElementCallback(final u u) {
        b.i(this, u);
    }
    
    public void startActivityFromFragment(final Fragment fragment, final Intent intent, final int n) {
        this.startActivityFromFragment(fragment, intent, n, null);
    }
    
    public void startActivityFromFragment(final Fragment fragment, final Intent intent, final int n, final Bundle bundle) {
        if (n == -1) {
            b.k(this, intent, -1, bundle);
            return;
        }
        fragment.startActivityForResult(intent, n, bundle);
    }
    
    @Deprecated
    public void startIntentSenderFromFragment(final Fragment fragment, final IntentSender intentSender, final int n, final Intent intent, final int n2, final int n3, final int n4, final Bundle bundle) throws IntentSender$SendIntentException {
        if (n == -1) {
            b.l(this, intentSender, n, intent, n2, n3, n4, bundle);
            return;
        }
        fragment.startIntentSenderForResult(intentSender, n, intent, n2, n3, n4, bundle);
    }
    
    public void supportFinishAfterTransition() {
        b.c(this);
    }
    
    @Deprecated
    public void supportInvalidateOptionsMenu() {
        this.invalidateOptionsMenu();
    }
    
    public void supportPostponeEnterTransition() {
        b.e(this);
    }
    
    public void supportStartPostponedEnterTransition() {
        b.m(this);
    }
    
    @Deprecated
    @Override
    public final void validateRequestPermissionsRequestCode(final int n) {
    }
    
    class a extends m<h> implements androidx.core.content.b, androidx.core.content.c, p, q, r0, h, androidx.activity.result.c, u0.e, y, j
    {
        final h f;
        
        public a(final h f) {
            super(this.f = f);
        }
        
        @Override
        public void a(final FragmentManager fragmentManager, final Fragment fragment) {
            this.f.onAttachFragment(fragment);
        }
        
        @Override
        public void addMenuProvider(final o o) {
            this.f.addMenuProvider(o);
        }
        
        @Override
        public void addOnConfigurationChangedListener(final androidx.core.util.a<Configuration> a) {
            this.f.addOnConfigurationChangedListener(a);
        }
        
        @Override
        public void addOnMultiWindowModeChangedListener(final androidx.core.util.a<i> a) {
            this.f.addOnMultiWindowModeChangedListener(a);
        }
        
        @Override
        public void addOnPictureInPictureModeChangedListener(final androidx.core.util.a<s> a) {
            this.f.addOnPictureInPictureModeChangedListener(a);
        }
        
        @Override
        public void addOnTrimMemoryListener(final androidx.core.util.a<Integer> a) {
            this.f.addOnTrimMemoryListener(a);
        }
        
        @Override
        public View c(final int n) {
            return this.f.findViewById(n);
        }
        
        @Override
        public boolean d() {
            final Window window = this.f.getWindow();
            return window != null && window.peekDecorView() != null;
        }
        
        @Override
        public ActivityResultRegistry getActivityResultRegistry() {
            return this.f.getActivityResultRegistry();
        }
        
        @Override
        public Lifecycle getLifecycle() {
            return this.f.mFragmentLifecycleRegistry;
        }
        
        @Override
        public OnBackPressedDispatcher getOnBackPressedDispatcher() {
            return this.f.getOnBackPressedDispatcher();
        }
        
        @Override
        public c getSavedStateRegistry() {
            return this.f.getSavedStateRegistry();
        }
        
        @Override
        public q0 getViewModelStore() {
            return this.f.getViewModelStore();
        }
        
        @Override
        public void h(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
            this.f.dump(s, fileDescriptor, printWriter, array);
        }
        
        @Override
        public /* bridge */ Object i() {
            return this.q();
        }
        
        @Override
        public LayoutInflater j() {
            return this.f.getLayoutInflater().cloneInContext((Context)this.f);
        }
        
        @Override
        public boolean l(final String s) {
            return b.j(this.f, s);
        }
        
        @Override
        public void o() {
            this.p();
        }
        
        public void p() {
            this.f.invalidateOptionsMenu();
        }
        
        public h q() {
            return this.f;
        }
        
        @Override
        public void removeMenuProvider(final o o) {
            this.f.removeMenuProvider(o);
        }
        
        @Override
        public void removeOnConfigurationChangedListener(final androidx.core.util.a<Configuration> a) {
            this.f.removeOnConfigurationChangedListener(a);
        }
        
        @Override
        public void removeOnMultiWindowModeChangedListener(final androidx.core.util.a<i> a) {
            this.f.removeOnMultiWindowModeChangedListener(a);
        }
        
        @Override
        public void removeOnPictureInPictureModeChangedListener(final androidx.core.util.a<s> a) {
            this.f.removeOnPictureInPictureModeChangedListener(a);
        }
        
        @Override
        public void removeOnTrimMemoryListener(final androidx.core.util.a<Integer> a) {
            this.f.removeOnTrimMemoryListener(a);
        }
    }
}
