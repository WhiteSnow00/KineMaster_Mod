// 
// Decompiled by Procyon v0.6.0
// 

package com.fasterxml.jackson.core.util;

import java.io.Serializable;

public class Separators implements Serializable
{
    private static final long serialVersionUID = 1L;
    private final char arrayValueSeparator;
    private final char objectEntrySeparator;
    private final char objectFieldValueSeparator;
    
    public Separators() {
        this(':', ',', ',');
    }
    
    public Separators(final char objectFieldValueSeparator, final char objectEntrySeparator, final char arrayValueSeparator) {
        this.objectFieldValueSeparator = objectFieldValueSeparator;
        this.objectEntrySeparator = objectEntrySeparator;
        this.arrayValueSeparator = arrayValueSeparator;
    }
    
    public static Separators createDefaultInstance() {
        return new Separators();
    }
    
    public char getArrayValueSeparator() {
        return this.arrayValueSeparator;
    }
    
    public char getObjectEntrySeparator() {
        return this.objectEntrySeparator;
    }
    
    public char getObjectFieldValueSeparator() {
        return this.objectFieldValueSeparator;
    }
    
    public Separators withArrayValueSeparator(final char c) {
        Separators separators;
        if (this.arrayValueSeparator == c) {
            separators = this;
        }
        else {
            separators = new Separators(this.objectFieldValueSeparator, this.objectEntrySeparator, c);
        }
        return separators;
    }
    
    public Separators withObjectEntrySeparator(final char c) {
        Separators separators;
        if (this.objectEntrySeparator == c) {
            separators = this;
        }
        else {
            separators = new Separators(this.objectFieldValueSeparator, c, this.arrayValueSeparator);
        }
        return separators;
    }
    
    public Separators withObjectFieldValueSeparator(final char c) {
        Separators separators;
        if (this.objectFieldValueSeparator == c) {
            separators = this;
        }
        else {
            separators = new Separators(c, this.objectEntrySeparator, this.arrayValueSeparator);
        }
        return separators;
    }
}
