import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtWouldYouLike;
	private JTextField txtThankYouFor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 24));
		setTitle("Welcome");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 736, 677);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Hello! ");
		lblNewLabel.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel.setBounds(10, 30, 176, 141);
		contentPane.add(lblNewLabel);

		txtWouldYouLike = new JTextField();
		txtWouldYouLike.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 16));
		txtWouldYouLike.setText("Would you like to see the top 20 most frequent words on the Raven Poem?");
		txtWouldYouLike.setBounds(20, 166, 677, 102);
		contentPane.add(txtWouldYouLike);
		txtWouldYouLike.setColumns(10);

		JButton btnYes = new JButton("Yes");
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TextAnalyzer text = new TextAnalyzer();
				try {
					Map<String, Integer> stats = new HashMap<String, Integer>();
					String temp = "";
					text.countFrequencies("C:\\Users\\fatim\\eclipse-workspace\\SDLC Assignment\\TheRavenPoem.txt",
							stats);
					String s;
					Integer integer;
					for (Entry<String, Integer> iter : stats.entrySet()) {
						temp += iter.getKey() + " " + iter.getValue() + "\n";

					}

					JOptionPane.showMessageDialog(null, temp, "result", JOptionPane.INFORMATION_MESSAGE);

				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnYes.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 17));
		btnYes.setBounds(158, 304, 164, 52);
		contentPane.add(btnYes);

		JButton btnNo = new JButton("No");
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showInternalMessageDialog(null, " Bye");
			}
		});
		btnNo.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 17));
		btnNo.setBounds(418, 304, 128, 52);
		contentPane.add(btnNo);

		txtThankYouFor = new JTextField();
		txtThankYouFor.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 17));
		txtThankYouFor.setText("Thank you for playing !");
		txtThankYouFor.setBounds(207, 435, 320, 108);
		contentPane.add(txtThankYouFor);
		txtThankYouFor.setColumns(10);
	}
}
