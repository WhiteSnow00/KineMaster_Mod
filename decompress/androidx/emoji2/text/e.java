// 
// Decompiled by Procyon v0.6.0
// 

package androidx.emoji2.text;

import java.util.Arrays;
import java.util.List;
import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import java.util.ArrayList;
import android.view.KeyEvent;
import android.text.Editable;
import android.view.inputmethod.InputConnection;
import androidx.core.util.h;
import java.util.Collection;
import androidx.collection.b;
import android.os.Looper;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import android.os.Handler;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;

public class e
{
    private static final Object n;
    private static final Object o;
    private static volatile e p;
    private final ReadWriteLock a;
    private final Set<e> b;
    private volatile int c;
    private final Handler d;
    private final b e;
    final g f;
    final boolean g;
    final boolean h;
    final int[] i;
    private final boolean j;
    private final int k;
    private final int l;
    private final d m;
    
    static {
        n = new Object();
        o = new Object();
    }
    
    private e(final c c) {
        this.a = new ReentrantReadWriteLock();
        this.c = 3;
        this.g = c.b;
        this.h = c.c;
        this.i = c.d;
        this.j = c.f;
        this.k = c.g;
        this.f = c.a;
        this.l = c.h;
        this.m = c.i;
        this.d = new Handler(Looper.getMainLooper());
        final androidx.collection.b b = new androidx.collection.b();
        this.b = b;
        final Set<e> e = c.e;
        if (e != null && !e.isEmpty()) {
            b.addAll(c.e);
        }
        this.e = (b)new a(this);
        this.l();
    }
    
    static d a(final e e) {
        return e.m;
    }
    
    public static e b() {
        synchronized (e.n) {
            final e p = e.p;
            androidx.core.util.h.i(p != null, "EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
            return p;
        }
    }
    
    public static boolean e(final InputConnection inputConnection, final Editable editable, final int n, final int n2, final boolean b) {
        return androidx.emoji2.text.h.c(inputConnection, editable, n, n2, b);
    }
    
    public static boolean f(final Editable editable, final int n, final KeyEvent keyEvent) {
        return androidx.emoji2.text.h.d(editable, n, keyEvent);
    }
    
    public static e g(final c c) {
        e e;
        if ((e = androidx.emoji2.text.e.p) == null) {
            synchronized (androidx.emoji2.text.e.n) {
                if ((e = androidx.emoji2.text.e.p) == null) {
                    e = (androidx.emoji2.text.e.p = new e(c));
                }
            }
        }
        return e;
    }
    
    public static boolean h() {
        return e.p != null;
    }
    
    private boolean j() {
        final int d = this.d();
        boolean b = true;
        if (d != 1) {
            b = false;
        }
        return b;
    }
    
    private void l() {
        this.a.writeLock().lock();
        try {
            if (this.l == 0) {
                this.c = 0;
            }
            this.a.writeLock().unlock();
            if (this.d() == 0) {
                this.e.a();
            }
        }
        finally {
            this.a.writeLock().unlock();
        }
    }
    
    public int c() {
        return this.k;
    }
    
    public int d() {
        this.a.readLock().lock();
        try {
            return this.c;
        }
        finally {
            this.a.readLock().unlock();
        }
    }
    
    public boolean i() {
        return this.j;
    }
    
    public void k() {
        final int l = this.l;
        boolean b = true;
        if (l != 1) {
            b = false;
        }
        androidx.core.util.h.i(b, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        if (this.j()) {
            return;
        }
        this.a.writeLock().lock();
        try {
            if (this.c == 0) {
                return;
            }
            this.c = 0;
            this.a.writeLock().unlock();
            this.e.a();
        }
        finally {
            this.a.writeLock().unlock();
        }
    }
    
    void m(final Throwable t) {
        final ArrayList list = new ArrayList();
        this.a.writeLock().lock();
        try {
            this.c = 2;
            list.addAll(this.b);
            this.b.clear();
            this.a.writeLock().unlock();
            this.d.post((Runnable)new f(list, this.c, t));
        }
        finally {
            this.a.writeLock().unlock();
        }
    }
    
    void n() {
        final ArrayList list = new ArrayList();
        this.a.writeLock().lock();
        try {
            this.c = 1;
            list.addAll(this.b);
            this.b.clear();
            this.a.writeLock().unlock();
            this.d.post((Runnable)new f(list, this.c));
        }
        finally {
            this.a.writeLock().unlock();
        }
    }
    
    public CharSequence o(final CharSequence charSequence) {
        int length;
        if (charSequence == null) {
            length = 0;
        }
        else {
            length = charSequence.length();
        }
        return this.p(charSequence, 0, length);
    }
    
    public CharSequence p(final CharSequence charSequence, final int n, final int n2) {
        return this.q(charSequence, n, n2, Integer.MAX_VALUE);
    }
    
    public CharSequence q(final CharSequence charSequence, final int n, final int n2, final int n3) {
        return this.r(charSequence, n, n2, n3, 0);
    }
    
    public CharSequence r(final CharSequence charSequence, final int n, final int n2, final int n3, final int n4) {
        androidx.core.util.h.i(this.j(), "Not initialized yet");
        androidx.core.util.h.e(n, "start cannot be negative");
        androidx.core.util.h.e(n2, "end cannot be negative");
        androidx.core.util.h.e(n3, "maxEmojiCount cannot be negative");
        final boolean b = false;
        androidx.core.util.h.b(n <= n2, "start should be <= than end");
        if (charSequence == null) {
            return null;
        }
        androidx.core.util.h.b(n <= charSequence.length(), "start should be < than charSequence length");
        androidx.core.util.h.b(n2 <= charSequence.length(), "end should be < than charSequence length");
        CharSequence b2 = charSequence;
        if (charSequence.length() != 0) {
            if (n == n2) {
                b2 = charSequence;
            }
            else {
                boolean g;
                if (n4 != 1) {
                    g = b;
                    if (n4 != 2) {
                        g = this.g;
                    }
                }
                else {
                    g = true;
                }
                b2 = this.e.b(charSequence, n, n2, n3, g);
            }
        }
        return b2;
    }
    
    public void s(final e e) {
        androidx.core.util.h.h(e, "initCallback cannot be null");
        this.a.writeLock().lock();
        try {
            if (this.c != 1 && this.c != 2) {
                this.b.add(e);
            }
            else {
                this.d.post((Runnable)new f(e, this.c));
            }
        }
        finally {
            this.a.writeLock().unlock();
        }
    }
    
    public void t(final e e) {
        androidx.core.util.h.h(e, "initCallback cannot be null");
        this.a.writeLock().lock();
        try {
            this.b.remove(e);
        }
        finally {
            this.a.writeLock().unlock();
        }
    }
    
    public void u(final EditorInfo editorInfo) {
        if (this.j()) {
            if (editorInfo != null) {
                if (editorInfo.extras == null) {
                    editorInfo.extras = new Bundle();
                }
                this.e.c(editorInfo);
            }
        }
    }
    
    private static final class a extends b
    {
        private volatile androidx.emoji2.text.h b;
        private volatile m c;
        
        a(final e e) {
            super(e);
        }
        
        @Override
        void a() {
            try {
                super.a.f.a(new h(this) {
                    final a a;
                    
                    @Override
                    public void a(final Throwable t) {
                        this.a.a.m(t);
                    }
                    
                    @Override
                    public void b(final m m) {
                        this.a.d(m);
                    }
                });
            }
            finally {
                final Throwable t;
                super.a.m(t);
            }
        }
        
        @Override
        CharSequence b(final CharSequence charSequence, final int n, final int n2, final int n3, final boolean b) {
            return this.b.h(charSequence, n, n2, n3, b);
        }
        
        @Override
        void c(final EditorInfo editorInfo) {
            editorInfo.extras.putInt("android.support.text.emoji.emojiCompat_metadataVersion", this.c.e());
            editorInfo.extras.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", super.a.g);
        }
        
        void d(m c) {
            if (c == null) {
                super.a.m(new IllegalArgumentException("metadataRepo cannot be null"));
                return;
            }
            this.c = c;
            c = this.c;
            final i i = new i();
            final d a = androidx.emoji2.text.e.a(super.a);
            final e a2 = super.a;
            this.b = new androidx.emoji2.text.h(c, i, a, a2.h, a2.i);
            super.a.n();
        }
    }
    
    public abstract static class h
    {
        public abstract void a(final Throwable p0);
        
        public abstract void b(final m p0);
    }
    
    private static class b
    {
        final e a;
        
        b(final e a) {
            this.a = a;
        }
        
        void a() {
            throw null;
        }
        
        CharSequence b(final CharSequence charSequence, final int n, final int n2, final int n3, final boolean b) {
            throw null;
        }
        
        void c(final EditorInfo editorInfo) {
            throw null;
        }
    }
    
    public abstract static class c
    {
        final g a;
        boolean b;
        boolean c;
        int[] d;
        Set<e> e;
        boolean f;
        int g;
        int h;
        d i;
        
        protected c(final g a) {
            this.g = -16711936;
            this.h = 0;
            this.i = new androidx.emoji2.text.d();
            androidx.core.util.h.h(a, "metadataLoader cannot be null.");
            this.a = a;
        }
        
        protected final g a() {
            return this.a;
        }
        
        public c b(final int h) {
            this.h = h;
            return this;
        }
    }
    
    public interface d
    {
        boolean a(final CharSequence p0, final int p1, final int p2, final int p3);
    }
    
    public abstract static class e
    {
        public void a(final Throwable t) {
        }
        
        public void b() {
        }
    }
    
    private static class f implements Runnable
    {
        private final List<e> a;
        private final Throwable b;
        private final int c;
        
        f(final e e, final int n) {
            this(Arrays.asList(androidx.core.util.h.h(e, "initCallback cannot be null")), n, null);
        }
        
        f(final Collection<e> collection, final int n) {
            this(collection, n, null);
        }
        
        f(final Collection<e> collection, final int c, final Throwable b) {
            androidx.core.util.h.h(collection, "initCallbacks cannot be null");
            this.a = new ArrayList<e>(collection);
            this.c = c;
            this.b = b;
        }
        
        @Override
        public void run() {
            final int size = this.a.size();
            final int c = this.c;
            int i = 0;
            final int n = 0;
            if (c != 1) {
                for (int j = n; j < size; ++j) {
                    this.a.get(j).a(this.b);
                }
            }
            else {
                while (i < size) {
                    this.a.get(i).b();
                    ++i;
                }
            }
        }
    }
    
    public interface g
    {
        void a(final h p0);
    }
    
    static class i
    {
        androidx.emoji2.text.i a(final androidx.emoji2.text.g g) {
            return new o(g);
        }
    }
}
