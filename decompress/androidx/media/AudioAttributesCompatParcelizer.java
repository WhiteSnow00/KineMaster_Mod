// 
// Decompiled by Procyon v0.6.0
// 

package androidx.media;

import b1.b;
import androidx.versionedparcelable.VersionedParcel;

public class AudioAttributesCompatParcelizer
{
    public static AudioAttributesCompat read(final VersionedParcel versionedParcel) {
        final AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        audioAttributesCompat.a = versionedParcel.v(audioAttributesCompat.a, 1);
        return audioAttributesCompat;
    }
    
    public static void write(final AudioAttributesCompat audioAttributesCompat, final VersionedParcel versionedParcel) {
        versionedParcel.x(false, false);
        versionedParcel.M(audioAttributesCompat.a, 1);
    }
}
