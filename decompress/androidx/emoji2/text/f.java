// 
// Decompiled by Procyon v0.6.0
// 

package androidx.emoji2.text;

import java.util.concurrent.ThreadPoolExecutor;

public final class f implements Runnable
{
    public final EmojiCompatInitializer.b a;
    public final e.h b;
    public final ThreadPoolExecutor c;
    
    public f(final EmojiCompatInitializer.b a, final e.h b, final ThreadPoolExecutor c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public final void run() {
        EmojiCompatInitializer.b.b(this.a, this.b, this.c);
    }
}
