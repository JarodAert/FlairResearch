package android.support.constraint.solver.widgets;

import android.support.constraint.solver.ArrayRow;
import android.support.constraint.solver.Cache;
import android.support.constraint.solver.EquationCreation;
import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.SolverVariable;
import java.util.ArrayList;

public class ConstraintWidget
  implements Solvable
{
  private static final boolean AUTOTAG_CENTER = false;
  public static final int CHAIN_PACKED = 2;
  public static final int CHAIN_SPREAD = 0;
  public static final int CHAIN_SPREAD_INSIDE = 1;
  public static float DEFAULT_BIAS = 0.5F;
  protected static final int DIRECT = 2;
  public static final int GONE = 8;
  public static final int HORIZONTAL = 0;
  public static final int INVISIBLE = 4;
  protected static final int SOLVER = 1;
  public static final int UNKNOWN = -1;
  public static final int VERTICAL = 1;
  public static final int VISIBLE;
  protected ArrayList<ConstraintAnchor> mAnchors = new ArrayList();
  private Animator mAnimator = new Animator(this);
  ConstraintAnchor mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
  int mBaselineDistance = 0;
  ConstraintAnchor mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
  ConstraintAnchor mCenter = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
  ConstraintAnchor mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
  ConstraintAnchor mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
  private Object mCompanionWidget;
  private int mContainerItemSkip = 0;
  private String mDebugName = null;
  private float mDimensionRatio = 0.0F;
  private int mDimensionRatioSide = -1;
  int mDistToBottom;
  int mDistToLeft;
  int mDistToRight;
  int mDistToTop;
  private int mDrawHeight = 0;
  private int mDrawWidth = 0;
  private int mDrawX = 0;
  private int mDrawY = 0;
  private int mHeight = 0;
  float mHorizontalBiasPercent = DEFAULT_BIAS;
  boolean mHorizontalChainFixedPosition;
  int mHorizontalChainStyle = 0;
  DimensionBehaviour mHorizontalDimensionBehaviour = DimensionBehaviour.FIXED;
  public int mHorizontalResolution = -1;
  float mHorizontalWeight = 0.0F;
  ConstraintAnchor mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
  private int mMinHeight;
  private int mMinWidth;
  protected int mOffsetX = 0;
  protected int mOffsetY = 0;
  ConstraintWidget mParent = null;
  ConstraintAnchor mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
  private int mSolverBottom = 0;
  private int mSolverLeft = 0;
  private int mSolverRight = 0;
  private int mSolverTop = 0;
  ConstraintAnchor mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
  private String mType = null;
  float mVerticalBiasPercent = DEFAULT_BIAS;
  boolean mVerticalChainFixedPosition;
  int mVerticalChainStyle = 0;
  DimensionBehaviour mVerticalDimensionBehaviour = DimensionBehaviour.FIXED;
  public int mVerticalResolution = -1;
  float mVerticalWeight = 0.0F;
  private int mVisibility = 0;
  private int mWidth = 0;
  private int mWrapHeight;
  boolean mWrapVisited;
  private int mWrapWidth;
  protected int mX = 0;
  protected int mY = 0;
  
  public ConstraintWidget()
  {
    addAnchors();
  }
  
  public ConstraintWidget(int paramInt1, int paramInt2)
  {
    this(0, 0, paramInt1, paramInt2);
  }
  
  public ConstraintWidget(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    mX = paramInt1;
    mY = paramInt2;
    mWidth = paramInt3;
    mHeight = paramInt4;
    addAnchors();
    forceUpdateDrawPosition();
  }
  
  private void addAnchors()
  {
    mAnchors.add(mLeft);
    mAnchors.add(mTop);
    mAnchors.add(mRight);
    mAnchors.add(mBottom);
    mAnchors.add(mCenterX);
    mAnchors.add(mCenterY);
    mAnchors.add(mBaseline);
  }
  
  private void applyConstraints(LinearSystem paramLinearSystem, boolean paramBoolean1, boolean paramBoolean2, ConstraintAnchor paramConstraintAnchor1, ConstraintAnchor paramConstraintAnchor2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, boolean paramBoolean3, boolean paramBoolean4)
  {
    SolverVariable localSolverVariable1 = paramLinearSystem.createObjectVariable(paramConstraintAnchor1);
    SolverVariable localSolverVariable2 = paramLinearSystem.createObjectVariable(paramConstraintAnchor2);
    SolverVariable localSolverVariable3 = paramLinearSystem.createObjectVariable(paramConstraintAnchor1.getTarget());
    SolverVariable localSolverVariable4 = paramLinearSystem.createObjectVariable(paramConstraintAnchor2.getTarget());
    int i = paramConstraintAnchor1.getMargin();
    int j = paramConstraintAnchor2.getMargin();
    if (mVisibility == 8) {
      paramInt3 = 0;
    }
    if ((localSolverVariable3 == null) && (localSolverVariable4 == null))
    {
      paramLinearSystem.addConstraint(paramLinearSystem.createRow().createRowEquals(localSolverVariable1, paramInt1));
      if (!paramBoolean3)
      {
        if (!paramBoolean1) {
          break label114;
        }
        paramLinearSystem.addConstraint(EquationCreation.createRowEquals(paramLinearSystem, localSolverVariable2, localSolverVariable1, paramInt4, true));
      }
    }
    label114:
    label629:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (paramBoolean2)
            {
              paramLinearSystem.addConstraint(EquationCreation.createRowEquals(paramLinearSystem, localSolverVariable2, localSolverVariable1, paramInt3, false));
              return;
            }
            paramLinearSystem.addConstraint(paramLinearSystem.createRow().createRowEquals(localSolverVariable2, paramInt2));
            return;
            if ((localSolverVariable3 == null) || (localSolverVariable4 != null)) {
              break;
            }
            paramLinearSystem.addConstraint(paramLinearSystem.createRow().createRowEquals(localSolverVariable1, localSolverVariable3, i));
            if (paramBoolean1)
            {
              paramLinearSystem.addConstraint(EquationCreation.createRowEquals(paramLinearSystem, localSolverVariable2, localSolverVariable1, paramInt4, true));
              return;
            }
          } while (paramBoolean3);
          if (paramBoolean2)
          {
            paramLinearSystem.addConstraint(paramLinearSystem.createRow().createRowEquals(localSolverVariable2, localSolverVariable1, paramInt3));
            return;
          }
          paramLinearSystem.addConstraint(paramLinearSystem.createRow().createRowEquals(localSolverVariable2, paramInt2));
          return;
          if ((localSolverVariable3 != null) || (localSolverVariable4 == null)) {
            break;
          }
          paramLinearSystem.addConstraint(paramLinearSystem.createRow().createRowEquals(localSolverVariable2, localSolverVariable4, j * -1));
          if (paramBoolean1)
          {
            paramLinearSystem.addConstraint(EquationCreation.createRowEquals(paramLinearSystem, localSolverVariable2, localSolverVariable1, paramInt4, true));
            return;
          }
        } while (paramBoolean3);
        if (paramBoolean2)
        {
          paramLinearSystem.addConstraint(paramLinearSystem.createRow().createRowEquals(localSolverVariable2, localSolverVariable1, paramInt3));
          return;
        }
        paramLinearSystem.addConstraint(paramLinearSystem.createRow().createRowEquals(localSolverVariable1, paramInt1));
        return;
        if (!paramBoolean2) {
          break;
        }
        if (paramBoolean1) {
          paramLinearSystem.addConstraint(EquationCreation.createRowEquals(paramLinearSystem, localSolverVariable2, localSolverVariable1, paramInt4, true));
        }
        while (paramConstraintAnchor1.getStrength() != paramConstraintAnchor2.getStrength()) {
          if (paramConstraintAnchor1.getStrength() == ConstraintAnchor.Strength.STRONG)
          {
            paramLinearSystem.addConstraint(paramLinearSystem.createRow().createRowEquals(localSolverVariable1, localSolverVariable3, i));
            SolverVariable localSolverVariable6 = paramLinearSystem.createSlackVariable();
            ArrayRow localArrayRow2 = paramLinearSystem.createRow();
            localArrayRow2.createRowLowerThan(localSolverVariable2, localSolverVariable4, localSolverVariable6, j * -1);
            paramLinearSystem.addConstraint(localArrayRow2);
            return;
            paramLinearSystem.addConstraint(paramLinearSystem.createRow().createRowEquals(localSolverVariable2, localSolverVariable1, paramInt3));
          }
          else
          {
            SolverVariable localSolverVariable5 = paramLinearSystem.createSlackVariable();
            ArrayRow localArrayRow1 = paramLinearSystem.createRow();
            localArrayRow1.createRowGreaterThan(localSolverVariable1, localSolverVariable3, localSolverVariable5, i);
            paramLinearSystem.addConstraint(localArrayRow1);
            paramLinearSystem.addConstraint(paramLinearSystem.createRow().createRowEquals(localSolverVariable2, localSolverVariable4, j * -1));
            return;
          }
        }
        if (localSolverVariable3 == localSolverVariable4)
        {
          paramLinearSystem.addConstraint(EquationCreation.createRowCentering(paramLinearSystem, localSolverVariable1, localSolverVariable3, 0, 0.5F, localSolverVariable4, localSolverVariable2, 0, true));
          return;
        }
      } while (paramBoolean4);
      boolean bool1;
      if (paramConstraintAnchor1.getConnectionType() != ConstraintAnchor.ConnectionType.STRICT)
      {
        bool1 = true;
        paramLinearSystem.addConstraint(EquationCreation.createRowGreaterThan(paramLinearSystem, localSolverVariable1, localSolverVariable3, i, bool1));
        if (paramConstraintAnchor2.getConnectionType() == ConstraintAnchor.ConnectionType.STRICT) {
          break label629;
        }
      }
      for (boolean bool2 = true;; bool2 = false)
      {
        paramLinearSystem.addConstraint(EquationCreation.createRowLowerThan(paramLinearSystem, localSolverVariable2, localSolverVariable4, j * -1, bool2));
        paramLinearSystem.addConstraint(EquationCreation.createRowCentering(paramLinearSystem, localSolverVariable1, localSolverVariable3, i, paramFloat, localSolverVariable4, localSolverVariable2, j, false));
        return;
        bool1 = false;
        break;
      }
      if (paramBoolean3)
      {
        paramLinearSystem.addConstraint(EquationCreation.createRowGreaterThan(paramLinearSystem, localSolverVariable1, localSolverVariable3, i, true));
        paramLinearSystem.addConstraint(EquationCreation.createRowLowerThan(paramLinearSystem, localSolverVariable2, localSolverVariable4, j * -1, true));
        paramLinearSystem.addConstraint(EquationCreation.createRowCentering(paramLinearSystem, localSolverVariable1, localSolverVariable3, i, paramFloat, localSolverVariable4, localSolverVariable2, j, true));
        return;
      }
    } while (paramBoolean4);
    paramLinearSystem.addConstraint(paramLinearSystem.createRow().createRowEquals(localSolverVariable1, localSolverVariable3, i));
    paramLinearSystem.addConstraint(paramLinearSystem.createRow().createRowEquals(localSolverVariable2, localSolverVariable4, j * -1));
  }
  
  public void addToSolver(LinearSystem paramLinearSystem)
  {
    addToSolver(paramLinearSystem, Integer.MAX_VALUE);
  }
  
  public void addToSolver(LinearSystem paramLinearSystem, int paramInt)
  {
    SolverVariable localSolverVariable1;
    if (paramInt != Integer.MAX_VALUE)
    {
      int i16 = mLeft.mGroup;
      localSolverVariable1 = null;
      if (i16 != paramInt) {}
    }
    else
    {
      localSolverVariable1 = paramLinearSystem.createObjectVariable(mLeft);
    }
    SolverVariable localSolverVariable2;
    if (paramInt != Integer.MAX_VALUE)
    {
      int i15 = mRight.mGroup;
      localSolverVariable2 = null;
      if (i15 != paramInt) {}
    }
    else
    {
      localSolverVariable2 = paramLinearSystem.createObjectVariable(mRight);
    }
    SolverVariable localSolverVariable3;
    if (paramInt != Integer.MAX_VALUE)
    {
      int i14 = mTop.mGroup;
      localSolverVariable3 = null;
      if (i14 != paramInt) {}
    }
    else
    {
      localSolverVariable3 = paramLinearSystem.createObjectVariable(mTop);
    }
    SolverVariable localSolverVariable4;
    if (paramInt != Integer.MAX_VALUE)
    {
      int i13 = mBottom.mGroup;
      localSolverVariable4 = null;
      if (i13 != paramInt) {}
    }
    else
    {
      localSolverVariable4 = paramLinearSystem.createObjectVariable(mBottom);
    }
    SolverVariable localSolverVariable5;
    if (paramInt != Integer.MAX_VALUE)
    {
      int i12 = mBaseline.mGroup;
      localSolverVariable5 = null;
      if (i12 != paramInt) {}
    }
    else
    {
      localSolverVariable5 = paramLinearSystem.createObjectVariable(mBaseline);
    }
    ConstraintWidget localConstraintWidget = mParent;
    boolean bool1 = false;
    boolean bool2 = false;
    if (localConstraintWidget != null)
    {
      if ((mLeft.mTarget == null) || (mLeft.mTarget.mTarget != mLeft))
      {
        ConstraintAnchor localConstraintAnchor7 = mRight.mTarget;
        bool1 = false;
        if (localConstraintAnchor7 != null)
        {
          ConstraintAnchor localConstraintAnchor11 = mRight.mTarget.mTarget;
          ConstraintAnchor localConstraintAnchor12 = mRight;
          bool1 = false;
          if (localConstraintAnchor11 != localConstraintAnchor12) {}
        }
      }
      else
      {
        ((ConstraintWidgetContainer)mParent).addChain(this, 0);
        bool1 = true;
      }
      if ((mTop.mTarget == null) || (mTop.mTarget.mTarget != mTop))
      {
        ConstraintAnchor localConstraintAnchor8 = mBottom.mTarget;
        bool2 = false;
        if (localConstraintAnchor8 != null)
        {
          ConstraintAnchor localConstraintAnchor9 = mBottom.mTarget.mTarget;
          ConstraintAnchor localConstraintAnchor10 = mBottom;
          bool2 = false;
          if (localConstraintAnchor9 != localConstraintAnchor10) {}
        }
      }
      else
      {
        ((ConstraintWidgetContainer)mParent).addChain(this, 1);
        bool2 = true;
      }
      if ((mParent.getHorizontalDimensionBehaviour() == DimensionBehaviour.WRAP_CONTENT) && (!bool1))
      {
        if ((mLeft.mTarget != null) && (mLeft.mTarget.mOwner == mParent)) {
          break label1098;
        }
        SolverVariable localSolverVariable10 = paramLinearSystem.createObjectVariable(mParent.mLeft);
        ArrayRow localArrayRow4 = paramLinearSystem.createRow();
        SolverVariable localSolverVariable11 = paramLinearSystem.createSlackVariable();
        localArrayRow4.createRowGreaterThan(localSolverVariable1, localSolverVariable10, localSolverVariable11, 0);
        paramLinearSystem.addConstraint(localArrayRow4);
        break label1097;
        if ((mRight.mTarget != null) && (mRight.mTarget.mOwner == mParent)) {
          break label1138;
        }
        SolverVariable localSolverVariable12 = paramLinearSystem.createObjectVariable(mParent.mRight);
        ArrayRow localArrayRow5 = paramLinearSystem.createRow();
        SolverVariable localSolverVariable13 = paramLinearSystem.createSlackVariable();
        localArrayRow5.createRowGreaterThan(localSolverVariable12, localSolverVariable2, localSolverVariable13, 0);
        paramLinearSystem.addConstraint(localArrayRow5);
      }
      label523:
      if ((mParent.getVerticalDimensionBehaviour() == DimensionBehaviour.WRAP_CONTENT) && (!bool2))
      {
        if ((mTop.mTarget != null) && (mTop.mTarget.mOwner == mParent)) {
          break label1178;
        }
        SolverVariable localSolverVariable6 = paramLinearSystem.createObjectVariable(mParent.mTop);
        ArrayRow localArrayRow2 = paramLinearSystem.createRow();
        SolverVariable localSolverVariable7 = paramLinearSystem.createSlackVariable();
        localArrayRow2.createRowGreaterThan(localSolverVariable3, localSolverVariable6, localSolverVariable7, 0);
        paramLinearSystem.addConstraint(localArrayRow2);
        label612:
        if ((mBottom.mTarget != null) && (mBottom.mTarget.mOwner == mParent)) {
          break label1218;
        }
        SolverVariable localSolverVariable8 = paramLinearSystem.createObjectVariable(mParent.mBottom);
        ArrayRow localArrayRow3 = paramLinearSystem.createRow();
        SolverVariable localSolverVariable9 = paramLinearSystem.createSlackVariable();
        localArrayRow3.createRowGreaterThan(localSolverVariable8, localSolverVariable4, localSolverVariable9, 0);
        paramLinearSystem.addConstraint(localArrayRow3);
      }
    }
    label683:
    int i = mWidth;
    if (i < mMinWidth) {
      i = mMinWidth;
    }
    int j = mHeight;
    int k = mMinHeight;
    if (j < k) {
      j = mMinHeight;
    }
    boolean bool3;
    label742:
    boolean bool4;
    label755:
    int m;
    float f1;
    int n;
    label953:
    boolean bool6;
    label973:
    ConstraintAnchor localConstraintAnchor5;
    ConstraintAnchor localConstraintAnchor6;
    int i8;
    int i9;
    int i10;
    float f4;
    if (mHorizontalDimensionBehaviour != DimensionBehaviour.MATCH_CONSTRAINT)
    {
      bool3 = true;
      if (mVerticalDimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT) {
        break label1264;
      }
      bool4 = true;
      if ((!bool3) && (mLeft != null) && (mRight != null) && ((mLeft.mTarget == null) || (mRight.mTarget == null))) {
        bool3 = true;
      }
      if ((!bool4) && (mTop != null) && (mBottom != null) && ((mTop.mTarget == null) || (mBottom.mTarget == null)) && ((mBaselineDistance == 0) || ((mBaseline != null) && ((mTop.mTarget == null) || (mBaseline.mTarget == null))))) {
        bool4 = true;
      }
      m = mDimensionRatioSide;
      f1 = mDimensionRatio;
      boolean bool5 = mDimensionRatio < 0.0F;
      n = 0;
      if (bool5)
      {
        int i11 = mVisibility;
        n = 0;
        if (i11 != 8)
        {
          if ((mHorizontalDimensionBehaviour != DimensionBehaviour.MATCH_CONSTRAINT) || (mVerticalDimensionBehaviour != DimensionBehaviour.MATCH_CONSTRAINT)) {
            break label1300;
          }
          n = 1;
          if ((!bool3) || (bool4)) {
            break label1270;
          }
          m = 0;
        }
      }
      if ((mHorizontalDimensionBehaviour != DimensionBehaviour.WRAP_CONTENT) || (!(this instanceof ConstraintWidgetContainer))) {
        break label1391;
      }
      bool6 = true;
      if ((mHorizontalResolution != 2) && ((paramInt == Integer.MAX_VALUE) || ((mLeft.mGroup == paramInt) && (mRight.mGroup == paramInt))))
      {
        localConstraintAnchor5 = mLeft;
        localConstraintAnchor6 = mRight;
        i8 = mX;
        i9 = i + mX;
        i10 = mMinWidth;
        f4 = mHorizontalBiasPercent;
        if ((n == 0) || (m != 0)) {
          break label1397;
        }
      }
    }
    label1097:
    label1098:
    label1138:
    label1178:
    label1218:
    label1264:
    label1270:
    label1300:
    label1391:
    label1397:
    for (boolean bool10 = true;; bool10 = false)
    {
      applyConstraints(paramLinearSystem, bool6, bool3, localConstraintAnchor5, localConstraintAnchor6, i8, i9, i, i10, f4, bool10, bool1);
      if (mVerticalResolution != 2) {
        break label1403;
      }
      return;
      if ((mLeft.mTarget == null) || (mLeft.mTarget.mOwner != mParent)) {
        break;
      }
      mLeft.setConnectionType(ConstraintAnchor.ConnectionType.STRICT);
      break;
      if ((mRight.mTarget == null) || (mRight.mTarget.mOwner != mParent)) {
        break label523;
      }
      mRight.setConnectionType(ConstraintAnchor.ConnectionType.STRICT);
      break label523;
      if ((mTop.mTarget == null) || (mTop.mTarget.mOwner != mParent)) {
        break label612;
      }
      mTop.setConnectionType(ConstraintAnchor.ConnectionType.STRICT);
      break label612;
      if ((mBottom.mTarget == null) || (mBottom.mTarget.mOwner != mParent)) {
        break label683;
      }
      mBottom.setConnectionType(ConstraintAnchor.ConnectionType.STRICT);
      break label683;
      bool3 = false;
      break label742;
      bool4 = false;
      break label755;
      if ((bool3) || (!bool4)) {
        break label953;
      }
      m = 1;
      if (mDimensionRatioSide != -1) {
        break label953;
      }
      f1 = 1.0F / f1;
      break label953;
      if (mHorizontalDimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT)
      {
        i = (int)(f1 * mHeight);
        bool3 = true;
        m = 0;
        n = 0;
        break label953;
      }
      DimensionBehaviour localDimensionBehaviour1 = mVerticalDimensionBehaviour;
      DimensionBehaviour localDimensionBehaviour2 = DimensionBehaviour.MATCH_CONSTRAINT;
      n = 0;
      if (localDimensionBehaviour1 != localDimensionBehaviour2) {
        break label953;
      }
      m = 1;
      if (mDimensionRatioSide == -1) {
        f1 = 1.0F / f1;
      }
      j = (int)(f1 * mWidth);
      bool4 = true;
      n = 0;
      break label953;
      bool6 = false;
      break label973;
    }
    label1403:
    boolean bool7;
    label1423:
    boolean bool9;
    if ((mVerticalDimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) && ((this instanceof ConstraintWidgetContainer)))
    {
      bool7 = true;
      if (mBaselineDistance <= 0) {
        break label1688;
      }
      ConstraintAnchor localConstraintAnchor3 = mBottom;
      if ((paramInt == Integer.MAX_VALUE) || ((mBottom.mGroup == paramInt) && (mBaseline.mGroup == paramInt)))
      {
        int i4 = j - getBaselineDistance();
        paramLinearSystem.addConstraint(EquationCreation.createRowEquals(paramLinearSystem, localSolverVariable4, localSolverVariable5, i4, false));
      }
      if (mBaseline.mTarget != null)
      {
        j = mBaselineDistance;
        localConstraintAnchor3 = mBaseline;
      }
      if ((paramInt == Integer.MAX_VALUE) || ((mTop.mGroup == paramInt) && (mGroup == paramInt)))
      {
        ConstraintAnchor localConstraintAnchor4 = mTop;
        int i5 = mY;
        int i6 = j + mY;
        int i7 = mMinHeight;
        float f3 = mVerticalBiasPercent;
        if ((n == 0) || (m != 1)) {
          break label1682;
        }
        bool9 = true;
        label1585:
        applyConstraints(paramLinearSystem, bool7, bool4, localConstraintAnchor4, localConstraintAnchor3, i5, i6, j, i7, f3, bool9, bool2);
      }
    }
    label1612:
    ArrayRow localArrayRow1;
    label1682:
    label1688:
    ConstraintAnchor localConstraintAnchor1;
    ConstraintAnchor localConstraintAnchor2;
    int i1;
    int i2;
    int i3;
    float f2;
    for (;;)
    {
      if (n != 0)
      {
        localArrayRow1 = paramLinearSystem.createRow();
        if ((paramInt != Integer.MAX_VALUE) && ((mLeft.mGroup != paramInt) || (mRight.mGroup != paramInt))) {
          break;
        }
        if (m != 0) {
          break label1806;
        }
        paramLinearSystem.addConstraint(localArrayRow1.createRowDimensionRatio(localSolverVariable2, localSolverVariable1, localSolverVariable4, localSolverVariable3, f1));
        return;
        bool7 = false;
        break label1423;
        bool9 = false;
        break label1585;
        if ((paramInt == Integer.MAX_VALUE) || ((mTop.mGroup == paramInt) && (mBottom.mGroup == paramInt)))
        {
          localConstraintAnchor1 = mTop;
          localConstraintAnchor2 = mBottom;
          i1 = mY;
          i2 = j + mY;
          i3 = mMinHeight;
          f2 = mVerticalBiasPercent;
          if ((n == 0) || (m != 1)) {
            break label1800;
          }
        }
      }
    }
    label1800:
    for (boolean bool8 = true;; bool8 = false)
    {
      applyConstraints(paramLinearSystem, bool7, bool4, localConstraintAnchor1, localConstraintAnchor2, i1, i2, j, i3, f2, bool8, bool2);
      break label1612;
      break;
    }
    label1806:
    paramLinearSystem.addConstraint(localArrayRow1.createRowDimensionRatio(localSolverVariable4, localSolverVariable3, localSolverVariable2, localSolverVariable1, f1));
  }
  
  public void connect(ConstraintAnchor.Type paramType1, ConstraintWidget paramConstraintWidget, ConstraintAnchor.Type paramType2)
  {
    connect(paramType1, paramConstraintWidget, paramType2, 0, ConstraintAnchor.Strength.STRONG);
  }
  
  public void connect(ConstraintAnchor.Type paramType1, ConstraintWidget paramConstraintWidget, ConstraintAnchor.Type paramType2, int paramInt)
  {
    connect(paramType1, paramConstraintWidget, paramType2, paramInt, ConstraintAnchor.Strength.STRONG);
  }
  
  public void connect(ConstraintAnchor.Type paramType1, ConstraintWidget paramConstraintWidget, ConstraintAnchor.Type paramType2, int paramInt, ConstraintAnchor.Strength paramStrength)
  {
    connect(paramType1, paramConstraintWidget, paramType2, paramInt, paramStrength, 0);
  }
  
  public void connect(ConstraintAnchor.Type paramType1, ConstraintWidget paramConstraintWidget, ConstraintAnchor.Type paramType2, int paramInt1, ConstraintAnchor.Strength paramStrength, int paramInt2)
  {
    int i;
    int j;
    if (paramType1 == ConstraintAnchor.Type.CENTER) {
      if (paramType2 == ConstraintAnchor.Type.CENTER)
      {
        ConstraintAnchor localConstraintAnchor16 = getAnchor(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor localConstraintAnchor17 = getAnchor(ConstraintAnchor.Type.RIGHT);
        ConstraintAnchor localConstraintAnchor18 = getAnchor(ConstraintAnchor.Type.TOP);
        ConstraintAnchor localConstraintAnchor19 = getAnchor(ConstraintAnchor.Type.BOTTOM);
        if (localConstraintAnchor16 != null)
        {
          boolean bool4 = localConstraintAnchor16.isConnected();
          i = 0;
          if (bool4) {}
        }
        else
        {
          if (localConstraintAnchor17 == null) {
            break label162;
          }
          boolean bool3 = localConstraintAnchor17.isConnected();
          i = 0;
          if (!bool3) {
            break label162;
          }
        }
        if (localConstraintAnchor18 != null)
        {
          boolean bool2 = localConstraintAnchor18.isConnected();
          j = 0;
          if (bool2) {}
        }
        else
        {
          if (localConstraintAnchor19 == null) {
            break label200;
          }
          boolean bool1 = localConstraintAnchor19.isConnected();
          j = 0;
          if (!bool1) {
            break label200;
          }
        }
        label130:
        if ((i != 0) && (j != 0)) {
          getAnchor(ConstraintAnchor.Type.CENTER).connect(paramConstraintWidget.getAnchor(ConstraintAnchor.Type.CENTER), 0, paramInt2);
        }
      }
    }
    label162:
    label200:
    ConstraintAnchor localConstraintAnchor1;
    ConstraintAnchor localConstraintAnchor2;
    do
    {
      do
      {
        do
        {
          return;
          connect(ConstraintAnchor.Type.LEFT, paramConstraintWidget, ConstraintAnchor.Type.LEFT, 0, paramStrength, paramInt2);
          connect(ConstraintAnchor.Type.RIGHT, paramConstraintWidget, ConstraintAnchor.Type.RIGHT, 0, paramStrength, paramInt2);
          i = 1;
          break;
          connect(ConstraintAnchor.Type.TOP, paramConstraintWidget, ConstraintAnchor.Type.TOP, 0, paramStrength, paramInt2);
          connect(ConstraintAnchor.Type.BOTTOM, paramConstraintWidget, ConstraintAnchor.Type.BOTTOM, 0, paramStrength, paramInt2);
          j = 1;
          break label130;
          if (i != 0)
          {
            getAnchor(ConstraintAnchor.Type.CENTER_X).connect(paramConstraintWidget.getAnchor(ConstraintAnchor.Type.CENTER_X), 0, paramInt2);
            return;
          }
        } while (j == 0);
        getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(paramConstraintWidget.getAnchor(ConstraintAnchor.Type.CENTER_Y), 0, paramInt2);
        return;
        if ((paramType2 == ConstraintAnchor.Type.LEFT) || (paramType2 == ConstraintAnchor.Type.RIGHT))
        {
          connect(ConstraintAnchor.Type.LEFT, paramConstraintWidget, paramType2, 0, paramStrength, paramInt2);
          connect(ConstraintAnchor.Type.RIGHT, paramConstraintWidget, paramType2, 0, paramStrength, paramInt2);
          getAnchor(ConstraintAnchor.Type.CENTER).connect(paramConstraintWidget.getAnchor(paramType2), 0, paramInt2);
          return;
        }
      } while ((paramType2 != ConstraintAnchor.Type.TOP) && (paramType2 != ConstraintAnchor.Type.BOTTOM));
      connect(ConstraintAnchor.Type.TOP, paramConstraintWidget, paramType2, 0, paramStrength, paramInt2);
      connect(ConstraintAnchor.Type.BOTTOM, paramConstraintWidget, paramType2, 0, paramStrength, paramInt2);
      getAnchor(ConstraintAnchor.Type.CENTER).connect(paramConstraintWidget.getAnchor(paramType2), 0, paramInt2);
      return;
      if ((paramType1 == ConstraintAnchor.Type.CENTER_X) && ((paramType2 == ConstraintAnchor.Type.LEFT) || (paramType2 == ConstraintAnchor.Type.RIGHT)))
      {
        ConstraintAnchor localConstraintAnchor13 = getAnchor(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor localConstraintAnchor14 = paramConstraintWidget.getAnchor(paramType2);
        ConstraintAnchor localConstraintAnchor15 = getAnchor(ConstraintAnchor.Type.RIGHT);
        localConstraintAnchor13.connect(localConstraintAnchor14, 0, paramInt2);
        localConstraintAnchor15.connect(localConstraintAnchor14, 0, paramInt2);
        getAnchor(ConstraintAnchor.Type.CENTER_X).connect(localConstraintAnchor14, 0, paramInt2);
        return;
      }
      if ((paramType1 == ConstraintAnchor.Type.CENTER_Y) && ((paramType2 == ConstraintAnchor.Type.TOP) || (paramType2 == ConstraintAnchor.Type.BOTTOM)))
      {
        ConstraintAnchor localConstraintAnchor12 = paramConstraintWidget.getAnchor(paramType2);
        getAnchor(ConstraintAnchor.Type.TOP).connect(localConstraintAnchor12, 0, paramInt2);
        getAnchor(ConstraintAnchor.Type.BOTTOM).connect(localConstraintAnchor12, 0, paramInt2);
        getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(localConstraintAnchor12, 0, paramInt2);
        return;
      }
      if ((paramType1 == ConstraintAnchor.Type.CENTER_X) && (paramType2 == ConstraintAnchor.Type.CENTER_X))
      {
        getAnchor(ConstraintAnchor.Type.LEFT).connect(paramConstraintWidget.getAnchor(ConstraintAnchor.Type.LEFT), 0, paramInt2);
        getAnchor(ConstraintAnchor.Type.RIGHT).connect(paramConstraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT), 0, paramInt2);
        getAnchor(ConstraintAnchor.Type.CENTER_X).connect(paramConstraintWidget.getAnchor(paramType2), 0, paramInt2);
        return;
      }
      if ((paramType1 == ConstraintAnchor.Type.CENTER_Y) && (paramType2 == ConstraintAnchor.Type.CENTER_Y))
      {
        getAnchor(ConstraintAnchor.Type.TOP).connect(paramConstraintWidget.getAnchor(ConstraintAnchor.Type.TOP), 0, paramInt2);
        getAnchor(ConstraintAnchor.Type.BOTTOM).connect(paramConstraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM), 0, paramInt2);
        getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(paramConstraintWidget.getAnchor(paramType2), 0, paramInt2);
        return;
      }
      localConstraintAnchor1 = getAnchor(paramType1);
      localConstraintAnchor2 = paramConstraintWidget.getAnchor(paramType2);
    } while (!localConstraintAnchor1.isValidConnection(localConstraintAnchor2));
    if (paramType1 == ConstraintAnchor.Type.BASELINE)
    {
      ConstraintAnchor localConstraintAnchor10 = getAnchor(ConstraintAnchor.Type.TOP);
      ConstraintAnchor localConstraintAnchor11 = getAnchor(ConstraintAnchor.Type.BOTTOM);
      if (localConstraintAnchor10 != null) {
        localConstraintAnchor10.reset();
      }
      if (localConstraintAnchor11 != null) {
        localConstraintAnchor11.reset();
      }
      paramInt1 = 0;
    }
    for (;;)
    {
      localConstraintAnchor1.connect(localConstraintAnchor2, paramInt1, paramStrength, paramInt2);
      localConstraintAnchor2.getOwner().connectedTo(localConstraintAnchor1.getOwner());
      return;
      if ((paramType1 == ConstraintAnchor.Type.TOP) || (paramType1 == ConstraintAnchor.Type.BOTTOM))
      {
        ConstraintAnchor localConstraintAnchor3 = getAnchor(ConstraintAnchor.Type.BASELINE);
        if (localConstraintAnchor3 != null) {
          localConstraintAnchor3.reset();
        }
        ConstraintAnchor localConstraintAnchor4 = getAnchor(ConstraintAnchor.Type.CENTER);
        if (localConstraintAnchor4.getTarget() != localConstraintAnchor2) {
          localConstraintAnchor4.reset();
        }
        ConstraintAnchor localConstraintAnchor5 = getAnchor(paramType1).getOpposite();
        ConstraintAnchor localConstraintAnchor6 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
        if (localConstraintAnchor6.isConnected())
        {
          localConstraintAnchor5.reset();
          localConstraintAnchor6.reset();
        }
      }
      else if ((paramType1 == ConstraintAnchor.Type.LEFT) || (paramType1 == ConstraintAnchor.Type.RIGHT))
      {
        ConstraintAnchor localConstraintAnchor7 = getAnchor(ConstraintAnchor.Type.CENTER);
        if (localConstraintAnchor7.getTarget() != localConstraintAnchor2) {
          localConstraintAnchor7.reset();
        }
        ConstraintAnchor localConstraintAnchor8 = getAnchor(paramType1).getOpposite();
        ConstraintAnchor localConstraintAnchor9 = getAnchor(ConstraintAnchor.Type.CENTER_X);
        if (localConstraintAnchor9.isConnected())
        {
          localConstraintAnchor8.reset();
          localConstraintAnchor9.reset();
        }
      }
    }
  }
  
  public void connect(ConstraintAnchor paramConstraintAnchor1, ConstraintAnchor paramConstraintAnchor2, int paramInt)
  {
    connect(paramConstraintAnchor1, paramConstraintAnchor2, paramInt, ConstraintAnchor.Strength.STRONG, 0);
  }
  
  public void connect(ConstraintAnchor paramConstraintAnchor1, ConstraintAnchor paramConstraintAnchor2, int paramInt1, int paramInt2)
  {
    connect(paramConstraintAnchor1, paramConstraintAnchor2, paramInt1, ConstraintAnchor.Strength.STRONG, paramInt2);
  }
  
  public void connect(ConstraintAnchor paramConstraintAnchor1, ConstraintAnchor paramConstraintAnchor2, int paramInt1, ConstraintAnchor.Strength paramStrength, int paramInt2)
  {
    if (paramConstraintAnchor1.getOwner() == this) {
      connect(paramConstraintAnchor1.getType(), paramConstraintAnchor2.getOwner(), paramConstraintAnchor2.getType(), paramInt1, paramStrength, paramInt2);
    }
  }
  
  public void connectedTo(ConstraintWidget paramConstraintWidget) {}
  
  public void disconnectUnlockedWidget(ConstraintWidget paramConstraintWidget)
  {
    ArrayList localArrayList = getAnchors();
    int i = 0;
    int j = localArrayList.size();
    while (i < j)
    {
      ConstraintAnchor localConstraintAnchor = (ConstraintAnchor)localArrayList.get(i);
      if ((localConstraintAnchor.isConnected()) && (localConstraintAnchor.getTarget().getOwner() == paramConstraintWidget) && (localConstraintAnchor.getConnectionCreator() == 2)) {
        localConstraintAnchor.reset();
      }
      i++;
    }
  }
  
  public void disconnectWidget(ConstraintWidget paramConstraintWidget)
  {
    ArrayList localArrayList = getAnchors();
    int i = 0;
    int j = localArrayList.size();
    while (i < j)
    {
      ConstraintAnchor localConstraintAnchor = (ConstraintAnchor)localArrayList.get(i);
      if ((localConstraintAnchor.isConnected()) && (localConstraintAnchor.getTarget().getOwner() == paramConstraintWidget)) {
        localConstraintAnchor.reset();
      }
      i++;
    }
  }
  
  public void forceUpdateDrawPosition()
  {
    int i = mX;
    int j = mY;
    int k = mX + mWidth;
    int m = mY + mHeight;
    mDrawX = i;
    mDrawY = j;
    mDrawWidth = (k - i);
    mDrawHeight = (m - j);
  }
  
  public ConstraintAnchor getAnchor(ConstraintAnchor.Type paramType)
  {
    switch (1.$SwitchMap$android$support$constraint$solver$widgets$ConstraintAnchor$Type[paramType.ordinal()])
    {
    default: 
      return null;
    case 1: 
      return mLeft;
    case 2: 
      return mTop;
    case 3: 
      return mRight;
    case 4: 
      return mBottom;
    case 5: 
      return mBaseline;
    case 6: 
      return mCenterX;
    case 7: 
      return mCenterY;
    }
    return mCenter;
  }
  
  public ArrayList<ConstraintAnchor> getAnchors()
  {
    return mAnchors;
  }
  
  public int getBaselineDistance()
  {
    return mBaselineDistance;
  }
  
  public int getBottom()
  {
    return getY() + mHeight;
  }
  
  public Object getCompanionWidget()
  {
    return mCompanionWidget;
  }
  
  public int getContainerItemSkip()
  {
    return mContainerItemSkip;
  }
  
  public String getDebugName()
  {
    return mDebugName;
  }
  
  public float getDimensionRatio()
  {
    return mDimensionRatio;
  }
  
  public int getDimensionRatioSide()
  {
    return mDimensionRatioSide;
  }
  
  public int getDrawBottom()
  {
    return getDrawY() + mDrawHeight;
  }
  
  public int getDrawHeight()
  {
    return mDrawHeight;
  }
  
  public int getDrawRight()
  {
    return getDrawX() + mDrawWidth;
  }
  
  public int getDrawWidth()
  {
    return mDrawWidth;
  }
  
  public int getDrawX()
  {
    return mDrawX + mOffsetX;
  }
  
  public int getDrawY()
  {
    return mDrawY + mOffsetY;
  }
  
  public int getHeight()
  {
    if (mVisibility == 8) {
      return 0;
    }
    return mHeight;
  }
  
  public float getHorizontalBiasPercent()
  {
    return mHorizontalBiasPercent;
  }
  
  public ConstraintWidget getHorizontalChainControlWidget()
  {
    boolean bool = isInHorizontalChain();
    Object localObject1 = null;
    Object localObject2;
    if (bool) {
      localObject2 = this;
    }
    for (;;)
    {
      ConstraintAnchor localConstraintAnchor1;
      ConstraintAnchor localConstraintAnchor2;
      if ((localObject1 == null) && (localObject2 != null))
      {
        localConstraintAnchor1 = ((ConstraintWidget)localObject2).getAnchor(ConstraintAnchor.Type.LEFT);
        if (localConstraintAnchor1 != null) {
          break label59;
        }
        localConstraintAnchor2 = null;
        if (localConstraintAnchor2 != null) {
          break label69;
        }
      }
      label59:
      label69:
      for (ConstraintWidget localConstraintWidget = null;; localConstraintWidget = localConstraintAnchor2.getOwner())
      {
        if (localConstraintWidget != getParent()) {
          break label79;
        }
        localObject1 = localObject2;
        return localObject1;
        localConstraintAnchor2 = localConstraintAnchor1.getTarget();
        break;
      }
      label79:
      if (localConstraintWidget == null) {}
      for (ConstraintAnchor localConstraintAnchor3 = null;; localConstraintAnchor3 = localConstraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).getTarget())
      {
        if ((localConstraintAnchor3 == null) || (localConstraintAnchor3.getOwner() == localObject2)) {
          break label122;
        }
        localObject1 = localObject2;
        break;
      }
      label122:
      localObject2 = localConstraintWidget;
    }
  }
  
  public int getHorizontalChainStyle()
  {
    return mHorizontalChainStyle;
  }
  
  public DimensionBehaviour getHorizontalDimensionBehaviour()
  {
    return mHorizontalDimensionBehaviour;
  }
  
  public int getInternalDrawBottom()
  {
    return mDrawY + mDrawHeight;
  }
  
  public int getInternalDrawRight()
  {
    return mDrawX + mDrawWidth;
  }
  
  int getInternalDrawX()
  {
    return mDrawX;
  }
  
  int getInternalDrawY()
  {
    return mDrawY;
  }
  
  public int getLeft()
  {
    return getX();
  }
  
  public int getMinHeight()
  {
    return mMinHeight;
  }
  
  public int getMinWidth()
  {
    return mMinWidth;
  }
  
  public ConstraintWidget getParent()
  {
    return mParent;
  }
  
  public int getRight()
  {
    return getX() + mWidth;
  }
  
  public WidgetContainer getRootWidgetContainer()
  {
    for (ConstraintWidget localConstraintWidget = this; localConstraintWidget.getParent() != null; localConstraintWidget = localConstraintWidget.getParent()) {}
    if ((localConstraintWidget instanceof WidgetContainer)) {
      return (WidgetContainer)localConstraintWidget;
    }
    return null;
  }
  
  protected int getRootX()
  {
    return mX + mOffsetX;
  }
  
  protected int getRootY()
  {
    return mY + mOffsetY;
  }
  
  public int getTop()
  {
    return getY();
  }
  
  public String getType()
  {
    return mType;
  }
  
  public float getVerticalBiasPercent()
  {
    return mVerticalBiasPercent;
  }
  
  public ConstraintWidget getVerticalChainControlWidget()
  {
    boolean bool = isInVerticalChain();
    Object localObject1 = null;
    Object localObject2;
    if (bool) {
      localObject2 = this;
    }
    for (;;)
    {
      ConstraintAnchor localConstraintAnchor1;
      ConstraintAnchor localConstraintAnchor2;
      if ((localObject1 == null) && (localObject2 != null))
      {
        localConstraintAnchor1 = ((ConstraintWidget)localObject2).getAnchor(ConstraintAnchor.Type.TOP);
        if (localConstraintAnchor1 != null) {
          break label59;
        }
        localConstraintAnchor2 = null;
        if (localConstraintAnchor2 != null) {
          break label69;
        }
      }
      label59:
      label69:
      for (ConstraintWidget localConstraintWidget = null;; localConstraintWidget = localConstraintAnchor2.getOwner())
      {
        if (localConstraintWidget != getParent()) {
          break label79;
        }
        localObject1 = localObject2;
        return localObject1;
        localConstraintAnchor2 = localConstraintAnchor1.getTarget();
        break;
      }
      label79:
      if (localConstraintWidget == null) {}
      for (ConstraintAnchor localConstraintAnchor3 = null;; localConstraintAnchor3 = localConstraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).getTarget())
      {
        if ((localConstraintAnchor3 == null) || (localConstraintAnchor3.getOwner() == localObject2)) {
          break label122;
        }
        localObject1 = localObject2;
        break;
      }
      label122:
      localObject2 = localConstraintWidget;
    }
  }
  
  public int getVerticalChainStyle()
  {
    return mVerticalChainStyle;
  }
  
  public DimensionBehaviour getVerticalDimensionBehaviour()
  {
    return mVerticalDimensionBehaviour;
  }
  
  public int getVisibility()
  {
    return mVisibility;
  }
  
  public int getWidth()
  {
    if (mVisibility == 8) {
      return 0;
    }
    return mWidth;
  }
  
  public int getWrapHeight()
  {
    return mWrapHeight;
  }
  
  public int getWrapWidth()
  {
    return mWrapWidth;
  }
  
  public int getX()
  {
    return mX;
  }
  
  public int getY()
  {
    return mY;
  }
  
  public boolean hasAncestor(ConstraintWidget paramConstraintWidget)
  {
    ConstraintWidget localConstraintWidget = getParent();
    if (localConstraintWidget == paramConstraintWidget) {
      return true;
    }
    if (localConstraintWidget == paramConstraintWidget.getParent()) {
      return false;
    }
    do
    {
      localConstraintWidget = localConstraintWidget.getParent();
      if (localConstraintWidget == null) {
        break label46;
      }
      if (localConstraintWidget == paramConstraintWidget) {
        break;
      }
    } while (localConstraintWidget != paramConstraintWidget.getParent());
    return true;
    label46:
    return false;
  }
  
  public boolean hasBaseline()
  {
    return mBaselineDistance > 0;
  }
  
  public void immediateConnect(ConstraintAnchor.Type paramType1, ConstraintWidget paramConstraintWidget, ConstraintAnchor.Type paramType2, int paramInt1, int paramInt2)
  {
    getAnchor(paramType1).connect(paramConstraintWidget.getAnchor(paramType2), paramInt1, paramInt2, ConstraintAnchor.Strength.STRONG, 0, true);
  }
  
  public boolean isAnimating()
  {
    if (Animator.doAnimation()) {
      return mAnimator.isAnimating();
    }
    return false;
  }
  
  public boolean isInHorizontalChain()
  {
    return ((mLeft.mTarget != null) && (mLeft.mTarget.mTarget == mLeft)) || ((mRight.mTarget != null) && (mRight.mTarget.mTarget == mRight));
  }
  
  public boolean isInVerticalChain()
  {
    return ((mTop.mTarget != null) && (mTop.mTarget.mTarget == mTop)) || ((mBottom.mTarget != null) && (mBottom.mTarget.mTarget == mBottom));
  }
  
  public boolean isInsideConstraintLayout()
  {
    ConstraintWidget localConstraintWidget = getParent();
    if (localConstraintWidget == null) {
      return false;
    }
    do
    {
      localConstraintWidget = localConstraintWidget.getParent();
      if (localConstraintWidget == null) {
        break;
      }
    } while (!(localConstraintWidget instanceof ConstraintWidgetContainer));
    return true;
  }
  
  public boolean isRoot()
  {
    return mParent == null;
  }
  
  public boolean isRootContainer()
  {
    return ((this instanceof ConstraintWidgetContainer)) && ((mParent == null) || (!(mParent instanceof ConstraintWidgetContainer)));
  }
  
  public void reset()
  {
    mLeft.reset();
    mTop.reset();
    mRight.reset();
    mBottom.reset();
    mBaseline.reset();
    mCenterX.reset();
    mCenterY.reset();
    mCenter.reset();
    mParent = null;
    mWidth = 0;
    mHeight = 0;
    mDimensionRatio = 0.0F;
    mDimensionRatioSide = -1;
    mX = 0;
    mY = 0;
    mDrawX = 0;
    mDrawY = 0;
    mDrawWidth = 0;
    mDrawHeight = 0;
    mOffsetX = 0;
    mOffsetY = 0;
    mBaselineDistance = 0;
    mMinWidth = 0;
    mMinHeight = 0;
    mWrapWidth = 0;
    mWrapHeight = 0;
    mHorizontalBiasPercent = DEFAULT_BIAS;
    mVerticalBiasPercent = DEFAULT_BIAS;
    mHorizontalDimensionBehaviour = DimensionBehaviour.FIXED;
    mVerticalDimensionBehaviour = DimensionBehaviour.FIXED;
    mCompanionWidget = null;
    mContainerItemSkip = 0;
    mVisibility = 0;
    mDebugName = null;
    mType = null;
    mWrapVisited = false;
    mHorizontalChainStyle = 0;
    mVerticalChainStyle = 0;
    mHorizontalChainFixedPosition = false;
    mVerticalChainFixedPosition = false;
    mHorizontalWeight = 0.0F;
    mVerticalWeight = 0.0F;
    mHorizontalResolution = -1;
    mVerticalResolution = -1;
  }
  
  public void resetAllConstraints()
  {
    resetAnchors();
    setVerticalBiasPercent(DEFAULT_BIAS);
    setHorizontalBiasPercent(DEFAULT_BIAS);
    if ((this instanceof ConstraintWidgetContainer)) {}
    label83:
    label104:
    do
    {
      for (;;)
      {
        return;
        if (getHorizontalDimensionBehaviour() == DimensionBehaviour.MATCH_CONSTRAINT)
        {
          if (getWidth() != getWrapWidth()) {
            break label83;
          }
          setHorizontalDimensionBehaviour(DimensionBehaviour.WRAP_CONTENT);
        }
        while (getVerticalDimensionBehaviour() == DimensionBehaviour.MATCH_CONSTRAINT)
        {
          if (getHeight() != getWrapHeight()) {
            break label104;
          }
          setVerticalDimensionBehaviour(DimensionBehaviour.WRAP_CONTENT);
          return;
          if (getWidth() > getMinWidth()) {
            setHorizontalDimensionBehaviour(DimensionBehaviour.FIXED);
          }
        }
      }
    } while (getHeight() <= getMinHeight());
    setVerticalDimensionBehaviour(DimensionBehaviour.FIXED);
  }
  
  public void resetAnchor(ConstraintAnchor paramConstraintAnchor)
  {
    if ((getParent() != null) && ((getParent() instanceof ConstraintWidgetContainer)) && (((ConstraintWidgetContainer)getParent()).handlesInternalConstraints())) {
      return;
    }
    ConstraintAnchor localConstraintAnchor1 = getAnchor(ConstraintAnchor.Type.LEFT);
    ConstraintAnchor localConstraintAnchor2 = getAnchor(ConstraintAnchor.Type.RIGHT);
    ConstraintAnchor localConstraintAnchor3 = getAnchor(ConstraintAnchor.Type.TOP);
    ConstraintAnchor localConstraintAnchor4 = getAnchor(ConstraintAnchor.Type.BOTTOM);
    ConstraintAnchor localConstraintAnchor5 = getAnchor(ConstraintAnchor.Type.CENTER);
    ConstraintAnchor localConstraintAnchor6 = getAnchor(ConstraintAnchor.Type.CENTER_X);
    ConstraintAnchor localConstraintAnchor7 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
    if (paramConstraintAnchor == localConstraintAnchor5)
    {
      if ((localConstraintAnchor1.isConnected()) && (localConstraintAnchor2.isConnected()) && (localConstraintAnchor1.getTarget() == localConstraintAnchor2.getTarget()))
      {
        localConstraintAnchor1.reset();
        localConstraintAnchor2.reset();
      }
      if ((localConstraintAnchor3.isConnected()) && (localConstraintAnchor4.isConnected()) && (localConstraintAnchor3.getTarget() == localConstraintAnchor4.getTarget()))
      {
        localConstraintAnchor3.reset();
        localConstraintAnchor4.reset();
      }
      mHorizontalBiasPercent = 0.5F;
      mVerticalBiasPercent = 0.5F;
    }
    for (;;)
    {
      paramConstraintAnchor.reset();
      return;
      if (paramConstraintAnchor == localConstraintAnchor6)
      {
        if ((localConstraintAnchor1.isConnected()) && (localConstraintAnchor2.isConnected()) && (localConstraintAnchor1.getTarget().getOwner() == localConstraintAnchor2.getTarget().getOwner()))
        {
          localConstraintAnchor1.reset();
          localConstraintAnchor2.reset();
        }
        mHorizontalBiasPercent = 0.5F;
      }
      else if (paramConstraintAnchor == localConstraintAnchor7)
      {
        if ((localConstraintAnchor3.isConnected()) && (localConstraintAnchor4.isConnected()) && (localConstraintAnchor3.getTarget().getOwner() == localConstraintAnchor4.getTarget().getOwner()))
        {
          localConstraintAnchor3.reset();
          localConstraintAnchor4.reset();
        }
        mVerticalBiasPercent = 0.5F;
      }
      else if ((paramConstraintAnchor == localConstraintAnchor1) || (paramConstraintAnchor == localConstraintAnchor2))
      {
        if ((localConstraintAnchor1.isConnected()) && (localConstraintAnchor1.getTarget() == localConstraintAnchor2.getTarget())) {
          localConstraintAnchor5.reset();
        }
      }
      else if (((paramConstraintAnchor == localConstraintAnchor3) || (paramConstraintAnchor == localConstraintAnchor4)) && (localConstraintAnchor3.isConnected()) && (localConstraintAnchor3.getTarget() == localConstraintAnchor4.getTarget()))
      {
        localConstraintAnchor5.reset();
      }
    }
  }
  
  public void resetAnchors()
  {
    ConstraintWidget localConstraintWidget = getParent();
    if ((localConstraintWidget != null) && ((localConstraintWidget instanceof ConstraintWidgetContainer)) && (((ConstraintWidgetContainer)getParent()).handlesInternalConstraints())) {}
    for (;;)
    {
      return;
      int i = 0;
      int j = mAnchors.size();
      while (i < j)
      {
        ((ConstraintAnchor)mAnchors.get(i)).reset();
        i++;
      }
    }
  }
  
  public void resetAnchors(int paramInt)
  {
    ConstraintWidget localConstraintWidget = getParent();
    if ((localConstraintWidget != null) && ((localConstraintWidget instanceof ConstraintWidgetContainer)) && (((ConstraintWidgetContainer)getParent()).handlesInternalConstraints())) {
      return;
    }
    int i = 0;
    int j = mAnchors.size();
    label41:
    ConstraintAnchor localConstraintAnchor;
    if (i < j)
    {
      localConstraintAnchor = (ConstraintAnchor)mAnchors.get(i);
      if (paramInt == localConstraintAnchor.getConnectionCreator())
      {
        if (!localConstraintAnchor.isVerticalAnchor()) {
          break label95;
        }
        setVerticalBiasPercent(DEFAULT_BIAS);
      }
    }
    for (;;)
    {
      localConstraintAnchor.reset();
      i++;
      break label41;
      break;
      label95:
      setHorizontalBiasPercent(DEFAULT_BIAS);
    }
  }
  
  public void resetGroups()
  {
    int i = mAnchors.size();
    for (int j = 0; j < i; j++) {
      mAnchors.get(j)).mGroup = Integer.MAX_VALUE;
    }
  }
  
  public void resetSolverVariables(Cache paramCache)
  {
    mLeft.resetSolverVariable(paramCache);
    mTop.resetSolverVariable(paramCache);
    mRight.resetSolverVariable(paramCache);
    mBottom.resetSolverVariable(paramCache);
    mBaseline.resetSolverVariable(paramCache);
    mCenter.resetSolverVariable(paramCache);
    mCenterX.resetSolverVariable(paramCache);
    mCenterY.resetSolverVariable(paramCache);
  }
  
  public void setBaselineDistance(int paramInt)
  {
    mBaselineDistance = paramInt;
  }
  
  public void setCompanionWidget(Object paramObject)
  {
    mCompanionWidget = paramObject;
  }
  
  public void setContainerItemSkip(int paramInt)
  {
    if (paramInt >= 0)
    {
      mContainerItemSkip = paramInt;
      return;
    }
    mContainerItemSkip = 0;
  }
  
  public void setDebugName(String paramString)
  {
    mDebugName = paramString;
  }
  
  public void setDebugSolverName(LinearSystem paramLinearSystem, String paramString)
  {
    mDebugName = paramString;
    SolverVariable localSolverVariable1 = paramLinearSystem.createObjectVariable(mLeft);
    SolverVariable localSolverVariable2 = paramLinearSystem.createObjectVariable(mTop);
    SolverVariable localSolverVariable3 = paramLinearSystem.createObjectVariable(mRight);
    SolverVariable localSolverVariable4 = paramLinearSystem.createObjectVariable(mBottom);
    localSolverVariable1.setName(paramString + ".left");
    localSolverVariable2.setName(paramString + ".top");
    localSolverVariable3.setName(paramString + ".right");
    localSolverVariable4.setName(paramString + ".bottom");
    if (mBaselineDistance > 0) {
      paramLinearSystem.createObjectVariable(mBaseline).setName(paramString + ".baseline");
    }
  }
  
  public void setDimension(int paramInt1, int paramInt2)
  {
    mWidth = paramInt1;
    if (mWidth < mMinWidth) {
      mWidth = mMinWidth;
    }
    mHeight = paramInt2;
    if (mHeight < mMinHeight) {
      mHeight = mMinHeight;
    }
  }
  
  public void setDimensionRatio(float paramFloat, int paramInt)
  {
    mDimensionRatio = paramFloat;
    mDimensionRatioSide = paramInt;
  }
  
  public void setDimensionRatio(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      mDimensionRatio = 0.0F;
      return;
    }
    int i = -1;
    int j = paramString.length();
    int k = paramString.indexOf(',');
    String str4;
    label67:
    int m;
    label73:
    String str2;
    String str3;
    if ((k > 0) && (k < j - 1))
    {
      str4 = paramString.substring(0, k);
      if (str4.equalsIgnoreCase("W"))
      {
        i = 0;
        m = k + 1;
        int n = paramString.indexOf(':');
        if ((n < 0) || (n >= j - 1)) {
          break label267;
        }
        str2 = paramString.substring(m, n);
        str3 = paramString.substring(n + 1);
        int i2 = str2.length();
        f1 = 0.0F;
        if (i2 > 0)
        {
          int i3 = str3.length();
          f1 = 0.0F;
          if (i3 <= 0) {}
        }
      }
    }
    for (;;)
    {
      try
      {
        f3 = Float.parseFloat(str2);
        f4 = Float.parseFloat(str3);
        boolean bool1 = f3 < 0.0F;
        f1 = 0.0F;
        if (bool1)
        {
          boolean bool2 = f4 < 0.0F;
          f1 = 0.0F;
          if (bool2)
          {
            if (i != 1) {
              continue;
            }
            float f5 = Math.abs(f4 / f3);
            f1 = f5;
          }
        }
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        float f3;
        float f4;
        float f6;
        float f7;
        label267:
        String str1;
        int i1;
        f1 = 0.0F;
        continue;
      }
      if (f1 <= 0.0F) {
        break;
      }
      mDimensionRatio = f1;
      mDimensionRatioSide = i;
      return;
      if (!str4.equalsIgnoreCase("H")) {
        break label67;
      }
      i = 1;
      break label67;
      m = 0;
      break label73;
      f6 = f3 / f4;
      f7 = Math.abs(f6);
      f1 = f7;
      continue;
      str1 = paramString.substring(m);
      i1 = str1.length();
      f1 = 0.0F;
      if (i1 > 0) {
        try
        {
          float f2 = Float.parseFloat(str1);
          f1 = f2;
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          f1 = 0.0F;
        }
      }
    }
  }
  
  public void setDrawHeight(int paramInt)
  {
    mDrawHeight = paramInt;
  }
  
  public void setDrawOrigin(int paramInt1, int paramInt2)
  {
    mDrawX = (paramInt1 - mOffsetX);
    mDrawY = (paramInt2 - mOffsetY);
    mX = mDrawX;
    mY = mDrawY;
  }
  
  public void setDrawWidth(int paramInt)
  {
    mDrawWidth = paramInt;
  }
  
  public void setDrawX(int paramInt)
  {
    mDrawX = (paramInt - mOffsetX);
    mX = mDrawX;
  }
  
  public void setDrawY(int paramInt)
  {
    mDrawY = (paramInt - mOffsetY);
    mY = mDrawY;
  }
  
  public void setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt3 - paramInt1;
    int j = paramInt4 - paramInt2;
    if ((mHorizontalDimensionBehaviour == DimensionBehaviour.FIXED) && (i < getWidth())) {
      i = getWidth();
    }
    if ((mVerticalDimensionBehaviour == DimensionBehaviour.FIXED) && (j < getHeight())) {
      j = getHeight();
    }
    mX = paramInt1;
    mY = paramInt2;
    setDimension(i, j);
  }
  
  public void setGoneMargin(ConstraintAnchor.Type paramType, int paramInt)
  {
    switch (1.$SwitchMap$android$support$constraint$solver$widgets$ConstraintAnchor$Type[paramType.ordinal()])
    {
    default: 
      return;
    case 1: 
      mLeft.mGoneMargin = paramInt;
      return;
    case 2: 
      mTop.mGoneMargin = paramInt;
      return;
    case 3: 
      mRight.mGoneMargin = paramInt;
      return;
    }
    mBottom.mGoneMargin = paramInt;
  }
  
  public void setHeight(int paramInt)
  {
    mHeight = paramInt;
    if (mHeight < mMinHeight) {
      mHeight = mMinHeight;
    }
  }
  
  public void setHorizontalBiasPercent(float paramFloat)
  {
    mHorizontalBiasPercent = paramFloat;
  }
  
  public void setHorizontalChainStyle(int paramInt)
  {
    mHorizontalChainStyle = paramInt;
  }
  
  public void setHorizontalDimension(int paramInt1, int paramInt2)
  {
    mX = paramInt1;
    mWidth = (paramInt2 - paramInt1);
    if (mWidth < mMinWidth) {
      mWidth = mMinWidth;
    }
  }
  
  public void setHorizontalDimensionBehaviour(DimensionBehaviour paramDimensionBehaviour)
  {
    mHorizontalDimensionBehaviour = paramDimensionBehaviour;
    if (mHorizontalDimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
      setWidth(mWrapWidth);
    }
  }
  
  public void setHorizontalWeight(float paramFloat)
  {
    mHorizontalWeight = paramFloat;
  }
  
  public void setMinHeight(int paramInt)
  {
    mMinHeight = paramInt;
  }
  
  public void setMinWidth(int paramInt)
  {
    mMinWidth = paramInt;
  }
  
  public void setOffset(int paramInt1, int paramInt2)
  {
    mOffsetX = paramInt1;
    mOffsetY = paramInt2;
  }
  
  public void setOrigin(int paramInt1, int paramInt2)
  {
    mX = paramInt1;
    mY = paramInt2;
  }
  
  public void setParent(ConstraintWidget paramConstraintWidget)
  {
    mParent = paramConstraintWidget;
  }
  
  public void setType(String paramString)
  {
    mType = paramString;
  }
  
  public void setVerticalBiasPercent(float paramFloat)
  {
    mVerticalBiasPercent = paramFloat;
  }
  
  public void setVerticalChainStyle(int paramInt)
  {
    mVerticalChainStyle = paramInt;
  }
  
  public void setVerticalDimension(int paramInt1, int paramInt2)
  {
    mY = paramInt1;
    mHeight = (paramInt2 - paramInt1);
    if (mHeight < mMinHeight) {
      mHeight = mMinHeight;
    }
  }
  
  public void setVerticalDimensionBehaviour(DimensionBehaviour paramDimensionBehaviour)
  {
    mVerticalDimensionBehaviour = paramDimensionBehaviour;
    if (mVerticalDimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
      setHeight(mWrapHeight);
    }
  }
  
  public void setVerticalWeight(float paramFloat)
  {
    mVerticalWeight = paramFloat;
  }
  
  public void setVisibility(int paramInt)
  {
    mVisibility = paramInt;
  }
  
  public void setWidth(int paramInt)
  {
    mWidth = paramInt;
    if (mWidth < mMinWidth) {
      mWidth = mMinWidth;
    }
  }
  
  public void setWrapHeight(int paramInt)
  {
    mWrapHeight = paramInt;
  }
  
  public void setWrapWidth(int paramInt)
  {
    mWrapWidth = paramInt;
  }
  
  public void setX(int paramInt)
  {
    mX = paramInt;
  }
  
  public void setY(int paramInt)
  {
    mY = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1;
    StringBuilder localStringBuilder2;
    if (mType != null)
    {
      str1 = "type: " + mType + " ";
      localStringBuilder2 = localStringBuilder1.append(str1);
      if (mDebugName == null) {
        break label196;
      }
    }
    label196:
    for (String str2 = "id: " + mDebugName + " ";; str2 = "")
    {
      return str2 + "(" + mX + ", " + mY + ") - (" + mWidth + " x " + mHeight + ")" + " wrap: (" + mWrapWidth + " x " + mWrapHeight + ")";
      str1 = "";
      break;
    }
  }
  
  public void updateDrawPosition()
  {
    int i = mX;
    int j = mY;
    int k = mX + mWidth;
    int m = mY + mHeight;
    if (Animator.doAnimation())
    {
      mAnimator.animate(i, j, k, m);
      i = mAnimator.getCurrentLeft();
      j = mAnimator.getCurrentTop();
      k = mAnimator.getCurrentRight();
      m = mAnimator.getCurrentBottom();
    }
    mDrawX = i;
    mDrawY = j;
    mDrawWidth = (k - i);
    mDrawHeight = (m - j);
  }
  
  public void updateFromSolver(LinearSystem paramLinearSystem)
  {
    updateFromSolver(paramLinearSystem, Integer.MAX_VALUE);
  }
  
  public void updateFromSolver(LinearSystem paramLinearSystem, int paramInt)
  {
    if (paramInt == Integer.MAX_VALUE) {
      setFrame(paramLinearSystem.getObjectVariableValue(mLeft), paramLinearSystem.getObjectVariableValue(mTop), paramLinearSystem.getObjectVariableValue(mRight), paramLinearSystem.getObjectVariableValue(mBottom));
    }
    do
    {
      return;
      if (paramInt == -2)
      {
        setFrame(mSolverLeft, mSolverTop, mSolverRight, mSolverBottom);
        return;
      }
      if (mLeft.mGroup == paramInt) {
        mSolverLeft = paramLinearSystem.getObjectVariableValue(mLeft);
      }
      if (mTop.mGroup == paramInt) {
        mSolverTop = paramLinearSystem.getObjectVariableValue(mTop);
      }
      if (mRight.mGroup == paramInt) {
        mSolverRight = paramLinearSystem.getObjectVariableValue(mRight);
      }
    } while (mBottom.mGroup != paramInt);
    mSolverBottom = paramLinearSystem.getObjectVariableValue(mBottom);
  }
  
  public static enum ContentAlignment
  {
    static
    {
      END = new ContentAlignment("END", 2);
      TOP = new ContentAlignment("TOP", 3);
      VERTICAL_MIDDLE = new ContentAlignment("VERTICAL_MIDDLE", 4);
      BOTTOM = new ContentAlignment("BOTTOM", 5);
      LEFT = new ContentAlignment("LEFT", 6);
      RIGHT = new ContentAlignment("RIGHT", 7);
      ContentAlignment[] arrayOfContentAlignment = new ContentAlignment[8];
      arrayOfContentAlignment[0] = BEGIN;
      arrayOfContentAlignment[1] = MIDDLE;
      arrayOfContentAlignment[2] = END;
      arrayOfContentAlignment[3] = TOP;
      arrayOfContentAlignment[4] = VERTICAL_MIDDLE;
      arrayOfContentAlignment[5] = BOTTOM;
      arrayOfContentAlignment[6] = LEFT;
      arrayOfContentAlignment[7] = RIGHT;
      $VALUES = arrayOfContentAlignment;
    }
    
    private ContentAlignment() {}
  }
  
  public static enum DimensionBehaviour
  {
    static
    {
      MATCH_CONSTRAINT = new DimensionBehaviour("MATCH_CONSTRAINT", 2);
      DimensionBehaviour[] arrayOfDimensionBehaviour = new DimensionBehaviour[3];
      arrayOfDimensionBehaviour[0] = FIXED;
      arrayOfDimensionBehaviour[1] = WRAP_CONTENT;
      arrayOfDimensionBehaviour[2] = MATCH_CONSTRAINT;
      $VALUES = arrayOfDimensionBehaviour;
    }
    
    private DimensionBehaviour() {}
  }
}
