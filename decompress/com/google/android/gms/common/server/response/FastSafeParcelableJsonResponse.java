// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.server.response;

import android.os.Parcelable;
import android.os.Parcel;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Iterator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@KeepForSdk
@ShowFirstParty
public abstract class FastSafeParcelableJsonResponse extends FastJsonResponse implements SafeParcelable
{
    @KeepForSdk
    public FastSafeParcelableJsonResponse() {
    }
    
    public final int describeContents() {
        return 0;
    }
    
    @KeepForSdk
    @Override
    public boolean equals(final Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (!this.getClass().isInstance(o)) {
            return false;
        }
        final FastJsonResponse fastJsonResponse = (FastJsonResponse)o;
        for (final FastJsonResponse.Field field : this.getFieldMappings().values()) {
            if (this.isFieldSet(field)) {
                if (!fastJsonResponse.isFieldSet(field) || !Objects.b(this.getFieldValue(field), fastJsonResponse.getFieldValue(field))) {
                    return false;
                }
                continue;
            }
            else {
                if (fastJsonResponse.isFieldSet(field)) {
                    return false;
                }
                continue;
            }
        }
        return true;
    }
    
    @VisibleForTesting
    public Object getValueObject(final String s) {
        return null;
    }
    
    @KeepForSdk
    @Override
    public int hashCode() {
        final Iterator<FastJsonResponse.Field<?, ?>> iterator = this.getFieldMappings().values().iterator();
        int n = 0;
        while (iterator.hasNext()) {
            final FastJsonResponse.Field field = iterator.next();
            if (this.isFieldSet(field)) {
                n = n * 31 + Preconditions.k(this.getFieldValue(field)).hashCode();
            }
        }
        return n;
    }
    
    @VisibleForTesting
    public boolean isPrimitiveFieldSet(final String s) {
        return false;
    }
    
    @KeepForSdk
    public byte[] toByteArray() {
        final Parcel obtain = Parcel.obtain();
        ((Parcelable)this).writeToParcel(obtain, 0);
        final byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }
}
