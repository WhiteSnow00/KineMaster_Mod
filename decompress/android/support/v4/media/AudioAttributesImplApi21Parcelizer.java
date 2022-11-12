// 
// Decompiled by Procyon v0.6.0
// 

package android.support.v4.media;

import androidx.media.AudioAttributesImplApi21;
import androidx.versionedparcelable.VersionedParcel;

public final class AudioAttributesImplApi21Parcelizer extends androidx.media.AudioAttributesImplApi21Parcelizer
{
    public static AudioAttributesImplApi21 read(final VersionedParcel versionedParcel) {
        return androidx.media.AudioAttributesImplApi21Parcelizer.read(versionedParcel);
    }
    
    public static void write(final AudioAttributesImplApi21 audioAttributesImplApi21, final VersionedParcel versionedParcel) {
        androidx.media.AudioAttributesImplApi21Parcelizer.write(audioAttributesImplApi21, versionedParcel);
    }
}
