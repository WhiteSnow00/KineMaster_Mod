// 
// Decompiled by Procyon v0.6.0
// 

package m0;

import android.os.Bundle;

public class a
{
    public static boolean a(final Bundle bundle, final Bundle bundle2) {
        final boolean b = true;
        final boolean b2 = true;
        boolean b3 = true;
        if (bundle == bundle2) {
            return true;
        }
        if (bundle == null) {
            if (bundle2.getInt("android.media.browse.extra.PAGE", -1) != -1 || bundle2.getInt("android.media.browse.extra.PAGE_SIZE", -1) != -1) {
                b3 = false;
            }
            return b3;
        }
        if (bundle2 == null) {
            return bundle.getInt("android.media.browse.extra.PAGE", -1) == -1 && bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1) == -1 && b;
        }
        return bundle.getInt("android.media.browse.extra.PAGE", -1) == bundle2.getInt("android.media.browse.extra.PAGE", -1) && bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1) == bundle2.getInt("android.media.browse.extra.PAGE_SIZE", -1) && b2;
    }
}
