// 
// Decompiled by Procyon v0.6.0
// 

package e1;

import android.app.Notification;

public final class c
{
    private final int a;
    private final int b;
    private final Notification c;
    
    public c(final int a, final Notification c, final int b) {
        this.a = a;
        this.c = c;
        this.b = b;
    }
    
    public int a() {
        return this.b;
    }
    
    public Notification b() {
        return this.c;
    }
    
    public int c() {
        return this.a;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o != null && c.class == o.getClass()) {
            final c c = (c)o;
            return this.a == c.a && this.b == c.b && this.c.equals(c.c);
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return (this.a * 31 + this.b) * 31 + this.c.hashCode();
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ForegroundInfo{");
        sb.append("mNotificationId=");
        sb.append(this.a);
        sb.append(", mForegroundServiceType=");
        sb.append(this.b);
        sb.append(", mNotification=");
        sb.append(this.c);
        sb.append('}');
        return sb.toString();
    }
}
