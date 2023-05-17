package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vew.AboutUsView;
import Vew.LoginView;
import Vew.MoreHelpView;
import Vew.QuanLiNhanVienView;
import Vew.QuanLiSachView;
import Vew.QuanliHomePageView;

public class QuanLiHomePageActionListener implements ActionListener {

	private QuanliHomePageView qlhpView;
	public QuanLiHomePageActionListener(QuanliHomePageView qlhp)
	{
		super();
		this.qlhpView = qlhp;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Quản lý sách"))
		{
			new QuanLiSachView();
			this.qlhpView.dispose();
		}
		if(src.equals("Quản lý nhân viên"))
		{
			new QuanLiNhanVienView();
			this.qlhpView.dispose();
		}
		if(src.equals("Dang xuat tai khoan"))
		{
			new LoginView();
			this.qlhpView.dispose();
		}
		if(src.equals("About us"))
		{
			new AboutUsView();
			this.qlhpView.dispose();

		}
		if(src.equals("Doi mat khau"))
		{
			this.qlhpView.chucnangDOiMK();
		}
		if (src.equals("More help")) {
			new MoreHelpView();
		}
		
		
	}

}
