package android.support.v4.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import java.io.FileNotFoundException;

public final class PrintHelper
{
  public static final int COLOR_MODE_COLOR = 2;
  public static final int COLOR_MODE_MONOCHROME = 1;
  public static final int ORIENTATION_LANDSCAPE = 1;
  public static final int ORIENTATION_PORTRAIT = 2;
  public static final int SCALE_MODE_FILL = 2;
  public static final int SCALE_MODE_FIT = 1;
  PrintHelperVersionImpl mImpl;
  
  public PrintHelper(Context paramContext)
  {
    if (systemSupportsPrint())
    {
      mImpl = new PrintHelperKitkatImpl(paramContext);
      return;
    }
    mImpl = new PrintHelperStubImpl(null);
  }
  
  public static boolean systemSupportsPrint()
  {
    return Build.VERSION.SDK_INT >= 19;
  }
  
  public int getColorMode()
  {
    return mImpl.getColorMode();
  }
  
  public int getOrientation()
  {
    return mImpl.getOrientation();
  }
  
  public int getScaleMode()
  {
    return mImpl.getScaleMode();
  }
  
  public void printBitmap(String paramString, Bitmap paramBitmap)
  {
    mImpl.printBitmap(paramString, paramBitmap);
  }
  
  public void printBitmap(String paramString, Uri paramUri)
    throws FileNotFoundException
  {
    mImpl.printBitmap(paramString, paramUri);
  }
  
  public void setColorMode(int paramInt)
  {
    mImpl.setColorMode(paramInt);
  }
  
  public void setOrientation(int paramInt)
  {
    mImpl.setOrientation(paramInt);
  }
  
  public void setScaleMode(int paramInt)
  {
    mImpl.setScaleMode(paramInt);
  }
  
  private static final class PrintHelperKitkatImpl
    implements PrintHelper.PrintHelperVersionImpl
  {
    private final PrintHelperKitkat mPrintHelper;
    
    PrintHelperKitkatImpl(Context paramContext)
    {
      mPrintHelper = new PrintHelperKitkat(paramContext);
    }
    
    public int getColorMode()
    {
      return mPrintHelper.getColorMode();
    }
    
    public int getOrientation()
    {
      return mPrintHelper.getOrientation();
    }
    
    public int getScaleMode()
    {
      return mPrintHelper.getScaleMode();
    }
    
    public void printBitmap(String paramString, Bitmap paramBitmap)
    {
      mPrintHelper.printBitmap(paramString, paramBitmap);
    }
    
    public void printBitmap(String paramString, Uri paramUri)
      throws FileNotFoundException
    {
      mPrintHelper.printBitmap(paramString, paramUri);
    }
    
    public void setColorMode(int paramInt)
    {
      mPrintHelper.setColorMode(paramInt);
    }
    
    public void setOrientation(int paramInt)
    {
      mPrintHelper.setOrientation(paramInt);
    }
    
    public void setScaleMode(int paramInt)
    {
      mPrintHelper.setScaleMode(paramInt);
    }
  }
  
  private static final class PrintHelperStubImpl
    implements PrintHelper.PrintHelperVersionImpl
  {
    int mColorMode = 2;
    int mOrientation = 1;
    int mScaleMode = 2;
    
    private PrintHelperStubImpl() {}
    
    public int getColorMode()
    {
      return mColorMode;
    }
    
    public int getOrientation()
    {
      return mOrientation;
    }
    
    public int getScaleMode()
    {
      return mScaleMode;
    }
    
    public void printBitmap(String paramString, Bitmap paramBitmap) {}
    
    public void printBitmap(String paramString, Uri paramUri) {}
    
    public void setColorMode(int paramInt)
    {
      mColorMode = paramInt;
    }
    
    public void setOrientation(int paramInt)
    {
      mOrientation = paramInt;
    }
    
    public void setScaleMode(int paramInt)
    {
      mScaleMode = paramInt;
    }
  }
  
  static abstract interface PrintHelperVersionImpl
  {
    public abstract int getColorMode();
    
    public abstract int getOrientation();
    
    public abstract int getScaleMode();
    
    public abstract void printBitmap(String paramString, Bitmap paramBitmap);
    
    public abstract void printBitmap(String paramString, Uri paramUri)
      throws FileNotFoundException;
    
    public abstract void setColorMode(int paramInt);
    
    public abstract void setOrientation(int paramInt);
    
    public abstract void setScaleMode(int paramInt);
  }
}
