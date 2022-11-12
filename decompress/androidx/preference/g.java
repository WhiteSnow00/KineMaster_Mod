// 
// Decompiled by Procyon v0.6.0
// 

package androidx.preference;

import android.graphics.Canvas;
import android.graphics.Rect;
import androidx.recyclerview.widget.u;
import android.graphics.drawable.Drawable;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.util.TypedValue;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.os.Message;
import android.os.Looper;
import android.os.Handler;
import androidx.recyclerview.widget.RecyclerView;
import androidx.fragment.app.Fragment;

public abstract class g extends Fragment implements androidx.preference.j.c, j.a, j.b, DialogPreference.a
{
    private final c a;
    private j b;
    RecyclerView c;
    private boolean d;
    private boolean e;
    private int f;
    private Runnable g;
    private final Handler h;
    private final Runnable i;
    
    public g() {
        this.a = new c();
        this.f = androidx.preference.p.c;
        this.h = new Handler(Looper.getMainLooper()) {
            final g a;
            
            public void handleMessage(final Message message) {
                if (message.what == 1) {
                    this.a.h4();
                }
            }
        };
        this.i = new Runnable() {
            final g a;
            
            @Override
            public void run() {
                final RecyclerView c = this.a.c;
                c.focusableViewAvailable((View)c);
            }
        };
    }
    
    private void r4() {
        if (this.h.hasMessages(1)) {
            return;
        }
        this.h.obtainMessage(1).sendToTarget();
    }
    
    private void s4() {
        if (this.b != null) {
            return;
        }
        throw new RuntimeException("This should be called after super.onCreate.");
    }
    
    private void w4() {
        this.j4().setAdapter(null);
        final PreferenceScreen k4 = this.k4();
        if (k4 != null) {
            k4.d0();
        }
        this.q4();
    }
    
    @Override
    public void G3(final Preference preference) {
        boolean a = this.i4() instanceof d && ((d)this.i4()).a(this, preference);
        for (Fragment parentFragment = this; !a && parentFragment != null; parentFragment = parentFragment.getParentFragment()) {
            if (parentFragment instanceof d) {
                a = ((d)parentFragment).a(this, preference);
            }
        }
        boolean a2;
        if (!(a2 = a)) {
            a2 = a;
            if (this.getContext() instanceof d) {
                a2 = ((d)this.getContext()).a(this, preference);
            }
        }
        boolean a3;
        if (!(a3 = a2)) {
            a3 = a2;
            if (this.getActivity() instanceof d) {
                a3 = ((d)this.getActivity()).a(this, preference);
            }
        }
        if (a3) {
            return;
        }
        if (this.getParentFragmentManager().k0("androidx.preference.PreferenceFragment.DIALOG") != null) {
            return;
        }
        androidx.preference.f f;
        if (preference instanceof EditTextPreference) {
            f = androidx.preference.a.q4(preference.r());
        }
        else if (preference instanceof ListPreference) {
            f = androidx.preference.c.p4(preference.r());
        }
        else {
            if (!(preference instanceof MultiSelectListPreference)) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Cannot display dialog for an unknown Preference type: ");
                sb.append(preference.getClass().getSimpleName());
                sb.append(". Make sure to implement onPreferenceDisplayDialog() to handle displaying a custom dialog for this Preference.");
                throw new IllegalArgumentException(sb.toString());
            }
            f = androidx.preference.d.p4(preference.r());
        }
        f.setTargetFragment(this, 0);
        f.show(this.getParentFragmentManager(), "androidx.preference.PreferenceFragment.DIALOG");
    }
    
    @Override
    public boolean S3(final Preference preference) {
        if (preference.o() != null) {
            boolean a = this.i4() instanceof e && ((e)this.i4()).a(this, preference);
            for (Fragment parentFragment = this; !a && parentFragment != null; parentFragment = parentFragment.getParentFragment()) {
                if (parentFragment instanceof e) {
                    a = ((e)parentFragment).a(this, preference);
                }
            }
            boolean a2;
            if (!(a2 = a)) {
                a2 = a;
                if (this.getContext() instanceof e) {
                    a2 = ((e)this.getContext()).a(this, preference);
                }
            }
            boolean a3;
            if (!(a3 = a2)) {
                a3 = a2;
                if (this.getActivity() instanceof e) {
                    a3 = ((e)this.getActivity()).a(this, preference);
                }
            }
            if (!a3) {
                Log.w("PreferenceFragment", "onPreferenceStartFragment is not implemented in the parent activity - attempting to use a fallback implementation. You should implement this method so that you can configure the new fragment that will be displayed, and set a transition between the fragments.");
                final FragmentManager parentFragmentManager = this.getParentFragmentManager();
                final Bundle m = preference.m();
                final Fragment a4 = parentFragmentManager.x0().a(this.requireActivity().getClassLoader(), preference.o());
                a4.setArguments(m);
                a4.setTargetFragment(this, 0);
                parentFragmentManager.q().q(((View)this.requireView().getParent()).getId(), a4).h(null).i();
            }
            return true;
        }
        return false;
    }
    
    public void g4(final int n) {
        this.s4();
        this.v4(this.b.m(this.requireContext(), n, this.k4()));
    }
    
    void h4() {
        final PreferenceScreen k4 = this.k4();
        if (k4 != null) {
            this.j4().setAdapter(this.m4(k4));
            k4.U();
        }
        this.l4();
    }
    
    @Override
    public <T extends Preference> T i2(final CharSequence charSequence) {
        final j b = this.b;
        if (b == null) {
            return null;
        }
        return (T)b.a(charSequence);
    }
    
    public Fragment i4() {
        return null;
    }
    
    public final RecyclerView j4() {
        return this.c;
    }
    
    public PreferenceScreen k4() {
        return this.b.k();
    }
    
    protected void l4() {
    }
    
    protected RecyclerView.Adapter m4(final PreferenceScreen preferenceScreen) {
        return new h(preferenceScreen);
    }
    
    public RecyclerView.o n4() {
        return new LinearLayoutManager(this.requireContext());
    }
    
    public abstract void o4(final Bundle p0, final String p1);
    
    @Override
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        final TypedValue typedValue = new TypedValue();
        this.requireContext().getTheme().resolveAttribute(m.i, typedValue, true);
        int n;
        if ((n = typedValue.resourceId) == 0) {
            n = androidx.preference.r.a;
        }
        this.requireContext().getTheme().applyStyle(n, false);
        (this.b = new j(this.requireContext())).p((j.b)this);
        String string;
        if (this.getArguments() != null) {
            string = this.getArguments().getString("androidx.preference.PreferenceFragmentCompat.PREFERENCE_ROOT");
        }
        else {
            string = null;
        }
        this.o4(bundle, string);
    }
    
    @Override
    public View onCreateView(LayoutInflater cloneInContext, final ViewGroup viewGroup, final Bundle bundle) {
        final TypedArray obtainStyledAttributes = this.requireContext().obtainStyledAttributes((AttributeSet)null, s.v0, m.f, 0);
        this.f = obtainStyledAttributes.getResourceId(s.w0, this.f);
        final Drawable drawable = obtainStyledAttributes.getDrawable(s.x0);
        final int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(s.y0, -1);
        final boolean boolean1 = obtainStyledAttributes.getBoolean(s.z0, true);
        obtainStyledAttributes.recycle();
        cloneInContext = cloneInContext.cloneInContext(this.requireContext());
        final View inflate = cloneInContext.inflate(this.f, viewGroup, false);
        final View viewById = inflate.findViewById(16908351);
        if (!(viewById instanceof ViewGroup)) {
            throw new IllegalStateException("Content has view with id attribute 'android.R.id.list_container' that is not a ViewGroup class");
        }
        final ViewGroup viewGroup2 = (ViewGroup)viewById;
        final RecyclerView p3 = this.p4(cloneInContext, viewGroup2, bundle);
        if (p3 != null) {
            (this.c = p3).addItemDecoration((RecyclerView.n)this.a);
            this.t4(drawable);
            if (dimensionPixelSize != -1) {
                this.u4(dimensionPixelSize);
            }
            this.a.d(boolean1);
            if (this.c.getParent() == null) {
                viewGroup2.addView((View)this.c);
            }
            this.h.post(this.i);
            return inflate;
        }
        throw new RuntimeException("Could not create RecyclerView");
    }
    
    @Override
    public void onDestroyView() {
        this.h.removeCallbacks(this.i);
        this.h.removeMessages(1);
        if (this.d) {
            this.w4();
        }
        this.c = null;
        super.onDestroyView();
    }
    
    @Override
    public void onSaveInstanceState(final Bundle bundle) {
        super.onSaveInstanceState(bundle);
        final PreferenceScreen k4 = this.k4();
        if (k4 != null) {
            final Bundle bundle2 = new Bundle();
            k4.z0(bundle2);
            bundle.putBundle("android:preferences", bundle2);
        }
    }
    
    @Override
    public void onStart() {
        super.onStart();
        this.b.q((androidx.preference.j.c)this);
        this.b.o((j.a)this);
    }
    
    @Override
    public void onStop() {
        super.onStop();
        this.b.q(null);
        this.b.o(null);
    }
    
    @Override
    public void onViewCreated(final View view, final Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (bundle != null) {
            final Bundle bundle2 = bundle.getBundle("android:preferences");
            if (bundle2 != null) {
                final PreferenceScreen k4 = this.k4();
                if (k4 != null) {
                    k4.y0(bundle2);
                }
            }
        }
        if (this.d) {
            this.h4();
            final Runnable g = this.g;
            if (g != null) {
                g.run();
                this.g = null;
            }
        }
        this.e = true;
    }
    
    public RecyclerView p4(final LayoutInflater layoutInflater, final ViewGroup viewGroup, final Bundle bundle) {
        if (this.requireContext().getPackageManager().hasSystemFeature("android.hardware.type.automotive")) {
            final RecyclerView recyclerView = (RecyclerView)viewGroup.findViewById(o.b);
            if (recyclerView != null) {
                return recyclerView;
            }
        }
        final RecyclerView recyclerView2 = (RecyclerView)layoutInflater.inflate(androidx.preference.p.d, viewGroup, false);
        recyclerView2.setLayoutManager(this.n4());
        recyclerView2.setAccessibilityDelegateCompat(new androidx.preference.k(recyclerView2));
        return recyclerView2;
    }
    
    @Override
    public void q1(final PreferenceScreen preferenceScreen) {
        boolean a = this.i4() instanceof f && ((f)this.i4()).a(this, preferenceScreen);
        for (Fragment parentFragment = this; !a && parentFragment != null; parentFragment = parentFragment.getParentFragment()) {
            if (parentFragment instanceof f) {
                a = ((f)parentFragment).a(this, preferenceScreen);
            }
        }
        boolean a2;
        if (!(a2 = a)) {
            a2 = a;
            if (this.getContext() instanceof f) {
                a2 = ((f)this.getContext()).a(this, preferenceScreen);
            }
        }
        if (!a2 && this.getActivity() instanceof f) {
            ((f)this.getActivity()).a(this, preferenceScreen);
        }
    }
    
    protected void q4() {
    }
    
    public void t4(final Drawable drawable) {
        this.a.e(drawable);
    }
    
    public void u4(final int n) {
        this.a.f(n);
    }
    
    public void v4(final PreferenceScreen preferenceScreen) {
        if (this.b.r(preferenceScreen) && preferenceScreen != null) {
            this.q4();
            this.d = true;
            if (this.e) {
                this.r4();
            }
        }
    }
    
    private class c extends n
    {
        private Drawable a;
        private int b;
        private boolean c;
        final g d;
        
        c(final g d) {
            this.d = d;
            this.c = true;
        }
        
        private boolean g(final View view, final RecyclerView recyclerView) {
            final RecyclerView.c0 childViewHolder = recyclerView.getChildViewHolder(view);
            final boolean b = childViewHolder instanceof l;
            final boolean b2 = false;
            if (!b || !((l)childViewHolder).c()) {
                return false;
            }
            boolean c = this.c;
            final int indexOfChild = recyclerView.indexOfChild(view);
            if (indexOfChild < recyclerView.getChildCount() - 1) {
                final RecyclerView.c0 childViewHolder2 = recyclerView.getChildViewHolder(recyclerView.getChildAt(indexOfChild + 1));
                c = b2;
                if (childViewHolder2 instanceof l) {
                    c = b2;
                    if (((l)childViewHolder2).b()) {
                        c = true;
                    }
                }
            }
            return c;
        }
        
        public void d(final boolean c) {
            this.c = c;
        }
        
        public void e(final Drawable a) {
            if (a != null) {
                this.b = a.getIntrinsicHeight();
            }
            else {
                this.b = 0;
            }
            this.a = a;
            this.d.c.invalidateItemDecorations();
        }
        
        public void f(final int b) {
            this.b = b;
            this.d.c.invalidateItemDecorations();
        }
        
        @Override
        public void getItemOffsets(final Rect rect, final View view, final RecyclerView recyclerView, final z z) {
            if (this.g(view, recyclerView)) {
                rect.bottom = this.b;
            }
        }
        
        @Override
        public void onDrawOver(final Canvas canvas, final RecyclerView recyclerView, final z z) {
            if (this.a == null) {
                return;
            }
            final int childCount = recyclerView.getChildCount();
            final int width = recyclerView.getWidth();
            for (int i = 0; i < childCount; ++i) {
                final View child = recyclerView.getChildAt(i);
                if (this.g(child, recyclerView)) {
                    final int n = (int)child.getY() + child.getHeight();
                    this.a.setBounds(0, n, width, this.b + n);
                    this.a.draw(canvas);
                }
            }
        }
    }
    
    public interface d
    {
        boolean a(final g p0, final Preference p1);
    }
    
    public interface e
    {
        boolean a(final g p0, final Preference p1);
    }
    
    public interface f
    {
        boolean a(final g p0, final PreferenceScreen p1);
    }
}
