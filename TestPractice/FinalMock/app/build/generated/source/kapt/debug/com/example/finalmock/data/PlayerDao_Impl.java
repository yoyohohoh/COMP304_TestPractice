package com.example.finalmock.data;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
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
public final class PlayerDao_Impl implements PlayerDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Player> __insertionAdapterOfPlayer;

  private final EntityDeletionOrUpdateAdapter<Player> __deletionAdapterOfPlayer;

  private final EntityDeletionOrUpdateAdapter<Player> __updateAdapterOfPlayer;

  public PlayerDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPlayer = new EntityInsertionAdapter<Player>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `players` (`clubSymbol`,`playerName`,`playerRating`) VALUES (?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Player entity) {
        if (entity.getClubSymbol() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getClubSymbol());
        }
        if (entity.getPlayerName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getPlayerName());
        }
        statement.bindDouble(3, entity.getPlayerRating());
      }
    };
    this.__deletionAdapterOfPlayer = new EntityDeletionOrUpdateAdapter<Player>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `players` WHERE `clubSymbol` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Player entity) {
        if (entity.getClubSymbol() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getClubSymbol());
        }
      }
    };
    this.__updateAdapterOfPlayer = new EntityDeletionOrUpdateAdapter<Player>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `players` SET `clubSymbol` = ?,`playerName` = ?,`playerRating` = ? WHERE `clubSymbol` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Player entity) {
        if (entity.getClubSymbol() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getClubSymbol());
        }
        if (entity.getPlayerName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getPlayerName());
        }
        statement.bindDouble(3, entity.getPlayerRating());
        if (entity.getClubSymbol() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getClubSymbol());
        }
      }
    };
  }

  @Override
  public Object insert(final Player player, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfPlayer.insert(player);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object delete(final Player player, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfPlayer.handle(player);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object update(final Player player, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfPlayer.handle(player);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object getPlayer(final String club, final Continuation<? super Player> $completion) {
    final String _sql = "SELECT * FROM players WHERE clubSymbol = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (club == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, club);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Player>() {
      @Override
      @Nullable
      public Player call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfClubSymbol = CursorUtil.getColumnIndexOrThrow(_cursor, "clubSymbol");
          final int _cursorIndexOfPlayerName = CursorUtil.getColumnIndexOrThrow(_cursor, "playerName");
          final int _cursorIndexOfPlayerRating = CursorUtil.getColumnIndexOrThrow(_cursor, "playerRating");
          final Player _result;
          if (_cursor.moveToFirst()) {
            final String _tmpClubSymbol;
            if (_cursor.isNull(_cursorIndexOfClubSymbol)) {
              _tmpClubSymbol = null;
            } else {
              _tmpClubSymbol = _cursor.getString(_cursorIndexOfClubSymbol);
            }
            final String _tmpPlayerName;
            if (_cursor.isNull(_cursorIndexOfPlayerName)) {
              _tmpPlayerName = null;
            } else {
              _tmpPlayerName = _cursor.getString(_cursorIndexOfPlayerName);
            }
            final double _tmpPlayerRating;
            _tmpPlayerRating = _cursor.getDouble(_cursorIndexOfPlayerRating);
            _result = new Player(_tmpClubSymbol,_tmpPlayerName,_tmpPlayerRating);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Player>> getAllPlayers() {
    final String _sql = "SELECT * FROM players";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"players"}, new Callable<List<Player>>() {
      @Override
      @NonNull
      public List<Player> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfClubSymbol = CursorUtil.getColumnIndexOrThrow(_cursor, "clubSymbol");
          final int _cursorIndexOfPlayerName = CursorUtil.getColumnIndexOrThrow(_cursor, "playerName");
          final int _cursorIndexOfPlayerRating = CursorUtil.getColumnIndexOrThrow(_cursor, "playerRating");
          final List<Player> _result = new ArrayList<Player>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Player _item;
            final String _tmpClubSymbol;
            if (_cursor.isNull(_cursorIndexOfClubSymbol)) {
              _tmpClubSymbol = null;
            } else {
              _tmpClubSymbol = _cursor.getString(_cursorIndexOfClubSymbol);
            }
            final String _tmpPlayerName;
            if (_cursor.isNull(_cursorIndexOfPlayerName)) {
              _tmpPlayerName = null;
            } else {
              _tmpPlayerName = _cursor.getString(_cursorIndexOfPlayerName);
            }
            final double _tmpPlayerRating;
            _tmpPlayerRating = _cursor.getDouble(_cursorIndexOfPlayerRating);
            _item = new Player(_tmpClubSymbol,_tmpPlayerName,_tmpPlayerRating);
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

  @Override
  public Flow<List<Player>> searchPlayers(final String searchQuery) {
    final String _sql = "SELECT * FROM players WHERE playerName LIKE ? OR playerRating LIKE ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (searchQuery == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, searchQuery);
    }
    _argIndex = 2;
    if (searchQuery == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, searchQuery);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"players"}, new Callable<List<Player>>() {
      @Override
      @NonNull
      public List<Player> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfClubSymbol = CursorUtil.getColumnIndexOrThrow(_cursor, "clubSymbol");
          final int _cursorIndexOfPlayerName = CursorUtil.getColumnIndexOrThrow(_cursor, "playerName");
          final int _cursorIndexOfPlayerRating = CursorUtil.getColumnIndexOrThrow(_cursor, "playerRating");
          final List<Player> _result = new ArrayList<Player>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Player _item;
            final String _tmpClubSymbol;
            if (_cursor.isNull(_cursorIndexOfClubSymbol)) {
              _tmpClubSymbol = null;
            } else {
              _tmpClubSymbol = _cursor.getString(_cursorIndexOfClubSymbol);
            }
            final String _tmpPlayerName;
            if (_cursor.isNull(_cursorIndexOfPlayerName)) {
              _tmpPlayerName = null;
            } else {
              _tmpPlayerName = _cursor.getString(_cursorIndexOfPlayerName);
            }
            final double _tmpPlayerRating;
            _tmpPlayerRating = _cursor.getDouble(_cursorIndexOfPlayerRating);
            _item = new Player(_tmpClubSymbol,_tmpPlayerName,_tmpPlayerRating);
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
