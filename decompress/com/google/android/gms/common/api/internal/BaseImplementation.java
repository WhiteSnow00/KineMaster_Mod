// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class BaseImplementation
{
    @KeepForSdk
    public abstract static class ApiMethodImpl<R extends Result, A extends Api.AnyClient> extends BasePendingResult<R> implements ResultHolder<R>
    {
        @KeepForSdk
        private final Api.AnyClientKey<A> r;
        @KeepForSdk
        private final Api<?> s;
        
        @KeepForSdk
        protected ApiMethodImpl(final Api<?> s, final GoogleApiClient googleApiClient) {
            super(Preconditions.l(googleApiClient, "GoogleApiClient must not be null"));
            Preconditions.l(s, "Api must not be null");
            this.r = (Api.AnyClientKey<A>)s.b();
            this.s = s;
        }
        
        @KeepForSdk
        private void v(final RemoteException ex) {
            this.w(new Status(8, ex.getLocalizedMessage(), null));
        }
        
        @KeepForSdk
        @Override
        public /* bridge */ void a(final Object o) {
            super.i((R)o);
        }
        
        @KeepForSdk
        protected abstract void q(final A p0) throws RemoteException;
        
        @KeepForSdk
        public final Api<?> r() {
            return this.s;
        }
        
        @KeepForSdk
        public final Api.AnyClientKey<A> s() {
            return this.r;
        }
        
        @KeepForSdk
        protected void t(final R r) {
        }
        
        @KeepForSdk
        public final void u(final A a) throws DeadObjectException {
            try {
                this.q(a);
            }
            catch (final RemoteException ex) {
                this.v(ex);
            }
            catch (final DeadObjectException ex2) {
                this.v((RemoteException)ex2);
                throw ex2;
            }
        }
        
        @KeepForSdk
        public final void w(final Status status) {
            Preconditions.b(status.P1() ^ true, "Failed result must not be success");
            final Result e = this.e(status);
            this.i((R)e);
            this.t((R)e);
        }
    }
    
    @KeepForSdk
    public interface ResultHolder<R>
    {
        @KeepForSdk
        void a(final R p0);
    }
}
