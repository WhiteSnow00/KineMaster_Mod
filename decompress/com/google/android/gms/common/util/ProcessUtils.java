// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.util;

import android.os.StrictMode$ThreadPolicy;
import java.io.IOException;
import com.google.android.gms.common.internal.Preconditions;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import android.os.StrictMode;
import android.os.Process;
import javax.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class ProcessUtils
{
    @Nullable
    private static String a;
    private static int b;
    
    private ProcessUtils() {
    }
    
    @KeepForSdk
    public static String a() {
        if (ProcessUtils.a != null) {
            goto Label_0170;
        }
        int b;
        if ((b = ProcessUtils.b) == 0) {
            b = (ProcessUtils.b = Process.myPid());
        }
        if (b <= 0) {
            goto Label_0166;
        }
        try {
            final StringBuilder sb = new StringBuilder();
            sb.append("/proc/");
            sb.append(b);
            sb.append("/cmdline");
            final String string = sb.toString();
            final StrictMode$ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
            try {
                final BufferedReader bufferedReader = new BufferedReader(new FileReader(string));
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                try {
                    final String line = bufferedReader.readLine();
                    Preconditions.k(line);
                    line.trim();
                }
                catch (final IOException ex) {}
            }
            finally {}
        }
        catch (final IOException ex2) {}
    }
}
