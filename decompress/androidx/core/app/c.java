// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.app;

import android.app.ActivityOptions;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import androidx.core.util.d;
import android.app.Activity;

public class c
{
    protected c() {
    }
    
    public static c a(final Activity activity, final d<View, String>... array) {
        Pair<View, String>[] array2 = null;
        if (array != null) {
            final Pair[] array3 = new Pair[array.length];
            int n = 0;
            while (true) {
                array2 = (Pair<View, String>[])array3;
                if (n >= array.length) {
                    break;
                }
                array3[n] = Pair.create((Object)array[n].a, (Object)array[n].b);
                ++n;
            }
        }
        return new a(b.b(activity, array2));
    }
    
    public Bundle b() {
        throw null;
    }
    
    private static class a extends c
    {
        private final ActivityOptions a;
        
        a(final ActivityOptions a) {
            this.a = a;
        }
        
        @Override
        public Bundle b() {
            return this.a.toBundle();
        }
    }
    
    static class b
    {
        static ActivityOptions a(final Activity activity, final View view, final String s) {
            return ActivityOptions.makeSceneTransitionAnimation(activity, view, s);
        }
        
        @SafeVarargs
        static ActivityOptions b(final Activity activity, final Pair<View, String>... array) {
            return ActivityOptions.makeSceneTransitionAnimation(activity, (Pair[])array);
        }
        
        static ActivityOptions c() {
            return ActivityOptions.makeTaskLaunchBehind();
        }
    }
}
