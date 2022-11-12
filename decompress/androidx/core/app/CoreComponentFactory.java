// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.app;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.app.Application;
import android.app.Activity;
import android.content.Intent;
import android.app.AppComponentFactory;

public class CoreComponentFactory extends AppComponentFactory
{
    static <T> T a(final T t) {
        if (t instanceof a) {
            final Object a = ((a)t).a();
            if (a != null) {
                return (T)a;
            }
        }
        return t;
    }
    
    public Activity instantiateActivity(final ClassLoader classLoader, final String s, final Intent intent) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return a(super.instantiateActivity(classLoader, s, intent));
    }
    
    public Application instantiateApplication(final ClassLoader classLoader, final String s) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return a(super.instantiateApplication(classLoader, s));
    }
    
    public ContentProvider instantiateProvider(final ClassLoader classLoader, final String s) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return a(super.instantiateProvider(classLoader, s));
    }
    
    public BroadcastReceiver instantiateReceiver(final ClassLoader classLoader, final String s, final Intent intent) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return a(super.instantiateReceiver(classLoader, s, intent));
    }
    
    public Service instantiateService(final ClassLoader classLoader, final String s, final Intent intent) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return a(super.instantiateService(classLoader, s, intent));
    }
    
    public interface a
    {
        Object a();
    }
}
