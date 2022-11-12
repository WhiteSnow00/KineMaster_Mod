// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.dynamite;

import android.content.Context;

final class h implements VersionPolicy
{
    @Override
    public final SelectionResult a(final Context context, final String s, final IVersions versions) throws LoadingException {
        final SelectionResult selectionResult = new SelectionResult();
        selectionResult.a = versions.b(context, s);
        final int a = versions.a(context, s, true);
        selectionResult.b = a;
        int a2;
        if ((a2 = selectionResult.a) == 0) {
            if (a == 0) {
                selectionResult.c = 0;
                return selectionResult;
            }
            a2 = 0;
        }
        if (a2 >= a) {
            selectionResult.c = -1;
        }
        else {
            selectionResult.c = 1;
        }
        return selectionResult;
    }
}
