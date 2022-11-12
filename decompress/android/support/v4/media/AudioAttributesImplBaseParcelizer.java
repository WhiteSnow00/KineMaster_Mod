// 
// Decompiled by Procyon v0.6.0
// 

package android.support.v4.media;

import androidx.media.AudioAttributesImplBase;
import androidx.versionedparcelable.VersionedParcel;

public final class AudioAttributesImplBaseParcelizer extends androidx.media.AudioAttributesImplBaseParcelizer
{
    public static AudioAttributesImplBase read(final VersionedParcel versionedParcel) {
        return androidx.media.AudioAttributesImplBaseParcelizer.read(versionedParcel);
    }
    
    public static void write(final AudioAttributesImplBase audioAttributesImplBase, final VersionedParcel versionedParcel) {
        androidx.media.AudioAttributesImplBaseParcelizer.write(audioAttributesImplBase, versionedParcel);
    }
}
