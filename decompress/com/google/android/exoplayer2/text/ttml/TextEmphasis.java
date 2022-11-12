// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.text.ttml;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import com.google.common.collect.Sets$SetView;
import com.google.common.collect.Iterables;
import java.util.Set;
import com.google.common.collect.Sets;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.common.collect.ImmutableSet;
import java.util.regex.Pattern;

final class TextEmphasis
{
    private static final Pattern d;
    private static final ImmutableSet<String> e;
    private static final ImmutableSet<String> f;
    private static final ImmutableSet<String> g;
    private static final ImmutableSet<String> h;
    public final int a;
    public final int b;
    public final int c;
    
    static {
        d = Pattern.compile("\\s+");
        e = ImmutableSet.of((Object)"auto", (Object)"none");
        f = ImmutableSet.of((Object)"dot", (Object)"sesame", (Object)"circle");
        g = ImmutableSet.of((Object)"filled", (Object)"open");
        h = ImmutableSet.of((Object)"after", (Object)"before", (Object)"outside");
    }
    
    private TextEmphasis(final int a, final int b, final int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public static TextEmphasis a(String e) {
        if (e == null) {
            return null;
        }
        e = Ascii.e(e.trim());
        if (e.isEmpty()) {
            return null;
        }
        return b((ImmutableSet<String>)ImmutableSet.copyOf((Object[])TextUtils.split(e, TextEmphasis.d)));
    }
    
    private static TextEmphasis b(final ImmutableSet<String> set) {
        final String s = (String)Iterables.g((Iterable)Sets.e((Set)TextEmphasis.h, (Set)set), (Object)"outside");
        final int hashCode = s.hashCode();
        final int n = 2;
        int n2 = -1;
        final int n3 = 1;
        int n4 = 0;
        Label_0099: {
            if (hashCode != -1392885889) {
                if (hashCode != -1106037339) {
                    if (hashCode == 92734940) {
                        if (s.equals("after")) {
                            n4 = 0;
                            break Label_0099;
                        }
                    }
                }
                else if (s.equals("outside")) {
                    n4 = 1;
                    break Label_0099;
                }
            }
            else if (s.equals("before")) {
                n4 = 2;
                break Label_0099;
            }
            n4 = -1;
        }
        int n5;
        if (n4 != 0) {
            if (n4 != 1) {
                n5 = 1;
            }
            else {
                n5 = -2;
            }
        }
        else {
            n5 = 2;
        }
        final Sets$SetView e = Sets.e((Set)TextEmphasis.e, (Set)set);
        if (!((Set)e).isEmpty()) {
            final String s2 = (String)((Set)e).iterator().next();
            final int hashCode2 = s2.hashCode();
            int n6 = 0;
            Label_0207: {
                if (hashCode2 != 3005871) {
                    if (hashCode2 == 3387192) {
                        if (s2.equals("none")) {
                            n6 = 0;
                            break Label_0207;
                        }
                    }
                }
                else if (s2.equals("auto")) {
                    n6 = n3;
                    break Label_0207;
                }
                n6 = -1;
            }
            if (n6 == 0) {
                n2 = 0;
            }
            return new TextEmphasis(n2, 0, n5);
        }
        final Sets$SetView e2 = Sets.e((Set)TextEmphasis.g, (Set)set);
        final Sets$SetView e3 = Sets.e((Set)TextEmphasis.f, (Set)set);
        if (((Set)e2).isEmpty() && ((Set)e3).isEmpty()) {
            return new TextEmphasis(-1, 0, n5);
        }
        final String s3 = (String)Iterables.g((Iterable)e2, (Object)"filled");
        final int hashCode3 = s3.hashCode();
        int n7 = 0;
        Label_0339: {
            if (hashCode3 != -1274499742) {
                if (hashCode3 == 3417674) {
                    if (s3.equals("open")) {
                        n7 = 0;
                        break Label_0339;
                    }
                }
            }
            else if (s3.equals("filled")) {
                n7 = 1;
                break Label_0339;
            }
            n7 = -1;
        }
        int n8;
        if (n7 != 0) {
            n8 = 1;
        }
        else {
            n8 = 2;
        }
        final String s4 = (String)Iterables.g((Iterable)e3, (Object)"circle");
        final int hashCode4 = s4.hashCode();
        int n9;
        if (hashCode4 != -1360216880) {
            if (hashCode4 != -905816648) {
                if (hashCode4 != 99657) {
                    n9 = n2;
                }
                else {
                    n9 = n2;
                    if (s4.equals("dot")) {
                        n9 = 0;
                    }
                }
            }
            else {
                n9 = n2;
                if (s4.equals("sesame")) {
                    n9 = 1;
                }
            }
        }
        else {
            n9 = n2;
            if (s4.equals("circle")) {
                n9 = 2;
            }
        }
        int n10 = n;
        if (n9 != 0) {
            if (n9 != 1) {
                n10 = 1;
            }
            else {
                n10 = 3;
            }
        }
        return new TextEmphasis(n10, n8, n5);
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface Position {
    }
}
