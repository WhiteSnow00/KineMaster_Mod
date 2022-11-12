// 
// Decompiled by Procyon v0.6.0
// 

package androidx.work;

import java.util.Collections;
import android.net.Uri;
import java.util.List;
import android.net.Network;
import java.util.HashSet;
import java.util.Collection;
import e1.d;
import e1.j;
import e1.o;
import o1.a;
import java.util.concurrent.Executor;
import java.util.Set;
import java.util.UUID;

public final class WorkerParameters
{
    private UUID a;
    private b b;
    private Set<String> c;
    private a d;
    private int e;
    private Executor f;
    private o1.a g;
    private o h;
    private j i;
    private d j;
    
    public WorkerParameters(final UUID a, final b b, final Collection<String> collection, final a d, final int e, final Executor f, final o1.a g, final o h, final j i, final d j) {
        this.a = a;
        this.b = b;
        this.c = new HashSet<String>(collection);
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
        this.j = j;
    }
    
    public Executor a() {
        return this.f;
    }
    
    public d b() {
        return this.j;
    }
    
    public UUID c() {
        return this.a;
    }
    
    public b d() {
        return this.b;
    }
    
    public Network e() {
        return this.d.c;
    }
    
    public j f() {
        return this.i;
    }
    
    public int g() {
        return this.e;
    }
    
    public Set<String> h() {
        return this.c;
    }
    
    public o1.a i() {
        return this.g;
    }
    
    public List<String> j() {
        return this.d.a;
    }
    
    public List<Uri> k() {
        return this.d.b;
    }
    
    public o l() {
        return this.h;
    }
    
    public static class a
    {
        public List<String> a;
        public List<Uri> b;
        public Network c;
        
        public a() {
            this.a = Collections.emptyList();
            this.b = Collections.emptyList();
        }
    }
}
