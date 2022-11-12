// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.data;

public final class zad extends RuntimeException
{
    public zad(final String s) {
        super("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
    }
}
