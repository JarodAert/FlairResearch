package android.support.constraint.solver;

public class ArrayRow
{
  private static final boolean DEBUG = false;
  static final boolean USE_LINKED_VARIABLES = true;
  float constantValue = 0.0F;
  final float epsilon = 0.001F;
  boolean isSimpleDefinition = false;
  boolean used = false;
  SolverVariable variable = null;
  float variableValue = 0.0F;
  final ArrayLinkedVariables variables;
  
  public ArrayRow(Cache paramCache)
  {
    variables = new ArrayLinkedVariables(this, paramCache);
  }
  
  public ArrayRow addError(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2)
  {
    variables.put(paramSolverVariable1, 1.0F);
    variables.put(paramSolverVariable2, -1.0F);
    return this;
  }
  
  public ArrayRow addSingleError(SolverVariable paramSolverVariable, int paramInt)
  {
    variables.put(paramSolverVariable, paramInt);
    return this;
  }
  
  public ArrayRow createRowCentering(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt1, float paramFloat, SolverVariable paramSolverVariable3, SolverVariable paramSolverVariable4, int paramInt2, boolean paramBoolean)
  {
    if (paramSolverVariable2 == paramSolverVariable3)
    {
      variables.put(paramSolverVariable1, 1.0F);
      variables.put(paramSolverVariable4, 1.0F);
      variables.put(paramSolverVariable2, -2.0F);
    }
    do
    {
      do
      {
        return this;
        if (paramFloat != 0.5F) {
          break;
        }
        variables.put(paramSolverVariable1, 1.0F);
        variables.put(paramSolverVariable2, -1.0F);
        variables.put(paramSolverVariable3, -1.0F);
        variables.put(paramSolverVariable4, 1.0F);
      } while ((paramInt1 <= 0) && (paramInt2 <= 0));
      constantValue = (paramInt2 + -paramInt1);
      return this;
      variables.put(paramSolverVariable1, 1.0F * (1.0F - paramFloat));
      variables.put(paramSolverVariable2, -1.0F * (1.0F - paramFloat));
      variables.put(paramSolverVariable3, -1.0F * paramFloat);
      variables.put(paramSolverVariable4, 1.0F * paramFloat);
    } while ((paramInt1 <= 0) && (paramInt2 <= 0));
    constantValue = (-paramInt1 * (1.0F - paramFloat) + paramFloat * paramInt2);
    return this;
  }
  
  public ArrayRow createRowDefinition(SolverVariable paramSolverVariable, int paramInt)
  {
    variable = paramSolverVariable;
    computedValue = paramInt;
    constantValue = paramInt;
    isSimpleDefinition = true;
    return this;
  }
  
  public ArrayRow createRowDimensionPercent(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, SolverVariable paramSolverVariable3, float paramFloat)
  {
    variables.put(paramSolverVariable1, -1.0F);
    variables.put(paramSolverVariable2, 1.0F - paramFloat);
    variables.put(paramSolverVariable3, paramFloat);
    return this;
  }
  
  public ArrayRow createRowDimensionRatio(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, SolverVariable paramSolverVariable3, SolverVariable paramSolverVariable4, float paramFloat)
  {
    variables.put(paramSolverVariable1, -1.0F);
    variables.put(paramSolverVariable2, 1.0F);
    variables.put(paramSolverVariable3, paramFloat);
    variables.put(paramSolverVariable4, -paramFloat);
    return this;
  }
  
  public ArrayRow createRowEqualDimension(float paramFloat1, float paramFloat2, float paramFloat3, SolverVariable paramSolverVariable1, int paramInt1, SolverVariable paramSolverVariable2, int paramInt2, SolverVariable paramSolverVariable3, int paramInt3, SolverVariable paramSolverVariable4, int paramInt4)
  {
    if ((paramFloat2 == 0.0F) || (paramFloat1 == paramFloat3))
    {
      constantValue = (paramInt4 + (paramInt3 + (-paramInt1 - paramInt2)));
      variables.put(paramSolverVariable1, 1.0F);
      variables.put(paramSolverVariable2, -1.0F);
      variables.put(paramSolverVariable4, 1.0F);
      variables.put(paramSolverVariable3, -1.0F);
      return this;
    }
    float f = paramFloat1 / paramFloat2 / (paramFloat3 / paramFloat2);
    constantValue = (-paramInt1 - paramInt2 + f * paramInt3 + f * paramInt4);
    variables.put(paramSolverVariable1, 1.0F);
    variables.put(paramSolverVariable2, -1.0F);
    variables.put(paramSolverVariable4, f);
    variables.put(paramSolverVariable3, -f);
    return this;
  }
  
  public ArrayRow createRowEquals(SolverVariable paramSolverVariable, int paramInt)
  {
    if (paramInt < 0)
    {
      constantValue = (paramInt * -1);
      variables.put(paramSolverVariable, 1.0F);
      return this;
    }
    constantValue = paramInt;
    variables.put(paramSolverVariable, -1.0F);
    return this;
  }
  
  public ArrayRow createRowEquals(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt)
  {
    int i = 0;
    if (paramInt != 0)
    {
      int j = paramInt;
      i = 0;
      if (j < 0)
      {
        j *= -1;
        i = 1;
      }
      constantValue = j;
    }
    if (i == 0)
    {
      variables.put(paramSolverVariable1, -1.0F);
      variables.put(paramSolverVariable2, 1.0F);
      return this;
    }
    variables.put(paramSolverVariable1, 1.0F);
    variables.put(paramSolverVariable2, -1.0F);
    return this;
  }
  
  public ArrayRow createRowGreaterThan(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, SolverVariable paramSolverVariable3, int paramInt)
  {
    int i = 0;
    if (paramInt != 0)
    {
      int j = paramInt;
      i = 0;
      if (j < 0)
      {
        j *= -1;
        i = 1;
      }
      constantValue = j;
    }
    if (i == 0)
    {
      variables.put(paramSolverVariable1, -1.0F);
      variables.put(paramSolverVariable2, 1.0F);
      variables.put(paramSolverVariable3, 1.0F);
      return this;
    }
    variables.put(paramSolverVariable1, 1.0F);
    variables.put(paramSolverVariable2, -1.0F);
    variables.put(paramSolverVariable3, -1.0F);
    return this;
  }
  
  public ArrayRow createRowLowerThan(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, SolverVariable paramSolverVariable3, int paramInt)
  {
    int i = 0;
    if (paramInt != 0)
    {
      int j = paramInt;
      i = 0;
      if (j < 0)
      {
        j *= -1;
        i = 1;
      }
      constantValue = j;
    }
    if (i == 0)
    {
      variables.put(paramSolverVariable1, -1.0F);
      variables.put(paramSolverVariable2, 1.0F);
      variables.put(paramSolverVariable3, -1.0F);
      return this;
    }
    variables.put(paramSolverVariable1, 1.0F);
    variables.put(paramSolverVariable2, -1.0F);
    variables.put(paramSolverVariable3, 1.0F);
    return this;
  }
  
  public void ensurePositiveConstant()
  {
    if (constantValue < 0.0F)
    {
      constantValue = (-1.0F * constantValue);
      variables.invert();
    }
  }
  
  public boolean hasAtLeastOnePositiveVariable()
  {
    return variables.hasAtLeastOnePositiveVariable();
  }
  
  public boolean hasKeyVariable()
  {
    return (variable != null) && ((variable.mType == SolverVariable.Type.UNRESTRICTED) || (constantValue >= 0.0F));
  }
  
  public boolean hasVariable(SolverVariable paramSolverVariable)
  {
    return variables.containsKey(paramSolverVariable);
  }
  
  public void pickRowVariable()
  {
    SolverVariable localSolverVariable = variables.pickPivotCandidate();
    if (localSolverVariable != null) {
      pivot(localSolverVariable);
    }
    if (variables.currentSize == 0) {
      isSimpleDefinition = true;
    }
  }
  
  public void pivot(SolverVariable paramSolverVariable)
  {
    if (variable != null)
    {
      variables.put(variable, -1.0F);
      variable = null;
    }
    float f = -1.0F * variables.remove(paramSolverVariable);
    variable = paramSolverVariable;
    variableValue = 1.0F;
    if (f == 1.0F) {
      return;
    }
    constantValue /= f;
    variables.divideByAmount(f);
  }
  
  public void reset()
  {
    variable = null;
    variables.clear();
    variableValue = 0.0F;
    constantValue = 0.0F;
    isSimpleDefinition = false;
  }
  
  public int sizeInBytes()
  {
    SolverVariable localSolverVariable = variable;
    int i = 0;
    if (localSolverVariable != null) {
      i = 0 + 4;
    }
    return 4 + (4 + (i + 4)) + variables.sizeInBytes();
  }
  
  public String toReadableString()
  {
    if (variable == null) {}
    int i;
    int k;
    SolverVariable localSolverVariable;
    for (String str1 = "" + "0";; str1 = "" + variable)
    {
      str2 = str1 + " = ";
      boolean bool = constantValue < 0.0F;
      i = 0;
      if (bool)
      {
        str2 = str2 + constantValue;
        i = 1;
      }
      int j = variables.currentSize;
      for (k = 0;; k++)
      {
        if (k >= j) {
          break label337;
        }
        localSolverVariable = variables.getVariable(k);
        if (localSolverVariable != null) {
          break;
        }
      }
    }
    float f = variables.getVariableValue(k);
    String str3 = localSolverVariable.toString();
    if (i == 0)
    {
      if (f < 0.0F)
      {
        str2 = str2 + "- ";
        f *= -1.0F;
      }
      label211:
      if (f != 1.0F) {
        break label304;
      }
    }
    label304:
    for (String str2 = str2 + str3;; str2 = str2 + f + " " + str3)
    {
      i = 1;
      break;
      if (f > 0.0F)
      {
        str2 = str2 + " + ";
        break label211;
      }
      str2 = str2 + " - ";
      f *= -1.0F;
      break label211;
    }
    label337:
    if (i == 0) {
      str2 = str2 + "0.0";
    }
    return str2;
  }
  
  public String toString()
  {
    return toReadableString();
  }
  
  public void updateClientEquations()
  {
    variables.updateClientEquations(this);
  }
  
  public boolean updateRowWithEquation(ArrayRow paramArrayRow)
  {
    variables.updateFromRow(this, paramArrayRow);
    return true;
  }
}
