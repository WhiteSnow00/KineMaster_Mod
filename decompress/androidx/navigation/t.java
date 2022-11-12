// 
// Decompiled by Procyon v0.6.0
// 

package androidx.navigation;

import java.io.Serializable;
import android.os.Parcelable;
import kotlin.text.a;
import kotlin.text.l;
import java.util.Objects;
import kotlin.jvm.internal.o;
import android.os.Bundle;
import kotlin.jvm.internal.i;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0011\b&\u0018\u0000 \u0014*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0006\u001d\u001e\u001f !\"B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0012¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u0000H&¢\u0006\u0004\b\t\u0010\nJ\"\u0010\u000b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H¦\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u0005H&¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0005H\u0016R\u001a\u0010\u0016\u001a\u00020\u00128\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u001a\u001a\u00020\u00058\u0016X\u0096D¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019¨\u0006#" }, d2 = { "Landroidx/navigation/t;", "T", "", "Landroid/os/Bundle;", "bundle", "", "key", "value", "Lka/r;", "f", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/Object;)V", "a", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Object;", "e", "(Ljava/lang/String;)Ljava/lang/Object;", "d", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;", "toString", "", "Z", "c", "()Z", "isNullableAllowed", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "name", "<init>", "(Z)V", "l", "m", "n", "o", "p", "q", "navigation-common_release" }, k = 1, mv = { 1, 6, 0 })
public abstract class t<T>
{
    public static final l c;
    public static final t<Integer> d;
    public static final t<Integer> e;
    public static final t<int[]> f;
    public static final t<Long> g;
    public static final t<long[]> h;
    public static final t<Float> i;
    public static final t<float[]> j;
    public static final t<Boolean> k;
    public static final t<boolean[]> l;
    public static final t<String> m;
    public static final t<String[]> n;
    private final boolean a;
    private final String b;
    
    static {
        c = new l(null);
        d = new t<Integer>() {
            @Override
            public /* bridge */ Object a(final Bundle bundle, final String s) {
                return this.g(bundle, s);
            }
            
            @Override
            public String b() {
                return "integer";
            }
            
            @Override
            public /* bridge */ Object e(final String s) {
                return this.h(s);
            }
            
            @Override
            public /* bridge */ void f(final Bundle bundle, final String s, final Object o) {
                this.i(bundle, s, ((Number)o).intValue());
            }
            
            public Integer g(final Bundle bundle, final String s) {
                kotlin.jvm.internal.o.g((Object)bundle, "bundle");
                kotlin.jvm.internal.o.g((Object)s, "key");
                final Object value = bundle.get(s);
                Objects.requireNonNull(value, "null cannot be cast to non-null type kotlin.Int");
                return (int)value;
            }
            
            public Integer h(String substring) {
                kotlin.jvm.internal.o.g((Object)substring, "value");
                int n;
                if (kotlin.text.l.H(substring, "0x", false, 2, (Object)null)) {
                    substring = substring.substring(2);
                    kotlin.jvm.internal.o.f((Object)substring, "this as java.lang.String).substring(startIndex)");
                    n = Integer.parseInt(substring, kotlin.text.a.a(16));
                }
                else {
                    n = Integer.parseInt(substring);
                }
                return n;
            }
            
            public void i(final Bundle bundle, final String s, final int n) {
                kotlin.jvm.internal.o.g((Object)bundle, "bundle");
                kotlin.jvm.internal.o.g((Object)s, "key");
                bundle.putInt(s, n);
            }
        };
        e = new t<Integer>() {
            @Override
            public /* bridge */ Object a(final Bundle bundle, final String s) {
                return this.g(bundle, s);
            }
            
            @Override
            public String b() {
                return "reference";
            }
            
            @Override
            public /* bridge */ Object e(final String s) {
                return this.h(s);
            }
            
            @Override
            public /* bridge */ void f(final Bundle bundle, final String s, final Object o) {
                this.i(bundle, s, ((Number)o).intValue());
            }
            
            public Integer g(final Bundle bundle, final String s) {
                kotlin.jvm.internal.o.g((Object)bundle, "bundle");
                kotlin.jvm.internal.o.g((Object)s, "key");
                final Object value = bundle.get(s);
                Objects.requireNonNull(value, "null cannot be cast to non-null type kotlin.Int");
                return (int)value;
            }
            
            public Integer h(String substring) {
                kotlin.jvm.internal.o.g((Object)substring, "value");
                int n;
                if (kotlin.text.l.H(substring, "0x", false, 2, (Object)null)) {
                    substring = substring.substring(2);
                    kotlin.jvm.internal.o.f((Object)substring, "this as java.lang.String).substring(startIndex)");
                    n = Integer.parseInt(substring, kotlin.text.a.a(16));
                }
                else {
                    n = Integer.parseInt(substring);
                }
                return n;
            }
            
            public void i(final Bundle bundle, final String s, final int n) {
                kotlin.jvm.internal.o.g((Object)bundle, "bundle");
                kotlin.jvm.internal.o.g((Object)s, "key");
                bundle.putInt(s, n);
            }
        };
        f = new t<int[]>() {
            @Override
            public /* bridge */ Object a(final Bundle bundle, final String s) {
                return this.g(bundle, s);
            }
            
            @Override
            public String b() {
                return "integer[]";
            }
            
            @Override
            public /* bridge */ Object e(final String s) {
                return this.h(s);
            }
            
            @Override
            public /* bridge */ void f(final Bundle bundle, final String s, final Object o) {
                this.i(bundle, s, (int[])o);
            }
            
            public int[] g(final Bundle bundle, final String s) {
                kotlin.jvm.internal.o.g((Object)bundle, "bundle");
                kotlin.jvm.internal.o.g((Object)s, "key");
                return (int[])bundle.get(s);
            }
            
            public int[] h(final String s) {
                kotlin.jvm.internal.o.g((Object)s, "value");
                throw new UnsupportedOperationException("Arrays don't support default values.");
            }
            
            public void i(final Bundle bundle, final String s, final int[] array) {
                kotlin.jvm.internal.o.g((Object)bundle, "bundle");
                kotlin.jvm.internal.o.g((Object)s, "key");
                bundle.putIntArray(s, array);
            }
        };
        g = new t<Long>() {
            @Override
            public /* bridge */ Object a(final Bundle bundle, final String s) {
                return this.g(bundle, s);
            }
            
            @Override
            public String b() {
                return "long";
            }
            
            @Override
            public /* bridge */ Object e(final String s) {
                return this.h(s);
            }
            
            @Override
            public /* bridge */ void f(final Bundle bundle, final String s, final Object o) {
                this.i(bundle, s, ((Number)o).longValue());
            }
            
            public Long g(final Bundle bundle, final String s) {
                kotlin.jvm.internal.o.g((Object)bundle, "bundle");
                kotlin.jvm.internal.o.g((Object)s, "key");
                final Object value = bundle.get(s);
                Objects.requireNonNull(value, "null cannot be cast to non-null type kotlin.Long");
                return (long)value;
            }
            
            public Long h(String substring) {
                kotlin.jvm.internal.o.g((Object)substring, "value");
                String substring2;
                if (kotlin.text.l.s(substring, "L", false, 2, (Object)null)) {
                    substring2 = substring.substring(0, substring.length() - 1);
                    kotlin.jvm.internal.o.f((Object)substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                }
                else {
                    substring2 = substring;
                }
                long n;
                if (kotlin.text.l.H(substring, "0x", false, 2, (Object)null)) {
                    substring = substring2.substring(2);
                    kotlin.jvm.internal.o.f((Object)substring, "this as java.lang.String).substring(startIndex)");
                    n = Long.parseLong(substring, kotlin.text.a.a(16));
                }
                else {
                    n = Long.parseLong(substring2);
                }
                return n;
            }
            
            public void i(final Bundle bundle, final String s, final long n) {
                kotlin.jvm.internal.o.g((Object)bundle, "bundle");
                kotlin.jvm.internal.o.g((Object)s, "key");
                bundle.putLong(s, n);
            }
        };
        h = new t<long[]>() {
            @Override
            public /* bridge */ Object a(final Bundle bundle, final String s) {
                return this.g(bundle, s);
            }
            
            @Override
            public String b() {
                return "long[]";
            }
            
            @Override
            public /* bridge */ Object e(final String s) {
                return this.h(s);
            }
            
            @Override
            public /* bridge */ void f(final Bundle bundle, final String s, final Object o) {
                this.i(bundle, s, (long[])o);
            }
            
            public long[] g(final Bundle bundle, final String s) {
                kotlin.jvm.internal.o.g((Object)bundle, "bundle");
                kotlin.jvm.internal.o.g((Object)s, "key");
                return (long[])bundle.get(s);
            }
            
            public long[] h(final String s) {
                kotlin.jvm.internal.o.g((Object)s, "value");
                throw new UnsupportedOperationException("Arrays don't support default values.");
            }
            
            public void i(final Bundle bundle, final String s, final long[] array) {
                kotlin.jvm.internal.o.g((Object)bundle, "bundle");
                kotlin.jvm.internal.o.g((Object)s, "key");
                bundle.putLongArray(s, array);
            }
        };
        i = new t<Float>() {
            @Override
            public /* bridge */ Object a(final Bundle bundle, final String s) {
                return this.g(bundle, s);
            }
            
            @Override
            public String b() {
                return "float";
            }
            
            @Override
            public /* bridge */ Object e(final String s) {
                return this.h(s);
            }
            
            @Override
            public /* bridge */ void f(final Bundle bundle, final String s, final Object o) {
                this.i(bundle, s, ((Number)o).floatValue());
            }
            
            public Float g(final Bundle bundle, final String s) {
                kotlin.jvm.internal.o.g((Object)bundle, "bundle");
                kotlin.jvm.internal.o.g((Object)s, "key");
                final Object value = bundle.get(s);
                Objects.requireNonNull(value, "null cannot be cast to non-null type kotlin.Float");
                return (float)value;
            }
            
            public Float h(final String s) {
                kotlin.jvm.internal.o.g((Object)s, "value");
                return Float.parseFloat(s);
            }
            
            public void i(final Bundle bundle, final String s, final float n) {
                kotlin.jvm.internal.o.g((Object)bundle, "bundle");
                kotlin.jvm.internal.o.g((Object)s, "key");
                bundle.putFloat(s, n);
            }
        };
        j = new t<float[]>() {
            @Override
            public /* bridge */ Object a(final Bundle bundle, final String s) {
                return this.g(bundle, s);
            }
            
            @Override
            public String b() {
                return "float[]";
            }
            
            @Override
            public /* bridge */ Object e(final String s) {
                return this.h(s);
            }
            
            @Override
            public /* bridge */ void f(final Bundle bundle, final String s, final Object o) {
                this.i(bundle, s, (float[])o);
            }
            
            public float[] g(final Bundle bundle, final String s) {
                kotlin.jvm.internal.o.g((Object)bundle, "bundle");
                kotlin.jvm.internal.o.g((Object)s, "key");
                return (float[])bundle.get(s);
            }
            
            public float[] h(final String s) {
                kotlin.jvm.internal.o.g((Object)s, "value");
                throw new UnsupportedOperationException("Arrays don't support default values.");
            }
            
            public void i(final Bundle bundle, final String s, final float[] array) {
                kotlin.jvm.internal.o.g((Object)bundle, "bundle");
                kotlin.jvm.internal.o.g((Object)s, "key");
                bundle.putFloatArray(s, array);
            }
        };
        k = new t<Boolean>() {
            @Override
            public /* bridge */ Object a(final Bundle bundle, final String s) {
                return this.g(bundle, s);
            }
            
            @Override
            public String b() {
                return "boolean";
            }
            
            @Override
            public /* bridge */ Object e(final String s) {
                return this.h(s);
            }
            
            @Override
            public /* bridge */ void f(final Bundle bundle, final String s, final Object o) {
                this.i(bundle, s, (boolean)o);
            }
            
            public Boolean g(final Bundle bundle, final String s) {
                kotlin.jvm.internal.o.g((Object)bundle, "bundle");
                kotlin.jvm.internal.o.g((Object)s, "key");
                return (Boolean)bundle.get(s);
            }
            
            public Boolean h(final String s) {
                kotlin.jvm.internal.o.g((Object)s, "value");
                boolean b;
                if (kotlin.jvm.internal.o.b((Object)s, (Object)"true")) {
                    b = true;
                }
                else {
                    if (!kotlin.jvm.internal.o.b((Object)s, (Object)"false")) {
                        throw new IllegalArgumentException("A boolean NavType only accepts \"true\" or \"false\" values.");
                    }
                    b = false;
                }
                return b;
            }
            
            public void i(final Bundle bundle, final String s, final boolean b) {
                kotlin.jvm.internal.o.g((Object)bundle, "bundle");
                kotlin.jvm.internal.o.g((Object)s, "key");
                bundle.putBoolean(s, b);
            }
        };
        l = new t<boolean[]>() {
            @Override
            public /* bridge */ Object a(final Bundle bundle, final String s) {
                return this.g(bundle, s);
            }
            
            @Override
            public String b() {
                return "boolean[]";
            }
            
            @Override
            public /* bridge */ Object e(final String s) {
                return this.h(s);
            }
            
            @Override
            public /* bridge */ void f(final Bundle bundle, final String s, final Object o) {
                this.i(bundle, s, (boolean[])o);
            }
            
            public boolean[] g(final Bundle bundle, final String s) {
                kotlin.jvm.internal.o.g((Object)bundle, "bundle");
                kotlin.jvm.internal.o.g((Object)s, "key");
                return (boolean[])bundle.get(s);
            }
            
            public boolean[] h(final String s) {
                kotlin.jvm.internal.o.g((Object)s, "value");
                throw new UnsupportedOperationException("Arrays don't support default values.");
            }
            
            public void i(final Bundle bundle, final String s, final boolean[] array) {
                kotlin.jvm.internal.o.g((Object)bundle, "bundle");
                kotlin.jvm.internal.o.g((Object)s, "key");
                bundle.putBooleanArray(s, array);
            }
        };
        m = new t<String>() {
            @Override
            public /* bridge */ Object a(final Bundle bundle, final String s) {
                return this.g(bundle, s);
            }
            
            @Override
            public String b() {
                return "string";
            }
            
            @Override
            public /* bridge */ Object e(final String s) {
                return this.h(s);
            }
            
            @Override
            public /* bridge */ void f(final Bundle bundle, final String s, final Object o) {
                this.i(bundle, s, (String)o);
            }
            
            public String g(final Bundle bundle, final String s) {
                kotlin.jvm.internal.o.g((Object)bundle, "bundle");
                kotlin.jvm.internal.o.g((Object)s, "key");
                return (String)bundle.get(s);
            }
            
            public String h(final String s) {
                kotlin.jvm.internal.o.g((Object)s, "value");
                return s;
            }
            
            public void i(final Bundle bundle, final String s, final String s2) {
                kotlin.jvm.internal.o.g((Object)bundle, "bundle");
                kotlin.jvm.internal.o.g((Object)s, "key");
                bundle.putString(s, s2);
            }
        };
        n = new t<String[]>() {
            @Override
            public /* bridge */ Object a(final Bundle bundle, final String s) {
                return this.g(bundle, s);
            }
            
            @Override
            public String b() {
                return "string[]";
            }
            
            @Override
            public /* bridge */ Object e(final String s) {
                return this.h(s);
            }
            
            @Override
            public /* bridge */ void f(final Bundle bundle, final String s, final Object o) {
                this.i(bundle, s, (String[])o);
            }
            
            public String[] g(final Bundle bundle, final String s) {
                kotlin.jvm.internal.o.g((Object)bundle, "bundle");
                kotlin.jvm.internal.o.g((Object)s, "key");
                return (String[])bundle.get(s);
            }
            
            public String[] h(final String s) {
                kotlin.jvm.internal.o.g((Object)s, "value");
                throw new UnsupportedOperationException("Arrays don't support default values.");
            }
            
            public void i(final Bundle bundle, final String s, final String[] array) {
                kotlin.jvm.internal.o.g((Object)bundle, "bundle");
                kotlin.jvm.internal.o.g((Object)s, "key");
                bundle.putStringArray(s, array);
            }
        };
    }
    
    public t(final boolean a) {
        this.a = a;
        this.b = "nav_type";
    }
    
    public abstract T a(final Bundle p0, final String p1);
    
    public abstract String b();
    
    public boolean c() {
        return this.a;
    }
    
    public final T d(final Bundle bundle, final String s, final String s2) {
        kotlin.jvm.internal.o.g((Object)bundle, "bundle");
        kotlin.jvm.internal.o.g((Object)s, "key");
        kotlin.jvm.internal.o.g((Object)s2, "value");
        final T e = this.e(s2);
        this.f(bundle, s, e);
        return e;
    }
    
    public abstract T e(final String p0);
    
    public abstract void f(final Bundle p0, final String p1, final T p2);
    
    @Override
    public String toString() {
        return this.b();
    }
    
    @Metadata(bv = {}, d1 = { "\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0018\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001f\u0010 J \u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0017J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0007J\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0007R\u001c\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u001c\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\fR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\fR\u001c\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\fR\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\fR\u001c\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\fR\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\fR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00150\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\fR\"\u0010\u001d\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001c0\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\fR\u001c\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\f¨\u0006!" }, d2 = { "Landroidx/navigation/t$l;", "", "", "type", "packageName", "Landroidx/navigation/t;", "a", "value", "b", "c", "", "BoolArrayType", "Landroidx/navigation/t;", "", "BoolType", "", "FloatArrayType", "", "FloatType", "", "IntArrayType", "", "IntType", "", "LongArrayType", "", "LongType", "ReferenceType", "", "StringArrayType", "StringType", "<init>", "()V", "navigation-common_release" }, k = 1, mv = { 1, 6, 0 })
    public static final class l
    {
        private l() {
        }
        
        public l(final i i) {
            this();
        }
        
        public t<?> a(final String s, String s2) {
            final t<Integer> d = t.d;
            if (kotlin.jvm.internal.o.b((Object)d.b(), (Object)s)) {
                return d;
            }
            final t<int[]> f = t.f;
            if (kotlin.jvm.internal.o.b((Object)f.b(), (Object)s)) {
                return f;
            }
            final t<Long> g = t.g;
            if (kotlin.jvm.internal.o.b((Object)g.b(), (Object)s)) {
                return g;
            }
            final t<long[]> h = t.h;
            if (kotlin.jvm.internal.o.b((Object)h.b(), (Object)s)) {
                return h;
            }
            final t<Boolean> k = t.k;
            if (kotlin.jvm.internal.o.b((Object)k.b(), (Object)s)) {
                return k;
            }
            final t<boolean[]> l = t.l;
            if (kotlin.jvm.internal.o.b((Object)l.b(), (Object)s)) {
                return l;
            }
            final t<String> m = t.m;
            if (kotlin.jvm.internal.o.b((Object)m.b(), (Object)s)) {
                return m;
            }
            final t<String[]> n = t.n;
            if (kotlin.jvm.internal.o.b((Object)n.b(), (Object)s)) {
                return n;
            }
            final t<Float> i = t.i;
            if (kotlin.jvm.internal.o.b((Object)i.b(), (Object)s)) {
                return i;
            }
            final t<float[]> j = t.j;
            if (kotlin.jvm.internal.o.b((Object)j.b(), (Object)s)) {
                return j;
            }
            final t<Integer> e = t.e;
            if (kotlin.jvm.internal.o.b((Object)e.b(), (Object)s)) {
                return e;
            }
            if (s != null && s.length() != 0) {
                try {
                    if (kotlin.text.l.H(s, ".", false, 2, (Object)null) && s2 != null) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append(s2);
                        sb.append(s);
                        s2 = sb.toString();
                    }
                    else {
                        s2 = s;
                    }
                    if (kotlin.text.l.s(s, "[]", false, 2, (Object)null)) {
                        s2 = s2.substring(0, s2.length() - 2);
                        kotlin.jvm.internal.o.f((Object)s2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                        final Class<?> forName = Class.forName(s2);
                        if (Parcelable.class.isAssignableFrom(forName)) {
                            return new n<Object>((Class<Parcelable>)forName);
                        }
                        if (Serializable.class.isAssignableFrom(forName)) {
                            return new p<Object>(forName);
                        }
                    }
                    else {
                        final Class<?> forName2 = Class.forName(s2);
                        if (Parcelable.class.isAssignableFrom(forName2)) {
                            return new o<Object>((Class<Object>)forName2);
                        }
                        if (Enum.class.isAssignableFrom(forName2)) {
                            return new m<Object>(forName2);
                        }
                        if (Serializable.class.isAssignableFrom(forName2)) {
                            return new q<Object>(forName2);
                        }
                    }
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append(s2);
                    sb2.append(" is not Serializable or Parcelable.");
                    throw new IllegalArgumentException(sb2.toString());
                }
                catch (final ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
            return m;
        }
        
        public final t<Object> b(final String s) {
            kotlin.jvm.internal.o.g((Object)s, "value");
            try {
                final t<Integer> d = t.d;
                d.e(s);
                return (t<Object>)d;
            }
            catch (final IllegalArgumentException ex) {
                try {
                    final t<Long> g = t.g;
                    g.e(s);
                    return (t<Object>)g;
                }
                catch (final IllegalArgumentException ex2) {
                    try {
                        final t<Float> i = t.i;
                        i.e(s);
                        return (t<Object>)i;
                    }
                    catch (final IllegalArgumentException ex3) {
                        try {
                            final t<Boolean> k = t.k;
                            k.e(s);
                            return (t<Object>)k;
                        }
                        catch (final IllegalArgumentException ex4) {
                            return (t<Object>)t.m;
                        }
                    }
                }
            }
        }
        
        public final t<Object> c(Object o) {
            if (o instanceof Integer) {
                o = t.d;
            }
            else if (o instanceof int[]) {
                o = t.f;
            }
            else if (o instanceof Long) {
                o = t.g;
            }
            else if (o instanceof long[]) {
                o = t.h;
            }
            else if (o instanceof Float) {
                o = t.i;
            }
            else if (o instanceof float[]) {
                o = t.j;
            }
            else if (o instanceof Boolean) {
                o = t.k;
            }
            else if (o instanceof boolean[]) {
                o = t.l;
            }
            else if (!(o instanceof String) && o != null) {
                if (o instanceof Object[] && ((Object[])o) instanceof String[]) {
                    o = t.n;
                }
                else {
                    if (o.getClass().isArray()) {
                        final Class<?> componentType = o.getClass().getComponentType();
                        o.d((Object)componentType);
                        if (Parcelable.class.isAssignableFrom(componentType)) {
                            final Class<?> componentType2 = o.getClass().getComponentType();
                            Objects.requireNonNull(componentType2, "null cannot be cast to non-null type java.lang.Class<android.os.Parcelable>");
                            o = new n((Class<Parcelable>)componentType2);
                            return (t<Object>)o;
                        }
                    }
                    if (o.getClass().isArray()) {
                        final Class<?> componentType3 = o.getClass().getComponentType();
                        o.d((Object)componentType3);
                        if (Serializable.class.isAssignableFrom(componentType3)) {
                            final Class<?> componentType4 = o.getClass().getComponentType();
                            Objects.requireNonNull(componentType4, "null cannot be cast to non-null type java.lang.Class<java.io.Serializable>");
                            o = new p((Class<Serializable>)componentType4);
                            return (t<Object>)o;
                        }
                    }
                    if (o instanceof Parcelable) {
                        o = new o((Class<Object>)o.getClass());
                    }
                    else if (o instanceof Enum) {
                        o = new m((Class<Enum>)o.getClass());
                    }
                    else {
                        if (!(o instanceof Serializable)) {
                            final StringBuilder sb = new StringBuilder();
                            sb.append("Object of type ");
                            sb.append(o.getClass().getName());
                            sb.append(" is not supported for navigation arguments.");
                            throw new IllegalArgumentException(sb.toString());
                        }
                        o = new q((Class<Serializable>)o.getClass());
                    }
                }
            }
            else {
                o = t.m;
            }
            return (t<Object>)o;
        }
    }
    
    @Metadata(bv = {}, d1 = { "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000*\f\b\u0001\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\b\u0012\u0004\u0012\u00028\u00010\u0003B\u0015\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\b¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0006\u001a\u00028\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0011" }, d2 = { "Landroidx/navigation/t$m;", "", "D", "Landroidx/navigation/t$q;", "", "value", "j", "(Ljava/lang/String;)Ljava/lang/Enum;", "Ljava/lang/Class;", "p", "Ljava/lang/Class;", "type", "b", "()Ljava/lang/String;", "name", "<init>", "(Ljava/lang/Class;)V", "navigation-common_release" }, k = 1, mv = { 1, 6, 0 })
    public static final class m<D extends Enum<?>> extends q<D>
    {
        private final Class<D> p;
        
        public m(final Class<D> p) {
            kotlin.jvm.internal.o.g((Object)p, "type");
            super(false, p);
            if (p.isEnum()) {
                this.p = p;
                return;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append(p);
            sb.append(" is not an Enum type.");
            throw new IllegalArgumentException(sb.toString().toString());
        }
        
        @Override
        public String b() {
            final String name = this.p.getName();
            o.f((Object)name, "type.name");
            return name;
        }
        
        @Override
        public /* bridge */ Object e(final String s) {
            return this.j(s);
        }
        
        @Override
        public /* bridge */ Serializable h(final String s) {
            return this.j(s);
        }
        
        public D j(final String s) {
            o.g((Object)s, "value");
            final D[] enumConstants = this.p.getEnumConstants();
            o.f((Object)enumConstants, "type.enumConstants");
            final int length = enumConstants.length;
            int i = 0;
            while (true) {
                while (i < length) {
                    final Enum<?> enum1 = enumConstants[i];
                    if (kotlin.text.l.t(((D)enum1).name(), s, true)) {
                        final Enum<?> enum2 = enum1;
                        if (enum2 != null) {
                            return (D)enum2;
                        }
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Enum value ");
                        sb.append(s);
                        sb.append(" not found for type ");
                        sb.append(this.p.getName());
                        sb.append('.');
                        throw new IllegalArgumentException(sb.toString());
                    }
                    else {
                        ++i;
                    }
                }
                final Enum<?> enum1 = null;
                continue;
            }
        }
    }
    
    @Metadata(bv = {}, d1 = { "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000*\b\b\u0001\u0010\u0002*\u00020\u00012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00040\u0003B\u0015\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00010\u0017¢\u0006\u0004\b\u001f\u0010 J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ(\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0016R \u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006!" }, d2 = { "Landroidx/navigation/t$n;", "Landroid/os/Parcelable;", "D", "Landroidx/navigation/t;", "", "Landroid/os/Bundle;", "bundle", "", "key", "value", "Lka/r;", "i", "(Landroid/os/Bundle;Ljava/lang/String;[Landroid/os/Parcelable;)V", "g", "(Landroid/os/Bundle;Ljava/lang/String;)[Landroid/os/Parcelable;", "h", "(Ljava/lang/String;)[Landroid/os/Parcelable;", "", "other", "", "equals", "", "hashCode", "Ljava/lang/Class;", "o", "Ljava/lang/Class;", "arrayType", "b", "()Ljava/lang/String;", "name", "type", "<init>", "(Ljava/lang/Class;)V", "navigation-common_release" }, k = 1, mv = { 1, 6, 0 })
    public static final class n<D extends Parcelable> extends t<D[]>
    {
        private final Class<D[]> o;
        
        public n(final Class<D> clazz) {
            kotlin.jvm.internal.o.g((Object)clazz, "type");
            super(true);
            if (Parcelable.class.isAssignableFrom(clazz)) {
                try {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("[L");
                    sb.append(clazz.getName());
                    sb.append(';');
                    this.o = (Class<D[]>)Class.forName(sb.toString());
                    return;
                }
                catch (final ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(clazz);
            sb2.append(" does not implement Parcelable.");
            throw new IllegalArgumentException(sb2.toString().toString());
        }
        
        @Override
        public /* bridge */ Object a(final Bundle bundle, final String s) {
            return this.g(bundle, s);
        }
        
        @Override
        public String b() {
            final String name = this.o.getName();
            kotlin.jvm.internal.o.f((Object)name, "arrayType.name");
            return name;
        }
        
        @Override
        public /* bridge */ Object e(final String s) {
            return this.h(s);
        }
        
        @Override
        public boolean equals(final Object o) {
            return this == o || (o != null && o.b((Object)n.class, (Object)o.getClass()) && o.b((Object)this.o, (Object)((n)o).o));
        }
        
        @Override
        public /* bridge */ void f(final Bundle bundle, final String s, final Object o) {
            this.i(bundle, s, (Parcelable[])o);
        }
        
        public D[] g(final Bundle bundle, final String s) {
            kotlin.jvm.internal.o.g((Object)bundle, "bundle");
            kotlin.jvm.internal.o.g((Object)s, "key");
            return (D[])bundle.get(s);
        }
        
        public D[] h(final String s) {
            kotlin.jvm.internal.o.g((Object)s, "value");
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }
        
        @Override
        public int hashCode() {
            return this.o.hashCode();
        }
        
        public void i(final Bundle bundle, final String s, final D[] array) {
            kotlin.jvm.internal.o.g((Object)bundle, "bundle");
            kotlin.jvm.internal.o.g((Object)s, "key");
            this.o.cast(array);
            bundle.putParcelableArray(s, (Parcelable[])array);
        }
    }
    
    @Metadata(bv = {}, d1 = { "\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u0015\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u0015¢\u0006\u0004\b\u001c\u0010\u001dJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\t\u0010\nJ\"\u0010\u000b\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00028\u00012\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0016R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001e" }, d2 = { "Landroidx/navigation/t$o;", "D", "Landroidx/navigation/t;", "Landroid/os/Bundle;", "bundle", "", "key", "value", "Lka/r;", "f", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/Object;)V", "a", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Object;", "e", "(Ljava/lang/String;)Ljava/lang/Object;", "", "other", "", "equals", "", "hashCode", "Ljava/lang/Class;", "o", "Ljava/lang/Class;", "type", "b", "()Ljava/lang/String;", "name", "<init>", "(Ljava/lang/Class;)V", "navigation-common_release" }, k = 1, mv = { 1, 6, 0 })
    public static final class o<D> extends t<D>
    {
        private final Class<D> o;
        
        public o(final Class<D> o) {
            kotlin.jvm.internal.o.g((Object)o, "type");
            final boolean b = true;
            super(true);
            int n = b ? 1 : 0;
            if (!Parcelable.class.isAssignableFrom(o)) {
                if (Serializable.class.isAssignableFrom(o)) {
                    n = (b ? 1 : 0);
                }
                else {
                    n = 0;
                }
            }
            if (n != 0) {
                this.o = o;
                return;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append(o);
            sb.append(" does not implement Parcelable or Serializable.");
            throw new IllegalArgumentException(sb.toString().toString());
        }
        
        @Override
        public D a(final Bundle bundle, final String s) {
            kotlin.jvm.internal.o.g((Object)bundle, "bundle");
            kotlin.jvm.internal.o.g((Object)s, "key");
            return (D)bundle.get(s);
        }
        
        @Override
        public String b() {
            final String name = this.o.getName();
            kotlin.jvm.internal.o.f((Object)name, "type.name");
            return name;
        }
        
        @Override
        public D e(final String s) {
            kotlin.jvm.internal.o.g((Object)s, "value");
            throw new UnsupportedOperationException("Parcelables don't support default values.");
        }
        
        @Override
        public boolean equals(final Object o) {
            return this == o || (o != null && o.b((Object)o.class, (Object)o.getClass()) && o.b((Object)this.o, (Object)((o)o).o));
        }
        
        @Override
        public void f(final Bundle bundle, final String s, final D n) {
            kotlin.jvm.internal.o.g((Object)bundle, "bundle");
            kotlin.jvm.internal.o.g((Object)s, "key");
            this.o.cast(n);
            if (n != null && !(n instanceof Parcelable)) {
                if (n instanceof Serializable) {
                    bundle.putSerializable(s, (Serializable)n);
                }
            }
            else {
                bundle.putParcelable(s, (Parcelable)n);
            }
        }
        
        @Override
        public int hashCode() {
            return this.o.hashCode();
        }
    }
    
    @Metadata(bv = {}, d1 = { "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000*\b\b\u0001\u0010\u0002*\u00020\u00012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00040\u0003B\u0015\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00010\u0017¢\u0006\u0004\b\u001f\u0010 J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ(\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0016R \u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006!" }, d2 = { "Landroidx/navigation/t$p;", "Ljava/io/Serializable;", "D", "Landroidx/navigation/t;", "", "Landroid/os/Bundle;", "bundle", "", "key", "value", "Lka/r;", "i", "(Landroid/os/Bundle;Ljava/lang/String;[Ljava/io/Serializable;)V", "g", "(Landroid/os/Bundle;Ljava/lang/String;)[Ljava/io/Serializable;", "h", "(Ljava/lang/String;)[Ljava/io/Serializable;", "", "other", "", "equals", "", "hashCode", "Ljava/lang/Class;", "o", "Ljava/lang/Class;", "arrayType", "b", "()Ljava/lang/String;", "name", "type", "<init>", "(Ljava/lang/Class;)V", "navigation-common_release" }, k = 1, mv = { 1, 6, 0 })
    public static final class p<D extends Serializable> extends t<D[]>
    {
        private final Class<D[]> o;
        
        public p(final Class<D> clazz) {
            kotlin.jvm.internal.o.g((Object)clazz, "type");
            super(true);
            if (Serializable.class.isAssignableFrom(clazz)) {
                try {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("[L");
                    sb.append(clazz.getName());
                    sb.append(';');
                    this.o = (Class<D[]>)Class.forName(sb.toString());
                    return;
                }
                catch (final ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(clazz);
            sb2.append(" does not implement Serializable.");
            throw new IllegalArgumentException(sb2.toString().toString());
        }
        
        @Override
        public /* bridge */ Object a(final Bundle bundle, final String s) {
            return this.g(bundle, s);
        }
        
        @Override
        public String b() {
            final String name = this.o.getName();
            kotlin.jvm.internal.o.f((Object)name, "arrayType.name");
            return name;
        }
        
        @Override
        public /* bridge */ Object e(final String s) {
            return this.h(s);
        }
        
        @Override
        public boolean equals(final Object o) {
            return this == o || (o != null && o.b((Object)p.class, (Object)o.getClass()) && o.b((Object)this.o, (Object)((p)o).o));
        }
        
        @Override
        public /* bridge */ void f(final Bundle bundle, final String s, final Object o) {
            this.i(bundle, s, (Serializable[])o);
        }
        
        public D[] g(final Bundle bundle, final String s) {
            kotlin.jvm.internal.o.g((Object)bundle, "bundle");
            kotlin.jvm.internal.o.g((Object)s, "key");
            return (D[])bundle.get(s);
        }
        
        public D[] h(final String s) {
            kotlin.jvm.internal.o.g((Object)s, "value");
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }
        
        @Override
        public int hashCode() {
            return this.o.hashCode();
        }
        
        public void i(final Bundle bundle, final String s, final D[] array) {
            kotlin.jvm.internal.o.g((Object)bundle, "bundle");
            kotlin.jvm.internal.o.g((Object)s, "key");
            this.o.cast(array);
            bundle.putSerializable(s, (Serializable)array);
        }
    }
    
    @Metadata(bv = {}, d1 = { "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u0000*\b\b\u0001\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00010\u0003B\u0017\b\u0016\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u0016¢\u0006\u0004\b\u001d\u0010\u001eB\u001f\b\u0010\u0012\u0006\u0010\u001f\u001a\u00020\u0012\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u0016¢\u0006\u0004\b\u001d\u0010 J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\"\u0010\f\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00028\u00012\u0006\u0010\b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0016R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006!" }, d2 = { "Landroidx/navigation/t$q;", "Ljava/io/Serializable;", "D", "Landroidx/navigation/t;", "Landroid/os/Bundle;", "bundle", "", "key", "value", "Lka/r;", "i", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/io/Serializable;)V", "g", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/io/Serializable;", "h", "(Ljava/lang/String;)Ljava/io/Serializable;", "", "other", "", "equals", "", "hashCode", "Ljava/lang/Class;", "o", "Ljava/lang/Class;", "type", "b", "()Ljava/lang/String;", "name", "<init>", "(Ljava/lang/Class;)V", "nullableAllowed", "(ZLjava/lang/Class;)V", "navigation-common_release" }, k = 1, mv = { 1, 6, 0 })
    public static class q<D extends Serializable> extends t<D>
    {
        private final Class<D> o;
        
        public q(final Class<D> o) {
            kotlin.jvm.internal.o.g((Object)o, "type");
            super(true);
            if (!Serializable.class.isAssignableFrom(o)) {
                final StringBuilder sb = new StringBuilder();
                sb.append(o);
                sb.append(" does not implement Serializable.");
                throw new IllegalArgumentException(sb.toString().toString());
            }
            if (true ^ o.isEnum()) {
                this.o = o;
                return;
            }
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(o);
            sb2.append(" is an Enum. You should use EnumType instead.");
            throw new IllegalArgumentException(sb2.toString().toString());
        }
        
        public q(final boolean b, final Class<D> o) {
            kotlin.jvm.internal.o.g((Object)o, "type");
            super(b);
            if (Serializable.class.isAssignableFrom(o)) {
                this.o = o;
                return;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append(o);
            sb.append(" does not implement Serializable.");
            throw new IllegalArgumentException(sb.toString().toString());
        }
        
        @Override
        public /* bridge */ Object a(final Bundle bundle, final String s) {
            return this.g(bundle, s);
        }
        
        @Override
        public String b() {
            final String name = this.o.getName();
            kotlin.jvm.internal.o.f((Object)name, "type.name");
            return name;
        }
        
        @Override
        public /* bridge */ Object e(final String s) {
            return this.h(s);
        }
        
        @Override
        public boolean equals(final Object o) {
            return this == o || (o instanceof q && o.b((Object)this.o, (Object)((q)o).o));
        }
        
        @Override
        public /* bridge */ void f(final Bundle bundle, final String s, final Object o) {
            this.i(bundle, s, (Serializable)o);
        }
        
        public D g(final Bundle bundle, final String s) {
            kotlin.jvm.internal.o.g((Object)bundle, "bundle");
            kotlin.jvm.internal.o.g((Object)s, "key");
            return (D)bundle.get(s);
        }
        
        public D h(final String s) {
            kotlin.jvm.internal.o.g((Object)s, "value");
            throw new UnsupportedOperationException("Serializables don't support default values.");
        }
        
        @Override
        public int hashCode() {
            return this.o.hashCode();
        }
        
        public void i(final Bundle bundle, final String s, final D n) {
            kotlin.jvm.internal.o.g((Object)bundle, "bundle");
            kotlin.jvm.internal.o.g((Object)s, "key");
            kotlin.jvm.internal.o.g((Object)n, "value");
            this.o.cast(n);
            bundle.putSerializable(s, (Serializable)n);
        }
    }
}
