package com.example.myfoodplannerapplication.plandatabase;
/*
@Database(entities = {MealPlan.class}, version = 1)
public abstract class PlanDataBase extends RoomDatabase{
    private static PlanDataBase instance = null;
    public abstract PlanDao planDao();
    public static synchronized PlanDataBase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), PlanDataBase.class,
                    "planDB") .build();
        }
        return instance;
    }
}*/