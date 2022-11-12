// 
// Decompiled by Procyon v0.6.0
// 

package b1;

import android.os.Bundle;
import androidx.versionedparcelable.ParcelImpl;
import android.os.Parcelable;

public class a
{
    private a() {
    }
    
    public static <T extends b> T a(final Parcelable parcelable) {
        if (parcelable instanceof ParcelImpl) {
            return ((ParcelImpl)parcelable).a();
        }
        throw new IllegalArgumentException("Invalid parcel");
    }
    
    public static <T extends b> T b(Bundle bundle, final String s) {
        try {
            bundle = (Bundle)bundle.getParcelable(s);
            if (bundle == null) {
                return null;
            }
            bundle.setClassLoader(a.class.getClassLoader());
            return a(bundle.getParcelable("a"));
        }
        catch (final RuntimeException ex) {
            return null;
        }
    }
    
    public static void c(final Bundle bundle, final String s, final b b) {
        if (b == null) {
            return;
        }
        final Bundle bundle2 = new Bundle();
        bundle2.putParcelable("a", d(b));
        bundle.putParcelable(s, (Parcelable)bundle2);
    }
    
    public static Parcelable d(final b b) {
        return (Parcelable)new ParcelImpl(b);
    }
}
