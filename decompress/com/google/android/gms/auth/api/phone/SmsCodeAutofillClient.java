// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.phone;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.HasApiKey;

public interface SmsCodeAutofillClient extends HasApiKey<Api.ApiOptions.NoOptions>
{
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_PARAMETER, ElementType.TYPE_USE })
    public @interface PermissionState {
    }
}
