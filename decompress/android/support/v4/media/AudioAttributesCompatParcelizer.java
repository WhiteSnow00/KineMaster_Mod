// 
// Decompiled by Procyon v0.6.0
// 

package android.support.v4.media;

import androidx.media.AudioAttributesCompat;
import androidx.versionedparcelable.VersionedParcel;

public final class AudioAttributesCompatParcelizer extends androidx.media.AudioAttributesCompatParcelizer
{
    public static AudioAttributesCompat read(final VersionedParcel versionedParcel) {
        return androidx.media.AudioAttributesCompatParcelizer.read(versionedParcel);
    }
    
    public static void write(final AudioAttributesCompat audioAttributesCompat, final VersionedParcel versionedParcel) {
        androidx.media.AudioAttributesCompatParcelizer.write(audioAttributesCompat, versionedParcel);
    }
}
