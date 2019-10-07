package com.project.capstone.virtualmobileapp.presenter;


import com.project.capstone.virtualmobileapp.model.Item;
import com.project.capstone.virtualmobileapp.model.ModelTimKiem;
import com.project.capstone.virtualmobileapp.view.ViewTimKiem;

import java.util.ArrayList;

public class PresenterLogicTimKiem implements IPresenterTimKiem {

    ViewTimKiem viewTimKiem;
    ModelTimKiem modelTimKiem;

    public PresenterLogicTimKiem() {
    }

    public PresenterLogicTimKiem(ViewTimKiem viewTimKiem) {
        this.viewTimKiem = viewTimKiem;
        modelTimKiem = new ModelTimKiem();
    }

    @Override
    public void TimKiemSanPhamTheoTenSP(String tensp, int limit) {

        ArrayList<Item> sanPhamList = modelTimKiem.TimKiemSanPhamTheoTen(tensp, "DANHSACHSANPHAM", "dsad", 0);

        if (sanPhamList.size() > 0) {
            viewTimKiem.TimKiemThanhCong(sanPhamList);
        } else {
            viewTimKiem.TimKiemThatBai();
        }
    }
}
