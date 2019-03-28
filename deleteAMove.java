package com.example.codebind.linkingactivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class deleteAMove extends AppCompatActivity {


    DatabaseHelper myDb;
    EditText deleteMoveName;
    Button btnDeleteMove;








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_amove);
        myDb = new DatabaseHelper(this);
        deleteMoveName = (EditText)findViewById(R.id.txtMoveToDelete);

        btnDeleteMove = (Button)findViewById(R.id.btnDeleteThisMove);


        DeleteData();



    }

    public void DeleteData() {
        btnDeleteMove.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String deletedMove;
                        Integer deletedRows = myDb.deleteData(deleteMoveName.getText().toString());
                        deletedMove=deleteMoveName.getText().toString();
                        if(deletedRows > 0)
                            Toast.makeText(deleteAMove.this,"Goodbye, '"+deletedMove+"'!",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(deleteAMove.this,"Oops! '"+deletedMove+"' Not Deleted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }



}
