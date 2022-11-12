// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import android.os.IInterface;
import android.util.Log;

public abstract class zzc
{
    private Object a;
    private boolean b;
    final BaseGmsClient c;
    
    public zzc(final BaseGmsClient c, final Object a) {
        this.c = c;
        this.a = a;
        this.b = false;
    }
    
    protected abstract void a(final Object p0);
    
    protected abstract void b();
    
    public final void c() {
        synchronized (this) {
            final Object a = this.a;
            if (this.b) {
                final String string = this.toString();
                final StringBuilder sb = new StringBuilder();
                sb.append("Callback proxy ");
                sb.append(string);
                sb.append(" being reused. This is not safe.");
                Log.w("GmsClient", sb.toString());
            }
            monitorexit(this);
            if (a != null) {
                try {
                    this.a(a);
                }
                catch (final RuntimeException ex) {
                    throw ex;
                }
            }
            synchronized (this) {
                this.b = true;
                monitorexit(this);
                this.e();
            }
        }
    }
    
    public final void d() {
        synchronized (this) {
            this.a = null;
        }
    }
    
    public final void e() {
        this.d();
        synchronized (BaseGmsClient.zzf((BaseGmsClient<IInterface>)this.c)) {
            BaseGmsClient.zzf((BaseGmsClient<IInterface>)this.c).remove(this);
        }
    }
}
