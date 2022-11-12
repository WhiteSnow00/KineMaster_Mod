// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth.internal;

import com.google.android.gms.internal.firebase-auth-api.zzxb;
import com.google.firebase.auth.ActionCodeInfo;
import com.google.firebase.auth.ActionCodeResult;

public final class zzo implements ActionCodeResult
{
    private final int a;
    private final String b;
    private final String c;
    private final ActionCodeInfo d;
    
    public zzo(final zzxb zzxb) {
        String b;
        if (((com.google.android.gms.internal.firebase_auth_api.zzxb)zzxb).zzh()) {
            b = ((com.google.android.gms.internal.firebase_auth_api.zzxb)zzxb).zzd();
        }
        else {
            b = ((com.google.android.gms.internal.firebase_auth_api.zzxb)zzxb).zzc();
        }
        this.b = b;
        this.c = ((com.google.android.gms.internal.firebase_auth_api.zzxb)zzxb).zzc();
        final boolean zzi = ((com.google.android.gms.internal.firebase_auth_api.zzxb)zzxb).zzi();
        ActionCodeInfo d = null;
        if (!zzi) {
            this.a = 3;
            this.d = null;
            return;
        }
        final String zze = ((com.google.android.gms.internal.firebase_auth_api.zzxb)zzxb).zze();
        final int hashCode = zze.hashCode();
        int a = 0;
        int n = 0;
        Label_0235: {
            switch (hashCode) {
                case 970484929: {
                    if (zze.equals("RECOVER_EMAIL")) {
                        n = 4;
                        break Label_0235;
                    }
                    break;
                }
                case 870738373: {
                    if (zze.equals("EMAIL_SIGNIN")) {
                        n = 2;
                        break Label_0235;
                    }
                    break;
                }
                case -1099157829: {
                    if (zze.equals("VERIFY_AND_CHANGE_EMAIL")) {
                        n = 3;
                        break Label_0235;
                    }
                    break;
                }
                case -1341836234: {
                    if (zze.equals("VERIFY_EMAIL")) {
                        n = 1;
                        break Label_0235;
                    }
                    break;
                }
                case -1452371317: {
                    if (zze.equals("PASSWORD_RESET")) {
                        n = 0;
                        break Label_0235;
                    }
                    break;
                }
                case -1874510116: {
                    if (zze.equals("REVERT_SECOND_FACTOR_ADDITION")) {
                        n = 5;
                        break Label_0235;
                    }
                    break;
                }
            }
            n = -1;
        }
        if (n != 0) {
            if (n != 1) {
                if (n != 2) {
                    if (n != 3) {
                        if (n != 4) {
                            if (n != 5) {
                                a = 3;
                            }
                            else {
                                a = 6;
                            }
                        }
                        else {
                            a = 2;
                        }
                    }
                    else {
                        a = 5;
                    }
                }
                else {
                    a = 4;
                }
            }
            else {
                a = 1;
            }
        }
        this.a = a;
        if (a != 4 && a != 3) {
            if (((com.google.android.gms.internal.firebase_auth_api.zzxb)zzxb).zzg()) {
                d = new zzn(((com.google.android.gms.internal.firebase_auth_api.zzxb)zzxb).zzc(), zzba.a(((com.google.android.gms.internal.firebase_auth_api.zzxb)zzxb).zzb()));
            }
            else if (((com.google.android.gms.internal.firebase_auth_api.zzxb)zzxb).zzh()) {
                d = new zzl(((com.google.android.gms.internal.firebase_auth_api.zzxb)zzxb).zzd(), ((com.google.android.gms.internal.firebase_auth_api.zzxb)zzxb).zzc());
            }
            else if (((com.google.android.gms.internal.firebase_auth_api.zzxb)zzxb).zzf()) {
                d = new zzm(((com.google.android.gms.internal.firebase_auth_api.zzxb)zzxb).zzc());
            }
            this.d = d;
            return;
        }
        this.d = null;
    }
    
    public final int a() {
        return this.a;
    }
}
