// 
// Decompiled by Procyon v0.6.0
// 

package androidx.media;

import android.os.Parcelable;
import android.media.AudioAttributes;
import androidx.versionedparcelable.VersionedParcel;

public class AudioAttributesImplApi26Parcelizer
{
    public static AudioAttributesImplApi26 read(final VersionedParcel versionedParcel) {
        final AudioAttributesImplApi26 audioAttributesImplApi26 = new AudioAttributesImplApi26();
        audioAttributesImplApi26.a = versionedParcel.r(audioAttributesImplApi26.a, 1);
        audioAttributesImplApi26.b = versionedParcel.p(audioAttributesImplApi26.b, 2);
        return audioAttributesImplApi26;
    }
    
    public static void write(final AudioAttributesImplApi26 audioAttributesImplApi26, final VersionedParcel versionedParcel) {
        versionedParcel.x(false, false);
        versionedParcel.H((Parcelable)audioAttributesImplApi26.a, 1);
        versionedParcel.F(audioAttributesImplApi26.b, 2);
    }
}
