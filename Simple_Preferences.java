package com.sukohi.lib;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

public class Simple_Preferences {

	public static final String DEFAULT_VALUE_STRING = "";
	public static final int DEFAULT_VALUE_INT = -1;
	public static final long DEFAULT_VALUE_LONG = -1;
	public static final boolean DEFAULT_VALUE_BOOLEAN = false;
	private SharedPreferences preferences;
	private SharedPreferences.Editor editor;
	
	public Simple_Preferences(Context context, String name, int mode) {
		
		preferences = context.getSharedPreferences(name, mode);
		
	}
	
	public void setString(String key, String value) {
		
		setBegin();
        editor.putString(key, value);
        setCommit();
		
	}
	
	public void setInt(String key, int value) {
		
		setBegin();
        editor.putInt(key, value);
        setCommit();
		
	}
	
	public void setLong(String key, long value) {
		
		setBegin();
        editor.putLong(key, value);
        setCommit();
		
	}
	
	public void setBoolean(String key, boolean value) {
		
		setBegin();
        editor.putBoolean(key, value);
        setCommit();
		
	}
	
	@SuppressLint("CommitPrefEdits")
	private void setBegin() {
		
		editor = preferences.edit();
		
	}
	
	private void setCommit() {
		
		editor.commit();
		
	}
	
	public String getString(String key) {
		
		return preferences.getString(key, DEFAULT_VALUE_STRING);
		
	}
	
	public int getInt(String key) {
		
		return preferences.getInt(key, DEFAULT_VALUE_INT);
		
	}
	
	public long getLong(String key) {
		
		return preferences.getLong(key, DEFAULT_VALUE_LONG);
		
	}
	
	public boolean getBoolean(String key) {
		
		return preferences.getBoolean(key, DEFAULT_VALUE_BOOLEAN);
		
	}
	
	public SharedPreferences getPreferences() {
		
		return preferences;
		
	}
	
}
/*** Example 

	Simple_Preferences sp = new Simple_Preferences(this, "user_data", Activity.MODE_PRIVATE);
		
	sp.setString("string_key", "string");
	sp.setInt("int_key", 99);
	sp.setLong("long_key", 999);
	sp.setBoolean("boolean_key", true);

	Log.v("String", sp.getString("string_key"));
	Log.v("int", ""+ sp.getInt("int_key"));
	Log.v("long", ""+ sp.getLong("long_key"));
	Log.v("boolean", ""+ sp.getBoolean("boolean_key"));
	
	SharedPreferences preferences = sp.getPreferences();

***/
