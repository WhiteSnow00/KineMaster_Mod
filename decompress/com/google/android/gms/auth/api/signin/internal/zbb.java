// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.signin.internal;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.logging.Logger;

public final class zbb implements Runnable
{
    private static final Logger c;
    private final String a;
    private final StatusPendingResult b;
    
    static {
        c = new Logger("RevokeAccessOperation", new String[0]);
    }
    
    public zbb(final String s) {
        this.a = Preconditions.g(s);
        this.b = new StatusPendingResult(null);
    }
    
    public static PendingResult a(final String s) {
        if (s == null) {
            return PendingResults.a(new Status(4), null);
        }
        final zbb zbb = new zbb(s);
        new Thread(zbb).start();
        return zbb.b;
    }
    
    @Override
    public final void run() {
        Status i;
        Status status;
        Status g = status = (i = Status.i);
        Label_0299: {
            Label_0274: {
                try {
                    i = g;
                    status = g;
                    final String a = this.a;
                    i = g;
                    status = g;
                    i = g;
                    status = g;
                    final StringBuilder sb = new StringBuilder();
                    i = g;
                    status = g;
                    sb.append("https://accounts.google.com/o/oauth2/revoke?token=");
                    i = g;
                    status = g;
                    sb.append(a);
                    i = g;
                    status = g;
                    final URL url = new URL(sb.toString());
                    i = g;
                    status = g;
                    final HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                    i = g;
                    status = g;
                    httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    i = g;
                    status = g;
                    final int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == 200) {
                        i = g;
                        status = g;
                        g = Status.g;
                    }
                    else {
                        i = g;
                        status = g;
                        zbb.c.c("Unable to revoke access!", new Object[0]);
                    }
                    i = g;
                    status = g;
                    final Logger c = zbb.c;
                    i = g;
                    status = g;
                    i = g;
                    status = g;
                    final StringBuilder sb2 = new StringBuilder();
                    i = g;
                    status = g;
                    sb2.append("Response Code: ");
                    i = g;
                    status = g;
                    sb2.append(responseCode);
                    i = g;
                    status = g;
                    c.a(sb2.toString(), new Object[0]);
                    break Label_0299;
                }
                catch (final Exception ex) {}
                catch (final IOException ex2) {
                    break Label_0274;
                }
                final Exception ex;
                zbb.c.c("Exception when revoking access: ".concat(String.valueOf(ex.toString())), new Object[0]);
                g = i;
                break Label_0299;
            }
            final IOException ex2;
            zbb.c.c("IOException when revoking access: ".concat(String.valueOf(ex2.toString())), new Object[0]);
            g = status;
        }
        this.b.i(g);
    }
}
