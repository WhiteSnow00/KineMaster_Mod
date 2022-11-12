// 
// Decompiled by Procyon v0.6.0
// 

package androidx.emoji2.text;

import android.os.Build$VERSION;
import android.text.Spannable;
import java.util.concurrent.atomic.AtomicInteger;
import android.text.SpanWatcher;
import android.text.TextWatcher;
import java.lang.reflect.Array;
import java.io.IOException;
import android.text.Editable;
import androidx.core.util.h;
import java.util.ArrayList;
import java.util.List;
import android.text.SpannableStringBuilder;

public final class n extends SpannableStringBuilder
{
    private final Class<?> a;
    private final List<a> b;
    
    n(final Class<?> a, final CharSequence charSequence) {
        super(charSequence);
        this.b = new ArrayList<a>();
        h.h(a, "watcherClass cannot be null");
        this.a = a;
    }
    
    n(final Class<?> a, final CharSequence charSequence, final int n, final int n2) {
        super(charSequence, n, n2);
        this.b = new ArrayList<a>();
        h.h(a, "watcherClass cannot be null");
        this.a = a;
    }
    
    private void b() {
        for (int i = 0; i < this.b.size(); ++i) {
            this.b.get(i).a();
        }
    }
    
    public static n c(final Class<?> clazz, final CharSequence charSequence) {
        return new n(clazz, charSequence);
    }
    
    private void e() {
        for (int i = 0; i < this.b.size(); ++i) {
            this.b.get(i).onTextChanged((CharSequence)this, 0, this.length(), this.length());
        }
    }
    
    private a f(final Object o) {
        for (int i = 0; i < this.b.size(); ++i) {
            final a a = this.b.get(i);
            if (a.a == o) {
                return a;
            }
        }
        return null;
    }
    
    private boolean g(final Class<?> clazz) {
        return this.a == clazz;
    }
    
    private boolean h(final Object o) {
        return o != null && this.g(o.getClass());
    }
    
    private void i() {
        for (int i = 0; i < this.b.size(); ++i) {
            this.b.get(i).c();
        }
    }
    
    public void a() {
        this.b();
    }
    
    public /* bridge */ Editable append(final char c) {
        return (Editable)this.append(c);
    }
    
    public /* bridge */ Editable append(final CharSequence charSequence) {
        return (Editable)this.append(charSequence);
    }
    
    public /* bridge */ Editable append(final CharSequence charSequence, final int n, final int n2) {
        return (Editable)this.append(charSequence, n, n2);
    }
    
    public SpannableStringBuilder append(final char c) {
        super.append(c);
        return this;
    }
    
    public SpannableStringBuilder append(final CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }
    
    public SpannableStringBuilder append(final CharSequence charSequence, final int n, final int n2) {
        super.append(charSequence, n, n2);
        return this;
    }
    
    public SpannableStringBuilder append(final CharSequence charSequence, final Object o, final int n) {
        super.append(charSequence, o, n);
        return this;
    }
    
    public /* bridge */ Appendable append(final char c) throws IOException {
        return (Appendable)this.append(c);
    }
    
    public /* bridge */ Appendable append(final CharSequence charSequence) throws IOException {
        return (Appendable)this.append(charSequence);
    }
    
    public /* bridge */ Appendable append(final CharSequence charSequence, final int n, final int n2) throws IOException {
        return (Appendable)this.append(charSequence, n, n2);
    }
    
    public void d() {
        this.i();
        this.e();
    }
    
    public /* bridge */ Editable delete(final int n, final int n2) {
        return (Editable)this.delete(n, n2);
    }
    
    public SpannableStringBuilder delete(final int n, final int n2) {
        super.delete(n, n2);
        return this;
    }
    
    public int getSpanEnd(final Object o) {
        Object o2 = o;
        if (this.h(o)) {
            final a f = this.f(o);
            o2 = o;
            if (f != null) {
                o2 = f;
            }
        }
        return super.getSpanEnd(o2);
    }
    
    public int getSpanFlags(final Object o) {
        Object o2 = o;
        if (this.h(o)) {
            final a f = this.f(o);
            o2 = o;
            if (f != null) {
                o2 = f;
            }
        }
        return super.getSpanFlags(o2);
    }
    
    public int getSpanStart(final Object o) {
        Object o2 = o;
        if (this.h(o)) {
            final a f = this.f(o);
            o2 = o;
            if (f != null) {
                o2 = f;
            }
        }
        return super.getSpanStart(o2);
    }
    
    public <T> T[] getSpans(int i, final int n, final Class<T> clazz) {
        if (this.g(clazz)) {
            final a[] array = (a[])super.getSpans(i, n, (Class)a.class);
            final Object[] array2 = (Object[])Array.newInstance(clazz, array.length);
            for (i = 0; i < array.length; ++i) {
                array2[i] = array[i].a;
            }
            return (T[])array2;
        }
        return (T[])super.getSpans(i, n, (Class)clazz);
    }
    
    public /* bridge */ Editable insert(final int n, final CharSequence charSequence) {
        return (Editable)this.insert(n, charSequence);
    }
    
    public /* bridge */ Editable insert(final int n, final CharSequence charSequence, final int n2, final int n3) {
        return (Editable)this.insert(n, charSequence, n2, n3);
    }
    
    public SpannableStringBuilder insert(final int n, final CharSequence charSequence) {
        super.insert(n, charSequence);
        return this;
    }
    
    public SpannableStringBuilder insert(final int n, final CharSequence charSequence, final int n2, final int n3) {
        super.insert(n, charSequence, n2, n3);
        return this;
    }
    
    public int nextSpanTransition(final int n, final int n2, final Class clazz) {
        if (clazz != null) {
            final Class<a> clazz2 = clazz;
            if (!this.g(clazz)) {
                return super.nextSpanTransition(n, n2, (Class)clazz2);
            }
        }
        final Class<a> clazz2 = a.class;
        return super.nextSpanTransition(n, n2, (Class)clazz2);
    }
    
    public void removeSpan(Object o) {
        a a;
        if (this.h(o)) {
            final a f = this.f(o);
            if ((a = f) != null) {
                o = f;
                a = f;
            }
        }
        else {
            a = null;
        }
        super.removeSpan(o);
        if (a != null) {
            this.b.remove(a);
        }
    }
    
    public /* bridge */ Editable replace(final int n, final int n2, final CharSequence charSequence) {
        return (Editable)this.replace(n, n2, charSequence);
    }
    
    public /* bridge */ Editable replace(final int n, final int n2, final CharSequence charSequence, final int n3, final int n4) {
        return (Editable)this.replace(n, n2, charSequence, n3, n4);
    }
    
    public SpannableStringBuilder replace(final int n, final int n2, final CharSequence charSequence) {
        this.b();
        super.replace(n, n2, charSequence);
        this.i();
        return this;
    }
    
    public SpannableStringBuilder replace(final int n, final int n2, final CharSequence charSequence, final int n3, final int n4) {
        this.b();
        super.replace(n, n2, charSequence, n3, n4);
        this.i();
        return this;
    }
    
    public void setSpan(final Object o, final int n, final int n2, final int n3) {
        Object o2 = o;
        if (this.h(o)) {
            o2 = new a(o);
            this.b.add((a)o2);
        }
        super.setSpan(o2, n, n2, n3);
    }
    
    public CharSequence subSequence(final int n, final int n2) {
        return (CharSequence)new n(this.a, (CharSequence)this, n, n2);
    }
    
    private static class a implements TextWatcher, SpanWatcher
    {
        final Object a;
        private final AtomicInteger b;
        
        a(final Object a) {
            this.b = new AtomicInteger(0);
            this.a = a;
        }
        
        private boolean b(final Object o) {
            return o instanceof i;
        }
        
        final void a() {
            this.b.incrementAndGet();
        }
        
        public void afterTextChanged(final Editable editable) {
            ((TextWatcher)this.a).afterTextChanged(editable);
        }
        
        public void beforeTextChanged(final CharSequence charSequence, final int n, final int n2, final int n3) {
            ((TextWatcher)this.a).beforeTextChanged(charSequence, n, n2, n3);
        }
        
        final void c() {
            this.b.decrementAndGet();
        }
        
        public void onSpanAdded(final Spannable spannable, final Object o, final int n, final int n2) {
            if (this.b.get() > 0 && this.b(o)) {
                return;
            }
            ((SpanWatcher)this.a).onSpanAdded(spannable, o, n, n2);
        }
        
        public void onSpanChanged(final Spannable spannable, final Object o, int n, final int n2, int n3, final int n4) {
            if (this.b.get() > 0 && this.b(o)) {
                return;
            }
            if (Build$VERSION.SDK_INT < 28) {
                if (n > n2) {
                    n = 0;
                }
                if (n3 > n4) {
                    n3 = 0;
                }
            }
            ((SpanWatcher)this.a).onSpanChanged(spannable, o, n, n2, n3, n4);
        }
        
        public void onSpanRemoved(final Spannable spannable, final Object o, final int n, final int n2) {
            if (this.b.get() > 0 && this.b(o)) {
                return;
            }
            ((SpanWatcher)this.a).onSpanRemoved(spannable, o, n, n2);
        }
        
        public void onTextChanged(final CharSequence charSequence, final int n, final int n2, final int n3) {
            ((TextWatcher)this.a).onTextChanged(charSequence, n, n2, n3);
        }
    }
}
