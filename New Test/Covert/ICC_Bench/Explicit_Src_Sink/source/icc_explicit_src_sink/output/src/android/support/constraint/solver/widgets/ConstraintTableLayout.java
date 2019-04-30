package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import java.util.ArrayList;

public class ConstraintTableLayout
  extends ConstraintWidgetContainer
{
  public static final int ALIGN_CENTER = 0;
  private static final int ALIGN_FULL = 3;
  public static final int ALIGN_LEFT = 1;
  public static final int ALIGN_RIGHT = 2;
  private ArrayList<Guideline> mHorizontalGuidelines = new ArrayList();
  private ArrayList<HorizontalSlice> mHorizontalSlices = new ArrayList();
  private int mNumCols = 0;
  private int mNumRows = 0;
  private int mPadding = 8;
  private boolean mVerticalGrowth = true;
  private ArrayList<Guideline> mVerticalGuidelines = new ArrayList();
  private ArrayList<VerticalSlice> mVerticalSlices = new ArrayList();
  private LinearSystem system = null;
  
  public ConstraintTableLayout() {}
  
  public ConstraintTableLayout(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public ConstraintTableLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  private void setChildrenConnections()
  {
    int i = mChildren.size();
    int j = 0;
    int k = 0;
    if (k < i)
    {
      ConstraintWidget localConstraintWidget1 = (ConstraintWidget)mChildren.get(k);
      int m = j + localConstraintWidget1.getContainerItemSkip();
      int n = m % mNumCols;
      int i1 = m / mNumCols;
      HorizontalSlice localHorizontalSlice = (HorizontalSlice)mHorizontalSlices.get(i1);
      VerticalSlice localVerticalSlice = (VerticalSlice)mVerticalSlices.get(n);
      ConstraintWidget localConstraintWidget2 = left;
      ConstraintWidget localConstraintWidget3 = right;
      ConstraintWidget localConstraintWidget4 = top;
      ConstraintWidget localConstraintWidget5 = bottom;
      localConstraintWidget1.getAnchor(ConstraintAnchor.Type.LEFT).connect(localConstraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT), mPadding);
      if ((localConstraintWidget3 instanceof Guideline))
      {
        localConstraintWidget1.getAnchor(ConstraintAnchor.Type.RIGHT).connect(localConstraintWidget3.getAnchor(ConstraintAnchor.Type.LEFT), mPadding);
        label169:
        switch (alignment)
        {
        default: 
          label200:
          localConstraintWidget1.getAnchor(ConstraintAnchor.Type.TOP).connect(localConstraintWidget4.getAnchor(ConstraintAnchor.Type.TOP), mPadding);
          if ((localConstraintWidget5 instanceof Guideline)) {
            localConstraintWidget1.getAnchor(ConstraintAnchor.Type.BOTTOM).connect(localConstraintWidget5.getAnchor(ConstraintAnchor.Type.TOP), mPadding);
          }
          break;
        }
      }
      for (;;)
      {
        j = m + 1;
        k++;
        break;
        localConstraintWidget1.getAnchor(ConstraintAnchor.Type.RIGHT).connect(localConstraintWidget3.getAnchor(ConstraintAnchor.Type.RIGHT), mPadding);
        break label169;
        localConstraintWidget1.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
        break label200;
        localConstraintWidget1.getAnchor(ConstraintAnchor.Type.LEFT).setStrength(ConstraintAnchor.Strength.STRONG);
        localConstraintWidget1.getAnchor(ConstraintAnchor.Type.RIGHT).setStrength(ConstraintAnchor.Strength.WEAK);
        break label200;
        localConstraintWidget1.getAnchor(ConstraintAnchor.Type.LEFT).setStrength(ConstraintAnchor.Strength.WEAK);
        localConstraintWidget1.getAnchor(ConstraintAnchor.Type.RIGHT).setStrength(ConstraintAnchor.Strength.STRONG);
        break label200;
        localConstraintWidget1.getAnchor(ConstraintAnchor.Type.BOTTOM).connect(localConstraintWidget5.getAnchor(ConstraintAnchor.Type.BOTTOM), mPadding);
      }
    }
  }
  
  private void setHorizontalSlices()
  {
    mHorizontalSlices.clear();
    float f1 = 100.0F / mNumRows;
    float f2 = f1;
    Object localObject = this;
    int i = 0;
    if (i < mNumRows)
    {
      HorizontalSlice localHorizontalSlice = new HorizontalSlice();
      top = ((ConstraintWidget)localObject);
      if (i < -1 + mNumRows)
      {
        Guideline localGuideline = new Guideline();
        localGuideline.setOrientation(0);
        localGuideline.setParent(this);
        localGuideline.setGuidePercent((int)f2);
        f2 += f1;
        bottom = localGuideline;
        mHorizontalGuidelines.add(localGuideline);
      }
      for (;;)
      {
        localObject = bottom;
        mHorizontalSlices.add(localHorizontalSlice);
        i++;
        break;
        bottom = this;
      }
    }
    updateDebugSolverNames();
  }
  
  private void setVerticalSlices()
  {
    mVerticalSlices.clear();
    Object localObject = this;
    float f1 = 100.0F / mNumCols;
    float f2 = f1;
    int i = 0;
    if (i < mNumCols)
    {
      VerticalSlice localVerticalSlice = new VerticalSlice();
      left = ((ConstraintWidget)localObject);
      if (i < -1 + mNumCols)
      {
        Guideline localGuideline = new Guideline();
        localGuideline.setOrientation(1);
        localGuideline.setParent(this);
        localGuideline.setGuidePercent((int)f2);
        f2 += f1;
        right = localGuideline;
        mVerticalGuidelines.add(localGuideline);
      }
      for (;;)
      {
        localObject = right;
        mVerticalSlices.add(localVerticalSlice);
        i++;
        break;
        right = this;
      }
    }
    updateDebugSolverNames();
  }
  
  private void updateDebugSolverNames()
  {
    if (system == null) {}
    for (;;)
    {
      return;
      int i = mVerticalGuidelines.size();
      for (int j = 0; j < i; j++) {
        ((Guideline)mVerticalGuidelines.get(j)).setDebugSolverName(system, getDebugName() + ".VG" + j);
      }
      int k = mHorizontalGuidelines.size();
      for (int m = 0; m < k; m++) {
        ((Guideline)mHorizontalGuidelines.get(m)).setDebugSolverName(system, getDebugName() + ".HG" + m);
      }
    }
  }
  
  public void addToSolver(LinearSystem paramLinearSystem, int paramInt)
  {
    super.addToSolver(paramLinearSystem, paramInt);
    int i = mChildren.size();
    if (i == 0) {}
    for (;;)
    {
      return;
      setTableDimensions();
      if (paramLinearSystem == mSystem)
      {
        int j = mVerticalGuidelines.size();
        int k = 0;
        if (k < j)
        {
          Guideline localGuideline2 = (Guideline)mVerticalGuidelines.get(k);
          if (getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {}
          for (boolean bool2 = true;; bool2 = false)
          {
            localGuideline2.setPositionRelaxed(bool2);
            localGuideline2.addToSolver(paramLinearSystem, paramInt);
            k++;
            break;
          }
        }
        int m = mHorizontalGuidelines.size();
        int n = 0;
        if (n < m)
        {
          Guideline localGuideline1 = (Guideline)mHorizontalGuidelines.get(n);
          if (getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {}
          for (boolean bool1 = true;; bool1 = false)
          {
            localGuideline1.setPositionRelaxed(bool1);
            localGuideline1.addToSolver(paramLinearSystem, paramInt);
            n++;
            break;
          }
        }
        for (int i1 = 0; i1 < i; i1++) {
          ((ConstraintWidget)mChildren.get(i1)).addToSolver(paramLinearSystem, paramInt);
        }
      }
    }
  }
  
  public void computeGuidelinesPercentPositions()
  {
    int i = mVerticalGuidelines.size();
    for (int j = 0; j < i; j++) {
      ((Guideline)mVerticalGuidelines.get(j)).inferRelativePercentPosition();
    }
    int k = mHorizontalGuidelines.size();
    for (int m = 0; m < k; m++) {
      ((Guideline)mHorizontalGuidelines.get(m)).inferRelativePercentPosition();
    }
  }
  
  public void cycleColumnAlignment(int paramInt)
  {
    VerticalSlice localVerticalSlice = (VerticalSlice)mVerticalSlices.get(paramInt);
    switch (alignment)
    {
    }
    for (;;)
    {
      setChildrenConnections();
      return;
      alignment = 0;
      continue;
      alignment = 1;
      continue;
      alignment = 2;
    }
  }
  
  public String getColumnAlignmentRepresentation(int paramInt)
  {
    VerticalSlice localVerticalSlice = (VerticalSlice)mVerticalSlices.get(paramInt);
    if (alignment == 1) {
      return "L";
    }
    if (alignment == 0) {
      return "C";
    }
    if (alignment == 3) {
      return "F";
    }
    if (alignment == 2) {
      return "R";
    }
    return "!";
  }
  
  public String getColumnsAlignmentRepresentation()
  {
    int i = mVerticalSlices.size();
    String str = "";
    int j = 0;
    if (j < i)
    {
      VerticalSlice localVerticalSlice = (VerticalSlice)mVerticalSlices.get(j);
      if (alignment == 1) {
        str = str + "L";
      }
      for (;;)
      {
        j++;
        break;
        if (alignment == 0) {
          str = str + "C";
        } else if (alignment == 3) {
          str = str + "F";
        } else if (alignment == 2) {
          str = str + "R";
        }
      }
    }
    return str;
  }
  
  public ArrayList<Guideline> getHorizontalGuidelines()
  {
    return mHorizontalGuidelines;
  }
  
  public int getNumCols()
  {
    return mNumCols;
  }
  
  public int getNumRows()
  {
    return mNumRows;
  }
  
  public int getPadding()
  {
    return mPadding;
  }
  
  public String getType()
  {
    return "ConstraintTableLayout";
  }
  
  public ArrayList<Guideline> getVerticalGuidelines()
  {
    return mVerticalGuidelines;
  }
  
  public boolean handlesInternalConstraints()
  {
    return true;
  }
  
  public boolean isVerticalGrowth()
  {
    return mVerticalGrowth;
  }
  
  public void setColumnAlignment(int paramInt1, int paramInt2)
  {
    if (paramInt1 < mVerticalSlices.size())
    {
      mVerticalSlices.get(paramInt1)).alignment = paramInt2;
      setChildrenConnections();
    }
  }
  
  public void setColumnAlignment(String paramString)
  {
    int i = 0;
    int j = paramString.length();
    if (i < j)
    {
      int k = paramString.charAt(i);
      if (k == 76) {
        setColumnAlignment(i, 1);
      }
      for (;;)
      {
        i++;
        break;
        if (k == 67) {
          setColumnAlignment(i, 0);
        } else if (k == 70) {
          setColumnAlignment(i, 3);
        } else if (k == 82) {
          setColumnAlignment(i, 2);
        } else {
          setColumnAlignment(i, 0);
        }
      }
    }
  }
  
  public void setDebugSolverName(LinearSystem paramLinearSystem, String paramString)
  {
    system = paramLinearSystem;
    super.setDebugSolverName(paramLinearSystem, paramString);
    updateDebugSolverNames();
  }
  
  public void setNumCols(int paramInt)
  {
    if ((mVerticalGrowth) && (mNumCols != paramInt))
    {
      mNumCols = paramInt;
      setVerticalSlices();
      setTableDimensions();
    }
  }
  
  public void setNumRows(int paramInt)
  {
    if ((!mVerticalGrowth) && (mNumCols != paramInt))
    {
      mNumRows = paramInt;
      setHorizontalSlices();
      setTableDimensions();
    }
  }
  
  public void setPadding(int paramInt)
  {
    if (paramInt > 1) {
      mPadding = paramInt;
    }
  }
  
  public void setTableDimensions()
  {
    int i = 0;
    int j = mChildren.size();
    for (int k = 0; k < j; k++) {
      i += ((ConstraintWidget)mChildren.get(k)).getContainerItemSkip();
    }
    int m = j + i;
    if (mVerticalGrowth)
    {
      if (mNumCols == 0) {
        setNumCols(1);
      }
      int i1 = m / mNumCols;
      if (i1 * mNumCols < m) {
        i1++;
      }
      if ((mNumRows == i1) && (mVerticalGuidelines.size() == -1 + mNumCols)) {
        return;
      }
      mNumRows = i1;
      setHorizontalSlices();
    }
    for (;;)
    {
      setChildrenConnections();
      return;
      if (mNumRows == 0) {
        setNumRows(1);
      }
      int n = m / mNumRows;
      if (n * mNumRows < m) {
        n++;
      }
      if ((mNumCols == n) && (mHorizontalGuidelines.size() == -1 + mNumRows)) {
        break;
      }
      mNumCols = n;
      setVerticalSlices();
    }
  }
  
  public void setVerticalGrowth(boolean paramBoolean)
  {
    mVerticalGrowth = paramBoolean;
  }
  
  public void updateFromSolver(LinearSystem paramLinearSystem, int paramInt)
  {
    super.updateFromSolver(paramLinearSystem, paramInt);
    if (paramLinearSystem == mSystem)
    {
      int i = mVerticalGuidelines.size();
      for (int j = 0; j < i; j++) {
        ((Guideline)mVerticalGuidelines.get(j)).updateFromSolver(paramLinearSystem, paramInt);
      }
      int k = mHorizontalGuidelines.size();
      for (int m = 0; m < k; m++) {
        ((Guideline)mHorizontalGuidelines.get(m)).updateFromSolver(paramLinearSystem, paramInt);
      }
    }
  }
  
  class HorizontalSlice
  {
    ConstraintWidget bottom;
    int padding;
    ConstraintWidget top;
    
    HorizontalSlice() {}
  }
  
  class VerticalSlice
  {
    int alignment = 1;
    ConstraintWidget left;
    int padding;
    ConstraintWidget right;
    
    VerticalSlice() {}
  }
}
