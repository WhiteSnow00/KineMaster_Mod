// 
// Decompiled by Procyon v0.6.0
// 

package androidx.browser.customtabs;

import android.os.Parcelable;
import android.app.PendingIntent;
import android.os.IBinder;
import android.util.SparseArray;
import java.util.ArrayList;
import androidx.core.content.a;
import android.net.Uri;
import android.content.Context;
import android.os.Bundle;
import android.content.Intent;

public final class d
{
    public final Intent a;
    public final Bundle b;
    
    d(final Intent a, final Bundle b) {
        this.a = a;
        this.b = b;
    }
    
    public void a(final Context context, final Uri data) {
        this.a.setData(data);
        androidx.core.content.a.startActivity(context, this.a, this.b);
    }
    
    public static final class a
    {
        private final Intent a;
        private final androidx.browser.customtabs.a.a b;
        private ArrayList<Bundle> c;
        private Bundle d;
        private ArrayList<Bundle> e;
        private SparseArray<Bundle> f;
        private Bundle g;
        private int h;
        private boolean i;
        
        public a() {
            this.a = new Intent("android.intent.action.VIEW");
            this.b = new androidx.browser.customtabs.a.a();
            this.h = 0;
            this.i = true;
        }
        
        public a(final f f) {
            this.a = new Intent("android.intent.action.VIEW");
            this.b = new androidx.browser.customtabs.a.a();
            this.h = 0;
            this.i = true;
            if (f != null) {
                this.b(f);
            }
        }
        
        private void c(final IBinder binder, final PendingIntent pendingIntent) {
            final Bundle bundle = new Bundle();
            androidx.core.app.f.b(bundle, "android.support.customtabs.extra.SESSION", binder);
            if (pendingIntent != null) {
                bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", (Parcelable)pendingIntent);
            }
            this.a.putExtras(bundle);
        }
        
        public d a() {
            if (!this.a.hasExtra("android.support.customtabs.extra.SESSION")) {
                this.c(null, null);
            }
            final ArrayList<Bundle> c = this.c;
            if (c != null) {
                this.a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", (ArrayList)c);
            }
            final ArrayList<Bundle> e = this.e;
            if (e != null) {
                this.a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", (ArrayList)e);
            }
            this.a.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.i);
            this.a.putExtras(this.b.a().a());
            final Bundle g = this.g;
            if (g != null) {
                this.a.putExtras(g);
            }
            if (this.f != null) {
                final Bundle bundle = new Bundle();
                bundle.putSparseParcelableArray("androidx.browser.customtabs.extra.COLOR_SCHEME_PARAMS", (SparseArray)this.f);
                this.a.putExtras(bundle);
            }
            this.a.putExtra("androidx.browser.customtabs.extra.SHARE_STATE", this.h);
            return new d(this.a, this.d);
        }
        
        public a b(final f f) {
            this.a.setPackage(f.b().getPackageName());
            this.c(f.a(), f.c());
            return this;
        }
        
        public a d(final boolean b) {
            this.a.putExtra("android.support.customtabs.extra.TITLE_VISIBILITY", (int)(b ? 1 : 0));
            return this;
        }
        
        @Deprecated
        public a e(final int n) {
            this.b.b(n);
            return this;
        }
    }
}
