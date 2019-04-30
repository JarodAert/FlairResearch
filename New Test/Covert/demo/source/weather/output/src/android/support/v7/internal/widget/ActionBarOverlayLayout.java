package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.v7.app.ActionBar;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.id;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class ActionBarOverlayLayout
  extends FrameLayout
{
  static final int[] mActionBarSizeAttr;
  private ActionBar mActionBar;
  private View mActionBarBottom;
  private int mActionBarHeight;
  private View mActionBarTop;
  private ActionBarView mActionView;
  private ActionBarContainer mContainerView;
  private View mContent;
  private final Rect mZeroRect = new Rect(0, 0, 0, 0);
  
  static
  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = R.attr.actionBarSize;
    mActionBarSizeAttr = arrayOfInt;
  }
  
  public ActionBarOverlayLayout(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public ActionBarOverlayLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  private boolean applyInsets(View paramView, Rect paramRect, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    boolean bool = false;
    if (paramBoolean1)
    {
      int i = leftMargin;
      int j = left;
      bool = false;
      if (i != j)
      {
        bool = true;
        leftMargin = left;
      }
    }
    if ((paramBoolean2) && (topMargin != top))
    {
      bool = true;
      topMargin = top;
    }
    if ((paramBoolean4) && (rightMargin != right))
    {
      bool = true;
      rightMargin = right;
    }
    if ((paramBoolean3) && (bottomMargin != bottom))
    {
      bool = true;
      bottomMargin = bottom;
    }
    return bool;
  }
  
  private void init(Context paramContext)
  {
    TypedArray localTypedArray = getContext().getTheme().obtainStyledAttributes(mActionBarSizeAttr);
    mActionBarHeight = localTypedArray.getDimensionPixelSize(0, 0);
    localTypedArray.recycle();
  }
  
  void pullChildren()
  {
    if (mContent == null)
    {
      mContent = findViewById(R.id.action_bar_activity_content);
      if (mContent == null) {
        mContent = findViewById(16908290);
      }
      mActionBarTop = findViewById(R.id.top_action_bar);
      mContainerView = ((ActionBarContainer)findViewById(R.id.action_bar_container));
      mActionView = ((ActionBarView)findViewById(R.id.action_bar));
      mActionBarBottom = findViewById(R.id.split_action_bar);
    }
  }
  
  public void setActionBar(ActionBar paramActionBar)
  {
    mActionBar = paramActionBar;
  }
}
