// 
// Decompiled by Procyon v0.6.0
// 

package androidx.fragment.app;

import android.os.Parcelable;
import androidx.lifecycle.r;
import java.util.Iterator;
import android.app.Activity;
import androidx.lifecycle.r0;
import android.view.LayoutInflater;
import android.view.View$OnAttachStateChangeListener;
import f0.b;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import android.content.res.Resources$NotFoundException;
import android.view.ViewGroup;
import android.util.SparseArray;
import android.view.ViewParent;
import android.view.View;
import android.util.Log;
import android.os.Bundle;

class a0
{
    private final q a;
    private final b0 b;
    private final Fragment c;
    private boolean d;
    private int e;
    
    a0(final q a, final b0 b, final Fragment c) {
        this.d = false;
        this.e = -1;
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    a0(final q a, final b0 b, final Fragment c, final FragmentState fragmentState) {
        this.d = false;
        this.e = -1;
        this.a = a;
        this.b = b;
        this.c = c;
        c.mSavedViewState = null;
        c.mSavedViewRegistryState = null;
        c.mBackStackNesting = 0;
        c.mInLayout = false;
        c.mAdded = false;
        final Fragment mTarget = c.mTarget;
        String mWho;
        if (mTarget != null) {
            mWho = mTarget.mWho;
        }
        else {
            mWho = null;
        }
        c.mTargetWho = mWho;
        c.mTarget = null;
        final Bundle x = fragmentState.x;
        if (x != null) {
            c.mSavedFragmentState = x;
        }
        else {
            c.mSavedFragmentState = new Bundle();
        }
    }
    
    a0(final q a, final b0 b, final ClassLoader classLoader, final l l, final FragmentState fragmentState) {
        this.d = false;
        this.e = -1;
        this.a = a;
        this.b = b;
        final Fragment a2 = fragmentState.a(l, classLoader);
        this.c = a2;
        if (FragmentManager.N0(2)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Instantiated fragment ");
            sb.append(a2);
            Log.v("FragmentManager", sb.toString());
        }
    }
    
    private boolean l(final View view) {
        if (view == this.c.mView) {
            return true;
        }
        for (ViewParent viewParent = view.getParent(); viewParent != null; viewParent = viewParent.getParent()) {
            if (viewParent == this.c.mView) {
                return true;
            }
        }
        return false;
    }
    
    private Bundle q() {
        final Bundle bundle = new Bundle();
        this.c.performSaveInstanceState(bundle);
        this.a.j(this.c, bundle, false);
        Bundle bundle2 = bundle;
        if (bundle.isEmpty()) {
            bundle2 = null;
        }
        if (this.c.mView != null) {
            this.t();
        }
        Bundle bundle3 = bundle2;
        if (this.c.mSavedViewState != null) {
            if ((bundle3 = bundle2) == null) {
                bundle3 = new Bundle();
            }
            bundle3.putSparseParcelableArray("android:view_state", (SparseArray)this.c.mSavedViewState);
        }
        Bundle bundle4 = bundle3;
        if (this.c.mSavedViewRegistryState != null) {
            if ((bundle4 = bundle3) == null) {
                bundle4 = new Bundle();
            }
            bundle4.putBundle("android:view_registry_state", this.c.mSavedViewRegistryState);
        }
        Bundle bundle5 = bundle4;
        if (!this.c.mUserVisibleHint) {
            if ((bundle5 = bundle4) == null) {
                bundle5 = new Bundle();
            }
            bundle5.putBoolean("android:user_visible_hint", this.c.mUserVisibleHint);
        }
        return bundle5;
    }
    
    void a() {
        if (FragmentManager.N0(3)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("moveto ACTIVITY_CREATED: ");
            sb.append(this.c);
            Log.d("FragmentManager", sb.toString());
        }
        final Fragment c = this.c;
        c.performActivityCreated(c.mSavedFragmentState);
        final q a = this.a;
        final Fragment c2 = this.c;
        a.a(c2, c2.mSavedFragmentState, false);
    }
    
    void b() {
        final int j = this.b.j(this.c);
        final Fragment c = this.c;
        c.mContainer.addView(c.mView, j);
    }
    
    void c() {
        if (FragmentManager.N0(3)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("moveto ATTACHED: ");
            sb.append(this.c);
            Log.d("FragmentManager", sb.toString());
        }
        final Fragment c = this.c;
        final Fragment mTarget = c.mTarget;
        a0 a0 = null;
        if (mTarget != null) {
            a0 = this.b.n(mTarget.mWho);
            if (a0 == null) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Fragment ");
                sb2.append(this.c);
                sb2.append(" declared target fragment ");
                sb2.append(this.c.mTarget);
                sb2.append(" that does not belong to this FragmentManager!");
                throw new IllegalStateException(sb2.toString());
            }
            final Fragment c2 = this.c;
            c2.mTargetWho = c2.mTarget.mWho;
            c2.mTarget = null;
        }
        else {
            final String mTargetWho = c.mTargetWho;
            if (mTargetWho != null) {
                a0 = this.b.n(mTargetWho);
                if (a0 == null) {
                    final StringBuilder sb3 = new StringBuilder();
                    sb3.append("Fragment ");
                    sb3.append(this.c);
                    sb3.append(" declared target fragment ");
                    sb3.append(this.c.mTargetWho);
                    sb3.append(" that does not belong to this FragmentManager!");
                    throw new IllegalStateException(sb3.toString());
                }
            }
        }
        if (a0 != null) {
            a0.m();
        }
        final Fragment c3 = this.c;
        c3.mHost = c3.mFragmentManager.A0();
        final Fragment c4 = this.c;
        c4.mParentFragment = c4.mFragmentManager.D0();
        this.a.g(this.c, false);
        this.c.performAttach();
        this.a.b(this.c, false);
    }
    
    int d() {
        final Fragment c = this.c;
        if (c.mFragmentManager == null) {
            return c.mState;
        }
        final int e = this.e;
        final int n = a0$b.a[c.mMaxState.ordinal()];
        int n2 = e;
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    if (n != 4) {
                        n2 = Math.min(e, -1);
                    }
                    else {
                        n2 = Math.min(e, 0);
                    }
                }
                else {
                    n2 = Math.min(e, 1);
                }
            }
            else {
                n2 = Math.min(e, 5);
            }
        }
        final Fragment c2 = this.c;
        int n3 = n2;
        if (c2.mFromLayout) {
            if (c2.mInLayout) {
                final int max = Math.max(this.e, 2);
                final View mView = this.c.mView;
                n3 = max;
                if (mView != null) {
                    n3 = max;
                    if (mView.getParent() == null) {
                        n3 = Math.min(max, 2);
                    }
                }
            }
            else if (this.e < 4) {
                n3 = Math.min(n2, c2.mState);
            }
            else {
                n3 = Math.min(n2, 1);
            }
        }
        int min = n3;
        if (!this.c.mAdded) {
            min = Math.min(n3, 1);
        }
        SpecialEffectsController.Operation.LifecycleImpact l = null;
        final Fragment c3 = this.c;
        final ViewGroup mContainer = c3.mContainer;
        if (mContainer != null) {
            l = SpecialEffectsController.n(mContainer, c3.getParentFragmentManager()).l(this);
        }
        int n4;
        if (l == SpecialEffectsController.Operation.LifecycleImpact.ADDING) {
            n4 = Math.min(min, 6);
        }
        else if (l == SpecialEffectsController.Operation.LifecycleImpact.REMOVING) {
            n4 = Math.max(min, 3);
        }
        else {
            final Fragment c4 = this.c;
            n4 = min;
            if (c4.mRemoving) {
                if (c4.isInBackStack()) {
                    n4 = Math.min(min, 1);
                }
                else {
                    n4 = Math.min(min, -1);
                }
            }
        }
        final Fragment c5 = this.c;
        int min2 = n4;
        if (c5.mDeferStart) {
            min2 = n4;
            if (c5.mState < 5) {
                min2 = Math.min(n4, 4);
            }
        }
        if (FragmentManager.N0(2)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("computeExpectedState() of ");
            sb.append(min2);
            sb.append(" for ");
            sb.append(this.c);
            Log.v("FragmentManager", sb.toString());
        }
        return min2;
    }
    
    void e() {
        if (FragmentManager.N0(3)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("moveto CREATED: ");
            sb.append(this.c);
            Log.d("FragmentManager", sb.toString());
        }
        final Fragment c = this.c;
        if (!c.mIsCreated) {
            this.a.h(c, c.mSavedFragmentState, false);
            final Fragment c2 = this.c;
            c2.performCreate(c2.mSavedFragmentState);
            final q a = this.a;
            final Fragment c3 = this.c;
            a.c(c3, c3.mSavedFragmentState, false);
        }
        else {
            c.restoreChildFragmentState(c.mSavedFragmentState);
            this.c.mState = 1;
        }
    }
    
    void f() {
        if (this.c.mFromLayout) {
            return;
        }
        if (FragmentManager.N0(3)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("moveto CREATE_VIEW: ");
            sb.append(this.c);
            Log.d("FragmentManager", sb.toString());
        }
        final Fragment c = this.c;
        final LayoutInflater performGetLayoutInflater = c.performGetLayoutInflater(c.mSavedFragmentState);
        final ViewGroup viewGroup = null;
        final Fragment c2 = this.c;
        ViewGroup mContainer = c2.mContainer;
        if (mContainer == null) {
            final int mContainerId = c2.mContainerId;
            mContainer = viewGroup;
            if (mContainerId != 0) {
                if (mContainerId == -1) {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Cannot create fragment ");
                    sb2.append(this.c);
                    sb2.append(" for a container view with no id");
                    throw new IllegalArgumentException(sb2.toString());
                }
                final ViewGroup viewGroup2 = (ViewGroup)c2.mFragmentManager.u0().c(this.c.mContainerId);
                if (viewGroup2 == null) {
                    final Fragment c3 = this.c;
                    if (!c3.mRestored) {
                        String resourceName;
                        try {
                            resourceName = c3.getResources().getResourceName(this.c.mContainerId);
                        }
                        catch (final Resources$NotFoundException ex) {
                            resourceName = "unknown";
                        }
                        final StringBuilder sb3 = new StringBuilder();
                        sb3.append("No view found for id 0x");
                        sb3.append(Integer.toHexString(this.c.mContainerId));
                        sb3.append(" (");
                        sb3.append(resourceName);
                        sb3.append(") for fragment ");
                        sb3.append(this.c);
                        throw new IllegalArgumentException(sb3.toString());
                    }
                    mContainer = viewGroup2;
                }
                else {
                    mContainer = viewGroup2;
                    if (!(viewGroup2 instanceof FragmentContainerView)) {
                        FragmentStrictMode.p(this.c, viewGroup2);
                        mContainer = viewGroup2;
                    }
                }
            }
        }
        final Fragment c4 = this.c;
        c4.performCreateView(performGetLayoutInflater, c4.mContainer = mContainer, c4.mSavedFragmentState);
        final View mView = this.c.mView;
        if (mView != null) {
            mView.setSaveFromParentEnabled(false);
            final Fragment c5 = this.c;
            c5.mView.setTag(f0.b.a, (Object)c5);
            if (mContainer != null) {
                this.b();
            }
            final Fragment c6 = this.c;
            if (c6.mHidden) {
                c6.mView.setVisibility(8);
            }
            if (androidx.core.view.b0.S(this.c.mView)) {
                androidx.core.view.b0.m0(this.c.mView);
            }
            else {
                final View mView2 = this.c.mView;
                mView2.addOnAttachStateChangeListener((View$OnAttachStateChangeListener)new View$OnAttachStateChangeListener(this, mView2) {
                    final View a;
                    final a0 b;
                    
                    public void onViewAttachedToWindow(final View view) {
                        this.a.removeOnAttachStateChangeListener((View$OnAttachStateChangeListener)this);
                        androidx.core.view.b0.m0(this.a);
                    }
                    
                    public void onViewDetachedFromWindow(final View view) {
                    }
                });
            }
            this.c.performViewCreated();
            final q a = this.a;
            final Fragment c7 = this.c;
            a.m(c7, c7.mView, c7.mSavedFragmentState, false);
            final int visibility = this.c.mView.getVisibility();
            this.c.setPostOnViewCreatedAlpha(this.c.mView.getAlpha());
            final Fragment c8 = this.c;
            if (c8.mContainer != null && visibility == 0) {
                final View focus = c8.mView.findFocus();
                if (focus != null) {
                    this.c.setFocusedView(focus);
                    if (FragmentManager.N0(2)) {
                        final StringBuilder sb4 = new StringBuilder();
                        sb4.append("requestFocus: Saved focused view ");
                        sb4.append(focus);
                        sb4.append(" for Fragment ");
                        sb4.append(this.c);
                        Log.v("FragmentManager", sb4.toString());
                    }
                }
                this.c.mView.setAlpha(0.0f);
            }
        }
        this.c.mState = 2;
    }
    
    void g() {
        if (FragmentManager.N0(3)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("movefrom CREATED: ");
            sb.append(this.c);
            Log.d("FragmentManager", sb.toString());
        }
        final Fragment c = this.c;
        final boolean mRemoving = c.mRemoving;
        boolean r = true;
        final boolean b = mRemoving && !c.isInBackStack();
        if (b) {
            final Fragment c2 = this.c;
            if (!c2.mBeingSaved) {
                this.b.B(c2.mWho, null);
            }
        }
        if (b || this.b.p().u(this.c)) {
            final m<?> mHost = this.c.mHost;
            if (mHost instanceof r0) {
                r = this.b.p().r();
            }
            else if (mHost.f() instanceof Activity) {
                r = (true ^ ((Activity)mHost.f()).isChangingConfigurations());
            }
            if ((b && !this.c.mBeingSaved) || r) {
                this.b.p().j(this.c);
            }
            this.c.performDestroy();
            this.a.d(this.c, false);
            for (final a0 a0 : this.b.k()) {
                if (a0 != null) {
                    final Fragment k = a0.k();
                    if (!this.c.mWho.equals(k.mTargetWho)) {
                        continue;
                    }
                    k.mTarget = this.c;
                    k.mTargetWho = null;
                }
            }
            final Fragment c3 = this.c;
            final String mTargetWho = c3.mTargetWho;
            if (mTargetWho != null) {
                c3.mTarget = this.b.f(mTargetWho);
            }
            this.b.s(this);
        }
        else {
            final String mTargetWho2 = this.c.mTargetWho;
            if (mTargetWho2 != null) {
                final Fragment f = this.b.f(mTargetWho2);
                if (f != null && f.mRetainInstance) {
                    this.c.mTarget = f;
                }
            }
            this.c.mState = 0;
        }
    }
    
    void h() {
        if (FragmentManager.N0(3)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("movefrom CREATE_VIEW: ");
            sb.append(this.c);
            Log.d("FragmentManager", sb.toString());
        }
        final Fragment c = this.c;
        final ViewGroup mContainer = c.mContainer;
        if (mContainer != null) {
            final View mView = c.mView;
            if (mView != null) {
                mContainer.removeView(mView);
            }
        }
        this.c.performDestroyView();
        this.a.n(this.c, false);
        final Fragment c2 = this.c;
        c2.mContainer = null;
        c2.mView = null;
        c2.mViewLifecycleOwner = null;
        c2.mViewLifecycleOwnerLiveData.setValue(null);
        this.c.mInLayout = false;
    }
    
    void i() {
        if (FragmentManager.N0(3)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("movefrom ATTACHED: ");
            sb.append(this.c);
            Log.d("FragmentManager", sb.toString());
        }
        this.c.performDetach();
        final q a = this.a;
        final Fragment c = this.c;
        final int n = 0;
        a.e(c, false);
        final Fragment c2 = this.c;
        c2.mState = -1;
        c2.mHost = null;
        c2.mParentFragment = null;
        c2.mFragmentManager = null;
        int n2 = n;
        if (c2.mRemoving) {
            n2 = n;
            if (!c2.isInBackStack()) {
                n2 = 1;
            }
        }
        if (n2 != 0 || this.b.p().u(this.c)) {
            if (FragmentManager.N0(3)) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("initState called for fragment: ");
                sb2.append(this.c);
                Log.d("FragmentManager", sb2.toString());
            }
            this.c.initState();
        }
    }
    
    void j() {
        final Fragment c = this.c;
        if (c.mFromLayout && c.mInLayout && !c.mPerformedCreateView) {
            if (FragmentManager.N0(3)) {
                final StringBuilder sb = new StringBuilder();
                sb.append("moveto CREATE_VIEW: ");
                sb.append(this.c);
                Log.d("FragmentManager", sb.toString());
            }
            final Fragment c2 = this.c;
            c2.performCreateView(c2.performGetLayoutInflater(c2.mSavedFragmentState), null, this.c.mSavedFragmentState);
            final View mView = this.c.mView;
            if (mView != null) {
                mView.setSaveFromParentEnabled(false);
                final Fragment c3 = this.c;
                c3.mView.setTag(f0.b.a, (Object)c3);
                final Fragment c4 = this.c;
                if (c4.mHidden) {
                    c4.mView.setVisibility(8);
                }
                this.c.performViewCreated();
                final q a = this.a;
                final Fragment c5 = this.c;
                a.m(c5, c5.mView, c5.mSavedFragmentState, false);
                this.c.mState = 2;
            }
        }
    }
    
    Fragment k() {
        return this.c;
    }
    
    void m() {
        if (this.d) {
            if (FragmentManager.N0(2)) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Ignoring re-entrant call to moveToExpectedState() for ");
                sb.append(this.k());
                Log.v("FragmentManager", sb.toString());
            }
            return;
        }
        try {
            this.d = true;
            boolean b = false;
            Fragment c;
            int mState;
            while (true) {
                final int d = this.d();
                c = this.c;
                mState = c.mState;
                if (d == mState) {
                    break;
                }
                if (d > mState) {
                    switch (mState + 1) {
                        case 7: {
                            this.p();
                            break;
                        }
                        case 6: {
                            c.mState = 6;
                            break;
                        }
                        case 5: {
                            this.v();
                            break;
                        }
                        case 4: {
                            if (c.mView != null) {
                                final ViewGroup mContainer = c.mContainer;
                                if (mContainer != null) {
                                    SpecialEffectsController.n(mContainer, c.getParentFragmentManager()).b(SpecialEffectsController.Operation.State.from(this.c.mView.getVisibility()), this);
                                }
                            }
                            this.c.mState = 4;
                            break;
                        }
                        case 3: {
                            this.a();
                            break;
                        }
                        case 2: {
                            this.j();
                            this.f();
                            break;
                        }
                        case 1: {
                            this.e();
                            break;
                        }
                        case 0: {
                            this.c();
                            break;
                        }
                    }
                }
                else {
                    switch (mState - 1) {
                        case 6: {
                            this.n();
                            break;
                        }
                        case 5: {
                            c.mState = 5;
                            break;
                        }
                        case 4: {
                            this.w();
                            break;
                        }
                        case 3: {
                            if (FragmentManager.N0(3)) {
                                final StringBuilder sb2 = new StringBuilder();
                                sb2.append("movefrom ACTIVITY_CREATED: ");
                                sb2.append(this.c);
                                Log.d("FragmentManager", sb2.toString());
                            }
                            final Fragment c2 = this.c;
                            if (c2.mBeingSaved) {
                                this.s();
                            }
                            else if (c2.mView != null && c2.mSavedViewState == null) {
                                this.t();
                            }
                            final Fragment c3 = this.c;
                            if (c3.mView != null) {
                                final ViewGroup mContainer2 = c3.mContainer;
                                if (mContainer2 != null) {
                                    SpecialEffectsController.n(mContainer2, c3.getParentFragmentManager()).d(this);
                                }
                            }
                            this.c.mState = 3;
                            break;
                        }
                        case 2: {
                            c.mInLayout = false;
                            c.mState = 2;
                            break;
                        }
                        case 1: {
                            this.h();
                            this.c.mState = 1;
                            break;
                        }
                        case 0: {
                            if (c.mBeingSaved && this.b.q(c.mWho) == null) {
                                this.s();
                            }
                            this.g();
                            break;
                        }
                        case -1: {
                            this.i();
                            break;
                        }
                    }
                }
                b = true;
            }
            if (!b && mState == -1 && c.mRemoving && !c.isInBackStack() && !this.c.mBeingSaved) {
                if (FragmentManager.N0(3)) {
                    final StringBuilder sb3 = new StringBuilder();
                    sb3.append("Cleaning up state of never attached fragment: ");
                    sb3.append(this.c);
                    Log.d("FragmentManager", sb3.toString());
                }
                this.b.p().j(this.c);
                this.b.s(this);
                if (FragmentManager.N0(3)) {
                    final StringBuilder sb4 = new StringBuilder();
                    sb4.append("initState called for fragment: ");
                    sb4.append(this.c);
                    Log.d("FragmentManager", sb4.toString());
                }
                this.c.initState();
            }
            final Fragment c4 = this.c;
            if (c4.mHiddenChanged) {
                if (c4.mView != null) {
                    final ViewGroup mContainer3 = c4.mContainer;
                    if (mContainer3 != null) {
                        final SpecialEffectsController n = SpecialEffectsController.n(mContainer3, c4.getParentFragmentManager());
                        if (this.c.mHidden) {
                            n.c(this);
                        }
                        else {
                            n.e(this);
                        }
                    }
                }
                final Fragment c5 = this.c;
                final FragmentManager mFragmentManager = c5.mFragmentManager;
                if (mFragmentManager != null) {
                    mFragmentManager.L0(c5);
                }
                final Fragment c6 = this.c;
                c6.mHiddenChanged = false;
                c6.onHiddenChanged(c6.mHidden);
                this.c.mChildFragmentManager.L();
            }
        }
        finally {
            this.d = false;
        }
    }
    
    void n() {
        if (FragmentManager.N0(3)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("movefrom RESUMED: ");
            sb.append(this.c);
            Log.d("FragmentManager", sb.toString());
        }
        this.c.performPause();
        this.a.f(this.c, false);
    }
    
    void o(final ClassLoader classLoader) {
        final Bundle mSavedFragmentState = this.c.mSavedFragmentState;
        if (mSavedFragmentState == null) {
            return;
        }
        mSavedFragmentState.setClassLoader(classLoader);
        final Fragment c = this.c;
        c.mSavedViewState = (SparseArray<Parcelable>)c.mSavedFragmentState.getSparseParcelableArray("android:view_state");
        final Fragment c2 = this.c;
        c2.mSavedViewRegistryState = c2.mSavedFragmentState.getBundle("android:view_registry_state");
        final Fragment c3 = this.c;
        c3.mTargetWho = c3.mSavedFragmentState.getString("android:target_state");
        final Fragment c4 = this.c;
        if (c4.mTargetWho != null) {
            c4.mTargetRequestCode = c4.mSavedFragmentState.getInt("android:target_req_state", 0);
        }
        final Fragment c5 = this.c;
        final Boolean mSavedUserVisibleHint = c5.mSavedUserVisibleHint;
        if (mSavedUserVisibleHint != null) {
            c5.mUserVisibleHint = mSavedUserVisibleHint;
            this.c.mSavedUserVisibleHint = null;
        }
        else {
            c5.mUserVisibleHint = c5.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
        }
        final Fragment c6 = this.c;
        if (!c6.mUserVisibleHint) {
            c6.mDeferStart = true;
        }
    }
    
    void p() {
        if (FragmentManager.N0(3)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("moveto RESUMED: ");
            sb.append(this.c);
            Log.d("FragmentManager", sb.toString());
        }
        final View focusedView = this.c.getFocusedView();
        if (focusedView != null && this.l(focusedView)) {
            final boolean requestFocus = focusedView.requestFocus();
            if (FragmentManager.N0(2)) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("requestFocus: Restoring focused view ");
                sb2.append(focusedView);
                sb2.append(" ");
                String s;
                if (requestFocus) {
                    s = "succeeded";
                }
                else {
                    s = "failed";
                }
                sb2.append(s);
                sb2.append(" on Fragment ");
                sb2.append(this.c);
                sb2.append(" resulting in focused view ");
                sb2.append(this.c.mView.findFocus());
                Log.v("FragmentManager", sb2.toString());
            }
        }
        this.c.setFocusedView(null);
        this.c.performResume();
        this.a.i(this.c, false);
        final Fragment c = this.c;
        c.mSavedFragmentState = null;
        c.mSavedViewState = null;
        c.mSavedViewRegistryState = null;
    }
    
    Fragment.SavedState r() {
        final int mState = this.c.mState;
        Object o = null;
        if (mState > -1) {
            final Bundle q = this.q();
            o = o;
            if (q != null) {
                o = new Fragment.SavedState(q);
            }
        }
        return (Fragment.SavedState)o;
    }
    
    void s() {
        final FragmentState fragmentState = new FragmentState(this.c);
        final Fragment c = this.c;
        if (c.mState > -1 && fragmentState.x == null) {
            final Bundle q = this.q();
            fragmentState.x = q;
            if (this.c.mTargetWho != null) {
                if (q == null) {
                    fragmentState.x = new Bundle();
                }
                fragmentState.x.putString("android:target_state", this.c.mTargetWho);
                final int mTargetRequestCode = this.c.mTargetRequestCode;
                if (mTargetRequestCode != 0) {
                    fragmentState.x.putInt("android:target_req_state", mTargetRequestCode);
                }
            }
        }
        else {
            fragmentState.x = c.mSavedFragmentState;
        }
        this.b.B(this.c.mWho, fragmentState);
    }
    
    void t() {
        if (this.c.mView == null) {
            return;
        }
        if (FragmentManager.N0(2)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Saving view state for fragment ");
            sb.append(this.c);
            sb.append(" with view ");
            sb.append(this.c.mView);
            Log.v("FragmentManager", sb.toString());
        }
        final SparseArray mSavedViewState = new SparseArray();
        this.c.mView.saveHierarchyState(mSavedViewState);
        if (mSavedViewState.size() > 0) {
            this.c.mSavedViewState = (SparseArray<Parcelable>)mSavedViewState;
        }
        final Bundle mSavedViewRegistryState = new Bundle();
        this.c.mViewLifecycleOwner.e(mSavedViewRegistryState);
        if (!mSavedViewRegistryState.isEmpty()) {
            this.c.mSavedViewRegistryState = mSavedViewRegistryState;
        }
    }
    
    void u(final int e) {
        this.e = e;
    }
    
    void v() {
        if (FragmentManager.N0(3)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("moveto STARTED: ");
            sb.append(this.c);
            Log.d("FragmentManager", sb.toString());
        }
        this.c.performStart();
        this.a.k(this.c, false);
    }
    
    void w() {
        if (FragmentManager.N0(3)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("movefrom STARTED: ");
            sb.append(this.c);
            Log.d("FragmentManager", sb.toString());
        }
        this.c.performStop();
        this.a.l(this.c, false);
    }
}
