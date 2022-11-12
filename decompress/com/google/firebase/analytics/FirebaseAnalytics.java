// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.analytics;

import android.app.Activity;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.TimeUnit;
import com.google.firebase.installations.FirebaseInstallations;
import com.google.android.gms.measurement.internal.zzik;
import androidx.annotation.Keep;
import android.os.Bundle;
import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzee;

public final class FirebaseAnalytics
{
    private static volatile FirebaseAnalytics b;
    private final zzee a;
    
    public FirebaseAnalytics(final zzee a) {
        Preconditions.k(a);
        this.a = a;
    }
    
    @Keep
    public static FirebaseAnalytics getInstance(final Context context) {
        if (FirebaseAnalytics.b == null) {
            synchronized (FirebaseAnalytics.class) {
                if (FirebaseAnalytics.b == null) {
                    FirebaseAnalytics.b = new FirebaseAnalytics(zzee.zzg(context, (String)null, (String)null, (String)null, (Bundle)null));
                }
            }
        }
        return FirebaseAnalytics.b;
    }
    
    @Keep
    public static zzik getScionFrontendApiImplementation(final Context context, final Bundle bundle) {
        final zzee zzg = zzee.zzg(context, (String)null, (String)null, (String)null, bundle);
        if (zzg == null) {
            return null;
        }
        return (zzik)new a(zzg);
    }
    
    public void a(final String s, final Bundle bundle) {
        this.a.zzx(s, bundle);
    }
    
    public void b(final boolean b) {
        this.a.zzK(Boolean.valueOf(b));
    }
    
    public void c(final String s, final String s2) {
        this.a.zzN((String)null, s, (Object)s2, false);
    }
    
    @Keep
    public String getFirebaseInstanceId() {
        try {
            return (String)Tasks.b(FirebaseInstallations.n().getId(), 30000L, TimeUnit.MILLISECONDS);
        }
        catch (final InterruptedException ex) {
            throw new IllegalStateException(ex);
        }
        catch (final TimeoutException ex2) {
            throw new IllegalThreadStateException("Firebase Installations getId Task has timed out.");
        }
        catch (final ExecutionException ex3) {
            throw new IllegalStateException(ex3.getCause());
        }
    }
    
    @Deprecated
    @Keep
    public void setCurrentScreen(final Activity activity, final String s, final String s2) {
        this.a.zzG(activity, s, s2);
    }
    
    public enum ConsentStatus
    {
        DENIED("DENIED", 1), 
        GRANTED("GRANTED", 0);
        
        private static final ConsentStatus[] zza;
        
        private ConsentStatus(final String s, final int n) {
        }
    }
    
    public enum ConsentType
    {
        AD_STORAGE("AD_STORAGE", 0), 
        ANALYTICS_STORAGE("ANALYTICS_STORAGE", 1);
        
        private static final ConsentType[] zza;
        
        private ConsentType(final String s, final int n) {
        }
    }
    
    public static class Event
    {
        protected Event() {
        }
    }
    
    public static class Param
    {
        protected Param() {
        }
    }
    
    public static class UserProperty
    {
        protected UserProperty() {
        }
    }
}
