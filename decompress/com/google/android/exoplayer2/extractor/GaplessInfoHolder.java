// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.regex.Matcher;
import com.google.android.exoplayer2.util.Util;
import java.util.regex.Pattern;

public final class GaplessInfoHolder
{
    private static final Pattern c;
    public int a;
    public int b;
    
    static {
        c = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    }
    
    public GaplessInfoHolder() {
        this.a = -1;
        this.b = -1;
    }
    
    private boolean b(final String s) {
        final Matcher matcher = GaplessInfoHolder.c.matcher(s);
        if (!matcher.find()) {
            return false;
        }
        try {
            final int int1 = Integer.parseInt(Util.j(matcher.group(1)), 16);
            final int int2 = Integer.parseInt(Util.j(matcher.group(2)), 16);
            if (int1 > 0 || int2 > 0) {
                this.a = int1;
                this.b = int2;
                return true;
            }
            return false;
        }
        catch (final NumberFormatException ex) {
            return false;
        }
    }
    
    public boolean a() {
        return this.a != -1 && this.b != -1;
    }
    
    public boolean c(final Metadata metadata) {
        for (int i = 0; i < metadata.d(); ++i) {
            final Metadata.Entry c = metadata.c(i);
            if (c instanceof CommentFrame) {
                final CommentFrame commentFrame = (CommentFrame)c;
                if ("iTunSMPB".equals(commentFrame.c) && this.b(commentFrame.d)) {
                    return true;
                }
            }
            else if (c instanceof InternalFrame) {
                final InternalFrame internalFrame = (InternalFrame)c;
                if ("com.apple.iTunes".equals(internalFrame.b) && "iTunSMPB".equals(internalFrame.c) && this.b(internalFrame.d)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean d(int b) {
        final int a = b >> 12;
        b &= 0xFFF;
        if (a <= 0 && b <= 0) {
            return false;
        }
        this.a = a;
        this.b = b;
        return true;
    }
}
