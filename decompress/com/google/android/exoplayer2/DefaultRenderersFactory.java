// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.video.MediaCodecVideoRenderer;
import com.google.android.exoplayer2.text.TextRenderer;
import com.google.android.exoplayer2.metadata.MetadataRenderer;
import android.os.Looper;
import com.google.android.exoplayer2.video.spherical.CameraMotionRenderer;
import com.google.android.exoplayer2.audio.AudioCapabilities;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import com.google.android.exoplayer2.audio.AudioSink;
import java.util.ArrayList;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import android.os.Handler;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.mediacodec.DefaultMediaCodecAdapterFactory;
import android.content.Context;

public class DefaultRenderersFactory implements RenderersFactory
{
    private final Context a;
    private final DefaultMediaCodecAdapterFactory b;
    private int c;
    private long d;
    private boolean e;
    private MediaCodecSelector f;
    private boolean g;
    private boolean h;
    private boolean i;
    
    public DefaultRenderersFactory(final Context a) {
        this.a = a;
        this.b = new DefaultMediaCodecAdapterFactory();
        this.c = 0;
        this.d = 5000L;
        this.f = MediaCodecSelector.a;
    }
    
    @Override
    public Renderer[] a(final Handler handler, final VideoRendererEventListener videoRendererEventListener, final AudioRendererEventListener audioRendererEventListener, final TextOutput textOutput, final MetadataOutput metadataOutput) {
        final ArrayList list = new ArrayList();
        this.h(this.a, this.c, this.f, this.e, handler, videoRendererEventListener, this.d, list);
        final AudioSink c = this.c(this.a, this.g, this.h, this.i);
        if (c != null) {
            this.b(this.a, this.c, this.f, this.e, c, handler, audioRendererEventListener, list);
        }
        this.g(this.a, textOutput, handler.getLooper(), this.c, list);
        this.e(this.a, metadataOutput, handler.getLooper(), this.c, list);
        this.d(this.a, this.c, list);
        this.f(this.a, handler, this.c, list);
        return list.toArray(new Renderer[0]);
    }
    
    protected void b(final Context p0, final int p1, final MediaCodecSelector p2, final boolean p3, final AudioSink p4, final Handler p5, final AudioRendererEventListener p6, final ArrayList<Renderer> p7) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     2: new             Lcom/google/android/exoplayer2/audio/MediaCodecAudioRenderer;
        //     5: dup            
        //     6: aload_1        
        //     7: aload_0        
        //     8: invokevirtual   com/google/android/exoplayer2/DefaultRenderersFactory.i:()Lcom/google/android/exoplayer2/mediacodec/MediaCodecAdapter$Factory;
        //    11: aload_3        
        //    12: iload           4
        //    14: aload           6
        //    16: aload           7
        //    18: aload           5
        //    20: invokespecial   com/google/android/exoplayer2/audio/MediaCodecAudioRenderer.<init>:(Landroid/content/Context;Lcom/google/android/exoplayer2/mediacodec/MediaCodecAdapter$Factory;Lcom/google/android/exoplayer2/mediacodec/MediaCodecSelector;ZLandroid/os/Handler;Lcom/google/android/exoplayer2/audio/AudioRendererEventListener;Lcom/google/android/exoplayer2/audio/AudioSink;)V
        //    23: invokevirtual   java/util/ArrayList.add:(Ljava/lang/Object;)Z
        //    26: pop            
        //    27: iload_2        
        //    28: ifne            32
        //    31: return         
        //    32: aload           8
        //    34: invokevirtual   java/util/ArrayList.size:()I
        //    37: istore          10
        //    39: iload           10
        //    41: istore          9
        //    43: iload_2        
        //    44: iconst_2       
        //    45: if_icmpne       54
        //    48: iload           10
        //    50: iconst_1       
        //    51: isub           
        //    52: istore          9
        //    54: ldc             "com.google.android.exoplayer2.decoder.midi.MidiRenderer"
        //    56: invokestatic    java/lang/Class.forName:(Ljava/lang/String;)Ljava/lang/Class;
        //    59: iconst_0       
        //    60: anewarray       Ljava/lang/Class;
        //    63: invokevirtual   java/lang/Class.getConstructor:([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
        //    66: iconst_0       
        //    67: anewarray       Ljava/lang/Object;
        //    70: invokevirtual   java/lang/reflect/Constructor.newInstance:([Ljava/lang/Object;)Ljava/lang/Object;
        //    73: checkcast       Lcom/google/android/exoplayer2/Renderer;
        //    76: astore_1       
        //    77: iload           9
        //    79: iconst_1       
        //    80: iadd           
        //    81: istore_2       
        //    82: aload           8
        //    84: iload           9
        //    86: aload_1        
        //    87: invokevirtual   java/util/ArrayList.add:(ILjava/lang/Object;)V
        //    90: ldc             "DefaultRenderersFactory"
        //    92: ldc             "Loaded MidiRenderer."
        //    94: invokestatic    com/google/android/exoplayer2/util/Log.f:(Ljava/lang/String;Ljava/lang/String;)V
        //    97: goto            122
        //   100: astore_1       
        //   101: iload_2        
        //   102: istore          9
        //   104: goto            119
        //   107: astore_1       
        //   108: new             Ljava/lang/RuntimeException;
        //   111: dup            
        //   112: ldc             "Error instantiating MIDI extension"
        //   114: aload_1        
        //   115: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   118: athrow         
        //   119: iload           9
        //   121: istore_2       
        //   122: ldc             "com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer"
        //   124: invokestatic    java/lang/Class.forName:(Ljava/lang/String;)Ljava/lang/Class;
        //   127: iconst_3       
        //   128: anewarray       Ljava/lang/Class;
        //   131: dup            
        //   132: iconst_0       
        //   133: ldc             Landroid/os/Handler;.class
        //   135: aastore        
        //   136: dup            
        //   137: iconst_1       
        //   138: ldc             Lcom/google/android/exoplayer2/audio/AudioRendererEventListener;.class
        //   140: aastore        
        //   141: dup            
        //   142: iconst_2       
        //   143: ldc             Lcom/google/android/exoplayer2/audio/AudioSink;.class
        //   145: aastore        
        //   146: invokevirtual   java/lang/Class.getConstructor:([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
        //   149: iconst_3       
        //   150: anewarray       Ljava/lang/Object;
        //   153: dup            
        //   154: iconst_0       
        //   155: aload           6
        //   157: aastore        
        //   158: dup            
        //   159: iconst_1       
        //   160: aload           7
        //   162: aastore        
        //   163: dup            
        //   164: iconst_2       
        //   165: aload           5
        //   167: aastore        
        //   168: invokevirtual   java/lang/reflect/Constructor.newInstance:([Ljava/lang/Object;)Ljava/lang/Object;
        //   171: checkcast       Lcom/google/android/exoplayer2/Renderer;
        //   174: astore_1       
        //   175: iload_2        
        //   176: iconst_1       
        //   177: iadd           
        //   178: istore          9
        //   180: aload           8
        //   182: iload_2        
        //   183: aload_1        
        //   184: invokevirtual   java/util/ArrayList.add:(ILjava/lang/Object;)V
        //   187: ldc             "DefaultRenderersFactory"
        //   189: ldc             "Loaded LibopusAudioRenderer."
        //   191: invokestatic    com/google/android/exoplayer2/util/Log.f:(Ljava/lang/String;Ljava/lang/String;)V
        //   194: iload           9
        //   196: istore_2       
        //   197: goto            219
        //   200: astore_1       
        //   201: iload           9
        //   203: istore_2       
        //   204: goto            219
        //   207: astore_1       
        //   208: new             Ljava/lang/RuntimeException;
        //   211: dup            
        //   212: ldc             "Error instantiating Opus extension"
        //   214: aload_1        
        //   215: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   218: athrow         
        //   219: ldc             "com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer"
        //   221: invokestatic    java/lang/Class.forName:(Ljava/lang/String;)Ljava/lang/Class;
        //   224: iconst_3       
        //   225: anewarray       Ljava/lang/Class;
        //   228: dup            
        //   229: iconst_0       
        //   230: ldc             Landroid/os/Handler;.class
        //   232: aastore        
        //   233: dup            
        //   234: iconst_1       
        //   235: ldc             Lcom/google/android/exoplayer2/audio/AudioRendererEventListener;.class
        //   237: aastore        
        //   238: dup            
        //   239: iconst_2       
        //   240: ldc             Lcom/google/android/exoplayer2/audio/AudioSink;.class
        //   242: aastore        
        //   243: invokevirtual   java/lang/Class.getConstructor:([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
        //   246: iconst_3       
        //   247: anewarray       Ljava/lang/Object;
        //   250: dup            
        //   251: iconst_0       
        //   252: aload           6
        //   254: aastore        
        //   255: dup            
        //   256: iconst_1       
        //   257: aload           7
        //   259: aastore        
        //   260: dup            
        //   261: iconst_2       
        //   262: aload           5
        //   264: aastore        
        //   265: invokevirtual   java/lang/reflect/Constructor.newInstance:([Ljava/lang/Object;)Ljava/lang/Object;
        //   268: checkcast       Lcom/google/android/exoplayer2/Renderer;
        //   271: astore_1       
        //   272: iload_2        
        //   273: iconst_1       
        //   274: iadd           
        //   275: istore          9
        //   277: aload           8
        //   279: iload_2        
        //   280: aload_1        
        //   281: invokevirtual   java/util/ArrayList.add:(ILjava/lang/Object;)V
        //   284: ldc             "DefaultRenderersFactory"
        //   286: ldc             "Loaded LibflacAudioRenderer."
        //   288: invokestatic    com/google/android/exoplayer2/util/Log.f:(Ljava/lang/String;Ljava/lang/String;)V
        //   291: iload           9
        //   293: istore_2       
        //   294: goto            316
        //   297: astore_1       
        //   298: iload           9
        //   300: istore_2       
        //   301: goto            316
        //   304: astore_1       
        //   305: new             Ljava/lang/RuntimeException;
        //   308: dup            
        //   309: ldc             "Error instantiating FLAC extension"
        //   311: aload_1        
        //   312: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   315: athrow         
        //   316: aload           8
        //   318: iload_2        
        //   319: ldc             "com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer"
        //   321: invokestatic    java/lang/Class.forName:(Ljava/lang/String;)Ljava/lang/Class;
        //   324: iconst_3       
        //   325: anewarray       Ljava/lang/Class;
        //   328: dup            
        //   329: iconst_0       
        //   330: ldc             Landroid/os/Handler;.class
        //   332: aastore        
        //   333: dup            
        //   334: iconst_1       
        //   335: ldc             Lcom/google/android/exoplayer2/audio/AudioRendererEventListener;.class
        //   337: aastore        
        //   338: dup            
        //   339: iconst_2       
        //   340: ldc             Lcom/google/android/exoplayer2/audio/AudioSink;.class
        //   342: aastore        
        //   343: invokevirtual   java/lang/Class.getConstructor:([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
        //   346: iconst_3       
        //   347: anewarray       Ljava/lang/Object;
        //   350: dup            
        //   351: iconst_0       
        //   352: aload           6
        //   354: aastore        
        //   355: dup            
        //   356: iconst_1       
        //   357: aload           7
        //   359: aastore        
        //   360: dup            
        //   361: iconst_2       
        //   362: aload           5
        //   364: aastore        
        //   365: invokevirtual   java/lang/reflect/Constructor.newInstance:([Ljava/lang/Object;)Ljava/lang/Object;
        //   368: checkcast       Lcom/google/android/exoplayer2/Renderer;
        //   371: invokevirtual   java/util/ArrayList.add:(ILjava/lang/Object;)V
        //   374: ldc             "DefaultRenderersFactory"
        //   376: ldc             "Loaded FfmpegAudioRenderer."
        //   378: invokestatic    com/google/android/exoplayer2/util/Log.f:(Ljava/lang/String;Ljava/lang/String;)V
        //   381: goto            396
        //   384: astore_1       
        //   385: new             Ljava/lang/RuntimeException;
        //   388: dup            
        //   389: ldc             "Error instantiating FFmpeg extension"
        //   391: aload_1        
        //   392: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   395: athrow         
        //   396: return         
        //   397: astore_1       
        //   398: goto            119
        //   401: astore_1       
        //   402: goto            219
        //   405: astore_1       
        //   406: goto            316
        //   409: astore_1       
        //   410: goto            396
        //    Signature:
        //  (Landroid/content/Context;ILcom/google/android/exoplayer2/mediacodec/MediaCodecSelector;ZLcom/google/android/exoplayer2/audio/AudioSink;Landroid/os/Handler;Lcom/google/android/exoplayer2/audio/AudioRendererEventListener;Ljava/util/ArrayList<Lcom/google/android/exoplayer2/Renderer;>;)V
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                              
        //  -----  -----  -----  -----  ----------------------------------
        //  54     77     397    401    Ljava/lang/ClassNotFoundException;
        //  54     77     107    119    Ljava/lang/Exception;
        //  82     97     100    107    Ljava/lang/ClassNotFoundException;
        //  82     97     107    119    Ljava/lang/Exception;
        //  122    175    401    405    Ljava/lang/ClassNotFoundException;
        //  122    175    207    219    Ljava/lang/Exception;
        //  180    194    200    207    Ljava/lang/ClassNotFoundException;
        //  180    194    207    219    Ljava/lang/Exception;
        //  219    272    405    409    Ljava/lang/ClassNotFoundException;
        //  219    272    304    316    Ljava/lang/Exception;
        //  277    291    297    304    Ljava/lang/ClassNotFoundException;
        //  277    291    304    316    Ljava/lang/Exception;
        //  316    381    409    413    Ljava/lang/ClassNotFoundException;
        //  316    381    384    396    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 238, Size: 238
        //     at java.util.ArrayList.rangeCheck(Unknown Source)
        //     at java.util.ArrayList.get(Unknown Source)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3362)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:112)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:203)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:93)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:868)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:761)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:638)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:605)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:195)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:162)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:137)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:333)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:254)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:129)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    protected AudioSink c(final Context context, final boolean b, final boolean b2, final boolean b3) {
        return new DefaultAudioSink.Builder().g(AudioCapabilities.c(context)).k(b).j(b2).l(b3 ? 1 : 0).f();
    }
    
    protected void d(final Context context, final int n, final ArrayList<Renderer> list) {
        list.add(new CameraMotionRenderer());
    }
    
    protected void e(final Context context, final MetadataOutput metadataOutput, final Looper looper, final int n, final ArrayList<Renderer> list) {
        list.add(new MetadataRenderer(metadataOutput, looper));
    }
    
    protected void f(final Context context, final Handler handler, final int n, final ArrayList<Renderer> list) {
    }
    
    protected void g(final Context context, final TextOutput textOutput, final Looper looper, final int n, final ArrayList<Renderer> list) {
        list.add(new TextRenderer(textOutput, looper));
    }
    
    protected void h(final Context context, int n, final MediaCodecSelector mediaCodecSelector, final boolean b, final Handler handler, final VideoRendererEventListener videoRendererEventListener, final long n2, final ArrayList<Renderer> list) {
        list.add(new MediaCodecVideoRenderer(context, this.i(), mediaCodecSelector, n2, b, handler, videoRendererEventListener, 50));
        if (n == 0) {
            return;
        }
        int size;
        final int n3 = size = list.size();
        Label_0056: {
            if (n != 2) {
                break Label_0056;
            }
            size = n3 - 1;
            try {
                try {
                    final Renderer renderer = (Renderer)Class.forName("com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer").getConstructor(Long.TYPE, Handler.class, VideoRendererEventListener.class, Integer.TYPE).newInstance(n2, handler, videoRendererEventListener, 50);
                    n = size + 1;
                    try {
                        list.add(size, renderer);
                        Log.f("DefaultRenderersFactory", "Loaded LibvpxVideoRenderer.");
                    }
                    catch (final ClassNotFoundException ex) {
                        size = n;
                    }
                }
                catch (final Exception ex2) {
                    throw new RuntimeException("Error instantiating VP9 extension", ex2);
                }
                n = size;
                try {
                    list.add(n, (MediaCodecVideoRenderer)Class.forName("com.google.android.exoplayer2.ext.av1.Libgav1VideoRenderer").getConstructor(Long.TYPE, Handler.class, VideoRendererEventListener.class, Integer.TYPE).newInstance(n2, handler, videoRendererEventListener, 50));
                    Log.f("DefaultRenderersFactory", "Loaded Libgav1VideoRenderer.");
                }
                catch (final Exception ex3) {
                    throw new RuntimeException("Error instantiating AV1 extension", ex3);
                }
                catch (final ClassNotFoundException ex4) {}
            }
            catch (final ClassNotFoundException ex5) {}
        }
    }
    
    protected MediaCodecAdapter.Factory i() {
        return this.b;
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface ExtensionRendererMode {
    }
}
