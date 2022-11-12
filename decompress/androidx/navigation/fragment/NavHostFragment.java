// 
// Decompiled by Procyon v0.6.0
// 

package androidx.navigation.fragment;

import android.view.Window;
import android.app.Dialog;
import android.view.ViewParent;
import android.content.res.TypedArray;
import q0.g;
import androidx.navigation.z;
import android.util.AttributeSet;
import androidx.navigation.Navigation;
import androidx.fragment.app.FragmentContainerView;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import androidx.lifecycle.q0;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.h;
import android.content.ContextWrapper;
import androidx.lifecycle.r;
import android.os.Bundle;
import androidx.navigation.v;
import androidx.navigation.NavDestination;
import q0.c;
import androidx.fragment.app.FragmentManager;
import android.content.Context;
import q0.e;
import androidx.navigation.Navigator;
import java.util.Objects;
import androidx.navigation.NavController;
import q0.f;
import kotlin.jvm.internal.i;
import android.view.View;
import androidx.navigation.o;
import kotlin.Metadata;
import androidx.fragment.app.Fragment;

@Metadata(bv = {}, d1 = { "\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u000f\b\u0016\u0018\u0000 :2\u00020\u00012\u00020\u0002:\u0001$B\u0007¢\u0006\u0004\b8\u00109J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0017J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0017J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0015J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0015J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0017J\u0010\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013H\u0015J&\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001a2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\"\u0010 \u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0017J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0007H\u0017J\b\u0010#\u001a\u00020\u0005H\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010(\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010+\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u00105\u001a\u00020,8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u0011\u0010\u000e\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b6\u00107¨\u0006;" }, d2 = { "Landroidx/navigation/fragment/NavHostFragment;", "Landroidx/fragment/app/Fragment;", "", "Landroid/content/Context;", "context", "Lka/r;", "onAttach", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "Landroidx/navigation/o;", "navHostController", "k4", "Landroidx/navigation/NavController;", "navController", "j4", "", "isPrimaryNavigationFragment", "onPrimaryNavigationFragmentChanged", "Landroidx/navigation/Navigator;", "Lq0/e$b;", "h4", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "view", "onViewCreated", "Landroid/util/AttributeSet;", "attrs", "onInflate", "outState", "onSaveInstanceState", "onDestroyView", "a", "Landroidx/navigation/o;", "b", "Ljava/lang/Boolean;", "isPrimaryBeforeOnCreate", "c", "Landroid/view/View;", "viewParent", "", "d", "I", "graphId", "e", "Z", "defaultNavHost", "i4", "()I", "containerId", "getNavController", "()Landroidx/navigation/NavController;", "<init>", "()V", "f", "navigation-fragment_release" }, k = 1, mv = { 1, 6, 0 })
public class NavHostFragment extends Fragment
{
    public static final a f;
    private o a;
    private Boolean b;
    private View c;
    private int d;
    private boolean e;
    
    static {
        f = new a(null);
    }
    
    public static final o g4(final NavHostFragment navHostFragment) {
        return navHostFragment.a;
    }
    
    private final int i4() {
        int n = this.getId();
        if (n == 0 || n == -1) {
            n = q0.f.a;
        }
        return n;
    }
    
    public final NavController getNavController() {
        final o a = this.a;
        if (a != null) {
            Objects.requireNonNull(a, "null cannot be cast to non-null type androidx.navigation.NavHostController");
            return a;
        }
        throw new IllegalStateException("NavController is not available before onCreate()".toString());
    }
    
    protected Navigator<? extends q0.e.b> h4() {
        final Context requireContext = this.requireContext();
        kotlin.jvm.internal.o.f((Object)requireContext, "requireContext()");
        final FragmentManager childFragmentManager = this.getChildFragmentManager();
        kotlin.jvm.internal.o.f((Object)childFragmentManager, "childFragmentManager");
        return (Navigator<? extends q0.e.b>)new q0.e(requireContext, childFragmentManager, this.i4());
    }
    
    protected void j4(final NavController navController) {
        kotlin.jvm.internal.o.g((Object)navController, "navController");
        final v f = navController.F();
        final Context requireContext = this.requireContext();
        kotlin.jvm.internal.o.f((Object)requireContext, "requireContext()");
        final FragmentManager childFragmentManager = this.getChildFragmentManager();
        kotlin.jvm.internal.o.f((Object)childFragmentManager, "childFragmentManager");
        f.b(new c(requireContext, childFragmentManager));
        navController.F().b(this.h4());
    }
    
    protected void k4(final o o) {
        kotlin.jvm.internal.o.g((Object)o, "navHostController");
        this.j4(o);
    }
    
    @Override
    public void onAttach(final Context context) {
        kotlin.jvm.internal.o.g((Object)context, "context");
        super.onAttach(context);
        if (this.e) {
            this.getParentFragmentManager().q().v(this).i();
        }
    }
    
    @Override
    public void onCreate(final Bundle bundle) {
        Context context = this.requireContext();
        kotlin.jvm.internal.o.f((Object)context, "requireContext()");
        final o a = new o(context);
        kotlin.jvm.internal.o.d((Object)(this.a = a));
        a.j0(this);
        while (context instanceof ContextWrapper) {
            if (context instanceof h) {
                final o a2 = this.a;
                kotlin.jvm.internal.o.d((Object)a2);
                final OnBackPressedDispatcher onBackPressedDispatcher = ((h)context).getOnBackPressedDispatcher();
                kotlin.jvm.internal.o.f((Object)onBackPressedDispatcher, "context as OnBackPressed\u2026).onBackPressedDispatcher");
                a2.k0(onBackPressedDispatcher);
                break;
            }
            context = ((ContextWrapper)context).getBaseContext();
            kotlin.jvm.internal.o.f((Object)context, "context.baseContext");
        }
        final o a3 = this.a;
        kotlin.jvm.internal.o.d((Object)a3);
        final Boolean b = this.b;
        int int1 = 0;
        boolean b2 = false;
        Label_0164: {
            if (b != null) {
                Objects.requireNonNull(b, "null cannot be cast to non-null type kotlin.Boolean");
                if (b) {
                    b2 = true;
                    break Label_0164;
                }
            }
            b2 = false;
        }
        a3.s(b2);
        final Bundle bundle2 = null;
        this.b = null;
        final o a4 = this.a;
        kotlin.jvm.internal.o.d((Object)a4);
        final q0 viewModelStore = this.getViewModelStore();
        kotlin.jvm.internal.o.f((Object)viewModelStore, "viewModelStore");
        a4.l0(viewModelStore);
        final o a5 = this.a;
        kotlin.jvm.internal.o.d((Object)a5);
        this.k4(a5);
        Bundle bundle3;
        if (bundle != null) {
            bundle3 = bundle.getBundle("android-support-nav:fragment:navControllerState");
            if (bundle.getBoolean("android-support-nav:fragment:defaultHost", false)) {
                this.e = true;
                this.getParentFragmentManager().q().v(this).i();
            }
            this.d = bundle.getInt("android-support-nav:fragment:graphId");
        }
        else {
            bundle3 = null;
        }
        if (bundle3 != null) {
            final o a6 = this.a;
            kotlin.jvm.internal.o.d((Object)a6);
            a6.d0(bundle3);
        }
        if (this.d != 0) {
            final o a7 = this.a;
            kotlin.jvm.internal.o.d((Object)a7);
            a7.g0(this.d);
        }
        else {
            final Bundle arguments = this.getArguments();
            if (arguments != null) {
                int1 = arguments.getInt("android-support-nav:fragment:graphId");
            }
            Bundle bundle4 = bundle2;
            if (arguments != null) {
                bundle4 = arguments.getBundle("android-support-nav:fragment:startDestinationArgs");
            }
            if (int1 != 0) {
                final o a8 = this.a;
                kotlin.jvm.internal.o.d((Object)a8);
                a8.h0(int1, bundle4);
            }
        }
        super.onCreate(bundle);
    }
    
    @Override
    public View onCreateView(final LayoutInflater layoutInflater, final ViewGroup viewGroup, final Bundle bundle) {
        kotlin.jvm.internal.o.g((Object)layoutInflater, "inflater");
        final Context context = layoutInflater.getContext();
        kotlin.jvm.internal.o.f((Object)context, "inflater.context");
        final FragmentContainerView fragmentContainerView = new FragmentContainerView(context);
        fragmentContainerView.setId(this.i4());
        return (View)fragmentContainerView;
    }
    
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        final View c = this.c;
        if (c != null && Navigation.b(c) == this.a) {
            Navigation.e(c, null);
        }
        this.c = null;
    }
    
    @Override
    public void onInflate(final Context context, final AttributeSet set, final Bundle bundle) {
        kotlin.jvm.internal.o.g((Object)context, "context");
        kotlin.jvm.internal.o.g((Object)set, "attrs");
        super.onInflate(context, set, bundle);
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, z.g);
        kotlin.jvm.internal.o.f((Object)obtainStyledAttributes, "context.obtainStyledAttr\u2026yleable.NavHost\n        )");
        final int resourceId = obtainStyledAttributes.getResourceId(z.h, 0);
        if (resourceId != 0) {
            this.d = resourceId;
        }
        final ka.r a = ka.r.a;
        obtainStyledAttributes.recycle();
        final TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(set, g.e);
        kotlin.jvm.internal.o.f((Object)obtainStyledAttributes2, "context.obtainStyledAttr\u2026tyleable.NavHostFragment)");
        if (obtainStyledAttributes2.getBoolean(g.f, false)) {
            this.e = true;
        }
        obtainStyledAttributes2.recycle();
    }
    
    @Override
    public void onPrimaryNavigationFragmentChanged(final boolean b) {
        final o a = this.a;
        if (a != null) {
            if (a != null) {
                a.s(b);
            }
        }
        else {
            this.b = b;
        }
    }
    
    @Override
    public void onSaveInstanceState(final Bundle bundle) {
        kotlin.jvm.internal.o.g((Object)bundle, "outState");
        super.onSaveInstanceState(bundle);
        final o a = this.a;
        kotlin.jvm.internal.o.d((Object)a);
        final Bundle f0 = a.f0();
        if (f0 != null) {
            bundle.putBundle("android-support-nav:fragment:navControllerState", f0);
        }
        if (this.e) {
            bundle.putBoolean("android-support-nav:fragment:defaultHost", true);
        }
        final int d = this.d;
        if (d != 0) {
            bundle.putInt("android-support-nav:fragment:graphId", d);
        }
    }
    
    @Override
    public void onViewCreated(View c, final Bundle bundle) {
        kotlin.jvm.internal.o.g((Object)c, "view");
        super.onViewCreated(c, bundle);
        if (c instanceof ViewGroup) {
            Navigation.e(c, this.a);
            if (c.getParent() != null) {
                final ViewParent parent = c.getParent();
                Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.View");
                c = (View)parent;
                kotlin.jvm.internal.o.d((Object)(this.c = c));
                if (c.getId() == this.getId()) {
                    c = this.c;
                    kotlin.jvm.internal.o.d((Object)c);
                    Navigation.e(c, this.a);
                }
            }
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("created host view ");
        sb.append(c);
        sb.append(" is not a ViewGroup");
        throw new IllegalStateException(sb.toString().toString());
    }
    
    @Metadata(bv = {}, d1 = { "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0087T¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u000b\u0010\b¨\u0006\u000e" }, d2 = { "Landroidx/navigation/fragment/NavHostFragment$a;", "", "Landroidx/fragment/app/Fragment;", "fragment", "Landroidx/navigation/NavController;", "a", "", "KEY_DEFAULT_NAV_HOST", "Ljava/lang/String;", "KEY_GRAPH_ID", "KEY_NAV_CONTROLLER_STATE", "KEY_START_DESTINATION_ARGS", "<init>", "()V", "navigation-fragment_release" }, k = 1, mv = { 1, 6, 0 })
    public static final class a
    {
        private a() {
        }
        
        public a(final i i) {
            this();
        }
        
        public final NavController a(final Fragment fragment) {
            kotlin.jvm.internal.o.g((Object)fragment, "fragment");
            for (Fragment parentFragment = fragment; parentFragment != null; parentFragment = parentFragment.getParentFragment()) {
                if (parentFragment instanceof NavHostFragment) {
                    final o g4 = NavHostFragment.g4((NavHostFragment)parentFragment);
                    Objects.requireNonNull(g4, "null cannot be cast to non-null type androidx.navigation.NavController");
                    return g4;
                }
                final Fragment e0 = parentFragment.getParentFragmentManager().E0();
                if (e0 instanceof NavHostFragment) {
                    final o g5 = NavHostFragment.g4((NavHostFragment)e0);
                    Objects.requireNonNull(g5, "null cannot be cast to non-null type androidx.navigation.NavController");
                    return g5;
                }
            }
            final View view = fragment.getView();
            if (view != null) {
                return Navigation.b(view);
            }
            final boolean b = fragment instanceof androidx.fragment.app.c;
            final View view2 = null;
            androidx.fragment.app.c c;
            if (b) {
                c = (androidx.fragment.app.c)fragment;
            }
            else {
                c = null;
            }
            View decorView = view2;
            if (c != null) {
                final Dialog dialog = c.getDialog();
                decorView = view2;
                if (dialog != null) {
                    final Window window = dialog.getWindow();
                    decorView = view2;
                    if (window != null) {
                        decorView = window.getDecorView();
                    }
                }
            }
            if (decorView != null) {
                return Navigation.b(decorView);
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("Fragment ");
            sb.append(fragment);
            sb.append(" does not have a NavController set");
            throw new IllegalStateException(sb.toString());
        }
    }
}
