import javax.swing.*;

public class KNNView extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private KNNController controller;

	private JMenuItem create,add, edit, remove;
	private JMenu File;
	public KNNView() {
		
		controller = new KNNController();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 400);
		
		
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);

		File = new JMenu("File");
	
		

		menuBar.add(File);
		menuBar.add(File);

		create = new JMenuItem("Create Feature");
		create.addActionListener(controller);

	

		add = new JMenuItem("Add Feature");
		add.addActionListener(controller);
		
		edit = new JMenuItem("Edit Feature");
		edit.setEnabled(false);
		edit.addActionListener(controller);
		
		remove = new JMenuItem("Remove");
		remove.setEnabled(false);
		remove.addActionListener(controller);

		File.add(add);
		File.add(edit);
		File.add(remove);
		File.add(create);		
		

		this.setVisible(true);

	}
	
	
	
	public JMenuItem getRemove() {
		return remove;
	}
	
	public JMenuItem getEdit() {
		return edit;	
	}
	
	
	public JMenu getFile() {
		return File;
		
	}
	
	public static void main(String args[]) {
		new KNNView();
	}

}
