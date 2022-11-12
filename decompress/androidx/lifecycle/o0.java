// 
// Decompiled by Procyon v0.6.0
// 

package androidx.lifecycle;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import android.app.Application;
import k0.d;
import java.util.Objects;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.o;
import k0.a;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0004\u0006\n\u001a\u001bB#\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015B\u0011\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0014\u0010\u0018B\u0019\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u000f¢\u0006\u0004\b\u0014\u0010\u0019J(\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0097\u0002¢\u0006\u0004\b\u0006\u0010\u0007J0\u0010\n\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0097\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0010¨\u0006\u001c" }, d2 = { "Landroidx/lifecycle/o0;", "", "Landroidx/lifecycle/l0;", "T", "Ljava/lang/Class;", "modelClass", "a", "(Ljava/lang/Class;)Landroidx/lifecycle/l0;", "", "key", "b", "(Ljava/lang/String;Ljava/lang/Class;)Landroidx/lifecycle/l0;", "Landroidx/lifecycle/q0;", "Landroidx/lifecycle/q0;", "store", "Landroidx/lifecycle/o0$b;", "Landroidx/lifecycle/o0$b;", "factory", "Lk0/a;", "defaultCreationExtras", "<init>", "(Landroidx/lifecycle/q0;Landroidx/lifecycle/o0$b;Lk0/a;)V", "Landroidx/lifecycle/r0;", "owner", "(Landroidx/lifecycle/r0;)V", "(Landroidx/lifecycle/r0;Landroidx/lifecycle/o0$b;)V", "c", "d", "lifecycle-viewmodel_release" }, k = 1, mv = { 1, 6, 0 })
public class o0
{
    private final q0 a;
    private final b b;
    private final k0.a c;
    
    public o0(final q0 q0, final b b) {
        o.g((Object)q0, "store");
        o.g((Object)b, "factory");
        this(q0, b, null, 4, null);
    }
    
    public o0(final q0 a, final b b, final k0.a c) {
        o.g((Object)a, "store");
        o.g((Object)b, "factory");
        o.g((Object)c, "defaultCreationExtras");
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public o0(final q0 q0, final b b, k0.a b2, final int n, final i i) {
        if ((n & 0x4) != 0x0) {
            b2 = k0.a.a.b;
        }
        this(q0, b, b2);
    }
    
    public o0(final r0 r0) {
        o.g((Object)r0, "owner");
        final q0 viewModelStore = r0.getViewModelStore();
        o.f((Object)viewModelStore, "owner.viewModelStore");
        this(viewModelStore, o0.a.f.a(r0), p0.a(r0));
    }
    
    public o0(final r0 r0, final b b) {
        o.g((Object)r0, "owner");
        o.g((Object)b, "factory");
        final q0 viewModelStore = r0.getViewModelStore();
        o.f((Object)viewModelStore, "owner.viewModelStore");
        this(viewModelStore, b, p0.a(r0));
    }
    
    public <T extends l0> T a(final Class<T> clazz) {
        o.g((Object)clazz, "modelClass");
        final String canonicalName = clazz.getCanonicalName();
        if (canonicalName != null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("androidx.lifecycle.ViewModelProvider.DefaultKey:");
            sb.append(canonicalName);
            return this.b(sb.toString(), clazz);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
    
    public <T extends l0> T b(final String s, Class<T> o) {
        o.g((Object)s, "key");
        o.g(o, "modelClass");
        final l0 b = this.a.b(s);
        if (((Class)o).isInstance(b)) {
            final b b2 = this.b;
            d d;
            if (b2 instanceof d) {
                d = (d)b2;
            }
            else {
                d = null;
            }
            if (d != null) {
                o.f((Object)b, "viewModel");
                d.c(b);
            }
            Objects.requireNonNull(b, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
            return (T)b;
        }
        final k0.d d2 = new k0.d(this.c);
        d2.c(o0.c.d, s);
        try {
            o = this.b.b((Class<l0>)o, d2);
        }
        catch (final AbstractMethodError abstractMethodError) {
            o = this.b.a((Class<Class>)o);
        }
        this.a.d(s, (l0)o);
        return (T)o;
    }
    
    @Metadata(bv = {}, d1 = { "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\b\u0016\u0018\u0000 \u00192\u00020\u0001:\u0001\u000eB\u001b\b\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016B\t\b\u0016¢\u0006\u0004\b\u0015\u0010\u0017B\u0011\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0018J/\u0010\b\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ/\u0010\f\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ'\u0010\u000e\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u001a" }, d2 = { "Landroidx/lifecycle/o0$a;", "Landroidx/lifecycle/o0$c;", "Landroidx/lifecycle/l0;", "T", "Ljava/lang/Class;", "modelClass", "Landroid/app/Application;", "app", "g", "(Ljava/lang/Class;Landroid/app/Application;)Landroidx/lifecycle/l0;", "Lk0/a;", "extras", "b", "(Ljava/lang/Class;Lk0/a;)Landroidx/lifecycle/l0;", "a", "(Ljava/lang/Class;)Landroidx/lifecycle/l0;", "e", "Landroid/app/Application;", "application", "", "unused", "<init>", "(Landroid/app/Application;I)V", "()V", "(Landroid/app/Application;)V", "f", "lifecycle-viewmodel_release" }, k = 1, mv = { 1, 6, 0 })
    public static class a extends c
    {
        public static final o0.a.a f;
        private static o0.a g;
        public static final k0.a.b<Application> h;
        private final Application e;
        
        static {
            f = new o0.a.a(null);
            h = o0.a.a.a.a;
        }
        
        public a() {
            this(null, 0);
        }
        
        public a(final Application application) {
            o.g((Object)application, "application");
            this(application, 0);
        }
        
        private a(final Application e, final int n) {
            this.e = e;
        }
        
        public static final o0.a e() {
            return o0.a.g;
        }
        
        public static final void f(final o0.a g) {
            o0.a.g = g;
        }
        
        private final <T extends l0> T g(Class<T> a, final Application application) {
            if (androidx.lifecycle.b.class.isAssignableFrom((Class<?>)a)) {
                try {
                    final l0 l0 = (T)((Class<Class<Class<?>>>)a).getConstructor(Application.class).newInstance(application);
                    o.f((Object)l0, "{\n                try {\n\u2026          }\n            }");
                    a = (Serializable)l0;
                    return (T)a;
                }
                catch (final InvocationTargetException ex) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Cannot create an instance of ");
                    sb.append(a);
                    throw new RuntimeException(sb.toString(), ex);
                }
                catch (final InstantiationException ex2) {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Cannot create an instance of ");
                    sb2.append(a);
                    throw new RuntimeException(sb2.toString(), ex2);
                }
                catch (final IllegalAccessException ex3) {
                    final StringBuilder sb3 = new StringBuilder();
                    sb3.append("Cannot create an instance of ");
                    sb3.append(a);
                    throw new RuntimeException(sb3.toString(), ex3);
                }
                catch (final NoSuchMethodException ex4) {
                    final StringBuilder sb4 = new StringBuilder();
                    sb4.append("Cannot create an instance of ");
                    sb4.append(a);
                    throw new RuntimeException(sb4.toString(), ex4);
                }
            }
            a = super.a((Class<Class<Class<?>>>)a);
            return (T)a;
        }
        
        @Override
        public <T extends l0> T a(final Class<T> clazz) {
            o.g((Object)clazz, "modelClass");
            final Application e = this.e;
            if (e != null) {
                return this.g(clazz, e);
            }
            throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        }
        
        @Override
        public <T extends l0> T b(final Class<T> clazz, final a a) {
            o.g((Object)clazz, "modelClass");
            o.g((Object)a, "extras");
            l0 l0;
            if (this.e != null) {
                l0 = this.a(clazz);
            }
            else {
                final Application application = a.a(o0.a.h);
                if (application != null) {
                    l0 = this.g(clazz, application);
                }
                else {
                    if (androidx.lifecycle.b.class.isAssignableFrom(clazz)) {
                        throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
                    }
                    l0 = super.a(clazz);
                }
            }
            return (T)l0;
        }
        
        @Metadata(bv = {}, d1 = { "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0005B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0007R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0015" }, d2 = { "Landroidx/lifecycle/o0$a$a;", "", "Landroidx/lifecycle/r0;", "owner", "Landroidx/lifecycle/o0$b;", "a", "(Landroidx/lifecycle/r0;)Landroidx/lifecycle/o0$b;", "Landroid/app/Application;", "application", "Landroidx/lifecycle/o0$a;", "b", "Lk0/a$b;", "APPLICATION_KEY", "Lk0/a$b;", "", "DEFAULT_KEY", "Ljava/lang/String;", "sInstance", "Landroidx/lifecycle/o0$a;", "<init>", "()V", "lifecycle-viewmodel_release" }, k = 1, mv = { 1, 6, 0 })
        public static final class a
        {
            private a() {
            }
            
            public a(final i i) {
                this();
            }
            
            public final b a(final r0 r0) {
                o.g((Object)r0, "owner");
                b b;
                if (r0 instanceof k) {
                    b = ((k)r0).getDefaultViewModelProviderFactory();
                    o.f((Object)b, "owner.defaultViewModelProviderFactory");
                }
                else {
                    b = o0.c.b.a();
                }
                return b;
            }
            
            public final o0.a b(final Application application) {
                o.g((Object)application, "application");
                if (o0.a.e() == null) {
                    o0.a.f(new o0.a(application));
                }
                final o0.a e = o0.a.e();
                o.d((Object)e);
                return e;
            }
            
            @Metadata(bv = {}, d1 = { "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c2\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005" }, d2 = { "Landroidx/lifecycle/o0$a$a$a;", "Lk0/a$b;", "Landroid/app/Application;", "<init>", "()V", "lifecycle-viewmodel_release" }, k = 1, mv = { 1, 6, 0 })
            private static final class a implements k0.a.b<Application>
            {
                public static final a a;
                
                static {
                    a = new a();
                }
            }
        }
    }
    
    @Metadata(bv = {}, d1 = { "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J/\u0010\n\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000b\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\f\u00c0\u0006\u0001" }, d2 = { "Landroidx/lifecycle/o0$b;", "", "Landroidx/lifecycle/l0;", "T", "Ljava/lang/Class;", "modelClass", "a", "(Ljava/lang/Class;)Landroidx/lifecycle/l0;", "Lk0/a;", "extras", "b", "(Ljava/lang/Class;Lk0/a;)Landroidx/lifecycle/l0;", "lifecycle-viewmodel_release" }, k = 1, mv = { 1, 6, 0 })
    public interface b
    {
        public static final a a = b.a.a;
        
        default <T extends l0> T a(final Class<T> clazz) {
            o.g((Object)clazz, "modelClass");
            throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
        }
        
        default <T extends l0> T b(final Class<T> clazz, final k0.a a) {
            o.g((Object)clazz, "modelClass");
            o.g((Object)a, "extras");
            return this.a(clazz);
        }
        
        @Metadata(bv = {}, d1 = { "\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004" }, d2 = { "Landroidx/lifecycle/o0$b$a;", "", "<init>", "()V", "lifecycle-viewmodel_release" }, k = 1, mv = { 1, 6, 0 })
        public static final class a
        {
            static final a a;
            
            static {
                a = new a();
            }
            
            private a() {
            }
        }
    }
    
    @Metadata(bv = {}, d1 = { "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 \n2\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\b\u0010\tJ'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\u000b" }, d2 = { "Landroidx/lifecycle/o0$c;", "Landroidx/lifecycle/o0$b;", "Landroidx/lifecycle/l0;", "T", "Ljava/lang/Class;", "modelClass", "a", "(Ljava/lang/Class;)Landroidx/lifecycle/l0;", "<init>", "()V", "b", "lifecycle-viewmodel_release" }, k = 1, mv = { 1, 6, 0 })
    public static class c implements b
    {
        public static final a b;
        private static c c;
        public static final k0.a.b<String> d;
        
        static {
            b = new a(null);
            d = a.a.a;
        }
        
        public static final c c() {
            return o0.c.c;
        }
        
        public static final void d(final c c) {
            o0.c.c = c;
        }
        
        @Override
        public <T extends l0> T a(final Class<T> clazz) {
            o.g((Object)clazz, "modelClass");
            try {
                final l0 instance = clazz.newInstance();
                o.f((Object)instance, "{\n                modelC\u2026wInstance()\n            }");
                return (T)instance;
            }
            catch (final IllegalAccessException ex) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Cannot create an instance of ");
                sb.append(clazz);
                throw new RuntimeException(sb.toString(), ex);
            }
            catch (final InstantiationException ex2) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Cannot create an instance of ");
                sb2.append(clazz);
                throw new RuntimeException(sb2.toString(), ex2);
            }
        }
        
        @Metadata(bv = {}, d1 = { "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000f" }, d2 = { "Landroidx/lifecycle/o0$c$a;", "", "Landroidx/lifecycle/o0$c;", "a", "()Landroidx/lifecycle/o0$c;", "getInstance$annotations", "()V", "instance", "Lk0/a$b;", "", "VIEW_MODEL_KEY", "Lk0/a$b;", "sInstance", "Landroidx/lifecycle/o0$c;", "<init>", "lifecycle-viewmodel_release" }, k = 1, mv = { 1, 6, 0 })
        public static final class a
        {
            private a() {
            }
            
            public a(final i i) {
                this();
            }
            
            public final c a() {
                if (o0.c.c() == null) {
                    o0.c.d(new c());
                }
                final c c = o0.c.c();
                o.d((Object)c);
                return c;
            }
            
            @Metadata(bv = {}, d1 = { "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u00c2\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005" }, d2 = { "Landroidx/lifecycle/o0$c$a$a;", "Lk0/a$b;", "", "<init>", "()V", "lifecycle-viewmodel_release" }, k = 1, mv = { 1, 6, 0 })
            private static final class a implements k0.a.b<String>
            {
                public static final a a;
                
                static {
                    a = new a();
                }
            }
        }
    }
    
    @Metadata(bv = {}, d1 = { "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\b" }, d2 = { "Landroidx/lifecycle/o0$d;", "", "Landroidx/lifecycle/l0;", "viewModel", "Lka/r;", "c", "<init>", "()V", "lifecycle-viewmodel_release" }, k = 1, mv = { 1, 6, 0 })
    public static class d
    {
        public void c(final l0 l0) {
            o.g((Object)l0, "viewModel");
        }
    }
}
