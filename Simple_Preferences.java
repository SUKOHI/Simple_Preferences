package com.sukohi.lib;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class Simple_Preferences {

	public static final String DEFAULT_VALUE_STRING = "";
	public static final int DEFAULT_VALUE_INT = -1;
	public static final long DEFAULT_VALUE_LONG = -1;
	public static final boolean DEFAULT_VALUE_BOOLEAN = false;
	private Context context;
	private String preferencesName = "";
	private SharedPreferences preferences;
	private SharedPreferences.Editor editor;
	
	public Simple_Preferences(Context context, String preferencesName) {
		
		this.context = context;
		this.preferencesName = preferencesName;
		preferences = context.getSharedPreferences(preferencesName, Activity.MODE_PRIVATE);
		
	}
	
	public void setMode(int mode) {
		
		preferences = context.getSharedPreferences(this.preferencesName, mode);
		
	}
	
	public void set(String key, String value) {
		
		_set(key, value);
		
	}
	
	public void set(String key, int value) {
		
		_set(key, String.valueOf(value));
		
	}
	
	public void set(String key, long value) {
		
		_set(key, String.valueOf(value));
		
	}
	
	public void set(String key, boolean value) {
		
		_set(key, String.valueOf(value));
		
	}
	
	private void _set(String key, String value) {
		
		editor = preferences.edit();
        editor.putString(key, value);
        editor.commit();
		
	}
	
	public String getString(String key) {
		
		return preferences.getString(key, DEFAULT_VALUE_STRING);
		
	}
	
	public int getInt(String key) {
		
		String value = preferences.getString(key, DEFAULT_VALUE_STRING);
		
		if(value.equals(DEFAULT_VALUE_STRING)) {
			
			return DEFAULT_VALUE_INT;
			
		}
		
		return Integer.parseInt(value);
		
	}
	
	public long getLong(String key) {
		
		String value = preferences.getString(key, DEFAULT_VALUE_STRING);
		
		if(value.equals(DEFAULT_VALUE_STRING)) {
			
			return DEFAULT_VALUE_LONG;
			
		}
		
		return Long.parseLong(value);
		
	}
	
	public boolean getBoolean(String key) {
		
		String value = preferences.getString(key, DEFAULT_VALUE_STRING);
		
		if(value.equals(DEFAULT_VALUE_STRING)) {
			
			return DEFAULT_VALUE_BOOLEAN;
			
		}
		
		return Boolean.parseBoolean(value);
		
	}
	
	public SharedPreferences getPreferences() {
		
		return preferences;
		
	}
	
}
/*** Example 

	Simple_Preferences sp = new Simple_Preferences(this, "pref_name");
	
	sp.setMode(Activity.MODE_PRIVATE);		// Skippable (Default: Activity.MODE_PRIVATE)
	sp.set("string_key", "string");
	sp.set("int_key", (int)99);
	sp.set("long_key", (long)999);
	sp.set("boolean_key", true);

	Log.v("String", sp.getString("string_key"));
	Log.v("int", ""+ sp.getInt("int_key"));
	Log.v("long", ""+ sp.getLong("long_key"));
	Log.v("boolean", ""+ sp.getBoolean("boolean_key"));
	
	SharedPreferences preferences = sp.getPreferences();

***/
