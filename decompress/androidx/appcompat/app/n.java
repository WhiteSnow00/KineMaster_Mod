// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.app;

import java.util.Calendar;
import android.util.Log;
import androidx.core.content.d;
import android.location.Location;
import android.location.LocationManager;
import android.content.Context;

class n
{
    private static n d;
    private final Context a;
    private final LocationManager b;
    private final a c;
    
    n(final Context a, final LocationManager b) {
        this.c = new a();
        this.a = a;
        this.b = b;
    }
    
    static n a(Context applicationContext) {
        if (n.d == null) {
            applicationContext = applicationContext.getApplicationContext();
            n.d = new n(applicationContext, (LocationManager)applicationContext.getSystemService("location"));
        }
        return n.d;
    }
    
    private Location b() {
        final int b = androidx.core.content.d.b(this.a, "android.permission.ACCESS_COARSE_LOCATION");
        Location c = null;
        Location c2;
        if (b == 0) {
            c2 = this.c("network");
        }
        else {
            c2 = null;
        }
        if (androidx.core.content.d.b(this.a, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            c = this.c("gps");
        }
        if (c != null && c2 != null) {
            Location location = c2;
            if (c.getTime() > c2.getTime()) {
                location = c;
            }
            return location;
        }
        if (c != null) {
            c2 = c;
        }
        return c2;
    }
    
    private Location c(final String s) {
        try {
            if (this.b.isProviderEnabled(s)) {
                return this.b.getLastKnownLocation(s);
            }
        }
        catch (final Exception ex) {
            Log.d("TwilightManager", "Failed to get last known location", (Throwable)ex);
        }
        return null;
    }
    
    private boolean e() {
        return this.c.f > System.currentTimeMillis();
    }
    
    private void f(final Location location) {
        final a c = this.c;
        final long currentTimeMillis = System.currentTimeMillis();
        final m b = m.b();
        b.a(currentTimeMillis - 86400000L, location.getLatitude(), location.getLongitude());
        final long a = b.a;
        b.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        final int c2 = b.c;
        boolean a2 = true;
        if (c2 != 1) {
            a2 = false;
        }
        final long b2 = b.b;
        final long a3 = b.a;
        b.a(86400000L + currentTimeMillis, location.getLatitude(), location.getLongitude());
        final long b3 = b.b;
        long f;
        if (b2 != -1L && a3 != -1L) {
            long n;
            if (currentTimeMillis > a3) {
                n = 0L + b3;
            }
            else if (currentTimeMillis > b2) {
                n = 0L + a3;
            }
            else {
                n = 0L + b2;
            }
            f = n + 60000L;
        }
        else {
            f = 43200000L + currentTimeMillis;
        }
        c.a = a2;
        c.b = a;
        c.c = b2;
        c.d = a3;
        c.e = b3;
        c.f = f;
    }
    
    boolean d() {
        final a c = this.c;
        if (this.e()) {
            return c.a;
        }
        final Location b = this.b();
        if (b != null) {
            this.f(b);
            return c.a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        final int value = Calendar.getInstance().get(11);
        return value < 6 || value >= 22;
    }
    
    private static class a
    {
        boolean a;
        long b;
        long c;
        long d;
        long e;
        long f;
        
        a() {
        }
    }
}
