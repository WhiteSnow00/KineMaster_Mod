// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common;

import java.util.List;
import com.google.android.gms.internal.common.zzag;
import java.util.HashMap;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.errorprone.annotations.RestrictedInheritance;

@RestrictedInheritance(allowedOnPath = ".*javatests/com/google/android/gmscore/integ/client/common/robolectric/.*", explanation = "Sub classing of GMS Core's APIs are restricted to testing fakes.", link = "go/gmscore-restrictedinheritance")
@KeepForSdk
@ShowFirstParty
public class GmsSignatureVerifier
{
    private static final b a;
    private static final b b;
    private static final HashMap c;
    
    static {
        final p p = new p();
        p.d("com.google.android.gms");
        p.a(204200000L);
        final j d = l.d;
        p.c((List)zzag.zzn((Object)d.q1(), (Object)l.b.q1()));
        final j c2 = l.c;
        p.b((List)zzag.zzn((Object)c2.q1(), (Object)l.a.q1()));
        a = p.e();
        final p p2 = new p();
        p2.d("com.android.vending");
        p2.a(82240000L);
        p2.c((List)zzag.zzm((Object)d.q1()));
        p2.b((List)zzag.zzm((Object)c2.q1()));
        b = p2.e();
        c = new HashMap();
    }
}
