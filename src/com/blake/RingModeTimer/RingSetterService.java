package com.blake.RingModeTimer;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.IBinder;

public class RingSetterService extends Service 
{
    /** Called when the activity is first created. */
	
	private  RingSetter setterRing;
	private ScheduledThreadPoolExecutor executor;
	
	public static AudioManager managerAudio;
	
	public void onCreate()
	{
		super.onCreate();
	    String strAudio = Context.AUDIO_SERVICE;
	    managerAudio = (AudioManager) getSystemService(strAudio);
	    executor = new ScheduledThreadPoolExecutor(1);
	    setterRing = new RingSetter(AudioManager.RINGER_MODE_NORMAL);	
	}
	
	@Override
	public IBinder onBind(Intent arg0) 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	public void onStart(Intent intent, int startId) 
	{
		super.onStart(intent, startId); 
		int nDelayTime = intent.getIntExtra("DelayTime", 3600000);
		SetRingTimer(nDelayTime);
	}
	
	@Override
	public void onDestroy()
	{
		
	}
	
    void SetRingTimer(int Milliseconds)
    {
    	//managerAudio.setRingerMode(AudioManager.RINGER_MODE_SILENT);
    	try
    	{
	    	if(0 < executor.getQueue().size())
	    	{
	    		executor.shutdown();
	    	}
	    	
	    	executor.schedule(setterRing, Milliseconds, TimeUnit.MILLISECONDS);
    	}
    	catch(Exception ex)
    	{
    		String strMsg = ex.getMessage();
    	}
    	
    	
    }
    

}
