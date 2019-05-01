package android.support.constraint.solver;

import java.io.PrintStream;

public class LinkedVariables
{
  private static final boolean DEBUG;
  public static int sCreation = 0;
  private SolverVariable candidate = null;
  int currentSize = 0;
  float epsilon = 0.001F;
  private Link head = null;
  private final Cache mCache;
  private final ArrayRow mRow;
  
  public LinkedVariables(ArrayRow paramArrayRow, Cache paramCache)
  {
    mRow = paramArrayRow;
    mCache = paramCache;
  }
  
  public final void add(SolverVariable paramSolverVariable, float paramFloat)
  {
    if (paramFloat == 0.0F)
    {
      remove(paramSolverVariable);
      return;
    }
    Link localLink1 = head;
    Link localLink2 = null;
    for (;;)
    {
      if (localLink1 == null) {
        break label141;
      }
      if (variable == paramSolverVariable)
      {
        value = (paramFloat + value);
        if (value != 0.0F) {
          break;
        }
        if (localLink1 == head) {
          head = next;
        }
        for (;;)
        {
          variable.removeClientEquation(mRow);
          mCache.linkedVariablesPool.release(localLink1);
          currentSize = (-1 + currentSize);
          return;
          next = next;
        }
      }
      if (variable.id < id) {
        localLink2 = localLink1;
      }
      localLink1 = next;
    }
    label141:
    Link localLink3 = (Link)mCache.linkedVariablesPool.acquire();
    if (localLink3 == null) {
      localLink3 = new Link();
    }
    value = paramFloat;
    variable = paramSolverVariable;
    next = null;
    if (localLink2 != null)
    {
      next = next;
      next = localLink3;
    }
    for (;;)
    {
      if (head == null) {
        head = localLink3;
      }
      currentSize = (1 + currentSize);
      return;
      next = head;
      head = localLink3;
    }
  }
  
  public final void clear()
  {
    Link localLink1 = head;
    while (localLink1 != null)
    {
      Link localLink2 = localLink1;
      localLink1 = next;
      mCache.linkedVariablesPool.release(localLink2);
    }
    head = null;
    currentSize = 0;
  }
  
  public final boolean containsKey(SolverVariable paramSolverVariable)
  {
    for (Link localLink = head; localLink != null; localLink = next) {
      if (variable == paramSolverVariable) {
        return true;
      }
    }
    return false;
  }
  
  public void display()
  {
    int i = size();
    System.out.print("{ ");
    int j = 0;
    if (j < i)
    {
      SolverVariable localSolverVariable = getVariable(j);
      if (localSolverVariable == null) {}
      for (;;)
      {
        j++;
        break;
        System.out.print(localSolverVariable + " = " + getVariableValue(j) + " ");
      }
    }
    System.out.println(" }");
  }
  
  public void divideByAmount(float paramFloat)
  {
    for (Link localLink = head; localLink != null; localLink = next) {
      value /= paramFloat;
    }
  }
  
  public final float get(SolverVariable paramSolverVariable)
  {
    for (Link localLink = head; localLink != null; localLink = next) {
      if (variable == paramSolverVariable) {
        return value;
      }
    }
    return 0.0F;
  }
  
  public SolverVariable getPivotCandidate()
  {
    if (candidate == null) {
      for (Link localLink = head; localLink != null; localLink = next) {
        if ((value < 0.0F) && ((candidate == null) || (variable.definitionId < candidate.definitionId))) {
          candidate = variable;
        }
      }
    }
    return candidate;
  }
  
  public final SolverVariable getVariable(int paramInt)
  {
    Link localLink = head;
    for (int i = 0; i != paramInt; i++) {
      localLink = next;
    }
    if (localLink != null) {
      return variable;
    }
    return null;
  }
  
  public final float getVariableValue(int paramInt)
  {
    Link localLink = head;
    for (int i = 0; i != paramInt; i++) {
      localLink = next;
    }
    if (localLink != null) {
      return value;
    }
    return 0.0F;
  }
  
  public boolean hasAtLeastOnePositiveVariable()
  {
    for (Link localLink = head; localLink != null; localLink = next) {
      if (value > 0.0F) {
        return true;
      }
    }
    return false;
  }
  
  public void invert()
  {
    for (Link localLink = head; localLink != null; localLink = next) {
      value = (-1.0F * value);
    }
  }
  
  public SolverVariable pickPivotCandidate()
  {
    Link localLink = head;
    SolverVariable localSolverVariable1 = null;
    SolverVariable localSolverVariable2 = null;
    if (localLink != null)
    {
      f = value;
      if (f < 0.0F)
      {
        if (f > -epsilon)
        {
          value = 0.0F;
          f = 0.0F;
        }
        if (f == 0.0F) {
          break label109;
        }
        if (variable.mType != SolverVariable.Type.UNRESTRICTED) {
          break label117;
        }
        if (f >= 0.0F) {
          break label100;
        }
        localSolverVariable2 = variable;
      }
    }
    label100:
    label109:
    label117:
    while (localSolverVariable2 != null)
    {
      float f;
      for (;;)
      {
        return localSolverVariable2;
        if (f < epsilon)
        {
          value = 0.0F;
          f = 0.0F;
        }
      }
      if (localSolverVariable2 == null) {
        localSolverVariable2 = variable;
      }
      for (;;)
      {
        localLink = next;
        break;
        if ((f < 0.0F) && (localSolverVariable1 == null)) {
          localSolverVariable1 = variable;
        }
      }
    }
    return localSolverVariable1;
  }
  
  public final void put(SolverVariable paramSolverVariable, float paramFloat)
  {
    if (paramFloat == 0.0F)
    {
      remove(paramSolverVariable);
      return;
    }
    Link localLink1 = head;
    Link localLink2 = null;
    while (localLink1 != null)
    {
      if (variable == paramSolverVariable)
      {
        value = paramFloat;
        return;
      }
      if (variable.id < id) {
        localLink2 = localLink1;
      }
      localLink1 = next;
    }
    Link localLink3 = (Link)mCache.linkedVariablesPool.acquire();
    if (localLink3 == null) {
      localLink3 = new Link();
    }
    value = paramFloat;
    variable = paramSolverVariable;
    next = null;
    if (localLink2 != null)
    {
      next = next;
      next = localLink3;
    }
    for (;;)
    {
      if (head == null) {
        head = localLink3;
      }
      currentSize = (1 + currentSize);
      return;
      next = head;
      head = localLink3;
    }
  }
  
  public final float remove(SolverVariable paramSolverVariable)
  {
    if (candidate == paramSolverVariable) {
      candidate = null;
    }
    Link localLink1 = head;
    Link localLink2 = null;
    while (localLink1 != null)
    {
      if (variable == paramSolverVariable)
      {
        float f = value;
        if (localLink1 == head) {
          head = next;
        }
        for (;;)
        {
          variable.removeClientEquation(mRow);
          mCache.linkedVariablesPool.release(localLink1);
          currentSize = (-1 + currentSize);
          return f;
          next = next;
        }
      }
      localLink2 = localLink1;
      localLink1 = next;
    }
    return 0.0F;
  }
  
  public final void setVariable(int paramInt, float paramFloat)
  {
    Link localLink = head;
    for (int i = 0; i != paramInt; i++) {
      localLink = next;
    }
    value = paramFloat;
  }
  
  public final int size()
  {
    return currentSize;
  }
  
  public int sizeInBytes()
  {
    return 0 + 16;
  }
  
  public String toString()
  {
    String str = "";
    for (Link localLink = head; localLink != null; localLink = next) {
      str = str + " -> (" + localLink + ")";
    }
    return str;
  }
  
  public final void updateArray(LinkedVariables paramLinkedVariables, float paramFloat)
  {
    if (paramFloat == 0.0F) {}
    for (;;)
    {
      return;
      for (Link localLink = head; localLink != null; localLink = next) {
        paramLinkedVariables.put(variable, paramLinkedVariables.get(variable) + paramFloat * value);
      }
    }
  }
  
  public void updateClientEquations(ArrayRow paramArrayRow)
  {
    for (Link localLink = head; localLink != null; localLink = next) {
      variable.addClientEquation(paramArrayRow);
    }
  }
  
  public void updateFromRow(ArrayRow paramArrayRow1, ArrayRow paramArrayRow2)
  {
    Link localLink1 = head;
    Link localLink2 = null;
    Link localLink3 = (Link)mCache.linkedVariablesPool.acquire();
    if (localLink3 == null) {
      localLink3 = new Link();
    }
    next = null;
    Object localObject = localLink3;
    if (localLink1 != null)
    {
      if (variable == variable)
      {
        float f = value;
        if (!isSimpleDefinition) {
          for (Link localLink6 = variables).head; localLink6 != null; localLink6 = next)
          {
            Link localLink7 = (Link)mCache.linkedVariablesPool.acquire();
            if (localLink7 == null) {
              localLink7 = new Link();
            }
            variable = variable;
            value = (f * value);
            next = null;
            next = localLink7;
            localObject = localLink7;
          }
        }
        constantValue += f * constantValue;
        variable.removeClientEquation(paramArrayRow1);
        if (localLink2 == null)
        {
          head = next;
          label212:
          mCache.linkedVariablesPool.release(localLink1);
          currentSize = (-1 + currentSize);
        }
      }
      for (;;)
      {
        localLink1 = next;
        break;
        next = next;
        break label212;
        localLink2 = localLink1;
      }
    }
    Link localLink4 = next;
    while (localLink4 != null)
    {
      add(variable, value);
      Link localLink5 = localLink4;
      localLink4 = next;
      mCache.linkedVariablesPool.release(localLink5);
    }
    mCache.linkedVariablesPool.release(localLink3);
  }
  
  public void updateFromSystem(ArrayRow paramArrayRow, ArrayRow[] paramArrayOfArrayRow)
  {
    Link localLink1 = head;
    Link localLink2 = null;
    Link localLink3 = (Link)mCache.linkedVariablesPool.acquire();
    if (localLink3 == null) {
      localLink3 = new Link();
    }
    next = null;
    Object localObject = localLink3;
    if (localLink1 != null)
    {
      int i = variable.definitionId;
      if (i != -1)
      {
        float f = value;
        ArrayRow localArrayRow = paramArrayOfArrayRow[i];
        if (!isSimpleDefinition) {
          for (Link localLink6 = variables).head; localLink6 != null; localLink6 = next)
          {
            Link localLink7 = (Link)mCache.linkedVariablesPool.acquire();
            if (localLink7 == null) {
              localLink7 = new Link();
            }
            variable = variable;
            value = (f * value);
            next = null;
            next = localLink7;
            localObject = localLink7;
          }
        }
        constantValue += f * constantValue;
        variable.removeClientEquation(paramArrayRow);
        if (localLink2 == null)
        {
          head = next;
          label226:
          mCache.linkedVariablesPool.release(localLink1);
          currentSize = (-1 + currentSize);
        }
      }
      for (;;)
      {
        localLink1 = next;
        break;
        next = next;
        break label226;
        localLink2 = localLink1;
      }
    }
    Link localLink4 = next;
    while (localLink4 != null)
    {
      add(variable, value);
      Link localLink5 = localLink4;
      localLink4 = next;
      mCache.linkedVariablesPool.release(localLink5);
    }
    mCache.linkedVariablesPool.release(localLink3);
  }
  
  static class Link
  {
    Link next;
    float value;
    SolverVariable variable;
    
    public Link()
    {
      LinkedVariables.sCreation = 1 + LinkedVariables.sCreation;
    }
    
    public String toString()
    {
      return "" + value + " " + variable;
    }
  }
}
