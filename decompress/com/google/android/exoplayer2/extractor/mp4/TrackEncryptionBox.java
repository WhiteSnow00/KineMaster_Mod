// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.extractor.TrackOutput;

public final class TrackEncryptionBox
{
    public final boolean a;
    public final String b;
    public final TrackOutput.CryptoData c;
    public final int d;
    public final byte[] e;
    
    public TrackEncryptionBox(final boolean a, final String b, final int d, final byte[] array, final int n, final int n2, final byte[] e) {
        boolean b2 = true;
        final boolean b3 = d == 0;
        if (e != null) {
            b2 = false;
        }
        Assertions.a(b2 ^ b3);
        this.a = a;
        this.b = b;
        this.d = d;
        this.e = e;
        this.c = new TrackOutput.CryptoData(a(b), array, n, n2);
    }
    
    private static int a(final String s) {
        if (s == null) {
            return 1;
        }
        int n = -1;
        switch (s) {
            case "cens": {
                n = 3;
                break;
            }
            case "cenc": {
                n = 2;
                break;
            }
            case "cbcs": {
                n = 1;
                break;
            }
            case "cbc1": {
                n = 0;
                break;
            }
            default:
                break;
        }
        switch (n) {
            default: {
                final StringBuilder sb = new StringBuilder();
                sb.append("Unsupported protection scheme type '");
                sb.append(s);
                sb.append("'. Assuming AES-CTR crypto mode.");
                Log.i("TrackEncryptionBox", sb.toString());
                return 1;
            }
            case 2:
            case 3: {
                return 1;
            }
            case 0:
            case 1: {
                return 2;
            }
        }
    }
}
