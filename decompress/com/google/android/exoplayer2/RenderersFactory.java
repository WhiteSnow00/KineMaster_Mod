// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import android.os.Handler;

public interface RenderersFactory
{
    Renderer[] a(final Handler p0, final VideoRendererEventListener p1, final AudioRendererEventListener p2, final TextOutput p3, final MetadataOutput p4);
}
