// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.app;

import java.util.Collection;
import androidx.collection.b;
import android.app.RemoteInput;
import androidx.core.graphics.drawable.IconCompat;
import android.app.Notification$Action$Builder;
import android.graphics.drawable.Icon;
import java.util.Iterator;
import android.app.Notification;
import android.net.Uri;
import android.text.TextUtils;
import android.os.Build$VERSION;
import java.util.ArrayList;
import android.os.Bundle;
import java.util.List;
import android.widget.RemoteViews;
import android.app.Notification$Builder;
import android.content.Context;

class m implements k
{
    private final Context a;
    private final Notification$Builder b;
    private final l.e c;
    private RemoteViews d;
    private RemoteViews e;
    private final List<Bundle> f;
    private final Bundle g;
    private int h;
    private RemoteViews i;
    
    m(final l.e c) {
        this.f = new ArrayList<Bundle>();
        this.g = new Bundle();
        this.c = c;
        this.a = c.a;
        final Notification$Builder b = new Notification$Builder(c.a, c.K);
        this.b = b;
        final Notification r = c.R;
        b.setWhen(r.when).setSmallIcon(r.icon, r.iconLevel).setContent(r.contentView).setTicker(r.tickerText, c.i).setVibrate(r.vibrate).setLights(r.ledARGB, r.ledOnMS, r.ledOffMS).setOngoing((r.flags & 0x2) != 0x0).setOnlyAlertOnce((r.flags & 0x8) != 0x0).setAutoCancel((r.flags & 0x10) != 0x0).setDefaults(r.defaults).setContentTitle(c.e).setContentText(c.f).setContentInfo(c.k).setContentIntent(c.g).setDeleteIntent(r.deleteIntent).setFullScreenIntent(c.h, (r.flags & 0x80) != 0x0).setLargeIcon(c.j).setNumber(c.l).setProgress(c.t, c.u, c.v);
        b.setSubText(c.q).setUsesChronometer(c.o).setPriority(c.m);
        final Iterator<l.a> iterator = c.b.iterator();
        while (iterator.hasNext()) {
            this.a(iterator.next());
        }
        final Bundle d = c.D;
        if (d != null) {
            this.g.putAll(d);
        }
        final int sdk_INT = Build$VERSION.SDK_INT;
        this.d = c.H;
        this.e = c.I;
        this.b.setShowWhen(c.n);
        this.b.setLocalOnly(c.z).setGroup(c.w).setGroupSummary(c.x).setSortKey(c.y);
        this.h = c.O;
        this.b.setCategory(c.C).setColor(c.E).setVisibility(c.F).setPublicVersion(c.G).setSound(r.sound, r.audioAttributes);
        List<String> list;
        if (sdk_INT < 28) {
            list = d(f(c.c), c.U);
        }
        else {
            list = c.U;
        }
        if (list != null && !list.isEmpty()) {
            final Iterator iterator2 = list.iterator();
            while (iterator2.hasNext()) {
                this.b.addPerson((String)iterator2.next());
            }
        }
        this.i = c.J;
        if (c.d.size() > 0) {
            Bundle bundle;
            if ((bundle = c.c().getBundle("android.car.EXTENSIONS")) == null) {
                bundle = new Bundle();
            }
            final Bundle bundle2 = new Bundle(bundle);
            final Bundle bundle3 = new Bundle();
            for (int i = 0; i < c.d.size(); ++i) {
                bundle3.putBundle(Integer.toString(i), n.a(c.d.get(i)));
            }
            bundle.putBundle("invisible_actions", bundle3);
            bundle2.putBundle("invisible_actions", bundle3);
            c.c().putBundle("android.car.EXTENSIONS", bundle);
            this.g.putBundle("android.car.EXTENSIONS", bundle2);
        }
        final int sdk_INT2 = Build$VERSION.SDK_INT;
        final Icon t = c.T;
        if (t != null) {
            this.b.setSmallIcon(t);
        }
        this.b.setExtras(c.D).setRemoteInputHistory(c.s);
        final RemoteViews h = c.H;
        if (h != null) {
            this.b.setCustomContentView(h);
        }
        final RemoteViews j = c.I;
        if (j != null) {
            this.b.setCustomBigContentView(j);
        }
        final RemoteViews k = c.J;
        if (k != null) {
            this.b.setCustomHeadsUpContentView(k);
        }
        this.b.setBadgeIconType(c.L).setSettingsText(c.r).setShortcutId(c.M).setTimeoutAfter(c.N).setGroupAlertBehavior(c.O);
        if (c.B) {
            this.b.setColorized(c.A);
        }
        if (!TextUtils.isEmpty((CharSequence)c.K)) {
            this.b.setSound((Uri)null).setDefaults(0).setLights(0, 0, 0).setVibrate((long[])null);
        }
        if (sdk_INT2 >= 28) {
            final Iterator<r> iterator3 = c.c.iterator();
            while (iterator3.hasNext()) {
                this.b.addPerson(iterator3.next().h());
            }
        }
        final int sdk_INT3 = Build$VERSION.SDK_INT;
        if (sdk_INT3 >= 29) {
            this.b.setAllowSystemGeneratedContextualActions(c.Q);
            this.b.setBubbleMetadata(l.d.a(null));
        }
        if (sdk_INT3 >= 31) {
            final int p = c.P;
            if (p != 0) {
                this.b.setForegroundServiceBehavior(p);
            }
        }
        if (c.S) {
            if (this.c.x) {
                this.h = 2;
            }
            else {
                this.h = 1;
            }
            this.b.setVibrate((long[])null);
            this.b.setSound((Uri)null);
            final int n = r.defaults & 0xFFFFFFFE & 0xFFFFFFFD;
            r.defaults = n;
            this.b.setDefaults(n);
            if (TextUtils.isEmpty((CharSequence)this.c.w)) {
                this.b.setGroup("silent");
            }
            this.b.setGroupAlertBehavior(this.h);
        }
    }
    
    private void a(final l.a a) {
        final IconCompat d = a.d();
        Icon p;
        if (d != null) {
            p = d.p();
        }
        else {
            p = null;
        }
        final Notification$Action$Builder notification$Action$Builder = new Notification$Action$Builder(p, a.h(), a.a());
        if (a.e() != null) {
            final RemoteInput[] b = t.b(a.e());
            for (int length = b.length, i = 0; i < length; ++i) {
                notification$Action$Builder.addRemoteInput(b[i]);
            }
        }
        Bundle bundle;
        if (a.c() != null) {
            bundle = new Bundle(a.c());
        }
        else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", a.b());
        final int sdk_INT = Build$VERSION.SDK_INT;
        notification$Action$Builder.setAllowGeneratedReplies(a.b());
        bundle.putInt("android.support.action.semanticAction", a.f());
        if (sdk_INT >= 28) {
            notification$Action$Builder.setSemanticAction(a.f());
        }
        if (sdk_INT >= 29) {
            notification$Action$Builder.setContextual(a.j());
        }
        if (sdk_INT >= 31) {
            notification$Action$Builder.setAuthenticationRequired(a.i());
        }
        bundle.putBoolean("android.support.action.showsUserInterface", a.g());
        notification$Action$Builder.addExtras(bundle);
        this.b.addAction(notification$Action$Builder.build());
    }
    
    private static List<String> d(final List<String> list, final List<String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        final b b = new b(list.size() + list2.size());
        b.addAll(list);
        b.addAll(list2);
        return new ArrayList<String>(b);
    }
    
    private static List<String> f(final List<r> list) {
        if (list == null) {
            return null;
        }
        final ArrayList list2 = new ArrayList(list.size());
        final Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            list2.add(((r)iterator.next()).g());
        }
        return list2;
    }
    
    public Notification b() {
        final l.f p = this.c.p;
        if (p != null) {
            p.b(this);
        }
        RemoteViews e;
        if (p != null) {
            e = p.e(this);
        }
        else {
            e = null;
        }
        final Notification c = this.c();
        if (e != null) {
            c.contentView = e;
        }
        else {
            final RemoteViews h = this.c.H;
            if (h != null) {
                c.contentView = h;
            }
        }
        if (p != null) {
            final RemoteViews d = p.d(this);
            if (d != null) {
                c.bigContentView = d;
            }
        }
        if (p != null) {
            final RemoteViews f = this.c.p.f(this);
            if (f != null) {
                c.headsUpContentView = f;
            }
        }
        if (p != null) {
            final Bundle a = l.a(c);
            if (a != null) {
                p.a(a);
            }
        }
        return c;
    }
    
    protected Notification c() {
        return this.b.build();
    }
    
    Context e() {
        return this.a;
    }
    
    @Override
    public Notification$Builder getBuilder() {
        return this.b;
    }
}
