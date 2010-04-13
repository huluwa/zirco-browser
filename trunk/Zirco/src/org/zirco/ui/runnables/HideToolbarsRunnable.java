package org.zirco.ui.runnables;

import org.zirco.ui.IToolbarsContainer;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class HideToolbarsRunnable implements Runnable {
	
	private final static String TAG = "HideToolbarsRunnable";
	
	private IToolbarsContainer mParent;
	private boolean mDisabled;
	private int mDelay;
	
	public HideToolbarsRunnable(IToolbarsContainer parent, int delay) {
		mParent = parent;
		mDisabled = false;
		mDelay = delay;
	}
	
	private Handler mHandler = new Handler() {				
		
		public void handleMessage(Message msg) {
			if ((mParent != null) &&
					(!mDisabled)) {
				mParent.hideToolbars();
			}
		}
	};
	
	public void setDisabled() {
		mDisabled = true;
	}
	
	public void run() {
		try {
			
			Thread.sleep(mDelay);
			
			mHandler.sendEmptyMessage(0);
			
		} catch (InterruptedException e) {
			Log.w(TAG, "Exception in thread: " + e.getMessage());
			
			mHandler.sendEmptyMessage(0);
		}
	}

}
