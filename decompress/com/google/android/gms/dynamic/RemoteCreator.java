// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.dynamic;

import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public abstract class RemoteCreator<T>
{
    private final String zza;
    private Object zzb;
    
    @KeepForSdk
    protected RemoteCreator(final String zza) {
        this.zza = zza;
    }
    
    @KeepForSdk
    protected abstract T getRemoteCreator(final IBinder p0);
    
    @KeepForSdk
    protected final T getRemoteCreatorInstance(Context e) throws RemoteCreatorException {
        if (this.zzb == null) {
            Preconditions.k(e);
            e = GooglePlayServicesUtilLight.e(e);
            if (e != null) {
                final ClassLoader classLoader = e.getClassLoader();
                try {
                    this.zzb = this.getRemoteCreator((IBinder)classLoader.loadClass(this.zza).newInstance());
                    return (T)this.zzb;
                }
                catch (final IllegalAccessException ex) {
                    throw new RemoteCreatorException("Could not access creator.", ex);
                }
                catch (final InstantiationException ex2) {
                    throw new RemoteCreatorException("Could not instantiate creator.", ex2);
                }
                catch (final ClassNotFoundException ex3) {
                    throw new RemoteCreatorException("Could not load creator class.", ex3);
                }
            }
            throw new RemoteCreatorException("Could not get remote context.");
        }
        return (T)this.zzb;
    }
    
    @KeepForSdk
    public static class RemoteCreatorException extends Exception
    {
        @KeepForSdk
        public RemoteCreatorException(final String s) {
            super(s);
        }
        
        @KeepForSdk
        public RemoteCreatorException(final String s, final Throwable t) {
            super(s, t);
        }
    }
}
