package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JOptionPane;

import DataAccessObject.NhanvienDAO;
import DataAccessObject.ThanhvienDAO;
import Model.NhanVienModel;
import Model.ThanhVienModel;
import Vew.DoiMatKhauView;
import Vew.LoginView;

public class DoiMatKhauAcionlistener implements ActionListener {
	private DoiMatKhauView doimkView;

	public DoiMatKhauAcionlistener(DoiMatKhauView doimkView) {
		super();
		this.doimkView = doimkView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		String passCu = this.doimkView.jpasMKCu.getText();
		String passMoi = this.doimkView.jpabMoi.getText();
		String XacNhanMKMoi = this.doimkView.jpabXN.getText();
		if (src.equals("Xác nhận đổi mật khẩu")) {
			if (this.doimkView.jpasMKCu.getText().isEmpty() || this.doimkView.jpabMoi.getText().isEmpty()
					|| this.doimkView.jpabXN.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this.doimkView, "Các ô không được để trống", "LỖI",
						JOptionPane.ERROR_MESSAGE);
			} else {
				if (this.doimkView.nvmodel != null) {
					if (this.doimkView.nvmodel.getPassword().equals(passCu)) {
						if (passMoi.equals(XacNhanMKMoi)) {
							NhanVienModel nvpdate = new NhanVienModel(this.doimkView.nvmodel.getMaNV(),
									this.doimkView.nvmodel.getTenNV(), this.doimkView.nvmodel.getNgaySinh(),
									this.doimkView.nvmodel.getNgayVaoLam(), this.doimkView.nvmodel.getDiachi(),
									this.doimkView.nvmodel.getSodt(), this.doimkView.nvmodel.getCccd(),
									this.doimkView.nvmodel.getEmail(), this.doimkView.nvmodel.getUsername(), passMoi);
							NhanvienDAO.getInstance().update(nvpdate);
							JOptionPane.showMessageDialog(this.doimkView, "Đổi thành công, nhấn OK để đăng nhập lại",
									" THÀNH CÔNG", JOptionPane.DEFAULT_OPTION);
							new LoginView();
							this.doimkView.dispose();
						} else {
							JOptionPane.showMessageDialog(this.doimkView, "Xác nhận mật khẩu sai", "LỖI",
									JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(this.doimkView, "Mật khẩu cũ sai", "LỖI",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					if (this.doimkView.tvmodel.getPasswordtv().equals(passCu)) {
						if (passMoi.equals(XacNhanMKMoi)) {
							ThanhVienModel tvupdate = new ThanhVienModel(this.doimkView.tvmodel.getMatv(),
									this.doimkView.tvmodel.getTentv(), this.doimkView.tvmodel.getMadv(),
									this.doimkView.tvmodel.getNgaysinh(),
									this.doimkView.tvmodel.getDiachi(), this.doimkView.tvmodel.getSodt(),
									this.doimkView.tvmodel.getEmail(), this.doimkView.tvmodel.getNgayDKTV(),
									this.doimkView.tvmodel.getUsernametv(), passMoi);
							ThanhvienDAO.getINstance().update(tvupdate);
							JOptionPane.showMessageDialog(this.doimkView, "Đổi thành công, nhấn OK để đăng nhập lại",
									" THÀNH CÔNG", JOptionPane.DEFAULT_OPTION);
							new LoginView();
							this.doimkView.dispose();
						} else {
							JOptionPane.showMessageDialog(this.doimkView, "Xác nhận mật khẩu sai", "LỖI",
									JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(this.doimkView, "Mật khẩu cũ sai", "LỖI",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}
	}

}
