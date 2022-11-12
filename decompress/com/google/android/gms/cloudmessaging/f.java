// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.cloudmessaging;

import android.util.Log;
import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class f<T>
{
    final int a;
    final TaskCompletionSource<T> b;
    final int c;
    final Bundle d;
    
    f(final int a, final int c, final Bundle d) {
        this.b = (TaskCompletionSource<T>)new TaskCompletionSource();
        this.a = a;
        this.c = c;
        this.d = d;
    }
    
    abstract void a(final Bundle p0);
    
    abstract boolean b();
    
    final void c(final zzq zzq) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            final String value = String.valueOf(this);
            final String value2 = String.valueOf(zzq);
            final StringBuilder sb = new StringBuilder(value.length() + 14 + value2.length());
            sb.append("Failing ");
            sb.append(value);
            sb.append(" with ");
            sb.append(value2);
            Log.d("MessengerIpcClient", sb.toString());
        }
        this.b.b((Exception)zzq);
    }
    
    final void d(final T t) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            final String value = String.valueOf(this);
            final String value2 = String.valueOf(t);
            final StringBuilder sb = new StringBuilder(value.length() + 16 + value2.length());
            sb.append("Finishing ");
            sb.append(value);
            sb.append(" with ");
            sb.append(value2);
            Log.d("MessengerIpcClient", sb.toString());
        }
        this.b.c((Object)t);
    }
    
    @Override
    public final String toString() {
        final int c = this.c;
        final int a = this.a;
        final StringBuilder sb = new StringBuilder(55);
        sb.append("Request { what=");
        sb.append(c);
        sb.append(" id=");
        sb.append(a);
        sb.append(" oneWay=");
        sb.append(this.b());
        sb.append("}");
        return sb.toString();
    }
}
