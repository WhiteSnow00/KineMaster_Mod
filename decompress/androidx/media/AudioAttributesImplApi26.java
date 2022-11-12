// 
// Decompiled by Procyon v0.6.0
// 

package androidx.media;

import android.media.AudioAttributes;

public class AudioAttributesImplApi26 extends AudioAttributesImplApi21
{
    public AudioAttributesImplApi26() {
    }
    
    AudioAttributesImplApi26(final AudioAttributes audioAttributes) {
        super(audioAttributes, -1);
    }
    
    static class a extends AudioAttributesImplApi21.a
    {
        @Override
        public AudioAttributesImpl build() {
            return new AudioAttributesImplApi26(super.a.build());
        }
    }
}
