// 
// Decompiled by Procyon v0.6.0
// 

package com.airbnb.lottie.network;

import y1.d;

public enum FileExtension
{
    private static final FileExtension[] $VALUES;
    
    JSON(".json"), 
    ZIP(".zip");
    
    public final String extension;
    
    private FileExtension(final String extension) {
        this.extension = extension;
    }
    
    public static FileExtension forFile(final String s) {
        for (final FileExtension fileExtension : values()) {
            if (s.endsWith(fileExtension.extension)) {
                return fileExtension;
            }
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Unable to find correct extension for ");
        sb.append(s);
        d.c(sb.toString());
        return FileExtension.JSON;
    }
    
    public String tempExtension() {
        final StringBuilder sb = new StringBuilder();
        sb.append(".temp");
        sb.append(this.extension);
        return sb.toString();
    }
    
    @Override
    public String toString() {
        return this.extension;
    }
}
