package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.internal.widget.LinearLayoutICS;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout.LayoutParams;

public class ActionMenuView
  extends LinearLayoutICS
  implements MenuBuilder.ItemInvoker, MenuView
{
  static final int GENERATED_ITEM_PADDING = 4;
  static final int MIN_CELL_SIZE = 56;
  private static final String TAG = "ActionMenuView";
  private boolean mFormatItems;
  private int mFormatItemsWidth;
  private int mGeneratedItemPadding;
  private int mMaxItemHeight;
  private int mMeasuredExtraWidth;
  private MenuBuilder mMenu;
  private int mMinCellSize;
  private ActionMenuPresenter mPresenter;
  private boolean mReserveOverflow;
  
  public ActionMenuView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setBaselineAligned(false);
    float f = getResourcesgetDisplayMetricsdensity;
    mMinCellSize = ((int)(56.0F * f));
    mGeneratedItemPadding = ((int)(4.0F * f));
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
    mMaxItemHeight = localTypedArray.getDimensionPixelSize(1, 0);
    localTypedArray.recycle();
  }
  
  static int measureChildForCells(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt3) - paramInt4, View.MeasureSpec.getMode(paramInt3));
    ActionMenuItemView localActionMenuItemView;
    int j;
    label54:
    int k;
    if ((paramView instanceof ActionMenuItemView))
    {
      localActionMenuItemView = (ActionMenuItemView)paramView;
      if ((localActionMenuItemView == null) || (!localActionMenuItemView.hasText())) {
        break label178;
      }
      j = 1;
      k = 0;
      if (paramInt2 > 0) {
        if (j != 0)
        {
          k = 0;
          if (paramInt2 < 2) {}
        }
        else
        {
          paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1 * paramInt2, Integer.MIN_VALUE), i);
          int m = paramView.getMeasuredWidth();
          k = m / paramInt1;
          if (m % paramInt1 != 0) {
            k++;
          }
          if ((j != 0) && (k < 2)) {
            k = 2;
          }
        }
      }
      if ((isOverflowButton) || (j == 0)) {
        break label184;
      }
    }
    label178:
    label184:
    for (boolean bool = true;; bool = false)
    {
      expandable = bool;
      cellsUsed = k;
      paramView.measure(View.MeasureSpec.makeMeasureSpec(k * paramInt1, 1073741824), i);
      return k;
      localActionMenuItemView = null;
      break;
      j = 0;
      break label54;
    }
  }
  
  private void onMeasureExactFormat(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getSize(paramInt2);
    int m = getPaddingLeft() + getPaddingRight();
    int n = getPaddingTop() + getPaddingBottom();
    if (i == 1073741824) {}
    int i2;
    int i3;
    int i4;
    for (int i1 = View.MeasureSpec.makeMeasureSpec(k - n, 1073741824);; i1 = View.MeasureSpec.makeMeasureSpec(Math.min(mMaxItemHeight, k - n), Integer.MIN_VALUE))
    {
      i2 = j - m;
      i3 = i2 / mMinCellSize;
      i4 = i2 % mMinCellSize;
      if (i3 != 0) {
        break;
      }
      setMeasuredDimension(i2, 0);
      return;
    }
    int i5 = mMinCellSize + i4 / i3;
    int i6 = i3;
    int i7 = 0;
    int i8 = 0;
    int i9 = 0;
    int i10 = 0;
    int i11 = 0;
    long l1 = 0L;
    int i12 = getChildCount();
    int i13 = 0;
    while (i13 < i12)
    {
      View localView4 = getChildAt(i13);
      if (localView4.getVisibility() == 8)
      {
        i13++;
      }
      else
      {
        boolean bool1 = localView4 instanceof ActionMenuItemView;
        i10++;
        if (bool1) {
          localView4.setPadding(mGeneratedItemPadding, 0, mGeneratedItemPadding, 0);
        }
        LayoutParams localLayoutParams5 = (LayoutParams)localView4.getLayoutParams();
        expanded = false;
        extraPixels = 0;
        cellsUsed = 0;
        expandable = false;
        leftMargin = 0;
        rightMargin = 0;
        boolean bool2;
        if ((bool1) && (((ActionMenuItemView)localView4).hasText()))
        {
          bool2 = true;
          label286:
          preventEdgeOffset = bool2;
          if (!isOverflowButton) {
            break label398;
          }
        }
        label398:
        for (int i26 = 1;; i26 = i6)
        {
          int i27 = measureChildForCells(localView4, i5, i26, i1, n);
          i8 = Math.max(i8, i27);
          if (expandable) {
            i9++;
          }
          if (isOverflowButton) {
            i11 = 1;
          }
          i6 -= i27;
          int i28 = localView4.getMeasuredHeight();
          i7 = Math.max(i7, i28);
          if (i27 != 1) {
            break;
          }
          l1 |= 1 << i13;
          break;
          bool2 = false;
          break label286;
        }
      }
    }
    int i14;
    int i15;
    int i21;
    long l2;
    int i22;
    int i23;
    label445:
    LayoutParams localLayoutParams4;
    if ((i11 != 0) && (i10 == 2))
    {
      i14 = 1;
      i15 = 0;
      if ((i9 <= 0) || (i6 <= 0)) {
        break label556;
      }
      i21 = Integer.MAX_VALUE;
      l2 = 0L;
      i22 = 0;
      i23 = 0;
      if (i23 >= i12) {
        break label542;
      }
      localLayoutParams4 = (LayoutParams)getChildAt(i23).getLayoutParams();
      if (expandable) {
        break label486;
      }
    }
    for (;;)
    {
      i23++;
      break label445;
      i14 = 0;
      break;
      label486:
      if (cellsUsed < i21)
      {
        i21 = cellsUsed;
        l2 = 1 << i23;
        i22 = 1;
      }
      else if (cellsUsed == i21)
      {
        l2 |= 1 << i23;
        i22++;
      }
    }
    label542:
    l1 |= l2;
    label556:
    int i16;
    label570:
    int i18;
    label709:
    int i19;
    if (i22 > i6)
    {
      if ((i11 != 0) || (i10 != 1)) {
        break label878;
      }
      i16 = 1;
      if ((i6 <= 0) || (l1 == 0L) || ((i6 >= i10 - 1) && (i16 == 0) && (i8 <= 1))) {
        break label1037;
      }
      float f = Long.bitCount(l1);
      if (i16 == 0)
      {
        if (((1L & l1) != 0L) && (!getChildAt0getLayoutParamspreventEdgeOffset)) {
          f -= 0.5F;
        }
        if (((l1 & 1 << i12 - 1) != 0L) && (!getChildAt1getLayoutParamspreventEdgeOffset)) {
          f -= 0.5F;
        }
      }
      if (f <= 0.0F) {
        break label884;
      }
      i18 = (int)(i6 * i5 / f);
      i19 = 0;
      label712:
      if (i19 >= i12) {
        break label1034;
      }
      if ((l1 & 1 << i19) != 0L) {
        break label890;
      }
    }
    for (;;)
    {
      i19++;
      break label712;
      int i24 = i21 + 1;
      int i25 = 0;
      if (i25 < i12)
      {
        View localView3 = getChildAt(i25);
        LayoutParams localLayoutParams3 = (LayoutParams)localView3.getLayoutParams();
        if ((l2 & 1 << i25) == 0L) {
          if (cellsUsed == i24) {
            l1 |= 1 << i25;
          }
        }
        for (;;)
        {
          i25++;
          break;
          if ((i14 != 0) && (preventEdgeOffset) && (i6 == 1)) {
            localView3.setPadding(i5 + mGeneratedItemPadding, 0, mGeneratedItemPadding, 0);
          }
          cellsUsed = (1 + cellsUsed);
          expanded = true;
          i6--;
        }
      }
      i15 = 1;
      break;
      label878:
      i16 = 0;
      break label570;
      label884:
      i18 = 0;
      break label709;
      label890:
      View localView2 = getChildAt(i19);
      LayoutParams localLayoutParams2 = (LayoutParams)localView2.getLayoutParams();
      if ((localView2 instanceof ActionMenuItemView))
      {
        extraPixels = i18;
        expanded = true;
        if ((i19 == 0) && (!preventEdgeOffset)) {
          leftMargin = (-i18 / 2);
        }
        i15 = 1;
      }
      else if (isOverflowButton)
      {
        extraPixels = i18;
        expanded = true;
        rightMargin = (-i18 / 2);
        i15 = 1;
      }
      else
      {
        if (i19 != 0) {
          leftMargin = (i18 / 2);
        }
        int i20 = i12 - 1;
        if (i19 != i20) {
          rightMargin = (i18 / 2);
        }
      }
    }
    label1034:
    i6 = 0;
    label1037:
    if (i15 != 0)
    {
      int i17 = 0;
      if (i17 < i12)
      {
        View localView1 = getChildAt(i17);
        LayoutParams localLayoutParams1 = (LayoutParams)localView1.getLayoutParams();
        if (!expanded) {}
        for (;;)
        {
          i17++;
          break;
          localView1.measure(View.MeasureSpec.makeMeasureSpec(i5 * cellsUsed + extraPixels, 1073741824), i1);
        }
      }
    }
    if (i != 1073741824) {
      k = i7;
    }
    setMeasuredDimension(i2, k);
    mMeasuredExtraWidth = (i6 * i5);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return (paramLayoutParams != null) && ((paramLayoutParams instanceof LayoutParams));
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    return false;
  }
  
  protected LayoutParams generateDefaultLayoutParams()
  {
    LayoutParams localLayoutParams = new LayoutParams(-2, -2);
    gravity = 16;
    return localLayoutParams;
  }
  
  public LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof LayoutParams))
    {
      LayoutParams localLayoutParams = new LayoutParams((LayoutParams)paramLayoutParams);
      if (gravity <= 0) {
        gravity = 16;
      }
      return localLayoutParams;
    }
    return generateDefaultLayoutParams();
  }
  
  public LayoutParams generateOverflowButtonLayoutParams()
  {
    LayoutParams localLayoutParams = generateDefaultLayoutParams();
    isOverflowButton = true;
    return localLayoutParams;
  }
  
  public int getWindowAnimations()
  {
    return 0;
  }
  
  protected boolean hasSupportDividerBeforeChildAt(int paramInt)
  {
    View localView1 = getChildAt(paramInt - 1);
    View localView2 = getChildAt(paramInt);
    int i = getChildCount();
    boolean bool1 = false;
    if (paramInt < i)
    {
      boolean bool2 = localView1 instanceof ActionMenuChildView;
      bool1 = false;
      if (bool2) {
        bool1 = false | ((ActionMenuChildView)localView1).needsDividerAfter();
      }
    }
    if ((paramInt > 0) && ((localView2 instanceof ActionMenuChildView))) {
      bool1 |= ((ActionMenuChildView)localView2).needsDividerBefore();
    }
    return bool1;
  }
  
  public void initialize(MenuBuilder paramMenuBuilder)
  {
    mMenu = paramMenuBuilder;
  }
  
  public boolean invokeItem(MenuItemImpl paramMenuItemImpl)
  {
    return mMenu.performItemAction(paramMenuItemImpl, 0);
  }
  
  public boolean isExpandedFormat()
  {
    return mFormatItems;
  }
  
  public boolean isOverflowReserved()
  {
    return mReserveOverflow;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (Build.VERSION.SDK_INT >= 8) {
      super.onConfigurationChanged(paramConfiguration);
    }
    mPresenter.updateMenuView(false);
    if ((mPresenter != null) && (mPresenter.isOverflowMenuShowing()))
    {
      mPresenter.hideOverflowMenu();
      mPresenter.showOverflowMenu();
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    mPresenter.dismissPopupMenus();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!mFormatItems)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    int i = getChildCount();
    int j = (paramInt2 + paramInt4) / 2;
    int k = getSupportDividerWidth();
    int m = 0;
    int n = 0;
    int i1 = paramInt3 - paramInt1 - getPaddingRight() - getPaddingLeft();
    int i2 = 0;
    int i3 = 0;
    if (i3 < i)
    {
      View localView3 = getChildAt(i3);
      if (localView3.getVisibility() == 8) {}
      for (;;)
      {
        i3++;
        break;
        LayoutParams localLayoutParams2 = (LayoutParams)localView3.getLayoutParams();
        if (isOverflowButton)
        {
          int i19 = localView3.getMeasuredWidth();
          if (hasSupportDividerBeforeChildAt(i3)) {
            i19 += k;
          }
          int i20 = localView3.getMeasuredHeight();
          int i21 = getWidth() - getPaddingRight() - rightMargin;
          int i22 = i21 - i19;
          int i23 = j - i20 / 2;
          localView3.layout(i22, i23, i21, i23 + i20);
          i1 -= i19;
          i2 = 1;
        }
        else
        {
          int i18 = localView3.getMeasuredWidth() + leftMargin + rightMargin;
          m += i18;
          i1 -= i18;
          if (hasSupportDividerBeforeChildAt(i3)) {
            m += k;
          }
          n++;
        }
      }
    }
    if ((i == 1) && (i2 == 0))
    {
      View localView2 = getChildAt(0);
      int i14 = localView2.getMeasuredWidth();
      int i15 = localView2.getMeasuredHeight();
      int i16 = (paramInt3 - paramInt1) / 2 - i14 / 2;
      int i17 = j - i15 / 2;
      localView2.layout(i16, i17, i16 + i14, i17 + i15);
      return;
    }
    int i4;
    label345:
    int i6;
    label364:
    int i7;
    int i8;
    int i9;
    label381:
    View localView1;
    LayoutParams localLayoutParams1;
    if (i2 != 0)
    {
      i4 = 0;
      int i5 = n - i4;
      if (i5 <= 0) {
        break label436;
      }
      i6 = i1 / i5;
      i7 = Math.max(0, i6);
      i8 = getPaddingLeft();
      i9 = 0;
      if (i9 < i)
      {
        localView1 = getChildAt(i9);
        localLayoutParams1 = (LayoutParams)localView1.getLayoutParams();
        if ((localView1.getVisibility() != 8) && (!isOverflowButton)) {
          break label442;
        }
      }
    }
    for (;;)
    {
      i9++;
      break label381;
      break;
      i4 = 1;
      break label345;
      label436:
      i6 = 0;
      break label364;
      label442:
      int i10 = i8 + leftMargin;
      int i11 = localView1.getMeasuredWidth();
      int i12 = localView1.getMeasuredHeight();
      int i13 = j - i12 / 2;
      localView1.layout(i10, i13, i10 + i11, i13 + i12);
      i8 = i10 + (i7 + (i11 + rightMargin));
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    boolean bool1 = mFormatItems;
    if (View.MeasureSpec.getMode(paramInt1) == 1073741824) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      mFormatItems = bool2;
      if (bool1 != mFormatItems) {
        mFormatItemsWidth = 0;
      }
      int i = View.MeasureSpec.getMode(paramInt1);
      if ((mFormatItems) && (mMenu != null) && (i != mFormatItemsWidth))
      {
        mFormatItemsWidth = i;
        mMenu.onItemsChanged(true);
      }
      if (!mFormatItems) {
        break;
      }
      onMeasureExactFormat(paramInt1, paramInt2);
      return;
    }
    int j = getChildCount();
    for (int k = 0; k < j; k++)
    {
      LayoutParams localLayoutParams = (LayoutParams)getChildAt(k).getLayoutParams();
      rightMargin = 0;
      leftMargin = 0;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setOverflowReserved(boolean paramBoolean)
  {
    mReserveOverflow = paramBoolean;
  }
  
  public void setPresenter(ActionMenuPresenter paramActionMenuPresenter)
  {
    mPresenter = paramActionMenuPresenter;
  }
  
  public static abstract interface ActionMenuChildView
  {
    public abstract boolean needsDividerAfter();
    
    public abstract boolean needsDividerBefore();
  }
  
  public static class LayoutParams
    extends LinearLayout.LayoutParams
  {
    @ViewDebug.ExportedProperty
    public int cellsUsed;
    @ViewDebug.ExportedProperty
    public boolean expandable;
    public boolean expanded;
    @ViewDebug.ExportedProperty
    public int extraPixels;
    @ViewDebug.ExportedProperty
    public boolean isOverflowButton;
    @ViewDebug.ExportedProperty
    public boolean preventEdgeOffset;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
      isOverflowButton = false;
    }
    
    public LayoutParams(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      super(paramInt2);
      isOverflowButton = paramBoolean;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      isOverflowButton = isOverflowButton;
    }
  }
}
