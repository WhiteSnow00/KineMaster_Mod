// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.errorprone.annotations.RestrictedInheritance;
import com.google.errorprone.annotations.DoNotMock;
import com.google.android.gms.common.api.HasApiKey;

@DoNotMock
@RestrictedInheritance(allowedOnPath = ".*java.*/com/google/android/gms.*", explanation = "Use canonical fakes instead.", link = "go/gmscore-restrictedinheritance")
@KeepForSdk
public interface TelemetryLoggingClient extends HasApiKey<TelemetryLoggingOptions>
{
    @KeepForSdk
    Task<Void> a(final TelemetryData p0);
}
