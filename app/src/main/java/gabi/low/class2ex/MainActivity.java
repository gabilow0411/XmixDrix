package gabi.low.class2ex;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public  Model m;
    public TextView p1;
    public TextView p2;
    public  String pl1;
    public String pl2;
    public SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        p1 = findViewById(R.id.p2);
        p2 = findViewById(R.id.p1);
        Intent intent = getIntent();
        pl1 = intent.getStringExtra("first");
        pl2 = intent.getStringExtra("second");
        p1.setText(pl2+ "-X");
        p2.setText(pl1+ "-O");
        sharedPref = this.getSharedPreferences("myName", MODE_PRIVATE);
        if(!sharedPref.contains("score"))
        {
            SharedPreferences.Editor editor=sharedPref.edit();
            editor.putInt("score", 0);
            editor.commit();
        }
        // Connect all buttons to the same click handler
        for (int i = 1; i <= 9; i++) {
            String buttonID = "button" + i;
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            Button b = findViewById(resID);
            b.setOnClickListener(this);
        }
        //create board
         m = new Model();

    }

    @Override
    public void onClick(View view) {
        String tag = view.getTag().toString();
        System.out.println("tag"+tag);
        int row = tag.charAt(0)-'0';
        int column = tag.charAt(1)-'0';
        System.out.println("row"+row);
        System.out.println("colum"+column);
        Button clickedButton = (Button) view;
        Log.d("Android Seminar", "row: " + row + "column: " + column );
         tag = (String) view.getTag(); // read tag from the button
        String s = m.updateBoard(row,column);
        if ((!s.equals("n")))
            clickedButton.setText(s);
if(m.checkWin().equals("x")) {
    int score = sharedPref.getInt("score",0);
    score++;
    SharedPreferences.Editor editor=sharedPref.edit();
    editor.putInt("score", score);
    editor.commit();
    Toast.makeText(this, "the winner is  : " + pl2 + score, Toast.LENGTH_SHORT).show();
}
else if (m.checkWin().equals("o"))
    Toast.makeText(this, "the winner is : O " + pl1, Toast.LENGTH_SHORT).show();



        //Toast.makeText(this, "name 1: " + pl1, Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, "name 2: " + pl2, Toast.LENGTH_SHORT).show();
    }
}
