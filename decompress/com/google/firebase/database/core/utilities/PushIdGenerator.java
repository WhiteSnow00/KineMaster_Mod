// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core.utilities;

import java.util.Random;

public class PushIdGenerator
{
    private static final Random a;
    private static long b;
    private static final int[] c;
    
    static {
        a = new Random();
        PushIdGenerator.b = 0L;
        c = new int[12];
    }
}
