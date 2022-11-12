// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import com.google.android.gms.internal.ads.zzcfi;
import java.util.concurrent.TimeUnit;
import com.google.android.gms.internal.ads.zzaoc;
import android.os.AsyncTask;

final class e extends AsyncTask
{
    final zzs a;
    
    e(final zzs a, final zzp zzp) {
        this.a = a;
    }
    
    protected final String a(Void... a) {
        try {
            a = (ExecutionException)this.a;
            zzs.w1((zzs)a, (zzaoc)zzs.v1((zzs)a).get(1000L, TimeUnit.MILLISECONDS));
            return this.a.zzp();
        }
        catch (final TimeoutException ex) {
            zzcfi.zzk("", (Throwable)ex);
            return this.a.zzp();
        }
        catch (final ExecutionException a) {}
        catch (final InterruptedException ex2) {}
        zzcfi.zzk("", (Throwable)a);
        return this.a.zzp();
    }
    
    protected final /* bridge */ Object doInBackground(final Object[] array) {
        return this.a((Void[])array);
    }
    
    protected final /* bridge */ void onPostExecute(final Object o) {
        final String s = (String)o;
        final zzs a = this.a;
        if (zzs.q1(a) != null && s != null) {
            zzs.q1(a).loadUrl(s);
        }
    }
}
