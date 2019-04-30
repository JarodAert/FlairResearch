package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.appcompat.R.styleable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class LinearLayoutICS
  extends LinearLayout
{
  private static final int SHOW_DIVIDER_BEGINNING = 1;
  private static final int SHOW_DIVIDER_END = 4;
  private static final int SHOW_DIVIDER_MIDDLE = 2;
  private static final int SHOW_DIVIDER_NONE;
  private final Drawable mDivider;
  private final int mDividerHeight;
  private final int mDividerPadding;
  private final int mDividerWidth;
  private final int mShowDividers;
  
  public LinearLayoutICS(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.LinearLayoutICS);
    mDivider = localTypedArray.getDrawable(0);
    if (mDivider != null)
    {
      mDividerWidth = mDivider.getIntrinsicWidth();
      mDividerHeight = mDivider.getIntrinsicHeight();
      mShowDividers = localTypedArray.getInt(i, 0);
      mDividerPadding = localTypedArray.getDimensionPixelSize(2, 0);
      localTypedArray.recycle();
      if (mDivider != null) {
        break label110;
      }
    }
    for (;;)
    {
      setWillNotDraw(i);
      return;
      mDividerWidth = 0;
      mDividerHeight = 0;
      break;
      label110:
      int j = 0;
    }
  }
  
  void drawSupportDividersHorizontal(Canvas paramCanvas)
  {
    int i = getChildCount();
    for (int j = 0; j < i; j++)
    {
      View localView2 = getChildAt(j);
      if ((localView2 != null) && (localView2.getVisibility() != 8) && (hasSupportDividerBeforeChildAt(j)))
      {
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView2.getLayoutParams();
        drawSupportVerticalDivider(paramCanvas, localView2.getLeft() - leftMargin);
      }
    }
    View localView1;
    if (hasSupportDividerBeforeChildAt(i))
    {
      localView1 = getChildAt(i - 1);
      if (localView1 != null) {
        break label120;
      }
    }
    label120:
    for (int k = getWidth() - getPaddingRight() - mDividerWidth;; k = localView1.getRight())
    {
      drawSupportVerticalDivider(paramCanvas, k);
      return;
    }
  }
  
  void drawSupportDividersVertical(Canvas paramCanvas)
  {
    int i = getChildCount();
    for (int j = 0; j < i; j++)
    {
      View localView2 = getChildAt(j);
      if ((localView2 != null) && (localView2.getVisibility() != 8) && (hasSupportDividerBeforeChildAt(j)))
      {
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView2.getLayoutParams();
        drawSupportHorizontalDivider(paramCanvas, localView2.getTop() - topMargin);
      }
    }
    View localView1;
    if (hasSupportDividerBeforeChildAt(i))
    {
      localView1 = getChildAt(i - 1);
      if (localView1 != null) {
        break label120;
      }
    }
    label120:
    for (int k = getHeight() - getPaddingBottom() - mDividerHeight;; k = localView1.getBottom())
    {
      drawSupportHorizontalDivider(paramCanvas, k);
      return;
    }
  }
  
  void drawSupportHorizontalDivider(Canvas paramCanvas, int paramInt)
  {
    mDivider.setBounds(getPaddingLeft() + mDividerPadding, paramInt, getWidth() - getPaddingRight() - mDividerPadding, paramInt + mDividerHeight);
    mDivider.draw(paramCanvas);
  }
  
  void drawSupportVerticalDivider(Canvas paramCanvas, int paramInt)
  {
    mDivider.setBounds(paramInt, getPaddingTop() + mDividerPadding, paramInt + mDividerWidth, getHeight() - getPaddingBottom() - mDividerPadding);
    mDivider.draw(paramCanvas);
  }
  
  public int getSupportDividerWidth()
  {
    return mDividerWidth;
  }
  
  protected boolean hasSupportDividerBeforeChildAt(int paramInt)
  {
    if (paramInt == 0) {
      if ((0x1 & mShowDividers) == 0) {}
    }
    do
    {
      return true;
      return false;
      if (paramInt != getChildCount()) {
        break;
      }
    } while ((0x4 & mShowDividers) != 0);
    return false;
    if ((0x2 & mShowDividers) != 0) {
      for (int i = paramInt - 1;; i--)
      {
        boolean bool = false;
        if (i >= 0)
        {
          if (getChildAt(i).getVisibility() != 8) {
            bool = true;
          }
        }
        else {
          return bool;
        }
      }
    }
    return false;
  }
  
  protected void measureChildWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i;
    int j;
    LinearLayout.LayoutParams localLayoutParams;
    if (mDivider != null)
    {
      i = indexOfChild(paramView);
      j = getChildCount();
      localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
      if (getOrientation() != 1) {
        break label97;
      }
      if (!hasSupportDividerBeforeChildAt(i)) {
        break label67;
      }
      topMargin = mDividerHeight;
    }
    for (;;)
    {
      super.measureChildWithMargins(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
      label67:
      if ((i == j - 1) && (hasSupportDividerBeforeChildAt(j)))
      {
        bottomMargin = mDividerHeight;
        continue;
        label97:
        if (hasSupportDividerBeforeChildAt(i)) {
          leftMargin = mDividerWidth;
        } else if ((i == j - 1) && (hasSupportDividerBeforeChildAt(j))) {
          rightMargin = mDividerWidth;
        }
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (mDivider == null) {
      return;
    }
    if (getOrientation() == 1)
    {
      drawSupportDividersVertical(paramCanvas);
      return;
    }
    drawSupportDividersHorizontal(paramCanvas);
  }
}
