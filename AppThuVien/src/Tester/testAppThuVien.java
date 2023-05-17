package Tester;

import java.awt.desktop.AboutEvent;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.UIManager;

import Controller.QuanLiHomePageActionListener;
import DataAccessObject.ThanhvienDAO;
import Model.HumanModel;
import Model.NhanVienModel;
import Model.ThanhVienModel;
import Vew.AboutUsView;
import Vew.BaoCaoThogKeView;
import Vew.DoiMatKhauView;
import Vew.LoginView;
import Vew.MoreHelpView;
import Vew.MuonTraSachView;
import Vew.NhanVienHomePageView;
import Vew.QuanLiNhanVienView;
import Vew.QuanLiSachView;
import Vew.QuanLiThanhVienView;
import Vew.QuanliHomePageView;
import Vew.SinhvienHomePageView;
import Vew.ThanhVienView;
import Vew.ThongTinSinhVienView;
import Vew.TraCuuSach;

public class testAppThuVien {
	public static void main(String[] args) {
		new LoginView();
	}
}
