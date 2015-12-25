package com.example.g0274.fragment;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by g0274 on 2015/12/25.
 */
public class LeaveAdd extends AppCompatActivity {
    private DBHelper DH = null;
    static TextView names,dates,contents;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leave_add);
        ButtonClickListener listener=new ButtonClickListener();
        this.findViewById(R.id.add).setOnClickListener(listener);
        names=(TextView)findViewById(R.id.names);
        dates=(TextView)findViewById(R.id.dates);
        contents=(TextView)findViewById(R.id.contents);
        openDB();
    }
    private void add(String Title,String Content,String Kind){
        SQLiteDatabase db = DH.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("_NAME", names.getText().toString().trim());
        values.put("_DATE", dates.getText().toString().trim());
        values.put("_CONTENT", contents.getText().toString().trim());
        values.put("_STATE", "N");
        db.insert("Leave", null, values);
    }
    private void openDB(){
        DH = new DBHelper(this);
    }
    private void closeDB(){
        DH.close();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        closeDB();
    }

    class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if(v.getId()==R.id.add) {
            }
        }
    }
}

