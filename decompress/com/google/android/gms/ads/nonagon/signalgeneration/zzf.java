// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.nonagon.signalgeneration;

import java.util.concurrent.Executor;
import com.google.android.gms.ads.internal.client.zzc;
import com.google.android.gms.internal.ads.zzfby;
import com.google.android.gms.internal.ads.zzcfv;
import com.google.android.gms.internal.ads.zzbhy;
import com.google.android.gms.ads.internal.client.zzay;
import android.util.Pair;
import com.google.android.gms.internal.ads.zzdwb;
import com.google.android.gms.internal.ads.zzdwl;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzl;
import android.text.TextUtils;

public final class zzf
{
    public static String a(final String s) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            return "unspecified";
        }
        int n = 0;
        Label_0179: {
            switch (s.hashCode()) {
                case 1743582869: {
                    if (s.equals("requester_type_7")) {
                        n = 7;
                        break Label_0179;
                    }
                    break;
                }
                case 1743582868: {
                    if (s.equals("requester_type_6")) {
                        n = 6;
                        break Label_0179;
                    }
                    break;
                }
                case 1743582867: {
                    if (s.equals("requester_type_5")) {
                        n = 5;
                        break Label_0179;
                    }
                    break;
                }
                case 1743582866: {
                    if (s.equals("requester_type_4")) {
                        n = 4;
                        break Label_0179;
                    }
                    break;
                }
                case 1743582865: {
                    if (s.equals("requester_type_3")) {
                        n = 3;
                        break Label_0179;
                    }
                    break;
                }
                case 1743582864: {
                    if (s.equals("requester_type_2")) {
                        n = 2;
                        break Label_0179;
                    }
                    break;
                }
                case 1743582863: {
                    if (s.equals("requester_type_1")) {
                        n = 1;
                        break Label_0179;
                    }
                    break;
                }
                case 1743582862: {
                    if (s.equals("requester_type_0")) {
                        n = 0;
                        break Label_0179;
                    }
                    break;
                }
            }
            n = -1;
        }
        switch (n) {
            default: {
                return s;
            }
            case 7: {
                return "7";
            }
            case 6: {
                return "6";
            }
            case 5: {
                return "5";
            }
            case 4: {
                return "4";
            }
            case 3: {
                return "3";
            }
            case 2: {
                return "2";
            }
            case 1: {
                return "1";
            }
            case 0: {
                return "0";
            }
        }
    }
    
    public static String b(final zzl zzl) {
        final Bundle c = zzl.c;
        if (c == null) {
            return "unspecified";
        }
        return c.getString("query_info_type");
    }
    
    public static void c(final zzdwl zzdwl, final zzdwb zzdwb, final String s, final Pair... array) {
        if (!(boolean)zzay.c().zzb(zzbhy.zzfW)) {
            return;
        }
        ((Executor)zzcfv.zza).execute(new zze(zzdwl, zzdwb, s, array));
    }
    
    public static int d(final zzfby zzfby) {
        if (zzfby.zzq) {
            return 2;
        }
        final zzl zzd = zzfby.zzd;
        final zzc d = zzd.D;
        if (d == null && zzd.I == null) {
            return 1;
        }
        if (d != null && zzd.I != null) {
            return 5;
        }
        if (d != null) {
            return 3;
        }
        return 4;
    }
}
