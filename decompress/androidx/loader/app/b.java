// 
// Decompiled by Procyon v0.6.0
// 

package androidx.loader.app;

import androidx.collection.h;
import androidx.lifecycle.o0;
import androidx.lifecycle.l0;
import androidx.lifecycle.a0;
import androidx.lifecycle.z;
import android.os.Looper;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import android.util.Log;
import java.lang.reflect.Modifier;
import android.os.Bundle;
import androidx.lifecycle.q0;
import androidx.lifecycle.r;

class b extends androidx.loader.app.a
{
    static boolean c = false;
    private final r a;
    private final c b;
    
    b(final r a, final q0 q0) {
        this.a = a;
        this.b = androidx.loader.app.b.c.k(q0);
    }
    
    private <D> b<D> e(final int n, final Bundle bundle, final androidx.loader.app.a.a<D> a, final b<D> b) {
        try {
            this.b.p();
            final b<D> b2 = a.b(n, bundle);
            if (b2 == null) {
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
            }
            if (b2.getClass().isMemberClass() && !Modifier.isStatic(b2.getClass().getModifiers())) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Object returned from onCreateLoader must not be a non-static inner member class: ");
                sb.append(b2);
                throw new IllegalArgumentException(sb.toString());
            }
            final a a2 = new a<D>(n, bundle, (b<Object>)b2, (b<Object>)b);
            if (b.c) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("  Created new loader ");
                sb2.append(a2);
                Log.v("LoaderManager", sb2.toString());
            }
            this.b.o(n, a2);
            this.b.j();
            return a2.f(this.a, a);
        }
        finally {
            this.b.j();
        }
    }
    
    @Deprecated
    @Override
    public void a(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        this.b.h(s, fileDescriptor, printWriter, array);
    }
    
    @Override
    public <D> b<D> c(final int n, final Bundle bundle, final androidx.loader.app.a.a<D> a) {
        if (this.b.m()) {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
        final a<Object> l = this.b.l(n);
        if (androidx.loader.app.b.c) {
            final StringBuilder sb = new StringBuilder();
            sb.append("initLoader in ");
            sb.append(this);
            sb.append(": args=");
            sb.append(bundle);
            Log.v("LoaderManager", sb.toString());
        }
        if (l == null) {
            return this.e(n, bundle, a, null);
        }
        if (androidx.loader.app.b.c) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("  Re-using existing loader ");
            sb2.append(l);
            Log.v("LoaderManager", sb2.toString());
        }
        return (b<D>)l.f(this.a, (androidx.loader.app.a.a<Object>)a);
    }
    
    @Override
    public void d() {
        this.b.n();
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        androidx.core.util.b.a(this.a, sb);
        sb.append("}}");
        return sb.toString();
    }
    
    public static class a<D> extends z<D> implements b.b<D>
    {
        private final int a;
        private final Bundle b;
        private final b<D> c;
        private r d;
        private b<D> e;
        private b<D> f;
        
        a(final int a, final Bundle b, final b<D> c, final b<D> f) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.f = f;
            c.q(a, (b.b<D>)this);
        }
        
        @Override
        public void a(final b<D> b, final D value) {
            if (b.c) {
                final StringBuilder sb = new StringBuilder();
                sb.append("onLoadComplete: ");
                sb.append(this);
                Log.v("LoaderManager", sb.toString());
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.setValue(value);
            }
            else {
                if (b.c) {
                    Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
                }
                this.postValue(value);
            }
        }
        
        b<D> b(final boolean b) {
            if (b.c) {
                final StringBuilder sb = new StringBuilder();
                sb.append("  Destroying: ");
                sb.append(this);
                Log.v("LoaderManager", sb.toString());
            }
            this.c.b();
            this.c.a();
            final b<D> e = this.e;
            if (e != null) {
                this.removeObserver(e);
                if (b) {
                    e.c();
                }
            }
            this.c.v((b.b<D>)this);
            if ((e != null && !e.b()) || b) {
                this.c.r();
                return this.f;
            }
            return this.c;
        }
        
        public void c(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
            printWriter.print(s);
            printWriter.print("mId=");
            printWriter.print(this.a);
            printWriter.print(" mArgs=");
            printWriter.println(this.b);
            printWriter.print(s);
            printWriter.print("mLoader=");
            printWriter.println(this.c);
            final b<D> c = this.c;
            final StringBuilder sb = new StringBuilder();
            sb.append(s);
            sb.append("  ");
            c.g(sb.toString(), fileDescriptor, printWriter, array);
            if (this.e != null) {
                printWriter.print(s);
                printWriter.print("mCallbacks=");
                printWriter.println(this.e);
                final b<D> e = this.e;
                final StringBuilder sb2 = new StringBuilder();
                sb2.append(s);
                sb2.append("  ");
                e.a(sb2.toString(), printWriter);
            }
            printWriter.print(s);
            printWriter.print("mData=");
            printWriter.println(this.d().d(this.getValue()));
            printWriter.print(s);
            printWriter.print("mStarted=");
            printWriter.println(this.hasActiveObservers());
        }
        
        b<D> d() {
            return this.c;
        }
        
        void e() {
            final r d = this.d;
            final b<D> e = this.e;
            if (d != null && e != null) {
                super.removeObserver(e);
                this.observe(d, e);
            }
        }
        
        b<D> f(final r d, final androidx.loader.app.a.a<D> a) {
            final b e = new b((b<D>)this.c, (androidx.loader.app.a.a<D>)a);
            this.observe(d, e);
            final b<D> e2 = this.e;
            if (e2 != null) {
                this.removeObserver(e2);
            }
            this.d = d;
            this.e = e;
            return this.c;
        }
        
        @Override
        protected void onActive() {
            if (androidx.loader.app.b.c) {
                final StringBuilder sb = new StringBuilder();
                sb.append("  Starting: ");
                sb.append(this);
                Log.v("LoaderManager", sb.toString());
            }
            this.c.t();
        }
        
        @Override
        protected void onInactive() {
            if (androidx.loader.app.b.c) {
                final StringBuilder sb = new StringBuilder();
                sb.append("  Stopping: ");
                sb.append(this);
                Log.v("LoaderManager", sb.toString());
            }
            this.c.u();
        }
        
        @Override
        public void removeObserver(final a0<? super D> a0) {
            super.removeObserver(a0);
            this.d = null;
            this.e = null;
        }
        
        @Override
        public void setValue(final D value) {
            super.setValue(value);
            final b<D> f = this.f;
            if (f != null) {
                f.r();
                this.f = null;
            }
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.a);
            sb.append(" : ");
            androidx.core.util.b.a(this.c, sb);
            sb.append("}}");
            return sb.toString();
        }
    }
    
    static class b<D> implements a0<D>
    {
        private final androidx.loader.content.b<D> a;
        private final androidx.loader.app.a.a<D> b;
        private boolean c;
        
        b(final androidx.loader.content.b<D> a, final androidx.loader.app.a.a<D> b) {
            this.c = false;
            this.a = a;
            this.b = b;
        }
        
        public void a(final String s, final PrintWriter printWriter) {
            printWriter.print(s);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.c);
        }
        
        boolean b() {
            return this.c;
        }
        
        void c() {
            if (this.c) {
                if (androidx.loader.app.b.c) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("  Resetting: ");
                    sb.append(this.a);
                    Log.v("LoaderManager", sb.toString());
                }
                this.b.c(this.a);
            }
        }
        
        @Override
        public void onChanged(final D n) {
            if (androidx.loader.app.b.c) {
                final StringBuilder sb = new StringBuilder();
                sb.append("  onLoadFinished in ");
                sb.append(this.a);
                sb.append(": ");
                sb.append(this.a.d(n));
                Log.v("LoaderManager", sb.toString());
            }
            this.b.a(this.a, n);
            this.c = true;
        }
        
        @Override
        public String toString() {
            return this.b.toString();
        }
    }
    
    static class c extends l0
    {
        private static final o0.b c;
        private h<a> a;
        private boolean b;
        
        static {
            c = new o0.b() {
                @Override
                public <T extends l0> T a(final Class<T> clazz) {
                    return (T)new c();
                }
            };
        }
        
        c() {
            this.a = new h<a>();
            this.b = false;
        }
        
        static c k(final q0 q0) {
            return new o0(q0, androidx.loader.app.b.c.c).a(c.class);
        }
        
        public void h(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
            if (this.a.q() > 0) {
                printWriter.print(s);
                printWriter.println("Loaders:");
                final StringBuilder sb = new StringBuilder();
                sb.append(s);
                sb.append("    ");
                final String string = sb.toString();
                for (int i = 0; i < this.a.q(); ++i) {
                    final a a = this.a.r(i);
                    printWriter.print(s);
                    printWriter.print("  #");
                    printWriter.print(this.a.m(i));
                    printWriter.print(": ");
                    printWriter.println(a.toString());
                    a.c(string, fileDescriptor, printWriter, array);
                }
            }
        }
        
        void j() {
            this.b = false;
        }
        
         <D> a<D> l(final int n) {
            return this.a.g(n);
        }
        
        boolean m() {
            return this.b;
        }
        
        void n() {
            for (int q = this.a.q(), i = 0; i < q; ++i) {
                this.a.r(i).e();
            }
        }
        
        void o(final int n, final a a) {
            this.a.n(n, a);
        }
        
        @Override
        protected void onCleared() {
            super.onCleared();
            for (int q = this.a.q(), i = 0; i < q; ++i) {
                this.a.r(i).b(true);
            }
            this.a.c();
        }
        
        void p() {
            this.b = true;
        }
    }
}
