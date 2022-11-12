// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth.internal;

import android.util.Log;
import android.text.TextUtils;
import com.google.android.gms.safetynet.SafetyNetApi$AttestationResponse;

public final class zzbf
{
    private static final String a = "zzbf";
    
    private zzbf() {
    }
    
    public static boolean a(final SafetyNetApi$AttestationResponse safetyNetApi$AttestationResponse) {
        if (safetyNetApi$AttestationResponse == null || TextUtils.isEmpty((CharSequence)safetyNetApi$AttestationResponse.k())) {
            Log.e(zzbf.a, "No SafetyNet AttestationResponse passed.");
            return false;
        }
        final zzbe a = zzbe.a(safetyNetApi$AttestationResponse.k());
        if (a == null) {
            Log.e(zzbf.a, "Unable to parse SafetyNet AttestationResponse");
            return false;
        }
        if (!a.c()) {
            Log.e(zzbf.a, "SafetyNet Attestation fails basic integrity.");
            return false;
        }
        if (!TextUtils.isEmpty((CharSequence)a.b())) {
            Log.e(zzbf.a, "SafetyNet Attestation has advice: \n".concat(String.valueOf(a.b())));
            return false;
        }
        return true;
    }
}
