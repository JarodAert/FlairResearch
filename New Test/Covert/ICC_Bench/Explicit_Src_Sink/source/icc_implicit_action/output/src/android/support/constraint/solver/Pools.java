package android.support.constraint.solver;

final class Pools
{
  private static final boolean DEBUG;
  
  private Pools() {}
  
  static abstract interface Pool<T>
  {
    public abstract T acquire();
    
    public abstract boolean release(T paramT);
    
    public abstract void releaseAll(T[] paramArrayOfT, int paramInt);
  }
  
  static class SimplePool<T>
    implements Pools.Pool<T>
  {
    private final Object[] mPool;
    private int mPoolSize;
    
    public SimplePool(int paramInt)
    {
      if (paramInt <= 0) {
        throw new IllegalArgumentException("The max pool size must be > 0");
      }
      mPool = new Object[paramInt];
    }
    
    private boolean isInPool(T paramT)
    {
      for (int i = 0; i < mPoolSize; i++) {
        if (mPool[i] == paramT) {
          return true;
        }
      }
      return false;
    }
    
    public T acquire()
    {
      if (mPoolSize > 0)
      {
        int i = -1 + mPoolSize;
        Object localObject = mPool[i];
        mPool[i] = null;
        mPoolSize = (-1 + mPoolSize);
        return localObject;
      }
      return null;
    }
    
    public boolean release(T paramT)
    {
      if (mPoolSize < mPool.length)
      {
        mPool[mPoolSize] = paramT;
        mPoolSize = (1 + mPoolSize);
        return true;
      }
      return false;
    }
    
    public void releaseAll(T[] paramArrayOfT, int paramInt)
    {
      for (int i = 0; i < paramInt; i++)
      {
        T ? = paramArrayOfT[i];
        if (mPoolSize < mPool.length)
        {
          mPool[mPoolSize] = ?;
          mPoolSize = (1 + mPoolSize);
        }
      }
    }
  }
}
