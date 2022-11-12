// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.moduleinstall;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import com.google.android.gms.common.annotation.KeepForSdk;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
public class ModuleInstallStatusUpdate extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<ModuleInstallStatusUpdate> CREATOR;
    @Field
    private final int a;
    @Field
    @InstallState
    private final int b;
    @Field
    private final Long c;
    @Field
    private final Long d;
    @Field
    private final int e;
    private final ProgressInfo f;
    
    static {
        CREATOR = (Parcelable$Creator)new zae();
    }
    
    @KeepForSdk
    @Constructor
    public ModuleInstallStatusUpdate(@Param final int a, @Param @InstallState final int b, @Param final Long c, @Param final Long d, @Param final int e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        ProgressInfo f;
        if (c != null && d != null && d != 0L) {
            f = new ProgressInfo(c, d);
        }
        else {
            f = null;
        }
        this.f = f;
    }
    
    public int K1() {
        return this.e;
    }
    
    @InstallState
    public int L1() {
        return this.b;
    }
    
    public int M1() {
        return this.a;
    }
    
    public void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 1, this.M1());
        SafeParcelWriter.s(parcel, 2, this.L1());
        SafeParcelWriter.x(parcel, 3, this.c, false);
        SafeParcelWriter.x(parcel, 4, this.d, false);
        SafeParcelWriter.s(parcel, 5, this.K1());
        SafeParcelWriter.b(parcel, a);
    }
    
    @Retention(RetentionPolicy.CLASS)
    public @interface InstallState {
    }
    
    public static class ProgressInfo
    {
        private final long a;
        private final long b;
        
        ProgressInfo(final long a, final long b) {
            Preconditions.n(b);
            this.a = a;
            this.b = b;
        }
    }
}
