// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.metadata.icy;

import java.util.regex.Matcher;
import com.google.common.base.Ascii;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataInputBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.ByteBuffer;
import com.google.common.base.Charsets;
import java.nio.charset.CharsetDecoder;
import java.util.regex.Pattern;
import com.google.android.exoplayer2.metadata.SimpleMetadataDecoder;

public final class IcyDecoder extends SimpleMetadataDecoder
{
    private static final Pattern c;
    private final CharsetDecoder a;
    private final CharsetDecoder b;
    
    static {
        c = Pattern.compile("(.+?)='(.*?)';", 32);
    }
    
    public IcyDecoder() {
        this.a = Charsets.c.newDecoder();
        this.b = Charsets.b.newDecoder();
    }
    
    private String c(final ByteBuffer byteBuffer) {
        try {
            return this.a.decode(byteBuffer).toString();
        }
        catch (final CharacterCodingException ex) {
            this.a.reset();
            byteBuffer.rewind();
            try {
                return this.b.decode(byteBuffer).toString();
            }
            catch (final CharacterCodingException ex2) {
                return null;
            }
            finally {
                this.b.reset();
                byteBuffer.rewind();
            }
        }
        finally {
            this.a.reset();
            byteBuffer.rewind();
        }
    }
    
    @Override
    protected Metadata b(final MetadataInputBuffer metadataInputBuffer, final ByteBuffer byteBuffer) {
        final String c = this.c(byteBuffer);
        final byte[] array = new byte[byteBuffer.limit()];
        byteBuffer.get(array);
        String s = null;
        if (c == null) {
            return new Metadata(new Metadata.Entry[] { new IcyInfo(array, null, null) });
        }
        final Matcher matcher = IcyDecoder.c.matcher(c);
        int end = 0;
        String s2 = null;
        while (matcher.find(end)) {
            final String group = matcher.group(1);
            final String group2 = matcher.group(2);
            String s3 = s;
            String s4 = s2;
            if (group != null) {
                final String e = Ascii.e(group);
                e.hashCode();
                if (!e.equals("streamurl")) {
                    if (!e.equals("streamtitle")) {
                        s3 = s;
                        s4 = s2;
                    }
                    else {
                        s3 = group2;
                        s4 = s2;
                    }
                }
                else {
                    s4 = group2;
                    s3 = s;
                }
            }
            end = matcher.end();
            s = s3;
            s2 = s4;
        }
        return new Metadata(new Metadata.Entry[] { new IcyInfo(array, s, s2) });
    }
}
