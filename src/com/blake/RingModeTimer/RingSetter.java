package com.blake.RingModeTimer;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import com.blake.RingModeTimer.RingModeTimer;


public class RingSetter implements Runnable
{
	public static int modeRinger = AudioManager.RINGER_MODE_NORMAL;	

	
	public RingSetter(int RingMode)
	{
		modeRinger = RingMode;

	}
	
	public void run()
	{
		RingSetterService.managerAudio.setRingerMode(modeRinger);
	}
	
}