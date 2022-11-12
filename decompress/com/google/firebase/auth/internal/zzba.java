// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth.internal;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.android.gms.common.internal.Preconditions;
import android.text.TextUtils;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.android.gms.internal.firebase-auth-api.zzwu;

public final class zzba
{
    @Nullable
    public static MultiFactorInfo a(final zzwu zzwu) {
        MultiFactorInfo multiFactorInfo = null;
        if (zzwu == null) {
            return null;
        }
        if (!TextUtils.isEmpty((CharSequence)((com.google.android.gms.internal.firebase_auth_api.zzwu)zzwu).zze())) {
            multiFactorInfo = new PhoneMultiFactorInfo(((com.google.android.gms.internal.firebase_auth_api.zzwu)zzwu).zzd(), ((com.google.android.gms.internal.firebase_auth_api.zzwu)zzwu).zzc(), ((com.google.android.gms.internal.firebase_auth_api.zzwu)zzwu).zza(), Preconditions.g(((com.google.android.gms.internal.firebase_auth_api.zzwu)zzwu).zze()));
        }
        return multiFactorInfo;
    }
    
    public static List b(final List list) {
        if (list != null && !list.isEmpty()) {
            final ArrayList list2 = new ArrayList();
            final Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                final MultiFactorInfo a = a((zzwu)iterator.next());
                if (a != null) {
                    list2.add(a);
                }
            }
            return list2;
        }
        return new ArrayList();
    }
}
