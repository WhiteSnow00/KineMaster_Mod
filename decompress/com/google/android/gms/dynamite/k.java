// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.dynamite;

import android.content.Context;

final class k implements VersionPolicy
{
    @Override
    public final SelectionResult a(final Context context, final String s, final IVersions versions) throws LoadingException {
        final SelectionResult selectionResult = new SelectionResult();
        final int b = versions.b(context, s);
        selectionResult.a = b;
        int n = 0;
        int n2;
        if (b != 0) {
            n2 = versions.a(context, s, false);
            selectionResult.b = n2;
        }
        else {
            n2 = versions.a(context, s, true);
            selectionResult.b = n2;
        }
        final int a = selectionResult.a;
        if (a == 0) {
            if (n2 == 0) {
                selectionResult.c = 0;
                return selectionResult;
            }
        }
        else {
            n = a;
        }
        if (n2 >= n) {
            selectionResult.c = 1;
        }
        else {
            selectionResult.c = -1;
        }
        return selectionResult;
    }
}
