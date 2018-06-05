package customViews;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.zhudongdong.drawcorners.R;

/**
 * Created by zhudongdong on 2018/4/27.
 */

public class TitleView extends RelativeLayout {

//    public TitleView(Context context, AttributeSet attrs) {
//        super(context, attrs);
//        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TitleAttr);
//
//        initLeftTextView(context, typedArray);
//        typedArray.recycle();
//    }

    private TextView mLeftBackTextTv;
    private TextView mRightTextTv;
    private int defaultTitleSize = 20;

    public TitleView(Context context) {
        this(context, null);
    }

    public TitleView(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public TitleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context ,attrs);
    }

    private void initView(Context context, AttributeSet attrs){
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TitleAttr);
        initLeftTextView(context, typedArray);
        initLeftImageView(context,typedArray);
        initTitleView(context ,typedArray);
        initRightView(context, typedArray);

        Drawable background = typedArray.getDrawable(R.styleable.TitleAttr_title_bg);
        if(null != background) {
            if(Build.VERSION.SDK_INT >= 16) {
                this.setBackground(background);
            } else {
                this.setBackgroundDrawable(background);
            }
        }
        typedArray.recycle();
    }

    private void initRightView(Context context, TypedArray typedArray) {
        int rightText = typedArray.getResourceId(R.styleable.TitleAttr_left_text, 0);
        CharSequence charSequence = rightText > 0 ?
                typedArray.getResources().getText(rightText) : typedArray.getString(R.styleable.TitleAttr_right_text);
        LayoutParams params = initLayoutParams();

        mRightTextTv = createTextView(context, R.id.tv_right_text, charSequence, params);
        setTextViewDrawable(typedArray, R.styleable.TitleAttr_right_text_drawable_left, R.styleable.TitleAttr_right_text_drawable_right,
                mRightTextTv);
        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        float textSize = getDimensionPixelSize(typedArray, R.styleable.TitleAttr_small_text_size, defaultTitleSize);
        mRightTextTv.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
        mRightTextTv.setTextColor(getTextColorFromAttr(typedArray));
        addView(mRightTextTv);
    }

    private TextView mTitleTv;

    //中间标题
    private void initTitleView(Context context, TypedArray typedArray){
        int leftText = typedArray.getResourceId(R.styleable.TitleAttr_title_name, 0);
        CharSequence charSequence = leftText > 0 ? typedArray.getResources().getText(leftText):
                typedArray.getString(R.styleable.TitleAttr_title_name);
        LayoutParams params = initLayoutParams();
        mTitleTv = createTextView(context, R.id.tv_title_name, charSequence, params);
        setTextViewDrawable(typedArray, R.styleable.TitleAttr_title_drawable_left, R.styleable.TitleAttr_right_text_drawable_left,
                mTitleTv);

        float textSize = getDimensionPixelSize(typedArray, R.styleable.TitleAttr_title_text_size, defaultTitleSize);
        mTitleTv.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
        mTitleTv.setTextColor(getTextColorFromAttr(typedArray));

        int gravity = typedArray.getInt(R.styleable.TitleAttr_title_gravity, 0);
        if (gravity > 0){
            if (gravity == Gravity.LEFT){
                params.addRule(RelativeLayout.RIGHT_OF, mLeftBackImageTv == null ? mLeftBackTextTv.getId():mLeftBackImageTv.getId());
            }
        }else {
            params.addRule(RelativeLayout.CENTER_IN_PARENT);
        }
        addView(mTitleTv);
    }

    private void initLeftTextView(Context context, TypedArray typedArray){
        //取 set 属性值, 如果不存在 取默认值
        int leftText = typedArray.getResourceId(R.styleable.TitleAttr_left_text, 0);
        CharSequence charSequence = leftText > 0 ?
                typedArray.getResources().getText(leftText) : typedArray.getString(R.styleable.TitleAttr_left_text);
        LayoutParams params = initLayoutParams();

        mLeftBackTextTv = createTextView(context, R.id.tv_left_text, charSequence, params);
        setTextViewDrawable(typedArray, R.styleable.TitleAttr_left_text_drawable_left, R.styleable.TitleAttr_left_text_drawable_right,
                mLeftBackTextTv);
        params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        float textSize = getDimensionPixelSize(typedArray, R.styleable.TitleAttr_small_text_size, defaultTitleSize);
        mLeftBackTextTv.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
        mLeftBackTextTv.setTextColor(getTextColorFromAttr(typedArray));
        addView(mLeftBackTextTv);
    }

    private ImageView mLeftBackImageTv;

    private void initLeftImageView(Context context, TypedArray typedArray){
        int leftImageAttr = typedArray.getResourceId(R.styleable.TitleAttr_left_image, 0);
        if (leftImageAttr != 0){
            LayoutParams params = initLayoutParams();
            mLeftBackImageTv = createImageView(context, R.id.iv_left_image, leftImageAttr, params);
        }
    }

    @NonNull
    private ImageView createImageView(Context context, int id, int drawable, LayoutParams params){
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(params);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setId(id);
        imageView.setMinimumWidth((int)getPixelSizeByDp(minViewWidth));
        imageView.setImageResource(drawable);
        return imageView;
    }

    private int textColor = 0xffffff;
    private int getTextColorFromAttr(TypedArray typedArray){
        int textColorStyleable = typedArray.getResourceId(R.styleable.TitleAttr_title_text_color, 0);
        if (textColorStyleable > 0){
            return typedArray.getResources().getColor(textColorStyleable);
        }else {
            return typedArray.getColor(R.styleable.TitleAttr_title_text_color, textColor);
        }
    }


    private float getDimensionPixelSize(TypedArray typedArray, int stylable, int defaultSize){
        int sizeStyleable = typedArray.getResourceId(stylable, 0);
        return sizeStyleable > 0 ? typedArray.getResources().getDimensionPixelSize(stylable):typedArray.getDimensionPixelSize(
                stylable,(int)getPixelSizeBySp(defaultSize));
    }

    private LayoutParams initLayoutParams(){
        return new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT);
    }

    private int drawablePadding = 3;

    private void setTextViewDrawable(TypedArray typedArray, int leftDrawableStyleable, int rightDrawableStyleable,
                                     TextView textView){
        int leftDrawable = typedArray.getResourceId(leftDrawableStyleable, 0);
        int rightDrawable = typedArray.getResourceId(rightDrawableStyleable, 0);
        textView.setCompoundDrawablePadding((int)getPixelSizeByDp(drawablePadding));
        textView.setCompoundDrawablesWithIntrinsicBounds(leftDrawable,0,rightDrawable,0);
    }

    private int minViewWidth = 35;

    private TextView createTextView(Context context, int id, CharSequence charSequence, LayoutParams params){
        TextView textView = new TextView(context);
        textView.setLayoutParams(params);
        textView.setGravity(Gravity.CENTER);
        textView.setId(id);
        textView.setMinWidth((int) getPixelSizeByDp(minViewWidth));
        textView.setText(charSequence);
        return textView;
    }

    private float getPixelSizeByDp(int dp){
        Resources resources = getResources();
        final float scale = resources.getDisplayMetrics().density;
        return dp * scale + 0.5f;
    }

    private float getPixelSizeBySp(int sp){
        final float scale = getResources().getDisplayMetrics().scaledDensity;
        return sp *scale + 0.5f;
    }


}
