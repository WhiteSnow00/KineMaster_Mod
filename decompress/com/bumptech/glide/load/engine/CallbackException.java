// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.engine;

final class CallbackException extends RuntimeException
{
    private static final long serialVersionUID = -7530898992688511851L;
    
    CallbackException(final Throwable t) {
        super("Unexpected exception thrown by non-Glide code", t);
    }
}
