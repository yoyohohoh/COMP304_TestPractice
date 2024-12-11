package com.yoyo.ho.data;

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
public final class CompanyDao_Impl implements CompanyDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<CompanyStock> __insertionAdapterOfCompanyStock;

  private final EntityDeletionOrUpdateAdapter<CompanyStock> __deletionAdapterOfCompanyStock;

  private final EntityDeletionOrUpdateAdapter<CompanyStock> __updateAdapterOfCompanyStock;

  public CompanyDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCompanyStock = new EntityInsertionAdapter<CompanyStock>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `company_stock` (`companyName`,`openingPrice`,`closingPrice`) VALUES (?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final CompanyStock entity) {
        if (entity.getCompanyName() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getCompanyName());
        }
        statement.bindDouble(2, entity.getOpeningPrice());
        statement.bindDouble(3, entity.getClosingPrice());
      }
    };
    this.__deletionAdapterOfCompanyStock = new EntityDeletionOrUpdateAdapter<CompanyStock>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `company_stock` WHERE `companyName` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final CompanyStock entity) {
        if (entity.getCompanyName() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getCompanyName());
        }
      }
    };
    this.__updateAdapterOfCompanyStock = new EntityDeletionOrUpdateAdapter<CompanyStock>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `company_stock` SET `companyName` = ?,`openingPrice` = ?,`closingPrice` = ? WHERE `companyName` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final CompanyStock entity) {
        if (entity.getCompanyName() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getCompanyName());
        }
        statement.bindDouble(2, entity.getOpeningPrice());
        statement.bindDouble(3, entity.getClosingPrice());
        if (entity.getCompanyName() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getCompanyName());
        }
      }
    };
  }

  @Override
  public Object insert(final CompanyStock company, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfCompanyStock.insert(company);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object delete(final CompanyStock company, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfCompanyStock.handle(company);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object update(final CompanyStock company, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfCompanyStock.handle(company);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<CompanyStock>> getAllCompanys() {
    final String _sql = "SELECT * FROM company_stock";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"company_stock"}, new Callable<List<CompanyStock>>() {
      @Override
      @NonNull
      public List<CompanyStock> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfCompanyName = CursorUtil.getColumnIndexOrThrow(_cursor, "companyName");
          final int _cursorIndexOfOpeningPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "openingPrice");
          final int _cursorIndexOfClosingPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "closingPrice");
          final List<CompanyStock> _result = new ArrayList<CompanyStock>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final CompanyStock _item;
            final String _tmpCompanyName;
            if (_cursor.isNull(_cursorIndexOfCompanyName)) {
              _tmpCompanyName = null;
            } else {
              _tmpCompanyName = _cursor.getString(_cursorIndexOfCompanyName);
            }
            final double _tmpOpeningPrice;
            _tmpOpeningPrice = _cursor.getDouble(_cursorIndexOfOpeningPrice);
            final double _tmpClosingPrice;
            _tmpClosingPrice = _cursor.getDouble(_cursorIndexOfClosingPrice);
            _item = new CompanyStock(_tmpCompanyName,_tmpOpeningPrice,_tmpClosingPrice);
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
  public Object getCompanyByName(final String companyName,
      final Continuation<? super CompanyStock> $completion) {
    final String _sql = "SELECT * FROM company_stock WHERE companyName = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (companyName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, companyName);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<CompanyStock>() {
      @Override
      @Nullable
      public CompanyStock call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfCompanyName = CursorUtil.getColumnIndexOrThrow(_cursor, "companyName");
          final int _cursorIndexOfOpeningPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "openingPrice");
          final int _cursorIndexOfClosingPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "closingPrice");
          final CompanyStock _result;
          if (_cursor.moveToFirst()) {
            final String _tmpCompanyName;
            if (_cursor.isNull(_cursorIndexOfCompanyName)) {
              _tmpCompanyName = null;
            } else {
              _tmpCompanyName = _cursor.getString(_cursorIndexOfCompanyName);
            }
            final double _tmpOpeningPrice;
            _tmpOpeningPrice = _cursor.getDouble(_cursorIndexOfOpeningPrice);
            final double _tmpClosingPrice;
            _tmpClosingPrice = _cursor.getDouble(_cursorIndexOfClosingPrice);
            _result = new CompanyStock(_tmpCompanyName,_tmpOpeningPrice,_tmpClosingPrice);
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
