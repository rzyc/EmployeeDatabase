package compsci.application.earchallenger;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import android.graphics.Color;
import android.hardware.SensorManager;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class AppActivity extends Activity {

	//
	// Fields and variables
	//

	final Context context = this;
	
	SensorManager sensorManager;
	
	Random random = new Random();
	double ph = 0.0;
	final int amp = 22000;
	final double twopi = 8. * Math.atan(1.);
	final double base = 1.059463094359;
	int sr = 44100;
	int buffsize = 66150;

	double frequency;
	double nextFrequency;

	String[] intervals = { "Perfect Unison", "Minor 2nd", "Major 2nd",
			"Minor 3rd", "Major 3rd", "Perfect 4th", "Augmented 4th",
			"Perfect 5th", "Minor 6th", "Major 6th", "Minor 7th", "Major 7th",
			"Perfect Octave" };

	AudioTrack audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC, sr,
			AudioFormat.CHANNEL_OUT_MONO, AudioFormat.ENCODING_PCM_16BIT,
			buffsize, AudioTrack.MODE_STREAM);
	short samples[] = new short[buffsize];

	TextView score;
	TextView answer;
	TextView temp;

	int total = 0;
	int correct = 0;

	int currentInterval = -1;

	//
	// Methods
	//

	public void pickInterval(View view) {
		if (currentInterval < 0) {
		} else {
			int pickedInterval = Integer.parseInt((String) view.getTag());
			if (currentInterval == pickedInterval) {
				correct++;
				answer.setTextColor(Color.GREEN);
				answer.setText("Correct!");
			} else {
				answer.setTextColor(Color.RED);
				answer.setText("Wrong! It was a " + intervals[currentInterval]);
			}
			total++;
			setScore();
			currentInterval = -1;
		}
	}

	public void setScore (){
		score.setText(Integer.toString(correct) + "/" + Integer.toString(total));
	}
	
	public void playInterval(View view) {

		answer.setText("");
		
		if (currentInterval == -1) {
			currentInterval = random.nextInt(11);
			int shift = random.nextInt(11);

			frequency = 440 * Math.pow(base, shift);
			nextFrequency = 440 * Math.pow(base, shift + currentInterval);
		}
		
		double note[] = { frequency, nextFrequency };
		
		for (int i = 0; i < 2; i++) {
			audioTrack.play();

			for (int ii = 0; ii < buffsize; ii++) {
				samples[ii] = (short) (amp * Math.sin(ph));
				ph += twopi * note[i] / sr;
			}
			audioTrack.write(samples, 0, buffsize);

			audioTrack.stop();

			try {
				TimeUnit.MILLISECONDS.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public void reset (View view){
		total = 0;
		correct = 0;
		setScore();
		answer.setText("");
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_app);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		score = (TextView) findViewById(R.id.score);
		answer = (TextView) findViewById(R.id.answer);
	}
	
	public void switchModes1(View arg0) {
		 
	    Intent intent = new Intent(context, App2Activity.class);
                    startActivity(intent);   

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.app, menu);
		return true;
	}
}