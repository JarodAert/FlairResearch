package android.support.v4.print;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.CancellationSignal.OnCancelListener;
import android.print.PrintAttributes;
import android.print.PrintAttributes.Builder;
import android.print.PrintAttributes.MediaSize;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentAdapter.LayoutResultCallback;
import android.print.PrintDocumentInfo;
import android.print.PrintDocumentInfo.Builder;
import android.print.PrintManager;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

class PrintHelperKitkat
{
  public static final int COLOR_MODE_COLOR = 2;
  public static final int COLOR_MODE_MONOCHROME = 1;
  private static final String LOG_TAG = "PrintHelperKitkat";
  private static final int MAX_PRINT_SIZE = 3500;
  public static final int ORIENTATION_LANDSCAPE = 1;
  public static final int ORIENTATION_PORTRAIT = 2;
  public static final int SCALE_MODE_FILL = 2;
  public static final int SCALE_MODE_FIT = 1;
  int mColorMode = 2;
  final Context mContext;
  BitmapFactory.Options mDecodeOptions = null;
  private final Object mLock = new Object();
  int mOrientation = 1;
  int mScaleMode = 2;
  
  PrintHelperKitkat(Context paramContext)
  {
    mContext = paramContext;
  }
  
  private Matrix getMatrix(int paramInt1, int paramInt2, RectF paramRectF, int paramInt3)
  {
    Matrix localMatrix = new Matrix();
    float f1 = paramRectF.width() / paramInt1;
    if (paramInt3 == 2) {}
    for (float f2 = Math.max(f1, paramRectF.height() / paramInt2);; f2 = Math.min(f1, paramRectF.height() / paramInt2))
    {
      localMatrix.postScale(f2, f2);
      localMatrix.postTranslate((paramRectF.width() - f2 * paramInt1) / 2.0F, (paramRectF.height() - f2 * paramInt2) / 2.0F);
      return localMatrix;
    }
  }
  
  private Bitmap loadBitmap(Uri paramUri, BitmapFactory.Options paramOptions)
    throws FileNotFoundException
  {
    if ((paramUri == null) || (mContext == null)) {
      throw new IllegalArgumentException("bad argument to loadBitmap");
    }
    localInputStream = null;
    try
    {
      localInputStream = mContext.getContentResolver().openInputStream(paramUri);
      Bitmap localBitmap = BitmapFactory.decodeStream(localInputStream, null, paramOptions);
      if (localInputStream != null) {}
      try
      {
        localInputStream.close();
        return localBitmap;
      }
      catch (IOException localIOException2)
      {
        Log.w("PrintHelperKitkat", "close fail ", localIOException2);
        return localBitmap;
      }
      try
      {
        localInputStream.close();
        throw localObject;
      }
      catch (IOException localIOException1)
      {
        for (;;)
        {
          Log.w("PrintHelperKitkat", "close fail ", localIOException1);
        }
      }
    }
    finally
    {
      if (localInputStream == null) {}
    }
  }
  
  private Bitmap loadConstrainedBitmap(Uri paramUri, int paramInt)
    throws FileNotFoundException
  {
    if ((paramInt <= 0) || (paramUri == null) || (mContext == null)) {
      throw new IllegalArgumentException("bad argument to getScaledBitmap");
    }
    BitmapFactory.Options localOptions1 = new BitmapFactory.Options();
    inJustDecodeBounds = true;
    loadBitmap(paramUri, localOptions1);
    int i = outWidth;
    int j = outHeight;
    if ((i <= 0) || (j <= 0)) {}
    int m;
    do
    {
      return null;
      int k = Math.max(i, j);
      m = 1;
      while (k > paramInt)
      {
        k >>>= 1;
        m <<= 1;
      }
    } while ((m <= 0) || (Math.min(i, j) / m <= 0));
    BitmapFactory.Options localOptions2;
    synchronized (mLock)
    {
      mDecodeOptions = new BitmapFactory.Options();
      mDecodeOptions.inMutable = true;
      mDecodeOptions.inSampleSize = m;
      localOptions2 = mDecodeOptions;
    }
    try
    {
      Bitmap localBitmap = loadBitmap(paramUri, localOptions2);
      synchronized (mLock)
      {
        mDecodeOptions = null;
        return localBitmap;
      }
      localObject2 = finally;
      throw localObject2;
    }
    finally {}
  }
  
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
  
  public void printBitmap(final String paramString, final Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    final int i = mScaleMode;
    PrintManager localPrintManager = (PrintManager)mContext.getSystemService("print");
    PrintAttributes.MediaSize localMediaSize = PrintAttributes.MediaSize.UNKNOWN_PORTRAIT;
    if (paramBitmap.getWidth() > paramBitmap.getHeight()) {
      localMediaSize = PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE;
    }
    PrintAttributes localPrintAttributes = new PrintAttributes.Builder().setMediaSize(localMediaSize).setColorMode(mColorMode).build();
    localPrintManager.print(paramString, new PrintDocumentAdapter()
    {
      private PrintAttributes mAttributes;
      
      public void onLayout(PrintAttributes paramAnonymousPrintAttributes1, PrintAttributes paramAnonymousPrintAttributes2, CancellationSignal paramAnonymousCancellationSignal, PrintDocumentAdapter.LayoutResultCallback paramAnonymousLayoutResultCallback, Bundle paramAnonymousBundle)
      {
        int i = 1;
        mAttributes = paramAnonymousPrintAttributes2;
        PrintDocumentInfo localPrintDocumentInfo = new PrintDocumentInfo.Builder(paramString).setContentType(i).setPageCount(i).build();
        if (!paramAnonymousPrintAttributes2.equals(paramAnonymousPrintAttributes1)) {}
        for (;;)
        {
          paramAnonymousLayoutResultCallback.onLayoutFinished(localPrintDocumentInfo, i);
          return;
          int j = 0;
        }
      }
      
      /* Error */
      public void onWrite(android.print.PageRange[] paramAnonymousArrayOfPageRange, android.os.ParcelFileDescriptor paramAnonymousParcelFileDescriptor, CancellationSignal paramAnonymousCancellationSignal, android.print.PrintDocumentAdapter.WriteResultCallback paramAnonymousWriteResultCallback)
      {
        // Byte code:
        //   0: new 70	android/print/pdf/PrintedPdfDocument
        //   3: dup
        //   4: aload_0
        //   5: getfield 23	android/support/v4/print/PrintHelperKitkat$1:this$0	Landroid/support/v4/print/PrintHelperKitkat;
        //   8: getfield 74	android/support/v4/print/PrintHelperKitkat:mContext	Landroid/content/Context;
        //   11: aload_0
        //   12: getfield 36	android/support/v4/print/PrintHelperKitkat$1:mAttributes	Landroid/print/PrintAttributes;
        //   15: invokespecial 77	android/print/pdf/PrintedPdfDocument:<init>	(Landroid/content/Context;Landroid/print/PrintAttributes;)V
        //   18: astore 5
        //   20: aload 5
        //   22: iconst_1
        //   23: invokevirtual 81	android/print/pdf/PrintedPdfDocument:startPage	(I)Landroid/graphics/pdf/PdfDocument$Page;
        //   26: astore 8
        //   28: new 83	android/graphics/RectF
        //   31: dup
        //   32: aload 8
        //   34: invokevirtual 89	android/graphics/pdf/PdfDocument$Page:getInfo	()Landroid/graphics/pdf/PdfDocument$PageInfo;
        //   37: invokevirtual 95	android/graphics/pdf/PdfDocument$PageInfo:getContentRect	()Landroid/graphics/Rect;
        //   40: invokespecial 98	android/graphics/RectF:<init>	(Landroid/graphics/Rect;)V
        //   43: astore 9
        //   45: aload_0
        //   46: getfield 23	android/support/v4/print/PrintHelperKitkat$1:this$0	Landroid/support/v4/print/PrintHelperKitkat;
        //   49: aload_0
        //   50: getfield 27	android/support/v4/print/PrintHelperKitkat$1:val$bitmap	Landroid/graphics/Bitmap;
        //   53: invokevirtual 104	android/graphics/Bitmap:getWidth	()I
        //   56: aload_0
        //   57: getfield 27	android/support/v4/print/PrintHelperKitkat$1:val$bitmap	Landroid/graphics/Bitmap;
        //   60: invokevirtual 107	android/graphics/Bitmap:getHeight	()I
        //   63: aload 9
        //   65: aload_0
        //   66: getfield 29	android/support/v4/print/PrintHelperKitkat$1:val$fittingMode	I
        //   69: invokestatic 111	android/support/v4/print/PrintHelperKitkat:access$000	(Landroid/support/v4/print/PrintHelperKitkat;IILandroid/graphics/RectF;I)Landroid/graphics/Matrix;
        //   72: astore 10
        //   74: aload 8
        //   76: invokevirtual 115	android/graphics/pdf/PdfDocument$Page:getCanvas	()Landroid/graphics/Canvas;
        //   79: aload_0
        //   80: getfield 27	android/support/v4/print/PrintHelperKitkat$1:val$bitmap	Landroid/graphics/Bitmap;
        //   83: aload 10
        //   85: aconst_null
        //   86: invokevirtual 121	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V
        //   89: aload 5
        //   91: aload 8
        //   93: invokevirtual 125	android/print/pdf/PrintedPdfDocument:finishPage	(Landroid/graphics/pdf/PdfDocument$Page;)V
        //   96: aload 5
        //   98: new 127	java/io/FileOutputStream
        //   101: dup
        //   102: aload_2
        //   103: invokevirtual 133	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
        //   106: invokespecial 136	java/io/FileOutputStream:<init>	(Ljava/io/FileDescriptor;)V
        //   109: invokevirtual 140	android/print/pdf/PrintedPdfDocument:writeTo	(Ljava/io/OutputStream;)V
        //   112: iconst_1
        //   113: anewarray 142	android/print/PageRange
        //   116: astore 14
        //   118: aload 14
        //   120: iconst_0
        //   121: getstatic 146	android/print/PageRange:ALL_PAGES	Landroid/print/PageRange;
        //   124: aastore
        //   125: aload 4
        //   127: aload 14
        //   129: invokevirtual 152	android/print/PrintDocumentAdapter$WriteResultCallback:onWriteFinished	([Landroid/print/PageRange;)V
        //   132: aload 5
        //   134: ifnull +8 -> 142
        //   137: aload 5
        //   139: invokevirtual 155	android/print/pdf/PrintedPdfDocument:close	()V
        //   142: aload_2
        //   143: ifnull +7 -> 150
        //   146: aload_2
        //   147: invokevirtual 156	android/os/ParcelFileDescriptor:close	()V
        //   150: return
        //   151: astore 11
        //   153: ldc -98
        //   155: ldc -96
        //   157: aload 11
        //   159: invokestatic 166	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   162: pop
        //   163: aload 4
        //   165: aconst_null
        //   166: invokevirtual 170	android/print/PrintDocumentAdapter$WriteResultCallback:onWriteFailed	(Ljava/lang/CharSequence;)V
        //   169: goto -37 -> 132
        //   172: astore 6
        //   174: aload 5
        //   176: ifnull +8 -> 184
        //   179: aload 5
        //   181: invokevirtual 155	android/print/pdf/PrintedPdfDocument:close	()V
        //   184: aload_2
        //   185: ifnull +7 -> 192
        //   188: aload_2
        //   189: invokevirtual 156	android/os/ParcelFileDescriptor:close	()V
        //   192: aload 6
        //   194: athrow
        //   195: astore 13
        //   197: return
        //   198: astore 7
        //   200: goto -8 -> 192
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	203	0	this	1
        //   0	203	1	paramAnonymousArrayOfPageRange	android.print.PageRange[]
        //   0	203	2	paramAnonymousParcelFileDescriptor	android.os.ParcelFileDescriptor
        //   0	203	3	paramAnonymousCancellationSignal	CancellationSignal
        //   0	203	4	paramAnonymousWriteResultCallback	android.print.PrintDocumentAdapter.WriteResultCallback
        //   18	162	5	localPrintedPdfDocument	android.print.pdf.PrintedPdfDocument
        //   172	21	6	localObject	Object
        //   198	1	7	localIOException1	IOException
        //   26	66	8	localPage	android.graphics.pdf.PdfDocument.Page
        //   43	21	9	localRectF	RectF
        //   72	12	10	localMatrix	Matrix
        //   151	7	11	localIOException2	IOException
        //   195	1	13	localIOException3	IOException
        //   116	12	14	arrayOfPageRange	android.print.PageRange[]
        // Exception table:
        //   from	to	target	type
        //   96	132	151	java/io/IOException
        //   20	96	172	finally
        //   96	132	172	finally
        //   153	169	172	finally
        //   146	150	195	java/io/IOException
        //   188	192	198	java/io/IOException
      }
    }, localPrintAttributes);
  }
  
  public void printBitmap(final String paramString, final Uri paramUri)
    throws FileNotFoundException
  {
    PrintDocumentAdapter local2 = new PrintDocumentAdapter()
    {
      AsyncTask<Uri, Boolean, Bitmap> loadBitmap;
      private PrintAttributes mAttributes;
      Bitmap mBitmap = null;
      
      private void cancelLoad()
      {
        synchronized (mLock)
        {
          if (mDecodeOptions != null)
          {
            mDecodeOptions.requestCancelDecode();
            mDecodeOptions = null;
          }
          return;
        }
      }
      
      public void onFinish()
      {
        super.onFinish();
        cancelLoad();
        loadBitmap.cancel(true);
      }
      
      public void onLayout(final PrintAttributes paramAnonymousPrintAttributes1, final PrintAttributes paramAnonymousPrintAttributes2, final CancellationSignal paramAnonymousCancellationSignal, final PrintDocumentAdapter.LayoutResultCallback paramAnonymousLayoutResultCallback, Bundle paramAnonymousBundle)
      {
        int i = 1;
        if (paramAnonymousCancellationSignal.isCanceled())
        {
          paramAnonymousLayoutResultCallback.onLayoutCancelled();
          mAttributes = paramAnonymousPrintAttributes2;
          return;
        }
        if (mBitmap != null)
        {
          PrintDocumentInfo localPrintDocumentInfo = new PrintDocumentInfo.Builder(paramString).setContentType(i).setPageCount(i).build();
          if (!paramAnonymousPrintAttributes2.equals(paramAnonymousPrintAttributes1)) {}
          for (;;)
          {
            paramAnonymousLayoutResultCallback.onLayoutFinished(localPrintDocumentInfo, i);
            return;
            int j = 0;
          }
        }
        loadBitmap = new AsyncTask()
        {
          protected Bitmap doInBackground(Uri... paramAnonymous2VarArgs)
          {
            try
            {
              Bitmap localBitmap = PrintHelperKitkat.this.loadConstrainedBitmap(val$imageFile, 3500);
              return localBitmap;
            }
            catch (FileNotFoundException localFileNotFoundException) {}
            return null;
          }
          
          protected void onCancelled(Bitmap paramAnonymous2Bitmap)
          {
            paramAnonymousLayoutResultCallback.onLayoutCancelled();
          }
          
          protected void onPostExecute(Bitmap paramAnonymous2Bitmap)
          {
            int i = 1;
            super.onPostExecute(paramAnonymous2Bitmap);
            mBitmap = paramAnonymous2Bitmap;
            if (paramAnonymous2Bitmap != null)
            {
              PrintDocumentInfo localPrintDocumentInfo = new PrintDocumentInfo.Builder(val$jobName).setContentType(i).setPageCount(i).build();
              if (!paramAnonymousPrintAttributes2.equals(paramAnonymousPrintAttributes1)) {}
              for (;;)
              {
                paramAnonymousLayoutResultCallback.onLayoutFinished(localPrintDocumentInfo, i);
                return;
                int j = 0;
              }
            }
            paramAnonymousLayoutResultCallback.onLayoutFailed(null);
          }
          
          protected void onPreExecute()
          {
            paramAnonymousCancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener()
            {
              public void onCancel()
              {
                PrintHelperKitkat.2.this.cancelLoad();
                cancel(false);
              }
            });
          }
        };
        loadBitmap.execute(new Uri[0]);
        mAttributes = paramAnonymousPrintAttributes2;
      }
      
      /* Error */
      public void onWrite(android.print.PageRange[] paramAnonymousArrayOfPageRange, android.os.ParcelFileDescriptor paramAnonymousParcelFileDescriptor, CancellationSignal paramAnonymousCancellationSignal, android.print.PrintDocumentAdapter.WriteResultCallback paramAnonymousWriteResultCallback)
      {
        // Byte code:
        //   0: new 126	android/print/pdf/PrintedPdfDocument
        //   3: dup
        //   4: aload_0
        //   5: getfield 28	android/support/v4/print/PrintHelperKitkat$2:this$0	Landroid/support/v4/print/PrintHelperKitkat;
        //   8: getfield 130	android/support/v4/print/PrintHelperKitkat:mContext	Landroid/content/Context;
        //   11: aload_0
        //   12: getfield 83	android/support/v4/print/PrintHelperKitkat$2:mAttributes	Landroid/print/PrintAttributes;
        //   15: invokespecial 133	android/print/pdf/PrintedPdfDocument:<init>	(Landroid/content/Context;Landroid/print/PrintAttributes;)V
        //   18: astore 5
        //   20: aload 5
        //   22: iconst_1
        //   23: invokevirtual 137	android/print/pdf/PrintedPdfDocument:startPage	(I)Landroid/graphics/pdf/PdfDocument$Page;
        //   26: astore 8
        //   28: new 139	android/graphics/RectF
        //   31: dup
        //   32: aload 8
        //   34: invokevirtual 145	android/graphics/pdf/PdfDocument$Page:getInfo	()Landroid/graphics/pdf/PdfDocument$PageInfo;
        //   37: invokevirtual 151	android/graphics/pdf/PdfDocument$PageInfo:getContentRect	()Landroid/graphics/Rect;
        //   40: invokespecial 154	android/graphics/RectF:<init>	(Landroid/graphics/Rect;)V
        //   43: astore 9
        //   45: aload_0
        //   46: getfield 28	android/support/v4/print/PrintHelperKitkat$2:this$0	Landroid/support/v4/print/PrintHelperKitkat;
        //   49: aload_0
        //   50: getfield 39	android/support/v4/print/PrintHelperKitkat$2:mBitmap	Landroid/graphics/Bitmap;
        //   53: invokevirtual 160	android/graphics/Bitmap:getWidth	()I
        //   56: aload_0
        //   57: getfield 39	android/support/v4/print/PrintHelperKitkat$2:mBitmap	Landroid/graphics/Bitmap;
        //   60: invokevirtual 163	android/graphics/Bitmap:getHeight	()I
        //   63: aload 9
        //   65: aload_0
        //   66: getfield 34	android/support/v4/print/PrintHelperKitkat$2:val$fittingMode	I
        //   69: invokestatic 167	android/support/v4/print/PrintHelperKitkat:access$000	(Landroid/support/v4/print/PrintHelperKitkat;IILandroid/graphics/RectF;I)Landroid/graphics/Matrix;
        //   72: astore 10
        //   74: aload 8
        //   76: invokevirtual 171	android/graphics/pdf/PdfDocument$Page:getCanvas	()Landroid/graphics/Canvas;
        //   79: aload_0
        //   80: getfield 39	android/support/v4/print/PrintHelperKitkat$2:mBitmap	Landroid/graphics/Bitmap;
        //   83: aload 10
        //   85: aconst_null
        //   86: invokevirtual 177	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V
        //   89: aload 5
        //   91: aload 8
        //   93: invokevirtual 181	android/print/pdf/PrintedPdfDocument:finishPage	(Landroid/graphics/pdf/PdfDocument$Page;)V
        //   96: aload 5
        //   98: new 183	java/io/FileOutputStream
        //   101: dup
        //   102: aload_2
        //   103: invokevirtual 189	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
        //   106: invokespecial 192	java/io/FileOutputStream:<init>	(Ljava/io/FileDescriptor;)V
        //   109: invokevirtual 196	android/print/pdf/PrintedPdfDocument:writeTo	(Ljava/io/OutputStream;)V
        //   112: iconst_1
        //   113: anewarray 198	android/print/PageRange
        //   116: astore 14
        //   118: aload 14
        //   120: iconst_0
        //   121: getstatic 202	android/print/PageRange:ALL_PAGES	Landroid/print/PageRange;
        //   124: aastore
        //   125: aload 4
        //   127: aload 14
        //   129: invokevirtual 208	android/print/PrintDocumentAdapter$WriteResultCallback:onWriteFinished	([Landroid/print/PageRange;)V
        //   132: aload 5
        //   134: ifnull +8 -> 142
        //   137: aload 5
        //   139: invokevirtual 211	android/print/pdf/PrintedPdfDocument:close	()V
        //   142: aload_2
        //   143: ifnull +7 -> 150
        //   146: aload_2
        //   147: invokevirtual 212	android/os/ParcelFileDescriptor:close	()V
        //   150: return
        //   151: astore 11
        //   153: ldc -42
        //   155: ldc -40
        //   157: aload 11
        //   159: invokestatic 222	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   162: pop
        //   163: aload 4
        //   165: aconst_null
        //   166: invokevirtual 226	android/print/PrintDocumentAdapter$WriteResultCallback:onWriteFailed	(Ljava/lang/CharSequence;)V
        //   169: goto -37 -> 132
        //   172: astore 6
        //   174: aload 5
        //   176: ifnull +8 -> 184
        //   179: aload 5
        //   181: invokevirtual 211	android/print/pdf/PrintedPdfDocument:close	()V
        //   184: aload_2
        //   185: ifnull +7 -> 192
        //   188: aload_2
        //   189: invokevirtual 212	android/os/ParcelFileDescriptor:close	()V
        //   192: aload 6
        //   194: athrow
        //   195: astore 13
        //   197: return
        //   198: astore 7
        //   200: goto -8 -> 192
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	203	0	this	2
        //   0	203	1	paramAnonymousArrayOfPageRange	android.print.PageRange[]
        //   0	203	2	paramAnonymousParcelFileDescriptor	android.os.ParcelFileDescriptor
        //   0	203	3	paramAnonymousCancellationSignal	CancellationSignal
        //   0	203	4	paramAnonymousWriteResultCallback	android.print.PrintDocumentAdapter.WriteResultCallback
        //   18	162	5	localPrintedPdfDocument	android.print.pdf.PrintedPdfDocument
        //   172	21	6	localObject	Object
        //   198	1	7	localIOException1	IOException
        //   26	66	8	localPage	android.graphics.pdf.PdfDocument.Page
        //   43	21	9	localRectF	RectF
        //   72	12	10	localMatrix	Matrix
        //   151	7	11	localIOException2	IOException
        //   195	1	13	localIOException3	IOException
        //   116	12	14	arrayOfPageRange	android.print.PageRange[]
        // Exception table:
        //   from	to	target	type
        //   96	132	151	java/io/IOException
        //   20	96	172	finally
        //   96	132	172	finally
        //   153	169	172	finally
        //   146	150	195	java/io/IOException
        //   188	192	198	java/io/IOException
      }
    };
    PrintManager localPrintManager = (PrintManager)mContext.getSystemService("print");
    PrintAttributes.Builder localBuilder = new PrintAttributes.Builder();
    localBuilder.setColorMode(mColorMode);
    if (mOrientation == 1) {
      localBuilder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE);
    }
    for (;;)
    {
      localPrintManager.print(paramString, local2, localBuilder.build());
      return;
      if (mOrientation == 2) {
        localBuilder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_PORTRAIT);
      }
    }
  }
  
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
