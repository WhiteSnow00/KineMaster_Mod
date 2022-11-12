// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.text;

import android.text.TextDirectionHeuristics;
import androidx.core.util.c;
import android.text.TextUtils;
import android.text.PrecomputedText$Params$Builder;
import android.text.PrecomputedText$Params;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import android.os.Build$VERSION;
import android.text.PrecomputedText;
import android.text.Spannable;

public class b implements Spannable
{
    private static final Object d;
    private final Spannable a;
    private final a b;
    private final PrecomputedText c;
    
    static {
        d = new Object();
    }
    
    public a a() {
        return this.b;
    }
    
    public PrecomputedText b() {
        final Spannable a = this.a;
        if (a instanceof PrecomputedText) {
            return (PrecomputedText)a;
        }
        return null;
    }
    
    public char charAt(final int n) {
        return this.a.charAt(n);
    }
    
    public int getSpanEnd(final Object o) {
        return this.a.getSpanEnd(o);
    }
    
    public int getSpanFlags(final Object o) {
        return this.a.getSpanFlags(o);
    }
    
    public int getSpanStart(final Object o) {
        return this.a.getSpanStart(o);
    }
    
    public <T> T[] getSpans(final int n, final int n2, final Class<T> clazz) {
        if (Build$VERSION.SDK_INT >= 29) {
            return (T[])this.c.getSpans(n, n2, (Class)clazz);
        }
        return (T[])this.a.getSpans(n, n2, (Class)clazz);
    }
    
    public int length() {
        return this.a.length();
    }
    
    public int nextSpanTransition(final int n, final int n2, final Class clazz) {
        return this.a.nextSpanTransition(n, n2, clazz);
    }
    
    public void removeSpan(final Object o) {
        if (!(o instanceof MetricAffectingSpan)) {
            if (Build$VERSION.SDK_INT >= 29) {
                this.c.removeSpan(o);
            }
            else {
                this.a.removeSpan(o);
            }
            return;
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
    }
    
    public void setSpan(final Object o, final int n, final int n2, final int n3) {
        if (!(o instanceof MetricAffectingSpan)) {
            if (Build$VERSION.SDK_INT >= 29) {
                this.c.setSpan(o, n, n2, n3);
            }
            else {
                this.a.setSpan(o, n, n2, n3);
            }
            return;
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
    }
    
    public CharSequence subSequence(final int n, final int n2) {
        return this.a.subSequence(n, n2);
    }
    
    @Override
    public String toString() {
        return this.a.toString();
    }
    
    public static final class a
    {
        private final TextPaint a;
        private final TextDirectionHeuristic b;
        private final int c;
        private final int d;
        final PrecomputedText$Params e;
        
        public a(PrecomputedText$Params e) {
            this.a = e.getTextPaint();
            this.b = e.getTextDirection();
            this.c = e.getBreakStrategy();
            this.d = e.getHyphenationFrequency();
            if (Build$VERSION.SDK_INT < 29) {
                e = null;
            }
            this.e = e;
        }
        
        a(final TextPaint a, final TextDirectionHeuristic textDirectionHeuristic, final int n, final int n2) {
            if (Build$VERSION.SDK_INT >= 29) {
                this.e = new PrecomputedText$Params$Builder(a).setBreakStrategy(n).setHyphenationFrequency(n2).setTextDirection(textDirectionHeuristic).build();
            }
            else {
                this.e = null;
            }
            this.a = a;
            this.b = textDirectionHeuristic;
            this.c = n;
            this.d = n2;
        }
        
        public boolean a(final b.a a) {
            if (this.c != a.b()) {
                return false;
            }
            if (this.d != a.c()) {
                return false;
            }
            if (this.a.getTextSize() != a.e().getTextSize()) {
                return false;
            }
            if (this.a.getTextScaleX() != a.e().getTextScaleX()) {
                return false;
            }
            if (this.a.getTextSkewX() != a.e().getTextSkewX()) {
                return false;
            }
            if (this.a.getLetterSpacing() != a.e().getLetterSpacing()) {
                return false;
            }
            if (!TextUtils.equals((CharSequence)this.a.getFontFeatureSettings(), (CharSequence)a.e().getFontFeatureSettings())) {
                return false;
            }
            if (this.a.getFlags() != a.e().getFlags()) {
                return false;
            }
            if (!this.a.getTextLocales().equals((Object)a.e().getTextLocales())) {
                return false;
            }
            if (this.a.getTypeface() == null) {
                if (a.e().getTypeface() != null) {
                    return false;
                }
            }
            else if (!this.a.getTypeface().equals((Object)a.e().getTypeface())) {
                return false;
            }
            return true;
        }
        
        public int b() {
            return this.c;
        }
        
        public int c() {
            return this.d;
        }
        
        public TextDirectionHeuristic d() {
            return this.b;
        }
        
        public TextPaint e() {
            return this.a;
        }
        
        @Override
        public boolean equals(final Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof b.a)) {
                return false;
            }
            final b.a a = (b.a)o;
            return this.a(a) && this.b == a.d();
        }
        
        @Override
        public int hashCode() {
            return androidx.core.util.c.b(this.a.getTextSize(), this.a.getTextScaleX(), this.a.getTextSkewX(), this.a.getLetterSpacing(), this.a.getFlags(), this.a.getTextLocales(), this.a.getTypeface(), this.a.isElegantTextHeight(), this.b, this.c, this.d);
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("textSize=");
            sb2.append(this.a.getTextSize());
            sb.append(sb2.toString());
            final StringBuilder sb3 = new StringBuilder();
            sb3.append(", textScaleX=");
            sb3.append(this.a.getTextScaleX());
            sb.append(sb3.toString());
            final StringBuilder sb4 = new StringBuilder();
            sb4.append(", textSkewX=");
            sb4.append(this.a.getTextSkewX());
            sb.append(sb4.toString());
            final StringBuilder sb5 = new StringBuilder();
            sb5.append(", letterSpacing=");
            sb5.append(this.a.getLetterSpacing());
            sb.append(sb5.toString());
            final StringBuilder sb6 = new StringBuilder();
            sb6.append(", elegantTextHeight=");
            sb6.append(this.a.isElegantTextHeight());
            sb.append(sb6.toString());
            final StringBuilder sb7 = new StringBuilder();
            sb7.append(", textLocale=");
            sb7.append(this.a.getTextLocales());
            sb.append(sb7.toString());
            final StringBuilder sb8 = new StringBuilder();
            sb8.append(", typeface=");
            sb8.append(this.a.getTypeface());
            sb.append(sb8.toString());
            final StringBuilder sb9 = new StringBuilder();
            sb9.append(", variationSettings=");
            sb9.append(this.a.getFontVariationSettings());
            sb.append(sb9.toString());
            final StringBuilder sb10 = new StringBuilder();
            sb10.append(", textDir=");
            sb10.append(this.b);
            sb.append(sb10.toString());
            final StringBuilder sb11 = new StringBuilder();
            sb11.append(", breakStrategy=");
            sb11.append(this.c);
            sb.append(sb11.toString());
            final StringBuilder sb12 = new StringBuilder();
            sb12.append(", hyphenationFrequency=");
            sb12.append(this.d);
            sb.append(sb12.toString());
            sb.append("}");
            return sb.toString();
        }
        
        public static class a
        {
            private final TextPaint a;
            private TextDirectionHeuristic b;
            private int c;
            private int d;
            
            public a(final TextPaint a) {
                this.a = a;
                this.c = 1;
                this.d = 1;
                this.b = TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }
            
            public b.a a() {
                return new b.a(this.a, this.b, this.c, this.d);
            }
            
            public a b(final int c) {
                this.c = c;
                return this;
            }
            
            public a c(final int d) {
                this.d = d;
                return this;
            }
            
            public a d(final TextDirectionHeuristic b) {
                this.b = b;
                return this;
            }
        }
    }
}
