// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common;

import com.google.android.gms.dynamic.IObjectWrapper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.common.internal.zzz;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzy;

abstract class h extends zzy
{
    private final int a;
    
    protected h(final byte[] array) {
        Preconditions.a(array.length == 25);
        this.a = Arrays.hashCode(array);
    }
    
    protected static byte[] p1(final String s) {
        try {
            return s.getBytes("ISO-8859-1");
        }
        catch (final UnsupportedEncodingException ex) {
            throw new AssertionError((Object)ex);
        }
    }
    
    public final boolean equals(final Object o) {
        if (o != null) {
            if (o instanceof zzz) {
                try {
                    final zzz zzz = (zzz)o;
                    if (zzz.zzc() != this.a) {
                        return false;
                    }
                    final IObjectWrapper zzd = zzz.zzd();
                    return zzd != null && Arrays.equals(this.q1(), (byte[])ObjectWrapper.p1(zzd));
                }
                catch (final RemoteException ex) {
                    Log.e("GoogleCertificates", "Failed to get Google certificates from remote", (Throwable)ex);
                }
            }
        }
        return false;
    }
    
    public final int hashCode() {
        return this.a;
    }
    
    abstract byte[] q1();
    
    public final int zzc() {
        return this.a;
    }
    
    public final IObjectWrapper zzd() {
        return ObjectWrapper.q1(this.q1());
    }
}
