// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.app;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import androidx.appcompat.widget.o0;
import androidx.appcompat.widget.x;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.r;
import androidx.appcompat.widget.q;
import androidx.appcompat.widget.n;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.l;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.e;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.c;
import androidx.appcompat.view.d;
import android.util.Log;
import android.view.InflateException;
import android.view.View$OnClickListener;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import androidx.core.view.b0;
import android.os.Build$VERSION;
import android.util.AttributeSet;
import android.content.Context;
import android.view.View;
import java.lang.reflect.Constructor;
import androidx.collection.g;

public class j
{
    private static final Class<?>[] b;
    private static final int[] c;
    private static final int[] d;
    private static final int[] e;
    private static final int[] f;
    private static final String[] g;
    private static final g<String, Constructor<? extends View>> h;
    private final Object[] a;
    
    static {
        b = new Class[] { Context.class, AttributeSet.class };
        c = new int[] { 16843375 };
        d = new int[] { 16844160 };
        e = new int[] { 16844156 };
        f = new int[] { 16844148 };
        g = new String[] { "android.widget.", "android.view.", "android.webkit." };
        h = new g<String, Constructor<? extends View>>();
    }
    
    public j() {
        this.a = new Object[2];
    }
    
    private void a(final Context context, final View view, final AttributeSet set) {
        if (Build$VERSION.SDK_INT > 28) {
            return;
        }
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, j.d);
        if (obtainStyledAttributes.hasValue(0)) {
            b0.q0(view, obtainStyledAttributes.getBoolean(0, false));
        }
        obtainStyledAttributes.recycle();
        final TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(set, j.e);
        if (obtainStyledAttributes2.hasValue(0)) {
            b0.s0(view, obtainStyledAttributes2.getString(0));
        }
        obtainStyledAttributes2.recycle();
        final TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(set, j.f);
        if (obtainStyledAttributes3.hasValue(0)) {
            b0.G0(view, obtainStyledAttributes3.getBoolean(0, false));
        }
        obtainStyledAttributes3.recycle();
    }
    
    private void b(final View view, final AttributeSet set) {
        final Context context = view.getContext();
        if (context instanceof ContextWrapper) {
            if (b0.O(view)) {
                final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, j.c);
                final String string = obtainStyledAttributes.getString(0);
                if (string != null) {
                    view.setOnClickListener((View$OnClickListener)new a(view, string));
                }
                obtainStyledAttributes.recycle();
            }
        }
    }
    
    private View s(final Context context, final String s, String string) throws ClassNotFoundException, InflateException {
        final g<String, Constructor<? extends View>> h = j.h;
        Label_0095: {
            Constructor<? extends View> constructor;
            if ((constructor = h.get(s)) != null) {
                break Label_0095;
            }
            Label_0062: {
                if (string == null) {
                    break Label_0062;
                }
                try {
                    final StringBuilder sb = new StringBuilder();
                    sb.append(string);
                    sb.append(s);
                    string = sb.toString();
                    while (true) {
                        constructor = Class.forName(string, false, context.getClassLoader()).asSubclass(View.class).getConstructor(j.b);
                        h.put(s, constructor);
                        constructor.setAccessible(true);
                        return (View)constructor.newInstance(this.a);
                        string = s;
                        continue;
                    }
                }
                catch (final Exception ex) {
                    return null;
                }
            }
        }
    }
    
    private View t(final Context context, final String s, final AttributeSet set) {
        String attributeValue = s;
        if (s.equals("view")) {
            attributeValue = set.getAttributeValue((String)null, "class");
        }
        try {
            final Object[] a = this.a;
            a[0] = context;
            a[1] = set;
            if (-1 != attributeValue.indexOf(46)) {
                return this.s(context, attributeValue, null);
            }
            int n = 0;
            while (true) {
                final String[] g = j.g;
                if (n >= g.length) {
                    return null;
                }
                final View s2 = this.s(context, attributeValue, g[n]);
                if (s2 != null) {
                    return s2;
                }
                ++n;
            }
        }
        catch (final Exception ex) {
            return null;
        }
        finally {
            final Object[] a2 = this.a;
            a2[1] = (a2[0] = null);
        }
    }
    
    private static Context u(final Context context, final AttributeSet set, final boolean b, final boolean b2) {
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, d.j.H3, 0, 0);
        int resourceId;
        if (b) {
            resourceId = obtainStyledAttributes.getResourceId(d.j.I3, 0);
        }
        else {
            resourceId = 0;
        }
        int n = resourceId;
        if (b2 && (n = resourceId) == 0) {
            final int resourceId2 = obtainStyledAttributes.getResourceId(d.j.J3, 0);
            if ((n = resourceId2) != 0) {
                Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
                n = resourceId2;
            }
        }
        obtainStyledAttributes.recycle();
        Object o = context;
        if (n != 0) {
            if (context instanceof d) {
                o = context;
                if (((d)context).c() == n) {
                    return (Context)o;
                }
            }
            o = new d(context, n);
        }
        return (Context)o;
    }
    
    private void v(final View view, final String s) {
        if (view != null) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getName());
        sb.append(" asked to inflate view for <");
        sb.append(s);
        sb.append(">, but returned null");
        throw new IllegalStateException(sb.toString());
    }
    
    protected c c(final Context context, final AttributeSet set) {
        return new c(context, set);
    }
    
    protected AppCompatButton d(final Context context, final AttributeSet set) {
        return new AppCompatButton(context, set);
    }
    
    protected AppCompatCheckBox e(final Context context, final AttributeSet set) {
        return new AppCompatCheckBox(context, set);
    }
    
    protected e f(final Context context, final AttributeSet set) {
        return new e(context, set);
    }
    
    protected AppCompatEditText g(final Context context, final AttributeSet set) {
        return new AppCompatEditText(context, set);
    }
    
    protected l h(final Context context, final AttributeSet set) {
        return new l(context, set);
    }
    
    protected AppCompatImageView i(final Context context, final AttributeSet set) {
        return new AppCompatImageView(context, set);
    }
    
    protected n j(final Context context, final AttributeSet set) {
        return new n(context, set);
    }
    
    protected q k(final Context context, final AttributeSet set) {
        return new q(context, set);
    }
    
    protected r l(final Context context, final AttributeSet set) {
        return new r(context, set);
    }
    
    protected AppCompatSeekBar m(final Context context, final AttributeSet set) {
        return new AppCompatSeekBar(context, set);
    }
    
    protected AppCompatSpinner n(final Context context, final AttributeSet set) {
        return new AppCompatSpinner(context, set);
    }
    
    protected AppCompatTextView o(final Context context, final AttributeSet set) {
        return new AppCompatTextView(context, set);
    }
    
    protected x p(final Context context, final AttributeSet set) {
        return new x(context, set);
    }
    
    protected View q(final Context context, final String s, final AttributeSet set) {
        return null;
    }
    
    final View r(View o, final String s, final Context context, final AttributeSet set, final boolean b, final boolean b2, final boolean b3, final boolean b4) {
        Context context2;
        if (b && o != null) {
            context2 = ((View)o).getContext();
        }
        else {
            context2 = context;
        }
        Context u = null;
        Label_0046: {
            if (!b2) {
                u = context2;
                if (!b3) {
                    break Label_0046;
                }
            }
            u = u(context2, set, b2, b3);
        }
        Context b5 = u;
        if (b4) {
            b5 = o0.b(u);
        }
        s.hashCode();
        int n = -1;
        switch (s) {
            case "Button": {
                n = 13;
                break;
            }
            case "EditText": {
                n = 12;
                break;
            }
            case "CheckBox": {
                n = 11;
                break;
            }
            case "AutoCompleteTextView": {
                n = 10;
                break;
            }
            case "ImageView": {
                n = 9;
                break;
            }
            case "ToggleButton": {
                n = 8;
                break;
            }
            case "RadioButton": {
                n = 7;
                break;
            }
            case "Spinner": {
                n = 6;
                break;
            }
            case "SeekBar": {
                n = 5;
                break;
            }
            case "ImageButton": {
                n = 4;
                break;
            }
            case "TextView": {
                n = 3;
                break;
            }
            case "MultiAutoCompleteTextView": {
                n = 2;
                break;
            }
            case "CheckedTextView": {
                n = 1;
                break;
            }
            case "RatingBar": {
                n = 0;
                break;
            }
            default:
                break;
        }
        switch (n) {
            default: {
                o = this.q(b5, s, set);
                break;
            }
            case 13: {
                o = this.d(b5, set);
                this.v((View)o, s);
                break;
            }
            case 12: {
                o = this.g(b5, set);
                this.v((View)o, s);
                break;
            }
            case 11: {
                o = this.e(b5, set);
                this.v((View)o, s);
                break;
            }
            case 10: {
                o = this.c(b5, set);
                this.v((View)o, s);
                break;
            }
            case 9: {
                o = this.i(b5, set);
                this.v((View)o, s);
                break;
            }
            case 8: {
                o = this.p(b5, set);
                this.v((View)o, s);
                break;
            }
            case 7: {
                o = this.k(b5, set);
                this.v((View)o, s);
                break;
            }
            case 6: {
                o = this.n(b5, set);
                this.v((View)o, s);
                break;
            }
            case 5: {
                o = this.m(b5, set);
                this.v((View)o, s);
                break;
            }
            case 4: {
                o = this.h(b5, set);
                this.v((View)o, s);
                break;
            }
            case 3: {
                o = this.o(b5, set);
                this.v((View)o, s);
                break;
            }
            case 2: {
                o = this.j(b5, set);
                this.v((View)o, s);
                break;
            }
            case 1: {
                o = this.f(b5, set);
                this.v((View)o, s);
                break;
            }
            case 0: {
                o = this.l(b5, set);
                this.v((View)o, s);
                break;
            }
        }
        Object t = o;
        if (o == null) {
            t = o;
            if (context != b5) {
                t = this.t(b5, s, set);
            }
        }
        if (t != null) {
            this.b((View)t, set);
            this.a(b5, (View)t, set);
        }
        return (View)t;
    }
    
    private static class a implements View$OnClickListener
    {
        private final View a;
        private final String b;
        private Method c;
        private Context d;
        
        public a(final View a, final String b) {
            this.a = a;
            this.b = b;
        }
        
        private void a(Context d) {
        Label_0047_Outer:
            while (true) {
                Label_0070: {
                    if (d == null) {
                        break Label_0070;
                    }
                    while (true) {
                        try {
                            if (!d.isRestricted()) {
                                final Method method = d.getClass().getMethod(this.b, View.class);
                                if (method != null) {
                                    this.c = method;
                                    this.d = d;
                                    return;
                                }
                            }
                            if (d instanceof ContextWrapper) {
                                d = ((ContextWrapper)d).getBaseContext();
                                continue Label_0047_Outer;
                            }
                            d = null;
                            continue Label_0047_Outer;
                            final int id = this.a.getId();
                            iftrue(Label_0089:)(id != -1);
                            d = (Context)"";
                            while (true) {
                                final StringBuilder sb = new StringBuilder();
                                sb.append("Could not find method ");
                                sb.append(this.b);
                                sb.append("(View) in a parent or ancestor Context for android:onClick attribute defined on view ");
                                sb.append(this.a.getClass());
                                sb.append((String)d);
                                throw new IllegalStateException(sb.toString());
                                Label_0089: {
                                    d = (Context)new StringBuilder();
                                }
                                ((StringBuilder)d).append(" with id '");
                                ((StringBuilder)d).append(this.a.getContext().getResources().getResourceEntryName(id));
                                ((StringBuilder)d).append("'");
                                d = (Context)((StringBuilder)d).toString();
                                continue;
                            }
                        }
                        catch (final NoSuchMethodException ex) {
                            continue;
                        }
                        break;
                    }
                }
            }
        }
        
        public void onClick(final View view) {
            if (this.c == null) {
                this.a(this.a.getContext());
            }
            try {
                this.c.invoke(this.d, view);
            }
            catch (final InvocationTargetException ex) {
                throw new IllegalStateException("Could not execute method for android:onClick", ex);
            }
            catch (final IllegalAccessException ex2) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", ex2);
            }
        }
    }
}
