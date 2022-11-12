// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.resource.bitmap;

import android.media.MediaDataSource;
import java.io.IOException;
import com.bumptech.glide.load.engine.s;
import c2.e;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.os.Build$VERSION;
import android.media.MediaMetadataRetriever;
import android.content.res.AssetFileDescriptor;
import java.security.MessageDigest;
import java.nio.ByteBuffer;
import c2.d;
import android.graphics.Bitmap;
import c2.f;

public class VideoDecoder<T> implements c2.f<T, Bitmap>
{
    public static final c2.d<Long> d;
    public static final c2.d<Integer> e;
    private static final e f;
    private final f<T> a;
    private final e2.d b;
    private final e c;
    
    static {
        d = c2.d.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, (c2.d.b<Long>)new c2.d.b<Long>() {
            private final ByteBuffer a = ByteBuffer.allocate(8);
            
            @Override
            public /* bridge */ void a(final byte[] array, final Object o, final MessageDigest messageDigest) {
                this.b(array, (Long)o, messageDigest);
            }
            
            public void b(final byte[] array, final Long n, final MessageDigest messageDigest) {
                messageDigest.update(array);
                synchronized (this.a) {
                    this.a.position(0);
                    messageDigest.update(this.a.putLong(n).array());
                }
            }
        });
        e = c2.d.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, (c2.d.b<Integer>)new c2.d.b<Integer>() {
            private final ByteBuffer a = ByteBuffer.allocate(4);
            
            @Override
            public /* bridge */ void a(final byte[] array, final Object o, final MessageDigest messageDigest) {
                this.b(array, (Integer)o, messageDigest);
            }
            
            public void b(final byte[] array, final Integer n, final MessageDigest messageDigest) {
                if (n == null) {
                    return;
                }
                messageDigest.update(array);
                synchronized (this.a) {
                    this.a.position(0);
                    messageDigest.update(this.a.putInt(n).array());
                }
            }
        });
        f = new e();
    }
    
    VideoDecoder(final e2.d d, final f<T> f) {
        this(d, f, VideoDecoder.f);
    }
    
    VideoDecoder(final e2.d b, final f<T> a, final e c) {
        this.b = b;
        this.a = a;
        this.c = c;
    }
    
    public static c2.f<AssetFileDescriptor, Bitmap> c(final e2.d d) {
        return new VideoDecoder<AssetFileDescriptor>(d, (f<AssetFileDescriptor>)new c(null));
    }
    
    public static c2.f<ByteBuffer, Bitmap> d(final e2.d d) {
        return new VideoDecoder<ByteBuffer>(d, (f<ByteBuffer>)new d());
    }
    
    private static Bitmap e(final MediaMetadataRetriever mediaMetadataRetriever, final long n, final int n2, final int n3, final int n4, final DownsampleStrategy downsampleStrategy) {
        Bitmap g;
        if (Build$VERSION.SDK_INT >= 27 && n3 != Integer.MIN_VALUE && n4 != Integer.MIN_VALUE && downsampleStrategy != DownsampleStrategy.f) {
            g = g(mediaMetadataRetriever, n, n2, n3, n4, downsampleStrategy);
        }
        else {
            g = null;
        }
        Bitmap f = g;
        if (g == null) {
            f = f(mediaMetadataRetriever, n, n2);
        }
        if (f != null) {
            return f;
        }
        throw new VideoDecoderException();
    }
    
    private static Bitmap f(final MediaMetadataRetriever mediaMetadataRetriever, final long n, final int n2) {
        return mediaMetadataRetriever.getFrameAtTime(n, n2);
    }
    
    private static Bitmap g(final MediaMetadataRetriever mediaMetadataRetriever, final long n, final int n2, final int n3, final int n4, final DownsampleStrategy downsampleStrategy) {
        try {
            final int int1 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            final int int2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            final int int3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            int n5 = 0;
            int n6 = 0;
            Label_0064: {
                if (int3 != 90) {
                    n5 = int1;
                    n6 = int2;
                    if (int3 != 270) {
                        break Label_0064;
                    }
                }
                n6 = int1;
                n5 = int2;
            }
            final float b = downsampleStrategy.b(n5, n6, n3, n4);
            return mediaMetadataRetriever.getScaledFrameAtTime(n, n2, Math.round(n5 * b), Math.round(b * n6));
        }
        finally {
            if (Log.isLoggable("VideoDecoder", 3)) {
                final Throwable t;
                Log.d("VideoDecoder", "Exception trying to decode a scaled frame on oreo+, falling back to a fullsize frame", t);
            }
            return null;
        }
    }
    
    public static c2.f<ParcelFileDescriptor, Bitmap> h(final e2.d d) {
        return new VideoDecoder<ParcelFileDescriptor>(d, (f<ParcelFileDescriptor>)new g());
    }
    
    @Override
    public s<Bitmap> a(final T t, final int n, final int n2, final c2.e e) throws IOException {
        final long longValue = e.c(VideoDecoder.d);
        if (longValue < 0L && longValue != -1L) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Requested frame must be non-negative, or DEFAULT_FRAME, given: ");
            sb.append(longValue);
            throw new IllegalArgumentException(sb.toString());
        }
        Integer value;
        if ((value = e.c(VideoDecoder.e)) == null) {
            value = 2;
        }
        DownsampleStrategy g;
        if ((g = e.c(DownsampleStrategy.h)) == null) {
            g = DownsampleStrategy.g;
        }
        final MediaMetadataRetriever a = this.c.a();
        try {
            this.a.a(a, t);
            final Bitmap e2 = e(a, longValue, value, n, n2, g);
            if (Build$VERSION.SDK_INT >= 29) {
                a.close();
            }
            else {
                a.release();
            }
            return e.e(e2, this.b);
        }
        finally {
            if (Build$VERSION.SDK_INT >= 29) {
                a.close();
            }
            else {
                a.release();
            }
        }
    }
    
    @Override
    public boolean b(final T t, final c2.e e) {
        return true;
    }
    
    private static final class VideoDecoderException extends RuntimeException
    {
        private static final long serialVersionUID = -2556382523004027815L;
        
        VideoDecoderException() {
            super("MediaMetadataRetriever failed to retrieve a frame without throwing, check the adb logs for .*MetadataRetriever.* prior to this exception for details");
        }
    }
    
    private static final class c implements f<AssetFileDescriptor>
    {
        private c() {
        }
        
        c(final VideoDecoder$a b) {
            this();
        }
        
        @Override
        public /* bridge */ void a(final MediaMetadataRetriever mediaMetadataRetriever, final Object o) {
            this.b(mediaMetadataRetriever, (AssetFileDescriptor)o);
        }
        
        public void b(final MediaMetadataRetriever mediaMetadataRetriever, final AssetFileDescriptor assetFileDescriptor) {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }
    }
    
    static final class d implements f<ByteBuffer>
    {
        @Override
        public /* bridge */ void a(final MediaMetadataRetriever mediaMetadataRetriever, final Object o) {
            this.b(mediaMetadataRetriever, (ByteBuffer)o);
        }
        
        public void b(final MediaMetadataRetriever mediaMetadataRetriever, final ByteBuffer byteBuffer) {
            mediaMetadataRetriever.setDataSource((MediaDataSource)new MediaDataSource(this, byteBuffer) {
                final ByteBuffer a;
                final d b;
                
                public void close() {
                }
                
                public long getSize() {
                    return this.a.limit();
                }
                
                public int readAt(final long n, final byte[] array, final int n2, int min) {
                    if (n >= this.a.limit()) {
                        return -1;
                    }
                    this.a.position((int)n);
                    min = Math.min(min, this.a.remaining());
                    this.a.get(array, n2, min);
                    return min;
                }
            });
        }
    }
    
    static class e
    {
        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }
    
    interface f<T>
    {
        void a(final MediaMetadataRetriever p0, final T p1);
    }
    
    static final class g implements f<ParcelFileDescriptor>
    {
        @Override
        public /* bridge */ void a(final MediaMetadataRetriever mediaMetadataRetriever, final Object o) {
            this.b(mediaMetadataRetriever, (ParcelFileDescriptor)o);
        }
        
        public void b(final MediaMetadataRetriever mediaMetadataRetriever, final ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }
}
