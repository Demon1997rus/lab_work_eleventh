package lab_work_eleventh;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.BevelBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class MainWin {

	private JFrame frame;
	private JTextField textFieldForAdd;
	private JTextField textFieldForDelete;
	private JTextField textFieldForSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWin window = new MainWin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		MyList list = new MyList();
		frame = new JFrame();
		frame.setBounds(100, 100, 959, 727);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 11, 732, 666);
		frame.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JTextArea textArea = new JTextArea();
		panel.add(textArea, BorderLayout.CENTER);
		
		JButton pbAdd = new JButton("Добавить");
		pbAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list.add(textFieldForAdd.getText());
				textArea.setText(list.toStringForward());
			}
		});
		pbAdd.setBounds(752, 11, 181, 23);
		frame.getContentPane().add(pbAdd);
		
		textFieldForAdd = new JTextField();
		textFieldForAdd.setBounds(752, 37, 181, 20);
		frame.getContentPane().add(textFieldForAdd);
		textFieldForAdd.setColumns(10);
		
		JButton pbDelete = new JButton("Удалить");
		pbDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.delete(textFieldForDelete.getText())) {
					textArea.setText(list.toStringForward() + "\nУдалить удалось!");
				} else {
					textArea.setText(list.toStringForward() + "\nУдалить не удалось!");
				}
			}
		});
		pbDelete.setBounds(752, 83, 181, 23);
		frame.getContentPane().add(pbDelete);
		
		textFieldForDelete = new JTextField();
		textFieldForDelete.setBounds(752, 108, 181, 20);
		frame.getContentPane().add(textFieldForDelete);
		textFieldForDelete.setColumns(10);
		
		JButton pbListViewForward = new JButton("Просмотр списка(прямой)");
		pbListViewForward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(list.toStringForward());
			}
		});
		pbListViewForward.setBounds(752, 225, 181, 23);
		frame.getContentPane().add(pbListViewForward);
		
		JButton pbListViewBack = new JButton("Просмотр списка(обратный)");
		pbListViewBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(list.toStringBack());
			}
		});
		pbListViewBack.setBounds(752, 259, 181, 23);
		frame.getContentPane().add(pbListViewBack);
		
		JButton pbClearList = new JButton("Очистить список");
		pbClearList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list.clear();
				textArea.setText(list.toStringForward());
			}
		});
		pbClearList.setBounds(752, 293, 181, 23);
		frame.getContentPane().add(pbClearList);
		
		JButton pbSearch = new JButton("Поиск строки");
		pbSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.search(textFieldForSearch.getText())) {
					textArea.setText(list.toStringForward() + "\nСтрока найдена");
				} else {
					textArea.setText(list.toStringForward() + "\nСтрока не найдена");
				}
			}
		});
		pbSearch.setBounds(752, 149, 181, 23);
		frame.getContentPane().add(pbSearch);
		
		textFieldForSearch = new JTextField();
		textFieldForSearch.setBounds(752, 175, 181, 20);
		frame.getContentPane().add(textFieldForSearch);
		textFieldForSearch.setColumns(10);
	}
}
