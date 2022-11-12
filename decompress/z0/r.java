// 
// Decompiled by Procyon v0.6.0
// 

package z0;

import android.animation.AnimatorSet;
import android.animation.Animator;
import android.graphics.Canvas;
import android.graphics.Bitmap$Config;
import android.graphics.Picture;
import android.graphics.Bitmap;
import android.view.View$MeasureSpec;
import android.widget.ImageView$ScaleType;
import android.widget.ImageView;
import android.graphics.RectF;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build$VERSION;

class r
{
    private static final boolean a;
    private static final boolean b;
    private static final boolean c;
    
    static {
        final int sdk_INT = Build$VERSION.SDK_INT;
        boolean c2 = true;
        a = true;
        b = true;
        if (sdk_INT < 28) {
            c2 = false;
        }
        c = c2;
    }
    
    static View a(final ViewGroup viewGroup, final View view, final View view2) {
        final Matrix matrix = new Matrix();
        matrix.setTranslate((float)(-view2.getScrollX()), (float)(-view2.getScrollY()));
        z.i(view, matrix);
        z.j((View)viewGroup, matrix);
        final RectF rectF = new RectF(0.0f, 0.0f, (float)view.getWidth(), (float)view.getHeight());
        matrix.mapRect(rectF);
        final int round = Math.round(rectF.left);
        final int round2 = Math.round(rectF.top);
        final int round3 = Math.round(rectF.right);
        final int round4 = Math.round(rectF.bottom);
        final ImageView imageView = new ImageView(view.getContext());
        imageView.setScaleType(ImageView$ScaleType.CENTER_CROP);
        final Bitmap b = b(view, matrix, rectF, viewGroup);
        if (b != null) {
            imageView.setImageBitmap(b);
        }
        imageView.measure(View$MeasureSpec.makeMeasureSpec(round3 - round, 1073741824), View$MeasureSpec.makeMeasureSpec(round4 - round2, 1073741824));
        imageView.layout(round, round2, round3, round4);
        return (View)imageView;
    }
    
    private static Bitmap b(final View view, final Matrix matrix, final RectF rectF, final ViewGroup viewGroup) {
        boolean b;
        boolean b2;
        if (r.a) {
            b = (view.isAttachedToWindow() ^ true);
            b2 = (viewGroup != null && viewGroup.isAttachedToWindow());
        }
        else {
            b = false;
            b2 = false;
        }
        final boolean b3 = r.b;
        final Bitmap bitmap = null;
        ViewGroup viewGroup2;
        int indexOfChild;
        if (b3 && b) {
            if (!b2) {
                return null;
            }
            viewGroup2 = (ViewGroup)view.getParent();
            indexOfChild = viewGroup2.indexOfChild(view);
            viewGroup.getOverlay().add(view);
        }
        else {
            indexOfChild = 0;
            viewGroup2 = null;
        }
        final int round = Math.round(rectF.width());
        final int round2 = Math.round(rectF.height());
        Bitmap bitmap2 = bitmap;
        if (round > 0) {
            bitmap2 = bitmap;
            if (round2 > 0) {
                final float min = Math.min(1.0f, 1048576.0f / (round * round2));
                final int round3 = Math.round(round * min);
                final int round4 = Math.round(round2 * min);
                matrix.postTranslate(-rectF.left, -rectF.top);
                matrix.postScale(min, min);
                if (r.c) {
                    final Picture picture = new Picture();
                    final Canvas beginRecording = picture.beginRecording(round3, round4);
                    beginRecording.concat(matrix);
                    view.draw(beginRecording);
                    picture.endRecording();
                    bitmap2 = Bitmap.createBitmap(picture);
                }
                else {
                    bitmap2 = Bitmap.createBitmap(round3, round4, Bitmap$Config.ARGB_8888);
                    final Canvas canvas = new Canvas(bitmap2);
                    canvas.concat(matrix);
                    view.draw(canvas);
                }
            }
        }
        if (b3 && b) {
            viewGroup.getOverlay().remove(view);
            viewGroup2.addView(view, indexOfChild);
        }
        return bitmap2;
    }
    
    static Animator c(final Animator animator, final Animator animator2) {
        if (animator == null) {
            return animator2;
        }
        if (animator2 == null) {
            return animator;
        }
        final AnimatorSet set = new AnimatorSet();
        set.playTogether(new Animator[] { animator, animator2 });
        return (Animator)set;
    }
}
