package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import java.util.ArrayList;

public class ConstraintHorizontalLayout
  extends ConstraintWidgetContainer
{
  private ConstraintWidget.ContentAlignment mAlignment = ConstraintWidget.ContentAlignment.MIDDLE;
  
  public ConstraintHorizontalLayout() {}
  
  public ConstraintHorizontalLayout(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public ConstraintHorizontalLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void addToSolver(LinearSystem paramLinearSystem, int paramInt)
  {
    if (mChildren.size() != 0)
    {
      Object localObject = this;
      int i = 0;
      int j = mChildren.size();
      if (i < j)
      {
        ConstraintWidget localConstraintWidget = (ConstraintWidget)mChildren.get(i);
        if (localObject != this)
        {
          localConstraintWidget.connect(ConstraintAnchor.Type.LEFT, (ConstraintWidget)localObject, ConstraintAnchor.Type.RIGHT);
          ((ConstraintWidget)localObject).connect(ConstraintAnchor.Type.RIGHT, localConstraintWidget, ConstraintAnchor.Type.LEFT);
        }
        for (;;)
        {
          localConstraintWidget.connect(ConstraintAnchor.Type.TOP, this, ConstraintAnchor.Type.TOP);
          localConstraintWidget.connect(ConstraintAnchor.Type.BOTTOM, this, ConstraintAnchor.Type.BOTTOM);
          localObject = localConstraintWidget;
          i++;
          break;
          ConstraintAnchor.Strength localStrength2 = ConstraintAnchor.Strength.STRONG;
          if (mAlignment == ConstraintWidget.ContentAlignment.END) {
            localStrength2 = ConstraintAnchor.Strength.WEAK;
          }
          localConstraintWidget.connect(ConstraintAnchor.Type.LEFT, (ConstraintWidget)localObject, ConstraintAnchor.Type.LEFT, 0, localStrength2);
        }
      }
      if (localObject != this)
      {
        ConstraintAnchor.Strength localStrength1 = ConstraintAnchor.Strength.STRONG;
        if (mAlignment == ConstraintWidget.ContentAlignment.BEGIN) {
          localStrength1 = ConstraintAnchor.Strength.WEAK;
        }
        ConstraintAnchor.Type localType1 = ConstraintAnchor.Type.RIGHT;
        ConstraintAnchor.Type localType2 = ConstraintAnchor.Type.RIGHT;
        ((ConstraintWidget)localObject).connect(localType1, this, localType2, 0, localStrength1);
      }
    }
    super.addToSolver(paramLinearSystem, paramInt);
  }
}
