package com.bmpl.speechtotextnew;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView txtSpeechInput;
    private ImageButton btnSpeak;

    protected static final int REQ_CODE_SPEECH_INPUT = 1;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            txtSpeechInput = (TextView) findViewById(R.id.txtSpeechInput);
            btnSpeak = (ImageButton) findViewById(R.id.btnSpeak);

            btnSpeak.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    promptSpeechInput();
                }
            });
        }

        private void promptSpeechInput()
        {
            Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

            //Starts an activity that will prompt the user for speech and
            // send it through a speech recognizer.
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                    RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);//us, chinese, canada, etc

            //EXTRA_LANGUAGE_MODEL: Informs the recognizer which speech model to
            // prefer when performing ACTION_RECOGNIZE_SPEECH.
            //LANGUAGE_MODEL_FREE_FORM: Use a language model based on free-form
            // speech recognition.
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

            //EXTRA_LANGUAGE: Optional IETF language tag (as defined by BCP 47), for example "en-US".
            intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                    getString(R.string.speech_prompt));

            //EXTRA_PROMPT: Optional text prompt to show to the user when asking them to speak.
            try {

                //Starting this intent with just startActivity(Intent) is not supported.
                // You must either use startActivityForResult(Intent, int), or provide a PendingIntent, to receive recognition results.
                startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
                txtSpeechInput.setText("");
            }
            catch (ActivityNotFoundException a) {
                Toast.makeText(getApplicationContext(),
                        getString(R.string.speech_not_supported),
                        Toast.LENGTH_SHORT).show();
            }
        }


        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }

        /**
         * Receiving speech input
         * */
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            switch (requestCode) {
                case REQ_CODE_SPEECH_INPUT: {
                    if (resultCode == RESULT_OK && null != data) {

                        ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                        txtSpeechInput.setText(result.get(0));
                    }
                    break;
                }
            }
        }
}