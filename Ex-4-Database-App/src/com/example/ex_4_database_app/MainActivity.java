//Necessary Packages
package com.example.ex_4_database_app;


//Necessary Imports
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


//MainActivity Class
public class MainActivity extends Activity implements OnClickListener  {
	EditText editName,editEmpid,editsalary;
	Button btnAdd,btnDelete,btnModify,btnView,btnViewAll,btnReset;
	SQLiteDatabase db;
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
	editEmpid=(EditText)findViewById(R.id.editTex1);
	editName=(EditText)findViewById(R.id.editTex3);
	editsalary=(EditText)findViewById(R.id.editTex2);
	btnAdd=(Button)findViewById(R.id.button1);
	btnDelete=(Button)findViewById(R.id.button2);
	btnModify=(Button)findViewById(R.id.button5);
	btnView=(Button)findViewById(R.id.button3);
	btnViewAll=(Button)findViewById(R.id.button4);
	btnReset=(Button)findViewById(R.id.button6);
	btnAdd.setOnClickListener(this);
	btnDelete.setOnClickListener(this);
	btnModify.setOnClickListener(this);
	btnView.setOnClickListener(this);
	btnViewAll.setOnClickListener(this);
	db=openOrCreateDatabase("EmployeeDB", Context.MODE_PRIVATE, null);
	db.execSQL("CREATE TABLE IF NOT EXISTS employee(empid VARCHAR,name VARCHAR,salary VARCHAR);");
	}
	public void onClick(View view)
	{
	if(view==btnAdd)
	{
	if((editEmpid.getText().toString().trim().length()==0)||(editName.getText().toString().trim().length()==0)||(editsalary.getText().toString().trim().length()==0))
	{
	showMessage("Error", "Please enter all values");
	return;
	}
	db.execSQL("INSERT INTO employee VALUES('"+editEmpid.getText()+"','"+editName.getText()+"','"+editsalary.getText()+"');");
	showMessage("Success", "Record added");
	clearText();
	}
	if(view==btnDelete)
	{
	if(editEmpid.getText().toString().trim().length()==0)
	{
	showMessage("Error", "Please enter Employee id");
	return; }
	Cursor c=db.rawQuery("SELECT * FROM employee WHERE empid='"+editEmpid.getText()+"'", null);
	if(c.moveToFirst())
	{
	db.execSQL("DELETE FROM employee WHERE empid='"+editEmpid.getText()+"'");
	showMessage("Success", "Record Deleted");
	} else
	{
	showMessage("Error", "Invalid Employee id");
	}
	clearText();
	}
	if(view==btnModify)
	{
	if(editEmpid.getText().toString().trim().length()==0)
	{
	showMessage("Error", "Please enter Employee id");
	return;
	}
	Cursor c=db.rawQuery("SELECT * FROM employee WHERE empid='"+editEmpid.getText()+"'", null);
	if(c.moveToFirst())
	{
	db.execSQL("UPDATE employee SET name='"+editName.getText()+"',salary='"+editsalary.getText()+ "' WHERE empid='"+editEmpid.getText()+"'");
	showMessage("Success", "Record Modified");
	}
	else
	{
	showMessage("Error", "Invalid Rollno");
	}
	clearText();
	}
	if(view==btnView)
	{
	if(editEmpid.getText().toString().trim().length()==0)
	{
	showMessage("Error", "Please enter Employee id");
	return;
	}
	Cursor c=db.rawQuery("SELECT * FROM employee WHERE empid='"+editEmpid.getText()+"'", null);
	if(c.moveToFirst())
	{
	editName.setText(c.getString(1));
	editsalary.setText(c.getString(2));
	}
	else
	{
	showMessage("Error", "Invalid Employee id");
	clearText();
	}
	}
	if(view==btnViewAll)
	{
	Cursor c=db.rawQuery("SELECT * FROM employee", null);
	if(c.getCount()==0)
	{
	showMessage("Error", "No records found"); return;
	}
	StringBuffer buffer=new StringBuffer(); while(c.moveToNext())
	{
	buffer.append("Employee id: "+c.getString(0)+"\n");
	buffer.append("Name: "+c.getString(1)+"\n");
	buffer.append("salary: "+c.getString(2)+"\n\n");
	}
	showMessage("Employee details Details", buffer.toString());
	}
	}
	public void showMessage(String title,String message)
	{
	Builder builder=new Builder(this);
	builder.setCancelable(true); builder.setTitle(title);
	builder.setMessage(message);
	builder.show();
	}
	public void clearText()
	{
	editEmpid.setText(""); editName.setText("");
	editsalary.setText("");
	editEmpid.requestFocus();
	}
	}
