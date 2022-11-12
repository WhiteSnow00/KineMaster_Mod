// 
// Decompiled by Procyon v0.6.0
// 

package androidx.media;

import android.media.AudioAttributes;
import android.util.SparseIntArray;
import b1.b;

public class AudioAttributesCompat implements b
{
    private static final SparseIntArray b;
    static boolean c;
    private static final int[] d;
    public AudioAttributesImpl a;
    
    static {
        final SparseIntArray b2 = new SparseIntArray();
        (b = b2).put(5, 1);
        b2.put(6, 2);
        b2.put(7, 2);
        b2.put(8, 1);
        b2.put(9, 1);
        b2.put(10, 1);
        d = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16 };
    }
    
    public AudioAttributesCompat() {
    }
    
    AudioAttributesCompat(final AudioAttributesImpl a) {
        this.a = a;
    }
    
    static int b(final boolean b, int n, final int n2) {
        final int n3 = 1;
        if ((n & 0x1) == 0x1) {
            if (b) {
                n = n3;
            }
            else {
                n = 7;
            }
            return n;
        }
        final int n4 = 0;
        final int n5 = 0;
        if ((n & 0x4) == 0x4) {
            if (b) {
                n = n5;
            }
            else {
                n = 6;
            }
            return n;
        }
        n = n4;
        switch (n2) {
            default: {
                if (!b) {
                    return 3;
                }
                final StringBuilder sb = new StringBuilder();
                sb.append("Unknown usage value ");
                sb.append(n2);
                sb.append(" in audio attributes");
                throw new IllegalArgumentException(sb.toString());
            }
            case 13: {
                return 1;
            }
            case 11: {
                return 10;
            }
            case 6: {
                return 2;
            }
            case 5:
            case 7:
            case 8:
            case 9:
            case 10: {
                return 5;
            }
            case 4: {
                return 4;
            }
            case 3: {
                if (b) {
                    n = n4;
                    return n;
                }
                n = 8;
                return n;
            }
            case 2: {
                return n;
            }
            case 0:
            case 1:
            case 12:
            case 14:
            case 16: {
                return 3;
            }
        }
    }
    
    static String c(final int n) {
        switch (n) {
            default: {
                final StringBuilder sb = new StringBuilder();
                sb.append("unknown usage ");
                sb.append(n);
                return sb.toString();
            }
            case 16: {
                return "USAGE_ASSISTANT";
            }
            case 14: {
                return "USAGE_GAME";
            }
            case 13: {
                return "USAGE_ASSISTANCE_SONIFICATION";
            }
            case 12: {
                return "USAGE_ASSISTANCE_NAVIGATION_GUIDANCE";
            }
            case 11: {
                return "USAGE_ASSISTANCE_ACCESSIBILITY";
            }
            case 10: {
                return "USAGE_NOTIFICATION_EVENT";
            }
            case 9: {
                return "USAGE_NOTIFICATION_COMMUNICATION_DELAYED";
            }
            case 8: {
                return "USAGE_NOTIFICATION_COMMUNICATION_INSTANT";
            }
            case 7: {
                return "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
            }
            case 6: {
                return "USAGE_NOTIFICATION_RINGTONE";
            }
            case 5: {
                return "USAGE_NOTIFICATION";
            }
            case 4: {
                return "USAGE_ALARM";
            }
            case 3: {
                return "USAGE_VOICE_COMMUNICATION_SIGNALLING";
            }
            case 2: {
                return "USAGE_VOICE_COMMUNICATION";
            }
            case 1: {
                return "USAGE_MEDIA";
            }
            case 0: {
                return "USAGE_UNKNOWN";
            }
        }
    }
    
    public static AudioAttributesCompat d(final Object o) {
        if (AudioAttributesCompat.c) {
            return null;
        }
        return new AudioAttributesCompat(new AudioAttributesImplApi26((AudioAttributes)o));
    }
    
    public int a() {
        return this.a.a();
    }
    
    @Override
    public boolean equals(final Object o) {
        final boolean b = o instanceof AudioAttributesCompat;
        boolean b2 = false;
        if (!b) {
            return false;
        }
        final AudioAttributesCompat audioAttributesCompat = (AudioAttributesCompat)o;
        final AudioAttributesImpl a = this.a;
        if (a == null) {
            if (audioAttributesCompat.a == null) {
                b2 = true;
            }
            return b2;
        }
        return a.equals(audioAttributesCompat.a);
    }
    
    @Override
    public int hashCode() {
        return this.a.hashCode();
    }
    
    @Override
    public String toString() {
        return this.a.toString();
    }
    
    public static class a
    {
        final AudioAttributesImpl.a a;
        
        public a() {
            if (AudioAttributesCompat.c) {
                this.a = new AudioAttributesImplBase.a();
            }
            else {
                this.a = new AudioAttributesImplApi26.a();
            }
        }
        
        public AudioAttributesCompat a() {
            return new AudioAttributesCompat(this.a.build());
        }
        
        public a b(final int n) {
            this.a.a(n);
            return this;
        }
    }
}
