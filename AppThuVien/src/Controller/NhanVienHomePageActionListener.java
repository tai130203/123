package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vew.AboutUsView;
import Vew.BaoCaoThogKeView;
import Vew.DoiMatKhauView;
import Vew.LoginView;
import Vew.MoreHelpView;
import Vew.MuonTraSachView;
import Vew.NhanVienHomePageView;
import Vew.QuanLiThanhVienView;
import Vew.ThongTinView;

public class NhanVienHomePageActionListener implements ActionListener {
	private NhanVienHomePageView nvhpView;
	public NhanVienHomePageActionListener(NhanVienHomePageView nvhp_view)
	{
		super();
		this.nvhpView = nvhp_view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Dang xuat tai khoan"))
		{
			new LoginView();
			this.nvhpView.dispose();
		}
		if(src.equals("About us"))
		{
			new AboutUsView();
		}
		if(src.equals("Doi mat khau"))
		{
			this.nvhpView.chucnangDOiMK();
		}
		if (src.equals("More help")) {
			new MoreHelpView();
		}
		if (src.equals("Quản lí thành viên")) {
			new QuanLiThanhVienView(this.nvhpView.nvModel);
			this.nvhpView.dispose();
		}
		if (src.equals("Quản lí mượn trả sách")) {
			new MuonTraSachView();
			this.nvhpView.dispose();
		}	
		if (src.equals("Báo cáo thống kê")) {
			new BaoCaoThogKeView();
			this.nvhpView.dispose();
		}	
	}

}
