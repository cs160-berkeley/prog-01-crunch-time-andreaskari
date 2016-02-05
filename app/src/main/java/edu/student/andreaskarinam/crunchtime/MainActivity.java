package edu.student.andreaskarinam.crunchtime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner exercise_list;
    EditText text_box;
    TextView text_box_label;
    TextView calories_label;

    TextView pushup_calories_label;
    TextView situp_calories_label;
    TextView jumping_jack_calories_label;
    TextView jogging_calories_label;

    String selected_exercise = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exercise_list = (Spinner) findViewById(R.id.spinner);
        text_box = (EditText) findViewById(R.id.editText);
        text_box_label = (TextView) findViewById(R.id.textView);
        calories_label = (TextView) findViewById(R.id.textView2);
        pushup_calories_label = (TextView) findViewById(R.id.textView5);
        situp_calories_label = (TextView) findViewById(R.id.textView6);
        jumping_jack_calories_label = (TextView) findViewById(R.id.textView7);
        jogging_calories_label = (TextView) findViewById(R.id.textView8);

//        String[] exercises = {"Pushups", "Situps", "Squats", "Leg-Lifts", "Planks", "Jumping Jacks", "Pull Ups", "Cycling", "Walking", "Jogging", "Swimming"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, exercises);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.exercises, android.R.layout.simple_spinner_item);

        exercise_list.setAdapter(adapter);
        exercise_list.setOnItemSelectedListener(this);



        text_box.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {

            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                double calories = 0.0;
                if (!s.toString().equals("")) {
                    double number = Double.parseDouble(s.toString());
//                    System.out.println(number);
                    double calorie_conversion = 0;
                    if (selected_exercise.equals("Pushups")) {
                        calorie_conversion = (double) 100 / 350;
                    } else if (selected_exercise.equals("Situps")) {
                        calorie_conversion = (double) 100 / 200;
                    } else if (selected_exercise.equals("Squats")) {
                        calorie_conversion = (double) 100 / 225;
                    } else if (selected_exercise.equals("Leg-Lifts")) {
                        calorie_conversion = (double) 100 / 25;
                    } else if (selected_exercise.equals("Planks")) {
                        calorie_conversion = (double) 100 / 25;
                    } else if (selected_exercise.equals("Jumping Jacks")) {
                        calorie_conversion = (double) 100 / 10;
                    } else if (selected_exercise.equals("Pull Ups")) {
                        calorie_conversion = (double) 100 / 100;
                    } else if (selected_exercise.equals("Cycling")) {
                        calorie_conversion = (double) 100 / 12;
                    } else if (selected_exercise.equals("Walking")) {
                        calorie_conversion = (double) 100 / 20;
                    } else if (selected_exercise.equals("Jogging")) {
                        calorie_conversion = (double) 100 / 12;
                    } else if (selected_exercise.equals("Swimming")) {
                        calorie_conversion = (double) 100 / 13;
                    } else if (selected_exercise.equals("Stair-Climbing")) {
                        calorie_conversion = (double) 100 / 15;
                    }
                    calories = number * calorie_conversion;
                }
                calories_label.setText( (int) calories + " Calories");
                pushup_calories_label.setText((int) (calories * (double) 350 / 100) + " Pushups");
                situp_calories_label.setText((int) (calories * (double) 200 / 100) + " Situps");
                jumping_jack_calories_label.setText((int) (calories * (double) 10 / 100) + " minutes of Jumping Jacks");
                jogging_calories_label.setText((int) (calories * (double) 12 / 100) + " minutes of Jogging");
            }
        });
    }

    @Override
    public void onItemSelected (AdapterView<?> parent, View view, int position, long id) {
        TextView myText = (TextView) view;
        text_box.setText("");
        selected_exercise = new String(myText.getText().toString());
//        System.out.println(selected_exercise);
        String minutes_label = "Enter time in minutes:";
        String reps_label = "Enter number of reps:";
        if (selected_exercise.equals("Pushups")) {
            text_box_label.setText(reps_label);
        } else if (selected_exercise.equals("Situps")) {
            text_box_label.setText(reps_label);

        } else if (selected_exercise.equals("Squats")) {
            text_box_label.setText(reps_label);

        } else if (selected_exercise.equals("Leg-Lifts")) {
            text_box_label.setText(minutes_label);

        } else if (selected_exercise.equals("Planks")) {
            text_box_label.setText(minutes_label);

        } else if (selected_exercise.equals("Jumping Jacks")) {
            text_box_label.setText(minutes_label);

        } else if (selected_exercise.equals("Pull Ups")) {
            text_box_label.setText(reps_label);

        } else if (selected_exercise.equals("Cycling")) {
            text_box_label.setText(minutes_label);

        } else if (selected_exercise.equals("Walking")) {
            text_box_label.setText(minutes_label);

        } else if (selected_exercise.equals("Jogging")) {
            text_box_label.setText(minutes_label);

        } else if (selected_exercise.equals("Stair-Climbing")) {
            text_box_label.setText(minutes_label);
        }
    }

    @Override
    public void onNothingSelected (AdapterView<?> parent) {

    }
}
