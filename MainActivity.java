package com.example.codebind.linkingactivities;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private Button createButton;
    Button btnViewRandomWorkout;
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);

        //navigate to view all workouts
        Button viewAllButton =(Button) findViewById(R.id.btnViewAllWorkouts);

        viewAllButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openViewAll();
            }
        });

        //navigate to add move page

        Button addMoveButton =(Button) findViewById(R.id.btnAddMove);

        addMoveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openAddMove();
            }
        });

        //navigate to edit move page

        Button editMoveButton =(Button) findViewById(R.id.btnEditAMove);

        editMoveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openEditMove();
            }
        });

        //navigate to delete move
        Button deleteMoveButton =(Button) findViewById(R.id.btnDeleteMove);

        deleteMoveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openDeleteAMove();
            }
        });

        //button to view random workouts
        btnViewRandomWorkout=(Button)findViewById(R.id.btnViewRandomWorkout);
        //view random workout instantiate function
        viewRandom();

    }



    public void openViewAll() {
        Intent intent = new Intent(this, viewAllWorkouts.class);
        startActivity(intent);
    }



    public void openEditMove() {
        Intent intent = new Intent(this, editAMove.class);
        startActivity(intent);
    }




    public void openAddMove() {
        Intent intent = new Intent(this, addAMove.class);
        startActivity(intent);
    }



    public void openDeleteAMove() {
        Intent intent = new Intent(this, deleteAMove.class);
        startActivity(intent);
    }

    public void viewRandom() {
        btnViewRandomWorkout.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //get record count from moves table to set upper random number limit
                        Cursor recordCount=myDb.getRecordCount();

                        //get random number using new upper limit
                        Random rand = new Random();

                        int newLow = recordCount.getCount();
                        int low = newLow;
                        int high = 17;
                        //first move
                        int n = rand.nextInt(high-low) + low;
                        String rand1=String.valueOf(n);
                        Cursor move1=myDb.getRandom(rand1);

                        //second move
                        int n2 = rand.nextInt(high-low) + low;
                        String rand2=String.valueOf(n2);
                        Cursor move2=myDb.getRandom(rand2);

                        //third move
                        int n3 = rand.nextInt(high-low) + low;
                        String rand3=String.valueOf(n3);
                        Cursor move3=myDb.getRandom(rand3);

                        //fourth move
                        int n4 = rand.nextInt(high-low) + low;
                        String rand4=String.valueOf(n4);
                        Cursor move4=myDb.getRandom(rand4);


                        //fifth move
                        int n5 = rand.nextInt(high-low) + low;
                        String rand5=String.valueOf(n5);
                        Cursor move5=myDb.getRandom(rand5);

                        //sixth move
                        int n6 = rand.nextInt(high-low) + low;
                        String rand6=String.valueOf(n6);
                        Cursor move6=myDb.getRandom(rand6);

                        StringBuffer buffer = new StringBuffer();

                        //append move 1 to buffer
                        if( move1 != null && move1.moveToFirst() ){
                            buffer.append("Type :"+ move1.getString(1)+"\n");
                            buffer.append("Name :"+ move1.getString(2)+"\n");
                            buffer.append("Move Description :"+ move1.getString(3)+"\n\n");
                        }

                        //append move 2 to buffer
                        if( move2 != null && move2.moveToFirst() ){
                            buffer.append("Type :"+ move2.getString(1)+"\n");
                            buffer.append("Name :"+ move2.getString(2)+"\n");
                            buffer.append("Move Description :"+ move2.getString(3)+"\n\n");
                        }

                        //append move 3 to buffer
                        if( move3 != null && move3.moveToFirst() ){
                            buffer.append("Type :"+ move3.getString(1)+"\n");
                            buffer.append("Name :"+ move3.getString(2)+"\n");
                            buffer.append("Move Description :"+ move3.getString(3)+"\n\n");
                        }

                        //append move 4 to buffer
                        if( move4 != null && move4.moveToFirst() ){
                            buffer.append("Type :"+ move4.getString(1)+"\n");
                            buffer.append("Name :"+ move4.getString(2)+"\n");
                            buffer.append("Move Description :"+ move4.getString(3)+"\n\n");
                        }

                        //append move 5 to buffer
                        if( move5 != null && move5.moveToFirst() ){
                            buffer.append("Type :"+ move5.getString(1)+"\n");
                            buffer.append("Name :"+ move5.getString(2)+"\n");
                            buffer.append("Move Description :"+ move5.getString(3)+"\n\n");
                        }

                        //append move 6 to buffer
                        if( move6 != null && move6.moveToFirst() ){
                            buffer.append("Type :"+ move6.getString(1)+"\n");
                            buffer.append("Name :"+ move6.getString(2)+"\n");
                            buffer.append("Move Description :"+ move6.getString(3)+"\n\n");
                        }




                        showMessage("Your Random Workout",buffer.toString());



/*                        while (res.moveToNext()) {
                            buffer.append("Id :"+ res.getString(0)+"\n");
                            buffer.append("Type :"+ res.getString(1)+"\n");
                            buffer.append("Name :"+ res.getString(2)+"\n");
                            buffer.append("Move Description :"+ res.getString(3)+"\n\n");
                        }*/

                        // Show all data
                        //showMessage("Random Number",buffer.toString());
                    }
                }
        );
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
