// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import android.net.Uri;
import com.google.android.gms.ads.internal.zzt;
import android.content.DialogInterface;
import android.content.DialogInterface$OnClickListener;

final class c implements DialogInterface$OnClickListener
{
    final d a;
    
    c(final d a) {
        this.a = a;
    }
    
    public final void onClick(final DialogInterface dialogInterface, final int n) {
        zzt.q();
        zzs.p(this.a.a, Uri.parse("https://support.google.com/dfp_premium/answer/7160685#push"));
    }
}
