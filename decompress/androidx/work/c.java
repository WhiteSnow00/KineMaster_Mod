// 
// Decompiled by Procyon v0.6.0
// 

package androidx.work;

public final class c extends d
{
    c(final a a) {
        super(a.b, a.c, a.d);
    }
    
    public static c d(final Class<? extends ListenableWorker> clazz) {
        return ((d.a<B, c>)new a(clazz)).b();
    }
    
    public static final class a extends d.a<a, c>
    {
        public a(final Class<? extends ListenableWorker> clazz) {
            super(clazz);
            super.c.d = OverwritingInputMerger.class.getName();
        }
        
        @Override
        /* bridge */ d c() {
            return this.g();
        }
        
        @Override
        /* bridge */ d.a d() {
            return this.h();
        }
        
        c g() {
            if (super.a && super.c.j.h()) {
                throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
            }
            return new c(this);
        }
        
        a h() {
            return this;
        }
    }
}
