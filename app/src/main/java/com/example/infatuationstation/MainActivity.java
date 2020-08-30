package com.example.infatuationstation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView textView, textView2;
    EditText editText, editText2;
    ImageView imageView4;

    Button computeButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView4 = findViewById(R.id.imageView4);
        textView = findViewById(R.id.textView);
        textView2=findViewById(R.id.textView2);
        editText=findViewById(R.id.editText);
        editText2=findViewById(R.id.editText2);
        computeButton=findViewById(R.id.computeButton);

        textView2.setText("Enter the name of your infatuation");
        //textView2.setText("If you lost, perhaps you misspelled your own name wrong?");

        computeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (computeButton.getText().equals("Match")) {
                    computeButton.setText("Find");
                } else {
                    if (computeButton.getText().equals("Find")) {
                        computeButton.setText("Catch");
                    } else {
                        if (computeButton.getText().equals("Catch")) {
                            computeButton.setText("Match");
                        }
                    }
                }

                String name1 = editText.getText().toString().toLowerCase();
                String name2 = editText2.getText().toString().toLowerCase();

                if (editText.getText() == null || editText.getText().toString().equals(""))
                {
                    if (textView.getText() == "If you don't have a name, I'll give you one") {
                        editText.setText("Professor Hidgens");
                    } else {
                        textView.setText("If you don't have a name, I'll give you one");
                    }
                }
                //##############################################################
                else {
                    if (editText2.getText() == null || editText2.getText().toString().equals("")) {
                        if (textView2.getText() == "If you don't pick someone, I will") {
                            Random ran = new Random();
                            // Obtain a number between [0 - 5].
                            int n = ran.nextInt(5);

                            switch (n) {
                                // case statements
                                // values must be of same type of expression
                                case 0:
                                    // Statements
                                    editText2.setText("Greg");
                                    break; // break is optional

                                case 1:
                                    // Statements
                                    editText2.setText("Steve");
                                    break; // break is optional

                                case 2:
                                    // Statements
                                    editText2.setText("Stu");
                                    break; // break is optional

                                case 3:
                                    // Statements
                                    editText2.setText("Mark");
                                    break; // break is optional

                                case 4:
                                    // Statements
                                    editText2.setText("Leighton");
                                    break; // break is optional

                                case 5:
                                    // Statements
                                    editText2.setText("Chad");
                                    break; // break is optional

                                // We can have any number of case statements
                                // below is default statement, used when none of the cases is true.
                                // No break is needed in the default case.
                                default:
                                    // Statements
                                    editText2.setText("Greg");
                            }

                        } else {
                            textView2.setText("If you don't pick someone, I will");
                        }
                    } else {

            /*
            if (name2.charAt( (name2.charAt(name2.length() - 1))) == 'a') {
                    textView2.setText("Is that a girl name?");
            }

            if (name2.charAt(name2.length() - 1) == 'o') {
                    textView2.setText("That sounds like a boy name.");
            }
            */

                        //############################################
                        int score = 0;
                        int total = name1.length() + name2.length();

                        for (int i = 0; i < name1.length() - 1; i++) {
                            for (int j = 0; j < name2.length() - 1; j++) {
                                if (name1.charAt(i) == name2.charAt(j)) {
                                    score++;
                                }
                            }
                        }
                        //  for (int i = 0; i < name1.length()-1; i++)
                        // {
                        //Toast.makeText(MainActivity.this, name1.charAt(i), Toast.LENGTH_SHORT).show();
                        // for (int j = 0; j < name1.length()-1; j++)
                        //  {
                                /*
                                String test = "";
                                test+= name1.charAt(i);
                                String test2 = "";
                                test2+= name2.charAt(j);
                                Toast.makeText(MainActivity.this, test, Toast.LENGTH_SHORT).show();
                                   */

                        //   Toast.makeText(MainActivity.this, name2.charAt(j), Toast.LENGTH_SHORT).show();

                        // if((name1.charAt(i)) == name2.charAt(j)) {
                        //    score++;
                        //  }
                        //Toast.makeText(MainActivity.this, name1 + ": CharAt"+i+" = "+  name1.charAt(i) + ", " + name2 +  ": CharAt"+j+" = " + name2.charAt(j) , Toast.LENGTH_SHORT).show();

                        // }
                        //}
                        //int i = 16, j = name2.length()-1;
                        //Toast.makeText(MainActivity.this, name1 + ": CharAt"+i+" = "+  name1.charAt(i) + ", " + name2 +  ": CharAt"+j+" = " + name2.charAt(j) , Toast.LENGTH_SHORT).show();

                        //Toast.makeText(MainActivity.this, name1 + ": "+  name1.length() + ", " + name2 + ": " + name2.length(), Toast.LENGTH_SHORT).show();


                        if (score == total) {
                            textView2.setText("I think the idea is to check your compatibility with someone else...");

                        }

                        Toast.makeText(MainActivity.this, name1 + " " + name2 + " Total:" + total + " Score:" + score, Toast.LENGTH_SHORT).show();

                        float scorepio;

                        if (name1 != null && name2 != null) {
                            scorepio = (float) score / total;
                        } else {
                            scorepio = (float) 0.0;
                            textView2.setText("Enter names in both sections");
                        }

                        if (name1 == name2) {
                            textView2.setText("I think the idea is to check your compatibility with someone else...");
                            scorepio = (float) 0.01;
                        }
                        //textView2.setText("Score: "+ scorepio);
                        Toast.makeText(getApplicationContext(), "Score: " + scorepio, Toast.LENGTH_SHORT).show();
                        RotateAnimation rot = new RotateAnimation(0, (360 + scorepio * 100 - 50),
                                Animation.RELATIVE_TO_SELF, 0.5f,
                                Animation.RELATIVE_TO_SELF, 1f);

                        rot.setFillAfter(true);
                        rot.setDuration(2000);
                        rot.setInterpolator(new AccelerateDecelerateInterpolator());
                        imageView4.startAnimation(rot);

                        Random rando = new Random();

                        // Obtain a number between [0 - 4].
                        int n = rando.nextInt(5);

                        if (scorepio <= 0.5) {
                            switch (n) {
                                // case statements
                                // values must be of same type of expression

                                case 0:
                                    // Statements
                                    textView2.setText("Maybe if you try again, the mathematical formula's output will be different");
                                    break; // break is optional

                                case 1:
                                    // Statements
                                    textView2.setText("Time to get a cat");
                                    break; // break is optional

                                case 2:
                                    // Statements
                                    textView2.setText("Change your name to something better");
                                    break; // break is optional

                                case 3:
                                    // Statements
                                    textView2.setText("Abandon all hope, ye who enter");
                                    break;

                                case 4:
                                    // Statements
                                    textView2.setText("If you lost, perhaps you misspelled your own name wrong?");
                                    break;
                                // We can have any number of case statements
                                // below is default statement, used when none of the cases is true.
                                // No break is needed in the default case.
                                default:
                                    // Statements
                                    textView2.setText("If you lost, perhaps you misspelled your own name wrong?");
                            }
                        } else {
                            if (scorepio >= 0) {
                                textView2.setText("Winner winner, ask them to dinner");
                            } else {
                                textView2.setText("Try Asking Again");
                            }
                        }
                    }
                }


            }


        });

    }
}
