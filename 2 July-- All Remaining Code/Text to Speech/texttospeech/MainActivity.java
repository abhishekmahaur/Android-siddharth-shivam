package com.bmpl.texttospeechnew;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    private TextToSpeech textToSpeech;
    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textToSpeech = new TextToSpeech(MainActivity.this,this);

        button = (Button)findViewById(R.id.button);
        editText = (EditText)findViewById(R.id.editText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speakOut();
            }
        });
    }

    @Override
    public void onDestroy(){

        if(textToSpeech!=null){
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onDestroy();
    }

    @Override
    public void onInit(int status) {
        //0 == 0
        if(status == TextToSpeech.SUCCESS)
        {
            int result = textToSpeech.setLanguage(Locale.US);

            /*textToSpeech.setPitch(0.5f);
            textToSpeech.setSpeechRate(10.2f); */

            if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e(" TextToSpeech", "Language not supported");
                Toast.makeText(this," Language not supported.. Please provide proper data",Toast.LENGTH_LONG);
                button.setEnabled(false);
            }
            else{
                button.setEnabled(true);
                //speakOut();
            }
        }
        else {
            Log.e("TextToSpeech","Initialization Failed");
        }
    }

    private void speakOut()
    {
        String text = editText.getText().toString();
        //
        //textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH, null);
        String id = this.hashCode() + "" ;
        //app target nougat
        //API level - 21
        textToSpeech.speak(text , TextToSpeech.QUEUE_FLUSH, null, id);
    }
}