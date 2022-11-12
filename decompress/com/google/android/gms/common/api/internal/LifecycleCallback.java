// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.content.Intent;
import com.google.android.gms.common.internal.Preconditions;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import androidx.annotation.Keep;
import android.app.Activity;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class LifecycleCallback
{
    @KeepForSdk
    protected final LifecycleFragment a;
    
    @KeepForSdk
    protected LifecycleCallback(final LifecycleFragment a) {
        this.a = a;
    }
    
    @KeepForSdk
    public static LifecycleFragment c(final Activity activity) {
        return d(new LifecycleActivity(activity));
    }
    
    @KeepForSdk
    protected static LifecycleFragment d(final LifecycleActivity lifecycleActivity) {
        if (lifecycleActivity.d()) {
            return zzd.i4(lifecycleActivity.b());
        }
        if (lifecycleActivity.c()) {
            return zzb.c(lifecycleActivity.a());
        }
        throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
    }
    
    @Keep
    private static LifecycleFragment getChimeraLifecycleFragmentImpl(final LifecycleActivity lifecycleActivity) {
        throw new IllegalStateException("Method not available in SDK.");
    }
    
    @KeepForSdk
    public void a(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
    }
    
    @KeepForSdk
    public Activity b() {
        final Activity t2 = this.a.T2();
        Preconditions.k(t2);
        return t2;
    }
    
    @KeepForSdk
    public void e(final int n, final int n2, final Intent intent) {
    }
    
    @KeepForSdk
    public void f(final Bundle bundle) {
    }
    
    @KeepForSdk
    public void g() {
    }
    
    @KeepForSdk
    public void h() {
    }
    
    @KeepForSdk
    public void i(final Bundle bundle) {
    }
    
    @KeepForSdk
    public void j() {
    }
    
    @KeepForSdk
    public void k() {
    }
}
