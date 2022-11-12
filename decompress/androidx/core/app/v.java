// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.app;

import androidx.core.content.a;
import android.os.Bundle;
import android.app.PendingIntent;
import java.util.Iterator;
import android.content.pm.PackageManager$NameNotFoundException;
import android.util.Log;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import java.util.ArrayList;
import android.content.Intent;

public final class v implements Iterable<Intent>
{
    private final ArrayList<Intent> a;
    private final Context b;
    
    private v(final Context b) {
        this.a = new ArrayList<Intent>();
        this.b = b;
    }
    
    public static v g(final Context context) {
        return new v(context);
    }
    
    public v a(final Intent intent) {
        this.a.add(intent);
        return this;
    }
    
    public v b(final Intent intent) {
        ComponentName componentName;
        if ((componentName = intent.getComponent()) == null) {
            componentName = intent.resolveActivity(this.b.getPackageManager());
        }
        if (componentName != null) {
            this.f(componentName);
        }
        this.a(intent);
        return this;
    }
    
    public v e(final Activity activity) {
        Intent supportParentActivityIntent;
        if (activity instanceof b) {
            supportParentActivityIntent = ((b)activity).getSupportParentActivityIntent();
        }
        else {
            supportParentActivityIntent = null;
        }
        Intent a = supportParentActivityIntent;
        if (supportParentActivityIntent == null) {
            a = j.a(activity);
        }
        if (a != null) {
            ComponentName componentName;
            if ((componentName = a.getComponent()) == null) {
                componentName = a.resolveActivity(this.b.getPackageManager());
            }
            this.f(componentName);
            this.a(a);
        }
        return this;
    }
    
    public v f(final ComponentName componentName) {
        final int size = this.a.size();
        try {
            for (Intent intent = j.b(this.b, componentName); intent != null; intent = j.b(this.b, intent.getComponent())) {
                this.a.add(size, intent);
            }
            return this;
        }
        catch (final PackageManager$NameNotFoundException ex) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException((Throwable)ex);
        }
    }
    
    @Deprecated
    @Override
    public Iterator<Intent> iterator() {
        return this.a.iterator();
    }
    
    public Intent k(final int n) {
        return this.a.get(n);
    }
    
    public int m() {
        return this.a.size();
    }
    
    public PendingIntent n(final int n, final int n2) {
        return this.o(n, n2, null);
    }
    
    public PendingIntent o(final int n, final int n2, final Bundle bundle) {
        if (!this.a.isEmpty()) {
            final Intent[] array = this.a.toArray(new Intent[0]);
            array[0] = new Intent(array[0]).addFlags(268484608);
            return v.a.a(this.b, n, array, n2, bundle);
        }
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
    }
    
    public void p() {
        this.q(null);
    }
    
    public void q(final Bundle bundle) {
        if (!this.a.isEmpty()) {
            final Intent[] array = this.a.toArray(new Intent[0]);
            array[0] = new Intent(array[0]).addFlags(268484608);
            if (!androidx.core.content.a.startActivities(this.b, array, bundle)) {
                final Intent intent = new Intent(array[array.length - 1]);
                intent.addFlags(268435456);
                this.b.startActivity(intent);
            }
            return;
        }
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    }
    
    static class a
    {
        static PendingIntent a(final Context context, final int n, final Intent[] array, final int n2, final Bundle bundle) {
            return PendingIntent.getActivities(context, n, array, n2, bundle);
        }
    }
    
    public interface b
    {
        Intent getSupportParentActivityIntent();
    }
}
