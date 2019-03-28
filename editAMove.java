package com.example.codebind.linkingactivities;

import android.app.AlertDialog;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class editAMove extends AppCompatActivity {


    Button btnFindMoveByName;
    DatabaseHelper myDb;
    EditText editType,editName,editMoveDesc ,editTextId, editMoveName;
    Button btnviewUpdate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_amove);
        myDb = new DatabaseHelper(this);
        btnFindMoveByName=(Button)findViewById(R.id.btnFindMoveByName);
        btnviewUpdate= (Button)findViewById(R.id.button_Update);
        editMoveName = (EditText)findViewById(R.id.txtEditMoveName) ;
        editType = (EditText)findViewById(R.id.editText_type);
        editName = (EditText)findViewById(R.id.editText_name);
        editMoveDesc = (EditText)findViewById(R.id.editText_Description);
        editTextId = (EditText)findViewById(R.id.editText_id);

        viewMoveToEdit();
        UpdateData();
    }




    public void viewMoveToEdit() {
        btnFindMoveByName.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String move = editMoveName.getText().toString();
                        Cursor res = myDb.getRecordToEdit(move);
                        if(res.getCount() == 0) {
                            // show message
                            showMessage("Error","Nothing found");
                            return;
                        }
                        if(res != null && res.moveToFirst()){
                            String idToEdit=res.getString(0);
                            String typeToEdit=res.getString(1);
                            String nameToEdit=res.getString(2);
                            String descToEdit=res.getString(3);

                           editTextId.setText(idToEdit);
                            editType.setText(typeToEdit);
                            editName.setText(nameToEdit);
                            editMoveDesc.setText(descToEdit)
                            ;
                        }


                    }
                }
        );
    }


    public void UpdateData() {
        btnviewUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = myDb.updateData(editTextId.getText().toString(),
                                editType.getText().toString(),
                                editName.getText().toString(),editMoveDesc.getText().toString());
                        String updatedMove;
                        updatedMove=editName.getText().toString();
                        if(isUpdate == true)
                            Toast.makeText(editAMove.this,"'"+updatedMove +"' Updated",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(editAMove.this,"Oops! '" +updatedMove + "' not Updated",Toast.LENGTH_LONG).show();
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
