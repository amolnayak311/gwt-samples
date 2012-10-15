/**
 * 
 */
package com.example.studentmgmt.nonmvp.client;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.StackLayoutPanel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;

/**
 * @author Amol
 * 
 */
public class MenuPanel extends StackLayoutPanel {

	private final MainPanel mp;

	private final AddStudentPanel addStudentPanel;

	private final HomePanel homePanel;

	public MenuPanel(MainPanel mp) {
		super(Unit.EM);
		add(getStudentManagementTree(), new HTML("Student Management"), 2);
		add(new HTML("Move on, nothing here yet"), new HTML("Reports"), 2);
		this.mp = mp;
		addStudentPanel = new AddStudentPanel();
		homePanel = new HomePanel();
	}

	private Tree getStudentManagementTree() {
		Tree tree = new Tree();

		TreeItem home = new TreeItem("Home");
		tree.addItem(home);

		TreeItem links = new TreeItem("Links");
		tree.addItem(links);

		TreeItem addStudent = new TreeItem("Add Student");
		links.addItem(addStudent);

		TreeItem showStudents = new TreeItem("Show Students");
		links.addItem(showStudents);

		tree.addSelectionHandler(new SelectionHandler<TreeItem>() {

			@Override
			public void onSelection(SelectionEvent<TreeItem> event) {
				TreeItem item = event.getSelectedItem();
				String text = item.getText();
				if ("Add Student".equals(text)) {
					mp.showPanel(addStudentPanel);
				} else if ("Show Students".equals(text)) {

				} else if ("Home".equals(text)) {
					mp.showPanel(homePanel);
				}
			}
		});
		return tree;
	}
}
