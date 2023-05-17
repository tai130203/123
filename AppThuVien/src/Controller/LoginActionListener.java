package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Vew.DoiMatKhauView;
import Vew.LoginView;
import Vew.SinhvienHomePageView;
import Vew.ThongTinSinhVienView;

public class LoginActionListener implements ActionListener {
	private LoginView loginview;
	private DoiMatKhauView doimkView;

	public LoginActionListener(LoginView logview) {
		super();
		this.loginview = logview;
	}

	public LoginActionListener(DoiMatKhauView dmk) {
		super();
		this.doimkView = dmk;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();

		if (src.equals("Xác nhận")) {
			this.loginview.XuLiDangNhap();
		}
	}

}
