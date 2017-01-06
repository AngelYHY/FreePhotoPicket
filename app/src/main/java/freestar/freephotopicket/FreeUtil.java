package freestar.freephotopicket;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by Administrator on 2017/1/6 0006.
 */

public class FreeUtil {

    /**
     *dp转px
     */
    public static int dp2px(Context context, float dpValue) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, context.getResources().getDisplayMetrics());
    }
}
