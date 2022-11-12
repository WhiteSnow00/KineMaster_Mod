// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.nonagon.signalgeneration;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzfva;
import org.json.JSONException;
import com.google.android.gms.ads.internal.client.zzaw;
import java.io.Reader;
import android.util.JsonReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import com.google.android.gms.internal.ads.zzfvj;
import com.google.android.gms.internal.ads.zzbzu;
import com.google.android.gms.internal.ads.zzfuh;

public final class zzai implements zzfuh
{
    public final zzbzu a;
    
    public zzai(final zzbzu a) {
        this.a = a;
    }
    
    public final zzfvj zza(Object o) {
        final zzbzu a = this.a;
        o = new zzal(new JsonReader((Reader)new InputStreamReader((InputStream)o)));
        final Bundle zza = a.zza;
        try {
            ((zzal)o).b = zzaw.b().zzg(zza).toString();
        }
        catch (final JSONException ex) {
            ((zzal)o).b = "{}";
        }
        return zzfva.zzi(o);
    }
}
