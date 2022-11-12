// 
// Decompiled by Procyon v0.6.0
// 

package androidx.media;

import androidx.versionedparcelable.VersionedParcel;

public class AudioAttributesImplBaseParcelizer
{
    public static AudioAttributesImplBase read(final VersionedParcel versionedParcel) {
        final AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.a = versionedParcel.p(audioAttributesImplBase.a, 1);
        audioAttributesImplBase.b = versionedParcel.p(audioAttributesImplBase.b, 2);
        audioAttributesImplBase.c = versionedParcel.p(audioAttributesImplBase.c, 3);
        audioAttributesImplBase.d = versionedParcel.p(audioAttributesImplBase.d, 4);
        return audioAttributesImplBase;
    }
    
    public static void write(final AudioAttributesImplBase audioAttributesImplBase, final VersionedParcel versionedParcel) {
        versionedParcel.x(false, false);
        versionedParcel.F(audioAttributesImplBase.a, 1);
        versionedParcel.F(audioAttributesImplBase.b, 2);
        versionedParcel.F(audioAttributesImplBase.c, 3);
        versionedParcel.F(audioAttributesImplBase.d, 4);
    }
}
