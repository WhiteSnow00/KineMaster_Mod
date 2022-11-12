// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads;

import org.json.JSONException;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.Iterator;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzcfi;
import com.google.android.gms.ads.internal.client.zzu;
import java.util.ArrayList;
import java.util.List;
import com.google.android.gms.ads.internal.client.zzdh;

public final class ResponseInfo
{
    private final zzdh a;
    private final List b;
    private AdapterResponseInfo c;
    
    private ResponseInfo(zzdh a) {
        this.a = a;
        this.b = new ArrayList();
        if (a != null) {
            try {
                final List zzi = a.zzi();
                if (zzi != null) {
                    final Iterator iterator = zzi.iterator();
                    while (iterator.hasNext()) {
                        final AdapterResponseInfo e = AdapterResponseInfo.e((zzu)iterator.next());
                        if (e != null) {
                            this.b.add(e);
                        }
                    }
                }
            }
            catch (final RemoteException ex) {
                zzcfi.zzh("Could not forward getAdapterResponseInfo to ResponseInfo.", (Throwable)ex);
            }
        }
        a = this.a;
        if (a == null) {
            return;
        }
        try {
            final zzu zzf = a.zzf();
            if (zzf != null) {
                this.c = AdapterResponseInfo.e(zzf);
            }
        }
        catch (final RemoteException ex2) {
            zzcfi.zzh("Could not forward getLoadedAdapterResponse to ResponseInfo.", (Throwable)ex2);
        }
    }
    
    public static ResponseInfo c(final zzdh zzdh) {
        if (zzdh != null) {
            return new ResponseInfo(zzdh);
        }
        return null;
    }
    
    public static ResponseInfo d(final zzdh zzdh) {
        return new ResponseInfo(zzdh);
    }
    
    public String a() {
        try {
            final zzdh a = this.a;
            if (a != null) {
                return a.zzg();
            }
        }
        catch (final RemoteException ex) {
            zzcfi.zzh("Could not forward getMediationAdapterClassName to ResponseInfo.", (Throwable)ex);
        }
        return null;
    }
    
    public String b() {
        try {
            final zzdh a = this.a;
            if (a != null) {
                return a.zzh();
            }
        }
        catch (final RemoteException ex) {
            zzcfi.zzh("Could not forward getResponseId to ResponseInfo.", (Throwable)ex);
        }
        return null;
    }
    
    public final JSONObject e() throws JSONException {
        final JSONObject jsonObject = new JSONObject();
        final String b = this.b();
        if (b == null) {
            jsonObject.put("Response ID", (Object)"null");
        }
        else {
            jsonObject.put("Response ID", (Object)b);
        }
        final String a = this.a();
        if (a == null) {
            jsonObject.put("Mediation Adapter Class Name", (Object)"null");
        }
        else {
            jsonObject.put("Mediation Adapter Class Name", (Object)a);
        }
        final JSONArray jsonArray = new JSONArray();
        final Iterator iterator = this.b.iterator();
        while (iterator.hasNext()) {
            jsonArray.put((Object)((AdapterResponseInfo)iterator.next()).f());
        }
        jsonObject.put("Adapter Responses", (Object)jsonArray);
        final AdapterResponseInfo c = this.c;
        if (c != null) {
            jsonObject.put("Loaded Adapter Response", (Object)c.f());
        }
        return jsonObject;
    }
    
    @Override
    public String toString() {
        String string;
        try {
            string = this.e().toString(2);
        }
        catch (final JSONException ex) {
            string = "Error forming toString output.";
        }
        return string;
    }
}
