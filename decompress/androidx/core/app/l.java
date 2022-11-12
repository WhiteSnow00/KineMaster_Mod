// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.app;

import android.media.AudioAttributes$Builder;
import android.net.Uri;
import v.b;
import java.util.ArrayList;
import android.app.Notification$BubbleMetadata;
import android.app.Notification$BigTextStyle;
import android.widget.RemoteViews;
import android.graphics.drawable.Icon;
import android.content.Context;
import android.app.Notification$BigPictureStyle;
import android.os.Build$VERSION;
import android.graphics.Bitmap;
import android.content.res.Resources;
import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import android.os.Bundle;
import android.app.Notification;

public class l
{
    public static Bundle a(final Notification notification) {
        return notification.extras;
    }
    
    public static class a
    {
        final Bundle a;
        private IconCompat b;
        private final t[] c;
        private final t[] d;
        private boolean e;
        boolean f;
        private final int g;
        private final boolean h;
        @Deprecated
        public int i;
        public CharSequence j;
        public PendingIntent k;
        private boolean l;
        
        public a(final int n, final CharSequence charSequence, final PendingIntent pendingIntent) {
            IconCompat h = null;
            if (n != 0) {
                h = IconCompat.h(null, "", n);
            }
            this(h, charSequence, pendingIntent);
        }
        
        public a(final IconCompat iconCompat, final CharSequence charSequence, final PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), null, null, true, 0, true, false, false);
        }
        
        a(final IconCompat b, final CharSequence charSequence, final PendingIntent k, Bundle a, final t[] c, final t[] d, final boolean e, final int g, final boolean f, final boolean h, final boolean l) {
            this.f = true;
            this.b = b;
            if (b != null && b.k() == 2) {
                this.i = b.i();
            }
            this.j = e.d(charSequence);
            this.k = k;
            if (a == null) {
                a = new Bundle();
            }
            this.a = a;
            this.c = c;
            this.d = d;
            this.e = e;
            this.g = g;
            this.f = f;
            this.h = h;
            this.l = l;
        }
        
        public PendingIntent a() {
            return this.k;
        }
        
        public boolean b() {
            return this.e;
        }
        
        public Bundle c() {
            return this.a;
        }
        
        public IconCompat d() {
            if (this.b == null) {
                final int i = this.i;
                if (i != 0) {
                    this.b = IconCompat.h(null, "", i);
                }
            }
            return this.b;
        }
        
        public t[] e() {
            return this.c;
        }
        
        public int f() {
            return this.g;
        }
        
        public boolean g() {
            return this.f;
        }
        
        public CharSequence h() {
            return this.j;
        }
        
        public boolean i() {
            return this.l;
        }
        
        public boolean j() {
            return this.h;
        }
    }
    
    public static class b extends f
    {
        private Bitmap e;
        private IconCompat f;
        private boolean g;
        private CharSequence h;
        private boolean i;
        
        @Override
        public void b(final k k) {
            final int sdk_INT = Build$VERSION.SDK_INT;
            final Notification$BigPictureStyle bigPicture = new Notification$BigPictureStyle(k.getBuilder()).setBigContentTitle(super.b).bigPicture(this.e);
            if (this.g) {
                final IconCompat f = this.f;
                Context e = null;
                if (f == null) {
                    a.a(bigPicture, null);
                }
                else {
                    if (k instanceof m) {
                        e = ((m)k).e();
                    }
                    l.b.b.a(bigPicture, this.f.q(e));
                }
            }
            if (super.d) {
                a.b(bigPicture, super.c);
            }
            if (sdk_INT >= 31) {
                c.b(bigPicture, this.i);
                c.a(bigPicture, this.h);
            }
        }
        
        @Override
        protected String c() {
            return "androidx.core.app.NotificationCompat$BigPictureStyle";
        }
        
        public l.b h(final Bitmap bitmap) {
            IconCompat e;
            if (bitmap == null) {
                e = null;
            }
            else {
                e = IconCompat.e(bitmap);
            }
            this.f = e;
            this.g = true;
            return this;
        }
        
        public l.b i(final Bitmap e) {
            this.e = e;
            return this;
        }
        
        private static class a
        {
            static void a(final Notification$BigPictureStyle notification$BigPictureStyle, final Bitmap bitmap) {
                notification$BigPictureStyle.bigLargeIcon(bitmap);
            }
            
            static void b(final Notification$BigPictureStyle notification$BigPictureStyle, final CharSequence summaryText) {
                notification$BigPictureStyle.setSummaryText(summaryText);
            }
        }
        
        private static class b
        {
            static void a(final Notification$BigPictureStyle notification$BigPictureStyle, final Icon icon) {
                notification$BigPictureStyle.bigLargeIcon(icon);
            }
        }
        
        private static class c
        {
            static void a(final Notification$BigPictureStyle notification$BigPictureStyle, final CharSequence contentDescription) {
                notification$BigPictureStyle.setContentDescription(contentDescription);
            }
            
            static void b(final Notification$BigPictureStyle notification$BigPictureStyle, final boolean b) {
                notification$BigPictureStyle.showBigPictureWhenCollapsed(b);
            }
        }
    }
    
    public abstract static class f
    {
        protected e a;
        CharSequence b;
        CharSequence c;
        boolean d;
        
        public f() {
            this.d = false;
        }
        
        public void a(final Bundle bundle) {
            if (this.d) {
                bundle.putCharSequence("android.summaryText", this.c);
            }
            final CharSequence b = this.b;
            if (b != null) {
                bundle.putCharSequence("android.title.big", b);
            }
            final String c = this.c();
            if (c != null) {
                bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", c);
            }
        }
        
        public abstract void b(final k p0);
        
        protected abstract String c();
        
        public RemoteViews d(final k k) {
            return null;
        }
        
        public RemoteViews e(final k k) {
            return null;
        }
        
        public RemoteViews f(final k k) {
            return null;
        }
        
        public void g(final e a) {
            if (this.a != a && (this.a = a) != null) {
                a.w(this);
            }
        }
    }
    
    public static class c extends f
    {
        private CharSequence e;
        
        @Override
        public void a(final Bundle bundle) {
            super.a(bundle);
        }
        
        @Override
        public void b(final k k) {
            final Notification$BigTextStyle bigText = new Notification$BigTextStyle(k.getBuilder()).setBigContentTitle(super.b).bigText(this.e);
            if (super.d) {
                bigText.setSummaryText(super.c);
            }
        }
        
        @Override
        protected String c() {
            return "androidx.core.app.NotificationCompat$BigTextStyle";
        }
        
        public c h(final CharSequence charSequence) {
            this.e = l.e.d(charSequence);
            return this;
        }
    }
    
    public static final class d
    {
        public static Notification$BubbleMetadata a(final d d) {
            return null;
        }
    }
    
    public static class e
    {
        boolean A;
        boolean B;
        String C;
        Bundle D;
        int E;
        int F;
        Notification G;
        RemoteViews H;
        RemoteViews I;
        RemoteViews J;
        String K;
        int L;
        String M;
        long N;
        int O;
        int P;
        boolean Q;
        Notification R;
        boolean S;
        Icon T;
        @Deprecated
        public ArrayList<String> U;
        public Context a;
        public ArrayList<a> b;
        public ArrayList<r> c;
        ArrayList<a> d;
        CharSequence e;
        CharSequence f;
        PendingIntent g;
        PendingIntent h;
        RemoteViews i;
        Bitmap j;
        CharSequence k;
        int l;
        int m;
        boolean n;
        boolean o;
        f p;
        CharSequence q;
        CharSequence r;
        CharSequence[] s;
        int t;
        int u;
        boolean v;
        String w;
        boolean x;
        String y;
        boolean z;
        
        @Deprecated
        public e(final Context context) {
            this(context, null);
        }
        
        public e(final Context a, final String k) {
            this.b = new ArrayList<a>();
            this.c = new ArrayList<r>();
            this.d = new ArrayList<a>();
            this.n = true;
            this.z = false;
            this.E = 0;
            this.F = 0;
            this.L = 0;
            this.O = 0;
            this.P = 0;
            final Notification r = new Notification();
            this.R = r;
            this.a = a;
            this.K = k;
            r.when = System.currentTimeMillis();
            this.R.audioStreamType = -1;
            this.m = 0;
            this.U = new ArrayList<String>();
            this.Q = true;
        }
        
        protected static CharSequence d(final CharSequence charSequence) {
            if (charSequence == null) {
                return charSequence;
            }
            CharSequence subSequence = charSequence;
            if (charSequence.length() > 5120) {
                subSequence = charSequence.subSequence(0, 5120);
            }
            return subSequence;
        }
        
        private Bitmap e(final Bitmap bitmap) {
            Bitmap scaledBitmap = bitmap;
            if (bitmap != null) {
                if (Build$VERSION.SDK_INT >= 27) {
                    scaledBitmap = bitmap;
                }
                else {
                    final Resources resources = this.a.getResources();
                    final int dimensionPixelSize = resources.getDimensionPixelSize(v.b.b);
                    final int dimensionPixelSize2 = resources.getDimensionPixelSize(v.b.a);
                    if (bitmap.getWidth() <= dimensionPixelSize && bitmap.getHeight() <= dimensionPixelSize2) {
                        return bitmap;
                    }
                    final double min = Math.min(dimensionPixelSize / (double)Math.max(1, bitmap.getWidth()), dimensionPixelSize2 / (double)Math.max(1, bitmap.getHeight()));
                    scaledBitmap = Bitmap.createScaledBitmap(bitmap, (int)Math.ceil(bitmap.getWidth() * min), (int)Math.ceil(bitmap.getHeight() * min), true);
                }
            }
            return scaledBitmap;
        }
        
        private void n(final int n, final boolean b) {
            if (b) {
                final Notification r = this.R;
                r.flags |= n;
            }
            else {
                final Notification r2 = this.R;
                r2.flags &= ~n;
            }
        }
        
        public e A(final long when) {
            this.R.when = when;
            return this;
        }
        
        public e a(final int n, final CharSequence charSequence, final PendingIntent pendingIntent) {
            this.b.add(new a(n, charSequence, pendingIntent));
            return this;
        }
        
        public Notification b() {
            return new m(this).b();
        }
        
        public Bundle c() {
            if (this.D == null) {
                this.D = new Bundle();
            }
            return this.D;
        }
        
        public e f(final boolean b) {
            this.n(16, b);
            return this;
        }
        
        public e g(final String k) {
            this.K = k;
            return this;
        }
        
        public e h(final int e) {
            this.E = e;
            return this;
        }
        
        public e i(final PendingIntent g) {
            this.g = g;
            return this;
        }
        
        public e j(final CharSequence charSequence) {
            this.f = d(charSequence);
            return this;
        }
        
        public e k(final CharSequence charSequence) {
            this.e = d(charSequence);
            return this;
        }
        
        public e l(final int defaults) {
            final Notification r = this.R;
            r.defaults = defaults;
            if ((defaults & 0x4) != 0x0) {
                r.flags |= 0x1;
            }
            return this;
        }
        
        public e m(final PendingIntent deleteIntent) {
            this.R.deleteIntent = deleteIntent;
            return this;
        }
        
        public e o(final Bitmap bitmap) {
            this.j = this.e(bitmap);
            return this;
        }
        
        public e p(int ledARGB, final int ledOnMS, final int ledOffMS) {
            final Notification r = this.R;
            r.ledARGB = ledARGB;
            r.ledOnMS = ledOnMS;
            r.ledOffMS = ledOffMS;
            if (ledOnMS != 0 && ledOffMS != 0) {
                ledARGB = 1;
            }
            else {
                ledARGB = 0;
            }
            r.flags = (ledARGB | (r.flags & 0xFFFFFFFE));
            return this;
        }
        
        public e q(final boolean z) {
            this.z = z;
            return this;
        }
        
        public e r(final int l) {
            this.l = l;
            return this;
        }
        
        public e s(final int m) {
            this.m = m;
            return this;
        }
        
        public e t(final boolean n) {
            this.n = n;
            return this;
        }
        
        public e u(final int icon) {
            this.R.icon = icon;
            return this;
        }
        
        public e v(final Uri sound) {
            final Notification r = this.R;
            r.sound = sound;
            r.audioStreamType = -1;
            r.audioAttributes = new AudioAttributes$Builder().setContentType(4).setUsage(5).build();
            return this;
        }
        
        public e w(final f p) {
            if (this.p != p && (this.p = p) != null) {
                p.g(this);
            }
            return this;
        }
        
        public e x(final CharSequence charSequence) {
            this.R.tickerText = d(charSequence);
            return this;
        }
        
        public e y(final long[] vibrate) {
            this.R.vibrate = vibrate;
            return this;
        }
        
        public e z(final int f) {
            this.F = f;
            return this;
        }
    }
}
