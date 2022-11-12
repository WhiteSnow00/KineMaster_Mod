// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal.safeparcel;

import android.os.Parcelable;

public interface SafeParcelable extends Parcelable
{
    public static final String NULL = "SAFE_PARCELABLE_NULL_STRING";
    
    public @interface Class {
    }
    
    public @interface Constructor {
    }
    
    public @interface Field {
    }
    
    public @interface Indicator {
    }
    
    public @interface Param {
    }
    
    public @interface RemovedParam {
    }
    
    public @interface Reserved {
    }
    
    public @interface VersionField {
    }
}
