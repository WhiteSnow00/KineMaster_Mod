// 
// Decompiled by Procyon v0.6.0
// 

package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;
import android.os.Parcelable$Creator;
import android.content.IntentSender$SendIntentException;
import android.content.IntentSender;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.TimeUnit;
import u0.f;
import androidx.lifecycle.t0;
import androidx.lifecycle.s0;
import androidx.lifecycle.q;
import androidx.lifecycle.o;
import java.util.Iterator;
import android.util.AttributeSet;
import android.view.MenuInflater;
import android.view.Menu;
import android.view.ContextMenu$ContextMenuInfo;
import android.view.ContextMenu;
import android.animation.Animator;
import android.view.animation.Animation;
import android.view.MenuItem;
import android.content.res.Configuration;
import android.app.Activity;
import android.content.Intent;
import androidx.lifecycle.q0;
import androidx.lifecycle.LiveData;
import android.content.res.Resources;
import java.util.Objects;
import androidx.core.app.u;
import androidx.lifecycle.i0;
import android.app.Application;
import android.content.ContextWrapper;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import android.util.Log;
import androidx.core.app.c;
import java.util.concurrent.atomic.AtomicReference;
import androidx.activity.result.b;
import androidx.activity.result.ActivityResultRegistry;
import c.a;
import java.lang.reflect.InvocationTargetException;
import android.content.Context;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.SavedStateHandleSupport;
import java.util.UUID;
import androidx.lifecycle.z;
import android.view.View;
import android.os.Parcelable;
import android.util.SparseArray;
import u0.d;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.t;
import android.view.LayoutInflater;
import androidx.lifecycle.o0;
import android.view.ViewGroup;
import android.os.Bundle;
import u0.e;
import androidx.lifecycle.k;
import androidx.lifecycle.r0;
import androidx.lifecycle.r;
import android.view.View$OnCreateContextMenuListener;
import android.content.ComponentCallbacks;

public class Fragment implements ComponentCallbacks, View$OnCreateContextMenuListener, r, r0, androidx.lifecycle.k, e
{
    static final int ACTIVITY_CREATED = 4;
    static final int ATTACHED = 0;
    static final int AWAITING_ENTER_EFFECTS = 6;
    static final int AWAITING_EXIT_EFFECTS = 3;
    static final int CREATED = 1;
    static final int INITIALIZING = -1;
    static final int RESUMED = 7;
    static final int STARTED = 5;
    static final Object USE_DEFAULT_TRANSITION;
    static final int VIEW_CREATED = 2;
    boolean mAdded;
    j mAnimationInfo;
    Bundle mArguments;
    int mBackStackNesting;
    boolean mBeingSaved;
    private boolean mCalled;
    FragmentManager mChildFragmentManager;
    ViewGroup mContainer;
    int mContainerId;
    private int mContentLayoutId;
    o0.b mDefaultFactory;
    boolean mDeferStart;
    boolean mDetached;
    int mFragmentId;
    FragmentManager mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mHiddenChanged;
    m<?> mHost;
    boolean mInLayout;
    boolean mIsCreated;
    private Boolean mIsPrimaryNavigationFragment;
    LayoutInflater mLayoutInflater;
    t mLifecycleRegistry;
    Lifecycle.State mMaxState;
    boolean mMenuVisible;
    private final AtomicInteger mNextLocalRequestCode;
    private final ArrayList<l> mOnPreAttachedListeners;
    Fragment mParentFragment;
    boolean mPerformedCreateView;
    Runnable mPostponedDurationRunnable;
    public String mPreviousWho;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetainInstanceChangedWhileDetached;
    Bundle mSavedFragmentState;
    private final l mSavedStateAttachListener;
    d mSavedStateRegistryController;
    Boolean mSavedUserVisibleHint;
    Bundle mSavedViewRegistryState;
    SparseArray<Parcelable> mSavedViewState;
    int mState;
    String mTag;
    Fragment mTarget;
    int mTargetRequestCode;
    String mTargetWho;
    boolean mUserVisibleHint;
    View mView;
    g0 mViewLifecycleOwner;
    z<r> mViewLifecycleOwnerLiveData;
    String mWho;
    
    static {
        USE_DEFAULT_TRANSITION = new Object();
    }
    
    public Fragment() {
        this.mState = -1;
        this.mWho = UUID.randomUUID().toString();
        this.mTargetWho = null;
        this.mIsPrimaryNavigationFragment = null;
        this.mChildFragmentManager = new w();
        this.mMenuVisible = true;
        this.mUserVisibleHint = true;
        this.mPostponedDurationRunnable = new Runnable() {
            final Fragment a;
            
            @Override
            public void run() {
                this.a.startPostponedEnterTransition();
            }
        };
        this.mMaxState = Lifecycle.State.RESUMED;
        this.mViewLifecycleOwnerLiveData = new z<r>();
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mOnPreAttachedListeners = new ArrayList<l>();
        this.mSavedStateAttachListener = (l)new l() {
            final Fragment a;
            
            @Override
            void a() {
                this.a.mSavedStateRegistryController.c();
                SavedStateHandleSupport.c(this.a);
            }
        };
        this.initLifecycle();
    }
    
    public Fragment(final int mContentLayoutId) {
        this();
        this.mContentLayoutId = mContentLayoutId;
    }
    
    private j ensureAnimationInfo() {
        if (this.mAnimationInfo == null) {
            this.mAnimationInfo = new j();
        }
        return this.mAnimationInfo;
    }
    
    private int getMinimumMaxLifecycleState() {
        final Lifecycle.State mMaxState = this.mMaxState;
        if (mMaxState != Lifecycle.State.INITIALIZED && this.mParentFragment != null) {
            return Math.min(mMaxState.ordinal(), this.mParentFragment.getMinimumMaxLifecycleState());
        }
        return mMaxState.ordinal();
    }
    
    private Fragment getTargetFragment(final boolean b) {
        if (b) {
            FragmentStrictMode.l(this);
        }
        final Fragment mTarget = this.mTarget;
        if (mTarget != null) {
            return mTarget;
        }
        final FragmentManager mFragmentManager = this.mFragmentManager;
        if (mFragmentManager != null) {
            final String mTargetWho = this.mTargetWho;
            if (mTargetWho != null) {
                return mFragmentManager.h0(mTargetWho);
            }
        }
        return null;
    }
    
    private void initLifecycle() {
        this.mLifecycleRegistry = new t(this);
        this.mSavedStateRegistryController = d.a(this);
        this.mDefaultFactory = null;
        if (!this.mOnPreAttachedListeners.contains(this.mSavedStateAttachListener)) {
            this.registerOnPreAttachListener(this.mSavedStateAttachListener);
        }
    }
    
    @Deprecated
    public static Fragment instantiate(final Context context, final String s) {
        return instantiate(context, s, null);
    }
    
    @Deprecated
    public static Fragment instantiate(final Context context, final String s, final Bundle arguments) {
        try {
            final Fragment fragment = (Fragment)androidx.fragment.app.l.d(context.getClassLoader(), s).getConstructor((Class<?>[])new Class[0]).newInstance(new Object[0]);
            if (arguments != null) {
                arguments.setClassLoader(fragment.getClass().getClassLoader());
                fragment.setArguments(arguments);
            }
            return fragment;
        }
        catch (final InvocationTargetException ex) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Unable to instantiate fragment ");
            sb.append(s);
            sb.append(": calling Fragment constructor caused an exception");
            throw new InstantiationException(sb.toString(), ex);
        }
        catch (final NoSuchMethodException ex2) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Unable to instantiate fragment ");
            sb2.append(s);
            sb2.append(": could not find Fragment constructor");
            throw new InstantiationException(sb2.toString(), ex2);
        }
        catch (final IllegalAccessException ex3) {
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("Unable to instantiate fragment ");
            sb3.append(s);
            sb3.append(": make sure class name exists, is public, and has an empty constructor that is public");
            throw new InstantiationException(sb3.toString(), ex3);
        }
        catch (final java.lang.InstantiationException ex4) {
            final StringBuilder sb4 = new StringBuilder();
            sb4.append("Unable to instantiate fragment ");
            sb4.append(s);
            sb4.append(": make sure class name exists, is public, and has an empty constructor that is public");
            throw new InstantiationException(sb4.toString(), ex4);
        }
    }
    
    private <I, O> b<I> prepareCallInternal(final a<I, O> a, final k.a<Void, ActivityResultRegistry> a2, final androidx.activity.result.a<O> a3) {
        if (this.mState <= 1) {
            final AtomicReference atomicReference = new AtomicReference();
            this.registerOnPreAttachListener((l)new l(this, a2, atomicReference, a, a3) {
                final k.a a;
                final AtomicReference b;
                final a c;
                final androidx.activity.result.a d;
                final Fragment e;
                
                @Override
                void a() {
                    this.b.set(this.a.apply(null).i(this.e.generateActivityResultKey(), this.e, (a<Object, Object>)this.c, this.d));
                }
            });
            return new b<I>(this, atomicReference, a) {
                final AtomicReference a;
                final a b;
                final Fragment c;
                
                @Override
                public void b(final I n, final c c) {
                    final b b = this.a.get();
                    if (b != null) {
                        b.b(n, c);
                        return;
                    }
                    throw new IllegalStateException("Operation cannot be started before fragment is in created state");
                }
                
                @Override
                public void c() {
                    final b b = this.a.getAndSet(null);
                    if (b != null) {
                        b.c();
                    }
                }
            };
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate()).");
        throw new IllegalStateException(sb.toString());
    }
    
    private void registerOnPreAttachListener(final l l) {
        if (this.mState >= 0) {
            l.a();
        }
        else {
            this.mOnPreAttachedListeners.add(l);
        }
    }
    
    private void restoreViewState() {
        if (FragmentManager.N0(3)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("moveto RESTORE_VIEW_STATE: ");
            sb.append(this);
            Log.d("FragmentManager", sb.toString());
        }
        if (this.mView != null) {
            this.restoreViewState(this.mSavedFragmentState);
        }
        this.mSavedFragmentState = null;
    }
    
    void callStartTransitionListener(final boolean b) {
        final j mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo != null) {
            mAnimationInfo.t = false;
        }
        if (this.mView != null) {
            final ViewGroup mContainer = this.mContainer;
            if (mContainer != null) {
                final FragmentManager mFragmentManager = this.mFragmentManager;
                if (mFragmentManager != null) {
                    final SpecialEffectsController n = SpecialEffectsController.n(mContainer, mFragmentManager);
                    n.p();
                    if (b) {
                        this.mHost.g().post((Runnable)new Runnable(this, n) {
                            final SpecialEffectsController a;
                            final Fragment b;
                            
                            @Override
                            public void run() {
                                this.a.g();
                            }
                        });
                    }
                    else {
                        n.g();
                    }
                }
            }
        }
    }
    
    androidx.fragment.app.j createFragmentContainer() {
        return new androidx.fragment.app.j(this) {
            final Fragment a;
            
            @Override
            public View c(final int n) {
                final View mView = this.a.mView;
                if (mView != null) {
                    return mView.findViewById(n);
                }
                final StringBuilder sb = new StringBuilder();
                sb.append("Fragment ");
                sb.append(this.a);
                sb.append(" does not have a view");
                throw new IllegalStateException(sb.toString());
            }
            
            @Override
            public boolean d() {
                return this.a.mView != null;
            }
        };
    }
    
    public void dump(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        printWriter.print(s);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.mFragmentId));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.mContainerId));
        printWriter.print(" mTag=");
        printWriter.println(this.mTag);
        printWriter.print(s);
        printWriter.print("mState=");
        printWriter.print(this.mState);
        printWriter.print(" mWho=");
        printWriter.print(this.mWho);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.mBackStackNesting);
        printWriter.print(s);
        printWriter.print("mAdded=");
        printWriter.print(this.mAdded);
        printWriter.print(" mRemoving=");
        printWriter.print(this.mRemoving);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.mFromLayout);
        printWriter.print(" mInLayout=");
        printWriter.println(this.mInLayout);
        printWriter.print(s);
        printWriter.print("mHidden=");
        printWriter.print(this.mHidden);
        printWriter.print(" mDetached=");
        printWriter.print(this.mDetached);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.mMenuVisible);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.mHasMenu);
        printWriter.print(s);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.mRetainInstance);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.mUserVisibleHint);
        if (this.mFragmentManager != null) {
            printWriter.print(s);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.mFragmentManager);
        }
        if (this.mHost != null) {
            printWriter.print(s);
            printWriter.print("mHost=");
            printWriter.println(this.mHost);
        }
        if (this.mParentFragment != null) {
            printWriter.print(s);
            printWriter.print("mParentFragment=");
            printWriter.println(this.mParentFragment);
        }
        if (this.mArguments != null) {
            printWriter.print(s);
            printWriter.print("mArguments=");
            printWriter.println(this.mArguments);
        }
        if (this.mSavedFragmentState != null) {
            printWriter.print(s);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.mSavedFragmentState);
        }
        if (this.mSavedViewState != null) {
            printWriter.print(s);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.mSavedViewState);
        }
        if (this.mSavedViewRegistryState != null) {
            printWriter.print(s);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.mSavedViewRegistryState);
        }
        final Fragment targetFragment = this.getTargetFragment(false);
        if (targetFragment != null) {
            printWriter.print(s);
            printWriter.print("mTarget=");
            printWriter.print(targetFragment);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.mTargetRequestCode);
        }
        printWriter.print(s);
        printWriter.print("mPopDirection=");
        printWriter.println(this.getPopDirection());
        if (this.getEnterAnim() != 0) {
            printWriter.print(s);
            printWriter.print("getEnterAnim=");
            printWriter.println(this.getEnterAnim());
        }
        if (this.getExitAnim() != 0) {
            printWriter.print(s);
            printWriter.print("getExitAnim=");
            printWriter.println(this.getExitAnim());
        }
        if (this.getPopEnterAnim() != 0) {
            printWriter.print(s);
            printWriter.print("getPopEnterAnim=");
            printWriter.println(this.getPopEnterAnim());
        }
        if (this.getPopExitAnim() != 0) {
            printWriter.print(s);
            printWriter.print("getPopExitAnim=");
            printWriter.println(this.getPopExitAnim());
        }
        if (this.mContainer != null) {
            printWriter.print(s);
            printWriter.print("mContainer=");
            printWriter.println(this.mContainer);
        }
        if (this.mView != null) {
            printWriter.print(s);
            printWriter.print("mView=");
            printWriter.println(this.mView);
        }
        if (this.getAnimatingAway() != null) {
            printWriter.print(s);
            printWriter.print("mAnimatingAway=");
            printWriter.println(this.getAnimatingAway());
        }
        if (this.getContext() != null) {
            androidx.loader.app.a.b(this).a(s, fileDescriptor, printWriter, array);
        }
        printWriter.print(s);
        final StringBuilder sb = new StringBuilder();
        sb.append("Child ");
        sb.append(this.mChildFragmentManager);
        sb.append(":");
        printWriter.println(sb.toString());
        final FragmentManager mChildFragmentManager = this.mChildFragmentManager;
        final StringBuilder sb2 = new StringBuilder();
        sb2.append(s);
        sb2.append("  ");
        mChildFragmentManager.Z(sb2.toString(), fileDescriptor, printWriter, array);
    }
    
    @Override
    public final boolean equals(final Object o) {
        return super.equals(o);
    }
    
    Fragment findFragmentByWho(final String s) {
        if (s.equals(this.mWho)) {
            return this;
        }
        return this.mChildFragmentManager.l0(s);
    }
    
    String generateActivityResultKey() {
        final StringBuilder sb = new StringBuilder();
        sb.append("fragment_");
        sb.append(this.mWho);
        sb.append("_rq#");
        sb.append(this.mNextLocalRequestCode.getAndIncrement());
        return sb.toString();
    }
    
    public final h getActivity() {
        final m<?> mHost = this.mHost;
        h h;
        if (mHost == null) {
            h = null;
        }
        else {
            h = (h)mHost.e();
        }
        return h;
    }
    
    public boolean getAllowEnterTransitionOverlap() {
        final j mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo != null) {
            final Boolean q = mAnimationInfo.q;
            if (q != null) {
                return q;
            }
        }
        return true;
    }
    
    public boolean getAllowReturnTransitionOverlap() {
        final j mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo != null) {
            final Boolean p = mAnimationInfo.p;
            if (p != null) {
                return p;
            }
        }
        return true;
    }
    
    View getAnimatingAway() {
        final j mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo == null) {
            return null;
        }
        return mAnimationInfo.a;
    }
    
    public final Bundle getArguments() {
        return this.mArguments;
    }
    
    public final FragmentManager getChildFragmentManager() {
        if (this.mHost != null) {
            return this.mChildFragmentManager;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" has not been attached yet.");
        throw new IllegalStateException(sb.toString());
    }
    
    public Context getContext() {
        final m<?> mHost = this.mHost;
        Context f;
        if (mHost == null) {
            f = null;
        }
        else {
            f = mHost.f();
        }
        return f;
    }
    
    public k0.a getDefaultViewModelCreationExtras() {
        while (true) {
            for (Context context = this.requireContext().getApplicationContext(); context instanceof ContextWrapper; context = ((ContextWrapper)context).getBaseContext()) {
                if (context instanceof Application) {
                    final Application application = (Application)context;
                    if (application == null && FragmentManager.N0(3)) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Could not find Application instance from Context ");
                        sb.append(this.requireContext().getApplicationContext());
                        sb.append(", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
                        Log.d("FragmentManager", sb.toString());
                    }
                    final k0.d d = new k0.d();
                    if (application != null) {
                        d.c(o0.a.h, application);
                    }
                    d.c(SavedStateHandleSupport.a, this);
                    d.c(SavedStateHandleSupport.b, this);
                    if (this.getArguments() != null) {
                        d.c(SavedStateHandleSupport.c, this.getArguments());
                    }
                    return d;
                }
            }
            final Application application = null;
            continue;
        }
    }
    
    public o0.b getDefaultViewModelProviderFactory() {
        if (this.mFragmentManager != null) {
            if (this.mDefaultFactory == null) {
                final Application application = null;
                Context context = this.requireContext().getApplicationContext();
                Application application2;
                while (true) {
                    application2 = application;
                    if (!(context instanceof ContextWrapper)) {
                        break;
                    }
                    if (context instanceof Application) {
                        application2 = (Application)context;
                        break;
                    }
                    context = ((ContextWrapper)context).getBaseContext();
                }
                if (application2 == null && FragmentManager.N0(3)) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Could not find Application instance from Context ");
                    sb.append(this.requireContext().getApplicationContext());
                    sb.append(", you will need CreationExtras to use AndroidViewModel with the default ViewModelProvider.Factory");
                    Log.d("FragmentManager", sb.toString());
                }
                this.mDefaultFactory = new i0(application2, this, this.getArguments());
            }
            return this.mDefaultFactory;
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }
    
    int getEnterAnim() {
        final j mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo == null) {
            return 0;
        }
        return mAnimationInfo.c;
    }
    
    public Object getEnterTransition() {
        final j mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo == null) {
            return null;
        }
        return mAnimationInfo.j;
    }
    
    u getEnterTransitionCallback() {
        final j mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo == null) {
            return null;
        }
        Objects.requireNonNull(mAnimationInfo);
        return null;
    }
    
    int getExitAnim() {
        final j mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo == null) {
            return 0;
        }
        return mAnimationInfo.d;
    }
    
    public Object getExitTransition() {
        final j mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo == null) {
            return null;
        }
        return mAnimationInfo.l;
    }
    
    u getExitTransitionCallback() {
        final j mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo == null) {
            return null;
        }
        Objects.requireNonNull(mAnimationInfo);
        return null;
    }
    
    View getFocusedView() {
        final j mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo == null) {
            return null;
        }
        return mAnimationInfo.s;
    }
    
    @Deprecated
    public final FragmentManager getFragmentManager() {
        return this.mFragmentManager;
    }
    
    public final Object getHost() {
        final m<?> mHost = this.mHost;
        Object i;
        if (mHost == null) {
            i = null;
        }
        else {
            i = mHost.i();
        }
        return i;
    }
    
    public final int getId() {
        return this.mFragmentId;
    }
    
    public final LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflater;
        if ((layoutInflater = this.mLayoutInflater) == null) {
            layoutInflater = this.performGetLayoutInflater(null);
        }
        return layoutInflater;
    }
    
    @Deprecated
    public LayoutInflater getLayoutInflater(final Bundle bundle) {
        final m<?> mHost = this.mHost;
        if (mHost != null) {
            final LayoutInflater j = mHost.j();
            androidx.core.view.h.a(j, this.mChildFragmentManager.B0());
            return j;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }
    
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }
    
    @Deprecated
    public androidx.loader.app.a getLoaderManager() {
        return androidx.loader.app.a.b(this);
    }
    
    int getNextTransition() {
        final j mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo == null) {
            return 0;
        }
        return mAnimationInfo.g;
    }
    
    public final Fragment getParentFragment() {
        return this.mParentFragment;
    }
    
    public final FragmentManager getParentFragmentManager() {
        final FragmentManager mFragmentManager = this.mFragmentManager;
        if (mFragmentManager != null) {
            return mFragmentManager;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" not associated with a fragment manager.");
        throw new IllegalStateException(sb.toString());
    }
    
    boolean getPopDirection() {
        final j mAnimationInfo = this.mAnimationInfo;
        return mAnimationInfo != null && mAnimationInfo.b;
    }
    
    int getPopEnterAnim() {
        final j mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo == null) {
            return 0;
        }
        return mAnimationInfo.e;
    }
    
    int getPopExitAnim() {
        final j mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo == null) {
            return 0;
        }
        return mAnimationInfo.f;
    }
    
    float getPostOnViewCreatedAlpha() {
        final j mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo == null) {
            return 1.0f;
        }
        return mAnimationInfo.r;
    }
    
    public Object getReenterTransition() {
        final j mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo == null) {
            return null;
        }
        Object o;
        if ((o = mAnimationInfo.m) == Fragment.USE_DEFAULT_TRANSITION) {
            o = this.getExitTransition();
        }
        return o;
    }
    
    public final Resources getResources() {
        return this.requireContext().getResources();
    }
    
    @Deprecated
    public final boolean getRetainInstance() {
        FragmentStrictMode.j(this);
        return this.mRetainInstance;
    }
    
    public Object getReturnTransition() {
        final j mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo == null) {
            return null;
        }
        Object o;
        if ((o = mAnimationInfo.k) == Fragment.USE_DEFAULT_TRANSITION) {
            o = this.getEnterTransition();
        }
        return o;
    }
    
    public final u0.c getSavedStateRegistry() {
        return this.mSavedStateRegistryController.b();
    }
    
    public Object getSharedElementEnterTransition() {
        final j mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo == null) {
            return null;
        }
        return mAnimationInfo.n;
    }
    
    public Object getSharedElementReturnTransition() {
        final j mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo == null) {
            return null;
        }
        Object o;
        if ((o = mAnimationInfo.o) == Fragment.USE_DEFAULT_TRANSITION) {
            o = this.getSharedElementEnterTransition();
        }
        return o;
    }
    
    ArrayList<String> getSharedElementSourceNames() {
        final j mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo != null) {
            final ArrayList<String> h = mAnimationInfo.h;
            if (h != null) {
                return h;
            }
        }
        return new ArrayList<String>();
    }
    
    ArrayList<String> getSharedElementTargetNames() {
        final j mAnimationInfo = this.mAnimationInfo;
        if (mAnimationInfo != null) {
            final ArrayList<String> i = mAnimationInfo.i;
            if (i != null) {
                return i;
            }
        }
        return new ArrayList<String>();
    }
    
    public final String getString(final int n) {
        return this.getResources().getString(n);
    }
    
    public final String getString(final int n, final Object... array) {
        return this.getResources().getString(n, array);
    }
    
    public final String getTag() {
        return this.mTag;
    }
    
    @Deprecated
    public final Fragment getTargetFragment() {
        return this.getTargetFragment(true);
    }
    
    @Deprecated
    public final int getTargetRequestCode() {
        FragmentStrictMode.k(this);
        return this.mTargetRequestCode;
    }
    
    public final CharSequence getText(final int n) {
        return this.getResources().getText(n);
    }
    
    @Deprecated
    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }
    
    public View getView() {
        return this.mView;
    }
    
    public r getViewLifecycleOwner() {
        final g0 mViewLifecycleOwner = this.mViewLifecycleOwner;
        if (mViewLifecycleOwner != null) {
            return mViewLifecycleOwner;
        }
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }
    
    public LiveData<r> getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }
    
    public q0 getViewModelStore() {
        if (this.mFragmentManager == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (this.getMinimumMaxLifecycleState() != Lifecycle.State.INITIALIZED.ordinal()) {
            return this.mFragmentManager.I0(this);
        }
        throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
    }
    
    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }
    
    @Override
    public final int hashCode() {
        return super.hashCode();
    }
    
    void initState() {
        this.initLifecycle();
        this.mPreviousWho = this.mWho;
        this.mWho = UUID.randomUUID().toString();
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = new w();
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
    }
    
    public final boolean isAdded() {
        return this.mHost != null && this.mAdded;
    }
    
    public final boolean isDetached() {
        return this.mDetached;
    }
    
    public final boolean isHidden() {
        if (!this.mHidden) {
            final FragmentManager mFragmentManager = this.mFragmentManager;
            if (mFragmentManager == null || !mFragmentManager.P0(this.mParentFragment)) {
                return false;
            }
        }
        return true;
    }
    
    final boolean isInBackStack() {
        return this.mBackStackNesting > 0;
    }
    
    public final boolean isInLayout() {
        return this.mInLayout;
    }
    
    public final boolean isMenuVisible() {
        if (this.mMenuVisible) {
            final FragmentManager mFragmentManager = this.mFragmentManager;
            if (mFragmentManager == null || mFragmentManager.Q0(this.mParentFragment)) {
                return true;
            }
        }
        return false;
    }
    
    boolean isPostponed() {
        final j mAnimationInfo = this.mAnimationInfo;
        return mAnimationInfo != null && mAnimationInfo.t;
    }
    
    public final boolean isRemoving() {
        return this.mRemoving;
    }
    
    public final boolean isResumed() {
        return this.mState >= 7;
    }
    
    public final boolean isStateSaved() {
        final FragmentManager mFragmentManager = this.mFragmentManager;
        return mFragmentManager != null && mFragmentManager.T0();
    }
    
    public final boolean isVisible() {
        if (this.isAdded() && !this.isHidden()) {
            final View mView = this.mView;
            if (mView != null && mView.getWindowToken() != null && this.mView.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }
    
    void noteStateNotSaved() {
        this.mChildFragmentManager.d1();
    }
    
    @Deprecated
    public void onActivityCreated(final Bundle bundle) {
        this.mCalled = true;
    }
    
    @Deprecated
    public void onActivityResult(final int n, final int n2, final Intent intent) {
        if (FragmentManager.N0(2)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Fragment ");
            sb.append(this);
            sb.append(" received the following in onActivityResult(): requestCode: ");
            sb.append(n);
            sb.append(" resultCode: ");
            sb.append(n2);
            sb.append(" data: ");
            sb.append(intent);
            Log.v("FragmentManager", sb.toString());
        }
    }
    
    @Deprecated
    public void onAttach(final Activity activity) {
        this.mCalled = true;
    }
    
    public void onAttach(final Context context) {
        this.mCalled = true;
        final m<?> mHost = this.mHost;
        Activity e;
        if (mHost == null) {
            e = null;
        }
        else {
            e = mHost.e();
        }
        if (e != null) {
            this.mCalled = false;
            this.onAttach(e);
        }
    }
    
    @Deprecated
    public void onAttachFragment(final Fragment fragment) {
    }
    
    public void onConfigurationChanged(final Configuration configuration) {
        this.mCalled = true;
    }
    
    public boolean onContextItemSelected(final MenuItem menuItem) {
        return false;
    }
    
    public void onCreate(final Bundle bundle) {
        this.mCalled = true;
        this.restoreChildFragmentState(bundle);
        if (!this.mChildFragmentManager.S0(1)) {
            this.mChildFragmentManager.E();
        }
    }
    
    public Animation onCreateAnimation(final int n, final boolean b, final int n2) {
        return null;
    }
    
    public Animator onCreateAnimator(final int n, final boolean b, final int n2) {
        return null;
    }
    
    public void onCreateContextMenu(final ContextMenu contextMenu, final View view, final ContextMenu$ContextMenuInfo contextMenu$ContextMenuInfo) {
        this.requireActivity().onCreateContextMenu(contextMenu, view, contextMenu$ContextMenuInfo);
    }
    
    @Deprecated
    public void onCreateOptionsMenu(final Menu menu, final MenuInflater menuInflater) {
    }
    
    public View onCreateView(final LayoutInflater layoutInflater, final ViewGroup viewGroup, final Bundle bundle) {
        final int mContentLayoutId = this.mContentLayoutId;
        if (mContentLayoutId != 0) {
            return layoutInflater.inflate(mContentLayoutId, viewGroup, false);
        }
        return null;
    }
    
    public void onDestroy() {
        this.mCalled = true;
    }
    
    @Deprecated
    public void onDestroyOptionsMenu() {
    }
    
    public void onDestroyView() {
        this.mCalled = true;
    }
    
    public void onDetach() {
        this.mCalled = true;
    }
    
    public LayoutInflater onGetLayoutInflater(final Bundle bundle) {
        return this.getLayoutInflater(bundle);
    }
    
    public void onHiddenChanged(final boolean b) {
    }
    
    @Deprecated
    public void onInflate(final Activity activity, final AttributeSet set, final Bundle bundle) {
        this.mCalled = true;
    }
    
    public void onInflate(final Context context, final AttributeSet set, final Bundle bundle) {
        this.mCalled = true;
        final m<?> mHost = this.mHost;
        Activity e;
        if (mHost == null) {
            e = null;
        }
        else {
            e = mHost.e();
        }
        if (e != null) {
            this.mCalled = false;
            this.onInflate(e, set, bundle);
        }
    }
    
    public void onLowMemory() {
        this.mCalled = true;
    }
    
    public void onMultiWindowModeChanged(final boolean b) {
    }
    
    @Deprecated
    public boolean onOptionsItemSelected(final MenuItem menuItem) {
        return false;
    }
    
    @Deprecated
    public void onOptionsMenuClosed(final Menu menu) {
    }
    
    public void onPause() {
        this.mCalled = true;
    }
    
    public void onPictureInPictureModeChanged(final boolean b) {
    }
    
    @Deprecated
    public void onPrepareOptionsMenu(final Menu menu) {
    }
    
    public void onPrimaryNavigationFragmentChanged(final boolean b) {
    }
    
    @Deprecated
    public void onRequestPermissionsResult(final int n, final String[] array, final int[] array2) {
    }
    
    public void onResume() {
        this.mCalled = true;
    }
    
    public void onSaveInstanceState(final Bundle bundle) {
    }
    
    public void onStart() {
        this.mCalled = true;
    }
    
    public void onStop() {
        this.mCalled = true;
    }
    
    public void onViewCreated(final View view, final Bundle bundle) {
    }
    
    public void onViewStateRestored(final Bundle bundle) {
        this.mCalled = true;
    }
    
    void performActivityCreated(final Bundle bundle) {
        this.mChildFragmentManager.d1();
        this.mState = 3;
        this.mCalled = false;
        this.onActivityCreated(bundle);
        if (this.mCalled) {
            this.restoreViewState();
            this.mChildFragmentManager.A();
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" did not call through to super.onActivityCreated()");
        throw new SuperNotCalledException(sb.toString());
    }
    
    void performAttach() {
        final Iterator<l> iterator = this.mOnPreAttachedListeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().a();
        }
        this.mOnPreAttachedListeners.clear();
        this.mChildFragmentManager.o(this.mHost, this.createFragmentContainer(), this);
        this.mState = 0;
        this.mCalled = false;
        this.onAttach(this.mHost.f());
        if (this.mCalled) {
            this.mFragmentManager.K(this);
            this.mChildFragmentManager.B();
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" did not call through to super.onAttach()");
        throw new SuperNotCalledException(sb.toString());
    }
    
    void performConfigurationChanged(final Configuration configuration) {
        this.onConfigurationChanged(configuration);
        this.mChildFragmentManager.C(configuration);
    }
    
    boolean performContextItemSelected(final MenuItem menuItem) {
        return !this.mHidden && (this.onContextItemSelected(menuItem) || this.mChildFragmentManager.D(menuItem));
    }
    
    void performCreate(final Bundle bundle) {
        this.mChildFragmentManager.d1();
        this.mState = 1;
        this.mCalled = false;
        this.mLifecycleRegistry.a(new o(this) {
            final Fragment a;
            
            @Override
            public void f(final r r, final Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_STOP) {
                    final View mView = this.a.mView;
                    if (mView != null) {
                        k.a(mView);
                    }
                }
            }
        });
        this.mSavedStateRegistryController.d(bundle);
        this.onCreate(bundle);
        this.mIsCreated = true;
        if (this.mCalled) {
            this.mLifecycleRegistry.h(Lifecycle.Event.ON_CREATE);
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" did not call through to super.onCreate()");
        throw new SuperNotCalledException(sb.toString());
    }
    
    boolean performCreateOptionsMenu(final Menu menu, final MenuInflater menuInflater) {
        final boolean mHidden = this.mHidden;
        boolean b = false;
        final boolean b2 = false;
        if (!mHidden) {
            boolean b3 = b2;
            if (this.mHasMenu) {
                b3 = b2;
                if (this.mMenuVisible) {
                    b3 = true;
                    this.onCreateOptionsMenu(menu, menuInflater);
                }
            }
            b = (b3 | this.mChildFragmentManager.F(menu, menuInflater));
        }
        return b;
    }
    
    void performCreateView(final LayoutInflater layoutInflater, final ViewGroup viewGroup, final Bundle bundle) {
        this.mChildFragmentManager.d1();
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new g0(this, this.getViewModelStore());
        final View onCreateView = this.onCreateView(layoutInflater, viewGroup, bundle);
        this.mView = onCreateView;
        if (onCreateView != null) {
            this.mViewLifecycleOwner.b();
            s0.a(this.mView, this.mViewLifecycleOwner);
            t0.a(this.mView, this.mViewLifecycleOwner);
            f.a(this.mView, this.mViewLifecycleOwner);
            this.mViewLifecycleOwnerLiveData.setValue(this.mViewLifecycleOwner);
        }
        else {
            if (this.mViewLifecycleOwner.c()) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.mViewLifecycleOwner = null;
        }
    }
    
    void performDestroy() {
        this.mChildFragmentManager.G();
        this.mLifecycleRegistry.h(Lifecycle.Event.ON_DESTROY);
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        this.onDestroy();
        if (this.mCalled) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" did not call through to super.onDestroy()");
        throw new SuperNotCalledException(sb.toString());
    }
    
    void performDestroyView() {
        this.mChildFragmentManager.H();
        if (this.mView != null && this.mViewLifecycleOwner.getLifecycle().b().isAtLeast(Lifecycle.State.CREATED)) {
            this.mViewLifecycleOwner.a(Lifecycle.Event.ON_DESTROY);
        }
        this.mState = 1;
        this.mCalled = false;
        this.onDestroyView();
        if (this.mCalled) {
            androidx.loader.app.a.b(this).d();
            this.mPerformedCreateView = false;
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" did not call through to super.onDestroyView()");
        throw new SuperNotCalledException(sb.toString());
    }
    
    void performDetach() {
        this.mState = -1;
        this.mCalled = false;
        this.onDetach();
        this.mLayoutInflater = null;
        if (this.mCalled) {
            if (!this.mChildFragmentManager.M0()) {
                this.mChildFragmentManager.G();
                this.mChildFragmentManager = new w();
            }
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" did not call through to super.onDetach()");
        throw new SuperNotCalledException(sb.toString());
    }
    
    LayoutInflater performGetLayoutInflater(final Bundle bundle) {
        return this.mLayoutInflater = this.onGetLayoutInflater(bundle);
    }
    
    void performLowMemory() {
        this.onLowMemory();
        this.mChildFragmentManager.I();
    }
    
    void performMultiWindowModeChanged(final boolean b) {
        this.onMultiWindowModeChanged(b);
        this.mChildFragmentManager.J(b);
    }
    
    boolean performOptionsItemSelected(final MenuItem menuItem) {
        return !this.mHidden && ((this.mHasMenu && this.mMenuVisible && this.onOptionsItemSelected(menuItem)) || this.mChildFragmentManager.M(menuItem));
    }
    
    void performOptionsMenuClosed(final Menu menu) {
        if (!this.mHidden) {
            if (this.mHasMenu && this.mMenuVisible) {
                this.onOptionsMenuClosed(menu);
            }
            this.mChildFragmentManager.N(menu);
        }
    }
    
    void performPause() {
        this.mChildFragmentManager.P();
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(Lifecycle.Event.ON_PAUSE);
        }
        this.mLifecycleRegistry.h(Lifecycle.Event.ON_PAUSE);
        this.mState = 6;
        this.mCalled = false;
        this.onPause();
        if (this.mCalled) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" did not call through to super.onPause()");
        throw new SuperNotCalledException(sb.toString());
    }
    
    void performPictureInPictureModeChanged(final boolean b) {
        this.onPictureInPictureModeChanged(b);
        this.mChildFragmentManager.Q(b);
    }
    
    boolean performPrepareOptionsMenu(final Menu menu) {
        final boolean mHidden = this.mHidden;
        boolean b = false;
        final boolean b2 = false;
        if (!mHidden) {
            boolean b3 = b2;
            if (this.mHasMenu) {
                b3 = b2;
                if (this.mMenuVisible) {
                    b3 = true;
                    this.onPrepareOptionsMenu(menu);
                }
            }
            b = (b3 | this.mChildFragmentManager.R(menu));
        }
        return b;
    }
    
    void performPrimaryNavigationFragmentChanged() {
        final boolean r0 = this.mFragmentManager.R0(this);
        final Boolean mIsPrimaryNavigationFragment = this.mIsPrimaryNavigationFragment;
        if (mIsPrimaryNavigationFragment == null || mIsPrimaryNavigationFragment != r0) {
            this.mIsPrimaryNavigationFragment = r0;
            this.onPrimaryNavigationFragmentChanged(r0);
            this.mChildFragmentManager.S();
        }
    }
    
    void performResume() {
        this.mChildFragmentManager.d1();
        this.mChildFragmentManager.d0(true);
        this.mState = 7;
        this.mCalled = false;
        this.onResume();
        if (this.mCalled) {
            final t mLifecycleRegistry = this.mLifecycleRegistry;
            final Lifecycle.Event on_RESUME = Lifecycle.Event.ON_RESUME;
            mLifecycleRegistry.h(on_RESUME);
            if (this.mView != null) {
                this.mViewLifecycleOwner.a(on_RESUME);
            }
            this.mChildFragmentManager.T();
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" did not call through to super.onResume()");
        throw new SuperNotCalledException(sb.toString());
    }
    
    void performSaveInstanceState(final Bundle bundle) {
        this.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.e(bundle);
        final Bundle a1 = this.mChildFragmentManager.A1();
        if (a1 != null) {
            bundle.putParcelable("android:support:fragments", (Parcelable)a1);
        }
    }
    
    void performStart() {
        this.mChildFragmentManager.d1();
        this.mChildFragmentManager.d0(true);
        this.mState = 5;
        this.mCalled = false;
        this.onStart();
        if (this.mCalled) {
            final t mLifecycleRegistry = this.mLifecycleRegistry;
            final Lifecycle.Event on_START = Lifecycle.Event.ON_START;
            mLifecycleRegistry.h(on_START);
            if (this.mView != null) {
                this.mViewLifecycleOwner.a(on_START);
            }
            this.mChildFragmentManager.U();
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" did not call through to super.onStart()");
        throw new SuperNotCalledException(sb.toString());
    }
    
    void performStop() {
        this.mChildFragmentManager.W();
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(Lifecycle.Event.ON_STOP);
        }
        this.mLifecycleRegistry.h(Lifecycle.Event.ON_STOP);
        this.mState = 4;
        this.mCalled = false;
        this.onStop();
        if (this.mCalled) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" did not call through to super.onStop()");
        throw new SuperNotCalledException(sb.toString());
    }
    
    void performViewCreated() {
        this.onViewCreated(this.mView, this.mSavedFragmentState);
        this.mChildFragmentManager.X();
    }
    
    public void postponeEnterTransition() {
        this.ensureAnimationInfo().t = true;
    }
    
    public final void postponeEnterTransition(final long n, final TimeUnit timeUnit) {
        this.ensureAnimationInfo().t = true;
        final FragmentManager mFragmentManager = this.mFragmentManager;
        Handler g;
        if (mFragmentManager != null) {
            g = mFragmentManager.A0().g();
        }
        else {
            g = new Handler(Looper.getMainLooper());
        }
        g.removeCallbacks(this.mPostponedDurationRunnable);
        g.postDelayed(this.mPostponedDurationRunnable, timeUnit.toMillis(n));
    }
    
    public final <I, O> b<I> registerForActivityResult(final a<I, O> a, final ActivityResultRegistry activityResultRegistry, final androidx.activity.result.a<O> a2) {
        return this.prepareCallInternal(a, new k.a<Void, ActivityResultRegistry>(this, activityResultRegistry) {
            final ActivityResultRegistry a;
            final Fragment b;
            
            public ActivityResultRegistry a(final Void void1) {
                return this.a;
            }
            
            @Override
            public /* bridge */ Object apply(final Object o) {
                return this.a((Void)o);
            }
        }, a2);
    }
    
    public final <I, O> b<I> registerForActivityResult(final a<I, O> a, final androidx.activity.result.a<O> a2) {
        return this.prepareCallInternal(a, new k.a<Void, ActivityResultRegistry>(this) {
            final Fragment a;
            
            public ActivityResultRegistry a(final Void void1) {
                final Fragment a = this.a;
                final m<?> mHost = a.mHost;
                if (mHost instanceof androidx.activity.result.c) {
                    return ((androidx.activity.result.c)mHost).getActivityResultRegistry();
                }
                return a.requireActivity().getActivityResultRegistry();
            }
            
            @Override
            public /* bridge */ Object apply(final Object o) {
                return this.a((Void)o);
            }
        }, a2);
    }
    
    public void registerForContextMenu(final View view) {
        view.setOnCreateContextMenuListener((View$OnCreateContextMenuListener)this);
    }
    
    @Deprecated
    public final void requestPermissions(final String[] array, final int n) {
        if (this.mHost != null) {
            this.getParentFragmentManager().Z0(this, array, n);
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" not attached to Activity");
        throw new IllegalStateException(sb.toString());
    }
    
    public final h requireActivity() {
        final h activity = this.getActivity();
        if (activity != null) {
            return activity;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" not attached to an activity.");
        throw new IllegalStateException(sb.toString());
    }
    
    public final Bundle requireArguments() {
        final Bundle arguments = this.getArguments();
        if (arguments != null) {
            return arguments;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" does not have any arguments.");
        throw new IllegalStateException(sb.toString());
    }
    
    public final Context requireContext() {
        final Context context = this.getContext();
        if (context != null) {
            return context;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" not attached to a context.");
        throw new IllegalStateException(sb.toString());
    }
    
    @Deprecated
    public final FragmentManager requireFragmentManager() {
        return this.getParentFragmentManager();
    }
    
    public final Object requireHost() {
        final Object host = this.getHost();
        if (host != null) {
            return host;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" not attached to a host.");
        throw new IllegalStateException(sb.toString());
    }
    
    public final Fragment requireParentFragment() {
        final Fragment parentFragment = this.getParentFragment();
        if (parentFragment != null) {
            return parentFragment;
        }
        if (this.getContext() == null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Fragment ");
            sb.append(this);
            sb.append(" is not attached to any Fragment or host");
            throw new IllegalStateException(sb.toString());
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("Fragment ");
        sb2.append(this);
        sb2.append(" is not a child Fragment, it is directly attached to ");
        sb2.append(this.getContext());
        throw new IllegalStateException(sb2.toString());
    }
    
    public final View requireView() {
        final View view = this.getView();
        if (view != null) {
            return view;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" did not return a View from onCreateView() or this was called before onCreateView().");
        throw new IllegalStateException(sb.toString());
    }
    
    void restoreChildFragmentState(final Bundle bundle) {
        if (bundle != null) {
            final Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            if (parcelable != null) {
                this.mChildFragmentManager.y1(parcelable);
                this.mChildFragmentManager.E();
            }
        }
    }
    
    final void restoreViewState(final Bundle bundle) {
        final SparseArray<Parcelable> mSavedViewState = this.mSavedViewState;
        if (mSavedViewState != null) {
            this.mView.restoreHierarchyState((SparseArray)mSavedViewState);
            this.mSavedViewState = null;
        }
        if (this.mView != null) {
            this.mViewLifecycleOwner.d(this.mSavedViewRegistryState);
            this.mSavedViewRegistryState = null;
        }
        this.mCalled = false;
        this.onViewStateRestored(bundle);
        if (this.mCalled) {
            if (this.mView != null) {
                this.mViewLifecycleOwner.a(Lifecycle.Event.ON_CREATE);
            }
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" did not call through to super.onViewStateRestored()");
        throw new SuperNotCalledException(sb.toString());
    }
    
    public void setAllowEnterTransitionOverlap(final boolean b) {
        this.ensureAnimationInfo().q = b;
    }
    
    public void setAllowReturnTransitionOverlap(final boolean b) {
        this.ensureAnimationInfo().p = b;
    }
    
    void setAnimations(final int c, final int d, final int e, final int f) {
        if (this.mAnimationInfo == null && c == 0 && d == 0 && e == 0 && f == 0) {
            return;
        }
        this.ensureAnimationInfo().c = c;
        this.ensureAnimationInfo().d = d;
        this.ensureAnimationInfo().e = e;
        this.ensureAnimationInfo().f = f;
    }
    
    public void setArguments(final Bundle mArguments) {
        if (this.mFragmentManager != null && this.isStateSaved()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.mArguments = mArguments;
    }
    
    public void setEnterSharedElementCallback(final u u) {
        Objects.requireNonNull(this.ensureAnimationInfo());
    }
    
    public void setEnterTransition(final Object j) {
        this.ensureAnimationInfo().j = j;
    }
    
    public void setExitSharedElementCallback(final u u) {
        Objects.requireNonNull(this.ensureAnimationInfo());
    }
    
    public void setExitTransition(final Object l) {
        this.ensureAnimationInfo().l = l;
    }
    
    void setFocusedView(final View s) {
        this.ensureAnimationInfo().s = s;
    }
    
    @Deprecated
    public void setHasOptionsMenu(final boolean mHasMenu) {
        if (this.mHasMenu != mHasMenu) {
            this.mHasMenu = mHasMenu;
            if (this.isAdded() && !this.isHidden()) {
                this.mHost.o();
            }
        }
    }
    
    public void setInitialSavedState(final SavedState savedState) {
        if (this.mFragmentManager == null) {
            Bundle a = null;
            Label_0025: {
                if (savedState != null) {
                    a = savedState.a;
                    if (a != null) {
                        break Label_0025;
                    }
                }
                a = null;
            }
            this.mSavedFragmentState = a;
            return;
        }
        throw new IllegalStateException("Fragment already added");
    }
    
    public void setMenuVisibility(final boolean mMenuVisible) {
        if (this.mMenuVisible != mMenuVisible) {
            this.mMenuVisible = mMenuVisible;
            if (this.mHasMenu && this.isAdded() && !this.isHidden()) {
                this.mHost.o();
            }
        }
    }
    
    void setNextTransition(final int g) {
        if (this.mAnimationInfo == null && g == 0) {
            return;
        }
        this.ensureAnimationInfo();
        this.mAnimationInfo.g = g;
    }
    
    void setPopDirection(final boolean b) {
        if (this.mAnimationInfo == null) {
            return;
        }
        this.ensureAnimationInfo().b = b;
    }
    
    void setPostOnViewCreatedAlpha(final float r) {
        this.ensureAnimationInfo().r = r;
    }
    
    public void setReenterTransition(final Object m) {
        this.ensureAnimationInfo().m = m;
    }
    
    @Deprecated
    public void setRetainInstance(final boolean mRetainInstance) {
        FragmentStrictMode.m(this);
        this.mRetainInstance = mRetainInstance;
        final FragmentManager mFragmentManager = this.mFragmentManager;
        if (mFragmentManager != null) {
            if (mRetainInstance) {
                mFragmentManager.m(this);
            }
            else {
                mFragmentManager.u1(this);
            }
        }
        else {
            this.mRetainInstanceChangedWhileDetached = true;
        }
    }
    
    public void setReturnTransition(final Object k) {
        this.ensureAnimationInfo().k = k;
    }
    
    public void setSharedElementEnterTransition(final Object n) {
        this.ensureAnimationInfo().n = n;
    }
    
    void setSharedElementNames(final ArrayList<String> h, final ArrayList<String> i) {
        this.ensureAnimationInfo();
        final j mAnimationInfo = this.mAnimationInfo;
        mAnimationInfo.h = h;
        mAnimationInfo.i = i;
    }
    
    public void setSharedElementReturnTransition(final Object o) {
        this.ensureAnimationInfo().o = o;
    }
    
    @Deprecated
    public void setTargetFragment(final Fragment mTarget, final int mTargetRequestCode) {
        if (mTarget != null) {
            FragmentStrictMode.n(this, mTarget, mTargetRequestCode);
        }
        final FragmentManager mFragmentManager = this.mFragmentManager;
        FragmentManager mFragmentManager2;
        if (mTarget != null) {
            mFragmentManager2 = mTarget.mFragmentManager;
        }
        else {
            mFragmentManager2 = null;
        }
        if (mFragmentManager != null && mFragmentManager2 != null && mFragmentManager != mFragmentManager2) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Fragment ");
            sb.append(mTarget);
            sb.append(" must share the same FragmentManager to be set as a target fragment");
            throw new IllegalArgumentException(sb.toString());
        }
        for (Fragment targetFragment = mTarget; targetFragment != null; targetFragment = targetFragment.getTargetFragment(false)) {
            if (targetFragment.equals(this)) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Setting ");
                sb2.append(mTarget);
                sb2.append(" as the target of ");
                sb2.append(this);
                sb2.append(" would create a target cycle");
                throw new IllegalArgumentException(sb2.toString());
            }
        }
        if (mTarget == null) {
            this.mTargetWho = null;
            this.mTarget = null;
        }
        else if (this.mFragmentManager != null && mTarget.mFragmentManager != null) {
            this.mTargetWho = mTarget.mWho;
            this.mTarget = null;
        }
        else {
            this.mTargetWho = null;
            this.mTarget = mTarget;
        }
        this.mTargetRequestCode = mTargetRequestCode;
    }
    
    @Deprecated
    public void setUserVisibleHint(final boolean mUserVisibleHint) {
        FragmentStrictMode.o(this, mUserVisibleHint);
        if (!this.mUserVisibleHint && mUserVisibleHint && this.mState < 5 && this.mFragmentManager != null && this.isAdded() && this.mIsCreated) {
            final FragmentManager mFragmentManager = this.mFragmentManager;
            mFragmentManager.f1(mFragmentManager.y(this));
        }
        this.mUserVisibleHint = mUserVisibleHint;
        this.mDeferStart = (this.mState < 5 && !mUserVisibleHint);
        if (this.mSavedFragmentState != null) {
            this.mSavedUserVisibleHint = mUserVisibleHint;
        }
    }
    
    public boolean shouldShowRequestPermissionRationale(final String s) {
        final m<?> mHost = this.mHost;
        return mHost != null && mHost.l(s);
    }
    
    public void startActivity(final Intent intent) {
        this.startActivity(intent, null);
    }
    
    public void startActivity(final Intent intent, final Bundle bundle) {
        final m<?> mHost = this.mHost;
        if (mHost != null) {
            mHost.m(this, intent, -1, bundle);
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" not attached to Activity");
        throw new IllegalStateException(sb.toString());
    }
    
    @Deprecated
    public void startActivityForResult(final Intent intent, final int n) {
        this.startActivityForResult(intent, n, null);
    }
    
    @Deprecated
    public void startActivityForResult(final Intent intent, final int n, final Bundle bundle) {
        if (this.mHost != null) {
            this.getParentFragmentManager().a1(this, intent, n, bundle);
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this);
        sb.append(" not attached to Activity");
        throw new IllegalStateException(sb.toString());
    }
    
    @Deprecated
    public void startIntentSenderForResult(final IntentSender intentSender, final int n, final Intent intent, final int n2, final int n3, final int n4, final Bundle bundle) throws IntentSender$SendIntentException {
        if (this.mHost != null) {
            if (FragmentManager.N0(2)) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Fragment ");
                sb.append(this);
                sb.append(" received the following in startIntentSenderForResult() requestCode: ");
                sb.append(n);
                sb.append(" IntentSender: ");
                sb.append(intentSender);
                sb.append(" fillInIntent: ");
                sb.append(intent);
                sb.append(" options: ");
                sb.append(bundle);
                Log.v("FragmentManager", sb.toString());
            }
            this.getParentFragmentManager().b1(this, intentSender, n, intent, n2, n3, n4, bundle);
            return;
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("Fragment ");
        sb2.append(this);
        sb2.append(" not attached to Activity");
        throw new IllegalStateException(sb2.toString());
    }
    
    public void startPostponedEnterTransition() {
        if (this.mAnimationInfo != null) {
            if (this.ensureAnimationInfo().t) {
                if (this.mHost == null) {
                    this.ensureAnimationInfo().t = false;
                }
                else if (Looper.myLooper() != this.mHost.g().getLooper()) {
                    this.mHost.g().postAtFrontOfQueue((Runnable)new Runnable(this) {
                        final Fragment a;
                        
                        @Override
                        public void run() {
                            this.a.callStartTransitionListener(false);
                        }
                    });
                }
                else {
                    this.callStartTransitionListener(true);
                }
            }
        }
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(128);
        sb.append(this.getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("}");
        sb.append(" (");
        sb.append(this.mWho);
        if (this.mFragmentId != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            sb.append(" tag=");
            sb.append(this.mTag);
        }
        sb.append(")");
        return sb.toString();
    }
    
    public void unregisterForContextMenu(final View view) {
        view.setOnCreateContextMenuListener((View$OnCreateContextMenuListener)null);
    }
    
    public static class InstantiationException extends RuntimeException
    {
        public InstantiationException(final String s, final Exception ex) {
            super(s, ex);
        }
    }
    
    public static class SavedState implements Parcelable
    {
        public static final Parcelable$Creator<SavedState> CREATOR;
        final Bundle a;
        
        static {
            CREATOR = (Parcelable$Creator)new Parcelable$ClassLoaderCreator<SavedState>() {
                public SavedState a(final Parcel parcel) {
                    return new SavedState(parcel, null);
                }
                
                public SavedState b(final Parcel parcel, final ClassLoader classLoader) {
                    return new SavedState(parcel, classLoader);
                }
                
                public SavedState[] c(final int n) {
                    return new SavedState[n];
                }
                
                public /* bridge */ Object createFromParcel(final Parcel parcel) {
                    return this.a(parcel);
                }
                
                public /* bridge */ Object createFromParcel(final Parcel parcel, final ClassLoader classLoader) {
                    return this.b(parcel, classLoader);
                }
                
                public /* bridge */ Object[] newArray(final int n) {
                    return this.c(n);
                }
            };
        }
        
        SavedState(final Bundle a) {
            this.a = a;
        }
        
        SavedState(final Parcel parcel, final ClassLoader classLoader) {
            final Bundle bundle = parcel.readBundle();
            this.a = bundle;
            if (classLoader != null && bundle != null) {
                bundle.setClassLoader(classLoader);
            }
        }
        
        public int describeContents() {
            return 0;
        }
        
        public void writeToParcel(final Parcel parcel, final int n) {
            parcel.writeBundle(this.a);
        }
    }
    
    static class j
    {
        View a;
        boolean b;
        int c;
        int d;
        int e;
        int f;
        int g;
        ArrayList<String> h;
        ArrayList<String> i;
        Object j;
        Object k;
        Object l;
        Object m;
        Object n;
        Object o;
        Boolean p;
        Boolean q;
        float r;
        View s;
        boolean t;
        
        j() {
            this.j = null;
            final Object use_DEFAULT_TRANSITION = Fragment.USE_DEFAULT_TRANSITION;
            this.k = use_DEFAULT_TRANSITION;
            this.l = null;
            this.m = use_DEFAULT_TRANSITION;
            this.n = null;
            this.o = use_DEFAULT_TRANSITION;
            this.r = 1.0f;
            this.s = null;
        }
    }
    
    static class k
    {
        static void a(final View view) {
            view.cancelPendingInputEvents();
        }
    }
    
    private abstract static class l
    {
        private l() {
        }
        
        l(final Fragment$b runnable) {
            this();
        }
        
        abstract void a();
    }
}
