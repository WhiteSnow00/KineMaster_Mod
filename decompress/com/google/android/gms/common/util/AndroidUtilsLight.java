// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.util;

import java.security.NoSuchAlgorithmException;
import android.content.pm.PackageManager$NameNotFoundException;
import java.security.MessageDigest;
import android.content.pm.Signature;
import android.content.pm.PackageInfo;
import com.google.android.gms.common.wrappers.Wrappers;
import android.content.Context;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
@ShowFirstParty
public class AndroidUtilsLight
{
    @Deprecated
    @KeepForSdk
    public static byte[] a(final Context context, final String s) throws PackageManager$NameNotFoundException {
        final PackageInfo f = Wrappers.a(context).f(s, 64);
        final Signature[] signatures = f.signatures;
        if (signatures != null && signatures.length == 1) {
            final MessageDigest b = b("SHA1");
            if (b != null) {
                return b.digest(f.signatures[0].toByteArray());
            }
        }
        return null;
    }
    
    public static MessageDigest b(final String s) {
        int n = 0;
    Label_0021_Outer:
        while (true) {
            Label_0027: {
                if (n >= 2) {
                    break Label_0027;
                }
                while (true) {
                    try {
                        final MessageDigest instance = MessageDigest.getInstance(s);
                        if (instance == null) {
                            ++n;
                            continue Label_0021_Outer;
                        }
                        return instance;
                        return null;
                    }
                    catch (final NoSuchAlgorithmException ex) {
                        continue;
                    }
                    break;
                }
            }
        }
    }
}
