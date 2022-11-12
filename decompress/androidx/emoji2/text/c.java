// 
// Decompiled by Procyon v0.6.0
// 

package androidx.emoji2.text;

import android.util.Log;
import androidx.core.util.h;
import java.util.Iterator;
import android.content.pm.ResolveInfo;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build$VERSION;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import android.content.pm.Signature;
import androidx.core.provider.e;
import android.content.Context;

public final class c
{
    public static j a(final Context context) {
        return (j)new a(null).c(context);
    }
    
    public static class a
    {
        private final b a;
        
        public a(b e) {
            if (e == null) {
                e = e();
            }
            this.a = e;
        }
        
        private androidx.emoji2.text.e.c a(final Context context, final e e) {
            if (e == null) {
                return null;
            }
            return new j(context, e);
        }
        
        private List<List<byte[]>> b(final Signature[] array) {
            final ArrayList list = new ArrayList();
            for (int length = array.length, i = 0; i < length; ++i) {
                list.add(array[i].toByteArray());
            }
            return (List<List<byte[]>>)Collections.singletonList(list);
        }
        
        private e d(final ProviderInfo providerInfo, final PackageManager packageManager) throws PackageManager$NameNotFoundException {
            final String authority = providerInfo.authority;
            final String packageName = providerInfo.packageName;
            return new e(authority, packageName, "emojicompat-emoji-font", this.b(this.a.b(packageManager, packageName)));
        }
        
        private static b e() {
            if (Build$VERSION.SDK_INT >= 28) {
                return new d();
            }
            return new c();
        }
        
        private boolean f(final ProviderInfo providerInfo) {
            boolean b = true;
            if (providerInfo != null) {
                final ApplicationInfo applicationInfo = providerInfo.applicationInfo;
                if (applicationInfo != null && (applicationInfo.flags & 0x1) == 0x1) {
                    return b;
                }
            }
            b = false;
            return b;
        }
        
        private ProviderInfo g(final PackageManager packageManager) {
            final Iterator<ResolveInfo> iterator = this.a.c(packageManager, new Intent("androidx.content.action.LOAD_EMOJI_FONT"), 0).iterator();
            while (iterator.hasNext()) {
                final ProviderInfo a = this.a.a(iterator.next());
                if (this.f(a)) {
                    return a;
                }
            }
            return null;
        }
        
        public androidx.emoji2.text.e.c c(final Context context) {
            return this.a(context, this.h(context));
        }
        
        e h(final Context context) {
            final PackageManager packageManager = context.getPackageManager();
            h.h(packageManager, "Package manager required to locate emoji font provider");
            final ProviderInfo g = this.g(packageManager);
            if (g == null) {
                return null;
            }
            try {
                return this.d(g, packageManager);
            }
            catch (final PackageManager$NameNotFoundException ex) {
                Log.wtf("emoji2.text.DefaultEmojiConfig", (Throwable)ex);
                return null;
            }
        }
    }
    
    public static class b
    {
        public ProviderInfo a(final ResolveInfo resolveInfo) {
            throw null;
        }
        
        public Signature[] b(final PackageManager packageManager, final String s) throws PackageManager$NameNotFoundException {
            return packageManager.getPackageInfo(s, 64).signatures;
        }
        
        public List<ResolveInfo> c(final PackageManager packageManager, final Intent intent, final int n) {
            throw null;
        }
    }
    
    public static class c extends b
    {
        @Override
        public ProviderInfo a(final ResolveInfo resolveInfo) {
            return resolveInfo.providerInfo;
        }
        
        @Override
        public List<ResolveInfo> c(final PackageManager packageManager, final Intent intent, final int n) {
            return packageManager.queryIntentContentProviders(intent, n);
        }
    }
    
    public static class d extends c
    {
        @Override
        public Signature[] b(final PackageManager packageManager, final String s) throws PackageManager$NameNotFoundException {
            return packageManager.getPackageInfo(s, 64).signatures;
        }
    }
}
