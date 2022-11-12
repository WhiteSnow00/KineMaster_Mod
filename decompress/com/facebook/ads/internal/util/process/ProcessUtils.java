// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads.internal.util.process;

import android.text.TextUtils;
import java.lang.reflect.Field;
import android.app.Application;
import android.os.Build$VERSION;
import android.content.Context;
import androidx.annotation.Keep;

@Keep
public final class ProcessUtils
{
    private static String sProcessName;
    
    private ProcessUtils() {
    }
    
    public static String getProcessName(Context applicationContext) {
        synchronized (ProcessUtils.class) {
            final String sProcessName = ProcessUtils.sProcessName;
            if (sProcessName != null) {
                return sProcessName;
            }
            monitorexit(ProcessUtils.class);
            if (Build$VERSION.SDK_INT >= 28) {
                return getProcessNameAPI28();
            }
            applicationContext = applicationContext.getApplicationContext();
            if (applicationContext instanceof Application) {
                final String processNameViaReflection = getProcessNameViaReflection((Application)applicationContext);
                synchronized (ProcessUtils.class) {
                    return ProcessUtils.sProcessName = processNameViaReflection;
                }
            }
            return null;
        }
    }
    
    private static String getProcessNameAPI28() {
        try {
            return (String)Application.class.getMethod("getProcessName", (Class<?>[])null).invoke(null, (Object[])null);
        }
        catch (final Exception ex) {
            return null;
        }
    }
    
    private static String getProcessNameViaReflection(final Application application) {
        try {
            final Field field = application.getClass().getField("mLoadedApk");
            field.setAccessible(true);
            final Object value = field.get(application);
            final Field declaredField = value.getClass().getDeclaredField("mActivityThread");
            declaredField.setAccessible(true);
            final Object value2 = declaredField.get(value);
            return (String)value2.getClass().getDeclaredMethod("getProcessName", (Class<?>[])null).invoke(value2, (Object[])null);
        }
        catch (final Exception ex) {
            return null;
        }
    }
    
    public static String getProcessSpecificName(final String s, final Context context) {
        final String packageName = context.getPackageName();
        final String processName = getProcessName(context);
        String string = s;
        if (!TextUtils.isEmpty((CharSequence)processName)) {
            string = s;
            if (!packageName.equals(processName)) {
                String s2 = processName;
                if (processName.contains(":")) {
                    s2 = processName.split(":")[1];
                }
                final StringBuilder sb = new StringBuilder();
                sb.append(s);
                sb.append("_");
                sb.append(s2);
                string = sb.toString();
            }
        }
        return string;
    }
}
