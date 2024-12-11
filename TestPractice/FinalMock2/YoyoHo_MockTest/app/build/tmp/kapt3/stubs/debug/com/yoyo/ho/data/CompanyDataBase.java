package com.yoyo.ho.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0005"}, d2 = {"Lcom/yoyo/ho/data/CompanyDataBase;", "Landroidx/room/RoomDatabase;", "()V", "companyDao", "Lcom/yoyo/ho/data/CompanyDao;", "app_debug"})
@androidx.room.Database(entities = {com.yoyo.ho.data.CompanyStock.class}, version = 1)
public abstract class CompanyDataBase extends androidx.room.RoomDatabase {
    
    public CompanyDataBase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract com.yoyo.ho.data.CompanyDao companyDao();
}