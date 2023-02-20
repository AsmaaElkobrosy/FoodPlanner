package com.example.myfoodplannerapplication.plandatabase;

/*
public class PlanMealDataSource implements PlanDataSource {
    private PlanDao dao;
    private final Context context;
    private Observable<List<MealPlan>> storedMeals;
    private static LocalMealDataSource localMealDataSource = null;

    public PlanMealDataSource(Context context) {
        this.context = context;
        PlanDataBase db = PlanDataBase.getInstance(this.context.getApplicationContext());
        dao = db.planDao();
        storedMeals = dao.getMeals();
    }

    public static LocalMealDataSource getInstance(Context context) {
        if (localMealDataSource == null) {
            localMealDataSource = new LocalMealDataSource(context);
        }
        return localMealDataSource;
    }

    @Override
    public Observable<List<MealPlan>> getMeals() {

        return dao.getMeals();
    }

    @Override
    public void insertMeal(MealPlan meal) {
        dao.insertMeal(meal).subscribeOn(Schedulers.computation()).subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onComplete() {
            }

            @Override
            public void onError(Throwable e) {
            }
        });
    }

    @Override
    public void deleteMeal(MealPlan meal) {
        dao.deleteMeal(meal).subscribeOn(Schedulers.computation()).subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onComplete() {
            }

            @Override
            public void onError(Throwable e) {
            }
        });
    }

}
*/