// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api;

import java.util.Iterator;
import android.text.TextUtils;
import java.util.ArrayList;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.ConnectionResult;
import androidx.collection.a;

public class AvailabilityException extends Exception
{
    private final a zaa;
    
    public AvailabilityException(final a zaa) {
        this.zaa = zaa;
    }
    
    public ConnectionResult getConnectionResult(final GoogleApi<? extends Api.ApiOptions> googleApi) {
        final ApiKey<? extends Api.ApiOptions> apiKey = googleApi.getApiKey();
        final boolean b = this.zaa.get(apiKey) != null;
        final String b2 = apiKey.b();
        final StringBuilder sb = new StringBuilder();
        sb.append("The given API (");
        sb.append(b2);
        sb.append(") was not part of the availability request.");
        Preconditions.b(b, sb.toString());
        return Preconditions.k(this.zaa.get(apiKey));
    }
    
    public ConnectionResult getConnectionResult(final HasApiKey<? extends Api.ApiOptions> hasApiKey) {
        final ApiKey<? extends Api.ApiOptions> apiKey = hasApiKey.getApiKey();
        final boolean b = this.zaa.get(apiKey) != null;
        final String b2 = apiKey.b();
        final StringBuilder sb = new StringBuilder();
        sb.append("The given API (");
        sb.append(b2);
        sb.append(") was not part of the availability request.");
        Preconditions.b(b, sb.toString());
        return Preconditions.k(this.zaa.get(apiKey));
    }
    
    @Override
    public String getMessage() {
        final ArrayList list = new ArrayList();
        final Iterator iterator = this.zaa.keySet().iterator();
        boolean b = true;
        while (iterator.hasNext()) {
            final ApiKey apiKey = (ApiKey)iterator.next();
            final ConnectionResult connectionResult = Preconditions.k(this.zaa.get(apiKey));
            b &= (connectionResult.O1() ^ true);
            final String b2 = apiKey.b();
            final String value = String.valueOf(connectionResult);
            final StringBuilder sb = new StringBuilder();
            sb.append(b2);
            sb.append(": ");
            sb.append(value);
            list.add(sb.toString());
        }
        final StringBuilder sb2 = new StringBuilder();
        if (b) {
            sb2.append("None of the queried APIs are available. ");
        }
        else {
            sb2.append("Some of the queried APIs are unavailable. ");
        }
        sb2.append(TextUtils.join((CharSequence)"; ", (Iterable)list));
        return sb2.toString();
    }
}
