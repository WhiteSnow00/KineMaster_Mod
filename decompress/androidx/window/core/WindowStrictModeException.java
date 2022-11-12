// 
// Decompiled by Procyon v0.6.0
// 

package androidx.window.core;

import kotlin.jvm.internal.o;
import kotlin.Metadata;

@Metadata(d1 = { "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006" }, d2 = { "Landroidx/window/core/WindowStrictModeException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "(Ljava/lang/String;)V", "window_release" }, k = 1, mv = { 1, 6, 0 }, xi = 48)
public final class WindowStrictModeException extends Exception
{
    public WindowStrictModeException(final String s) {
        o.g((Object)s, "message");
        super(s);
    }
}
