package android.support.constraint;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.constraint.solver.widgets.Animator;
import android.support.constraint.solver.widgets.ConstraintAnchor;
import android.support.constraint.solver.widgets.ConstraintAnchor.Strength;
import android.support.constraint.solver.widgets.ConstraintAnchor.Type;
import android.support.constraint.solver.widgets.ConstraintWidget;
import android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour;
import android.support.constraint.solver.widgets.ConstraintWidgetContainer;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.ArrayList;

public class ConstraintLayout
  extends ViewGroup
{
  static final boolean ALLOWS_EMBEDDED = false;
  private static final boolean SIMPLE_LAYOUT = true;
  private static final String TAG = "ConstraintLayout";
  public static final String VERSION = "ConstraintLayout-1.0-beta4";
  SparseArray<View> mChildrenByIds = new SparseArray();
  private boolean mDirtyHierarchy = true;
  ConstraintWidgetContainer mLayoutWidget = new ConstraintWidgetContainer();
  private int mMaxHeight = Integer.MAX_VALUE;
  private int mMaxWidth = Integer.MAX_VALUE;
  private int mMinHeight = 0;
  private int mMinWidth = 0;
  private int mOptimizationLevel = 2;
  private final ArrayList<ConstraintWidget> mVariableDimensionsWidgets = new ArrayList(100);
  int previousHeightMeasureSpec = -1;
  int previousPaddingLeft = -1;
  int previousPaddingTop = -1;
  int previousWidthMeasureSpec = -1;
  
  public ConstraintLayout(Context paramContext)
  {
    super(paramContext);
    init(null);
  }
  
  public ConstraintLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramAttributeSet);
  }
  
  public ConstraintLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramAttributeSet);
  }
  
  private final ConstraintWidget getTargetWidget(int paramInt)
  {
    if (paramInt == 0) {
      return mLayoutWidget;
    }
    View localView = (View)mChildrenByIds.get(paramInt);
    if (localView == this) {
      return mLayoutWidget;
    }
    if (localView == null) {
      return null;
    }
    return getLayoutParamswidget;
  }
  
  private final ConstraintWidget getViewWidget(View paramView)
  {
    if (paramView == this) {
      return mLayoutWidget;
    }
    if (paramView == null) {
      return null;
    }
    return getLayoutParamswidget;
  }
  
  private void init(AttributeSet paramAttributeSet)
  {
    mLayoutWidget.setCompanionWidget(this);
    mChildrenByIds.put(getId(), this);
    if (paramAttributeSet != null)
    {
      TypedArray localTypedArray = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_Layout);
      int i = localTypedArray.getIndexCount();
      int j = 0;
      if (j < i)
      {
        int k = localTypedArray.getIndex(j);
        if (k == R.styleable.ConstraintLayout_Layout_android_minWidth) {
          mMinWidth = localTypedArray.getDimensionPixelOffset(k, mMinWidth);
        }
        for (;;)
        {
          j++;
          break;
          if (k == R.styleable.ConstraintLayout_Layout_android_minHeight) {
            mMinHeight = localTypedArray.getDimensionPixelOffset(k, mMinHeight);
          } else if (k == R.styleable.ConstraintLayout_Layout_android_maxWidth) {
            mMaxWidth = localTypedArray.getDimensionPixelOffset(k, mMaxWidth);
          } else if (k == R.styleable.ConstraintLayout_Layout_android_maxHeight) {
            mMaxHeight = localTypedArray.getDimensionPixelOffset(k, mMaxHeight);
          } else if (k == R.styleable.ConstraintLayout_Layout_layout_optimizationLevel) {
            mOptimizationLevel = localTypedArray.getInt(k, mOptimizationLevel);
          }
        }
      }
    }
  }
  
  private void internalMeasureChildren(int paramInt1, int paramInt2)
  {
    int i = getPaddingTop() + getPaddingBottom();
    int j = getPaddingLeft() + getPaddingRight();
    int k = getChildCount();
    int m = 0;
    if (m < k)
    {
      View localView = getChildAt(m);
      if (localView.getVisibility() == 8) {}
      LayoutParams localLayoutParams;
      ConstraintWidget localConstraintWidget;
      do
      {
        m++;
        break;
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        localConstraintWidget = widget;
      } while (isGuideline);
      int n = width;
      int i1 = height;
      int i2;
      if ((horizontalDimensionFixed) || (verticalDimensionFixed))
      {
        if (n != 0) {
          break label213;
        }
        i2 = getChildMeasureSpec(paramInt1, j, -2);
        label131:
        if (i1 != 0) {
          break label226;
        }
      }
      label213:
      label226:
      for (int i3 = getChildMeasureSpec(paramInt2, i, -2);; i3 = getChildMeasureSpec(paramInt2, i, i1))
      {
        localView.measure(i2, i3);
        n = localView.getMeasuredWidth();
        i1 = localView.getMeasuredHeight();
        localConstraintWidget.setWidth(n);
        localConstraintWidget.setHeight(i1);
        if (!needsBaseline) {
          break;
        }
        int i4 = localView.getBaseline();
        if (i4 == -1) {
          break;
        }
        localConstraintWidget.setBaselineDistance(i4);
        break;
        i2 = getChildMeasureSpec(paramInt1, j, n);
        break label131;
      }
    }
  }
  
  private void setChildrenConstraints()
  {
    int i = getChildCount();
    int j = 0;
    if (j < i)
    {
      View localView1 = getChildAt(j);
      ConstraintWidget localConstraintWidget1 = getViewWidget(localView1);
      if (localConstraintWidget1 == null) {}
      LayoutParams localLayoutParams1;
      label178:
      do
      {
        for (;;)
        {
          j++;
          break;
          localLayoutParams1 = (LayoutParams)localView1.getLayoutParams();
          localConstraintWidget1.reset();
          localConstraintWidget1.setParent(mLayoutWidget);
          localConstraintWidget1.setVisibility(localView1.getVisibility());
          localConstraintWidget1.setCompanionWidget(localView1);
          if ((!verticalDimensionFixed) || (!horizontalDimensionFixed)) {
            mVariableDimensionsWidgets.add(localConstraintWidget1);
          }
          if (!isGuideline) {
            break label178;
          }
          android.support.constraint.solver.widgets.Guideline localGuideline = (android.support.constraint.solver.widgets.Guideline)localConstraintWidget1;
          if (guideBegin != -1) {
            localGuideline.setGuideBegin(guideBegin);
          }
          if (guideEnd != -1) {
            localGuideline.setGuideEnd(guideEnd);
          }
          if (guidePercent != -1.0F) {
            localGuideline.setGuidePercent(guidePercent);
          }
        }
      } while ((resolvedLeftToLeft == -1) && (resolvedLeftToRight == -1) && (resolvedRightToLeft == -1) && (resolvedRightToRight == -1) && (topToTop == -1) && (topToBottom == -1) && (bottomToTop == -1) && (bottomToBottom == -1) && (baselineToBaseline == -1) && (editorAbsoluteX == -1) && (editorAbsoluteY == -1));
      int k = resolvedLeftToLeft;
      int m = resolvedLeftToRight;
      int n = resolvedRightToLeft;
      int i1 = resolvedRightToRight;
      int i2 = resolveGoneLeftMargin;
      int i3 = resolveGoneRightMargin;
      float f = resolvedHorizontalBias;
      if (Build.VERSION.SDK_INT < 17)
      {
        k = leftToLeft;
        m = leftToRight;
        n = rightToLeft;
        i1 = rightToRight;
        i2 = goneLeftMargin;
        i3 = goneRightMargin;
        f = horizontalBias;
        if ((k == -1) && (m == -1))
        {
          if (startToStart == -1) {
            break label984;
          }
          k = startToStart;
        }
        label411:
        if ((n == -1) && (i1 == -1))
        {
          if (endToStart == -1) {
            break label1003;
          }
          n = endToStart;
        }
      }
      label439:
      if (k != -1)
      {
        ConstraintWidget localConstraintWidget10 = getTargetWidget(k);
        if (localConstraintWidget10 != null) {
          localConstraintWidget1.immediateConnect(ConstraintAnchor.Type.LEFT, localConstraintWidget10, ConstraintAnchor.Type.LEFT, leftMargin, i2);
        }
        label478:
        if (n == -1) {
          break label1064;
        }
        ConstraintWidget localConstraintWidget9 = getTargetWidget(n);
        if (localConstraintWidget9 != null) {
          localConstraintWidget1.immediateConnect(ConstraintAnchor.Type.RIGHT, localConstraintWidget9, ConstraintAnchor.Type.LEFT, rightMargin, i3);
        }
        label517:
        if (topToTop == -1) {
          break label1106;
        }
        ConstraintWidget localConstraintWidget8 = getTargetWidget(topToTop);
        if (localConstraintWidget8 != null) {
          localConstraintWidget1.immediateConnect(ConstraintAnchor.Type.TOP, localConstraintWidget8, ConstraintAnchor.Type.TOP, topMargin, goneTopMargin);
        }
        label565:
        if (bottomToTop == -1) {
          break label1157;
        }
        ConstraintWidget localConstraintWidget7 = getTargetWidget(bottomToTop);
        if (localConstraintWidget7 != null) {
          localConstraintWidget1.immediateConnect(ConstraintAnchor.Type.BOTTOM, localConstraintWidget7, ConstraintAnchor.Type.TOP, bottomMargin, goneBottomMargin);
        }
        label613:
        if (baselineToBaseline != -1)
        {
          View localView2 = (View)mChildrenByIds.get(baselineToBaseline);
          ConstraintWidget localConstraintWidget6 = getTargetWidget(baselineToBaseline);
          if ((localConstraintWidget6 != null) && (localView2 != null) && ((localView2.getLayoutParams() instanceof LayoutParams)))
          {
            LayoutParams localLayoutParams2 = (LayoutParams)localView2.getLayoutParams();
            needsBaseline = true;
            needsBaseline = true;
            localConstraintWidget1.getAnchor(ConstraintAnchor.Type.BASELINE).connect(localConstraintWidget6.getAnchor(ConstraintAnchor.Type.BASELINE), 0, -1, ConstraintAnchor.Strength.STRONG, 0, true);
            localConstraintWidget1.getAnchor(ConstraintAnchor.Type.TOP).reset();
            localConstraintWidget1.getAnchor(ConstraintAnchor.Type.BOTTOM).reset();
          }
        }
        if ((f >= 0.0F) && (f != 0.5F)) {
          localConstraintWidget1.setHorizontalBiasPercent(f);
        }
        if ((verticalBias >= 0.0F) && (verticalBias != 0.5F)) {
          localConstraintWidget1.setVerticalBiasPercent(verticalBias);
        }
        if (horizontalDimensionFixed) {
          break label1208;
        }
        localConstraintWidget1.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
        localConstraintWidget1.setWidth(0);
        if (width == -1) {
          localConstraintWidget1.setWidth(mLayoutWidget.getWidth());
        }
        label840:
        if (verticalDimensionFixed) {
          break label1229;
        }
        localConstraintWidget1.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
        localConstraintWidget1.setHeight(0);
        if (height == -1) {
          localConstraintWidget1.setWidth(mLayoutWidget.getHeight());
        }
      }
      for (;;)
      {
        if ((isInEditMode()) && ((editorAbsoluteX != -1) || (editorAbsoluteY != -1))) {
          localConstraintWidget1.setOrigin(editorAbsoluteX, editorAbsoluteY);
        }
        if (dimensionRatio != null) {
          localConstraintWidget1.setDimensionRatio(dimensionRatio);
        }
        localConstraintWidget1.setHorizontalWeight(horizontalWeight);
        localConstraintWidget1.setVerticalWeight(verticalWeight);
        localConstraintWidget1.setHorizontalChainStyle(horizontalChainStyle);
        localConstraintWidget1.setVerticalChainStyle(verticalChainStyle);
        break;
        label984:
        if (startToEnd == -1) {
          break label411;
        }
        m = startToEnd;
        break label411;
        label1003:
        if (endToEnd == -1) {
          break label439;
        }
        i1 = endToEnd;
        break label439;
        if (m == -1) {
          break label478;
        }
        ConstraintWidget localConstraintWidget2 = getTargetWidget(m);
        if (localConstraintWidget2 == null) {
          break label478;
        }
        localConstraintWidget1.immediateConnect(ConstraintAnchor.Type.LEFT, localConstraintWidget2, ConstraintAnchor.Type.RIGHT, leftMargin, i2);
        break label478;
        label1064:
        if (i1 == -1) {
          break label517;
        }
        ConstraintWidget localConstraintWidget3 = getTargetWidget(i1);
        if (localConstraintWidget3 == null) {
          break label517;
        }
        localConstraintWidget1.immediateConnect(ConstraintAnchor.Type.RIGHT, localConstraintWidget3, ConstraintAnchor.Type.RIGHT, rightMargin, i3);
        break label517;
        label1106:
        if (topToBottom == -1) {
          break label565;
        }
        ConstraintWidget localConstraintWidget4 = getTargetWidget(topToBottom);
        if (localConstraintWidget4 == null) {
          break label565;
        }
        localConstraintWidget1.immediateConnect(ConstraintAnchor.Type.TOP, localConstraintWidget4, ConstraintAnchor.Type.BOTTOM, topMargin, goneTopMargin);
        break label565;
        label1157:
        if (bottomToBottom == -1) {
          break label613;
        }
        ConstraintWidget localConstraintWidget5 = getTargetWidget(bottomToBottom);
        if (localConstraintWidget5 == null) {
          break label613;
        }
        localConstraintWidget1.immediateConnect(ConstraintAnchor.Type.BOTTOM, localConstraintWidget5, ConstraintAnchor.Type.BOTTOM, bottomMargin, goneBottomMargin);
        break label613;
        label1208:
        localConstraintWidget1.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        localConstraintWidget1.setWidth(width);
        break label840;
        label1229:
        localConstraintWidget1.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        localConstraintWidget1.setHeight(height);
      }
    }
  }
  
  private void setSelfDimensionBehaviour(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getMode(paramInt2);
    int m = View.MeasureSpec.getSize(paramInt2);
    int n = getPaddingTop() + getPaddingBottom();
    int i1 = getPaddingLeft() + getPaddingRight();
    ConstraintWidget.DimensionBehaviour localDimensionBehaviour1 = ConstraintWidget.DimensionBehaviour.FIXED;
    ConstraintWidget.DimensionBehaviour localDimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.FIXED;
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    int i2 = 0;
    int i3;
    switch (i)
    {
    default: 
      i3 = 0;
      switch (k)
      {
      }
      break;
    }
    for (;;)
    {
      mLayoutWidget.setMinWidth(mMinWidth);
      mLayoutWidget.setMinHeight(mMinHeight);
      mLayoutWidget.setHorizontalDimensionBehaviour(localDimensionBehaviour1);
      mLayoutWidget.setWidth(i2);
      mLayoutWidget.setVerticalDimensionBehaviour(localDimensionBehaviour2);
      mLayoutWidget.setHeight(i3);
      return;
      localDimensionBehaviour1 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
      i2 = 0;
      break;
      if (width > 0)
      {
        i2 = Math.min(mMaxWidth, width);
        break;
      }
      localDimensionBehaviour1 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
      i2 = 0;
      break;
      i2 = Math.min(mMaxWidth, j) - i1;
      break;
      localDimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
      i3 = 0;
      continue;
      if (height > 0)
      {
        i3 = Math.min(mMaxHeight, height);
      }
      else
      {
        localDimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        i3 = 0;
        continue;
        i3 = Math.min(mMaxHeight, m) - n;
      }
    }
  }
  
  private void updateHierarchy()
  {
    int i = getChildCount();
    for (int j = 0;; j++)
    {
      int k = 0;
      if (j < i)
      {
        if (getChildAt(j).isLayoutRequested()) {
          k = 1;
        }
      }
      else
      {
        if (k != 0)
        {
          mVariableDimensionsWidgets.clear();
          setChildrenConstraints();
        }
        return;
      }
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
    if (Build.VERSION.SDK_INT < 14) {
      onViewAdded(paramView);
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  protected LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams(-2, -2);
  }
  
  public LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new LayoutParams(paramLayoutParams);
  }
  
  public int getMaxHeight()
  {
    return mMaxHeight;
  }
  
  public int getMaxWidth()
  {
    return mMaxWidth;
  }
  
  public int getMinHeight()
  {
    return mMinHeight;
  }
  
  public int getMinWidth()
  {
    return mMinWidth;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getChildCount();
    int j = 0;
    if (j < i)
    {
      View localView = getChildAt(j);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if ((localView.getVisibility() == 8) && (!isGuideline)) {}
      for (;;)
      {
        j++;
        break;
        ConstraintWidget localConstraintWidget = widget;
        int k = localConstraintWidget.getDrawX();
        int m = localConstraintWidget.getDrawY();
        localView.layout(k, m, k + localConstraintWidget.getWidth(), m + localConstraintWidget.getHeight());
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = getPaddingLeft();
    int j = getPaddingTop();
    if ((previousPaddingLeft == -1) || (previousPaddingTop == -1) || (previousHeightMeasureSpec == -1) || (previousWidthMeasureSpec == -1) || (previousPaddingLeft != i) || (previousPaddingTop != j) || (previousWidthMeasureSpec != paramInt1) || (previousHeightMeasureSpec != paramInt2))
    {
      mLayoutWidget.setX(i);
      mLayoutWidget.setY(j);
      setSelfDimensionBehaviour(paramInt1, paramInt2);
    }
    if (mDirtyHierarchy)
    {
      mDirtyHierarchy = false;
      updateHierarchy();
    }
    previousPaddingLeft = i;
    previousPaddingTop = j;
    previousWidthMeasureSpec = paramInt1;
    previousHeightMeasureSpec = paramInt2;
    internalMeasureChildren(paramInt1, paramInt2);
    if (getChildCount() > 0) {
      solveLinearSystem();
    }
    int k = mVariableDimensionsWidgets.size();
    int m = j + getPaddingBottom();
    int n = i + getPaddingRight();
    int i1 = 0;
    if (k > 0)
    {
      int i8 = 0;
      int i9 = 0;
      if (i9 < k)
      {
        ConstraintWidget localConstraintWidget = (ConstraintWidget)mVariableDimensionsWidgets.get(i9);
        if ((localConstraintWidget instanceof android.support.constraint.solver.widgets.Guideline)) {}
        View localView;
        do
        {
          i9++;
          break;
          localView = (View)localConstraintWidget.getCompanionWidget();
        } while ((localView == null) || (localView.getVisibility() == 8));
        int i10 = View.MeasureSpec.makeMeasureSpec(localConstraintWidget.getWidth(), 1073741824);
        int i11 = View.MeasureSpec.makeMeasureSpec(localConstraintWidget.getHeight(), 1073741824);
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (width == -2) {
          i10 = getChildMeasureSpec(paramInt1, n, width);
        }
        for (;;)
        {
          localView.measure(i10, i11);
          int i12 = localView.getMeasuredWidth();
          int i13 = localView.getMeasuredHeight();
          if (i12 != localConstraintWidget.getWidth())
          {
            localConstraintWidget.setWidth(i12);
            i8 = 1;
          }
          if (i13 != localConstraintWidget.getHeight())
          {
            localConstraintWidget.setHeight(i13);
            i8 = 1;
          }
          if (needsBaseline)
          {
            int i14 = localView.getBaseline();
            if ((i14 != -1) && (i14 != localConstraintWidget.getBaselineDistance()))
            {
              localConstraintWidget.setBaselineDistance(i14);
              i8 = 1;
            }
          }
          if (Build.VERSION.SDK_INT < 11) {
            break;
          }
          i1 = combineMeasuredStates(i1, localView.getMeasuredState());
          break;
          if (height == -2) {
            i11 = getChildMeasureSpec(paramInt2, m, height);
          }
        }
      }
      if (i8 != 0) {
        solveLinearSystem();
      }
    }
    int i2 = n + mLayoutWidget.getWidth();
    int i3 = m + mLayoutWidget.getHeight();
    if (Build.VERSION.SDK_INT >= 11)
    {
      int i4 = resolveSizeAndState(i2, paramInt1, i1);
      int i5 = resolveSizeAndState(i3, paramInt2, i1 << 16);
      int i6 = Math.min(mMaxWidth, i4);
      int i7 = Math.min(mMaxHeight, i5);
      setMeasuredDimension(0xFFFFFF & i6, 0xFFFFFF & i7);
      return;
    }
    setMeasuredDimension(i2, i3);
  }
  
  public void onViewAdded(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      super.onViewAdded(paramView);
    }
    ConstraintWidget localConstraintWidget = getViewWidget(paramView);
    if (((paramView instanceof Guideline)) && (!(localConstraintWidget instanceof android.support.constraint.solver.widgets.Guideline)))
    {
      LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
      widget = new android.support.constraint.solver.widgets.Guideline();
      isGuideline = true;
      ((android.support.constraint.solver.widgets.Guideline)widget).setOrientation(orientation);
      localConstraintWidget = widget;
    }
    ConstraintWidgetContainer localConstraintWidgetContainer = mLayoutWidget;
    localConstraintWidget.setCompanionWidget(paramView);
    mChildrenByIds.put(paramView.getId(), paramView);
    localConstraintWidgetContainer.add(localConstraintWidget);
    localConstraintWidget.setParent(localConstraintWidgetContainer);
    mDirtyHierarchy = true;
  }
  
  public void onViewRemoved(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      super.onViewRemoved(paramView);
    }
    mChildrenByIds.remove(paramView.getId());
    mLayoutWidget.remove(getViewWidget(paramView));
    mDirtyHierarchy = true;
  }
  
  public void removeView(View paramView)
  {
    super.removeView(paramView);
    if (Build.VERSION.SDK_INT < 14) {
      onViewRemoved(paramView);
    }
  }
  
  public void requestLayout()
  {
    super.requestLayout();
    mDirtyHierarchy = true;
  }
  
  protected void setDebugDirectResolution(boolean paramBoolean)
  {
    mLayoutWidget.setDirectResolution(paramBoolean);
  }
  
  public void setMaxHeight(int paramInt)
  {
    mMaxHeight = paramInt;
  }
  
  public void setMaxWidth(int paramInt)
  {
    mMaxWidth = paramInt;
  }
  
  public void setMinHeight(int paramInt)
  {
    mMinHeight = paramInt;
  }
  
  public void setMinWidth(int paramInt)
  {
    mMinWidth = paramInt;
  }
  
  protected void solveLinearSystem()
  {
    Animator.setAnimationEnabled(false);
    if (mOptimizationLevel == 2) {
      mLayoutWidget.setDirectResolution(true);
    }
    for (;;)
    {
      mLayoutWidget.layout();
      return;
      mLayoutWidget.setDirectResolution(false);
    }
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    public static final int BASELINE = 5;
    public static final int BOTTOM = 4;
    private static final int CHAIN_PACKED = 2;
    private static final int CHAIN_SPREAD = 0;
    private static final int CHAIN_SPREAD_INSIDE = 1;
    public static final int END = 7;
    public static final int HORIZONTAL = 0;
    public static final int LEFT = 1;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int PARENT_ID = 0;
    public static final int RIGHT = 2;
    public static final int START = 6;
    public static final int TOP = 3;
    public static final int UNSET = -1;
    public static final int VERTICAL = 1;
    public int baselineToBaseline = -1;
    public int bottomToBottom = -1;
    public int bottomToTop = -1;
    public String dimensionRatio = null;
    int dimensionRatioSide = 1;
    float dimensionRatioValue = 0.0F;
    public int editorAbsoluteX = -1;
    public int editorAbsoluteY = -1;
    public int endToEnd = -1;
    public int endToStart = -1;
    public int goneBottomMargin = -1;
    public int goneEndMargin = -1;
    public int goneLeftMargin = -1;
    public int goneRightMargin = -1;
    public int goneStartMargin = -1;
    public int goneTopMargin = -1;
    public int guideBegin = -1;
    public int guideEnd = -1;
    public float guidePercent = -1.0F;
    public float horizontalBias = 0.5F;
    public int horizontalChainStyle = 0;
    boolean horizontalDimensionFixed = true;
    public float horizontalWeight = 0.0F;
    boolean isGuideline = false;
    public int leftToLeft = -1;
    public int leftToRight = -1;
    boolean needsBaseline = false;
    public int orientation = -1;
    int resolveGoneLeftMargin = -1;
    int resolveGoneRightMargin = -1;
    float resolvedHorizontalBias = 0.5F;
    int resolvedLeftToLeft = -1;
    int resolvedLeftToRight = -1;
    int resolvedRightToLeft = -1;
    int resolvedRightToRight = -1;
    public int rightToLeft = -1;
    public int rightToRight = -1;
    public int startToEnd = -1;
    public int startToStart = -1;
    public int topToBottom = -1;
    public int topToTop = -1;
    public float verticalBias = 0.5F;
    public int verticalChainStyle = 0;
    boolean verticalDimensionFixed = true;
    public float verticalWeight = 0.0F;
    ConstraintWidget widget = new ConstraintWidget();
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_Layout);
      int i = localTypedArray.getIndexCount();
      int j = 0;
      if (j < i)
      {
        int k = localTypedArray.getIndex(j);
        if (k == R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf)
        {
          leftToLeft = localTypedArray.getResourceId(k, leftToLeft);
          if (leftToLeft == -1) {
            leftToLeft = localTypedArray.getInt(k, -1);
          }
        }
        for (;;)
        {
          j++;
          break;
          if (k == R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf)
          {
            leftToRight = localTypedArray.getResourceId(k, leftToRight);
            if (leftToRight == -1) {
              leftToRight = localTypedArray.getInt(k, -1);
            }
          }
          else if (k == R.styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf)
          {
            rightToLeft = localTypedArray.getResourceId(k, rightToLeft);
            if (rightToLeft == -1) {
              rightToLeft = localTypedArray.getInt(k, -1);
            }
          }
          else if (k == R.styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf)
          {
            rightToRight = localTypedArray.getResourceId(k, rightToRight);
            if (rightToRight == -1) {
              rightToRight = localTypedArray.getInt(k, -1);
            }
          }
          else if (k == R.styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf)
          {
            topToTop = localTypedArray.getResourceId(k, topToTop);
            if (topToTop == -1) {
              topToTop = localTypedArray.getInt(k, -1);
            }
          }
          else if (k == R.styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf)
          {
            topToBottom = localTypedArray.getResourceId(k, topToBottom);
            if (topToBottom == -1) {
              topToBottom = localTypedArray.getInt(k, -1);
            }
          }
          else if (k == R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf)
          {
            bottomToTop = localTypedArray.getResourceId(k, bottomToTop);
            if (bottomToTop == -1) {
              bottomToTop = localTypedArray.getInt(k, -1);
            }
          }
          else if (k == R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf)
          {
            bottomToBottom = localTypedArray.getResourceId(k, bottomToBottom);
            if (bottomToBottom == -1) {
              bottomToBottom = localTypedArray.getInt(k, -1);
            }
          }
          else if (k == R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf)
          {
            baselineToBaseline = localTypedArray.getResourceId(k, baselineToBaseline);
            if (baselineToBaseline == -1) {
              baselineToBaseline = localTypedArray.getInt(k, -1);
            }
          }
          else if (k == R.styleable.ConstraintLayout_Layout_layout_editor_absoluteX)
          {
            editorAbsoluteX = localTypedArray.getDimensionPixelOffset(k, editorAbsoluteX);
          }
          else if (k == R.styleable.ConstraintLayout_Layout_layout_editor_absoluteY)
          {
            editorAbsoluteY = localTypedArray.getDimensionPixelOffset(k, editorAbsoluteY);
          }
          else if (k == R.styleable.ConstraintLayout_Layout_layout_constraintGuide_begin)
          {
            guideBegin = localTypedArray.getDimensionPixelOffset(k, guideBegin);
          }
          else if (k == R.styleable.ConstraintLayout_Layout_layout_constraintGuide_end)
          {
            guideEnd = localTypedArray.getDimensionPixelOffset(k, guideEnd);
          }
          else if (k == R.styleable.ConstraintLayout_Layout_layout_constraintGuide_percent)
          {
            guidePercent = localTypedArray.getFloat(k, guidePercent);
          }
          else if (k == R.styleable.ConstraintLayout_Layout_android_orientation)
          {
            orientation = localTypedArray.getInt(k, orientation);
          }
          else if (k == R.styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf)
          {
            startToEnd = localTypedArray.getResourceId(k, startToEnd);
            if (startToEnd == -1) {
              startToEnd = localTypedArray.getInt(k, -1);
            }
          }
          else if (k == R.styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf)
          {
            startToStart = localTypedArray.getResourceId(k, startToStart);
            if (startToStart == -1) {
              startToStart = localTypedArray.getInt(k, -1);
            }
          }
          else if (k == R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf)
          {
            endToStart = localTypedArray.getResourceId(k, endToStart);
            if (endToStart == -1) {
              endToStart = localTypedArray.getInt(k, -1);
            }
          }
          else if (k == R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf)
          {
            endToEnd = localTypedArray.getResourceId(k, endToEnd);
            if (endToEnd == -1) {
              endToEnd = localTypedArray.getInt(k, -1);
            }
          }
          else if (k == R.styleable.ConstraintLayout_Layout_layout_goneMarginLeft)
          {
            goneLeftMargin = localTypedArray.getDimensionPixelSize(k, goneLeftMargin);
          }
          else if (k == R.styleable.ConstraintLayout_Layout_layout_goneMarginTop)
          {
            goneTopMargin = localTypedArray.getDimensionPixelSize(k, goneTopMargin);
          }
          else if (k == R.styleable.ConstraintLayout_Layout_layout_goneMarginRight)
          {
            goneRightMargin = localTypedArray.getDimensionPixelSize(k, goneRightMargin);
          }
          else if (k == R.styleable.ConstraintLayout_Layout_layout_goneMarginBottom)
          {
            goneBottomMargin = localTypedArray.getDimensionPixelSize(k, goneBottomMargin);
          }
          else if (k == R.styleable.ConstraintLayout_Layout_layout_goneMarginStart)
          {
            goneStartMargin = localTypedArray.getDimensionPixelSize(k, goneStartMargin);
          }
          else if (k == R.styleable.ConstraintLayout_Layout_layout_goneMarginEnd)
          {
            goneEndMargin = localTypedArray.getDimensionPixelSize(k, goneEndMargin);
          }
          else if (k == R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias)
          {
            horizontalBias = localTypedArray.getFloat(k, horizontalBias);
          }
          else if (k == R.styleable.ConstraintLayout_Layout_layout_constraintVertical_bias)
          {
            verticalBias = localTypedArray.getFloat(k, verticalBias);
          }
          else if (k == R.styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio)
          {
            dimensionRatio = localTypedArray.getString(k);
            dimensionRatioValue = NaN.0F;
            dimensionRatioSide = -1;
            if (dimensionRatio != null)
            {
              int m = dimensionRatio.length();
              int n = dimensionRatio.indexOf(',');
              String str4;
              if ((n > 0) && (n < m - 1))
              {
                str4 = dimensionRatio.substring(0, n);
                if (str4.equalsIgnoreCase("W")) {
                  dimensionRatioSide = 0;
                }
              }
              label1303:
              float f1;
              float f2;
              for (int i1 = n + 1;; i1 = 0)
              {
                int i2 = dimensionRatio.indexOf(':');
                if ((i2 < 0) || (i2 >= m - 1)) {
                  break label1476;
                }
                String str2 = dimensionRatio.substring(i1, i2);
                String str3 = dimensionRatio.substring(i2 + 1);
                if ((str2.length() <= 0) || (str3.length() <= 0)) {
                  break;
                }
                try
                {
                  f1 = Float.parseFloat(str2);
                  f2 = Float.parseFloat(str3);
                  if ((f1 <= 0.0F) || (f2 <= 0.0F)) {
                    break;
                  }
                  if (dimensionRatioSide != 1) {
                    break label1457;
                  }
                  dimensionRatioValue = Math.abs(f2 / f1);
                }
                catch (NumberFormatException localNumberFormatException2) {}
                break;
                if (!str4.equalsIgnoreCase("H")) {
                  break label1303;
                }
                dimensionRatioSide = 1;
                break label1303;
              }
              label1457:
              float f3 = f1 / f2;
              dimensionRatioValue = Math.abs(f3);
              continue;
              label1476:
              String str1 = dimensionRatio.substring(i1);
              if (str1.length() > 0) {
                try
                {
                  dimensionRatioValue = Float.parseFloat(str1);
                }
                catch (NumberFormatException localNumberFormatException1) {}
              }
            }
          }
          else if (k == R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight)
          {
            horizontalWeight = localTypedArray.getFloat(k, 0.0F);
          }
          else if (k == R.styleable.ConstraintLayout_Layout_layout_constraintVertical_weight)
          {
            verticalWeight = localTypedArray.getFloat(k, 0.0F);
          }
          else if (k == R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle)
          {
            horizontalChainStyle = localTypedArray.getInt(k, 0);
          }
          else if (k == R.styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle)
          {
            verticalChainStyle = localTypedArray.getInt(k, 0);
          }
          else if ((k != R.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator) && (k != R.styleable.ConstraintLayout_Layout_layout_constraintTop_creator) && (k != R.styleable.ConstraintLayout_Layout_layout_constraintRight_creator) && (k != R.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator) && (k != R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator))
          {
            Log.w("ConstraintLayout", "Unknown attribute 0x" + Integer.toHexString(k));
          }
        }
      }
      localTypedArray.recycle();
      validate();
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      guideBegin = guideBegin;
      guideEnd = guideEnd;
      guidePercent = guidePercent;
      leftToLeft = leftToLeft;
      leftToRight = leftToRight;
      rightToLeft = rightToLeft;
      rightToRight = rightToRight;
      topToTop = topToTop;
      topToBottom = topToBottom;
      bottomToTop = bottomToTop;
      bottomToBottom = bottomToBottom;
      baselineToBaseline = baselineToBaseline;
      startToEnd = startToEnd;
      startToStart = startToStart;
      endToStart = endToStart;
      endToEnd = endToEnd;
      goneLeftMargin = goneLeftMargin;
      goneTopMargin = goneTopMargin;
      goneRightMargin = goneRightMargin;
      goneBottomMargin = goneBottomMargin;
      goneStartMargin = goneStartMargin;
      goneEndMargin = goneEndMargin;
      horizontalBias = horizontalBias;
      verticalBias = verticalBias;
      dimensionRatio = dimensionRatio;
      dimensionRatioValue = dimensionRatioValue;
      dimensionRatioSide = dimensionRatioSide;
      horizontalWeight = horizontalWeight;
      verticalWeight = verticalWeight;
      horizontalChainStyle = horizontalChainStyle;
      verticalChainStyle = verticalChainStyle;
      editorAbsoluteX = editorAbsoluteX;
      editorAbsoluteY = editorAbsoluteY;
      orientation = orientation;
      horizontalDimensionFixed = horizontalDimensionFixed;
      verticalDimensionFixed = verticalDimensionFixed;
      needsBaseline = needsBaseline;
      isGuideline = isGuideline;
      resolvedLeftToLeft = resolvedLeftToLeft;
      resolvedLeftToRight = resolvedLeftToRight;
      resolvedRightToLeft = resolvedRightToLeft;
      resolvedRightToRight = resolvedRightToRight;
      resolveGoneLeftMargin = resolveGoneLeftMargin;
      resolveGoneRightMargin = resolveGoneRightMargin;
      resolvedHorizontalBias = resolvedHorizontalBias;
      widget = widget;
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    @TargetApi(17)
    public void resolveLayoutDirection(int paramInt)
    {
      int i = 1;
      super.resolveLayoutDirection(paramInt);
      resolvedRightToLeft = -1;
      resolvedRightToRight = -1;
      resolvedLeftToLeft = -1;
      resolvedLeftToRight = -1;
      resolveGoneLeftMargin = -1;
      resolveGoneRightMargin = -1;
      resolveGoneLeftMargin = goneLeftMargin;
      resolveGoneRightMargin = goneRightMargin;
      resolvedHorizontalBias = horizontalBias;
      if (i == getLayoutDirection())
      {
        if (i == 0) {
          break label252;
        }
        if (startToEnd == -1) {
          break label233;
        }
        resolvedRightToLeft = startToEnd;
        label89:
        if (endToStart != -1) {
          resolvedLeftToRight = endToStart;
        }
        if (endToEnd != -1) {
          resolvedLeftToLeft = endToEnd;
        }
        if (goneStartMargin != -1) {
          resolveGoneRightMargin = goneStartMargin;
        }
        if (goneEndMargin != -1) {
          resolveGoneLeftMargin = goneEndMargin;
        }
        resolvedHorizontalBias = (1.0F - horizontalBias);
        label163:
        if ((endToStart == -1) && (endToEnd == -1))
        {
          if (rightToLeft == -1) {
            break label351;
          }
          resolvedRightToLeft = rightToLeft;
        }
        label195:
        if ((startToStart == -1) && (startToEnd == -1))
        {
          if (leftToLeft == -1) {
            break label370;
          }
          resolvedLeftToLeft = leftToLeft;
        }
      }
      label233:
      label252:
      label351:
      label370:
      while (leftToRight == -1)
      {
        return;
        i = 0;
        break;
        if (startToStart == -1) {
          break label89;
        }
        resolvedRightToRight = startToStart;
        break label89;
        if (startToEnd != -1) {
          resolvedLeftToRight = startToEnd;
        }
        if (startToStart != -1) {
          resolvedLeftToLeft = startToStart;
        }
        if (endToStart != -1) {
          resolvedRightToLeft = endToStart;
        }
        if (endToEnd != -1) {
          resolvedRightToRight = endToEnd;
        }
        if (goneStartMargin != -1) {
          resolveGoneLeftMargin = goneStartMargin;
        }
        if (goneEndMargin == -1) {
          break label163;
        }
        resolveGoneRightMargin = goneEndMargin;
        break label163;
        if (rightToRight == -1) {
          break label195;
        }
        resolvedRightToRight = rightToRight;
        break label195;
      }
      resolvedLeftToRight = leftToRight;
    }
    
    public void validate()
    {
      isGuideline = false;
      horizontalDimensionFixed = true;
      verticalDimensionFixed = true;
      if ((width == 0) || (width == -1)) {
        horizontalDimensionFixed = false;
      }
      if ((height == 0) || (height == -1)) {
        verticalDimensionFixed = false;
      }
      if ((guidePercent != -1.0F) || (guideBegin != -1) || (guideEnd != -1))
      {
        isGuideline = true;
        horizontalDimensionFixed = true;
        verticalDimensionFixed = true;
        if (!(widget instanceof android.support.constraint.solver.widgets.Guideline)) {
          widget = new android.support.constraint.solver.widgets.Guideline();
        }
        ((android.support.constraint.solver.widgets.Guideline)widget).setOrientation(orientation);
      }
    }
  }
}
