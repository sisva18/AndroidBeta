package com.example.a5x5prototype;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class EditActivity extends AppCompatActivity {


    private Button btnSave,btnDelete;
    private EditText editable_item;
    EditActivity editDataActivity;
    DatabaseHelper mDatabaseHelper;

    private String selectedName;
    private int selectedID;
    private String selectedTable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        editable_item = (EditText) findViewById(R.id.editable_item);
        mDatabaseHelper = DatabaseHelper.getInstance(this);

        //get the intent extra from the ListDataActivity
        Bundle receivedIntent = getIntent().getExtras();

        //now get the itemID we passed as an extra
        selectedID = receivedIntent.getInt("id");

        //now get the name we passed as an extra
        selectedName = receivedIntent.getString("name");

        //get table pass as an extra
        selectedTable = receivedIntent.getString("table");

        //set the text to show the current selected name
        editable_item.setText(selectedName);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item = editable_item.getText().toString();
                if(!item.equals("")){
                    mDatabaseHelper.updateName(selectedTable, item, selectedID, selectedName);
                    //finish();
                    //refreshList();
                    onBackPressed();
                }else{
                    toastMessage("You must enter a max");
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDatabaseHelper.deleteName(selectedTable, selectedID, selectedName);
                editable_item.setText("");
                toastMessage("removed from maxes");
                //finish();
                //refreshList();
                onBackPressed();
            }
        });

    }

    /**
     * customizable toast
     * @param message
     */
    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }

    private void refreshList(){
        Intent intent=new Intent(this, ListDataActivity.class);
        overridePendingTransition( 0, 0);
        startActivity(intent);
        overridePendingTransition( 0, 0);
        finish();
    }


}

