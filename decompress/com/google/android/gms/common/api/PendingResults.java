// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.api.internal.OptionalPendingResultImpl;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;

public final class PendingResults
{
    private PendingResults() {
    }
    
    @KeepForSdk
    public static <R extends Result> PendingResult<R> a(final R r, final GoogleApiClient googleApiClient) {
        Preconditions.l(r, "Result must not be null");
        Preconditions.b(r.getStatus().P1() ^ true, "Status code must not be SUCCESS");
        final a a = new a(googleApiClient, r);
        a.i(r);
        return a;
    }
    
    @KeepForSdk
    public static <R extends Result> OptionalPendingResult<R> b(final R r, final GoogleApiClient googleApiClient) {
        Preconditions.l(r, "Result must not be null");
        final b b = new b(googleApiClient);
        b.i(r);
        return new OptionalPendingResultImpl<R>(b);
    }
    
    @KeepForSdk
    public static PendingResult<Status> c(final Status status, final GoogleApiClient googleApiClient) {
        Preconditions.l(status, "Result must not be null");
        final StatusPendingResult statusPendingResult = new StatusPendingResult(googleApiClient);
        statusPendingResult.i(status);
        return statusPendingResult;
    }
}
