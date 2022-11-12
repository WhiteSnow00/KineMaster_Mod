// 
// Decompiled by Procyon v0.6.0
// 

package androidx.emoji2.text;

import android.text.PrecomputedText;
import androidx.core.text.b;
import java.util.stream.IntStream;
import android.os.Build$VERSION;
import android.text.SpannableString;
import android.text.Spannable;

class p implements Spannable
{
    private boolean a;
    private Spannable b;
    
    p(final Spannable b) {
        this.a = false;
        this.b = b;
    }
    
    p(final CharSequence charSequence) {
        this.a = false;
        this.b = (Spannable)new SpannableString(charSequence);
    }
    
    private void a() {
        final Spannable b = this.b;
        if (!this.a && c().a((CharSequence)b)) {
            this.b = (Spannable)new SpannableString((CharSequence)b);
        }
        this.a = true;
    }
    
    static b c() {
        Object o;
        if (Build$VERSION.SDK_INT < 28) {
            o = new b();
        }
        else {
            o = new c();
        }
        return (b)o;
    }
    
    Spannable b() {
        return this.b;
    }
    
    public char charAt(final int n) {
        return this.b.charAt(n);
    }
    
    public IntStream chars() {
        return p.a.a((CharSequence)this.b);
    }
    
    public IntStream codePoints() {
        return p.a.b((CharSequence)this.b);
    }
    
    public int getSpanEnd(final Object o) {
        return this.b.getSpanEnd(o);
    }
    
    public int getSpanFlags(final Object o) {
        return this.b.getSpanFlags(o);
    }
    
    public int getSpanStart(final Object o) {
        return this.b.getSpanStart(o);
    }
    
    public <T> T[] getSpans(final int n, final int n2, final Class<T> clazz) {
        return (T[])this.b.getSpans(n, n2, (Class)clazz);
    }
    
    public int length() {
        return this.b.length();
    }
    
    public int nextSpanTransition(final int n, final int n2, final Class clazz) {
        return this.b.nextSpanTransition(n, n2, clazz);
    }
    
    public void removeSpan(final Object o) {
        this.a();
        this.b.removeSpan(o);
    }
    
    public void setSpan(final Object o, final int n, final int n2, final int n3) {
        this.a();
        this.b.setSpan(o, n, n2, n3);
    }
    
    public CharSequence subSequence(final int n, final int n2) {
        return this.b.subSequence(n, n2);
    }
    
    @Override
    public String toString() {
        return this.b.toString();
    }
    
    private static class a
    {
        static IntStream a(final CharSequence charSequence) {
            return charSequence.chars();
        }
        
        static IntStream b(final CharSequence charSequence) {
            return charSequence.codePoints();
        }
    }
    
    static class b
    {
        boolean a(final CharSequence charSequence) {
            return charSequence instanceof androidx.core.text.b;
        }
    }
    
    static class c extends b
    {
        @Override
        boolean a(final CharSequence charSequence) {
            return charSequence instanceof PrecomputedText || charSequence instanceof androidx.core.text.b;
        }
    }
}
