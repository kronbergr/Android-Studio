package com.example.codebind.linkingactivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addAMove extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText addMoveType,addMoveName,addMoveDesc;
    Button btnAddData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_amove);
        myDb = new DatabaseHelper(this);



        addMoveType = (EditText)findViewById(R.id.txtAddMoveType);
        addMoveName = (EditText)findViewById(R.id.txtAddMoveName);
        addMoveDesc = (EditText)findViewById(R.id.txtAddMoveDesc);

        btnAddData = (Button)findViewById(R.id.btnAddNewMove);

        AddData();


    }


    public  void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(addMoveType.getText().toString(),
                                addMoveName.getText().toString(),
                                addMoveDesc.getText().toString() );
                        String addedMove=addMoveName.getText().toString();
                        if(isInserted == true)
                            Toast.makeText(addAMove.this,"'"+addedMove + "'added!  ",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(addAMove.this,"Oops!'"+ addedMove + "'  not added",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }





}
