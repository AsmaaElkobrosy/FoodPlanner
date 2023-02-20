package com.example.myfoodplannerapplication.database;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.RxRoom;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.myfoodplannerapplication.plan.model.MealPlan;
import io.reactivex.Completable;
import io.reactivex.Observable;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.Void;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class PlanDao_Impl implements PlanDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<MealPlan> __insertionAdapterOfMealPlan;

  private final EntityDeletionOrUpdateAdapter<MealPlan> __deletionAdapterOfMealPlan;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllPlannedMeals;

  public PlanDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMealPlan = new EntityInsertionAdapter<MealPlan>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `Meal_Plan` (`idMeal`,`day`,`email`,`strMeal`,`strMealThumb`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, MealPlan value) {
        if (value.idMeal == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.idMeal);
        }
        if (value.day == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.day);
        }
        if (value.email == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.email);
        }
        if (value.strMeal == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.strMeal);
        }
        if (value.strMealThumb == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.strMealThumb);
        }
      }
    };
    this.__deletionAdapterOfMealPlan = new EntityDeletionOrUpdateAdapter<MealPlan>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Meal_Plan` WHERE `idMeal` = ? AND `day` = ? AND `email` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, MealPlan value) {
        if (value.idMeal == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.idMeal);
        }
        if (value.day == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.day);
        }
        if (value.email == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.email);
        }
      }
    };
    this.__preparedStmtOfDeleteAllPlannedMeals = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Meal_Plan";
        return _query;
      }
    };
  }

  @Override
  public Completable insertMeal(final MealPlan meal) {
    return Completable.fromCallable(new Callable<Void>() {
      @Override
      public Void call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfMealPlan.insert(meal);
          __db.setTransactionSuccessful();
          return null;
        } finally {
          __db.endTransaction();
        }
      }
    });
  }

  @Override
  public Completable deleteMeal(final MealPlan meal) {
    return Completable.fromCallable(new Callable<Void>() {
      @Override
      public Void call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfMealPlan.handle(meal);
          __db.setTransactionSuccessful();
          return null;
        } finally {
          __db.endTransaction();
        }
      }
    });
  }

  @Override
  public Completable deleteAllPlannedMeals() {
    return Completable.fromCallable(new Callable<Void>() {
      @Override
      public Void call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllPlannedMeals.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return null;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteAllPlannedMeals.release(_stmt);
        }
      }
    });
  }

  @Override
  public Observable<List<MealPlan>> getMeals() {
    final String _sql = "SELECT * From Meal_Plan";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createObservable(__db, false, new String[]{"Meal_Plan"}, new Callable<List<MealPlan>>() {
      @Override
      public List<MealPlan> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfIdMeal = CursorUtil.getColumnIndexOrThrow(_cursor, "idMeal");
          final int _cursorIndexOfDay = CursorUtil.getColumnIndexOrThrow(_cursor, "day");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfStrMeal = CursorUtil.getColumnIndexOrThrow(_cursor, "strMeal");
          final int _cursorIndexOfStrMealThumb = CursorUtil.getColumnIndexOrThrow(_cursor, "strMealThumb");
          final List<MealPlan> _result = new ArrayList<MealPlan>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final MealPlan _item;
            _item = new MealPlan();
            if (_cursor.isNull(_cursorIndexOfIdMeal)) {
              _item.idMeal = null;
            } else {
              _item.idMeal = _cursor.getString(_cursorIndexOfIdMeal);
            }
            if (_cursor.isNull(_cursorIndexOfDay)) {
              _item.day = null;
            } else {
              _item.day = _cursor.getString(_cursorIndexOfDay);
            }
            if (_cursor.isNull(_cursorIndexOfEmail)) {
              _item.email = null;
            } else {
              _item.email = _cursor.getString(_cursorIndexOfEmail);
            }
            if (_cursor.isNull(_cursorIndexOfStrMeal)) {
              _item.strMeal = null;
            } else {
              _item.strMeal = _cursor.getString(_cursorIndexOfStrMeal);
            }
            if (_cursor.isNull(_cursorIndexOfStrMealThumb)) {
              _item.strMealThumb = null;
            } else {
              _item.strMealThumb = _cursor.getString(_cursorIndexOfStrMealThumb);
            }
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
