package android.support.constraint;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class ConstraintSet
{
  public static final int BASELINE = 5;
  private static final int BASELINE_TO_BASELINE = 1;
  public static final int BOTTOM = 4;
  private static final int BOTTOM_MARGIN = 2;
  private static final int BOTTOM_TO_BOTTOM = 3;
  private static final int BOTTOM_TO_TOP = 4;
  private static final boolean DEBUG = false;
  private static final int DIMENSION_RATIO = 5;
  private static final int EDITOR_ABSOLUTE_X = 6;
  private static final int EDITOR_ABSOLUTE_Y = 7;
  public static final int END = 7;
  private static final int END_MARGIN = 8;
  private static final int END_TO_END = 9;
  private static final int END_TO_START = 10;
  public static final int GONE = 8;
  private static final int GONE_BOTTOM_MARGIN = 11;
  private static final int GONE_END_MARGIN = 12;
  private static final int GONE_LEFT_MARGIN = 13;
  private static final int GONE_RIGHT_MARGIN = 14;
  private static final int GONE_START_MARGIN = 15;
  private static final int GONE_TOP_MARGIN = 16;
  private static final int GUIDE_BEGIN = 17;
  private static final int GUIDE_END = 18;
  private static final int GUIDE_PERCENT = 19;
  public static final int HORIZONTAL = 0;
  private static final int HORIZONTAL_BIAS = 20;
  public static final int HORIZONTAL_GUIDELINE = 0;
  private static final int HORIZONTAL_STYLE = 41;
  private static final int HORIZONTAL_WEIGHT = 39;
  public static final int INVISIBLE = 4;
  private static final int LAYOUT_HEIGHT = 21;
  private static final int LAYOUT_VISIBILITY = 22;
  private static final int LAYOUT_WIDTH = 23;
  public static final int LEFT = 1;
  private static final int LEFT_MARGIN = 24;
  private static final int LEFT_TO_LEFT = 25;
  private static final int LEFT_TO_RIGHT = 26;
  public static final int MATCH_CONSTRAINT = 0;
  private static final int ORIENTATION = 27;
  public static final int PARENT_ID = 0;
  public static final int RIGHT = 2;
  private static final int RIGHT_MARGIN = 28;
  private static final int RIGHT_TO_LEFT = 29;
  private static final int RIGHT_TO_RIGHT = 30;
  public static final int START = 6;
  private static final int START_MARGIN = 31;
  private static final int START_TO_END = 32;
  private static final int START_TO_START = 33;
  private static final String TAG = "ConstraintSet";
  public static final int TOP = 3;
  private static final int TOP_MARGIN = 34;
  private static final int TOP_TO_BOTTOM = 35;
  private static final int TOP_TO_TOP = 36;
  private static final int UNUSED = 43;
  public static final int VERTICAL = 1;
  private static final int VERTICAL_BIAS = 37;
  public static final int VERTICAL_GUIDELINE = 1;
  private static final int VERTICAL_STYLE = 42;
  private static final int VERTICAL_WEIGHT = 40;
  private static final int VIEW_ID = 38;
  private static final int[] VISIBILITY_FLAGS = { 0, 4, 8 };
  public static final int VISIBLE = 0;
  public static final int WRAP_CONTENT = -2;
  private static SparseIntArray mapToConstant = new SparseIntArray();
  private HashMap<Integer, Constraint> mConstraints = new HashMap();
  
  static
  {
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintLeft_toLeftOf, 25);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintLeft_toRightOf, 26);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintRight_toLeftOf, 29);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintRight_toRightOf, 30);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintTop_toTopOf, 36);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintTop_toBottomOf, 35);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintBottom_toTopOf, 4);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintBottom_toBottomOf, 3);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintBaseline_toBaselineOf, 1);
    mapToConstant.append(R.styleable.ConstraintSet_layout_editor_absoluteX, 6);
    mapToConstant.append(R.styleable.ConstraintSet_layout_editor_absoluteY, 7);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintGuide_begin, 17);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintGuide_end, 18);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintGuide_percent, 19);
    mapToConstant.append(R.styleable.ConstraintSet_android_orientation, 27);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintStart_toEndOf, 32);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintStart_toStartOf, 33);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintEnd_toStartOf, 10);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintEnd_toEndOf, 9);
    mapToConstant.append(R.styleable.ConstraintSet_layout_goneMarginLeft, 13);
    mapToConstant.append(R.styleable.ConstraintSet_layout_goneMarginTop, 16);
    mapToConstant.append(R.styleable.ConstraintSet_layout_goneMarginRight, 14);
    mapToConstant.append(R.styleable.ConstraintSet_layout_goneMarginBottom, 11);
    mapToConstant.append(R.styleable.ConstraintSet_layout_goneMarginStart, 15);
    mapToConstant.append(R.styleable.ConstraintSet_layout_goneMarginEnd, 12);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintVertical_weight, 40);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintHorizontal_weight, 39);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintHorizontal_chainStyle, 41);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintVertical_chainStyle, 42);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintHorizontal_bias, 20);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintVertical_bias, 37);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintDimensionRatio, 5);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintLeft_creator, 43);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintTop_creator, 43);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintRight_creator, 43);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintBottom_creator, 43);
    mapToConstant.append(R.styleable.ConstraintSet_layout_constraintBaseline_creator, 43);
    mapToConstant.append(R.styleable.ConstraintSet_android_layout_marginLeft, 24);
    mapToConstant.append(R.styleable.ConstraintSet_android_layout_marginRight, 28);
    mapToConstant.append(R.styleable.ConstraintSet_android_layout_marginStart, 31);
    mapToConstant.append(R.styleable.ConstraintSet_android_layout_marginEnd, 8);
    mapToConstant.append(R.styleable.ConstraintSet_android_layout_marginTop, 34);
    mapToConstant.append(R.styleable.ConstraintSet_android_layout_marginBottom, 2);
    mapToConstant.append(R.styleable.ConstraintSet_android_layout_width, 23);
    mapToConstant.append(R.styleable.ConstraintSet_android_layout_height, 21);
    mapToConstant.append(R.styleable.ConstraintSet_android_visibility, 22);
    mapToConstant.append(R.styleable.ConstraintSet_android_id, 38);
  }
  
  public ConstraintSet() {}
  
  private void centerHorizontally(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float paramFloat)
  {
    connect(paramInt1, 1, paramInt2, paramInt3, paramInt4);
    connect(paramInt1, 2, paramInt5, paramInt6, paramInt7);
    mConstraints.get(Integer.valueOf(paramInt1))).horizontalBias = paramFloat;
  }
  
  private void centerVertically(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float paramFloat)
  {
    connect(paramInt1, 3, paramInt2, paramInt3, paramInt4);
    connect(paramInt1, 4, paramInt5, paramInt6, paramInt7);
    mConstraints.get(Integer.valueOf(paramInt1))).verticalBias = paramFloat;
  }
  
  private Constraint fillFromAttributeList(Context paramContext, AttributeSet paramAttributeSet)
  {
    Constraint localConstraint = new Constraint(null);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintSet);
    populateConstraint(localConstraint, localTypedArray);
    localTypedArray.recycle();
    return localConstraint;
  }
  
  private Constraint get(int paramInt)
  {
    if (!mConstraints.containsKey(Integer.valueOf(paramInt))) {
      mConstraints.put(Integer.valueOf(paramInt), new Constraint(null));
    }
    return (Constraint)mConstraints.get(Integer.valueOf(paramInt));
  }
  
  private static int lookupID(TypedArray paramTypedArray, int paramInt1, int paramInt2)
  {
    int i = paramTypedArray.getResourceId(paramInt1, paramInt2);
    if (i == -1) {
      i = paramTypedArray.getInt(paramInt1, -1);
    }
    return i;
  }
  
  private void populateConstraint(Constraint paramConstraint, TypedArray paramTypedArray)
  {
    int i = paramTypedArray.getIndexCount();
    int j = 0;
    if (j < i)
    {
      int k = paramTypedArray.getIndex(j);
      switch (mapToConstant.get(k))
      {
      default: 
        Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(k) + "   " + mapToConstant.get(k));
      }
      for (;;)
      {
        j++;
        break;
        leftToLeft = lookupID(paramTypedArray, k, leftToLeft);
        continue;
        leftToRight = lookupID(paramTypedArray, k, leftToRight);
        continue;
        rightToLeft = lookupID(paramTypedArray, k, rightToLeft);
        continue;
        rightToRight = lookupID(paramTypedArray, k, rightToRight);
        continue;
        topToTop = lookupID(paramTypedArray, k, topToTop);
        continue;
        topToBottom = lookupID(paramTypedArray, k, topToBottom);
        continue;
        bottomToTop = lookupID(paramTypedArray, k, bottomToTop);
        continue;
        bottomToBottom = lookupID(paramTypedArray, k, bottomToBottom);
        continue;
        baselineToBaseline = lookupID(paramTypedArray, k, baselineToBaseline);
        continue;
        editorAbsoluteX = paramTypedArray.getDimensionPixelOffset(k, editorAbsoluteX);
        continue;
        editorAbsoluteY = paramTypedArray.getDimensionPixelOffset(k, editorAbsoluteY);
        continue;
        guideBegin = paramTypedArray.getDimensionPixelOffset(k, guideBegin);
        continue;
        guideEnd = paramTypedArray.getDimensionPixelOffset(k, guideEnd);
        continue;
        guidePercent = paramTypedArray.getFloat(k, guidePercent);
        continue;
        orientation = paramTypedArray.getInt(k, orientation);
        continue;
        startToEnd = lookupID(paramTypedArray, k, startToEnd);
        continue;
        startToStart = lookupID(paramTypedArray, k, startToStart);
        continue;
        endToStart = lookupID(paramTypedArray, k, endToStart);
        continue;
        bottomToTop = lookupID(paramTypedArray, k, endToEnd);
        continue;
        goneLeftMargin = paramTypedArray.getDimensionPixelSize(k, goneLeftMargin);
        continue;
        goneTopMargin = paramTypedArray.getDimensionPixelSize(k, goneTopMargin);
        continue;
        goneRightMargin = paramTypedArray.getDimensionPixelSize(k, goneRightMargin);
        continue;
        goneBottomMargin = paramTypedArray.getDimensionPixelSize(k, goneBottomMargin);
        continue;
        goneStartMargin = paramTypedArray.getDimensionPixelSize(k, goneStartMargin);
        continue;
        goneEndMargin = paramTypedArray.getDimensionPixelSize(k, goneEndMargin);
        continue;
        horizontalBias = paramTypedArray.getFloat(k, horizontalBias);
        continue;
        verticalBias = paramTypedArray.getFloat(k, verticalBias);
        continue;
        leftMargin = paramTypedArray.getDimensionPixelSize(k, leftMargin);
        continue;
        rightMargin = paramTypedArray.getDimensionPixelSize(k, rightMargin);
        continue;
        startMargin = paramTypedArray.getDimensionPixelSize(k, startMargin);
        continue;
        endMargin = paramTypedArray.getDimensionPixelSize(k, endMargin);
        continue;
        topMargin = paramTypedArray.getDimensionPixelSize(k, topMargin);
        continue;
        bottomMargin = paramTypedArray.getDimensionPixelSize(k, bottomMargin);
        continue;
        mWidth = paramTypedArray.getLayoutDimension(k, mWidth);
        continue;
        mHeight = paramTypedArray.getLayoutDimension(k, mHeight);
        continue;
        visibility = paramTypedArray.getInt(k, visibility);
        visibility = VISIBILITY_FLAGS[visibility];
        continue;
        verticalWeight = paramTypedArray.getFloat(k, verticalWeight);
        continue;
        horizontalWeight = paramTypedArray.getFloat(k, horizontalWeight);
        continue;
        verticalChainStyle = paramTypedArray.getInt(k, verticalChainStyle);
        continue;
        horizontalChainStyle = paramTypedArray.getInt(k, horizontalChainStyle);
        continue;
        mViewId = paramTypedArray.getResourceId(k, mViewId);
        continue;
        dimensionRatio = paramTypedArray.getString(k);
      }
    }
  }
  
  private String sideToString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "undefined";
    case 1: 
      return "left";
    case 2: 
      return "right";
    case 3: 
      return "top";
    case 4: 
      return "bottom";
    case 5: 
      return "baseline";
    case 6: 
      return "start";
    }
    return "end";
  }
  
  public void applyTo(ConstraintLayout paramConstraintLayout)
  {
    int i = paramConstraintLayout.getChildCount();
    HashSet localHashSet = new HashSet(mConstraints.keySet());
    for (int j = 0; j < i; j++)
    {
      View localView = paramConstraintLayout.getChildAt(j);
      int k = localView.getId();
      if (mConstraints.containsKey(Integer.valueOf(k)))
      {
        localHashSet.remove(Integer.valueOf(k));
        Constraint localConstraint2 = (Constraint)mConstraints.get(Integer.valueOf(k));
        ConstraintLayout.LayoutParams localLayoutParams2 = (ConstraintLayout.LayoutParams)localView.getLayoutParams();
        localConstraint2.applyTo(localLayoutParams2);
        localView.setLayoutParams(localLayoutParams2);
        localView.setVisibility(visibility);
      }
    }
    Iterator localIterator = localHashSet.iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      Constraint localConstraint1 = (Constraint)mConstraints.get(localInteger);
      if (mIsGuideline)
      {
        Guideline localGuideline = new Guideline(paramConstraintLayout.getContext());
        localGuideline.setId(localInteger.intValue());
        ConstraintLayout.LayoutParams localLayoutParams1 = paramConstraintLayout.generateDefaultLayoutParams();
        localConstraint1.applyTo(localLayoutParams1);
        paramConstraintLayout.addView(localGuideline, localLayoutParams1);
      }
    }
  }
  
  public void center(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float paramFloat)
  {
    if (paramInt4 < 0) {
      throw new IllegalArgumentException("margin must be > 0");
    }
    if (paramInt7 < 0) {
      throw new IllegalArgumentException("margin must be > 0");
    }
    if ((paramFloat <= 0.0F) || (paramFloat > 1.0F)) {
      throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
    }
    if ((paramInt3 == 1) || (paramInt3 == 2))
    {
      connect(paramInt1, 1, paramInt2, paramInt3, paramInt4);
      connect(paramInt1, 2, paramInt5, paramInt6, paramInt7);
      mConstraints.get(Integer.valueOf(paramInt1))).horizontalBias = paramFloat;
      return;
    }
    connect(paramInt1, 3, paramInt2, paramInt3, paramInt4);
    connect(paramInt1, 4, paramInt5, paramInt6, paramInt7);
    mConstraints.get(Integer.valueOf(paramInt1))).verticalBias = paramFloat;
  }
  
  public void centerHorizontally(int paramInt1, int paramInt2)
  {
    center(paramInt1, paramInt2, 1, 0, paramInt2, 2, 0, 0.5F);
  }
  
  public void centerVertically(int paramInt1, int paramInt2)
  {
    center(paramInt1, paramInt2, 3, 0, paramInt2, 4, 0, 0.5F);
  }
  
  public void clear(int paramInt)
  {
    mConstraints.remove(Integer.valueOf(paramInt));
  }
  
  public void clear(int paramInt1, int paramInt2)
  {
    Constraint localConstraint;
    if (mConstraints.containsKey(Integer.valueOf(paramInt1))) {
      localConstraint = (Constraint)mConstraints.get(Integer.valueOf(paramInt1));
    }
    switch (paramInt2)
    {
    default: 
      throw new IllegalArgumentException("unknown constraint");
    case 1: 
      leftToRight = -1;
      leftToLeft = -1;
      leftMargin = 0;
      return;
    case 2: 
      leftToRight = -1;
      leftToLeft = -1;
      rightMargin = 0;
      return;
    case 3: 
      topToBottom = -1;
      topToTop = -1;
      topMargin = 0;
      return;
    case 4: 
      bottomToTop = -1;
      bottomToBottom = -1;
      bottomMargin = 0;
      return;
    case 5: 
      baselineToBaseline = -1;
      return;
    case 6: 
      startToEnd = -1;
      startToStart = -1;
      startMargin = 0;
      return;
    }
    endToStart = -1;
    endToEnd = -1;
    endMargin = 0;
  }
  
  public void clone(Context paramContext, int paramInt)
  {
    clone((ConstraintLayout)LayoutInflater.from(paramContext).inflate(paramInt, null));
  }
  
  public void clone(ConstraintLayout paramConstraintLayout)
  {
    int i = paramConstraintLayout.getChildCount();
    mConstraints.clear();
    for (int j = 0; j < i; j++)
    {
      View localView = paramConstraintLayout.getChildAt(j);
      ConstraintLayout.LayoutParams localLayoutParams = (ConstraintLayout.LayoutParams)localView.getLayoutParams();
      int k = localView.getId();
      if (!mConstraints.containsKey(Integer.valueOf(k))) {
        mConstraints.put(Integer.valueOf(k), new Constraint(null));
      }
      Constraint localConstraint = (Constraint)mConstraints.get(Integer.valueOf(k));
      localConstraint.fillFrom(k, localLayoutParams);
      visibility = localView.getVisibility();
    }
  }
  
  public void connect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (!mConstraints.containsKey(Integer.valueOf(paramInt1))) {
      mConstraints.put(Integer.valueOf(paramInt1), new Constraint(null));
    }
    Constraint localConstraint = (Constraint)mConstraints.get(Integer.valueOf(paramInt1));
    switch (paramInt2)
    {
    default: 
      throw new IllegalArgumentException(sideToString(paramInt2) + " to " + sideToString(paramInt4) + " unknown");
    case 1: 
      if (paramInt4 == 1)
      {
        leftToLeft = paramInt3;
        leftToRight = -1;
      }
      for (;;)
      {
        leftMargin = paramInt5;
        return;
        if (paramInt4 != 2) {
          break;
        }
        leftToRight = paramInt3;
        leftToLeft = -1;
      }
      throw new IllegalArgumentException("Left to " + sideToString(paramInt4) + " undefined");
    case 2: 
      if (paramInt4 == 1)
      {
        rightToLeft = paramInt3;
        rightToRight = -1;
      }
      for (;;)
      {
        rightMargin = paramInt5;
        return;
        if (paramInt4 != 2) {
          break;
        }
        rightToRight = paramInt3;
        rightToLeft = -1;
      }
      throw new IllegalArgumentException("right to " + sideToString(paramInt4) + " undefined");
    case 3: 
      if (paramInt4 == 3)
      {
        topToTop = paramInt3;
        topToBottom = -1;
      }
      for (baselineToBaseline = -1;; baselineToBaseline = -1)
      {
        topMargin = paramInt5;
        return;
        if (paramInt4 != 4) {
          break;
        }
        topToBottom = paramInt3;
        topToTop = -1;
      }
      throw new IllegalArgumentException("right to " + sideToString(paramInt4) + " undefined");
    case 4: 
      if (paramInt4 == 4)
      {
        bottomToBottom = paramInt3;
        bottomToTop = -1;
      }
      for (baselineToBaseline = -1;; baselineToBaseline = -1)
      {
        bottomMargin = paramInt5;
        return;
        if (paramInt4 != 3) {
          break;
        }
        bottomToTop = paramInt3;
        bottomToBottom = -1;
      }
      throw new IllegalArgumentException("right to " + sideToString(paramInt4) + " undefined");
    case 5: 
      if (paramInt4 == 5)
      {
        baselineToBaseline = paramInt3;
        bottomToBottom = -1;
        bottomToTop = -1;
        topToTop = -1;
        topToBottom = -1;
        return;
      }
      throw new IllegalArgumentException("right to " + sideToString(paramInt4) + " undefined");
    case 6: 
      if (paramInt4 == 6)
      {
        startToStart = paramInt3;
        startToEnd = -1;
      }
      for (;;)
      {
        startMargin = paramInt5;
        return;
        if (paramInt4 != 7) {
          break;
        }
        startToEnd = paramInt3;
        startToStart = -1;
      }
      throw new IllegalArgumentException("right to " + sideToString(paramInt4) + " undefined");
    }
    if (paramInt4 == 7)
    {
      endToEnd = paramInt3;
      endToStart = -1;
    }
    for (;;)
    {
      endMargin = paramInt5;
      return;
      if (paramInt4 != 6) {
        break;
      }
      endToStart = paramInt3;
      endToEnd = -1;
    }
    throw new IllegalArgumentException("right to " + sideToString(paramInt4) + " undefined");
  }
  
  public void constrainHeight(int paramInt1, int paramInt2)
  {
    getmHeight = paramInt2;
  }
  
  public void constrainWidth(int paramInt1, int paramInt2)
  {
    getmWidth = paramInt2;
  }
  
  public void create(int paramInt1, int paramInt2)
  {
    Constraint localConstraint = get(paramInt1);
    mIsGuideline = true;
    orientation = paramInt2;
  }
  
  public void createHorizontalChain(int paramInt1, int paramInt2, int[] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt3)
  {
    if (paramArrayOfInt.length < 2) {
      throw new IllegalArgumentException("must have 2 or more widgets in a chain");
    }
    if ((paramArrayOfFloat != null) && (paramArrayOfFloat.length != paramArrayOfInt.length)) {
      throw new IllegalArgumentException("must have 2 or more widgets in a chain");
    }
    if (paramArrayOfFloat != null) {
      get0verticalWeight = paramArrayOfFloat[0];
    }
    get0horizontalChainStyle = paramInt3;
    connect(paramArrayOfInt[0], 3, paramInt1, 3, 0);
    for (int i = 1; i < -1 + paramArrayOfInt.length; i++)
    {
      paramArrayOfInt[i];
      connect(paramArrayOfInt[i], 3, paramArrayOfInt[(i - 1)], 4, 0);
      connect(paramArrayOfInt[(i - 1)], 4, paramArrayOfInt[i], 3, 0);
      if (paramArrayOfFloat != null) {
        getverticalWeight = paramArrayOfFloat[i];
      }
    }
    connect(paramArrayOfInt[(-1 + paramArrayOfInt.length)], 4, paramInt2, 3, 0);
    if (paramArrayOfFloat != null) {
      get-1lengthverticalWeight = paramArrayOfFloat[(-1 + paramArrayOfInt.length)];
    }
  }
  
  public void createVerticalChain(int paramInt1, int paramInt2, int[] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt3)
  {
    if (paramArrayOfInt.length < 2) {
      throw new IllegalArgumentException("must have 2 or more widgets in a chain");
    }
    if ((paramArrayOfFloat != null) && (paramArrayOfFloat.length != paramArrayOfInt.length)) {
      throw new IllegalArgumentException("must have 2 or more widgets in a chain");
    }
    if (paramArrayOfFloat != null) {
      get0verticalWeight = paramArrayOfFloat[0];
    }
    get0verticalChainStyle = paramInt3;
    connect(paramArrayOfInt[0], 3, paramInt1, 3, 0);
    for (int i = 1; i < -1 + paramArrayOfInt.length; i++)
    {
      paramArrayOfInt[i];
      connect(paramArrayOfInt[i], 3, paramArrayOfInt[(i - 1)], 4, 0);
      connect(paramArrayOfInt[(i - 1)], 4, paramArrayOfInt[i], 3, 0);
      if (paramArrayOfFloat != null) {
        getverticalWeight = paramArrayOfFloat[i];
      }
    }
    connect(paramArrayOfInt[(-1 + paramArrayOfInt.length)], 4, paramInt2, 3, 0);
    if (paramArrayOfFloat != null) {
      get-1lengthverticalWeight = paramArrayOfFloat[(-1 + paramArrayOfInt.length)];
    }
  }
  
  public void load(Context paramContext, int paramInt)
  {
    XmlResourceParser localXmlResourceParser = paramContext.getResources().getXml(paramInt);
    int i;
    for (;;)
    {
      try
      {
        i = localXmlResourceParser.getEventType();
      }
      catch (XmlPullParserException localXmlPullParserException)
      {
        String str;
        Constraint localConstraint;
        localXmlPullParserException.printStackTrace();
        return;
        continue;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        return;
      }
      i = localXmlResourceParser.next();
      break;
      localXmlResourceParser.getName();
      continue;
      str = localXmlResourceParser.getName();
      localConstraint = fillFromAttributeList(paramContext, Xml.asAttributeSet(localXmlResourceParser));
      if (str.equalsIgnoreCase("Guideline")) {
        mIsGuideline = true;
      }
      mConstraints.put(Integer.valueOf(mViewId), localConstraint);
    }
    while (i == 1) {}
    switch (i)
    {
    }
  }
  
  public void setDimensionRatio(int paramInt, String paramString)
  {
    getdimensionRatio = paramString;
  }
  
  public void setGuidelineBegin(int paramInt1, int paramInt2)
  {
    getguideBegin = paramInt2;
    getguideEnd = -1;
    getguidePercent = 0.5F;
  }
  
  public void setGuidelineEnd(int paramInt1, int paramInt2)
  {
    getguideEnd = paramInt2;
    getguideBegin = -1;
    getguidePercent = 0.5F;
  }
  
  public void setGuidelinePercent(int paramInt, float paramFloat)
  {
    getguidePercent = paramFloat;
    getguideEnd = -1;
    getguideBegin = -1;
  }
  
  public void setHorizontalBias(int paramInt, float paramFloat)
  {
    gethorizontalBias = paramFloat;
  }
  
  public void setMargin(int paramInt1, int paramInt2, int paramInt3)
  {
    Constraint localConstraint = get(paramInt1);
    switch (paramInt2)
    {
    default: 
      throw new IllegalArgumentException("unknown constraint");
    case 1: 
      leftMargin = paramInt3;
      return;
    case 2: 
      rightMargin = paramInt3;
      return;
    case 3: 
      topMargin = paramInt3;
      return;
    case 4: 
      bottomMargin = paramInt3;
      return;
    case 5: 
      throw new IllegalArgumentException("baseline does not support margins");
    case 6: 
      startMargin = paramInt3;
      return;
    }
    endMargin = paramInt3;
  }
  
  public void setVerticalBias(int paramInt, float paramFloat)
  {
    getverticalBias = paramFloat;
  }
  
  public void setVisibility(int paramInt1, int paramInt2)
  {
    getvisibility = paramInt2;
  }
  
  private static class Constraint
  {
    static final int UNSET = -1;
    public int baselineToBaseline = -1;
    public int bottomMargin;
    public int bottomToBottom = -1;
    public int bottomToTop = -1;
    public String dimensionRatio = null;
    public int editorAbsoluteX = -1;
    public int editorAbsoluteY = -1;
    public int endMargin;
    public int endToEnd = -1;
    public int endToStart = -1;
    public int goneBottomMargin;
    public int goneEndMargin;
    public int goneLeftMargin;
    public int goneRightMargin;
    public int goneStartMargin;
    public int goneTopMargin;
    public int guideBegin = -1;
    public int guideEnd = -1;
    public float guidePercent = -1.0F;
    public float horizontalBias = 0.5F;
    public int horizontalChainStyle;
    public float horizontalWeight;
    public int leftMargin;
    public int leftToLeft = -1;
    public int leftToRight = -1;
    public int mHeight;
    boolean mIsGuideline = false;
    int mViewId;
    public int mWidth;
    public int orientation = -1;
    public int rightMargin;
    public int rightToLeft = -1;
    public int rightToRight = -1;
    public int startMargin;
    public int startToEnd = -1;
    public int startToStart = -1;
    public int topMargin;
    public int topToBottom = -1;
    public int topToTop = -1;
    public float verticalBias = 0.5F;
    public int verticalChainStyle;
    public float verticalWeight;
    public int visibility;
    
    private Constraint() {}
    
    private void fillFrom(int paramInt, ConstraintLayout.LayoutParams paramLayoutParams)
    {
      mViewId = paramInt;
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
      horizontalBias = horizontalBias;
      verticalBias = verticalBias;
      dimensionRatio = dimensionRatio;
      editorAbsoluteX = editorAbsoluteX;
      editorAbsoluteY = editorAbsoluteY;
      orientation = orientation;
      guidePercent = guidePercent;
      guideBegin = guideBegin;
      guideEnd = guideEnd;
      mWidth = width;
      mHeight = height;
      leftMargin = leftMargin;
      rightMargin = rightMargin;
      topMargin = topMargin;
      bottomMargin = bottomMargin;
      verticalWeight = verticalWeight;
      horizontalWeight = horizontalWeight;
      verticalChainStyle = verticalChainStyle;
      horizontalChainStyle = horizontalChainStyle;
      if (Build.VERSION.SDK_INT >= 17)
      {
        endMargin = paramLayoutParams.getMarginEnd();
        startMargin = paramLayoutParams.getMarginStart();
      }
    }
    
    public void applyTo(ConstraintLayout.LayoutParams paramLayoutParams)
    {
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
      leftMargin = leftMargin;
      rightMargin = rightMargin;
      topMargin = topMargin;
      bottomMargin = bottomMargin;
      horizontalBias = horizontalBias;
      verticalBias = verticalBias;
      dimensionRatio = dimensionRatio;
      editorAbsoluteX = editorAbsoluteX;
      editorAbsoluteY = editorAbsoluteY;
      verticalWeight = verticalWeight;
      horizontalWeight = horizontalWeight;
      verticalChainStyle = verticalChainStyle;
      horizontalChainStyle = horizontalChainStyle;
      orientation = orientation;
      guidePercent = guidePercent;
      guideBegin = guideBegin;
      guideEnd = guideEnd;
      width = mWidth;
      height = mHeight;
      if (Build.VERSION.SDK_INT >= 17)
      {
        paramLayoutParams.setMarginStart(startMargin);
        paramLayoutParams.setMarginEnd(endMargin);
      }
      paramLayoutParams.validate();
    }
  }
}
