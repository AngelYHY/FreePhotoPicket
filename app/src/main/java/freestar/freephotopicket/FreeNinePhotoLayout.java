package freestar.freephotopicket;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * Created by Administrator on 2017/1/6 0006.
 */

public class FreeNinePhotoLayout extends FrameLayout {

    /**
     * item 的尺寸，优先级高于 bga_npl_otherWhiteSpacing，默认值为 0dp
     */
    private int mItemWidth;

    /**
     * 当只有一张图片时，是否显示成大图，默认值为 true
     */
    private boolean mShowAsLargeWhenOnlyOne;

    /**
     * Item 条目圆角尺寸，默认值为 0dp
     */
    private int mItemCornerRadius;

    /**
     * Item 间的水平和垂直间距，默认值为 4dp
     */
    private int mItemWhiteSpacing;

    /**
     * 占位图资源，默认值为 R.mipmap.bga_pp_ic_holder_light
     */
    private int mPlaceholderDrawableResId;

    /**
     * 出去九宫格部分的空白区域的尺寸，默认值为 100dp
     */
    private int mOtherWhiteSpacing;

    /**
     * 列数,默认值为 3，当该值大于 3 并且数据源里只有四张图片时不会显示成 2 列
     */
    private int mItemSpanCount;

    public FreeNinePhotoLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FreeNinePhotoLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initDefaultAttrs(context);
        initCustomAttrs(context, attrs);
    }

    private void initCustomAttrs(Context context, AttributeSet attrs) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.FreeNinePhotoLayout);
        for (int i = 0, len = array.getIndexCount(); i < len; i++) {
            initCustomAttr(array.getIndex(i), array);
        }
        array.recycle();
    }

    private void initCustomAttr(int attr, TypedArray array) {
        switch (attr) {
            case R.styleable.FreeNinePhotoLayout_free_npl_showAsLargeWhenOnlyOne:
                mShowAsLargeWhenOnlyOne = array.getBoolean(attr, mShowAsLargeWhenOnlyOne);
                break;
            case R.styleable.FreeNinePhotoLayout_free_npl_itemCornerRadius:
                mItemCornerRadius = array.getDimensionPixelSize(attr, mItemCornerRadius);
                break;
            case R.styleable.FreeNinePhotoLayout_free_npl_itemWhiteSpacing:
                mItemWhiteSpacing = array.getDimensionPixelSize(attr, mItemWhiteSpacing);
                break;
            case R.styleable.FreeNinePhotoLayout_free_npl_itemSpanCount:
                mItemSpanCount = array.getInteger(attr, mItemSpanCount);
                break;
            case R.styleable.FreeNinePhotoLayout_free_npl_itemWidth:
                mItemWidth = array.getDimensionPixelSize(attr, mItemWidth);
                break;
            case R.styleable.FreeNinePhotoLayout_free_npl_otherWhiteSpacing:
                mOtherWhiteSpacing = array.getDimensionPixelSize(attr, mOtherWhiteSpacing);
                break;
            case R.styleable.FreeNinePhotoLayout_free_npl_placeholderDrawable:
                mPlaceholderDrawableResId = array.getResourceId(attr, mPlaceholderDrawableResId);
                break;
        }
    }

    private void initDefaultAttrs(Context context) {
        mItemWidth = 0;
        mShowAsLargeWhenOnlyOne = true;
        mItemCornerRadius = 0;
        mItemWhiteSpacing = FreeUtil.dp2px(context, 4);
        mOtherWhiteSpacing = FreeUtil.dp2px(context, 100);
        mPlaceholderDrawableResId = R.mipmap.bga_pp_ic_holder_light;
        mItemSpanCount = 3;
    }


}
