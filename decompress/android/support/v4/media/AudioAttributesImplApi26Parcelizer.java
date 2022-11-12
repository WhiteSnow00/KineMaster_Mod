// 
// Decompiled by Procyon v0.6.0
// 

package android.support.v4.media;

import androidx.media.AudioAttributesImplApi26;
import androidx.versionedparcelable.VersionedParcel;

public final class AudioAttributesImplApi26Parcelizer extends androidx.media.AudioAttributesImplApi26Parcelizer
{
    public static AudioAttributesImplApi26 read(final VersionedParcel versionedParcel) {
        return androidx.media.AudioAttributesImplApi26Parcelizer.read(versionedParcel);
    }
    
    public static void write(final AudioAttributesImplApi26 audioAttributesImplApi26, final VersionedParcel versionedParcel) {
        androidx.media.AudioAttributesImplApi26Parcelizer.write(audioAttributesImplApi26, versionedParcel);
    }
}
