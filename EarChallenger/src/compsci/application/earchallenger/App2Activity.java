package compsci.application.earchallenger;

import android.app.Activity;
import android.widget.TextView;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.View;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.hardware.SensorManager;
import android.util.Log;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.MediaRecorder;
import android.media.MediaPlayer;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class App2Activity extends Activity
{
	final Context context = this;
	
	private static final String LOG_TAG = "AudioRecordTest";
    private static String mFileName = null;

    private MediaRecorder mRecorder = null;

    private MediaPlayer mPlayer = null;
	
	SensorManager sensorManager;
	
	Random random = new Random();
	double ph = 0.0;
	final int amp = 22000;
	final double twopi = 8. * Math.atan(1.);
	final double base = 1.059463094359;
	int sr = 44100;
	int buffsize = 66150;
	int shift = 44100;

	double frequency;
	double nextFrequency;
	
	boolean recing = false;
	boolean playing = false;

	String[] intervals = { "Perfect Unison", "Minor 2nd", "Major 2nd",
			"Minor 3rd", "Major 3rd", "Perfect 4th", "Augmented 4th",
			"Perfect 5th", "Minor 6th", "Major 6th", "Minor 7th", "Major 7th",
			"Perfect Octave" };

	AudioTrack audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC, sr,
			AudioFormat.CHANNEL_OUT_MONO, AudioFormat.ENCODING_PCM_16BIT,
			buffsize, AudioTrack.MODE_STREAM);
	short samples[] = new short[buffsize];
	TextView inv;
	TextView temp;
	TextView msg;
	TextView rec;
	int currentInterval = -1;

	//
	// Methods
	//
	
	public void playNote(View view) {
		msg.setText("");
		if (playing){
			onPlay (false);
			playing = false;
		}
		if (currentInterval == -1) {
			currentInterval = random.nextInt(11);
			shift = random.nextInt(11);
			String iv = new String(intervals[currentInterval]);
			inv.setText(iv);
			frequency = 440 * Math.pow(base, shift);
		}
		
		double note = frequency;
		
		for (int i = 0; i < 2; i++) {
			audioTrack.play();

			for (int ii = 0; ii < buffsize; ii++) {
				samples[ii] = (short) (amp * Math.sin(ph));
				ph += twopi * note / sr;
			}
			audioTrack.write(samples, 0, buffsize);

			audioTrack.stop();

			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void playInterval (View view) {
		if (currentInterval != -1) {
			nextFrequency = 440 * Math.pow(base, shift + currentInterval);
			if (playing){
				onPlay (false);
				playing = false;
			}
			double note = nextFrequency;
		
			for (int i = 0; i < 2; i++) {
				audioTrack.play();

				for (int ii = 0; ii < buffsize; ii++) {
					samples[ii] = (short) (amp * Math.sin(ph));
					ph += twopi * note / sr;
				}
				audioTrack.write(samples, 0, buffsize);

				audioTrack.stop();

				try {
					TimeUnit.MILLISECONDS.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void reset (View view){
		msg.setText("Please press Play Starting Note");
		currentInterval = -1;
		inv.setText("");
		if (playing){
			onPlay (false);
			playing = false;
		}
		if (recing){
    		onRecord(false);
    		recing = false;
    	}
	}

    private void onRecord(boolean start) {
        if (start) {
            startRecording();
        } else {
            stopRecording();
        }
    }

    private void onPlay(boolean start) {
        if (start) {
            startPlaying();
        } else {
            stopPlaying();
        }
    }

    private void startPlaying() {
        mPlayer = new MediaPlayer();
        try {
            mPlayer.setDataSource(mFileName);
            mPlayer.prepare();
            mPlayer.start();
        } catch (IOException e) {
            Log.e(LOG_TAG, "prepare() failed");
        }
    }

    private void stopPlaying() {
        mPlayer.release();
        mPlayer = null;
    }

    private void startRecording() {
        mRecorder = new MediaRecorder();
        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mRecorder.setOutputFile(mFileName);
        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        try {
            mRecorder.prepare();
        } catch (IOException e) {
            Log.e(LOG_TAG, "prepare() failed");
        }

        mRecorder.start();
    }

    private void stopRecording() {
        mRecorder.stop();
        mRecorder.release();
        mRecorder = null;
    }
    
    public void sRec(View view) {
    	if (playing){
			onPlay (false);
			playing = false;
		}
    	if (!recing){
    		onRecord(true);
    		recing = true;
    	}
    }
    
    public void eRec(View view) {
    	if (playing){
			onPlay (false);
			playing = false;
		}
    	if (recing){
    		onRecord(false);
    		recing = false;
    	}
    }
    
    public void sPlay(View view) {
    	if (playing){
			onPlay (false);
			playing = false;
		}
    	if (!playing){
    		onPlay(true);
    		playing = true;
    	}
    }
    
    public App2Activity() {
        mFileName = Environment.getExternalStorageDirectory().getAbsolutePath();
        mFileName += "/VocalTrainer.3gp";
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_app2);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		msg = (TextView) findViewById(R.id.msg);
		inv = (TextView) findViewById(R.id.iv);
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mRecorder != null) {
            mRecorder.release();
            mRecorder = null;
        }

        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
        }
    }
    
    public void switchModes2(View arg0) {
    	 
	    Intent intent = new Intent(context, AppActivity.class);
                    startActivity(intent);   

	}
    
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.app, menu);
		return true;
	}
}