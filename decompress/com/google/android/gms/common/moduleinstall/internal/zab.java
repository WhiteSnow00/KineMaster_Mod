// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.moduleinstall.internal;

import android.os.Parcelable$Creator;
import com.google.android.gms.common.Feature;
import java.util.Comparator;

public final class zab implements Comparator
{
    public static final zab a;
    
    static {
        a = new zab();
    }
    
    private zab() {
    }
    
    @Override
    public final int compare(final Object o, final Object o2) {
        final Feature feature = (Feature)o;
        final Feature feature2 = (Feature)o2;
        final Parcelable$Creator<ApiFeatureRequest> creator = ApiFeatureRequest.CREATOR;
        long compareTo;
        if (!feature.K1().equals(feature2.K1())) {
            compareTo = feature.K1().compareTo(feature2.K1());
        }
        else {
            compareTo = lcmp(feature.L1(), feature2.L1());
        }
        return (int)compareTo;
    }
}
