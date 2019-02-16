package murat.swings.sample.label.extend;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.sun.xml.internal.ws.api.config.management.policy.ManagementAssertion.Setting;

import javafx.scene.control.ScrollPane;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JtableSample extends JFrame{
	private JTable table;
	String adi;
	public JtableSample() {
		initialize();
	}
	
	private void initialize()
	{
		setTitle("Deneme");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {32,343, 0, 0, 0,0};
		gridBagLayout.rowHeights = new int[] {260,0};
		gridBagLayout.columnWeights = new double[] {0.0,0.0, 0.0, 0.0, 1.0,Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[] {1.0,Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		String[][] data = new String[3][5];
		String[] columnNames = {"Adi", "Soyadi", "TcNo","xx","yy"};
		
		JScrollPane scrolPane = new JScrollPane();
		GridBagConstraints gbc_scrolPane = new GridBagConstraints();
		gbc_scrolPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrolPane.fill = GridBagConstraints.BOTH;
		gbc_scrolPane.gridx = 1;
		gbc_scrolPane.gridy = 0;
		getContentPane().add(scrolPane, gbc_scrolPane);
		
		data[0][0] = "Murat";
		data[0][1] = "Murat";
		data[0][2] = "Murat";
		data[0][3] = "Murat";
		data[0][4] = "Murat";
		data[1][0] = "Gureken";
		data[1][1] = "Gureken";

		DefaultTableModel model = new DefaultTableModel(data,columnNames);

		table = new JTable(data, columnNames);
		table.setModel(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row=table.getSelectedRow();
				//adi = (String)(table.getModel().getValueAt(row, 0)); //mouse ile tiklanan satirin 0. kolonunun degeri alinir.

				DefaultTableModel m = (DefaultTableModel)table.getModel();
				Object o = m.getDataVector().elementAt(row);
				adi = (String)o.toString(); //butun satirdaki veriler var
			
			}
		});
		scrolPane.setViewportView(table); //tablo icerigi gorunmesi icin
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(JtableSample.this, adi); //table.addMouseListener'da secilen tablo degerini verir
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 0;
		getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 4;
		gbc_comboBox.gridy = 0;
		getContentPane().add(comboBox, gbc_comboBox);
		setBounds(150, 200, 586, 400);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
