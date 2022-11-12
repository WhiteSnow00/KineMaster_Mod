// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.text;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import android.os.Parcelable;
import java.io.Serializable;
import com.google.common.base.Objects;
import android.text.TextUtils;
import android.os.Bundle;
import android.text.SpannedString;
import android.text.Spanned;
import com.google.android.exoplayer2.util.Assertions;
import c4.a;
import android.graphics.Bitmap;
import android.text.Layout$Alignment;
import com.google.android.exoplayer2.Bundleable;

public final class Cue implements Bundleable
{
    public static final Cue C;
    public static final Creator<Cue> D;
    public final int A;
    public final float B;
    public final CharSequence a;
    public final Layout$Alignment b;
    public final Layout$Alignment c;
    public final Bitmap d;
    public final float e;
    public final int f;
    public final int g;
    public final float h;
    public final int i;
    public final float j;
    public final float p;
    public final boolean w;
    public final int x;
    public final int y;
    public final float z;
    
    static {
        C = new Builder().o("").a();
        D = a.a;
    }
    
    private Cue(final CharSequence charSequence, final Layout$Alignment b, final Layout$Alignment c, final Bitmap d, final float e, final int f, final int g, final float h, final int i, final int y, final float z, final float j, final float p17, final boolean w, final int x, final int a, final float b2) {
        if (charSequence == null) {
            Assertions.e(d);
        }
        else {
            Assertions.a(d == null);
        }
        if (charSequence instanceof Spanned) {
            this.a = (CharSequence)SpannedString.valueOf(charSequence);
        }
        else if (charSequence != null) {
            this.a = charSequence.toString();
        }
        else {
            this.a = null;
        }
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
        this.j = j;
        this.p = p17;
        this.w = w;
        this.x = x;
        this.y = y;
        this.z = z;
        this.A = a;
        this.B = b2;
    }
    
    Cue(final CharSequence charSequence, final Layout$Alignment layout$Alignment, final Layout$Alignment layout$Alignment2, final Bitmap bitmap, final float n, final int n2, final int n3, final float n4, final int n5, final int n6, final float n7, final float n8, final float n9, final boolean b, final int n10, final int n11, final float n12, final Cue$a object) {
        this(charSequence, layout$Alignment, layout$Alignment2, bitmap, n, n2, n3, n4, n5, n6, n7, n8, n9, b, n10, n11, n12);
    }
    
    public static Cue a(final Bundle bundle) {
        return c(bundle);
    }
    
    private static final Cue c(final Bundle bundle) {
        final Builder builder = new Builder();
        final CharSequence charSequence = bundle.getCharSequence(d(0));
        if (charSequence != null) {
            builder.o(charSequence);
        }
        final Layout$Alignment layout$Alignment = (Layout$Alignment)bundle.getSerializable(d(1));
        if (layout$Alignment != null) {
            builder.p(layout$Alignment);
        }
        final Layout$Alignment layout$Alignment2 = (Layout$Alignment)bundle.getSerializable(d(2));
        if (layout$Alignment2 != null) {
            builder.j(layout$Alignment2);
        }
        final Bitmap bitmap = (Bitmap)bundle.getParcelable(d(3));
        if (bitmap != null) {
            builder.f(bitmap);
        }
        if (bundle.containsKey(d(4)) && bundle.containsKey(d(5))) {
            builder.h(bundle.getFloat(d(4)), bundle.getInt(d(5)));
        }
        if (bundle.containsKey(d(6))) {
            builder.i(bundle.getInt(d(6)));
        }
        if (bundle.containsKey(d(7))) {
            builder.k(bundle.getFloat(d(7)));
        }
        if (bundle.containsKey(d(8))) {
            builder.l(bundle.getInt(d(8)));
        }
        if (bundle.containsKey(d(10)) && bundle.containsKey(d(9))) {
            builder.q(bundle.getFloat(d(10)), bundle.getInt(d(9)));
        }
        if (bundle.containsKey(d(11))) {
            builder.n(bundle.getFloat(d(11)));
        }
        if (bundle.containsKey(d(12))) {
            builder.g(bundle.getFloat(d(12)));
        }
        if (bundle.containsKey(d(13))) {
            builder.s(bundle.getInt(d(13)));
        }
        if (!bundle.getBoolean(d(14), false)) {
            builder.b();
        }
        if (bundle.containsKey(d(15))) {
            builder.r(bundle.getInt(d(15)));
        }
        if (bundle.containsKey(d(16))) {
            builder.m(bundle.getFloat(d(16)));
        }
        return builder.a();
    }
    
    private static String d(final int n) {
        return Integer.toString(n, 36);
    }
    
    public Builder b() {
        return new Builder(this, null);
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && Cue.class == o.getClass()) {
            final Cue cue = (Cue)o;
            if (TextUtils.equals(this.a, cue.a) && this.b == cue.b && this.c == cue.c) {
                final Bitmap d = this.d;
                if (d == null) {
                    if (cue.d != null) {
                        return false;
                    }
                }
                else {
                    final Bitmap d2 = cue.d;
                    if (d2 == null || !d.sameAs(d2)) {
                        return false;
                    }
                }
                if (this.e == cue.e && this.f == cue.f && this.g == cue.g && this.h == cue.h && this.i == cue.i && this.j == cue.j && this.p == cue.p && this.w == cue.w && this.x == cue.x && this.y == cue.y && this.z == cue.z && this.A == cue.A && this.B == cue.B) {
                    return b;
                }
            }
            b = false;
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return Objects.b(new Object[] { this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.p, this.w, this.x, this.y, this.z, this.A, this.B });
    }
    
    @Override
    public Bundle toBundle() {
        final Bundle bundle = new Bundle();
        bundle.putCharSequence(d(0), this.a);
        bundle.putSerializable(d(1), (Serializable)this.b);
        bundle.putSerializable(d(2), (Serializable)this.c);
        bundle.putParcelable(d(3), (Parcelable)this.d);
        bundle.putFloat(d(4), this.e);
        bundle.putInt(d(5), this.f);
        bundle.putInt(d(6), this.g);
        bundle.putFloat(d(7), this.h);
        bundle.putInt(d(8), this.i);
        bundle.putInt(d(9), this.y);
        bundle.putFloat(d(10), this.z);
        bundle.putFloat(d(11), this.j);
        bundle.putFloat(d(12), this.p);
        bundle.putBoolean(d(14), this.w);
        bundle.putInt(d(13), this.x);
        bundle.putInt(d(15), this.A);
        bundle.putFloat(d(16), this.B);
        return bundle;
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE })
    public @interface AnchorType {
    }
    
    public static final class Builder
    {
        private CharSequence a;
        private Bitmap b;
        private Layout$Alignment c;
        private Layout$Alignment d;
        private float e;
        private int f;
        private int g;
        private float h;
        private int i;
        private int j;
        private float k;
        private float l;
        private float m;
        private boolean n;
        private int o;
        private int p;
        private float q;
        
        public Builder() {
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = -3.4028235E38f;
            this.f = Integer.MIN_VALUE;
            this.g = Integer.MIN_VALUE;
            this.h = -3.4028235E38f;
            this.i = Integer.MIN_VALUE;
            this.j = Integer.MIN_VALUE;
            this.k = -3.4028235E38f;
            this.l = -3.4028235E38f;
            this.m = -3.4028235E38f;
            this.n = false;
            this.o = -16777216;
            this.p = Integer.MIN_VALUE;
        }
        
        private Builder(final Cue cue) {
            this.a = cue.a;
            this.b = cue.d;
            this.c = cue.b;
            this.d = cue.c;
            this.e = cue.e;
            this.f = cue.f;
            this.g = cue.g;
            this.h = cue.h;
            this.i = cue.i;
            this.j = cue.y;
            this.k = cue.z;
            this.l = cue.j;
            this.m = cue.p;
            this.n = cue.w;
            this.o = cue.x;
            this.p = cue.A;
            this.q = cue.B;
        }
        
        Builder(final Cue cue, final Cue$a object) {
            this(cue);
        }
        
        public Cue a() {
            return new Cue(this.a, this.c, this.d, this.b, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, null);
        }
        
        public Builder b() {
            this.n = false;
            return this;
        }
        
        public int c() {
            return this.g;
        }
        
        public int d() {
            return this.i;
        }
        
        public CharSequence e() {
            return this.a;
        }
        
        public Builder f(final Bitmap b) {
            this.b = b;
            return this;
        }
        
        public Builder g(final float m) {
            this.m = m;
            return this;
        }
        
        public Builder h(final float e, final int f) {
            this.e = e;
            this.f = f;
            return this;
        }
        
        public Builder i(final int g) {
            this.g = g;
            return this;
        }
        
        public Builder j(final Layout$Alignment d) {
            this.d = d;
            return this;
        }
        
        public Builder k(final float h) {
            this.h = h;
            return this;
        }
        
        public Builder l(final int i) {
            this.i = i;
            return this;
        }
        
        public Builder m(final float q) {
            this.q = q;
            return this;
        }
        
        public Builder n(final float l) {
            this.l = l;
            return this;
        }
        
        public Builder o(final CharSequence a) {
            this.a = a;
            return this;
        }
        
        public Builder p(final Layout$Alignment c) {
            this.c = c;
            return this;
        }
        
        public Builder q(final float k, final int j) {
            this.k = k;
            this.j = j;
            return this;
        }
        
        public Builder r(final int p) {
            this.p = p;
            return this;
        }
        
        public Builder s(final int o) {
            this.o = o;
            this.n = true;
            return this;
        }
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE })
    public @interface LineType {
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE })
    public @interface TextSizeType {
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE })
    public @interface VerticalType {
    }
}
