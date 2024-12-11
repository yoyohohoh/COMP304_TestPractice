package com.yoyo.ho.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007J\u0016\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\t2\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0019"}, d2 = {"Lcom/yoyo/ho/viewmodel/CompanyViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/yoyo/ho/data/CompanyRepository;", "(Lcom/yoyo/ho/data/CompanyRepository;)V", "_selectedCompany", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/yoyo/ho/data/CompanyStock;", "allCompanys", "Lkotlinx/coroutines/flow/StateFlow;", "", "getAllCompanys", "()Lkotlinx/coroutines/flow/StateFlow;", "selectedCompany", "getSelectedCompany", "delete", "Lkotlinx/coroutines/Job;", "company", "getCompanyByName", "companyName", "", "insert", "loadSelectedCompany", "", "update", "app_debug"})
public final class CompanyViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.yoyo.ho.data.CompanyRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.yoyo.ho.data.CompanyStock>> allCompanys = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.yoyo.ho.data.CompanyStock> _selectedCompany = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.yoyo.ho.data.CompanyStock> selectedCompany = null;
    
    public CompanyViewModel(@org.jetbrains.annotations.NotNull
    com.yoyo.ho.data.CompanyRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.yoyo.ho.data.CompanyStock>> getAllCompanys() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job insert(@org.jetbrains.annotations.NotNull
    com.yoyo.ho.data.CompanyStock company) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job update(@org.jetbrains.annotations.NotNull
    com.yoyo.ho.data.CompanyStock company) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job delete(@org.jetbrains.annotations.NotNull
    com.yoyo.ho.data.CompanyStock company) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.yoyo.ho.data.CompanyStock> getCompanyByName(@org.jetbrains.annotations.NotNull
    java.lang.String companyName) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.yoyo.ho.data.CompanyStock> getSelectedCompany() {
        return null;
    }
    
    public final void loadSelectedCompany(@org.jetbrains.annotations.NotNull
    java.lang.String companyName) {
    }
}