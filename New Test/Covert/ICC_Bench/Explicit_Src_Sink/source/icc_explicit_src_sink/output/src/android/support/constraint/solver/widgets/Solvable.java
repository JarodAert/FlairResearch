package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;

public abstract interface Solvable
{
  public abstract void addToSolver(LinearSystem paramLinearSystem, int paramInt);
  
  public abstract void setDebugSolverName(LinearSystem paramLinearSystem, String paramString);
  
  public abstract void updateFromSolver(LinearSystem paramLinearSystem, int paramInt);
}
