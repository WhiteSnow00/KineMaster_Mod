// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.dynamite;

import android.content.Context;

final class f implements VersionPolicy
{
    @Override
    public final SelectionResult a(final Context context, final String s, final IVersions versions) throws LoadingException {
        final SelectionResult selectionResult = new SelectionResult();
        final int b = versions.b(context, s);
        selectionResult.a = b;
        if (b != 0) {
            selectionResult.c = -1;
        }
        else if ((selectionResult.b = versions.a(context, s, true)) != 0) {
            selectionResult.c = 1;
        }
        return selectionResult;
    }
}
