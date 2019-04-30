package android.support.constraint.solver.widgets;

import android.support.constraint.solver.ArrayRow;
import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.SolverVariable;
import java.util.ArrayList;
import java.util.Arrays;

public class ConstraintWidgetContainer
  extends WidgetContainer
{
  static boolean ALLOW_ROOT_GROUP = true;
  private static final boolean DEBUG = false;
  private static final boolean USE_DIRECT_CHAIN_RESOLUTION = true;
  private static final boolean USE_SNAPSHOT = true;
  private static final boolean USE_THREAD;
  protected LinearSystem mBackgroundSystem = null;
  private boolean mDirectResolution = true;
  private ConstraintWidget[] mHorizontalChainsArray = new ConstraintWidget[4];
  private int mHorizontalChainsSize = 0;
  private ConstraintWidget[] mMatchConstraintsChainedWidgets = new ConstraintWidget[4];
  int mPaddingBottom;
  int mPaddingLeft;
  int mPaddingRight;
  int mPaddingTop;
  private Snapshot mSnapshot;
  protected LinearSystem mSystem = new LinearSystem();
  private ConstraintWidget[] mVerticalChainsArray = new ConstraintWidget[4];
  private int mVerticalChainsSize = 0;
  int mWrapHeight;
  int mWrapWidth;
  
  public ConstraintWidgetContainer() {}
  
  public ConstraintWidgetContainer(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public ConstraintWidgetContainer(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  private void addHorizontalChain(ConstraintWidget paramConstraintWidget)
  {
    for (int i = 0; i < mHorizontalChainsSize; i++) {
      if (mHorizontalChainsArray[i] == paramConstraintWidget) {
        return;
      }
    }
    if (1 + mHorizontalChainsSize >= mHorizontalChainsArray.length) {
      mHorizontalChainsArray = ((ConstraintWidget[])Arrays.copyOf(mHorizontalChainsArray, 2 * mHorizontalChainsArray.length));
    }
    mHorizontalChainsArray[mHorizontalChainsSize] = paramConstraintWidget;
    mHorizontalChainsSize = (1 + mHorizontalChainsSize);
  }
  
  private void addVerticalChain(ConstraintWidget paramConstraintWidget)
  {
    for (int i = 0; i < mVerticalChainsSize; i++) {
      if (mVerticalChainsArray[i] == paramConstraintWidget) {
        return;
      }
    }
    if (1 + mVerticalChainsSize >= mVerticalChainsArray.length) {
      mVerticalChainsArray = ((ConstraintWidget[])Arrays.copyOf(mVerticalChainsArray, 2 * mVerticalChainsArray.length));
    }
    mVerticalChainsArray[mVerticalChainsSize] = paramConstraintWidget;
    mVerticalChainsSize = (1 + mVerticalChainsSize);
  }
  
  private void applyHorizontalChain(LinearSystem paramLinearSystem)
  {
    int i = 0;
    int j = mHorizontalChainsSize;
    if (i < j)
    {
      ConstraintWidget localConstraintWidget1 = mHorizontalChainsArray[i];
      int k = countMatchConstraintsChainedWidgets(mHorizontalChainsArray[i], 0);
      int m;
      label45:
      ConstraintWidget localConstraintWidget2;
      int n;
      if (mHorizontalChainStyle == 2)
      {
        m = 1;
        localConstraintWidget2 = localConstraintWidget1;
        if (mHorizontalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
          break label109;
        }
        n = 1;
        label62:
        if ((!mHorizontalChainFixedPosition) || (m != 0) || (n != 0) || (mHorizontalChainStyle != 0)) {
          break label115;
        }
        Optimizer.applyDirectResolutionHorizontalChain(this, paramLinearSystem, k, localConstraintWidget2);
      }
      label109:
      label115:
      label214:
      label248:
      label314:
      label357:
      label475:
      label481:
      label495:
      label501:
      label540:
      label599:
      label674:
      label678:
      float f;
      for (;;)
      {
        i++;
        break;
        m = 0;
        break label45;
        n = 0;
        break label62;
        if ((k == 0) || (m != 0))
        {
          ConstraintWidget localConstraintWidget3 = null;
          if ((localConstraintWidget3 == null) || ((mLeft.mTarget != null) && (mLeft.mTarget.mOwner == localConstraintWidget3)))
          {
            int i1 = mLeft.getMargin();
            int i2 = mRight.getMargin();
            SolverVariable localSolverVariable1 = mLeft.mSolverVariable;
            SolverVariable localSolverVariable2;
            SolverVariable localSolverVariable3;
            SolverVariable localSolverVariable4;
            int i3;
            int i6;
            ConstraintWidget localConstraintWidget4;
            if (mLeft.mTarget != null)
            {
              localSolverVariable2 = mLeft.mTarget.mSolverVariable;
              localSolverVariable3 = mRight.mSolverVariable;
              if (mRight.mTarget == null) {
                break label475;
              }
              localSolverVariable4 = mRight.mTarget.mSolverVariable;
              i3 = i1;
              if (localConstraintWidget3 != null) {
                i3 += mRight.getMargin();
              }
              if (localSolverVariable2 != null)
              {
                if (((localConstraintWidget2 != localConstraintWidget1) || (mHorizontalChainStyle != 1)) && ((m == 0) || (localConstraintWidget2 == localConstraintWidget1))) {
                  break label481;
                }
                paramLinearSystem.addEquality(localSolverVariable1, localSolverVariable2, i3, 3);
              }
              if (localSolverVariable4 != null)
              {
                i6 = i2;
                ConstraintAnchor localConstraintAnchor = mRight.mTarget.mOwner.mLeft;
                if (mTarget == null) {
                  break label495;
                }
                localConstraintWidget4 = mTarget.mOwner;
                int i7 = 1;
                if (localConstraintWidget4 == localConstraintWidget2)
                {
                  i6 += localConstraintAnchor.getMargin();
                  i7 = 0;
                }
                if (m == 0)
                {
                  if ((i7 == 0) || (mHorizontalChainStyle != 1)) {
                    break label501;
                  }
                  paramLinearSystem.addEquality(localSolverVariable3, localSolverVariable4, -i6, 3);
                }
              }
            }
            for (;;)
            {
              if (mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                paramLinearSystem.addEquality(mRight.mSolverVariable, mLeft.mSolverVariable, 0, 3);
              }
              localConstraintWidget3 = localConstraintWidget2;
              if (localSolverVariable4 == null) {
                break label540;
              }
              localConstraintWidget2 = mRight.mTarget.mOwner;
              break;
              localSolverVariable2 = null;
              break label214;
              localSolverVariable4 = null;
              break label248;
              paramLinearSystem.addGreaterThan(localSolverVariable1, localSolverVariable2, i3, 1);
              break label314;
              localConstraintWidget4 = null;
              break label357;
              paramLinearSystem.addLowerThan(localSolverVariable3, localSolverVariable4, -i6, 1);
              if (localSolverVariable2 != null) {
                paramLinearSystem.addCentering(localSolverVariable1, localSolverVariable2, i1, 0.5F, localSolverVariable4, localSolverVariable3, i2, 2);
              }
            }
          }
          if (m != 0)
          {
            int i4 = mLeft.getMargin();
            int i5 = mRight.getMargin();
            SolverVariable localSolverVariable5 = mLeft.mSolverVariable;
            SolverVariable localSolverVariable6;
            SolverVariable localSolverVariable7;
            if (mLeft.mTarget != null)
            {
              localSolverVariable6 = mLeft.mTarget.mSolverVariable;
              localSolverVariable7 = mRight.mSolverVariable;
              if (mRight.mTarget == null) {
                break label674;
              }
            }
            for (SolverVariable localSolverVariable8 = mRight.mTarget.mSolverVariable;; localSolverVariable8 = null)
            {
              if ((localSolverVariable6 == null) || (localSolverVariable8 == null)) {
                break label678;
              }
              paramLinearSystem.addCentering(localSolverVariable5, localSolverVariable6, i4, mHorizontalBiasPercent, localSolverVariable8, localSolverVariable7, i5, 2);
              break;
              localSolverVariable6 = null;
              break label599;
            }
          }
        }
        else
        {
          ConstraintWidget localConstraintWidget5 = null;
          f = 0.0F;
          if ((localConstraintWidget5 == null) || ((mLeft.mTarget != null) && (mLeft.mTarget.mOwner == localConstraintWidget5)))
          {
            if (mHorizontalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
            {
              int i8 = mLeft.getMargin();
              if (localConstraintWidget5 != null) {
                i8 += mRight.getMargin();
              }
              int i9 = 2;
              if (mLeft.mTarget.mOwner.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                i9 = 1;
              }
              paramLinearSystem.addGreaterThan(mLeft.mSolverVariable, mLeft.mTarget.mSolverVariable, i8, i9);
              int i10 = mRight.getMargin();
              if ((mRight.mTarget.mOwner.mLeft.mTarget != null) && (mRight.mTarget.mOwner.mLeft.mTarget.mOwner == localConstraintWidget2)) {
                i10 += mRight.mTarget.mOwner.mLeft.getMargin();
              }
              int i11 = 2;
              if (mRight.mTarget.mOwner.mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                i11 = 1;
              }
              paramLinearSystem.addLowerThan(mRight.mSolverVariable, mRight.mTarget.mSolverVariable, -i10, i11);
            }
            for (;;)
            {
              localConstraintWidget5 = localConstraintWidget2;
              localConstraintWidget2 = mRight.mTarget.mOwner;
              break;
              f += mHorizontalWeight;
              paramLinearSystem.addGreaterThan(mRight.mSolverVariable, mLeft.mSolverVariable, 0, 0);
              paramLinearSystem.addLowerThan(mRight.mSolverVariable, mRight.mTarget.mSolverVariable, 0, 0);
            }
          }
          if (k != 1) {
            break label1165;
          }
          ConstraintWidget localConstraintWidget8 = mMatchConstraintsChainedWidgets[0];
          int i18 = mLeft.getMargin();
          if (mLeft.mTarget != null) {
            i18 += mLeft.mTarget.getMargin();
          }
          paramLinearSystem.addEquality(mLeft.mSolverVariable, mLeft.mTarget.mSolverVariable, i18, 0);
          int i19 = mRight.getMargin();
          if (mRight.mTarget != null) {
            i19 += mRight.mTarget.getMargin();
          }
          paramLinearSystem.addEquality(mRight.mSolverVariable, mRight.mTarget.mSolverVariable, -i19, 0);
        }
      }
      label1165:
      for (int i12 = 0;; i12++)
      {
        int i13 = k - 1;
        if (i12 >= i13) {
          break;
        }
        ConstraintWidget localConstraintWidget6 = mMatchConstraintsChainedWidgets[i12];
        ConstraintWidget localConstraintWidget7 = mMatchConstraintsChainedWidgets[(i12 + 1)];
        SolverVariable localSolverVariable9 = mLeft.mSolverVariable;
        SolverVariable localSolverVariable10 = mRight.mSolverVariable;
        SolverVariable localSolverVariable11 = mLeft.mSolverVariable;
        SolverVariable localSolverVariable12 = mRight.mSolverVariable;
        int i14 = mLeft.getMargin();
        if ((mLeft.mTarget != null) && (mLeft.mTarget.mOwner.mRight.mTarget != null) && (mLeft.mTarget.mOwner.mRight.mTarget.mOwner == localConstraintWidget6)) {
          i14 += mLeft.mTarget.mOwner.mRight.getMargin();
        }
        paramLinearSystem.addGreaterThan(localSolverVariable9, mLeft.mTarget.mSolverVariable, i14, 1);
        int i15 = mRight.getMargin();
        if ((mRight.mTarget != null) && (mRight.mTarget.mOwner.mLeft.mTarget != null) && (mRight.mTarget.mOwner.mLeft.mTarget.mOwner == localConstraintWidget6)) {
          i15 += mRight.mTarget.mOwner.mLeft.getMargin();
        }
        paramLinearSystem.addLowerThan(localSolverVariable10, mRight.mTarget.mSolverVariable, -i15, 1);
        if (i12 + 1 == k - 1)
        {
          int i16 = mLeft.getMargin();
          if ((mLeft.mTarget != null) && (mLeft.mTarget.mOwner.mRight.mTarget != null) && (mLeft.mTarget.mOwner.mRight.mTarget.mOwner == localConstraintWidget7)) {
            i16 += mLeft.mTarget.mOwner.mRight.getMargin();
          }
          paramLinearSystem.addGreaterThan(localSolverVariable11, mLeft.mTarget.mSolverVariable, i16, 1);
          int i17 = mRight.getMargin();
          if ((mRight.mTarget != null) && (mRight.mTarget.mOwner.mLeft.mTarget != null) && (mRight.mTarget.mOwner.mLeft.mTarget.mOwner == localConstraintWidget7)) {
            i17 += mRight.mTarget.mOwner.mLeft.getMargin();
          }
          paramLinearSystem.addLowerThan(localSolverVariable12, mRight.mTarget.mSolverVariable, -i17, 1);
        }
        ArrayRow localArrayRow = paramLinearSystem.createRow();
        localArrayRow.createRowEqualDimension(mHorizontalWeight, f, mHorizontalWeight, localSolverVariable9, mLeft.getMargin(), localSolverVariable10, mRight.getMargin(), localSolverVariable11, mLeft.getMargin(), localSolverVariable12, mRight.getMargin());
        paramLinearSystem.addConstraint(localArrayRow);
      }
    }
  }
  
  private void applyVerticalChain(LinearSystem paramLinearSystem)
  {
    int i = 0;
    int j = mVerticalChainsSize;
    if (i < j)
    {
      ConstraintWidget localConstraintWidget1 = mVerticalChainsArray[i];
      int k = countMatchConstraintsChainedWidgets(mVerticalChainsArray[i], 1);
      int m;
      label45:
      ConstraintWidget localConstraintWidget2;
      int n;
      if (mVerticalChainStyle == 2)
      {
        m = 1;
        localConstraintWidget2 = localConstraintWidget1;
        if (mVerticalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
          break label109;
        }
        n = 1;
        label62:
        if ((!mVerticalChainFixedPosition) || (m != 0) || (n != 0) || (mVerticalChainStyle != 0)) {
          break label115;
        }
        Optimizer.applyDirectResolutionVerticalChain(this, paramLinearSystem, k, localConstraintWidget2);
      }
      label109:
      label115:
      label214:
      label248:
      label314:
      label357:
      label475:
      label481:
      label495:
      label501:
      label540:
      label599:
      label674:
      label678:
      float f;
      for (;;)
      {
        i++;
        break;
        m = 0;
        break label45;
        n = 0;
        break label62;
        if ((k == 0) || (m != 0))
        {
          ConstraintWidget localConstraintWidget3 = null;
          if ((localConstraintWidget3 == null) || ((mTop.mTarget != null) && (mTop.mTarget.mOwner == localConstraintWidget3)))
          {
            int i1 = mTop.getMargin();
            int i2 = mBottom.getMargin();
            SolverVariable localSolverVariable1 = mTop.mSolverVariable;
            SolverVariable localSolverVariable2;
            SolverVariable localSolverVariable3;
            SolverVariable localSolverVariable4;
            int i3;
            int i6;
            ConstraintWidget localConstraintWidget4;
            if (mTop.mTarget != null)
            {
              localSolverVariable2 = mTop.mTarget.mSolverVariable;
              localSolverVariable3 = mBottom.mSolverVariable;
              if (mBottom.mTarget == null) {
                break label475;
              }
              localSolverVariable4 = mBottom.mTarget.mSolverVariable;
              i3 = i1;
              if (localConstraintWidget3 != null) {
                i3 += mBottom.getMargin();
              }
              if (localSolverVariable2 != null)
              {
                if (((localConstraintWidget2 != localConstraintWidget1) || (mVerticalChainStyle != 1)) && ((m == 0) || (localConstraintWidget2 == localConstraintWidget1))) {
                  break label481;
                }
                paramLinearSystem.addEquality(localSolverVariable1, localSolverVariable2, i3, 3);
              }
              if (localSolverVariable4 != null)
              {
                i6 = i2;
                ConstraintAnchor localConstraintAnchor = mBottom.mTarget.mOwner.mTop;
                if (mTarget == null) {
                  break label495;
                }
                localConstraintWidget4 = mTarget.mOwner;
                int i7 = 1;
                if (localConstraintWidget4 == localConstraintWidget2)
                {
                  i6 += localConstraintAnchor.getMargin();
                  i7 = 0;
                }
                if (m == 0)
                {
                  if ((i7 == 0) || (mVerticalChainStyle != 1)) {
                    break label501;
                  }
                  paramLinearSystem.addEquality(localSolverVariable3, localSolverVariable4, -i6, 3);
                }
              }
            }
            for (;;)
            {
              if (mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                paramLinearSystem.addEquality(mBottom.mSolverVariable, mTop.mSolverVariable, 0, 3);
              }
              localConstraintWidget3 = localConstraintWidget2;
              if (localSolverVariable4 == null) {
                break label540;
              }
              localConstraintWidget2 = mBottom.mTarget.mOwner;
              break;
              localSolverVariable2 = null;
              break label214;
              localSolverVariable4 = null;
              break label248;
              paramLinearSystem.addGreaterThan(localSolverVariable1, localSolverVariable2, i3, 1);
              break label314;
              localConstraintWidget4 = null;
              break label357;
              paramLinearSystem.addLowerThan(localSolverVariable3, localSolverVariable4, -i6, 1);
              if (localSolverVariable2 != null) {
                paramLinearSystem.addCentering(localSolverVariable1, localSolverVariable2, i1, 0.5F, localSolverVariable4, localSolverVariable3, i2, 2);
              }
            }
          }
          if (m != 0)
          {
            int i4 = mTop.getMargin();
            int i5 = mBottom.getMargin();
            SolverVariable localSolverVariable5 = mTop.mSolverVariable;
            SolverVariable localSolverVariable6;
            SolverVariable localSolverVariable7;
            if (mTop.mTarget != null)
            {
              localSolverVariable6 = mTop.mTarget.mSolverVariable;
              localSolverVariable7 = mBottom.mSolverVariable;
              if (mBottom.mTarget == null) {
                break label674;
              }
            }
            for (SolverVariable localSolverVariable8 = mBottom.mTarget.mSolverVariable;; localSolverVariable8 = null)
            {
              if ((localSolverVariable6 == null) || (localSolverVariable8 == null)) {
                break label678;
              }
              paramLinearSystem.addCentering(localSolverVariable5, localSolverVariable6, i4, mVerticalBiasPercent, localSolverVariable8, localSolverVariable7, i5, 2);
              break;
              localSolverVariable6 = null;
              break label599;
            }
          }
        }
        else
        {
          ConstraintWidget localConstraintWidget5 = null;
          f = 0.0F;
          if ((localConstraintWidget5 == null) || ((mTop.mTarget != null) && (mTop.mTarget.mOwner == localConstraintWidget5)))
          {
            if (mVerticalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
            {
              int i8 = mTop.getMargin();
              if (localConstraintWidget5 != null) {
                i8 += mBottom.getMargin();
              }
              int i9 = 2;
              if (mTop.mTarget.mOwner.mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                i9 = 1;
              }
              paramLinearSystem.addGreaterThan(mTop.mSolverVariable, mTop.mTarget.mSolverVariable, i8, i9);
              int i10 = mBottom.getMargin();
              if ((mBottom.mTarget.mOwner.mTop.mTarget != null) && (mBottom.mTarget.mOwner.mTop.mTarget.mOwner == localConstraintWidget2)) {
                i10 += mBottom.mTarget.mOwner.mTop.getMargin();
              }
              int i11 = 2;
              if (mBottom.mTarget.mOwner.mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                i11 = 1;
              }
              paramLinearSystem.addLowerThan(mBottom.mSolverVariable, mBottom.mTarget.mSolverVariable, -i10, i11);
            }
            for (;;)
            {
              localConstraintWidget5 = localConstraintWidget2;
              localConstraintWidget2 = mBottom.mTarget.mOwner;
              break;
              f += mVerticalWeight;
              paramLinearSystem.addGreaterThan(mBottom.mSolverVariable, mTop.mSolverVariable, 0, 0);
              paramLinearSystem.addLowerThan(mBottom.mSolverVariable, mBottom.mTarget.mSolverVariable, 0, 0);
            }
          }
          if (k != 1) {
            break label1165;
          }
          ConstraintWidget localConstraintWidget8 = mMatchConstraintsChainedWidgets[0];
          int i18 = mTop.getMargin();
          if (mTop.mTarget != null) {
            i18 += mTop.mTarget.getMargin();
          }
          paramLinearSystem.addEquality(mTop.mSolverVariable, mTop.mTarget.mSolverVariable, i18, 0);
          int i19 = mBottom.getMargin();
          if (mBottom.mTarget != null) {
            i19 += mBottom.mTarget.getMargin();
          }
          paramLinearSystem.addEquality(mBottom.mSolverVariable, mBottom.mTarget.mSolverVariable, -i19, 0);
        }
      }
      label1165:
      for (int i12 = 0;; i12++)
      {
        int i13 = k - 1;
        if (i12 >= i13) {
          break;
        }
        ConstraintWidget localConstraintWidget6 = mMatchConstraintsChainedWidgets[i12];
        ConstraintWidget localConstraintWidget7 = mMatchConstraintsChainedWidgets[(i12 + 1)];
        SolverVariable localSolverVariable9 = mTop.mSolverVariable;
        SolverVariable localSolverVariable10 = mBottom.mSolverVariable;
        SolverVariable localSolverVariable11 = mTop.mSolverVariable;
        SolverVariable localSolverVariable12 = mBottom.mSolverVariable;
        int i14 = mTop.getMargin();
        if ((mTop.mTarget != null) && (mTop.mTarget.mOwner.mBottom.mTarget != null) && (mTop.mTarget.mOwner.mBottom.mTarget.mOwner == localConstraintWidget6)) {
          i14 += mTop.mTarget.mOwner.mBottom.getMargin();
        }
        paramLinearSystem.addGreaterThan(localSolverVariable9, mTop.mTarget.mSolverVariable, i14, 1);
        int i15 = mBottom.getMargin();
        if ((mBottom.mTarget != null) && (mBottom.mTarget.mOwner.mTop.mTarget != null) && (mBottom.mTarget.mOwner.mTop.mTarget.mOwner == localConstraintWidget6)) {
          i15 += mBottom.mTarget.mOwner.mTop.getMargin();
        }
        paramLinearSystem.addLowerThan(localSolverVariable10, mBottom.mTarget.mSolverVariable, -i15, 1);
        if (i12 + 1 == k - 1)
        {
          int i16 = mTop.getMargin();
          if ((mTop.mTarget != null) && (mTop.mTarget.mOwner.mBottom.mTarget != null) && (mTop.mTarget.mOwner.mBottom.mTarget.mOwner == localConstraintWidget7)) {
            i16 += mTop.mTarget.mOwner.mBottom.getMargin();
          }
          paramLinearSystem.addGreaterThan(localSolverVariable11, mTop.mTarget.mSolverVariable, i16, 1);
          int i17 = mBottom.getMargin();
          if ((mBottom.mTarget != null) && (mBottom.mTarget.mOwner.mTop.mTarget != null) && (mBottom.mTarget.mOwner.mTop.mTarget.mOwner == localConstraintWidget7)) {
            i17 += mBottom.mTarget.mOwner.mTop.getMargin();
          }
          paramLinearSystem.addLowerThan(localSolverVariable12, mBottom.mTarget.mSolverVariable, -i17, 1);
        }
        ArrayRow localArrayRow = paramLinearSystem.createRow();
        localArrayRow.createRowEqualDimension(mVerticalWeight, f, mVerticalWeight, localSolverVariable9, mTop.getMargin(), localSolverVariable10, mBottom.getMargin(), localSolverVariable11, mTop.getMargin(), localSolverVariable12, mBottom.getMargin());
        paramLinearSystem.addConstraint(localArrayRow);
      }
    }
  }
  
  private int countMatchConstraintsChainedWidgets(ConstraintWidget paramConstraintWidget, int paramInt)
  {
    if (paramInt == 0)
    {
      boolean bool2 = true;
      ConstraintWidget localConstraintWidget3 = paramConstraintWidget;
      ConstraintAnchor localConstraintAnchor2 = mLeft.mTarget;
      int k = 0;
      if (localConstraintAnchor2 != null)
      {
        ConstraintWidget localConstraintWidget4 = mLeft.mTarget.mOwner;
        k = 0;
        if (localConstraintWidget4 != this) {
          bool2 = false;
        }
      }
      for (;;)
      {
        if (mRight.mTarget != null)
        {
          if (mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
          {
            if (k + 1 >= mMatchConstraintsChainedWidgets.length) {
              mMatchConstraintsChainedWidgets = ((ConstraintWidget[])Arrays.copyOf(mMatchConstraintsChainedWidgets, 2 * mMatchConstraintsChainedWidgets.length));
            }
            ConstraintWidget[] arrayOfConstraintWidget2 = mMatchConstraintsChainedWidgets;
            int m = k + 1;
            arrayOfConstraintWidget2[k] = paramConstraintWidget;
            k = m;
          }
          if (mRight.mTarget.mOwner.mLeft.mTarget != null) {
            break label182;
          }
        }
        label182:
        while ((mRight.mTarget.mOwner.mLeft.mTarget.mOwner != paramConstraintWidget) || (mRight.mTarget.mOwner == paramConstraintWidget))
        {
          if ((mRight.mTarget != null) && (mRight.mTarget.mOwner != this)) {
            bool2 = false;
          }
          mHorizontalChainFixedPosition = bool2;
          return k;
        }
        paramConstraintWidget = mRight.mTarget.mOwner;
      }
    }
    boolean bool1 = true;
    ConstraintWidget localConstraintWidget1 = paramConstraintWidget;
    ConstraintAnchor localConstraintAnchor1 = mTop.mTarget;
    int i = 0;
    if (localConstraintAnchor1 != null)
    {
      ConstraintWidget localConstraintWidget2 = mTop.mTarget.mOwner;
      i = 0;
      if (localConstraintWidget2 != this) {
        bool1 = false;
      }
    }
    for (;;)
    {
      if (mBottom.mTarget != null)
      {
        if (mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
        {
          if (i + 1 >= mMatchConstraintsChainedWidgets.length) {
            mMatchConstraintsChainedWidgets = ((ConstraintWidget[])Arrays.copyOf(mMatchConstraintsChainedWidgets, 2 * mMatchConstraintsChainedWidgets.length));
          }
          ConstraintWidget[] arrayOfConstraintWidget1 = mMatchConstraintsChainedWidgets;
          int j = i + 1;
          arrayOfConstraintWidget1[i] = paramConstraintWidget;
          i = j;
        }
        if (mBottom.mTarget.mOwner.mTop.mTarget != null) {
          break label407;
        }
      }
      label407:
      while ((mBottom.mTarget.mOwner.mTop.mTarget.mOwner != paramConstraintWidget) || (mBottom.mTarget.mOwner == paramConstraintWidget))
      {
        if ((mBottom.mTarget != null) && (mBottom.mTarget.mOwner != this)) {
          bool1 = false;
        }
        mVerticalChainFixedPosition = bool1;
        return i;
      }
      paramConstraintWidget = mBottom.mTarget.mOwner;
    }
  }
  
  public static ConstraintWidgetContainer createContainer(ConstraintWidgetContainer paramConstraintWidgetContainer, String paramString, ArrayList<ConstraintWidget> paramArrayList, int paramInt)
  {
    Rectangle localRectangle = getBounds(paramArrayList);
    if ((width == 0) || (height == 0))
    {
      paramConstraintWidgetContainer = null;
      return paramConstraintWidgetContainer;
    }
    if (paramInt > 0)
    {
      int k = Math.min(x, y);
      if (paramInt > k) {
        paramInt = k;
      }
      localRectangle.grow(paramInt, paramInt);
    }
    paramConstraintWidgetContainer.setOrigin(x, y);
    paramConstraintWidgetContainer.setDimension(width, height);
    paramConstraintWidgetContainer.setDebugName(paramString);
    ConstraintWidget localConstraintWidget1 = ((ConstraintWidget)paramArrayList.get(0)).getParent();
    int i = 0;
    int j = paramArrayList.size();
    label116:
    ConstraintWidget localConstraintWidget2;
    if (i < j)
    {
      localConstraintWidget2 = (ConstraintWidget)paramArrayList.get(i);
      if (localConstraintWidget2.getParent() == localConstraintWidget1) {
        break label150;
      }
    }
    for (;;)
    {
      i++;
      break label116;
      break;
      label150:
      paramConstraintWidgetContainer.add(localConstraintWidget2);
      localConstraintWidget2.setX(localConstraintWidget2.getX() - x);
      localConstraintWidget2.setY(localConstraintWidget2.getY() - y);
    }
  }
  
  private boolean optimize(LinearSystem paramLinearSystem)
  {
    int i = mChildren.size();
    if (mDirectResolution)
    {
      int i1;
      int i3;
      int i4;
      for (int n = 0;; n++)
      {
        i1 = 0;
        i2 = 0;
        i3 = 0;
        i4 = 0;
        if (n >= i) {
          break;
        }
        ConstraintWidget localConstraintWidget3 = (ConstraintWidget)mChildren.get(n);
        mHorizontalResolution = -1;
        mVerticalResolution = -1;
        if ((mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) || (mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT))
        {
          mHorizontalResolution = 1;
          mVerticalResolution = 1;
        }
      }
      if ((i3 == 0) && (i1 == 0)) {}
      for (int i2 = 1;; i2 = 1)
      {
        int i5;
        int i6;
        label140:
        label185:
        label240:
        label250:
        do
        {
          if (i2 != 0) {
            break label280;
          }
          i5 = i3;
          i6 = i1;
          i3 = 0;
          i1 = 0;
          i4++;
          int i7 = 0;
          ConstraintWidget localConstraintWidget2;
          if (i7 < i)
          {
            localConstraintWidget2 = (ConstraintWidget)mChildren.get(i7);
            if (mHorizontalResolution == -1)
            {
              if (mHorizontalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                break label240;
              }
              mHorizontalResolution = 1;
            }
            if (mVerticalResolution == -1)
            {
              if (mVerticalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                break label250;
              }
              mVerticalResolution = 1;
            }
          }
          for (;;)
          {
            if (mVerticalResolution == -1) {
              i3++;
            }
            if (mHorizontalResolution == -1) {
              i1++;
            }
            i7++;
            break label140;
            break;
            Optimizer.checkHorizontalSimpleDependency(this, paramLinearSystem, localConstraintWidget2);
            break label185;
            Optimizer.checkVerticalSimpleDependency(this, paramLinearSystem, localConstraintWidget2);
          }
        } while ((i5 != i3) || (i6 != i1));
      }
    }
    label280:
    int j = 0;
    int k = 0;
    int m = 0;
    if (m < i)
    {
      ConstraintWidget localConstraintWidget1 = (ConstraintWidget)mChildren.get(m);
      if (!mDirectResolution)
      {
        mHorizontalResolution = 1;
        mVerticalResolution = 1;
      }
      for (;;)
      {
        m++;
        break;
        if ((mHorizontalResolution == 1) || (mHorizontalResolution == -1)) {
          j++;
        }
        if ((mVerticalResolution == 1) || (mVerticalResolution == -1)) {
          k++;
        }
      }
    }
    return (mDirectResolution) && (j == 0) && (k == 0);
  }
  
  private void resetChains()
  {
    mHorizontalChainsSize = 0;
    mVerticalChainsSize = 0;
  }
  
  static int setGroup(ConstraintAnchor paramConstraintAnchor, int paramInt)
  {
    int i = mGroup;
    if (mOwner.getParent() == null) {
      i = paramInt;
    }
    while (i <= paramInt) {
      return i;
    }
    mGroup = paramInt;
    ConstraintAnchor localConstraintAnchor1 = paramConstraintAnchor.getOpposite();
    ConstraintAnchor localConstraintAnchor2 = mTarget;
    if (localConstraintAnchor1 != null) {
      paramInt = setGroup(localConstraintAnchor1, paramInt);
    }
    if (localConstraintAnchor2 != null) {
      paramInt = setGroup(localConstraintAnchor2, paramInt);
    }
    if (localConstraintAnchor1 != null) {
      paramInt = setGroup(localConstraintAnchor1, paramInt);
    }
    mGroup = paramInt;
    return paramInt;
  }
  
  void addChain(ConstraintWidget paramConstraintWidget, int paramInt)
  {
    ConstraintWidget localConstraintWidget = paramConstraintWidget;
    if (paramInt == 0)
    {
      while ((mLeft.mTarget != null) && (mLeft.mTarget.mOwner.mRight.mTarget != null) && (mLeft.mTarget.mOwner.mRight.mTarget == mLeft) && (mLeft.mTarget.mOwner != localConstraintWidget)) {
        localConstraintWidget = mLeft.mTarget.mOwner;
      }
      addHorizontalChain(localConstraintWidget);
    }
    while (paramInt != 1) {
      return;
    }
    while ((mTop.mTarget != null) && (mTop.mTarget.mOwner.mBottom.mTarget != null) && (mTop.mTarget.mOwner.mBottom.mTarget == mTop) && (mTop.mTarget.mOwner != localConstraintWidget)) {
      localConstraintWidget = mTop.mTarget.mOwner;
    }
    addVerticalChain(localConstraintWidget);
  }
  
  public boolean addChildrenToSolver(LinearSystem paramLinearSystem, int paramInt)
  {
    addToSolver(paramLinearSystem, paramInt);
    int i = mChildren.size();
    if ((mDirectResolution) && (optimize(paramLinearSystem))) {
      return false;
    }
    int j = 0;
    if (j < i)
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)mChildren.get(j);
      if ((localConstraintWidget instanceof ConstraintWidgetContainer))
      {
        ConstraintWidget.DimensionBehaviour localDimensionBehaviour1 = mHorizontalDimensionBehaviour;
        ConstraintWidget.DimensionBehaviour localDimensionBehaviour2 = mVerticalDimensionBehaviour;
        if (localDimensionBehaviour1 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
          localConstraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        }
        if (localDimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
          localConstraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        }
        localConstraintWidget.addToSolver(paramLinearSystem, paramInt);
        if (localDimensionBehaviour1 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
          localConstraintWidget.setHorizontalDimensionBehaviour(localDimensionBehaviour1);
        }
        if (localDimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
          localConstraintWidget.setVerticalDimensionBehaviour(localDimensionBehaviour2);
        }
      }
      for (;;)
      {
        j++;
        break;
        localConstraintWidget.addToSolver(paramLinearSystem, paramInt);
      }
    }
    if (mHorizontalChainsSize > 0) {
      applyHorizontalChain(paramLinearSystem);
    }
    if (mVerticalChainsSize > 0) {
      applyVerticalChain(paramLinearSystem);
    }
    return true;
  }
  
  public void findWrapRecursive(ConstraintWidget paramConstraintWidget)
  {
    int i = paramConstraintWidget.getWrapWidth();
    int j = i;
    int k = i;
    mWrapVisited = true;
    int n;
    int i1;
    if ((!mRight.isConnected()) && (!mLeft.isConnected()))
    {
      k += paramConstraintWidget.getX();
      mDistToLeft = k;
      mDistToRight = j;
      int m = paramConstraintWidget.getWrapHeight();
      n = m;
      i1 = m;
      if ((mBaseline.mTarget != null) || (mTop.mTarget != null) || (mBottom.mTarget != null)) {
        break label402;
      }
      n += paramConstraintWidget.getY();
    }
    for (;;)
    {
      mDistToTop = n;
      mDistToBottom = i1;
      return;
      ConstraintAnchor localConstraintAnchor = mRight.mTarget;
      ConstraintWidget localConstraintWidget1 = null;
      if (localConstraintAnchor != null)
      {
        localConstraintWidget1 = mRight.mTarget.getOwner();
        j += mRight.getMargin();
        if ((!localConstraintWidget1.isRoot()) && (!mWrapVisited)) {
          findWrapRecursive(localConstraintWidget1);
        }
      }
      boolean bool1 = mLeft.isConnected();
      ConstraintWidget localConstraintWidget2 = null;
      if (bool1)
      {
        localConstraintWidget2 = mLeft.mTarget.getOwner();
        k += mLeft.getMargin();
        if ((!localConstraintWidget2.isRoot()) && (!mWrapVisited)) {
          findWrapRecursive(localConstraintWidget2);
        }
      }
      if ((mRight.mTarget != null) && (!localConstraintWidget1.isRoot()))
      {
        if (mRight.mTarget.mType != ConstraintAnchor.Type.RIGHT) {
          break label346;
        }
        j += mDistToRight - localConstraintWidget1.getWrapWidth();
      }
      for (;;)
      {
        if ((mLeft.mTarget == null) || (localConstraintWidget2.isRoot())) {
          break label371;
        }
        if (mLeft.mTarget.getType() != ConstraintAnchor.Type.LEFT) {
          break label373;
        }
        k += mDistToLeft - localConstraintWidget2.getWrapWidth();
        break;
        label346:
        if (mRight.mTarget.getType() == ConstraintAnchor.Type.LEFT) {
          j += mDistToRight;
        }
      }
      label371:
      break;
      label373:
      if (mLeft.mTarget.getType() != ConstraintAnchor.Type.RIGHT) {
        break;
      }
      k += mDistToLeft;
      break;
      label402:
      if (mBaseline.isConnected())
      {
        ConstraintWidget localConstraintWidget5 = mBaseline.mTarget.getOwner();
        if (!mWrapVisited) {
          findWrapRecursive(localConstraintWidget5);
        }
        if (mDistToBottom > i1) {
          i1 = mDistToBottom;
        }
        if (mDistToTop > n) {
          n = mDistToTop;
        }
        mDistToTop = n;
        mDistToBottom = i1;
        return;
      }
      boolean bool2 = mTop.isConnected();
      ConstraintWidget localConstraintWidget3 = null;
      if (bool2)
      {
        localConstraintWidget3 = mTop.mTarget.getOwner();
        n += mTop.getMargin();
        if ((!localConstraintWidget3.isRoot()) && (!mWrapVisited)) {
          findWrapRecursive(localConstraintWidget3);
        }
      }
      boolean bool3 = mBottom.isConnected();
      ConstraintWidget localConstraintWidget4 = null;
      if (bool3)
      {
        localConstraintWidget4 = mBottom.mTarget.getOwner();
        i1 += mBottom.getMargin();
        if ((!localConstraintWidget4.isRoot()) && (!mWrapVisited)) {
          findWrapRecursive(localConstraintWidget4);
        }
      }
      if ((mTop.mTarget != null) && (!localConstraintWidget3.isRoot()))
      {
        if (mTop.mTarget.getType() != ConstraintAnchor.Type.TOP) {
          break label714;
        }
        n += mDistToTop - localConstraintWidget3.getWrapHeight();
      }
      for (;;)
      {
        if ((mBottom.mTarget == null) || (localConstraintWidget4.isRoot())) {
          break label741;
        }
        if (mBottom.mTarget.getType() != ConstraintAnchor.Type.BOTTOM) {
          break label743;
        }
        i1 += mDistToBottom - localConstraintWidget4.getWrapHeight();
        break;
        label714:
        if (mTop.mTarget.getType() == ConstraintAnchor.Type.BOTTOM) {
          n += mDistToTop;
        }
      }
      label741:
      continue;
      label743:
      if (mBottom.mTarget.getType() == ConstraintAnchor.Type.TOP) {
        i1 += mDistToBottom;
      }
    }
  }
  
  public void findWrapSize(ArrayList<ConstraintWidget> paramArrayList)
  {
    int i = 0;
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i2 = paramArrayList.size();
    int i3 = 0;
    if (i3 < i2)
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)paramArrayList.get(i3);
      if (localConstraintWidget.isRoot()) {}
      for (;;)
      {
        i3++;
        break;
        if (!mWrapVisited) {
          findWrapRecursive(localConstraintWidget);
        }
        int i5 = mDistToLeft + mDistToRight - localConstraintWidget.getWrapWidth();
        int i6 = mDistToTop + mDistToBottom - localConstraintWidget.getWrapHeight();
        j = Math.max(j, mDistToLeft);
        k = Math.max(k, mDistToRight);
        m = Math.max(m, mDistToBottom);
        i = Math.max(i, mDistToTop);
        n = Math.max(n, i5);
        i1 = Math.max(i1, i6);
      }
    }
    mWrapWidth = Math.max(Math.max(j, k), n);
    mWrapHeight = Math.max(Math.max(i, m), i1);
    for (int i4 = 0; i4 < i2; i4++) {
      getmWrapVisited = false;
    }
  }
  
  public ArrayList<Guideline> getHorizontalGuidelines()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int j = mChildren.size();
    while (i < j)
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)mChildren.get(i);
      if ((localConstraintWidget instanceof Guideline))
      {
        Guideline localGuideline = (Guideline)localConstraintWidget;
        if (localGuideline.getOrientation() == 0) {
          localArrayList.add(localGuideline);
        }
      }
      i++;
    }
    return localArrayList;
  }
  
  public LinearSystem getSystem()
  {
    return mSystem;
  }
  
  public String getType()
  {
    return "ConstraintLayout";
  }
  
  public ArrayList<Guideline> getVerticalGuidelines()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int j = mChildren.size();
    while (i < j)
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)mChildren.get(i);
      if ((localConstraintWidget instanceof Guideline))
      {
        Guideline localGuideline = (Guideline)localConstraintWidget;
        if (localGuideline.getOrientation() == 1) {
          localArrayList.add(localGuideline);
        }
      }
      i++;
    }
    return localArrayList;
  }
  
  public boolean handlesInternalConstraints()
  {
    return false;
  }
  
  public boolean isAnimating()
  {
    if (super.isAnimating()) {
      return true;
    }
    int i = 0;
    int j = mChildren.size();
    for (;;)
    {
      if (i >= j) {
        break label47;
      }
      if (((ConstraintWidget)mChildren.get(i)).isAnimating()) {
        break;
      }
      i++;
    }
    label47:
    return false;
  }
  
  public void layout()
  {
    i = mX;
    j = mY;
    getWidth();
    getHeight();
    if (mParent != null)
    {
      if (mSnapshot == null) {
        mSnapshot = new Snapshot(this);
      }
      mSnapshot.updateFrom(this);
      setX(mPaddingLeft);
      setY(mPaddingTop);
      resetAnchors();
      resetSolverVariables(mSystem.getCache());
    }
    for (;;)
    {
      resetChains();
      int k = mChildren.size();
      for (int m = 0; m < k; m++)
      {
        ConstraintWidget localConstraintWidget = (ConstraintWidget)mChildren.get(m);
        if ((localConstraintWidget instanceof WidgetContainer)) {
          ((WidgetContainer)localConstraintWidget).layout();
        }
      }
      mX = 0;
      mY = 0;
    }
    boolean bool = true;
    try
    {
      mSystem.reset();
      bool = addChildrenToSolver(mSystem, Integer.MAX_VALUE);
      if (bool) {
        mSystem.minimize();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int n;
        int i1;
        localException.printStackTrace();
        continue;
        updateFromSolver(mSystem, Integer.MAX_VALUE);
        continue;
        mX = i;
        mY = j;
      }
    }
    if (bool)
    {
      updateChildrenFromSolver(mSystem, Integer.MAX_VALUE);
      if (mParent == null) {
        break label315;
      }
      n = getWidth();
      i1 = getHeight();
      mSnapshot.applyTo(this);
      setWidth(n + mPaddingLeft + mPaddingRight);
      setHeight(i1 + mPaddingTop + mPaddingBottom);
      resetSolverVariables(mSystem.getCache());
      if (this == getRootConstraintContainer()) {
        updateDrawPosition();
      }
    }
  }
  
  public int layoutFindGroups()
  {
    ConstraintAnchor.Type[] arrayOfType = new ConstraintAnchor.Type[5];
    arrayOfType[0] = ConstraintAnchor.Type.LEFT;
    arrayOfType[1] = ConstraintAnchor.Type.RIGHT;
    arrayOfType[2] = ConstraintAnchor.Type.TOP;
    arrayOfType[3] = ConstraintAnchor.Type.BASELINE;
    arrayOfType[4] = ConstraintAnchor.Type.BOTTOM;
    int i = 1;
    int j = mChildren.size();
    int k = 0;
    if (k < j)
    {
      ConstraintWidget localConstraintWidget3 = (ConstraintWidget)mChildren.get(k);
      ConstraintAnchor localConstraintAnchor9 = mLeft;
      label96:
      ConstraintAnchor localConstraintAnchor10;
      label124:
      ConstraintAnchor localConstraintAnchor11;
      label152:
      ConstraintAnchor localConstraintAnchor12;
      label180:
      ConstraintAnchor localConstraintAnchor13;
      if (mTarget != null)
      {
        if (setGroup(localConstraintAnchor9, i) == i) {
          i++;
        }
        localConstraintAnchor10 = mTop;
        if (mTarget == null) {
          break label225;
        }
        if (setGroup(localConstraintAnchor10, i) == i) {
          i++;
        }
        localConstraintAnchor11 = mRight;
        if (mTarget == null) {
          break label236;
        }
        if (setGroup(localConstraintAnchor11, i) == i) {
          i++;
        }
        localConstraintAnchor12 = mBottom;
        if (mTarget == null) {
          break label247;
        }
        if (setGroup(localConstraintAnchor12, i) == i) {
          i++;
        }
        localConstraintAnchor13 = mBaseline;
        if (mTarget == null) {
          break label258;
        }
        if (setGroup(localConstraintAnchor13, i) == i) {
          i++;
        }
      }
      for (;;)
      {
        k++;
        break;
        mGroup = Integer.MAX_VALUE;
        break label96;
        label225:
        mGroup = Integer.MAX_VALUE;
        break label124;
        label236:
        mGroup = Integer.MAX_VALUE;
        break label152;
        label247:
        mGroup = Integer.MAX_VALUE;
        break label180;
        label258:
        mGroup = Integer.MAX_VALUE;
      }
    }
    int m = 1;
    int n = 0;
    int i1 = 0;
    while (m != 0)
    {
      m = 0;
      n++;
      for (int i14 = 0; i14 < j; i14++)
      {
        ConstraintWidget localConstraintWidget2 = (ConstraintWidget)mChildren.get(i14);
        int i15 = 0;
        if (i15 < arrayOfType.length)
        {
          ConstraintAnchor.Type localType = arrayOfType[i15];
          int i16 = 2.$SwitchMap$android$support$constraint$solver$widgets$ConstraintAnchor$Type[localType.ordinal()];
          ConstraintAnchor localConstraintAnchor6 = null;
          label380:
          ConstraintAnchor localConstraintAnchor7;
          switch (i16)
          {
          default: 
            localConstraintAnchor7 = mTarget;
            if (localConstraintAnchor7 != null) {
              break;
            }
          }
          int i18;
          label492:
          ConstraintAnchor localConstraintAnchor8;
          do
          {
            i15++;
            break;
            localConstraintAnchor6 = mLeft;
            break label380;
            localConstraintAnchor6 = mTop;
            break label380;
            localConstraintAnchor6 = mRight;
            break label380;
            localConstraintAnchor6 = mBottom;
            break label380;
            localConstraintAnchor6 = mBaseline;
            break label380;
            if ((mOwner.getParent() != null) && (mGroup != mGroup))
            {
              if (mGroup <= mGroup) {
                break label580;
              }
              i18 = mGroup;
              mGroup = i18;
              mGroup = i18;
              i1++;
              m = 1;
            }
            localConstraintAnchor8 = localConstraintAnchor7.getOpposite();
          } while ((localConstraintAnchor8 == null) || (mGroup == mGroup));
          if (mGroup > mGroup) {}
          for (int i17 = mGroup;; i17 = mGroup)
          {
            mGroup = i17;
            mGroup = i17;
            i1++;
            m = 1;
            break;
            label580:
            i18 = mGroup;
            break label492;
          }
        }
      }
    }
    int[] arrayOfInt = new int[1 + mChildren.size() * arrayOfType.length];
    Arrays.fill(arrayOfInt, -1);
    int i2 = 0;
    int i3 = 0;
    ConstraintWidget localConstraintWidget1;
    int i4;
    if (i2 < j)
    {
      localConstraintWidget1 = (ConstraintWidget)mChildren.get(i2);
      ConstraintAnchor localConstraintAnchor1 = mLeft;
      if (mGroup == Integer.MAX_VALUE) {
        break label975;
      }
      int i13 = mGroup;
      if (arrayOfInt[i13] != -1) {
        break label968;
      }
      i4 = i3 + 1;
      arrayOfInt[i13] = i3;
      label701:
      mGroup = arrayOfInt[i13];
    }
    for (;;)
    {
      ConstraintAnchor localConstraintAnchor2 = mTop;
      if (mGroup != Integer.MAX_VALUE)
      {
        int i11 = mGroup;
        if (arrayOfInt[i11] == -1)
        {
          int i12 = i4 + 1;
          arrayOfInt[i11] = i4;
          i4 = i12;
        }
        mGroup = arrayOfInt[i11];
      }
      ConstraintAnchor localConstraintAnchor3 = mRight;
      if (mGroup != Integer.MAX_VALUE)
      {
        int i9 = mGroup;
        if (arrayOfInt[i9] == -1)
        {
          int i10 = i4 + 1;
          arrayOfInt[i9] = i4;
          i4 = i10;
        }
        mGroup = arrayOfInt[i9];
      }
      ConstraintAnchor localConstraintAnchor4 = mBottom;
      if (mGroup != Integer.MAX_VALUE)
      {
        int i7 = mGroup;
        if (arrayOfInt[i7] == -1)
        {
          int i8 = i4 + 1;
          arrayOfInt[i7] = i4;
          i4 = i8;
        }
        mGroup = arrayOfInt[i7];
      }
      ConstraintAnchor localConstraintAnchor5 = mBaseline;
      if (mGroup != Integer.MAX_VALUE)
      {
        int i5 = mGroup;
        if (arrayOfInt[i5] == -1)
        {
          int i6 = i4 + 1;
          arrayOfInt[i5] = i4;
          i4 = i6;
        }
        mGroup = arrayOfInt[i5];
      }
      i2++;
      i3 = i4;
      break;
      return i3;
      label968:
      i4 = i3;
      break label701;
      label975:
      i4 = i3;
    }
  }
  
  public int layoutFindGroupsSimple()
  {
    int i = mChildren.size();
    for (int j = 0; j < i; j++)
    {
      ConstraintWidget localConstraintWidget = (ConstraintWidget)mChildren.get(j);
      mLeft.mGroup = 0;
      mRight.mGroup = 0;
      mTop.mGroup = 1;
      mBottom.mGroup = 1;
      mBaseline.mGroup = 1;
    }
    return 2;
  }
  
  public void layoutWithGroup(int paramInt)
  {
    int i = mX;
    int j = mY;
    if (mParent != null)
    {
      if (mSnapshot == null) {
        mSnapshot = new Snapshot(this);
      }
      mSnapshot.updateFrom(this);
      mX = 0;
      mY = 0;
      resetAnchors();
      resetSolverVariables(mSystem.getCache());
    }
    for (;;)
    {
      int k = mChildren.size();
      for (int m = 0; m < k; m++)
      {
        ConstraintWidget localConstraintWidget = (ConstraintWidget)mChildren.get(m);
        if ((localConstraintWidget instanceof WidgetContainer)) {
          ((WidgetContainer)localConstraintWidget).layout();
        }
      }
      mX = 0;
      mY = 0;
    }
    mLeft.mGroup = 0;
    mRight.mGroup = 0;
    mTop.mGroup = 1;
    mBottom.mGroup = 1;
    mSystem.reset();
    int n = 0;
    for (;;)
    {
      if (n < paramInt) {
        try
        {
          addToSolver(mSystem, n);
          mSystem.minimize();
          updateFromSolver(mSystem, n);
          updateFromSolver(mSystem, -2);
          n++;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
    if (mParent != null)
    {
      int i1 = getWidth();
      int i2 = getHeight();
      mSnapshot.applyTo(this);
      setWidth(i1);
      setHeight(i2);
    }
    for (;;)
    {
      if (this == getRootConstraintContainer()) {
        updateDrawPosition();
      }
      return;
      mX = i;
      mY = j;
    }
  }
  
  public void reset()
  {
    mSystem.reset();
    mPaddingLeft = 0;
    mPaddingRight = 0;
    mPaddingTop = 0;
    mPaddingBottom = 0;
    super.reset();
  }
  
  public void setDirectResolution(boolean paramBoolean)
  {
    mDirectResolution = paramBoolean;
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    mPaddingLeft = paramInt1;
    mPaddingTop = paramInt2;
    mPaddingRight = paramInt3;
    mPaddingBottom = paramInt4;
  }
  
  public void updateChildrenFromSolver(LinearSystem paramLinearSystem, int paramInt)
  {
    updateFromSolver(paramLinearSystem, paramInt);
    int i = mChildren.size();
    for (int j = 0; j < i; j++) {
      ((ConstraintWidget)mChildren.get(j)).updateFromSolver(paramLinearSystem, paramInt);
    }
  }
}
