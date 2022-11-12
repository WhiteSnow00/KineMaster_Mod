// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.cloudmessaging;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import android.content.Intent;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
public final class CloudMessage extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<CloudMessage> CREATOR;
    @Field
    Intent a;
    
    static {
        CREATOR = (Parcelable$Creator)new zza();
    }
    
    @Constructor
    public CloudMessage(@Param final Intent a) {
        this.a = a;
    }
    
    public Intent K1() {
        return this.a;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.A(parcel, 1, (Parcelable)this.a, n, false);
        SafeParcelWriter.b(parcel, a);
    }
    
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_PARAMETER, ElementType.TYPE_USE })
    public @interface MessagePriority {
    }
}
