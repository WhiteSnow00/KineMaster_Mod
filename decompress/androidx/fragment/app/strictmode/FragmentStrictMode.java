// 
// Decompiled by Procyon v0.6.0
// 

package androidx.fragment.app.strictmode;

import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.collections.e0;
import kotlin.collections.l0;
import kotlin.jvm.internal.i;
import java.util.Map;
import java.util.Set;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import g0.b;
import g0.a;
import android.util.Log;
import androidx.fragment.app.FragmentManager;
import kotlin.jvm.internal.o;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0003/0&B\t\b\u0002¢\u0006\u0004\b-\u0010.J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u001a\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0007J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0007J \u0010\u0016\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0007J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0007J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J0\u0010!\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u00042\u000e\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u001e2\u000e\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001a0\u001eH\u0002J\u0018\u0010\"\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0018\u0010%\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010$\u001a\u00020#H\u0002R\"\u0010,\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u00061" }, d2 = { "Landroidx/fragment/app/strictmode/FragmentStrictMode;", "", "Landroidx/fragment/app/Fragment;", "fragment", "Landroidx/fragment/app/strictmode/FragmentStrictMode$b;", "c", "", "previousFragmentId", "Lka/r;", "h", "Landroid/view/ViewGroup;", "container", "i", "m", "j", "", "isVisibleToUser", "o", "violatingFragment", "targetFragment", "", "requestCode", "n", "l", "k", "p", "Landroidx/fragment/app/strictmode/Violation;", "violation", "g", "policy", "Ljava/lang/Class;", "fragmentClass", "violationClass", "r", "d", "Ljava/lang/Runnable;", "runnable", "q", "b", "Landroidx/fragment/app/strictmode/FragmentStrictMode$b;", "getDefaultPolicy", "()Landroidx/fragment/app/strictmode/FragmentStrictMode$b;", "setDefaultPolicy", "(Landroidx/fragment/app/strictmode/FragmentStrictMode$b;)V", "defaultPolicy", "<init>", "()V", "Flag", "a", "fragment_release" }, k = 1, mv = { 1, 6, 0 })
public final class FragmentStrictMode
{
    public static final FragmentStrictMode a;
    private static b b;
    
    static {
        a = new FragmentStrictMode();
        FragmentStrictMode.b = FragmentStrictMode.b.e;
    }
    
    private FragmentStrictMode() {
    }
    
    public static void a(final b b, final Violation violation) {
        e(b, violation);
    }
    
    public static void b(final String s, final Violation violation) {
        f(s, violation);
    }
    
    private final b c(Fragment parentFragment) {
        while (parentFragment != null) {
            if (parentFragment.isAdded()) {
                final FragmentManager parentFragmentManager = parentFragment.getParentFragmentManager();
                o.f((Object)parentFragmentManager, "declaringFragment.parentFragmentManager");
                if (parentFragmentManager.G0() != null) {
                    final b g0 = parentFragmentManager.G0();
                    o.d((Object)g0);
                    return g0;
                }
            }
            parentFragment = parentFragment.getParentFragment();
        }
        return FragmentStrictMode.b;
    }
    
    private final void d(final b b, final Violation violation) {
        final Fragment fragment = violation.getFragment();
        final String name = fragment.getClass().getName();
        if (b.a().contains(Flag.PENALTY_LOG)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Policy violation in ");
            sb.append(name);
            Log.d("FragmentStrictMode", sb.toString(), (Throwable)violation);
        }
        if (b.b() != null) {
            this.q(fragment, (Runnable)new g0.a(b, violation));
        }
        if (b.a().contains(Flag.PENALTY_DEATH)) {
            this.q(fragment, (Runnable)new g0.b(name, violation));
        }
    }
    
    private static final void e(final b b, final Violation violation) {
        o.g((Object)b, "$policy");
        o.g((Object)violation, "$violation");
        b.b().a(violation);
    }
    
    private static final void f(final String s, final Violation violation) {
        o.g((Object)violation, "$violation");
        final StringBuilder sb = new StringBuilder();
        sb.append("Policy violation with PENALTY_DEATH in ");
        sb.append(s);
        Log.e("FragmentStrictMode", sb.toString(), (Throwable)violation);
        throw violation;
    }
    
    private final void g(final Violation violation) {
        if (FragmentManager.N0(3)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("StrictMode violation in ");
            sb.append(violation.getFragment().getClass().getName());
            Log.d("FragmentManager", sb.toString(), (Throwable)violation);
        }
    }
    
    public static final void h(final Fragment fragment, final String s) {
        o.g((Object)fragment, "fragment");
        o.g((Object)s, "previousFragmentId");
        final FragmentReuseViolation fragmentReuseViolation = new FragmentReuseViolation(fragment, s);
        final FragmentStrictMode a = FragmentStrictMode.a;
        a.g(fragmentReuseViolation);
        final b c = a.c(fragment);
        if (c.a().contains(Flag.DETECT_FRAGMENT_REUSE) && a.r(c, fragment.getClass(), fragmentReuseViolation.getClass())) {
            a.d(c, fragmentReuseViolation);
        }
    }
    
    public static final void i(final Fragment fragment, final ViewGroup viewGroup) {
        o.g((Object)fragment, "fragment");
        final FragmentTagUsageViolation fragmentTagUsageViolation = new FragmentTagUsageViolation(fragment, viewGroup);
        final FragmentStrictMode a = FragmentStrictMode.a;
        a.g(fragmentTagUsageViolation);
        final b c = a.c(fragment);
        if (c.a().contains(Flag.DETECT_FRAGMENT_TAG_USAGE) && a.r(c, fragment.getClass(), fragmentTagUsageViolation.getClass())) {
            a.d(c, fragmentTagUsageViolation);
        }
    }
    
    public static final void j(final Fragment fragment) {
        o.g((Object)fragment, "fragment");
        final GetRetainInstanceUsageViolation getRetainInstanceUsageViolation = new GetRetainInstanceUsageViolation(fragment);
        final FragmentStrictMode a = FragmentStrictMode.a;
        a.g(getRetainInstanceUsageViolation);
        final b c = a.c(fragment);
        if (c.a().contains(Flag.DETECT_RETAIN_INSTANCE_USAGE) && a.r(c, fragment.getClass(), getRetainInstanceUsageViolation.getClass())) {
            a.d(c, getRetainInstanceUsageViolation);
        }
    }
    
    public static final void k(final Fragment fragment) {
        o.g((Object)fragment, "fragment");
        final GetTargetFragmentRequestCodeUsageViolation getTargetFragmentRequestCodeUsageViolation = new GetTargetFragmentRequestCodeUsageViolation(fragment);
        final FragmentStrictMode a = FragmentStrictMode.a;
        a.g(getTargetFragmentRequestCodeUsageViolation);
        final b c = a.c(fragment);
        if (c.a().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && a.r(c, fragment.getClass(), getTargetFragmentRequestCodeUsageViolation.getClass())) {
            a.d(c, getTargetFragmentRequestCodeUsageViolation);
        }
    }
    
    public static final void l(final Fragment fragment) {
        o.g((Object)fragment, "fragment");
        final GetTargetFragmentUsageViolation getTargetFragmentUsageViolation = new GetTargetFragmentUsageViolation(fragment);
        final FragmentStrictMode a = FragmentStrictMode.a;
        a.g(getTargetFragmentUsageViolation);
        final b c = a.c(fragment);
        if (c.a().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && a.r(c, fragment.getClass(), getTargetFragmentUsageViolation.getClass())) {
            a.d(c, getTargetFragmentUsageViolation);
        }
    }
    
    public static final void m(final Fragment fragment) {
        o.g((Object)fragment, "fragment");
        final SetRetainInstanceUsageViolation setRetainInstanceUsageViolation = new SetRetainInstanceUsageViolation(fragment);
        final FragmentStrictMode a = FragmentStrictMode.a;
        a.g(setRetainInstanceUsageViolation);
        final b c = a.c(fragment);
        if (c.a().contains(Flag.DETECT_RETAIN_INSTANCE_USAGE) && a.r(c, fragment.getClass(), setRetainInstanceUsageViolation.getClass())) {
            a.d(c, setRetainInstanceUsageViolation);
        }
    }
    
    public static final void n(final Fragment fragment, final Fragment fragment2, final int n) {
        o.g((Object)fragment, "violatingFragment");
        o.g((Object)fragment2, "targetFragment");
        final SetTargetFragmentUsageViolation setTargetFragmentUsageViolation = new SetTargetFragmentUsageViolation(fragment, fragment2, n);
        final FragmentStrictMode a = FragmentStrictMode.a;
        a.g(setTargetFragmentUsageViolation);
        final b c = a.c(fragment);
        if (c.a().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && a.r(c, fragment.getClass(), setTargetFragmentUsageViolation.getClass())) {
            a.d(c, setTargetFragmentUsageViolation);
        }
    }
    
    public static final void o(final Fragment fragment, final boolean b) {
        o.g((Object)fragment, "fragment");
        final SetUserVisibleHintViolation setUserVisibleHintViolation = new SetUserVisibleHintViolation(fragment, b);
        final FragmentStrictMode a = FragmentStrictMode.a;
        a.g(setUserVisibleHintViolation);
        final b c = a.c(fragment);
        if (c.a().contains(Flag.DETECT_SET_USER_VISIBLE_HINT) && a.r(c, fragment.getClass(), setUserVisibleHintViolation.getClass())) {
            a.d(c, setUserVisibleHintViolation);
        }
    }
    
    public static final void p(final Fragment fragment, final ViewGroup viewGroup) {
        o.g((Object)fragment, "fragment");
        o.g((Object)viewGroup, "container");
        final WrongFragmentContainerViolation wrongFragmentContainerViolation = new WrongFragmentContainerViolation(fragment, viewGroup);
        final FragmentStrictMode a = FragmentStrictMode.a;
        a.g(wrongFragmentContainerViolation);
        final b c = a.c(fragment);
        if (c.a().contains(Flag.DETECT_WRONG_FRAGMENT_CONTAINER) && a.r(c, fragment.getClass(), wrongFragmentContainerViolation.getClass())) {
            a.d(c, wrongFragmentContainerViolation);
        }
    }
    
    private final void q(final Fragment fragment, final Runnable runnable) {
        if (fragment.isAdded()) {
            final Handler g = fragment.getParentFragmentManager().A0().g();
            o.f((Object)g, "fragment.parentFragmentManager.host.handler");
            if (o.b((Object)g.getLooper(), (Object)Looper.myLooper())) {
                runnable.run();
            }
            else {
                g.post(runnable);
            }
        }
        else {
            runnable.run();
        }
    }
    
    private final boolean r(final b b, final Class<? extends Fragment> clazz, final Class<? extends Violation> clazz2) {
        final Set set = b.c().get(clazz.getName());
        return set == null || ((o.b((Object)clazz2.getSuperclass(), (Object)Violation.class) || !kotlin.collections.o.R((Iterable)set, (Object)clazz2.getSuperclass())) && (set.contains(clazz2) ^ true));
    }
    
    @Metadata(d1 = { "\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b" }, d2 = { "Landroidx/fragment/app/strictmode/FragmentStrictMode$Flag;", "", "(Ljava/lang/String;I)V", "PENALTY_LOG", "PENALTY_DEATH", "DETECT_FRAGMENT_REUSE", "DETECT_FRAGMENT_TAG_USAGE", "DETECT_RETAIN_INSTANCE_USAGE", "DETECT_SET_USER_VISIBLE_HINT", "DETECT_TARGET_FRAGMENT_USAGE", "DETECT_WRONG_FRAGMENT_CONTAINER", "fragment_release" }, k = 1, mv = { 1, 6, 0 }, xi = 48)
    public enum Flag
    {
        private static final Flag[] $VALUES;
        
        DETECT_FRAGMENT_REUSE, 
        DETECT_FRAGMENT_TAG_USAGE, 
        DETECT_RETAIN_INSTANCE_USAGE, 
        DETECT_SET_USER_VISIBLE_HINT, 
        DETECT_TARGET_FRAGMENT_USAGE, 
        DETECT_WRONG_FRAGMENT_CONTAINER, 
        PENALTY_DEATH, 
        PENALTY_LOG;
        
        static {
            $VALUES = a();
        }
        
        private static final Flag[] a() {
            return new Flag[] { Flag.PENALTY_LOG, Flag.PENALTY_DEATH, Flag.DETECT_FRAGMENT_REUSE, Flag.DETECT_FRAGMENT_TAG_USAGE, Flag.DETECT_RETAIN_INSTANCE_USAGE, Flag.DETECT_SET_USER_VISIBLE_HINT, Flag.DETECT_TARGET_FRAGMENT_USAGE, Flag.DETECT_WRONG_FRAGMENT_CONTAINER };
        }
    }
    
    @Metadata(bv = {}, d1 = { "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006" }, d2 = { "Landroidx/fragment/app/strictmode/FragmentStrictMode$a;", "", "Landroidx/fragment/app/strictmode/Violation;", "violation", "Lka/r;", "a", "fragment_release" }, k = 1, mv = { 1, 6, 0 })
    public interface a
    {
        void a(final Violation p0);
    }
    
    @Metadata(bv = {}, d1 = { "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0001\u0004BC\b\u0000\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b\u0012 \u0010\u0016\u001a\u001c\u0012\u0004\u0012\u00020\u000e\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000f0\u00150\r¢\u0006\u0004\b\u0017\u0010\u0018R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR4\u0010\u0014\u001a\u001c\u0012\u0004\u0012\u00020\u000e\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000f0\u00020\r8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013¨\u0006\u001a" }, d2 = { "Landroidx/fragment/app/strictmode/FragmentStrictMode$b;", "", "", "Landroidx/fragment/app/strictmode/FragmentStrictMode$Flag;", "a", "Ljava/util/Set;", "()Ljava/util/Set;", "flags", "Landroidx/fragment/app/strictmode/FragmentStrictMode$a;", "b", "Landroidx/fragment/app/strictmode/FragmentStrictMode$a;", "()Landroidx/fragment/app/strictmode/FragmentStrictMode$a;", "listener", "", "", "Ljava/lang/Class;", "Landroidx/fragment/app/strictmode/Violation;", "c", "Ljava/util/Map;", "()Ljava/util/Map;", "mAllowedViolations", "", "allowedViolations", "<init>", "(Ljava/util/Set;Landroidx/fragment/app/strictmode/FragmentStrictMode$a;Ljava/util/Map;)V", "d", "fragment_release" }, k = 1, mv = { 1, 6, 0 })
    public static final class b
    {
        public static final a d;
        public static final b e;
        private final Set<Flag> a;
        private final FragmentStrictMode.a b;
        private final Map<String, Set<Class<? extends Violation>>> c;
        
        static {
            d = new a(null);
            e = new b(l0.d(), null, e0.i());
        }
        
        public b(final Set<? extends Flag> a, final FragmentStrictMode.a b, final Map<String, ? extends Set<Class<? extends Violation>>> map) {
            o.g((Object)a, "flags");
            o.g((Object)map, "allowedViolations");
            this.a = (Set<Flag>)a;
            this.b = b;
            final LinkedHashMap c = new LinkedHashMap();
            for (final Map.Entry entry : map.entrySet()) {
                c.put(entry.getKey(), entry.getValue());
            }
            this.c = c;
        }
        
        public final Set<Flag> a() {
            return this.a;
        }
        
        public final FragmentStrictMode.a b() {
            return this.b;
        }
        
        public final Map<String, Set<Class<? extends Violation>>> c() {
            return this.c;
        }
        
        @Metadata(bv = {}, d1 = { "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007" }, d2 = { "Landroidx/fragment/app/strictmode/FragmentStrictMode$b$a;", "", "Landroidx/fragment/app/strictmode/FragmentStrictMode$b;", "LAX", "Landroidx/fragment/app/strictmode/FragmentStrictMode$b;", "<init>", "()V", "fragment_release" }, k = 1, mv = { 1, 6, 0 })
        public static final class a
        {
            private a() {
            }
            
            public a(final i i) {
                this();
            }
        }
    }
}
