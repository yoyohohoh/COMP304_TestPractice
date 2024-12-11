package com.example.yoyo_ho_practicetest;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bJ\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00062\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bJ\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bR\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/example/yoyo_ho_practicetest/TaskViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/yoyo_ho_practicetest/TaskRepository;", "(Lcom/example/yoyo_ho_practicetest/TaskRepository;)V", "allTasks", "Lkotlinx/coroutines/flow/StateFlow;", "", "Lcom/example/yoyo_ho_practicetest/Task;", "getAllTasks", "()Lkotlinx/coroutines/flow/StateFlow;", "delete", "Lkotlinx/coroutines/Job;", "task", "getTask", "id", "", "insert", "searchTasks", "query", "", "update", "app_debug"})
public final class TaskViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.yoyo_ho_practicetest.TaskRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.yoyo_ho_practicetest.Task>> allTasks = null;
    
    public TaskViewModel(@org.jetbrains.annotations.NotNull
    com.example.yoyo_ho_practicetest.TaskRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.yoyo_ho_practicetest.Task>> getAllTasks() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job insert(@org.jetbrains.annotations.NotNull
    com.example.yoyo_ho_practicetest.Task task) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job update(@org.jetbrains.annotations.NotNull
    com.example.yoyo_ho_practicetest.Task task) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job delete(@org.jetbrains.annotations.NotNull
    com.example.yoyo_ho_practicetest.Task task) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.example.yoyo_ho_practicetest.Task> getTask(int id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.yoyo_ho_practicetest.Task>> searchTasks(@org.jetbrains.annotations.NotNull
    java.lang.String query) {
        return null;
    }
}