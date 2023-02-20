package com.example.myfoodplannerapplication.database;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.RxRoom;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.myfoodplannerapplication.MealFullDetailes;
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
public final class MealDao_Impl implements MealDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<MealFullDetailes> __insertionAdapterOfMealFullDetailes;

  private final EntityDeletionOrUpdateAdapter<MealFullDetailes> __deletionAdapterOfMealFullDetailes;

  public MealDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMealFullDetailes = new EntityInsertionAdapter<MealFullDetailes>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `Meals` (`idMeal`,`strMeal`,`strCategory`,`strArea`,`strInstructions`,`strMealThumb`,`strYoutube`,`strIngredient1`,`strIngredient2`,`strIngredient3`,`strIngredient4`,`strIngredient5`,`strIngredient6`,`strIngredient7`,`strIngredient8`,`strIngredient9`,`strIngredient10`,`strIngredient11`,`strIngredient12`,`strIngredient13`,`strMeasure1`,`strMeasure2`,`strMeasure3`,`strMeasure4`,`strMeasure5`,`strMeasure6`,`strMeasure7`,`strMeasure8`,`strMeasure9`,`strMeasure10`,`strMeasure11`,`strMeasure12`,`strMeasure13`,`email`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, MealFullDetailes value) {
        if (value.idMeal == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.idMeal);
        }
        if (value.strMeal == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.strMeal);
        }
        if (value.strCategory == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.strCategory);
        }
        if (value.strArea == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.strArea);
        }
        if (value.strInstructions == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.strInstructions);
        }
        if (value.strMealThumb == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.strMealThumb);
        }
        if (value.strYoutube == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.strYoutube);
        }
        if (value.strIngredient1 == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.strIngredient1);
        }
        if (value.strIngredient2 == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.strIngredient2);
        }
        if (value.strIngredient3 == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.strIngredient3);
        }
        if (value.strIngredient4 == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.strIngredient4);
        }
        if (value.strIngredient5 == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.strIngredient5);
        }
        if (value.strIngredient6 == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.strIngredient6);
        }
        if (value.strIngredient7 == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.strIngredient7);
        }
        if (value.strIngredient8 == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.strIngredient8);
        }
        if (value.strIngredient9 == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.strIngredient9);
        }
        if (value.strIngredient10 == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.strIngredient10);
        }
        if (value.strIngredient11 == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.strIngredient11);
        }
        if (value.strIngredient12 == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.strIngredient12);
        }
        if (value.strIngredient13 == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.strIngredient13);
        }
        if (value.strMeasure1 == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.strMeasure1);
        }
        if (value.strMeasure2 == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.strMeasure2);
        }
        if (value.strMeasure3 == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindString(23, value.strMeasure3);
        }
        if (value.strMeasure4 == null) {
          stmt.bindNull(24);
        } else {
          stmt.bindString(24, value.strMeasure4);
        }
        if (value.strMeasure5 == null) {
          stmt.bindNull(25);
        } else {
          stmt.bindString(25, value.strMeasure5);
        }
        if (value.strMeasure6 == null) {
          stmt.bindNull(26);
        } else {
          stmt.bindString(26, value.strMeasure6);
        }
        if (value.strMeasure7 == null) {
          stmt.bindNull(27);
        } else {
          stmt.bindString(27, value.strMeasure7);
        }
        if (value.strMeasure8 == null) {
          stmt.bindNull(28);
        } else {
          stmt.bindString(28, value.strMeasure8);
        }
        if (value.strMeasure9 == null) {
          stmt.bindNull(29);
        } else {
          stmt.bindString(29, value.strMeasure9);
        }
        if (value.strMeasure10 == null) {
          stmt.bindNull(30);
        } else {
          stmt.bindString(30, value.strMeasure10);
        }
        if (value.strMeasure11 == null) {
          stmt.bindNull(31);
        } else {
          stmt.bindString(31, value.strMeasure11);
        }
        if (value.strMeasure12 == null) {
          stmt.bindNull(32);
        } else {
          stmt.bindString(32, value.strMeasure12);
        }
        if (value.strMeasure13 == null) {
          stmt.bindNull(33);
        } else {
          stmt.bindString(33, value.strMeasure13);
        }
        if (value.email == null) {
          stmt.bindNull(34);
        } else {
          stmt.bindString(34, value.email);
        }
      }
    };
    this.__deletionAdapterOfMealFullDetailes = new EntityDeletionOrUpdateAdapter<MealFullDetailes>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Meals` WHERE `idMeal` = ? AND `email` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, MealFullDetailes value) {
        if (value.idMeal == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.idMeal);
        }
        if (value.email == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.email);
        }
      }
    };
  }

  @Override
  public Completable insertMeal(final MealFullDetailes meal) {
    return Completable.fromCallable(new Callable<Void>() {
      @Override
      public Void call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfMealFullDetailes.insert(meal);
          __db.setTransactionSuccessful();
          return null;
        } finally {
          __db.endTransaction();
        }
      }
    });
  }

  @Override
  public Completable deleteMeal(final MealFullDetailes meal) {
    return Completable.fromCallable(new Callable<Void>() {
      @Override
      public Void call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfMealFullDetailes.handle(meal);
          __db.setTransactionSuccessful();
          return null;
        } finally {
          __db.endTransaction();
        }
      }
    });
  }

  @Override
  public Observable<List<MealFullDetailes>> getMeals() {
    final String _sql = "SELECT * From Meals";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createObservable(__db, false, new String[]{"Meals"}, new Callable<List<MealFullDetailes>>() {
      @Override
      public List<MealFullDetailes> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfIdMeal = CursorUtil.getColumnIndexOrThrow(_cursor, "idMeal");
          final int _cursorIndexOfStrMeal = CursorUtil.getColumnIndexOrThrow(_cursor, "strMeal");
          final int _cursorIndexOfStrCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "strCategory");
          final int _cursorIndexOfStrArea = CursorUtil.getColumnIndexOrThrow(_cursor, "strArea");
          final int _cursorIndexOfStrInstructions = CursorUtil.getColumnIndexOrThrow(_cursor, "strInstructions");
          final int _cursorIndexOfStrMealThumb = CursorUtil.getColumnIndexOrThrow(_cursor, "strMealThumb");
          final int _cursorIndexOfStrYoutube = CursorUtil.getColumnIndexOrThrow(_cursor, "strYoutube");
          final int _cursorIndexOfStrIngredient1 = CursorUtil.getColumnIndexOrThrow(_cursor, "strIngredient1");
          final int _cursorIndexOfStrIngredient2 = CursorUtil.getColumnIndexOrThrow(_cursor, "strIngredient2");
          final int _cursorIndexOfStrIngredient3 = CursorUtil.getColumnIndexOrThrow(_cursor, "strIngredient3");
          final int _cursorIndexOfStrIngredient4 = CursorUtil.getColumnIndexOrThrow(_cursor, "strIngredient4");
          final int _cursorIndexOfStrIngredient5 = CursorUtil.getColumnIndexOrThrow(_cursor, "strIngredient5");
          final int _cursorIndexOfStrIngredient6 = CursorUtil.getColumnIndexOrThrow(_cursor, "strIngredient6");
          final int _cursorIndexOfStrIngredient7 = CursorUtil.getColumnIndexOrThrow(_cursor, "strIngredient7");
          final int _cursorIndexOfStrIngredient8 = CursorUtil.getColumnIndexOrThrow(_cursor, "strIngredient8");
          final int _cursorIndexOfStrIngredient9 = CursorUtil.getColumnIndexOrThrow(_cursor, "strIngredient9");
          final int _cursorIndexOfStrIngredient10 = CursorUtil.getColumnIndexOrThrow(_cursor, "strIngredient10");
          final int _cursorIndexOfStrIngredient11 = CursorUtil.getColumnIndexOrThrow(_cursor, "strIngredient11");
          final int _cursorIndexOfStrIngredient12 = CursorUtil.getColumnIndexOrThrow(_cursor, "strIngredient12");
          final int _cursorIndexOfStrIngredient13 = CursorUtil.getColumnIndexOrThrow(_cursor, "strIngredient13");
          final int _cursorIndexOfStrMeasure1 = CursorUtil.getColumnIndexOrThrow(_cursor, "strMeasure1");
          final int _cursorIndexOfStrMeasure2 = CursorUtil.getColumnIndexOrThrow(_cursor, "strMeasure2");
          final int _cursorIndexOfStrMeasure3 = CursorUtil.getColumnIndexOrThrow(_cursor, "strMeasure3");
          final int _cursorIndexOfStrMeasure4 = CursorUtil.getColumnIndexOrThrow(_cursor, "strMeasure4");
          final int _cursorIndexOfStrMeasure5 = CursorUtil.getColumnIndexOrThrow(_cursor, "strMeasure5");
          final int _cursorIndexOfStrMeasure6 = CursorUtil.getColumnIndexOrThrow(_cursor, "strMeasure6");
          final int _cursorIndexOfStrMeasure7 = CursorUtil.getColumnIndexOrThrow(_cursor, "strMeasure7");
          final int _cursorIndexOfStrMeasure8 = CursorUtil.getColumnIndexOrThrow(_cursor, "strMeasure8");
          final int _cursorIndexOfStrMeasure9 = CursorUtil.getColumnIndexOrThrow(_cursor, "strMeasure9");
          final int _cursorIndexOfStrMeasure10 = CursorUtil.getColumnIndexOrThrow(_cursor, "strMeasure10");
          final int _cursorIndexOfStrMeasure11 = CursorUtil.getColumnIndexOrThrow(_cursor, "strMeasure11");
          final int _cursorIndexOfStrMeasure12 = CursorUtil.getColumnIndexOrThrow(_cursor, "strMeasure12");
          final int _cursorIndexOfStrMeasure13 = CursorUtil.getColumnIndexOrThrow(_cursor, "strMeasure13");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final List<MealFullDetailes> _result = new ArrayList<MealFullDetailes>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final MealFullDetailes _item;
            _item = new MealFullDetailes();
            if (_cursor.isNull(_cursorIndexOfIdMeal)) {
              _item.idMeal = null;
            } else {
              _item.idMeal = _cursor.getString(_cursorIndexOfIdMeal);
            }
            if (_cursor.isNull(_cursorIndexOfStrMeal)) {
              _item.strMeal = null;
            } else {
              _item.strMeal = _cursor.getString(_cursorIndexOfStrMeal);
            }
            if (_cursor.isNull(_cursorIndexOfStrCategory)) {
              _item.strCategory = null;
            } else {
              _item.strCategory = _cursor.getString(_cursorIndexOfStrCategory);
            }
            if (_cursor.isNull(_cursorIndexOfStrArea)) {
              _item.strArea = null;
            } else {
              _item.strArea = _cursor.getString(_cursorIndexOfStrArea);
            }
            if (_cursor.isNull(_cursorIndexOfStrInstructions)) {
              _item.strInstructions = null;
            } else {
              _item.strInstructions = _cursor.getString(_cursorIndexOfStrInstructions);
            }
            if (_cursor.isNull(_cursorIndexOfStrMealThumb)) {
              _item.strMealThumb = null;
            } else {
              _item.strMealThumb = _cursor.getString(_cursorIndexOfStrMealThumb);
            }
            if (_cursor.isNull(_cursorIndexOfStrYoutube)) {
              _item.strYoutube = null;
            } else {
              _item.strYoutube = _cursor.getString(_cursorIndexOfStrYoutube);
            }
            if (_cursor.isNull(_cursorIndexOfStrIngredient1)) {
              _item.strIngredient1 = null;
            } else {
              _item.strIngredient1 = _cursor.getString(_cursorIndexOfStrIngredient1);
            }
            if (_cursor.isNull(_cursorIndexOfStrIngredient2)) {
              _item.strIngredient2 = null;
            } else {
              _item.strIngredient2 = _cursor.getString(_cursorIndexOfStrIngredient2);
            }
            if (_cursor.isNull(_cursorIndexOfStrIngredient3)) {
              _item.strIngredient3 = null;
            } else {
              _item.strIngredient3 = _cursor.getString(_cursorIndexOfStrIngredient3);
            }
            if (_cursor.isNull(_cursorIndexOfStrIngredient4)) {
              _item.strIngredient4 = null;
            } else {
              _item.strIngredient4 = _cursor.getString(_cursorIndexOfStrIngredient4);
            }
            if (_cursor.isNull(_cursorIndexOfStrIngredient5)) {
              _item.strIngredient5 = null;
            } else {
              _item.strIngredient5 = _cursor.getString(_cursorIndexOfStrIngredient5);
            }
            if (_cursor.isNull(_cursorIndexOfStrIngredient6)) {
              _item.strIngredient6 = null;
            } else {
              _item.strIngredient6 = _cursor.getString(_cursorIndexOfStrIngredient6);
            }
            if (_cursor.isNull(_cursorIndexOfStrIngredient7)) {
              _item.strIngredient7 = null;
            } else {
              _item.strIngredient7 = _cursor.getString(_cursorIndexOfStrIngredient7);
            }
            if (_cursor.isNull(_cursorIndexOfStrIngredient8)) {
              _item.strIngredient8 = null;
            } else {
              _item.strIngredient8 = _cursor.getString(_cursorIndexOfStrIngredient8);
            }
            if (_cursor.isNull(_cursorIndexOfStrIngredient9)) {
              _item.strIngredient9 = null;
            } else {
              _item.strIngredient9 = _cursor.getString(_cursorIndexOfStrIngredient9);
            }
            if (_cursor.isNull(_cursorIndexOfStrIngredient10)) {
              _item.strIngredient10 = null;
            } else {
              _item.strIngredient10 = _cursor.getString(_cursorIndexOfStrIngredient10);
            }
            if (_cursor.isNull(_cursorIndexOfStrIngredient11)) {
              _item.strIngredient11 = null;
            } else {
              _item.strIngredient11 = _cursor.getString(_cursorIndexOfStrIngredient11);
            }
            if (_cursor.isNull(_cursorIndexOfStrIngredient12)) {
              _item.strIngredient12 = null;
            } else {
              _item.strIngredient12 = _cursor.getString(_cursorIndexOfStrIngredient12);
            }
            if (_cursor.isNull(_cursorIndexOfStrIngredient13)) {
              _item.strIngredient13 = null;
            } else {
              _item.strIngredient13 = _cursor.getString(_cursorIndexOfStrIngredient13);
            }
            if (_cursor.isNull(_cursorIndexOfStrMeasure1)) {
              _item.strMeasure1 = null;
            } else {
              _item.strMeasure1 = _cursor.getString(_cursorIndexOfStrMeasure1);
            }
            if (_cursor.isNull(_cursorIndexOfStrMeasure2)) {
              _item.strMeasure2 = null;
            } else {
              _item.strMeasure2 = _cursor.getString(_cursorIndexOfStrMeasure2);
            }
            if (_cursor.isNull(_cursorIndexOfStrMeasure3)) {
              _item.strMeasure3 = null;
            } else {
              _item.strMeasure3 = _cursor.getString(_cursorIndexOfStrMeasure3);
            }
            if (_cursor.isNull(_cursorIndexOfStrMeasure4)) {
              _item.strMeasure4 = null;
            } else {
              _item.strMeasure4 = _cursor.getString(_cursorIndexOfStrMeasure4);
            }
            if (_cursor.isNull(_cursorIndexOfStrMeasure5)) {
              _item.strMeasure5 = null;
            } else {
              _item.strMeasure5 = _cursor.getString(_cursorIndexOfStrMeasure5);
            }
            if (_cursor.isNull(_cursorIndexOfStrMeasure6)) {
              _item.strMeasure6 = null;
            } else {
              _item.strMeasure6 = _cursor.getString(_cursorIndexOfStrMeasure6);
            }
            if (_cursor.isNull(_cursorIndexOfStrMeasure7)) {
              _item.strMeasure7 = null;
            } else {
              _item.strMeasure7 = _cursor.getString(_cursorIndexOfStrMeasure7);
            }
            if (_cursor.isNull(_cursorIndexOfStrMeasure8)) {
              _item.strMeasure8 = null;
            } else {
              _item.strMeasure8 = _cursor.getString(_cursorIndexOfStrMeasure8);
            }
            if (_cursor.isNull(_cursorIndexOfStrMeasure9)) {
              _item.strMeasure9 = null;
            } else {
              _item.strMeasure9 = _cursor.getString(_cursorIndexOfStrMeasure9);
            }
            if (_cursor.isNull(_cursorIndexOfStrMeasure10)) {
              _item.strMeasure10 = null;
            } else {
              _item.strMeasure10 = _cursor.getString(_cursorIndexOfStrMeasure10);
            }
            if (_cursor.isNull(_cursorIndexOfStrMeasure11)) {
              _item.strMeasure11 = null;
            } else {
              _item.strMeasure11 = _cursor.getString(_cursorIndexOfStrMeasure11);
            }
            if (_cursor.isNull(_cursorIndexOfStrMeasure12)) {
              _item.strMeasure12 = null;
            } else {
              _item.strMeasure12 = _cursor.getString(_cursorIndexOfStrMeasure12);
            }
            if (_cursor.isNull(_cursorIndexOfStrMeasure13)) {
              _item.strMeasure13 = null;
            } else {
              _item.strMeasure13 = _cursor.getString(_cursorIndexOfStrMeasure13);
            }
            if (_cursor.isNull(_cursorIndexOfEmail)) {
              _item.email = null;
            } else {
              _item.email = _cursor.getString(_cursorIndexOfEmail);
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
