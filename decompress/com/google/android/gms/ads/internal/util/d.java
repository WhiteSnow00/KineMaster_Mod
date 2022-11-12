// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import android.content.DialogInterface$OnClickListener;
import android.app.AlertDialog$Builder;
import android.content.Context;

final class d implements Runnable
{
    final Context a;
    final String b;
    final boolean c;
    final boolean d;
    
    d(final zzaw zzaw, final Context a, final String b, final boolean c, final boolean d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    @Override
    public final void run() {
        final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder(this.a);
        alertDialog$Builder.setMessage((CharSequence)this.b);
        if (this.c) {
            alertDialog$Builder.setTitle((CharSequence)"Error");
        }
        else {
            alertDialog$Builder.setTitle((CharSequence)"Info");
        }
        if (this.d) {
            alertDialog$Builder.setNeutralButton((CharSequence)"Dismiss", (DialogInterface$OnClickListener)null);
        }
        else {
            alertDialog$Builder.setPositiveButton((CharSequence)"Learn More", (DialogInterface$OnClickListener)new c(this));
            alertDialog$Builder.setNegativeButton((CharSequence)"Dismiss", (DialogInterface$OnClickListener)null);
        }
        alertDialog$Builder.create().show();
    }
}
