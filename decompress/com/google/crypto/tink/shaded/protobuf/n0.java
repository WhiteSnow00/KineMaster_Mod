// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

final class n0
{
    static String a(final ByteString byteString) {
        return b((b)new b(byteString) {
            final ByteString a;
            
            @Override
            public byte a(final int n) {
                return this.a.byteAt(n);
            }
            
            @Override
            public int size() {
                return this.a.size();
            }
        });
    }
    
    static String b(final b b) {
        final StringBuilder sb = new StringBuilder(b.size());
        for (int i = 0; i < b.size(); ++i) {
            final byte a = b.a(i);
            if (a != 34) {
                if (a != 39) {
                    if (a != 92) {
                        switch (a) {
                            default: {
                                if (a >= 32 && a <= 126) {
                                    sb.append((char)a);
                                    break;
                                }
                                sb.append('\\');
                                sb.append((char)((a >>> 6 & 0x3) + 48));
                                sb.append((char)((a >>> 3 & 0x7) + 48));
                                sb.append((char)((a & 0x7) + 48));
                                break;
                            }
                            case 13: {
                                sb.append("\\r");
                                break;
                            }
                            case 12: {
                                sb.append("\\f");
                                break;
                            }
                            case 11: {
                                sb.append("\\v");
                                break;
                            }
                            case 10: {
                                sb.append("\\n");
                                break;
                            }
                            case 9: {
                                sb.append("\\t");
                                break;
                            }
                            case 8: {
                                sb.append("\\b");
                                break;
                            }
                            case 7: {
                                sb.append("\\a");
                                break;
                            }
                        }
                    }
                    else {
                        sb.append("\\\\");
                    }
                }
                else {
                    sb.append("\\'");
                }
            }
            else {
                sb.append("\\\"");
            }
        }
        return sb.toString();
    }
    
    static String c(final String s) {
        return a(ByteString.copyFromUtf8(s));
    }
    
    private interface b
    {
        byte a(final int p0);
        
        int size();
    }
}
