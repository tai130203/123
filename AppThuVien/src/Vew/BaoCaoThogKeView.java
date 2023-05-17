package Vew;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DataAccessObject.BCTKDAO;
import DataAccessObject.MuonTraSachDAO;
import Model.BaoCaoThongKeModel;
import Model.MuonTraSachModel;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class BaoCaoThogKeView extends JFrame {

	private JPanel contentPane;
	private JTextField txtNhapMa;
	private JButton jbutTimKiem;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel jlabhd;
	private JLabel jlabnv;
	private JLabel jlabtv;
	private JLabel jlabng;
	private JLabel jlabTien;
	private JLabel jlabgc;
	private JButton jbutThemhd;
	private JButton jbutCapNhathd;
	private JTextField txtmahd;
	private JTextField txtmanv;
	private JTextField txtmatv;
	private JTextField txtNgay;
	private JTextField txtTien;
	private JTextField txtGhiCHu;
	private JButton btnLmMiBng;

	public BaoCaoThogKeView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 745, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setTitle("Báo Cáo Thống Kê");
		
		
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel jlabNhapMa = new JLabel("Nhập mã nhân viên");
		jlabNhapMa.setBounds(10, 11, 132, 14);
		contentPane.add(jlabNhapMa);
		
		txtNhapMa = new JTextField();
		txtNhapMa.setBounds(171, 8, 226, 20);
		contentPane.add(txtNhapMa);
		txtNhapMa.setColumns(10);
		
		jbutTimKiem = new JButton("Tìm");
		jbutTimKiem.setBounds(421, 7, 89, 23);
		contentPane.add(jbutTimKiem);
		jbutTimKiem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				chucnangTim();
			}
		});
		btnLmMiBng = new JButton("Làm mới bảng");
		btnLmMiBng.setBounds(533, 7, 122, 23);
		contentPane.add(btnLmMiBng);
		btnLmMiBng.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showTable();
			}
		});
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã hóa đơn", "Ngày lập hóa đơn", "Số tiền", "Ghi chú", "Mã nhân viên", "Mã thành viên"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(76);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(90);
		table.getColumnModel().getColumn(3).setPreferredWidth(120);
		table.getColumnModel().getColumn(4).setPreferredWidth(50);
		table.getColumnModel().getColumn(5).setPreferredWidth(50);
		table.setBounds(10, 52, 709, 149);
		
		showTable();
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				XuatRaJtxt(table.getSelectedRow());
			}
		});
		
		scrollPane = new JScrollPane(table);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 52, 709, 149);
		contentPane.add(scrollPane);
		
		jlabhd = new JLabel("MAHD");
		jlabhd.setBounds(10, 232, 46, 14);
		contentPane.add(jlabhd);
		
		jlabnv = new JLabel("MANV");
		jlabnv.setBounds(10, 257, 46, 14);
		contentPane.add(jlabnv);
		
		jlabtv = new JLabel("MATV");
		jlabtv.setBounds(10, 282, 46, 14);
		contentPane.add(jlabtv);
		
		jlabng = new JLabel("Ngày lập");
		jlabng.setBounds(238, 232, 60, 14);
		contentPane.add(jlabng);
		
		jlabTien = new JLabel("Số tiền");
		jlabTien.setBounds(238, 257, 46, 14);
		contentPane.add(jlabTien);
		
		jlabgc = new JLabel("Ghi chú");
		jlabgc.setBounds(238, 282, 46, 14);
		contentPane.add(jlabgc);
		
		jbutThemhd = new JButton("Thêm mới hóa đơn");
		jbutThemhd.setBounds(535, 228, 154, 23);
		contentPane.add(jbutThemhd);
		jbutThemhd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				chucnangThem();
			}
		});
		
		jbutCapNhathd = new JButton("Cập nhật hóa đơn");
		jbutCapNhathd.setBounds(535, 273, 154, 23);
		contentPane.add(jbutCapNhathd);
		jbutCapNhathd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				chucNangCapnhat();
				}
		});
		
		txtmahd = new JTextField();
		txtmahd.setBounds(49, 229, 145, 20);
		contentPane.add(txtmahd);
		txtmahd.setColumns(10);
		
		txtmanv = new JTextField();
		txtmanv.setColumns(10);
		txtmanv.setBounds(49, 254, 145, 20);
		contentPane.add(txtmanv);
		
		txtmatv = new JTextField();
		txtmatv.setColumns(10);
		txtmatv.setBounds(49, 279, 145, 20);
		contentPane.add(txtmatv);
		
		txtNgay = new JTextField();
		txtNgay.setColumns(10);
		txtNgay.setBounds(308, 229, 170, 20);
		contentPane.add(txtNgay);
		
		txtTien = new JTextField();
		txtTien.setColumns(10);
		txtTien.setBounds(308, 254, 170, 20);
		contentPane.add(txtTien);
		
		txtGhiCHu = new JTextField();
		txtGhiCHu.setColumns(10);
		txtGhiCHu.setBounds(308, 279, 170, 20);
		contentPane.add(txtGhiCHu);
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	public void XuatRaJtxt(int row)
	{
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		txtmahd.setText(model_table.getValueAt(row, 0) + "");
		txtmanv.setText(model_table.getValueAt(row, 4) + "");
		txtmatv.setText(model_table.getValueAt(row, 5) + "");
		txtNgay.setText(model_table.getValueAt(row, 1) + "");
		txtTien.setText(model_table.getValueAt(row, 2) + "");
		txtGhiCHu.setText(model_table.getValueAt(row, 3) + "");

	}
	public void chucnangTim()
	{
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.setRowCount(0);
		
		for(BaoCaoThongKeModel i:BCTKDAO.getInstance().selectByCondition(txtNhapMa.getText()))
		{
			model_table.addRow(new Object[] {i.getMaHD(), i.getNgayHD(), i.getSotien(), i.getGhichu(), i.getMaNV(), i.getMatv()});
		}
		model_table.fireTableDataChanged();
	}
	public void chucnangThem()
	{
		String ngayhd = txtNgay.getText();
		SimpleDateFormat inputformat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date  ngayhddate = null;

		try {
			ngayhddate = inputformat.parse(ngayhd);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		java.sql.Date sqlDateNgaymuon = new java.sql.Date(ngayhddate.getTime());
		BaoCaoThongKeModel mts = new BaoCaoThongKeModel(txtmahd.getText(), sqlDateNgaymuon,  txtTien.getText(),
				txtGhiCHu.getText(), txtmanv.getText(), txtmatv.getText());
		BCTKDAO.getInstance().insert(mts);
		showTable();
	}
	public void chucNangCapnhat()
	{
		String ngayhd = txtNgay.getText();
		SimpleDateFormat inputformat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date  ngayhddate = null;

		try {
			ngayhddate = inputformat.parse(ngayhd);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		java.sql.Date sqlDateNgaymuon = new java.sql.Date(ngayhddate.getTime());
		BaoCaoThongKeModel mts = new BaoCaoThongKeModel(txtmahd.getText(), sqlDateNgaymuon,  txtTien.getText(),
				txtGhiCHu.getText(), txtmanv.getText(), txtmatv.getText());
		BCTKDAO.getInstance().update(mts);
		showTable();
	}
	public void showTable()
	{
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.setRowCount(0);
		
		for(BaoCaoThongKeModel i:BCTKDAO.getInstance().selectAll())
		{
			model_table.addRow(new Object[] {i.getMaHD(), i.getNgayHD(), i.getSotien(), i.getGhichu(), i.getMaNV(), i.getMatv()});
		}
		model_table.fireTableDataChanged();
	}
}
