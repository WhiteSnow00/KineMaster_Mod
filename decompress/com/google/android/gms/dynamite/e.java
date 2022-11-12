// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.dynamite;

import android.content.Context;

final class e implements VersionPolicy
{
    @Override
    public final SelectionResult a(final Context context, final String s, final IVersions versions) throws LoadingException {
        final SelectionResult selectionResult = new SelectionResult();
        final int a = versions.a(context, s, true);
        selectionResult.b = a;
        if (a != 0) {
            selectionResult.c = 1;
        }
        else if ((selectionResult.a = versions.b(context, s)) != 0) {
            selectionResult.c = -1;
        }
        return selectionResult;
    }
}
