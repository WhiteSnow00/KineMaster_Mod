// 
// Decompiled by Procyon v0.6.0
// 

package androidx.fragment.app;

import android.content.res.TypedArray;
import android.view.View$OnAttachStateChangeListener;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import android.view.ViewGroup;
import android.util.Log;
import f0.c;
import android.util.AttributeSet;
import android.content.Context;
import android.view.View;
import android.view.LayoutInflater$Factory2;

class p implements LayoutInflater$Factory2
{
    final FragmentManager a;
    
    p(final FragmentManager a) {
        this.a = a;
    }
    
    public View onCreateView(View mView, final String s, final Context context, final AttributeSet set) {
        if (FragmentContainerView.class.getName().equals(s)) {
            return (View)new FragmentContainerView(context, set, this.a);
        }
        final boolean equals = "fragment".equals(s);
        Fragment j0 = null;
        if (!equals) {
            return null;
        }
        final String attributeValue = set.getAttributeValue((String)null, "class");
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, c.a);
        String string;
        if ((string = attributeValue) == null) {
            string = obtainStyledAttributes.getString(c.b);
        }
        final int resourceId = obtainStyledAttributes.getResourceId(c.c, -1);
        final String string2 = obtainStyledAttributes.getString(c.d);
        obtainStyledAttributes.recycle();
        if (string == null || !l.b(context.getClassLoader(), string)) {
            return null;
        }
        int id;
        if (mView != null) {
            id = mView.getId();
        }
        else {
            id = 0;
        }
        if (id == -1 && resourceId == -1 && string2 == null) {
            final StringBuilder sb = new StringBuilder();
            sb.append(set.getPositionDescription());
            sb.append(": Must specify unique android:id, android:tag, or have a parent with an id for ");
            sb.append(string);
            throw new IllegalArgumentException(sb.toString());
        }
        if (resourceId != -1) {
            j0 = this.a.j0(resourceId);
        }
        Fragment k0;
        if ((k0 = j0) == null) {
            k0 = j0;
            if (string2 != null) {
                k0 = this.a.k0(string2);
            }
        }
        Fragment j2;
        if ((j2 = k0) == null) {
            j2 = k0;
            if (id != -1) {
                j2 = this.a.j0(id);
            }
        }
        Fragment fragment;
        a0 a3;
        if (j2 == null) {
            final Fragment a = this.a.x0().a(context.getClassLoader(), string);
            a.mFromLayout = true;
            int mFragmentId;
            if (resourceId != 0) {
                mFragmentId = resourceId;
            }
            else {
                mFragmentId = id;
            }
            a.mFragmentId = mFragmentId;
            a.mContainerId = id;
            a.mTag = string2;
            a.mInLayout = true;
            final FragmentManager a2 = this.a;
            a.mFragmentManager = a2;
            a.mHost = a2.A0();
            a.onInflate(this.a.A0().f(), set, a.mSavedFragmentState);
            final a0 i = this.a.j(a);
            fragment = a;
            a3 = i;
            if (FragmentManager.N0(2)) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Fragment ");
                sb2.append(a);
                sb2.append(" has been inflated via the <fragment> tag: id=0x");
                sb2.append(Integer.toHexString(resourceId));
                Log.v("FragmentManager", sb2.toString());
                fragment = a;
                a3 = i;
            }
        }
        else {
            if (j2.mInLayout) {
                final StringBuilder sb3 = new StringBuilder();
                sb3.append(set.getPositionDescription());
                sb3.append(": Duplicate id 0x");
                sb3.append(Integer.toHexString(resourceId));
                sb3.append(", tag ");
                sb3.append(string2);
                sb3.append(", or parent id 0x");
                sb3.append(Integer.toHexString(id));
                sb3.append(" with another fragment for ");
                sb3.append(string);
                throw new IllegalArgumentException(sb3.toString());
            }
            j2.mInLayout = true;
            final FragmentManager a4 = this.a;
            j2.mFragmentManager = a4;
            j2.mHost = a4.A0();
            j2.onInflate(this.a.A0().f(), set, j2.mSavedFragmentState);
            final a0 y = this.a.y(j2);
            fragment = j2;
            a3 = y;
            if (FragmentManager.N0(2)) {
                final StringBuilder sb4 = new StringBuilder();
                sb4.append("Retained Fragment ");
                sb4.append(j2);
                sb4.append(" has been re-attached via the <fragment> tag: id=0x");
                sb4.append(Integer.toHexString(resourceId));
                Log.v("FragmentManager", sb4.toString());
                a3 = y;
                fragment = j2;
            }
        }
        final ViewGroup mContainer = (ViewGroup)mView;
        FragmentStrictMode.i(fragment, mContainer);
        fragment.mContainer = mContainer;
        a3.m();
        a3.j();
        mView = fragment.mView;
        if (mView != null) {
            if (resourceId != 0) {
                mView.setId(resourceId);
            }
            if (fragment.mView.getTag() == null) {
                fragment.mView.setTag((Object)string2);
            }
            fragment.mView.addOnAttachStateChangeListener((View$OnAttachStateChangeListener)new View$OnAttachStateChangeListener(this, a3) {
                final a0 a;
                final p b;
                
                public void onViewAttachedToWindow(final View view) {
                    final Fragment k = this.a.k();
                    this.a.m();
                    SpecialEffectsController.n((ViewGroup)k.mView.getParent(), this.b.a).j();
                }
                
                public void onViewDetachedFromWindow(final View view) {
                }
            });
            return fragment.mView;
        }
        final StringBuilder sb5 = new StringBuilder();
        sb5.append("Fragment ");
        sb5.append(string);
        sb5.append(" did not create a view.");
        throw new IllegalStateException(sb5.toString());
    }
    
    public View onCreateView(final String s, final Context context, final AttributeSet set) {
        return this.onCreateView(null, s, context, set);
    }
}
