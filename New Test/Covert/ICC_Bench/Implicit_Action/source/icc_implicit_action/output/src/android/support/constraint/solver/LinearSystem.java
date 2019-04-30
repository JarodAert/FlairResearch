package android.support.constraint.solver;

import android.support.constraint.solver.widgets.ConstraintAnchor;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;

public class LinearSystem
{
  private static final boolean DEBUG = false;
  private static final int POOL_SIZE = 1000;
  private int TABLE_SIZE = 32;
  private boolean[] mAlreadyTestedCandidates = new boolean[TABLE_SIZE];
  private final Cache mCache;
  private ArrayRow mGoal;
  private int mMaxColumns = TABLE_SIZE;
  int mMaxRows = TABLE_SIZE;
  int mNumColumns = 1;
  int mNumRows = 0;
  private SolverVariable[] mPoolVariables = new SolverVariable['Ϩ'];
  private int mPoolVariablesCount = 0;
  private ArrayRow[] mRows = null;
  private HashMap<String, SolverVariable> mVariables = null;
  private int mVariablesID = 0;
  private ArrayRow[] tempClientsCopy = new ArrayRow[32];
  SolverVariable[] tempVars = new SolverVariable['Ā'];
  
  public LinearSystem()
  {
    releaseRows();
    mCache = new Cache();
  }
  
  private final SolverVariable acquireSolverVariable(SolverVariable.Type paramType)
  {
    SolverVariable localSolverVariable = (SolverVariable)mCache.solverVariablePool.acquire();
    if (localSolverVariable == null) {
      localSolverVariable = new SolverVariable(mCache, paramType);
    }
    localSolverVariable.reset();
    localSolverVariable.setType(paramType);
    SolverVariable[] arrayOfSolverVariable = mPoolVariables;
    int i = mPoolVariablesCount;
    mPoolVariablesCount = (i + 1);
    arrayOfSolverVariable[i] = localSolverVariable;
    return localSolverVariable;
  }
  
  private void computeValues()
  {
    for (int i = 0; i < mNumRows; i++)
    {
      ArrayRow localArrayRow = mRows[i];
      variable.computedValue = constantValue;
    }
  }
  
  private SolverVariable createVariable(String paramString, SolverVariable.Type paramType)
  {
    if (1 + mNumColumns >= mMaxColumns) {
      increaseTableSize();
    }
    SolverVariable localSolverVariable = acquireSolverVariable(paramType);
    localSolverVariable.setName(paramString);
    mVariablesID = (1 + mVariablesID);
    mNumColumns = (1 + mNumColumns);
    id = mVariablesID;
    if (mVariables == null) {
      mVariables = new HashMap();
    }
    mVariables.put(paramString, localSolverVariable);
    mCache.mIndexedVariables[mVariablesID] = localSolverVariable;
    return localSolverVariable;
  }
  
  private void displaySolverVariables()
  {
    String str1 = "Display Rows (" + mNumRows + "x" + mNumColumns + ") :\n\t | C | ";
    for (int i = 1; i <= mNumColumns; i++)
    {
      SolverVariable localSolverVariable = mCache.mIndexedVariables[i];
      String str3 = str1 + localSolverVariable;
      str1 = str3 + " | ";
    }
    String str2 = str1 + "\n";
    System.out.println(str2);
  }
  
  private int enforceBFS(ArrayRow paramArrayRow)
    throws Exception
  {
    int i = 0;
    int j = mNumRows;
    int k = 0;
    if (i < j)
    {
      if (mRows[i].variable.mType == SolverVariable.Type.UNRESTRICTED) {}
      while (mRows[i].constantValue >= 0.0F)
      {
        i++;
        break;
      }
      k = 1;
    }
    int m = 0;
    if (k != 0)
    {
      int i3 = 0;
      m = 0;
      while (i3 == 0)
      {
        m++;
        float f1 = Float.MAX_VALUE;
        int i4 = Integer.MAX_VALUE;
        int i5 = -1;
        int i6 = -1;
        int i7 = 0;
        if (i7 < mNumRows)
        {
          ArrayRow localArrayRow2 = mRows[i7];
          if (variable.mType == SolverVariable.Type.UNRESTRICTED) {}
          while (constantValue >= 0.0F)
          {
            i7++;
            break;
          }
          int i9 = 1;
          label146:
          SolverVariable localSolverVariable;
          float f2;
          if (i9 < mNumColumns)
          {
            localSolverVariable = mCache.mIndexedVariables[i9];
            f2 = variables.get(localSolverVariable);
            if (f2 > 0.0F) {
              break label192;
            }
          }
          for (;;)
          {
            i9++;
            break label146;
            break;
            label192:
            float f3 = variables.get(localSolverVariable) / f2;
            if ((strength <= i4) && (f3 < f1))
            {
              f1 = f3;
              i5 = i7;
              i6 = i9;
              i4 = strength;
            }
          }
        }
        if (i5 != -1)
        {
          ArrayRow localArrayRow1 = mRows[i5];
          variable.definitionId = -1;
          localArrayRow1.pivot(mCache.mIndexedVariables[i6]);
          variable.definitionId = i5;
          for (int i8 = 0; i8 < mNumRows; i8++) {
            mRows[i8].updateRowWithEquation(localArrayRow1);
          }
          paramArrayRow.updateRowWithEquation(localArrayRow1);
        }
        else
        {
          i3 = 1;
        }
      }
    }
    int n = 0;
    int i1 = mNumRows;
    int i2 = 0;
    if (n < i1)
    {
      if (mRows[n].variable.mType == SolverVariable.Type.UNRESTRICTED) {}
      while (mRows[n].constantValue >= 0.0F)
      {
        n++;
        break;
      }
      i2 = 1;
    }
    if (i2 != 0) {}
    return m;
  }
  
  private String getDisplaySize(int paramInt)
  {
    int i = paramInt * 4 / 1024 / 1024;
    if (i > 0) {
      return "" + i + " Mb";
    }
    int j = paramInt * 4 / 1024;
    if (j > 0) {
      return "" + j + " Kb";
    }
    return "" + paramInt * 4 + " bytes";
  }
  
  private int optimize(ArrayRow paramArrayRow)
  {
    int i = 0;
    int j = 0;
    for (int k = 0; k < mNumColumns; k++) {
      mAlreadyTestedCandidates[k] = false;
    }
    int m = 0;
    while (i == 0)
    {
      j++;
      SolverVariable localSolverVariable = variables.getPivotCandidate();
      float f1;
      int n;
      int i1;
      float f2;
      int i2;
      label99:
      ArrayRow localArrayRow2;
      if (localSolverVariable != null)
      {
        if (mAlreadyTestedCandidates[id] != 0) {
          localSolverVariable = null;
        }
      }
      else
      {
        if (localSolverVariable == null) {
          break label330;
        }
        f1 = Float.MAX_VALUE;
        n = -1;
        i1 = 0;
        f2 = variables.get(localSolverVariable);
        i2 = 0;
        if (i2 >= mNumRows) {
          break label243;
        }
        localArrayRow2 = mRows[i2];
        if (variable.mType != SolverVariable.Type.UNRESTRICTED) {
          break label165;
        }
      }
      for (;;)
      {
        i2++;
        break label99;
        mAlreadyTestedCandidates[id] = true;
        m++;
        if (m < mNumColumns) {
          break;
        }
        i = 1;
        break;
        label165:
        if (localArrayRow2.hasVariable(localSolverVariable))
        {
          float f3 = variables.get(localSolverVariable);
          if (f3 > 0.0F)
          {
            float f4 = f2 / f3;
            if ((strength >= i1) && (f4 < f1))
            {
              f1 = f4;
              i1 = strength;
              n = i2;
            }
          }
        }
      }
      label243:
      if (n > -1)
      {
        ArrayRow localArrayRow1 = mRows[n];
        variable.definitionId = -1;
        localArrayRow1.pivot(localSolverVariable);
        variable.definitionId = n;
        for (int i3 = 0; i3 < mNumRows; i3++) {
          mRows[i3].updateRowWithEquation(localArrayRow1);
        }
        paramArrayRow.updateRowWithEquation(localArrayRow1);
      }
      else
      {
        i = 1;
        continue;
        label330:
        i = 1;
      }
    }
    return j;
  }
  
  private void releaseGoal()
  {
    if (mGoal != null) {
      mCache.arrayRowPool.release(mGoal);
    }
  }
  
  private void releaseRows()
  {
    for (int i = 0; i < mRows.length; i++)
    {
      ArrayRow localArrayRow = mRows[i];
      if (localArrayRow != null) {
        mCache.arrayRowPool.release(localArrayRow);
      }
      mRows[i] = null;
    }
  }
  
  private void updateRowFromVariables(ArrayRow paramArrayRow)
  {
    if (mNumRows > 0)
    {
      variables.updateFromSystem(paramArrayRow, mRows);
      if (variables.currentSize == 0) {
        isSimpleDefinition = true;
      }
    }
  }
  
  public void addCentering(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt1, float paramFloat, SolverVariable paramSolverVariable3, SolverVariable paramSolverVariable4, int paramInt2, int paramInt3)
  {
    ArrayRow localArrayRow = createRow();
    localArrayRow.createRowCentering(paramSolverVariable1, paramSolverVariable2, paramInt1, paramFloat, paramSolverVariable3, paramSolverVariable4, paramInt2, false);
    SolverVariable localSolverVariable1 = createErrorVariable();
    SolverVariable localSolverVariable2 = createErrorVariable();
    strength = paramInt3;
    strength = paramInt3;
    localArrayRow.addError(localSolverVariable1, localSolverVariable2);
    addConstraint(localArrayRow);
  }
  
  public void addConstraint(ArrayRow paramArrayRow)
  {
    if (paramArrayRow == null) {}
    int i;
    do
    {
      do
      {
        return;
        if ((1 + mNumRows >= mMaxRows) || (1 + mNumColumns >= mMaxColumns)) {
          increaseTableSize();
        }
        if (isSimpleDefinition) {
          break;
        }
        updateRowFromVariables(paramArrayRow);
        paramArrayRow.ensurePositiveConstant();
        paramArrayRow.pickRowVariable();
      } while (!paramArrayRow.hasKeyVariable());
      if (mRows[mNumRows] != null) {
        mCache.arrayRowPool.release(mRows[mNumRows]);
      }
      if (!isSimpleDefinition) {
        paramArrayRow.updateClientEquations();
      }
      mRows[mNumRows] = paramArrayRow;
      variable.definitionId = mNumRows;
      mNumRows = (1 + mNumRows);
      i = variable.mClientEquationsCount;
    } while (i <= 0);
    while (tempClientsCopy.length < i) {
      tempClientsCopy = new ArrayRow[2 * tempClientsCopy.length];
    }
    ArrayRow[] arrayOfArrayRow = tempClientsCopy;
    for (int j = 0; j < i; j++) {
      arrayOfArrayRow[j] = variable.mClientEquations[j];
    }
    int k = 0;
    label213:
    ArrayRow localArrayRow;
    if (k < i)
    {
      localArrayRow = arrayOfArrayRow[k];
      if (localArrayRow != paramArrayRow) {
        break label237;
      }
    }
    for (;;)
    {
      k++;
      break label213;
      break;
      label237:
      variables.updateFromRow(localArrayRow, paramArrayRow);
      localArrayRow.updateClientEquations();
    }
  }
  
  public void addConstraint(LinearEquation paramLinearEquation)
  {
    addConstraint(EquationCreation.createRowFromEquation(this, paramLinearEquation));
  }
  
  public void addEquality(SolverVariable paramSolverVariable, int paramInt)
  {
    int i = definitionId;
    if (definitionId != -1)
    {
      ArrayRow localArrayRow2 = mRows[i];
      if (isSimpleDefinition)
      {
        constantValue = paramInt;
        return;
      }
      ArrayRow localArrayRow3 = createRow();
      localArrayRow3.createRowEquals(paramSolverVariable, paramInt);
      addConstraint(localArrayRow3);
      return;
    }
    ArrayRow localArrayRow1 = createRow();
    localArrayRow1.createRowDefinition(paramSolverVariable, paramInt);
    addConstraint(localArrayRow1);
  }
  
  public void addEquality(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt1, int paramInt2)
  {
    ArrayRow localArrayRow = createRow();
    localArrayRow.createRowEquals(paramSolverVariable1, paramSolverVariable2, paramInt1);
    SolverVariable localSolverVariable1 = createErrorVariable();
    SolverVariable localSolverVariable2 = createErrorVariable();
    strength = paramInt2;
    strength = paramInt2;
    localArrayRow.addError(localSolverVariable1, localSolverVariable2);
    addConstraint(localArrayRow);
  }
  
  void addError(ArrayRow paramArrayRow)
  {
    paramArrayRow.addError(createErrorVariable(), createErrorVariable());
  }
  
  public void addGreaterThan(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt1, int paramInt2)
  {
    ArrayRow localArrayRow = createRow();
    SolverVariable localSolverVariable = createSlackVariable();
    strength = paramInt2;
    localArrayRow.createRowGreaterThan(paramSolverVariable1, paramSolverVariable2, localSolverVariable, paramInt1);
    addConstraint(localArrayRow);
  }
  
  public void addLowerThan(SolverVariable paramSolverVariable1, SolverVariable paramSolverVariable2, int paramInt1, int paramInt2)
  {
    ArrayRow localArrayRow = createRow();
    SolverVariable localSolverVariable = createSlackVariable();
    strength = paramInt2;
    localArrayRow.createRowLowerThan(paramSolverVariable1, paramSolverVariable2, localSolverVariable, paramInt1);
    addConstraint(localArrayRow);
  }
  
  void addSingleError(ArrayRow paramArrayRow, int paramInt)
  {
    paramArrayRow.addSingleError(createErrorVariable(), paramInt);
  }
  
  SolverVariable createErrorVariable()
  {
    if (1 + mNumColumns >= mMaxColumns) {
      increaseTableSize();
    }
    SolverVariable localSolverVariable = acquireSolverVariable(SolverVariable.Type.ERROR);
    mVariablesID = (1 + mVariablesID);
    mNumColumns = (1 + mNumColumns);
    id = mVariablesID;
    mCache.mIndexedVariables[mVariablesID] = localSolverVariable;
    return localSolverVariable;
  }
  
  public SolverVariable createObjectVariable(Object paramObject)
  {
    SolverVariable localSolverVariable;
    if (paramObject == null) {
      localSolverVariable = null;
    }
    do
    {
      boolean bool;
      do
      {
        return localSolverVariable;
        if (1 + mNumColumns >= mMaxColumns) {
          increaseTableSize();
        }
        bool = paramObject instanceof ConstraintAnchor;
        localSolverVariable = null;
      } while (!bool);
      localSolverVariable = ((ConstraintAnchor)paramObject).getSolverVariable();
      if (localSolverVariable == null)
      {
        ((ConstraintAnchor)paramObject).resetSolverVariable(mCache);
        localSolverVariable = ((ConstraintAnchor)paramObject).getSolverVariable();
      }
    } while ((id != -1) && (id <= mVariablesID) && (mCache.mIndexedVariables[id] != null));
    if (id != -1) {
      localSolverVariable.reset();
    }
    mVariablesID = (1 + mVariablesID);
    mNumColumns = (1 + mNumColumns);
    id = mVariablesID;
    mType = SolverVariable.Type.UNRESTRICTED;
    mCache.mIndexedVariables[mVariablesID] = localSolverVariable;
    return localSolverVariable;
  }
  
  public ArrayRow createRow()
  {
    ArrayRow localArrayRow = (ArrayRow)mCache.arrayRowPool.acquire();
    if (localArrayRow == null) {
      return new ArrayRow(mCache);
    }
    localArrayRow.reset();
    return localArrayRow;
  }
  
  public SolverVariable createSlackVariable()
  {
    if (1 + mNumColumns >= mMaxColumns) {
      increaseTableSize();
    }
    SolverVariable localSolverVariable = acquireSolverVariable(SolverVariable.Type.SLACK);
    mVariablesID = (1 + mVariablesID);
    mNumColumns = (1 + mNumColumns);
    id = mVariablesID;
    mCache.mIndexedVariables[mVariablesID] = localSolverVariable;
    return localSolverVariable;
  }
  
  public void displayReadableRows()
  {
    displaySolverVariables();
    String str1 = "";
    for (int i = 0; i < mNumRows; i++)
    {
      String str2 = str1 + mRows[i].toReadableString();
      str1 = str2 + "\n";
    }
    if (mGoal != null) {
      str1 = str1 + mGoal.toReadableString() + "\n";
    }
    System.out.println(str1);
  }
  
  public void displayRows()
  {
    displaySolverVariables();
    String str1 = "";
    for (int i = 0; i < mNumRows; i++)
    {
      String str2 = str1 + mRows[i];
      str1 = str2 + "\n";
    }
    if (mGoal != null) {
      str1 = str1 + mGoal + "\n";
    }
    System.out.println(str1);
  }
  
  public void displaySystemInformations()
  {
    int i = 0;
    for (int j = 0; j < TABLE_SIZE; j++) {
      if (mRows[j] != null) {
        i += mRows[j].sizeInBytes();
      }
    }
    int k = 0;
    for (int m = 0; m < mNumRows; m++) {
      if (mRows[m] != null) {
        k += mRows[m].sizeInBytes();
      }
    }
    System.out.println("Linear System -> Table size: " + TABLE_SIZE + " (" + getDisplaySize(TABLE_SIZE * TABLE_SIZE) + ") -- row sizes: " + getDisplaySize(i) + ", actual size: " + getDisplaySize(k) + " rows: " + mNumRows + "/" + mMaxRows + " cols: " + mNumColumns + "/" + mMaxColumns + " " + 0 + " occupied cells, " + getDisplaySize(0) + " " + LinkedVariables.sCreation + " created Link variables");
  }
  
  public void displayVariablesReadableRows()
  {
    displaySolverVariables();
    String str1 = "";
    for (int i = 0; i < mNumRows; i++) {
      if (mRows[i].variable.mType == SolverVariable.Type.UNRESTRICTED)
      {
        String str2 = str1 + mRows[i].toReadableString();
        str1 = str2 + "\n";
      }
    }
    if (mGoal != null) {
      str1 = str1 + mGoal.toReadableString() + "\n";
    }
    System.out.println(str1);
  }
  
  public Cache getCache()
  {
    return mCache;
  }
  
  public ArrayRow getGoal()
  {
    return mGoal;
  }
  
  public int getMemoryUsed()
  {
    int i = 0;
    for (int j = 0; j < mNumRows; j++) {
      if (mRows[j] != null) {
        i += mRows[j].sizeInBytes();
      }
    }
    return i;
  }
  
  public int getNumEquations()
  {
    return mNumRows;
  }
  
  public int getNumVariables()
  {
    return mVariablesID;
  }
  
  public int getObjectVariableValue(Object paramObject)
  {
    SolverVariable localSolverVariable = ((ConstraintAnchor)paramObject).getSolverVariable();
    if (localSolverVariable != null) {
      return (int)(0.5F + computedValue);
    }
    return 0;
  }
  
  public ArrayRow getRow(int paramInt)
  {
    return mRows[paramInt];
  }
  
  public float getValueFor(String paramString)
  {
    SolverVariable localSolverVariable = getVariable(paramString, SolverVariable.Type.UNRESTRICTED);
    if (localSolverVariable == null) {
      return 0.0F;
    }
    return computedValue;
  }
  
  public SolverVariable getVariable(String paramString, SolverVariable.Type paramType)
  {
    if (mVariables == null) {
      mVariables = new HashMap();
    }
    SolverVariable localSolverVariable = (SolverVariable)mVariables.get(paramString);
    if (localSolverVariable == null) {
      localSolverVariable = createVariable(paramString, paramType);
    }
    return localSolverVariable;
  }
  
  void increaseTableSize()
  {
    TABLE_SIZE = (2 * TABLE_SIZE);
    mRows = ((ArrayRow[])Arrays.copyOf(mRows, TABLE_SIZE));
    mCache.mIndexedVariables = ((SolverVariable[])Arrays.copyOf(mCache.mIndexedVariables, TABLE_SIZE));
    mAlreadyTestedCandidates = new boolean[TABLE_SIZE];
    mMaxColumns = TABLE_SIZE;
    mMaxRows = TABLE_SIZE;
    releaseGoal();
    mGoal = null;
  }
  
  public void minimize()
    throws Exception
  {
    rebuildGoalFromErrors();
    minimizeGoal(mGoal);
  }
  
  public void minimizeGoal(ArrayRow paramArrayRow)
    throws Exception
  {
    variables.updateFromSystem(paramArrayRow, mRows);
    if (!paramArrayRow.hasAtLeastOnePositiveVariable())
    {
      computeValues();
      return;
    }
    try
    {
      enforceBFS(paramArrayRow);
      optimize(paramArrayRow);
      computeValues();
      return;
    }
    catch (Exception localException)
    {
      computeValues();
      throw localException;
    }
  }
  
  public void rebuildGoalFromErrors()
  {
    if (mGoal != null) {
      mGoal.reset();
    }
    for (;;)
    {
      for (int i = 1; i < mNumColumns; i++)
      {
        SolverVariable localSolverVariable = mCache.mIndexedVariables[i];
        if (mType == SolverVariable.Type.ERROR) {
          mGoal.variables.put(localSolverVariable, 1.0F);
        }
      }
      mGoal = createRow();
    }
  }
  
  void replaceVariable(ArrayRow paramArrayRow, SolverVariable paramSolverVariable)
  {
    int i = definitionId;
    if (i != -1) {
      paramArrayRow.updateRowWithEquation(mRows[i]);
    }
  }
  
  public void reset()
  {
    for (int i = 0; i < mCache.mIndexedVariables.length; i++)
    {
      SolverVariable localSolverVariable = mCache.mIndexedVariables[i];
      if (localSolverVariable != null) {
        localSolverVariable.reset();
      }
    }
    mCache.solverVariablePool.releaseAll(mPoolVariables, mPoolVariablesCount);
    mPoolVariablesCount = 0;
    Arrays.fill(mCache.mIndexedVariables, null);
    if (mVariables != null) {
      mVariables.clear();
    }
    mVariablesID = 0;
    releaseGoal();
    mGoal = null;
    mNumColumns = 1;
    for (int j = 0; j < mNumRows; j++) {
      mRows[j].used = false;
    }
    releaseRows();
    mNumRows = 0;
  }
}
