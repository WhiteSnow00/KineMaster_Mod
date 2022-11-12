// 
// Decompiled by Procyon v0.6.0
// 

package com.fasterxml.jackson.core.io;

import java.io.Writer;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;

public abstract class OutputDecorator implements Serializable
{
    public abstract OutputStream decorate(final c p0, final OutputStream p1) throws IOException;
    
    public abstract Writer decorate(final c p0, final Writer p1) throws IOException;
}
