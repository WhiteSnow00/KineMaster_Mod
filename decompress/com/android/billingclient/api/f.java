// 
// Decompiled by Procyon v0.6.0
// 

package com.android.billingclient.api;

import android.text.TextUtils;
import java.util.Objects;
import com.google.android.gms.internal.play_billing.zzm;
import java.util.Iterator;
import java.util.List;
import java.util.Collection;
import java.util.ArrayList;
import com.google.android.gms.internal.play_billing.zzu;

public class f
{
    private boolean a;
    private String b;
    private String c;
    private c d;
    private zzu e;
    private ArrayList f;
    private boolean g;
    
    f(final m0 m0) {
    }
    
    public static a a() {
        return new a(null);
    }
    
    static /* bridge */ void h(final f f, final boolean a) {
        f.a = a;
    }
    
    static /* bridge */ void i(final f f, final boolean g) {
        f.g = g;
    }
    
    static /* bridge */ void j(final f f, final String b) {
        f.b = b;
    }
    
    static /* bridge */ void k(final f f, final String c) {
        f.c = c;
    }
    
    static /* bridge */ void l(final f f, final zzu e) {
        f.e = e;
    }
    
    static /* bridge */ void m(final f f, final ArrayList f2) {
        f.f = f2;
    }
    
    static /* bridge */ void n(final f f, final c d) {
        f.d = d;
    }
    
    public final int b() {
        return this.d.b();
    }
    
    public final String c() {
        return this.b;
    }
    
    public final String d() {
        return this.c;
    }
    
    public final String e() {
        return this.d.c();
    }
    
    public final ArrayList f() {
        final ArrayList list = new ArrayList();
        list.addAll(this.f);
        return list;
    }
    
    public final List g() {
        return (List)this.e;
    }
    
    public final boolean o() {
        return this.g;
    }
    
    final boolean p() {
        return this.b != null || this.c != null || this.d.b() != 0 || this.a || this.g;
    }
    
    public static class a
    {
        private String a;
        private String b;
        private List c;
        private ArrayList d;
        private boolean e;
        private c.a f;
        
        a(final h0 h0) {
            final c.a a = c.a();
            c.a.b(a);
            this.f = a;
        }
        
        public f a() {
            final ArrayList d = this.d;
            final boolean b = true;
            final boolean b2 = d != null && !d.isEmpty();
            final List c = this.c;
            final boolean b3 = c != null && !c.isEmpty();
            if (!b2 && !b3) {
                throw new IllegalArgumentException("Details of the products must be provided.");
            }
            if (b2 && b3) {
                throw new IllegalArgumentException("Set SkuDetails or ProductDetailsParams, not both.");
            }
            if (b2) {
                if (this.d.contains(null)) {
                    throw new IllegalArgumentException("SKU cannot be null.");
                }
                if (this.d.size() > 1) {
                    final SkuDetails skuDetails = this.d.get(0);
                    final String b4 = skuDetails.b();
                    final ArrayList d2 = this.d;
                    for (int size = d2.size(), i = 0; i < size; ++i) {
                        final SkuDetails skuDetails2 = (SkuDetails)d2.get(i);
                        if (!b4.equals("play_pass_subs") && !skuDetails2.b().equals("play_pass_subs") && !b4.equals(skuDetails2.b())) {
                            throw new IllegalArgumentException("SKUs should have the same type.");
                        }
                    }
                    final String f = skuDetails.f();
                    final ArrayList d3 = this.d;
                    for (int size2 = d3.size(), j = 0; j < size2; ++j) {
                        final SkuDetails skuDetails3 = (SkuDetails)d3.get(j);
                        if (!b4.equals("play_pass_subs") && !skuDetails3.b().equals("play_pass_subs") && !f.equals(skuDetails3.f())) {
                            throw new IllegalArgumentException("All SKUs must have the same package name.");
                        }
                    }
                }
            }
            else {
                final b b5 = this.c.get(0);
                for (int k = 0; k < this.c.size(); ++k) {
                    final b b6 = this.c.get(k);
                    if (b6 == null) {
                        throw new IllegalArgumentException("ProductDetailsParams cannot be null.");
                    }
                    if (k != 0 && !b6.b().d().equals(b5.b().d()) && !b6.b().d().equals("play_pass_subs")) {
                        throw new IllegalArgumentException("All products should have same ProductType.");
                    }
                }
                final String g = b5.b().g();
                for (final b b7 : this.c) {
                    if (!b5.b().d().equals("play_pass_subs") && !b7.b().d().equals("play_pass_subs")) {
                        if (g.equals(b7.b().g())) {
                            continue;
                        }
                        throw new IllegalArgumentException("All products must have the same package name.");
                    }
                }
            }
            final f f2 = new f(null);
            boolean b8 = false;
            Label_0646: {
                if (b2) {
                    b8 = b;
                    if (!this.d.get(0).f().isEmpty()) {
                        break Label_0646;
                    }
                }
                b8 = (b3 && !((b)this.c.get(0)).b().g().isEmpty() && b);
            }
            com.android.billingclient.api.f.h(f2, b8);
            com.android.billingclient.api.f.j(f2, this.a);
            com.android.billingclient.api.f.k(f2, this.b);
            com.android.billingclient.api.f.n(f2, this.f.a());
            final ArrayList d4 = this.d;
            ArrayList list;
            if (d4 != null) {
                list = new ArrayList(d4);
            }
            else {
                list = new ArrayList();
            }
            com.android.billingclient.api.f.m(f2, (ArrayList)list);
            com.android.billingclient.api.f.i(f2, this.e);
            final List c2 = this.c;
            zzu zzu;
            if (c2 != null) {
                zzu = com.google.android.gms.internal.play_billing.zzu.zzk((Collection)c2);
            }
            else {
                zzu = com.google.android.gms.internal.play_billing.zzu.zzl();
            }
            com.android.billingclient.api.f.l(f2, zzu);
            return f2;
        }
        
        public a b(final List<b> list) {
            this.c = new ArrayList(list);
            return this;
        }
    }
    
    public static final class b
    {
        private final m a;
        private final String b;
        
        b(final a a, final j0 j0) {
            this.a = a.d(a);
            this.b = a.e(a);
        }
        
        public static a a() {
            return new a(null);
        }
        
        public final m b() {
            return this.a;
        }
        
        public final String c() {
            return this.b;
        }
        
        public static class a
        {
            private m a;
            private String b;
            
            a(final i0 i0) {
            }
            
            static /* bridge */ m d(final a a) {
                return a.a;
            }
            
            static /* bridge */ String e(final a a) {
                return a.b;
            }
            
            public b a() {
                zzm.zzc((Object)this.a, (Object)"ProductDetails is required for constructing ProductDetailsParams.");
                zzm.zzc((Object)this.b, (Object)"offerToken is required for constructing ProductDetailsParams.");
                return new b(this, null);
            }
            
            public a b(final String b) {
                this.b = b;
                return this;
            }
            
            public a c(final m a) {
                this.a = a;
                if (a.b() != null) {
                    Objects.requireNonNull(a.b());
                    this.b = a.b().a();
                }
                return this;
            }
        }
    }
    
    public static class c
    {
        private String a;
        private int b;
        
        c(final l0 l0) {
            this.b = 0;
        }
        
        public static a a() {
            return new a(null);
        }
        
        static /* bridge */ void d(final c c, final String a) {
            c.a = a;
        }
        
        static /* bridge */ void e(final c c, final int b) {
            c.b = b;
        }
        
        final int b() {
            return this.b;
        }
        
        final String c() {
            return this.a;
        }
        
        public static class a
        {
            private String a;
            private boolean b;
            private int c;
            
            a(final k0 k0) {
                this.c = 0;
            }
            
            static a b(final a a) {
                a.b = true;
                return a;
            }
            
            public c a() {
                final boolean b = !TextUtils.isEmpty((CharSequence)this.a) || !TextUtils.isEmpty((CharSequence)null);
                final boolean b2 = true ^ TextUtils.isEmpty((CharSequence)null);
                if (b && b2) {
                    throw new IllegalArgumentException("Please provide Old SKU purchase information(token/id) or original external transaction id, not both.");
                }
                if (!this.b && !b && !b2) {
                    throw new IllegalArgumentException("Old SKU purchase information(token/id) or original external transaction id must be provided.");
                }
                final c c = new c(null);
                com.android.billingclient.api.f.c.d(c, this.a);
                com.android.billingclient.api.f.c.e(c, this.c);
                return c;
            }
        }
    }
}
