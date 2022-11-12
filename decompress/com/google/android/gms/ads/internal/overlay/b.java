// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.overlay;

import android.os.Handler;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import com.google.android.gms.ads.internal.util.zzs;
import android.graphics.drawable.BitmapDrawable;
import android.renderscript.Allocation;
import android.renderscript.ScriptIntrinsicBlur;
import android.renderscript.Element;
import android.content.Context;
import android.renderscript.RenderScript;
import android.graphics.Bitmap;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.ads.internal.util.zzb;

final class b extends zzb
{
    final zzl a;
    
    b(final zzl a, final zzj zzj) {
        this.a = a;
    }
    
    @Override
    public final void zza() {
        final Bitmap a = zzt.v().a(this.a.b.z.f);
        if (a != null) {
            zzt.q();
            final zzl a2 = this.a;
            final Activity a3 = a2.a;
            final com.google.android.gms.ads.internal.zzj z = a2.b.z;
            final boolean d = z.d;
            final float e = z.e;
            BitmapDrawable bitmapDrawable;
            if (d && e > 0.0f && e <= 25.0f) {
                try {
                    final Bitmap scaledBitmap = Bitmap.createScaledBitmap(a, a.getWidth(), a.getHeight(), false);
                    final Bitmap bitmap = Bitmap.createBitmap(scaledBitmap);
                    final RenderScript create = RenderScript.create((Context)a3);
                    final ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
                    final Allocation fromBitmap = Allocation.createFromBitmap(create, scaledBitmap);
                    final Allocation fromBitmap2 = Allocation.createFromBitmap(create, bitmap);
                    create2.setRadius(e);
                    create2.setInput(fromBitmap);
                    create2.forEach(fromBitmap2);
                    fromBitmap2.copyTo(bitmap);
                    bitmapDrawable = new BitmapDrawable(((Context)a3).getResources(), bitmap);
                }
                catch (final RuntimeException ex) {
                    bitmapDrawable = new BitmapDrawable(((Context)a3).getResources(), a);
                }
            }
            else {
                bitmapDrawable = new BitmapDrawable(((Context)a3).getResources(), a);
            }
            ((Handler)zzs.i).post((Runnable)new zzi(this, (Drawable)bitmapDrawable));
        }
    }
}
