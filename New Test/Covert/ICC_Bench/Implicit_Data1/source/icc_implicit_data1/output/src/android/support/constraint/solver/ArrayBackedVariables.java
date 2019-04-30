package android.support.constraint.solver;

import java.io.PrintStream;
import java.util.Arrays;

class ArrayBackedVariables
{
  private static final boolean DEBUG;
  private SolverVariable candidate = null;
  private int currentSize = 0;
  private int currentWriteSize = 0;
  private int[] indexes = null;
  private int maxSize = 4;
  private final int threshold = 16;
  private float[] values = null;
  private SolverVariable[] variables = null;
  
  public ArrayBackedVariables(ArrayRow paramArrayRow, Cache paramCache) {}
  
  private String getInternalArrays()
  {
    int i = size();
    String str1 = "" + "idx { ";
    for (int j = 0; j < i; j++) {
      str1 = str1 + indexes[j] + " ";
    }
    String str2 = str1 + "}\n";
    String str3 = str2 + "obj { ";
    for (int k = 0; k < i; k++) {
      str3 = str3 + variables[k] + ":" + values[k] + " ";
    }
    return str3 + "}\n";
  }
  
  public void add(SolverVariable paramSolverVariable, float paramFloat)
  {
    if (paramFloat == 0.0F) {
      return;
    }
    int i;
    label108:
    do
    {
      increaseSize();
      i = -1;
      for (int j = 0;; j++)
      {
        if (j >= currentWriteSize) {
          break label108;
        }
        if (variables[j] == paramSolverVariable)
        {
          float[] arrayOfFloat = values;
          arrayOfFloat[j] = (paramFloat + arrayOfFloat[j]);
          if (paramFloat < 0.0F) {
            candidate = paramSolverVariable;
          }
          if (values[j] != 0.0F) {
            break;
          }
          remove(paramSolverVariable);
          return;
        }
        if ((i == -1) && (variables[j] == null)) {
          i = j;
        }
      }
      if ((i == -1) && (currentWriteSize < maxSize)) {
        i = currentWriteSize;
      }
    } while (i == -1);
    variables[i] = paramSolverVariable;
    values[i] = paramFloat;
    for (int k = 0;; k++)
    {
      int m = currentSize;
      int n = 0;
      if (k < m)
      {
        int i1 = indexes[k];
        if (variables[i1].id > id)
        {
          System.arraycopy(indexes, k, indexes, k + 1, currentSize - k);
          indexes[k] = i;
          n = 1;
        }
      }
      else
      {
        if (n == 0) {
          indexes[currentSize] = i;
        }
        currentSize = (1 + currentSize);
        if (i + 1 > currentWriteSize) {
          currentWriteSize = (i + 1);
        }
        if (paramFloat >= 0.0F) {
          break;
        }
        candidate = paramSolverVariable;
        return;
      }
    }
  }
  
  public void clear()
  {
    int i = 0;
    int j = variables.length;
    while (i < j)
    {
      variables[i] = null;
      i++;
    }
    currentSize = 0;
    currentWriteSize = 0;
  }
  
  public boolean containsKey(SolverVariable paramSolverVariable)
  {
    if (currentSize < 8) {
      for (int m = 0; m < currentSize; m++) {
        if (variables[indexes[m]] == paramSolverVariable) {
          return true;
        }
      }
    }
    int i = 0;
    int j = -1 + currentSize;
    for (;;)
    {
      if (i > j) {
        break label116;
      }
      int k = i + (j - i) / 2;
      SolverVariable localSolverVariable = variables[indexes[k]];
      if (localSolverVariable == paramSolverVariable) {
        break;
      }
      if (id < id) {
        i = k + 1;
      } else {
        j = k - 1;
      }
    }
    label116:
    return false;
  }
  
  public void display()
  {
    int i = size();
    System.out.print("{ ");
    for (int j = 0; j < i; j++) {
      System.out.print(getVariable(j) + " = " + getVariableValue(j) + " ");
    }
    System.out.println(" }");
  }
  
  public void displayInternalArrays()
  {
    int i = size();
    System.out.print("idx { ");
    for (int j = 0; j < i; j++) {
      System.out.print(indexes[j] + " ");
    }
    System.out.println("}");
    System.out.print("obj { ");
    for (int k = 0; k < i; k++) {
      System.out.print(variables[k] + ":" + values[k] + " ");
    }
    System.out.println("}");
  }
  
  public void divideByAmount(float paramFloat) {}
  
  public final float get(SolverVariable paramSolverVariable)
  {
    if (currentSize < 16) {
      for (int n = 0; n < currentSize; n++)
      {
        int i1 = indexes[n];
        if (variables[i1] == paramSolverVariable) {
          return values[i1];
        }
      }
    }
    int i = 0;
    int j = -1 + currentSize;
    while (i <= j)
    {
      int k = i + (j - i) / 2;
      int m = indexes[k];
      SolverVariable localSolverVariable = variables[m];
      if (localSolverVariable == paramSolverVariable) {
        return values[m];
      }
      if (id < id) {
        i = k + 1;
      } else {
        j = k - 1;
      }
    }
    return 0.0F;
  }
  
  public SolverVariable getPivotCandidate()
  {
    if (candidate == null) {}
    for (int i = 0;; i++) {
      if (i < currentSize)
      {
        int j = indexes[i];
        if (values[j] < 0.0F) {
          candidate = variables[j];
        }
      }
      else
      {
        return candidate;
      }
    }
  }
  
  public final SolverVariable getVariable(int paramInt)
  {
    return variables[indexes[paramInt]];
  }
  
  public final float getVariableValue(int paramInt)
  {
    return values[indexes[paramInt]];
  }
  
  public boolean hasAtLeastOnePositiveVariable()
  {
    return false;
  }
  
  void increaseSize()
  {
    maxSize = (2 * maxSize);
    variables = ((SolverVariable[])Arrays.copyOf(variables, maxSize));
    values = Arrays.copyOf(values, maxSize);
    indexes = Arrays.copyOf(indexes, maxSize);
  }
  
  public void invert() {}
  
  public SolverVariable pickPivotCandidate()
  {
    return null;
  }
  
  public void put(SolverVariable paramSolverVariable, float paramFloat)
  {
    if (paramFloat == 0.0F)
    {
      remove(paramSolverVariable);
      return;
    }
    int i;
    label86:
    do
    {
      increaseSize();
      i = -1;
      for (int j = 0;; j++)
      {
        if (j >= currentWriteSize) {
          break label86;
        }
        if (variables[j] == paramSolverVariable)
        {
          values[j] = paramFloat;
          if (paramFloat >= 0.0F) {
            break;
          }
          candidate = paramSolverVariable;
          return;
        }
        if ((i == -1) && (variables[j] == null)) {
          i = j;
        }
      }
      if ((i == -1) && (currentWriteSize < maxSize)) {
        i = currentWriteSize;
      }
    } while (i == -1);
    variables[i] = paramSolverVariable;
    values[i] = paramFloat;
    for (int k = 0;; k++)
    {
      int m = currentSize;
      int n = 0;
      if (k < m)
      {
        int i1 = indexes[k];
        if (variables[i1].id > id)
        {
          System.arraycopy(indexes, k, indexes, k + 1, currentSize - k);
          indexes[k] = i;
          n = 1;
        }
      }
      else
      {
        if (n == 0) {
          indexes[currentSize] = i;
        }
        currentSize = (1 + currentSize);
        if (i + 1 > currentWriteSize) {
          currentWriteSize = (i + 1);
        }
        if (paramFloat >= 0.0F) {
          break;
        }
        candidate = paramSolverVariable;
        return;
      }
    }
  }
  
  public float remove(SolverVariable paramSolverVariable)
  {
    if (candidate == paramSolverVariable) {
      candidate = null;
    }
    for (int i = 0; i < currentWriteSize; i++)
    {
      int j = indexes[i];
      if (variables[j] == paramSolverVariable)
      {
        float f = values[j];
        variables[j] = null;
        System.arraycopy(indexes, i + 1, indexes, i, -1 + (currentWriteSize - i));
        currentSize = (-1 + currentSize);
        return f;
      }
    }
    return 0.0F;
  }
  
  public void setVariable(int paramInt, float paramFloat)
  {
    int i = indexes[paramInt];
    values[i] = paramFloat;
    if (paramFloat < 0.0F) {
      candidate = variables[i];
    }
  }
  
  public final int size()
  {
    return currentSize;
  }
  
  public int sizeInBytes()
  {
    return 16 + (0 + 4 * maxSize + 4 * maxSize + 4 * maxSize);
  }
  
  public final void updateArray(ArrayBackedVariables paramArrayBackedVariables, float paramFloat)
  {
    if (paramFloat == 0.0F) {}
    for (;;)
    {
      return;
      for (int i = 0; i < currentSize; i++)
      {
        int j = indexes[i];
        paramArrayBackedVariables.add(variables[j], paramFloat * values[j]);
      }
    }
  }
  
  public void updateClientEquations(ArrayRow paramArrayRow) {}
  
  public void updateFromRow(ArrayRow paramArrayRow1, ArrayRow paramArrayRow2) {}
  
  public void updateFromSystem(ArrayRow paramArrayRow, ArrayRow[] paramArrayOfArrayRow) {}
}
