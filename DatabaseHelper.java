package com.example.codebind.linkingactivities;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Moves.db";
    public static final String TABLE_NAME = "moves_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "TYPE";
    public static final String COL_3 = "NAME";
    public static final String COL_4 = "MOVEDESC";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,TYPE TEXT,NAME TEXT,MOVEDESC TEXT)");


        //this works now!


//Arms
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(TYPE, NAME, MOVEDESC) VALUES ('Arms', 'Bicep Curls', 'Standing with feet shouldler width apart and holding weights, bend elbows to bring weights to your shoulders with palms facing up.  3 sets of 10')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(TYPE, NAME, MOVEDESC) VALUES ('Arms', 'Hammer Curls', 'Standing with feet shoulder width apart and holding weights, bend elbows 90 degrees to bring weights to your shoulders with palms facing in.  3 sets of 10')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(TYPE, NAME, MOVEDESC) VALUES ('Arms', 'Lying Triceps Press', 'Lying on a bench with your feet on the floor, raise a straight bar in front of you at arms length.  Inhale and lower bar until it lightly touches your forehead., keeping elbows stationary.  Exhale and lift bar back into starting position.  3 sets of 10')");



//Back
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(TYPE, NAME, MOVEDESC) VALUES ('Back', 'Pullup', 'Grasp the bar with an overhand grip.  Pull yourself up, pulling elbows down and to your sides.  3 sets of 10')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(TYPE, NAME, MOVEDESC) VALUES ('Back', 'One-Arm Dumbbell Row', 'Lean forward at the waist and place your right knee and right hand on a flat bench.  Keeping your left foot flat on the floor, fully extend your left arm with weight in hand.  Pull dumbbell toward your hip, keeping your elbow close to your side.  3 sets of 10 on each side')");



//Chest
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(TYPE, NAME, MOVEDESC) VALUES ('Chest', 'Chest Press', 'Lie on a bench with your feet on the floor and a dumbbell in each hand, positioned at your shoulders with upper arms at 45 degrees to your body and elbows forward.  Bracing your abs, push the weights upward.  Lower back to starting position.  3 sets of 10')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(TYPE, NAME, MOVEDESC) VALUES ('Chest', 'Standing Chest Fly', 'Stand with feet shoulder width apart and a dumbbell in each hand.  Hold upper arms parallel to the floor with elbows at 90 degrees and palms facing forward.  Bring elbows and forearms to meet in front of your body.  Return to starting position.  3 sets of 10')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(TYPE, NAME, MOVEDESC) VALUES ('Chest', 'Dumbbell Pullover', 'Lying on your back with knees bent and a dumbbell in each hand, hold your arms straight out from your chest keeping hands together with palms facing inward.  Lower dumbbells over and behind your head until your upper arms are in line with your torso, keeping elbows straight.  Raise dumbbells back to starting position.  3 sets of 10')");

//Core
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(TYPE, NAME, MOVEDESC) VALUES ('Core', 'Dead Bug', 'Lie on your back with arms and legs extended toward the ceiling.  Lower right leg and extend left arm behind your head.  Return to starting position and repeat with opposite limbs to complete one rep.  3 sets of 10')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(TYPE, NAME, MOVEDESC) VALUES ('Core', 'Side Plank Hip Lifts', 'Begin in side plank position, resting on your elbow and holding your body in a straight line.  Lower your hip almost to the floor, then bring it back into side plank position. 3 sets of 10 on each side')");

//Legs
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(TYPE, NAME, MOVEDESC) VALUES ('Legs', 'Jump Squat', 'Stand with feet shoulder width apart and toes slightly angled outward.  Bend your knees, pressing hips back and keeping back straight.  Jump, pressing through the heels.  Land back into the squat position.  3 sets of 10')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(TYPE, NAME, MOVEDESC) VALUES ('Legs', 'Wall Sit Rotation', 'Start in squat position with back against a wall and holding a medicine ball with both hands at chest height.  Twist your torso to the right, keeping the medicine ball at your chest and your thighs paralell to the floor.  Twist back to the left to complete one rep.  3 sets of 10')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(TYPE, NAME, MOVEDESC) VALUES ('Legs', 'Side To Side Hops', 'Standing with your feet hip width apart and hands at your sides, jump with both feet to the right and then to the left to complete one rep.  3 sets of 10')");


//Cardio
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(TYPE, NAME, MOVEDESC) VALUES ('Cardio', 'Interval Run', 'Begin by walking for 2 minutes.  Jog for 30 seconds.  Repeat to complete one set, for a total of 5 minutes. Do as many sets as you can, resting when necessary')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(TYPE, NAME, MOVEDESC) VALUES ('Cardio', 'Interval Jump Rope', 'Stand with feet hip width apart, holding jump rope in your hands with the center of the rope hanging behind your feet.  Swinging the rope from behind you, jump over it when it reaches the ground for 2 minutes.  Transition into swinging the rope and jumping as fast as you can for 30 seconds.  Repeat to complete one set, for a total of 5 minutes.  Do as many sets as you can, resting when necessary')");
        db.execSQL("INSERT INTO " + TABLE_NAME+ "(TYPE, NAME, MOVEDESC) VALUES ('Cardio','Dance Party', 'Put on an upbeat song.  Dance wildly for the duration.  Repeat with the same song, or your own playlist.  Dance as long as you want to, resting when necessary')");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String type,String name,String movedesc) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,type);
        contentValues.put(COL_3,name);
        contentValues.put(COL_4,movedesc);
        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    public boolean updateData(String id,String type,String name,String movedesc) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,type);
        contentValues.put(COL_3,name);
        contentValues.put(COL_4,movedesc);
        db.update(TABLE_NAME, contentValues, "ID = ?",new String[] { id });
        return true;
    }

    public Integer deleteData (String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "NAME = ?",new String[] {name});
    }


    public Cursor getRandom(String random) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME+" where id ="+ random,null);
        return res;
    }

    public Cursor getRecordCount() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select count (*) from "+TABLE_NAME,null);
        return res;
    }

    public Cursor getRecordToEdit(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select ID, TYPE, NAME, MOVEDESC from "+TABLE_NAME+" where NAME ='"+name+"'",null);
        return res;
    }






}