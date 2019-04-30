package android.support.constraint.solver;

import java.io.PrintStream;
import java.util.Arrays;

public class ArrayLinkedVariables
{
  private static final boolean DEBUG = false;
  private static final int NONE = -1;
  private int ROW_SIZE = 8;
  private SolverVariable candidate = null;
  int currentSize = 0;
  private float epsilon = 0.001F;
  private int[] mArrayIndices = new int[ROW_SIZE];
  private int[] mArrayNextIndices = new int[ROW_SIZE];
  private float[] mArrayValues = new float[ROW_SIZE];
  private final Cache mCache;
  private boolean mDidFillOnce = false;
  private int mHead = -1;
  private int mLast = -1;
  private final ArrayRow mRow;
  
  public ArrayLinkedVariables(ArrayRow paramArrayRow, Cache paramCache)
  {
    mRow = paramArrayRow;
    mCache = paramCache;
  }
  
  public final void add(SolverVariable paramSolverVariable, float paramFloat)
  {
    if (paramFloat == 0.0F) {}
    do
    {
      return;
      if (mHead != -1) {
        break;
      }
      mHead = 0;
      mArrayValues[mHead] = paramFloat;
      mArrayIndices[mHead] = id;
      mArrayNextIndices[mHead] = -1;
      currentSize = (1 + currentSize);
    } while (mDidFillOnce);
    mLast = (1 + mLast);
    return;
    int i = mHead;
    int j = -1;
    for (int k = 0;; k++)
    {
      if ((i == -1) || (k >= currentSize)) {
        break label253;
      }
      int i1 = mArrayIndices[i];
      if (i1 == id)
      {
        float[] arrayOfFloat = mArrayValues;
        arrayOfFloat[i] = (paramFloat + arrayOfFloat[i]);
        if (mArrayValues[i] != 0.0F) {
          break;
        }
        if (i == mHead) {
          mHead = mArrayNextIndices[i];
        }
        for (;;)
        {
          mCache.mIndexedVariables[i1].removeClientEquation(mRow);
          if (mDidFillOnce) {
            mLast = i;
          }
          currentSize = (-1 + currentSize);
          return;
          mArrayNextIndices[j] = mArrayNextIndices[i];
        }
      }
      if (mArrayIndices[i] < id) {
        j = i;
      }
      i = mArrayNextIndices[i];
    }
    label253:
    int m = 1 + mLast;
    label287:
    int n;
    if (mDidFillOnce)
    {
      if (mArrayIndices[mLast] == -1) {
        m = mLast;
      }
    }
    else
    {
      if ((m >= mArrayIndices.length) && (currentSize < mArrayIndices.length))
      {
        n = 0;
        label312:
        if (n < mArrayIndices.length)
        {
          if (mArrayIndices[n] != -1) {
            break label536;
          }
          m = n;
        }
      }
      if (m >= mArrayIndices.length)
      {
        m = mArrayIndices.length;
        ROW_SIZE = (2 * ROW_SIZE);
        mDidFillOnce = false;
        mLast = (m - 1);
        mArrayValues = Arrays.copyOf(mArrayValues, ROW_SIZE);
        mArrayIndices = Arrays.copyOf(mArrayIndices, ROW_SIZE);
        mArrayNextIndices = Arrays.copyOf(mArrayNextIndices, ROW_SIZE);
      }
      mArrayIndices[m] = id;
      mArrayValues[m] = paramFloat;
      if (j == -1) {
        break label542;
      }
      mArrayNextIndices[m] = mArrayNextIndices[j];
      mArrayNextIndices[j] = m;
    }
    for (;;)
    {
      currentSize = (1 + currentSize);
      if (!mDidFillOnce) {
        mLast = (1 + mLast);
      }
      if (mLast < mArrayIndices.length) {
        break;
      }
      mDidFillOnce = true;
      mLast = (-1 + mArrayIndices.length);
      return;
      m = mArrayIndices.length;
      break label287;
      label536:
      n++;
      break label312;
      label542:
      mArrayNextIndices[m] = mHead;
      mHead = m;
    }
  }
  
  public final void clear()
  {
    mHead = -1;
    mLast = -1;
    mDidFillOnce = false;
    currentSize = 0;
  }
  
  public final boolean containsKey(SolverVariable paramSolverVariable)
  {
    if (mHead == -1) {}
    for (;;)
    {
      return false;
      int i = mHead;
      for (int j = 0; (i != -1) && (j < currentSize); j++)
      {
        if (mArrayIndices[i] == id) {
          return true;
        }
        i = mArrayNextIndices[i];
      }
    }
  }
  
  public void display()
  {
    int i = currentSize;
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
    int i = mHead;
    for (int j = 0; (i != -1) && (j < currentSize); j++)
    {
      float[] arrayOfFloat = mArrayValues;
      arrayOfFloat[i] /= paramFloat;
      i = mArrayNextIndices[i];
    }
  }
  
  public final float get(SolverVariable paramSolverVariable)
  {
    int i = mHead;
    for (int j = 0; (i != -1) && (j < currentSize); j++)
    {
      if (mArrayIndices[i] == id) {
        return mArrayValues[i];
      }
      i = mArrayNextIndices[i];
    }
    return 0.0F;
  }
  
  public SolverVariable getPivotCandidate()
  {
    if (candidate == null)
    {
      int i = mHead;
      int j = 0;
      localObject = null;
      while ((i != -1) && (j < currentSize))
      {
        if (mArrayValues[i] < 0.0F)
        {
          SolverVariable localSolverVariable = mCache.mIndexedVariables[mArrayIndices[i]];
          if ((localObject == null) || (strength > strength)) {
            localObject = localSolverVariable;
          }
        }
        i = mArrayNextIndices[i];
        j++;
      }
    }
    Object localObject = candidate;
    return localObject;
  }
  
  public final SolverVariable getVariable(int paramInt)
  {
    int i = mHead;
    for (int j = 0; (i != -1) && (j < currentSize); j++)
    {
      if (j == paramInt) {
        return mCache.mIndexedVariables[mArrayIndices[i]];
      }
      i = mArrayNextIndices[i];
    }
    return null;
  }
  
  public final float getVariableValue(int paramInt)
  {
    int i = mHead;
    for (int j = 0; (i != -1) && (j < currentSize); j++)
    {
      if (j == paramInt) {
        return mArrayValues[i];
      }
      i = mArrayNextIndices[i];
    }
    return 0.0F;
  }
  
  public boolean hasAtLeastOnePositiveVariable()
  {
    int i = mHead;
    for (int j = 0; (i != -1) && (j < currentSize); j++)
    {
      if (mArrayValues[i] > 0.0F) {
        return true;
      }
      i = mArrayNextIndices[i];
    }
    return false;
  }
  
  public void invert()
  {
    int i = mHead;
    for (int j = 0; (i != -1) && (j < currentSize); j++)
    {
      float[] arrayOfFloat = mArrayValues;
      arrayOfFloat[i] = (-1.0F * arrayOfFloat[i]);
      i = mArrayNextIndices[i];
    }
  }
  
  public SolverVariable pickPivotCandidate()
  {
    Object localObject1 = null;
    Object localObject2 = null;
    int i = mHead;
    int j = 0;
    if ((i != -1) && (j < currentSize))
    {
      float f = mArrayValues[i];
      if (f < 0.0F) {
        if (f > -epsilon)
        {
          mArrayValues[i] = 0.0F;
          f = 0.0F;
        }
      }
      SolverVariable localSolverVariable;
      while (f != 0.0F)
      {
        localSolverVariable = mCache.mIndexedVariables[mArrayIndices[i]];
        if (mType != SolverVariable.Type.UNRESTRICTED) {
          break label149;
        }
        if (f < 0.0F)
        {
          return localSolverVariable;
          if (f < epsilon)
          {
            mArrayValues[i] = 0.0F;
            f = 0.0F;
          }
        }
        else if (localObject2 == null)
        {
          localObject2 = localSolverVariable;
        }
      }
      for (;;)
      {
        i = mArrayNextIndices[i];
        j++;
        break;
        label149:
        if ((f < 0.0F) && ((localObject1 == null) || (strength < strength))) {
          localObject1 = localSolverVariable;
        }
      }
    }
    if (localObject2 != null) {
      return localObject2;
    }
    return localObject1;
  }
  
  public final void put(SolverVariable paramSolverVariable, float paramFloat)
  {
    if (paramFloat == 0.0F) {
      remove(paramSolverVariable);
    }
    do
    {
      return;
      if (mHead != -1) {
        break;
      }
      mHead = 0;
      mArrayValues[mHead] = paramFloat;
      mArrayIndices[mHead] = id;
      mArrayNextIndices[mHead] = -1;
      currentSize = (1 + currentSize);
    } while (mDidFillOnce);
    mLast = (1 + mLast);
    return;
    int i = mHead;
    int j = -1;
    for (int k = 0; (i != -1) && (k < currentSize); k++)
    {
      if (mArrayIndices[i] == id)
      {
        mArrayValues[i] = paramFloat;
        return;
      }
      if (mArrayIndices[i] < id) {
        j = i;
      }
      i = mArrayNextIndices[i];
    }
    int m = 1 + mLast;
    label196:
    int n;
    if (mDidFillOnce)
    {
      if (mArrayIndices[mLast] == -1) {
        m = mLast;
      }
    }
    else
    {
      if ((m >= mArrayIndices.length) && (currentSize < mArrayIndices.length))
      {
        n = 0;
        label221:
        if (n < mArrayIndices.length)
        {
          if (mArrayIndices[n] != -1) {
            break label434;
          }
          m = n;
        }
      }
      if (m >= mArrayIndices.length)
      {
        m = mArrayIndices.length;
        ROW_SIZE = (2 * ROW_SIZE);
        mDidFillOnce = false;
        mLast = (m - 1);
        mArrayValues = Arrays.copyOf(mArrayValues, ROW_SIZE);
        mArrayIndices = Arrays.copyOf(mArrayIndices, ROW_SIZE);
        mArrayNextIndices = Arrays.copyOf(mArrayNextIndices, ROW_SIZE);
      }
      mArrayIndices[m] = id;
      mArrayValues[m] = paramFloat;
      if (j == -1) {
        break label440;
      }
      mArrayNextIndices[m] = mArrayNextIndices[j];
      mArrayNextIndices[j] = m;
    }
    for (;;)
    {
      currentSize = (1 + currentSize);
      if (!mDidFillOnce) {
        mLast = (1 + mLast);
      }
      if (currentSize < mArrayIndices.length) {
        break;
      }
      mDidFillOnce = true;
      return;
      m = mArrayIndices.length;
      break label196;
      label434:
      n++;
      break label221;
      label440:
      mArrayNextIndices[m] = mHead;
      mHead = m;
    }
  }
  
  public final float remove(SolverVariable paramSolverVariable)
  {
    if (candidate == paramSolverVariable) {
      candidate = null;
    }
    if (mHead == -1) {}
    for (;;)
    {
      return 0.0F;
      int i = mHead;
      int j = -1;
      for (int k = 0; (i != -1) && (k < currentSize); k++)
      {
        int m = mArrayIndices[i];
        if (m == id)
        {
          if (i == mHead) {
            mHead = mArrayNextIndices[i];
          }
          for (;;)
          {
            mCache.mIndexedVariables[m].removeClientEquation(mRow);
            currentSize = (-1 + currentSize);
            mArrayIndices[i] = -1;
            if (mDidFillOnce) {
              mLast = i;
            }
            return mArrayValues[i];
            mArrayNextIndices[j] = mArrayNextIndices[i];
          }
        }
        j = i;
        i = mArrayNextIndices[i];
      }
    }
  }
  
  public final void setVariable(int paramInt, float paramFloat)
  {
    int i = mHead;
    for (int j = 0; (i != -1) && (j < currentSize); j++)
    {
      if (j == paramInt) {
        mArrayValues[i] = paramFloat;
      }
      i = mArrayNextIndices[i];
    }
  }
  
  public int sizeInBytes()
  {
    return 36 + (0 + 3 * (4 * mArrayIndices.length));
  }
  
  public String toString()
  {
    String str1 = "";
    int i = mHead;
    for (int j = 0; (i != -1) && (j < currentSize); j++)
    {
      String str2 = str1 + " -> ";
      String str3 = str2 + mArrayValues[i] + " : ";
      str1 = str3 + mCache.mIndexedVariables[mArrayIndices[i]];
      i = mArrayNextIndices[i];
    }
    return str1;
  }
  
  public final void updateArray(ArrayLinkedVariables paramArrayLinkedVariables, float paramFloat)
  {
    if (paramFloat == 0.0F) {}
    for (;;)
    {
      return;
      int i = mHead;
      for (int j = 0; (i != -1) && (j < currentSize); j++)
      {
        SolverVariable localSolverVariable = mCache.mIndexedVariables[mArrayIndices[i]];
        float f = mArrayValues[i];
        paramArrayLinkedVariables.put(localSolverVariable, paramArrayLinkedVariables.get(localSolverVariable) + f * paramFloat);
        i = mArrayNextIndices[i];
      }
    }
  }
  
  public void updateClientEquations(ArrayRow paramArrayRow)
  {
    int i = mHead;
    for (int j = 0; (i != -1) && (j < currentSize); j++)
    {
      mCache.mIndexedVariables[mArrayIndices[i]].addClientEquation(paramArrayRow);
      i = mArrayNextIndices[i];
    }
  }
  
  public void updateFromRow(ArrayRow paramArrayRow1, ArrayRow paramArrayRow2)
  {
    int i = mHead;
    int j = 0;
    while ((i != -1) && (j < currentSize)) {
      if (mArrayIndices[i] == variable.id)
      {
        float f = mArrayValues[i];
        remove(variable);
        ArrayLinkedVariables localArrayLinkedVariables = (ArrayLinkedVariables)variables;
        int k = mHead;
        for (int m = 0; (k != -1) && (m < currentSize); m++)
        {
          add(mCache.mIndexedVariables[mArrayIndices[k]], f * mArrayValues[k]);
          k = mArrayNextIndices[k];
        }
        constantValue += f * constantValue;
        variable.removeClientEquation(paramArrayRow1);
        i = mHead;
        j = 0;
      }
      else
      {
        i = mArrayNextIndices[i];
        j++;
      }
    }
  }
  
  public void updateFromSystem(ArrayRow paramArrayRow, ArrayRow[] paramArrayOfArrayRow)
  {
    int i = mHead;
    int j = 0;
    while ((i != -1) && (j < currentSize))
    {
      SolverVariable localSolverVariable = mCache.mIndexedVariables[mArrayIndices[i]];
      if (definitionId != -1)
      {
        float f = mArrayValues[i];
        remove(localSolverVariable);
        ArrayRow localArrayRow = paramArrayOfArrayRow[definitionId];
        if (!isSimpleDefinition)
        {
          ArrayLinkedVariables localArrayLinkedVariables = (ArrayLinkedVariables)variables;
          int k = mHead;
          for (int m = 0; (k != -1) && (m < currentSize); m++)
          {
            add(mCache.mIndexedVariables[mArrayIndices[k]], f * mArrayValues[k]);
            k = mArrayNextIndices[k];
          }
        }
        constantValue += f * constantValue;
        variable.removeClientEquation(paramArrayRow);
        i = mHead;
        j = 0;
      }
      else
      {
        i = mArrayNextIndices[i];
        j++;
      }
    }
  }
}
