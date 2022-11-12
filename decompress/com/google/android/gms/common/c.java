// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common;

final class c
{
    static int a(final int n) {
        for (int i = 0; i < 3; ++i) {
            final int n2 = (new int[] { 1, 2, 3 })[i];
            if (n2 == 0) {
                throw null;
            }
            if (n2 - 1 == n) {
                return n2;
            }
        }
        return 1;
    }
}
