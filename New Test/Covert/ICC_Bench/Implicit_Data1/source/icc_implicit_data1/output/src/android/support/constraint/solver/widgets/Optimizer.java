package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.SolverVariable;

public class Optimizer
{
  public Optimizer() {}
  
  static void applyDirectResolutionHorizontalChain(ConstraintWidgetContainer paramConstraintWidgetContainer, LinearSystem paramLinearSystem, int paramInt, ConstraintWidget paramConstraintWidget)
  {
    ConstraintWidget localConstraintWidget1 = paramConstraintWidget;
    int i = 0;
    ConstraintWidget localConstraintWidget2 = null;
    int j = 0;
    float f1 = 0.0F;
    label60:
    label86:
    label93:
    label167:
    label185:
    label188:
    while (paramConstraintWidget != null)
    {
      j++;
      int i2;
      int i4;
      if (mHorizontalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
      {
        int i1 = i + paramConstraintWidget.getWidth();
        if (mLeft.mTarget != null)
        {
          i2 = mLeft.getMargin();
          int i3 = i1 + i2;
          if (mRight.mTarget == null) {
            break label167;
          }
          i4 = mRight.getMargin();
          i = i3 + i4;
          localConstraintWidget2 = paramConstraintWidget;
          if (mRight.mTarget == null) {
            break label185;
          }
        }
      }
      for (paramConstraintWidget = mRight.mTarget.mOwner;; paramConstraintWidget = null)
      {
        if ((paramConstraintWidget == null) || ((mLeft.mTarget != null) && ((mLeft.mTarget == null) || (mLeft.mTarget.mOwner == localConstraintWidget2)))) {
          break label188;
        }
        paramConstraintWidget = null;
        break;
        i2 = 0;
        break label60;
        i4 = 0;
        break label86;
        f1 += mHorizontalWeight;
        break label93;
      }
    }
    int k = 0;
    if (localConstraintWidget2 != null)
    {
      if (mRight.mTarget == null) {
        break label508;
      }
      k = mRight.mTarget.mOwner.getX();
      if ((mRight.mTarget != null) && (mRight.mTarget.mOwner == paramConstraintWidgetContainer)) {
        k = paramConstraintWidgetContainer.getRight();
      }
    }
    float f2 = k - 0 - i;
    float f3 = f2 / (j + 1);
    ConstraintWidget localConstraintWidget3 = localConstraintWidget1;
    float f4;
    label290:
    int m;
    label316:
    int n;
    label337:
    float f5;
    float f6;
    label396:
    ConstraintWidget localConstraintWidget4;
    if (paramInt == 0)
    {
      f4 = f3;
      if (localConstraintWidget3 == null) {
        return;
      }
      if (mLeft.mTarget == null) {
        break label527;
      }
      m = mLeft.getMargin();
      if (mRight.mTarget == null) {
        break label533;
      }
      n = mRight.getMargin();
      f5 = f4 + m;
      paramLinearSystem.addEquality(mLeft.mSolverVariable, (int)(0.5F + f5));
      if (mHorizontalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
        break label566;
      }
      if (f1 != 0.0F) {
        break label539;
      }
      f6 = f5 + (f3 - m - n);
      paramLinearSystem.addEquality(mRight.mSolverVariable, (int)(0.5F + f6));
      if (paramInt == 0) {
        f6 += f3;
      }
      f4 = f6 + n;
      localConstraintWidget4 = localConstraintWidget3;
      if (mRight.mTarget == null) {
        break label580;
      }
    }
    label508:
    label527:
    label533:
    label539:
    label566:
    label580:
    for (localConstraintWidget3 = mRight.mTarget.mOwner;; localConstraintWidget3 = null)
    {
      if ((localConstraintWidget3 != null) && (mLeft.mTarget != null) && (mLeft.mTarget.mOwner != localConstraintWidget4)) {
        localConstraintWidget3 = null;
      }
      if (localConstraintWidget3 != paramConstraintWidgetContainer) {
        break label290;
      }
      localConstraintWidget3 = null;
      break label290;
      k = 0;
      break;
      f3 = f2 / paramInt;
      f4 = 0.0F;
      break label290;
      m = 0;
      break label316;
      n = 0;
      break label337;
      f6 = f5 + (f2 * mHorizontalWeight / f1 - m - n);
      break label396;
      f6 = f5 + localConstraintWidget3.getWidth();
      break label396;
    }
  }
  
  static void applyDirectResolutionVerticalChain(ConstraintWidgetContainer paramConstraintWidgetContainer, LinearSystem paramLinearSystem, int paramInt, ConstraintWidget paramConstraintWidget)
  {
    ConstraintWidget localConstraintWidget1 = paramConstraintWidget;
    int i = 0;
    ConstraintWidget localConstraintWidget2 = null;
    int j = 0;
    float f1 = 0.0F;
    label60:
    label86:
    label93:
    label167:
    label185:
    label188:
    while (paramConstraintWidget != null)
    {
      j++;
      int i2;
      int i4;
      if (mVerticalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT)
      {
        int i1 = i + paramConstraintWidget.getHeight();
        if (mTop.mTarget != null)
        {
          i2 = mTop.getMargin();
          int i3 = i1 + i2;
          if (mBottom.mTarget == null) {
            break label167;
          }
          i4 = mBottom.getMargin();
          i = i3 + i4;
          localConstraintWidget2 = paramConstraintWidget;
          if (mBottom.mTarget == null) {
            break label185;
          }
        }
      }
      for (paramConstraintWidget = mBottom.mTarget.mOwner;; paramConstraintWidget = null)
      {
        if ((paramConstraintWidget == null) || ((mTop.mTarget != null) && ((mTop.mTarget == null) || (mTop.mTarget.mOwner == localConstraintWidget2)))) {
          break label188;
        }
        paramConstraintWidget = null;
        break;
        i2 = 0;
        break label60;
        i4 = 0;
        break label86;
        f1 += mVerticalWeight;
        break label93;
      }
    }
    int k = 0;
    if (localConstraintWidget2 != null)
    {
      if (mBottom.mTarget == null) {
        break label508;
      }
      k = mBottom.mTarget.mOwner.getX();
      if ((mBottom.mTarget != null) && (mBottom.mTarget.mOwner == paramConstraintWidgetContainer)) {
        k = paramConstraintWidgetContainer.getBottom();
      }
    }
    float f2 = k - 0 - i;
    float f3 = f2 / (j + 1);
    ConstraintWidget localConstraintWidget3 = localConstraintWidget1;
    float f4;
    label290:
    int m;
    label316:
    int n;
    label337:
    float f5;
    float f6;
    label396:
    ConstraintWidget localConstraintWidget4;
    if (paramInt == 0)
    {
      f4 = f3;
      if (localConstraintWidget3 == null) {
        return;
      }
      if (mTop.mTarget == null) {
        break label527;
      }
      m = mTop.getMargin();
      if (mBottom.mTarget == null) {
        break label533;
      }
      n = mBottom.getMargin();
      f5 = f4 + m;
      paramLinearSystem.addEquality(mTop.mSolverVariable, (int)(0.5F + f5));
      if (mVerticalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
        break label566;
      }
      if (f1 != 0.0F) {
        break label539;
      }
      f6 = f5 + (f3 - m - n);
      paramLinearSystem.addEquality(mBottom.mSolverVariable, (int)(0.5F + f6));
      if (paramInt == 0) {
        f6 += f3;
      }
      f4 = f6 + n;
      localConstraintWidget4 = localConstraintWidget3;
      if (mBottom.mTarget == null) {
        break label580;
      }
    }
    label508:
    label527:
    label533:
    label539:
    label566:
    label580:
    for (localConstraintWidget3 = mBottom.mTarget.mOwner;; localConstraintWidget3 = null)
    {
      if ((localConstraintWidget3 != null) && (mTop.mTarget != null) && (mTop.mTarget.mOwner != localConstraintWidget4)) {
        localConstraintWidget3 = null;
      }
      if (localConstraintWidget3 != paramConstraintWidgetContainer) {
        break label290;
      }
      localConstraintWidget3 = null;
      break label290;
      k = 0;
      break;
      f3 = f2 / paramInt;
      f4 = 0.0F;
      break label290;
      m = 0;
      break label316;
      n = 0;
      break label337;
      f6 = f5 + (f2 * mVerticalWeight / f1 - m - n);
      break label396;
      f6 = f5 + localConstraintWidget3.getHeight();
      break label396;
    }
  }
  
  static void checkHorizontalSimpleDependency(ConstraintWidgetContainer paramConstraintWidgetContainer, LinearSystem paramLinearSystem, ConstraintWidget paramConstraintWidget)
  {
    if (mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
      mHorizontalResolution = 1;
    }
    int i;
    label744:
    int j;
    label757:
    Guideline localGuideline;
    do
    {
      return;
      if ((mLeft.mTarget != null) && (mRight.mTarget != null))
      {
        if ((mLeft.mTarget.mOwner == paramConstraintWidgetContainer) && (mRight.mTarget.mOwner == paramConstraintWidgetContainer))
        {
          int i9 = mLeft.getMargin();
          int i10 = mRight.getMargin();
          int i12;
          if (mHorizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            i12 = i9;
          }
          for (int i13 = paramConstraintWidgetContainer.getWidth() - i10;; i13 = i12 + paramConstraintWidget.getWidth())
          {
            mLeft.mSolverVariable = paramLinearSystem.createObjectVariable(mLeft);
            mRight.mSolverVariable = paramLinearSystem.createObjectVariable(mRight);
            paramLinearSystem.addEquality(mLeft.mSolverVariable, i12);
            paramLinearSystem.addEquality(mRight.mSolverVariable, i13);
            mHorizontalResolution = 2;
            paramConstraintWidget.setHorizontalDimension(i12, i13);
            return;
            int i11 = paramConstraintWidget.getWidth();
            i12 = i9 + (int)(0.5F + (paramConstraintWidgetContainer.getWidth() - i9 - i10 - i11) * mHorizontalBiasPercent);
          }
        }
        mHorizontalResolution = 1;
        return;
      }
      if ((mLeft.mTarget != null) && (mLeft.mTarget.mOwner == paramConstraintWidgetContainer))
      {
        int i7 = mLeft.getMargin();
        int i8 = i7 + paramConstraintWidget.getWidth();
        mLeft.mSolverVariable = paramLinearSystem.createObjectVariable(mLeft);
        mRight.mSolverVariable = paramLinearSystem.createObjectVariable(mRight);
        paramLinearSystem.addEquality(mLeft.mSolverVariable, i7);
        paramLinearSystem.addEquality(mRight.mSolverVariable, i8);
        mHorizontalResolution = 2;
        paramConstraintWidget.setHorizontalDimension(i7, i8);
        return;
      }
      if ((mRight.mTarget != null) && (mRight.mTarget.mOwner == paramConstraintWidgetContainer))
      {
        mLeft.mSolverVariable = paramLinearSystem.createObjectVariable(mLeft);
        mRight.mSolverVariable = paramLinearSystem.createObjectVariable(mRight);
        int i5 = paramConstraintWidgetContainer.getWidth() - mRight.getMargin();
        int i6 = i5 - paramConstraintWidget.getWidth();
        paramLinearSystem.addEquality(mLeft.mSolverVariable, i6);
        paramLinearSystem.addEquality(mRight.mSolverVariable, i5);
        mHorizontalResolution = 2;
        paramConstraintWidget.setHorizontalDimension(i6, i5);
        return;
      }
      if ((mLeft.mTarget != null) && (mLeft.mTarget.mOwner.mHorizontalResolution == 2))
      {
        SolverVariable localSolverVariable2 = mLeft.mTarget.mSolverVariable;
        mLeft.mSolverVariable = paramLinearSystem.createObjectVariable(mLeft);
        mRight.mSolverVariable = paramLinearSystem.createObjectVariable(mRight);
        int i3 = (int)(0.5F + (computedValue + mLeft.getMargin()));
        int i4 = i3 + paramConstraintWidget.getWidth();
        paramLinearSystem.addEquality(mLeft.mSolverVariable, i3);
        paramLinearSystem.addEquality(mRight.mSolverVariable, i4);
        mHorizontalResolution = 2;
        paramConstraintWidget.setHorizontalDimension(i3, i4);
        return;
      }
      if ((mRight.mTarget != null) && (mRight.mTarget.mOwner.mHorizontalResolution == 2))
      {
        SolverVariable localSolverVariable1 = mRight.mTarget.mSolverVariable;
        mLeft.mSolverVariable = paramLinearSystem.createObjectVariable(mLeft);
        mRight.mSolverVariable = paramLinearSystem.createObjectVariable(mRight);
        int i1 = (int)(0.5F + (computedValue - mRight.getMargin()));
        int i2 = i1 - paramConstraintWidget.getWidth();
        paramLinearSystem.addEquality(mLeft.mSolverVariable, i2);
        paramLinearSystem.addEquality(mRight.mSolverVariable, i1);
        mHorizontalResolution = 2;
        paramConstraintWidget.setHorizontalDimension(i2, i1);
        return;
      }
      if (mLeft.mTarget == null) {
        break;
      }
      i = 1;
      if (mRight.mTarget == null) {
        break label902;
      }
      j = 1;
      if ((i != 0) || (j != 0)) {
        break label906;
      }
      if (!(paramConstraintWidget instanceof Guideline)) {
        break label949;
      }
      localGuideline = (Guideline)paramConstraintWidget;
    } while (localGuideline.getOrientation() != 1);
    mLeft.mSolverVariable = paramLinearSystem.createObjectVariable(mLeft);
    mRight.mSolverVariable = paramLinearSystem.createObjectVariable(mRight);
    float f;
    if (localGuideline.getRelativeBegin() != -1) {
      f = localGuideline.getRelativeBegin();
    }
    for (;;)
    {
      int n = (int)(0.5F + f);
      paramLinearSystem.addEquality(mLeft.mSolverVariable, n);
      paramLinearSystem.addEquality(mRight.mSolverVariable, n);
      mHorizontalResolution = 2;
      mVerticalResolution = 2;
      paramConstraintWidget.setHorizontalDimension(n, n);
      paramConstraintWidget.setVerticalDimension(0, paramConstraintWidgetContainer.getHeight());
      return;
      i = 0;
      break label744;
      label902:
      j = 0;
      break label757;
      label906:
      break;
      if (localGuideline.getRelativeEnd() != -1) {
        f = paramConstraintWidgetContainer.getWidth() - localGuideline.getRelativeEnd();
      } else {
        f = paramConstraintWidgetContainer.getWidth() * localGuideline.getRelativePercent();
      }
    }
    label949:
    mLeft.mSolverVariable = paramLinearSystem.createObjectVariable(mLeft);
    mRight.mSolverVariable = paramLinearSystem.createObjectVariable(mRight);
    int k = paramConstraintWidget.getX();
    int m = k + paramConstraintWidget.getWidth();
    paramLinearSystem.addEquality(mLeft.mSolverVariable, k);
    paramLinearSystem.addEquality(mRight.mSolverVariable, m);
    mHorizontalResolution = 2;
  }
  
  static void checkVerticalSimpleDependency(ConstraintWidgetContainer paramConstraintWidgetContainer, LinearSystem paramLinearSystem, ConstraintWidget paramConstraintWidget)
  {
    if (mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
      mVerticalResolution = 1;
    }
    int i;
    label1117:
    int j;
    label1130:
    int k;
    label1143:
    Guideline localGuideline;
    do
    {
      return;
      if ((mTop.mTarget != null) && (mBottom.mTarget != null))
      {
        if ((mTop.mTarget.mOwner == paramConstraintWidgetContainer) && (mBottom.mTarget.mOwner == paramConstraintWidgetContainer))
        {
          int i12 = mTop.getMargin();
          int i13 = mBottom.getMargin();
          int i16;
          if (mVerticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            i16 = i12;
          }
          for (int i17 = i16 + paramConstraintWidget.getHeight();; i17 = i16 + paramConstraintWidget.getHeight())
          {
            mTop.mSolverVariable = paramLinearSystem.createObjectVariable(mTop);
            mBottom.mSolverVariable = paramLinearSystem.createObjectVariable(mBottom);
            paramLinearSystem.addEquality(mTop.mSolverVariable, i16);
            paramLinearSystem.addEquality(mBottom.mSolverVariable, i17);
            if (mBaselineDistance > 0)
            {
              mBaseline.mSolverVariable = paramLinearSystem.createObjectVariable(mBaseline);
              paramLinearSystem.addEquality(mBaseline.mSolverVariable, i16 + mBaselineDistance);
            }
            mVerticalResolution = 2;
            paramConstraintWidget.setVerticalDimension(i16, i17);
            return;
            int i14 = paramConstraintWidget.getHeight();
            int i15 = paramConstraintWidgetContainer.getHeight() - i12 - i13 - i14;
            i16 = (int)(0.5F + (i12 + i15 * mVerticalBiasPercent));
          }
        }
        mVerticalResolution = 1;
        return;
      }
      if ((mTop.mTarget != null) && (mTop.mTarget.mOwner == paramConstraintWidgetContainer))
      {
        int i10 = mTop.getMargin();
        int i11 = i10 + paramConstraintWidget.getHeight();
        mTop.mSolverVariable = paramLinearSystem.createObjectVariable(mTop);
        mBottom.mSolverVariable = paramLinearSystem.createObjectVariable(mBottom);
        paramLinearSystem.addEquality(mTop.mSolverVariable, i10);
        paramLinearSystem.addEquality(mBottom.mSolverVariable, i11);
        if (mBaselineDistance > 0)
        {
          mBaseline.mSolverVariable = paramLinearSystem.createObjectVariable(mBaseline);
          paramLinearSystem.addEquality(mBaseline.mSolverVariable, i10 + mBaselineDistance);
        }
        mVerticalResolution = 2;
        paramConstraintWidget.setVerticalDimension(i10, i11);
        return;
      }
      if ((mBottom.mTarget != null) && (mBottom.mTarget.mOwner == paramConstraintWidgetContainer))
      {
        mTop.mSolverVariable = paramLinearSystem.createObjectVariable(mTop);
        mBottom.mSolverVariable = paramLinearSystem.createObjectVariable(mBottom);
        int i8 = paramConstraintWidgetContainer.getHeight() - mBottom.getMargin();
        int i9 = i8 - paramConstraintWidget.getHeight();
        paramLinearSystem.addEquality(mTop.mSolverVariable, i9);
        paramLinearSystem.addEquality(mBottom.mSolverVariable, i8);
        if (mBaselineDistance > 0)
        {
          mBaseline.mSolverVariable = paramLinearSystem.createObjectVariable(mBaseline);
          paramLinearSystem.addEquality(mBaseline.mSolverVariable, i9 + mBaselineDistance);
        }
        mVerticalResolution = 2;
        paramConstraintWidget.setVerticalDimension(i9, i8);
        return;
      }
      if ((mTop.mTarget != null) && (mTop.mTarget.mOwner.mVerticalResolution == 2))
      {
        SolverVariable localSolverVariable3 = mTop.mTarget.mSolverVariable;
        mTop.mSolverVariable = paramLinearSystem.createObjectVariable(mTop);
        mBottom.mSolverVariable = paramLinearSystem.createObjectVariable(mBottom);
        int i6 = (int)(0.5F + (computedValue + mTop.getMargin()));
        int i7 = i6 + paramConstraintWidget.getHeight();
        paramLinearSystem.addEquality(mTop.mSolverVariable, i6);
        paramLinearSystem.addEquality(mBottom.mSolverVariable, i7);
        if (mBaselineDistance > 0)
        {
          mBaseline.mSolverVariable = paramLinearSystem.createObjectVariable(mBaseline);
          paramLinearSystem.addEquality(mBaseline.mSolverVariable, i6 + mBaselineDistance);
        }
        mVerticalResolution = 2;
        paramConstraintWidget.setVerticalDimension(i6, i7);
        return;
      }
      if ((mBottom.mTarget != null) && (mBottom.mTarget.mOwner.mVerticalResolution == 2))
      {
        SolverVariable localSolverVariable2 = mBottom.mTarget.mSolverVariable;
        mTop.mSolverVariable = paramLinearSystem.createObjectVariable(mTop);
        mBottom.mSolverVariable = paramLinearSystem.createObjectVariable(mBottom);
        int i4 = (int)(0.5F + (computedValue - mBottom.getMargin()));
        int i5 = i4 - paramConstraintWidget.getHeight();
        paramLinearSystem.addEquality(mTop.mSolverVariable, i5);
        paramLinearSystem.addEquality(mBottom.mSolverVariable, i4);
        if (mBaselineDistance > 0)
        {
          mBaseline.mSolverVariable = paramLinearSystem.createObjectVariable(mBaseline);
          paramLinearSystem.addEquality(mBaseline.mSolverVariable, i5 + mBaselineDistance);
        }
        mVerticalResolution = 2;
        paramConstraintWidget.setVerticalDimension(i5, i4);
        return;
      }
      if ((mBaseline.mTarget != null) && (mBaseline.mTarget.mOwner.mVerticalResolution == 2))
      {
        SolverVariable localSolverVariable1 = mBaseline.mTarget.mSolverVariable;
        mTop.mSolverVariable = paramLinearSystem.createObjectVariable(mTop);
        mBottom.mSolverVariable = paramLinearSystem.createObjectVariable(mBottom);
        int i2 = (int)(0.5F + (computedValue - mBaselineDistance));
        int i3 = i2 + paramConstraintWidget.getHeight();
        paramLinearSystem.addEquality(mTop.mSolverVariable, i2);
        paramLinearSystem.addEquality(mBottom.mSolverVariable, i3);
        mBaseline.mSolverVariable = paramLinearSystem.createObjectVariable(mBaseline);
        paramLinearSystem.addEquality(mBaseline.mSolverVariable, i2 + mBaselineDistance);
        mVerticalResolution = 2;
        paramConstraintWidget.setVerticalDimension(i2, i3);
        return;
      }
      if (mBaseline.mTarget == null) {
        break;
      }
      i = 1;
      if (mTop.mTarget == null) {
        break label1292;
      }
      j = 1;
      if (mBottom.mTarget == null) {
        break label1298;
      }
      k = 1;
      if ((i != 0) || (j != 0) || (k != 0)) {
        break label1302;
      }
      if (!(paramConstraintWidget instanceof Guideline)) {
        break label1345;
      }
      localGuideline = (Guideline)paramConstraintWidget;
    } while (localGuideline.getOrientation() != 0);
    mTop.mSolverVariable = paramLinearSystem.createObjectVariable(mTop);
    mBottom.mSolverVariable = paramLinearSystem.createObjectVariable(mBottom);
    float f;
    if (localGuideline.getRelativeBegin() != -1) {
      f = localGuideline.getRelativeBegin();
    }
    for (;;)
    {
      int i1 = (int)(0.5F + f);
      paramLinearSystem.addEquality(mTop.mSolverVariable, i1);
      paramLinearSystem.addEquality(mBottom.mSolverVariable, i1);
      mVerticalResolution = 2;
      mHorizontalResolution = 2;
      paramConstraintWidget.setVerticalDimension(i1, i1);
      paramConstraintWidget.setHorizontalDimension(0, paramConstraintWidgetContainer.getWidth());
      return;
      i = 0;
      break label1117;
      label1292:
      j = 0;
      break label1130;
      label1298:
      k = 0;
      break label1143;
      label1302:
      break;
      if (localGuideline.getRelativeEnd() != -1) {
        f = paramConstraintWidgetContainer.getHeight() - localGuideline.getRelativeEnd();
      } else {
        f = paramConstraintWidgetContainer.getHeight() * localGuideline.getRelativePercent();
      }
    }
    label1345:
    mTop.mSolverVariable = paramLinearSystem.createObjectVariable(mTop);
    mBottom.mSolverVariable = paramLinearSystem.createObjectVariable(mBottom);
    int m = paramConstraintWidget.getY();
    int n = m + paramConstraintWidget.getHeight();
    paramLinearSystem.addEquality(mTop.mSolverVariable, m);
    paramLinearSystem.addEquality(mBottom.mSolverVariable, n);
    if (mBaselineDistance > 0)
    {
      mBaseline.mSolverVariable = paramLinearSystem.createObjectVariable(mBaseline);
      paramLinearSystem.addEquality(mBaseline.mSolverVariable, m + mBaselineDistance);
    }
    mVerticalResolution = 2;
  }
}
