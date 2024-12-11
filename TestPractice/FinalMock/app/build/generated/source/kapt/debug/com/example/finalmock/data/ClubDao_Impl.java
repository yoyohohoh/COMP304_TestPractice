package com.example.finalmock.data;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ClubDao_Impl implements ClubDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Club> __insertionAdapterOfClub;

  public ClubDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfClub = new EntityInsertionAdapter<Club>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `clubs` (`clubName`,`clubSymbol`,`clubRanking`) VALUES (?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Club entity) {
        if (entity.getClubName() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getClubName());
        }
        statement.bindDouble(2, entity.getClubSymbol());
        statement.bindDouble(3, entity.getClubRanking());
      }
    };
  }

  @Override
  public Object insert(final Club club, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfClub.insert(club);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Club>> getAllClubs() {
    final String _sql = "SELECT * FROM clubs";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"clubs"}, new Callable<List<Club>>() {
      @Override
      @NonNull
      public List<Club> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfClubName = CursorUtil.getColumnIndexOrThrow(_cursor, "clubName");
          final int _cursorIndexOfClubSymbol = CursorUtil.getColumnIndexOrThrow(_cursor, "clubSymbol");
          final int _cursorIndexOfClubRanking = CursorUtil.getColumnIndexOrThrow(_cursor, "clubRanking");
          final List<Club> _result = new ArrayList<Club>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Club _item;
            final String _tmpClubName;
            if (_cursor.isNull(_cursorIndexOfClubName)) {
              _tmpClubName = null;
            } else {
              _tmpClubName = _cursor.getString(_cursorIndexOfClubName);
            }
            final double _tmpClubSymbol;
            _tmpClubSymbol = _cursor.getDouble(_cursorIndexOfClubSymbol);
            final double _tmpClubRanking;
            _tmpClubRanking = _cursor.getDouble(_cursorIndexOfClubRanking);
            _item = new Club(_tmpClubName,_tmpClubSymbol,_tmpClubRanking);
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
