// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.annotations;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR })
@KeepForSdk
public @interface PublicApi {
}
