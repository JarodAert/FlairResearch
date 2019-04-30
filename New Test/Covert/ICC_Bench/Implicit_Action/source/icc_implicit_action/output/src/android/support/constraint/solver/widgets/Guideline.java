package android.support.constraint.solver.widgets;

import android.support.constraint.solver.EquationCreation;
import android.support.constraint.solver.LinearSystem;
import java.util.ArrayList;

public class Guideline
  extends ConstraintWidget
{
  public static final int HORIZONTAL = 0;
  public static final int RELATIVE_BEGIN = 1;
  public static final int RELATIVE_END = 2;
  public static final int RELATIVE_PERCENT = 0;
  public static final int RELATIVE_UNKNWON = -1;
  public static final int VERTICAL = 1;
  private ConstraintAnchor mAnchor = mTop;
  private Rectangle mHead = new Rectangle();
  private int mHeadSize = 8;
  private boolean mIsPositionRelaxed = false;
  private int mMinimumPosition = 0;
  private int mOrientation = 0;
  protected int mRelativeBegin = -1;
  protected int mRelativeEnd = -1;
  protected float mRelativePercent = -1.0F;
  
  public Guideline()
  {
    mAnchors.clear();
    mAnchors.add(mAnchor);
  }
  
  public void addToSolver(LinearSystem paramLinearSystem, int paramInt)
  {
    ConstraintWidgetContainer localConstraintWidgetContainer = (ConstraintWidgetContainer)getParent();
    if (localConstraintWidgetContainer == null) {}
    do
    {
      ConstraintAnchor localConstraintAnchor1;
      ConstraintAnchor localConstraintAnchor2;
      do
      {
        return;
        localConstraintAnchor1 = localConstraintWidgetContainer.getAnchor(ConstraintAnchor.Type.LEFT);
        localConstraintAnchor2 = localConstraintWidgetContainer.getAnchor(ConstraintAnchor.Type.RIGHT);
        if (mOrientation == 0)
        {
          localConstraintAnchor1 = localConstraintWidgetContainer.getAnchor(ConstraintAnchor.Type.TOP);
          localConstraintAnchor2 = localConstraintWidgetContainer.getAnchor(ConstraintAnchor.Type.BOTTOM);
        }
        if (mRelativeBegin != -1)
        {
          paramLinearSystem.addConstraint(EquationCreation.createRowEquals(paramLinearSystem, paramLinearSystem.createObjectVariable(mAnchor), paramLinearSystem.createObjectVariable(localConstraintAnchor1), mRelativeBegin, false));
          return;
        }
        if (mRelativeEnd != -1)
        {
          paramLinearSystem.addConstraint(EquationCreation.createRowEquals(paramLinearSystem, paramLinearSystem.createObjectVariable(mAnchor), paramLinearSystem.createObjectVariable(localConstraintAnchor2), -mRelativeEnd, false));
          return;
        }
      } while (mRelativePercent == -1.0F);
      paramLinearSystem.addConstraint(EquationCreation.createRowDimensionPercent(paramLinearSystem, paramLinearSystem.createObjectVariable(mAnchor), paramLinearSystem.createObjectVariable(localConstraintAnchor1), paramLinearSystem.createObjectVariable(localConstraintAnchor2), mRelativePercent, mIsPositionRelaxed));
    } while (mMinimumPosition <= 0);
  }
  
  public void cyclePosition()
  {
    if (mRelativeBegin != -1) {
      inferRelativePercentPosition();
    }
    do
    {
      return;
      if (mRelativePercent != -1.0F)
      {
        inferRelativeEndPosition();
        return;
      }
    } while (mRelativeEnd == -1);
    inferRelativeBeginPosition();
  }
  
  public ConstraintAnchor getAnchor()
  {
    return mAnchor;
  }
  
  public ConstraintAnchor getAnchor(ConstraintAnchor.Type paramType)
  {
    switch (1.$SwitchMap$android$support$constraint$solver$widgets$ConstraintAnchor$Type[paramType.ordinal()])
    {
    }
    do
    {
      do
      {
        return null;
      } while (mOrientation != 1);
      return mAnchor;
    } while (mOrientation != 0);
    return mAnchor;
  }
  
  public ArrayList<ConstraintAnchor> getAnchors()
  {
    return mAnchors;
  }
  
  public Rectangle getHead()
  {
    mHead.setBounds(getDrawX() - mHeadSize, getDrawY() - 2 * mHeadSize, 2 * mHeadSize, 2 * mHeadSize);
    if (getOrientation() == 0) {
      mHead.setBounds(getDrawX() - 2 * mHeadSize, getDrawY() - mHeadSize, 2 * mHeadSize, 2 * mHeadSize);
    }
    return mHead;
  }
  
  public int getOrientation()
  {
    return mOrientation;
  }
  
  public int getRelativeBegin()
  {
    return mRelativeBegin;
  }
  
  public int getRelativeBehaviour()
  {
    int i = -1;
    if (mRelativePercent != -1.0F) {
      i = 0;
    }
    do
    {
      return i;
      if (mRelativeBegin != i) {
        return 1;
      }
    } while (mRelativeEnd == i);
    return 2;
  }
  
  public int getRelativeEnd()
  {
    return mRelativeEnd;
  }
  
  public float getRelativePercent()
  {
    return mRelativePercent;
  }
  
  public String getType()
  {
    return "Guideline";
  }
  
  void inferRelativeBeginPosition()
  {
    int i = getX();
    if (mOrientation == 0) {
      i = getY();
    }
    setGuideBegin(i);
  }
  
  void inferRelativeEndPosition()
  {
    int i = getParent().getWidth() - getX();
    if (mOrientation == 0) {
      i = getParent().getHeight() - getY();
    }
    setGuideEnd(i);
  }
  
  void inferRelativePercentPosition()
  {
    float f = getX() / getParent().getWidth();
    if (mOrientation == 0) {
      f = getY() / getParent().getHeight();
    }
    setGuidePercent(f);
  }
  
  public void setDrawOrigin(int paramInt1, int paramInt2)
  {
    int j;
    if (mOrientation == 1)
    {
      j = paramInt1 - mOffsetX;
      if (mRelativeBegin != -1) {
        setGuideBegin(j);
      }
    }
    int i;
    do
    {
      do
      {
        return;
        if (mRelativeEnd != -1)
        {
          setGuideEnd(getParent().getWidth() - j);
          return;
        }
      } while (mRelativePercent == -1.0F);
      setGuidePercent(j / getParent().getWidth());
      return;
      i = paramInt2 - mOffsetY;
      if (mRelativeBegin != -1)
      {
        setGuideBegin(i);
        return;
      }
      if (mRelativeEnd != -1)
      {
        setGuideEnd(getParent().getHeight() - i);
        return;
      }
    } while (mRelativePercent == -1.0F);
    setGuidePercent(i / getParent().getHeight());
  }
  
  public void setGuideBegin(int paramInt)
  {
    if (paramInt > -1)
    {
      mRelativePercent = -1.0F;
      mRelativeBegin = paramInt;
      mRelativeEnd = -1;
    }
  }
  
  public void setGuideEnd(int paramInt)
  {
    if (paramInt > -1)
    {
      mRelativePercent = -1.0F;
      mRelativeBegin = -1;
      mRelativeEnd = paramInt;
    }
  }
  
  public void setGuidePercent(float paramFloat)
  {
    if (paramFloat > -1.0F)
    {
      mRelativePercent = paramFloat;
      mRelativeBegin = -1;
      mRelativeEnd = -1;
    }
  }
  
  public void setGuidePercent(int paramInt)
  {
    setGuidePercent(paramInt / 100.0F);
  }
  
  public void setMinimumPosition(int paramInt)
  {
    mMinimumPosition = paramInt;
  }
  
  public void setOrientation(int paramInt)
  {
    if (mOrientation == paramInt) {
      return;
    }
    mOrientation = paramInt;
    mAnchors.clear();
    if (mOrientation == 1) {}
    for (mAnchor = mLeft;; mAnchor = mTop)
    {
      mAnchors.add(mAnchor);
      return;
    }
  }
  
  public void setPositionRelaxed(boolean paramBoolean)
  {
    if (mIsPositionRelaxed == paramBoolean) {
      return;
    }
    mIsPositionRelaxed = paramBoolean;
  }
  
  public void updateFromSolver(LinearSystem paramLinearSystem, int paramInt)
  {
    if (getParent() == null) {
      return;
    }
    int i = paramLinearSystem.getObjectVariableValue(mAnchor);
    if (mOrientation == 1)
    {
      setX(i);
      setY(0);
      setHeight(getParent().getHeight());
      setWidth(0);
      return;
    }
    setX(0);
    setY(i);
    setWidth(getParent().getWidth());
    setHeight(0);
  }
}
