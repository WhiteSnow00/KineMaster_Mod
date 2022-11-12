// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.scheduler;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import android.net.NetworkCapabilities;
import android.net.Network;
import com.google.android.exoplayer2.util.Util;
import android.os.PowerManager;
import android.content.Intent;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import com.google.android.exoplayer2.util.Assertions;
import android.net.ConnectivityManager;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public final class Requirements implements Parcelable
{
    public static final Parcelable$Creator<Requirements> CREATOR;
    private final int a;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<Requirements>() {
            public Requirements a(final Parcel parcel) {
                return new Requirements(parcel.readInt());
            }
            
            public Requirements[] b(final int n) {
                return new Requirements[n];
            }
            
            public /* bridge */ Object createFromParcel(final Parcel parcel) {
                return this.a(parcel);
            }
            
            public /* bridge */ Object[] newArray(final int n) {
                return this.b(n);
            }
        };
    }
    
    public Requirements(final int n) {
        int a = n;
        if ((n & 0x2) != 0x0) {
            a = (n | 0x1);
        }
        this.a = a;
    }
    
    private int b(final Context context) {
        if (!this.j()) {
            return 0;
        }
        final ConnectivityManager connectivityManager = Assertions.e(context.getSystemService("connectivity"));
        final NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected() || !i(connectivityManager)) {
            return this.a & 0x3;
        }
        if (this.m() && connectivityManager.isActiveNetworkMetered()) {
            return 2;
        }
        return 0;
    }
    
    private boolean f(final Context context) {
        final Intent registerReceiver = context.registerReceiver((BroadcastReceiver)null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean b = false;
        if (registerReceiver == null) {
            return false;
        }
        final int intExtra = registerReceiver.getIntExtra("status", -1);
        if (intExtra == 2 || intExtra == 5) {
            b = true;
        }
        return b;
    }
    
    private boolean g(final Context context) {
        final PowerManager powerManager = Assertions.e(context.getSystemService("power"));
        final int a = Util.a;
        boolean deviceIdleMode = true;
        if (a >= 23) {
            deviceIdleMode = powerManager.isDeviceIdleMode();
        }
        else {
            if (a >= 20) {
                if (!powerManager.isInteractive()) {
                    return deviceIdleMode;
                }
            }
            else if (!powerManager.isScreenOn()) {
                return deviceIdleMode;
            }
            deviceIdleMode = false;
        }
        return deviceIdleMode;
    }
    
    private static boolean i(final ConnectivityManager connectivityManager) {
        final int a = Util.a;
        boolean b = true;
        if (a < 24) {
            return true;
        }
        final Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null) {
            return false;
        }
        try {
            final NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
            if (networkCapabilities == null || !networkCapabilities.hasCapability(16)) {
                b = false;
            }
            return b;
        }
        catch (final SecurityException ex) {
            return b;
        }
    }
    
    private boolean k(final Context context) {
        return context.registerReceiver((BroadcastReceiver)null, new IntentFilter("android.intent.action.DEVICE_STORAGE_LOW")) == null;
    }
    
    public Requirements a(int n) {
        final int a = this.a;
        n &= a;
        Requirements requirements;
        if (n == a) {
            requirements = this;
        }
        else {
            requirements = new Requirements(n);
        }
        return requirements;
    }
    
    public int c(final Context context) {
        int b;
        final int n = b = this.b(context);
        if (this.e()) {
            b = n;
            if (!this.f(context)) {
                b = (n | 0x8);
            }
        }
        int n2 = b;
        if (this.h()) {
            n2 = b;
            if (!this.g(context)) {
                n2 = (b | 0x4);
            }
        }
        int n3 = n2;
        if (this.l()) {
            n3 = n2;
            if (!this.k(context)) {
                n3 = (n2 | 0x10);
            }
        }
        return n3;
    }
    
    public int d() {
        return this.a;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public boolean e() {
        return (this.a & 0x8) != 0x0;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && Requirements.class == o.getClass()) {
            if (this.a != ((Requirements)o).a) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    public boolean h() {
        return (this.a & 0x4) != 0x0;
    }
    
    @Override
    public int hashCode() {
        return this.a;
    }
    
    public boolean j() {
        final int a = this.a;
        boolean b = true;
        if ((a & 0x1) == 0x0) {
            b = false;
        }
        return b;
    }
    
    public boolean l() {
        return (this.a & 0x10) != 0x0;
    }
    
    public boolean m() {
        return (this.a & 0x2) != 0x0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeInt(this.a);
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE })
    public @interface RequirementFlags {
    }
}
