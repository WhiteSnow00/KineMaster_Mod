// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.identifier;

import java.net.HttpURLConnection;
import java.io.IOException;
import android.util.Log;
import java.net.URLConnection;
import java.net.URL;
import com.google.android.gms.internal.ads_identifier.zzi;

public final class zzc
{
    public static final void a(final String s) {
        Label_0131: {
            try {
                zzi.zzb(263);
                Object o = new URL(s);
                o = ((URL)o).openConnection();
                try {
                    final int responseCode = ((HttpURLConnection)o).getResponseCode();
                    if (responseCode < 200 || responseCode >= 300) {
                        final StringBuilder sb = new StringBuilder(String.valueOf(s).length() + 65);
                        sb.append("Received non-success response code ");
                        sb.append(responseCode);
                        sb.append(" from pinging URL: ");
                        sb.append(s);
                        Log.w("HttpUrlPinger", sb.toString());
                    }
                    zzi.zza();
                    return;
                }
                finally {
                    ((HttpURLConnection)o).disconnect();
                }
            }
            catch (final RuntimeException o) {
                break Label_0131;
            }
            catch (final IOException ex) {
                final Object o;
                final String message = ((Throwable)o).getMessage();
                final StringBuilder sb2 = new StringBuilder(String.valueOf(s).length() + 27 + String.valueOf(message).length());
                sb2.append("Error while pinging URL: ");
                sb2.append(s);
                sb2.append(". ");
                sb2.append(message);
                Log.w("HttpUrlPinger", sb2.toString(), (Throwable)o);
                zzi.zza();
                return;
            }
            catch (final IndexOutOfBoundsException ex2) {
                final String message2 = ex2.getMessage();
                final Object o = new StringBuilder(String.valueOf(s).length() + 32 + String.valueOf(message2).length());
                ((StringBuilder)o).append("Error while parsing ping URL: ");
                ((StringBuilder)o).append(s);
                ((StringBuilder)o).append(". ");
                ((StringBuilder)o).append(message2);
                Log.w("HttpUrlPinger", ((StringBuilder)o).toString(), (Throwable)ex2);
                zzi.zza();
                return;
            }
        }
        zzi.zza();
    }
}
