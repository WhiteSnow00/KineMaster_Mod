// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import android.text.TextDirectionHeuristics;
import android.text.TextDirectionHeuristic;
import android.text.StaticLayout$Builder;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.core.view.b0;
import d.j;
import android.util.AttributeSet;
import android.text.StaticLayout;
import android.text.method.TransformationMethod;
import android.text.Layout$Alignment;
import android.content.res.TypedArray;
import android.view.View;
import android.util.Log;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;
import android.os.Build$VERSION;
import android.content.Context;
import android.widget.TextView;
import android.text.TextPaint;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import android.graphics.RectF;

class w
{
    private static final RectF l;
    private static ConcurrentHashMap<String, Method> m;
    private static ConcurrentHashMap<String, Field> n;
    private int a;
    private boolean b;
    private float c;
    private float d;
    private float e;
    private int[] f;
    private boolean g;
    private TextPaint h;
    private final TextView i;
    private final Context j;
    private final f k;
    
    static {
        l = new RectF();
        w.m = new ConcurrentHashMap<String, Method>();
        w.n = new ConcurrentHashMap<String, Field>();
    }
    
    w(final TextView i) {
        this.a = 0;
        this.b = false;
        this.c = -1.0f;
        this.d = -1.0f;
        this.e = -1.0f;
        this.f = new int[0];
        this.g = false;
        this.i = i;
        this.j = i.getContext();
        if (Build$VERSION.SDK_INT >= 29) {
            this.k = (f)new e();
        }
        else {
            this.k = (f)new d();
        }
    }
    
    private int[] b(int[] array) {
        final int length = array.length;
        if (length == 0) {
            return array;
        }
        Arrays.sort(array);
        final ArrayList list = new ArrayList();
        final int n = 0;
        for (final int n2 : array) {
            if (n2 > 0 && Collections.binarySearch(list, n2) < 0) {
                list.add(n2);
            }
        }
        if (length == list.size()) {
            return array;
        }
        final int size = list.size();
        array = new int[size];
        for (int j = n; j < size; ++j) {
            array[j] = (int)list.get(j);
        }
        return array;
    }
    
    private void c() {
        this.a = 0;
        this.d = -1.0f;
        this.e = -1.0f;
        this.c = -1.0f;
        this.f = new int[0];
        this.b = false;
    }
    
    private int e(final RectF rectF) {
        int length = this.f.length;
        if (length != 0) {
            int n = 0;
            int i = 1;
            --length;
            while (i <= length) {
                n = (i + length) / 2;
                if (this.x(this.f[n], rectF)) {
                    final int n2 = n + 1;
                    n = i;
                    i = n2;
                }
                else {
                    length = --n;
                }
            }
            return this.f[n];
        }
        throw new IllegalStateException("No available text sizes to choose from.");
    }
    
    private static Method k(final String s) {
        try {
            Method method;
            if ((method = w.m.get(s)) == null) {
                final Method declaredMethod = TextView.class.getDeclaredMethod(s, (Class<?>[])new Class[0]);
                if ((method = declaredMethod) != null) {
                    declaredMethod.setAccessible(true);
                    w.m.put(s, declaredMethod);
                    method = declaredMethod;
                }
            }
            return method;
        }
        catch (final Exception ex) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Failed to retrieve TextView#");
            sb.append(s);
            sb.append("() method");
            Log.w("ACTVAutoSizeHelper", sb.toString(), (Throwable)ex);
            return null;
        }
    }
    
    static <T> T m(Object o, final String s, T invoke) {
        try {
            try {
                o = (invoke = (T)k(s).invoke(o, new Object[0]));
            }
            finally {}
        }
        catch (final Exception ex) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Failed to invoke TextView#");
            sb.append(s);
            sb.append("() method");
            Log.w("ACTVAutoSizeHelper", sb.toString(), (Throwable)ex);
        }
        return invoke;
    }
    
    private void s(final float textSize) {
        if (textSize != this.i.getPaint().getTextSize()) {
            this.i.getPaint().setTextSize(textSize);
            final boolean a = w.b.a((View)this.i);
            if (this.i.getLayout() != null) {
                this.b = false;
                try {
                    final Method k = k("nullLayouts");
                    if (k != null) {
                        k.invoke(this.i, new Object[0]);
                    }
                }
                catch (final Exception ex) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", (Throwable)ex);
                }
                if (!a) {
                    this.i.requestLayout();
                }
                else {
                    this.i.forceLayout();
                }
                this.i.invalidate();
            }
        }
    }
    
    private boolean u() {
        final boolean y = this.y();
        int i = 0;
        if (y && this.a == 1) {
            if (!this.g || this.f.length == 0) {
                final int n = (int)Math.floor((this.e - this.d) / this.c) + 1;
                final int[] array = new int[n];
                while (i < n) {
                    array[i] = Math.round(this.d + i * this.c);
                    ++i;
                }
                this.f = this.b(array);
            }
            this.b = true;
        }
        else {
            this.b = false;
        }
        return this.b;
    }
    
    private void v(final TypedArray typedArray) {
        final int length = typedArray.length();
        final int[] array = new int[length];
        if (length > 0) {
            for (int i = 0; i < length; ++i) {
                array[i] = typedArray.getDimensionPixelSize(i, -1);
            }
            this.f = this.b(array);
            this.w();
        }
    }
    
    private boolean w() {
        final int[] f = this.f;
        final int length = f.length;
        final boolean g = length > 0;
        this.g = g;
        if (g) {
            this.a = 1;
            this.d = (float)f[0];
            this.e = (float)f[length - 1];
            this.c = -1.0f;
        }
        return g;
    }
    
    private boolean x(final int n, final RectF rectF) {
        final CharSequence text = this.i.getText();
        final TransformationMethod transformationMethod = this.i.getTransformationMethod();
        CharSequence charSequence = text;
        if (transformationMethod != null) {
            final CharSequence transformation = transformationMethod.getTransformation(text, (View)this.i);
            charSequence = text;
            if (transformation != null) {
                charSequence = transformation;
            }
        }
        final int b = w.a.b(this.i);
        this.l(n);
        final StaticLayout d = this.d(charSequence, m(this.i, "getLayoutAlignment", Layout$Alignment.ALIGN_NORMAL), Math.round(rectF.right), b);
        return (b == -1 || (d.getLineCount() <= b && d.getLineEnd(d.getLineCount() - 1) == charSequence.length())) && d.getHeight() <= rectF.bottom;
    }
    
    private boolean y() {
        return this.i instanceof AppCompatEditText ^ true;
    }
    
    private void z(final float d, final float e, final float c) throws IllegalArgumentException {
        if (d <= 0.0f) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Minimum auto-size text size (");
            sb.append(d);
            sb.append("px) is less or equal to (0px)");
            throw new IllegalArgumentException(sb.toString());
        }
        if (e <= d) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Maximum auto-size text size (");
            sb2.append(e);
            sb2.append("px) is less or equal to minimum auto-size text size (");
            sb2.append(d);
            sb2.append("px)");
            throw new IllegalArgumentException(sb2.toString());
        }
        if (c > 0.0f) {
            this.a = 1;
            this.d = d;
            this.e = e;
            this.c = c;
            this.g = false;
            return;
        }
        final StringBuilder sb3 = new StringBuilder();
        sb3.append("The auto-size step granularity (");
        sb3.append(c);
        sb3.append("px) is less or equal to (0px)");
        throw new IllegalArgumentException(sb3.toString());
    }
    
    void a() {
        if (!this.n()) {
            return;
        }
        Label_0186: {
            if (this.b) {
                if (this.i.getMeasuredHeight() > 0) {
                    if (this.i.getMeasuredWidth() > 0) {
                        int n;
                        if (this.k.b(this.i)) {
                            n = 1048576;
                        }
                        else {
                            n = this.i.getMeasuredWidth() - this.i.getTotalPaddingLeft() - this.i.getTotalPaddingRight();
                        }
                        final int n2 = this.i.getHeight() - this.i.getCompoundPaddingBottom() - this.i.getCompoundPaddingTop();
                        if (n > 0) {
                            if (n2 > 0) {
                                final RectF l = w.l;
                                synchronized (l) {
                                    l.setEmpty();
                                    l.right = (float)n;
                                    l.bottom = (float)n2;
                                    final float n3 = (float)this.e(l);
                                    if (n3 != this.i.getTextSize()) {
                                        this.t(0, n3);
                                    }
                                    break Label_0186;
                                }
                            }
                        }
                    }
                }
                return;
            }
        }
        this.b = true;
    }
    
    StaticLayout d(final CharSequence charSequence, final Layout$Alignment layout$Alignment, final int n, final int n2) {
        return w.c.a(charSequence, layout$Alignment, n, n2, this.i, this.h, this.k);
    }
    
    int f() {
        return Math.round(this.e);
    }
    
    int g() {
        return Math.round(this.d);
    }
    
    int h() {
        return Math.round(this.c);
    }
    
    int[] i() {
        return this.f;
    }
    
    int j() {
        return this.a;
    }
    
    void l(final int n) {
        final TextPaint h = this.h;
        if (h == null) {
            this.h = new TextPaint();
        }
        else {
            h.reset();
        }
        this.h.set(this.i.getPaint());
        this.h.setTextSize((float)n);
    }
    
    boolean n() {
        return this.y() && this.a != 0;
    }
    
    void o(final AttributeSet set, int n) {
        final Context j = this.j;
        final int[] g0 = d.j.g0;
        final TypedArray obtainStyledAttributes = j.obtainStyledAttributes(set, g0, n, 0);
        final TextView i = this.i;
        b0.n0((View)i, i.getContext(), g0, set, obtainStyledAttributes, n, 0);
        n = d.j.l0;
        if (obtainStyledAttributes.hasValue(n)) {
            this.a = obtainStyledAttributes.getInt(n, 0);
        }
        n = d.j.k0;
        float dimension;
        if (obtainStyledAttributes.hasValue(n)) {
            dimension = obtainStyledAttributes.getDimension(n, -1.0f);
        }
        else {
            dimension = -1.0f;
        }
        n = d.j.i0;
        float dimension2;
        if (obtainStyledAttributes.hasValue(n)) {
            dimension2 = obtainStyledAttributes.getDimension(n, -1.0f);
        }
        else {
            dimension2 = -1.0f;
        }
        n = d.j.h0;
        float dimension3;
        if (obtainStyledAttributes.hasValue(n)) {
            dimension3 = obtainStyledAttributes.getDimension(n, -1.0f);
        }
        else {
            dimension3 = -1.0f;
        }
        n = d.j.j0;
        if (obtainStyledAttributes.hasValue(n)) {
            n = obtainStyledAttributes.getResourceId(n, 0);
            if (n > 0) {
                final TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(n);
                this.v(obtainTypedArray);
                obtainTypedArray.recycle();
            }
        }
        obtainStyledAttributes.recycle();
        if (this.y()) {
            if (this.a == 1) {
                if (!this.g) {
                    final DisplayMetrics displayMetrics = this.j.getResources().getDisplayMetrics();
                    float applyDimension = dimension2;
                    if (dimension2 == -1.0f) {
                        applyDimension = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                    }
                    float applyDimension2 = dimension3;
                    if (dimension3 == -1.0f) {
                        applyDimension2 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                    }
                    float n2 = dimension;
                    if (dimension == -1.0f) {
                        n2 = 1.0f;
                    }
                    this.z(applyDimension, applyDimension2, n2);
                }
                this.u();
            }
        }
        else {
            this.a = 0;
        }
    }
    
    void p(final int n, final int n2, final int n3, final int n4) throws IllegalArgumentException {
        if (this.y()) {
            final DisplayMetrics displayMetrics = this.j.getResources().getDisplayMetrics();
            this.z(TypedValue.applyDimension(n4, (float)n, displayMetrics), TypedValue.applyDimension(n4, (float)n2, displayMetrics), TypedValue.applyDimension(n4, (float)n3, displayMetrics));
            if (this.u()) {
                this.a();
            }
        }
    }
    
    void q(final int[] array, final int n) throws IllegalArgumentException {
        if (this.y()) {
            final int length = array.length;
            int n2 = 0;
            if (length > 0) {
                final int[] array2 = new int[length];
                int[] copy;
                if (n == 0) {
                    copy = Arrays.copyOf(array, length);
                }
                else {
                    final DisplayMetrics displayMetrics = this.j.getResources().getDisplayMetrics();
                    while (true) {
                        copy = array2;
                        if (n2 >= length) {
                            break;
                        }
                        array2[n2] = Math.round(TypedValue.applyDimension(n, (float)array[n2], displayMetrics));
                        ++n2;
                    }
                }
                this.f = this.b(copy);
                if (!this.w()) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("None of the preset sizes is valid: ");
                    sb.append(Arrays.toString(array));
                    throw new IllegalArgumentException(sb.toString());
                }
            }
            else {
                this.g = false;
            }
            if (this.u()) {
                this.a();
            }
        }
    }
    
    void r(final int n) {
        if (this.y()) {
            if (n != 0) {
                if (n != 1) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Unknown auto-size text type: ");
                    sb.append(n);
                    throw new IllegalArgumentException(sb.toString());
                }
                final DisplayMetrics displayMetrics = this.j.getResources().getDisplayMetrics();
                this.z(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
                if (this.u()) {
                    this.a();
                }
            }
            else {
                this.c();
            }
        }
    }
    
    void t(final int n, final float n2) {
        final Context j = this.j;
        Resources resources;
        if (j == null) {
            resources = Resources.getSystem();
        }
        else {
            resources = j.getResources();
        }
        this.s(TypedValue.applyDimension(n, n2, resources.getDisplayMetrics()));
    }
    
    private static final class a
    {
        static StaticLayout a(final CharSequence charSequence, final Layout$Alignment layout$Alignment, final int n, final TextView textView, final TextPaint textPaint) {
            return new StaticLayout(charSequence, textPaint, n, layout$Alignment, textView.getLineSpacingMultiplier(), textView.getLineSpacingExtra(), textView.getIncludeFontPadding());
        }
        
        static int b(final TextView textView) {
            return textView.getMaxLines();
        }
    }
    
    private static final class b
    {
        static boolean a(final View view) {
            return view.isInLayout();
        }
    }
    
    private static final class c
    {
        static StaticLayout a(CharSequence obtain, final Layout$Alignment alignment, int maxLines, final int n, final TextView textView, final TextPaint textPaint, final f f) {
            obtain = (CharSequence)StaticLayout$Builder.obtain(obtain, 0, obtain.length(), textPaint, maxLines);
            final StaticLayout$Builder setHyphenationFrequency = ((StaticLayout$Builder)obtain).setAlignment(alignment).setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier()).setIncludePad(textView.getIncludeFontPadding()).setBreakStrategy(textView.getBreakStrategy()).setHyphenationFrequency(textView.getHyphenationFrequency());
            maxLines = n;
            if (n == -1) {
                maxLines = Integer.MAX_VALUE;
            }
            setHyphenationFrequency.setMaxLines(maxLines);
            try {
                f.a((StaticLayout$Builder)obtain, textView);
            }
            catch (final ClassCastException ex) {
                Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
            }
            return ((StaticLayout$Builder)obtain).build();
        }
    }
    
    private static class d extends f
    {
        d() {
        }
        
        @Override
        void a(final StaticLayout$Builder staticLayout$Builder, final TextView textView) {
            staticLayout$Builder.setTextDirection((TextDirectionHeuristic)w.m(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }
    
    private static class f
    {
        f() {
        }
        
        void a(final StaticLayout$Builder staticLayout$Builder, final TextView textView) {
            throw null;
        }
        
        boolean b(final TextView textView) {
            return w.m(textView, "getHorizontallyScrolling", Boolean.FALSE);
        }
    }
    
    private static class e extends d
    {
        e() {
        }
        
        @Override
        void a(final StaticLayout$Builder staticLayout$Builder, final TextView textView) {
            staticLayout$Builder.setTextDirection(textView.getTextDirectionHeuristic());
        }
        
        @Override
        boolean b(final TextView textView) {
            return textView.isHorizontallyScrollable();
        }
    }
}
