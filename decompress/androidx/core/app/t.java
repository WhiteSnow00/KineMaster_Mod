// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.app;

import android.app.RemoteInput$Builder;
import android.os.Bundle;
import android.content.Intent;
import android.app.RemoteInput;

public final class t
{
    static RemoteInput a(final t t) {
        return a.b(t);
    }
    
    static RemoteInput[] b(final t[] array) {
        if (array == null) {
            return null;
        }
        final RemoteInput[] array2 = new RemoteInput[array.length];
        for (int i = 0; i < array.length; ++i) {
            final t t = array[i];
            array2[i] = a(null);
        }
        return array2;
    }
    
    static class a
    {
        static void a(final Object o, final Intent intent, final Bundle bundle) {
            RemoteInput.addResultsToIntent((RemoteInput[])o, intent, bundle);
        }
        
        public static RemoteInput b(final t t) {
            new(android.app.RemoteInput$Builder.class)();
            throw null;
        }
        
        static Bundle c(final Intent intent) {
            return RemoteInput.getResultsFromIntent(intent);
        }
    }
}
