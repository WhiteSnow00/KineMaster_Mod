// 
// Decompiled by Procyon v0.6.0
// 

package androidx.constraintlayout.motion.widget;

import android.util.Log;
import java.nio.CharBuffer;
import android.view.View;
import android.content.Context;

public class a
{
    public static String a() {
        final StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        final StringBuilder sb = new StringBuilder();
        sb.append(".(");
        sb.append(stackTraceElement.getFileName());
        sb.append(":");
        sb.append(stackTraceElement.getLineNumber());
        sb.append(") ");
        sb.append(stackTraceElement.getMethodName());
        sb.append("()");
        return sb.toString();
    }
    
    public static String b(final Context context, final int n) {
        if (n == -1) {
            return "UNKNOWN";
        }
        try {
            return context.getResources().getResourceEntryName(n);
        }
        catch (final Exception ex) {
            final StringBuilder sb = new StringBuilder();
            sb.append("?");
            sb.append(n);
            return sb.toString();
        }
    }
    
    public static String c(final View view) {
        try {
            return view.getContext().getResources().getResourceEntryName(view.getId());
        }
        catch (final Exception ex) {
            return "UNKNOWN";
        }
    }
    
    public static String d(final MotionLayout motionLayout, final int n) {
        return e(motionLayout, n, -1);
    }
    
    public static String e(final MotionLayout motionLayout, int length, final int n) {
        if (length == -1) {
            return "UNDEFINED";
        }
        String s2;
        final String s = s2 = motionLayout.getContext().getResources().getResourceEntryName(length);
        if (n != -1) {
            String replaceAll = s;
            if (s.length() > n) {
                replaceAll = s.replaceAll("([^_])[aeiou]+", "$1");
            }
            s2 = replaceAll;
            if (replaceAll.length() > n) {
                length = replaceAll.replaceAll("[^_]", "").length();
                s2 = replaceAll;
                if (length > 0) {
                    length = (replaceAll.length() - n) / length;
                    final StringBuilder sb = new StringBuilder();
                    sb.append(CharBuffer.allocate(length).toString().replace('\0', '.'));
                    sb.append("_");
                    s2 = replaceAll.replaceAll(sb.toString(), "_");
                }
            }
        }
        return s2;
    }
    
    public static void f(final String s, final String s2, int i) {
        final StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        final int length = stackTrace.length;
        final int n = 1;
        final int min = Math.min(i, length - 1);
        String string = " ";
        StackTraceElement stackTraceElement;
        StringBuilder sb;
        String string2;
        StringBuilder sb2;
        StringBuilder sb3;
        for (i = n; i <= min; ++i) {
            stackTraceElement = stackTrace[i];
            sb = new StringBuilder();
            sb.append(".(");
            sb.append(stackTrace[i].getFileName());
            sb.append(":");
            sb.append(stackTrace[i].getLineNumber());
            sb.append(") ");
            sb.append(stackTrace[i].getMethodName());
            string2 = sb.toString();
            sb2 = new StringBuilder();
            sb2.append(string);
            sb2.append(" ");
            string = sb2.toString();
            sb3 = new StringBuilder();
            sb3.append(s2);
            sb3.append(string);
            sb3.append(string2);
            sb3.append(string);
            Log.v(s, sb3.toString());
        }
    }
}
