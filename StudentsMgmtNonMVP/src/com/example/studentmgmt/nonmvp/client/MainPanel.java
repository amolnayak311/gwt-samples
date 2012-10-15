/**
 * 
 */
package com.example.studentmgmt.nonmvp.client;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Amol
 * 
 */
public class MainPanel extends DockLayoutPanel {

	private Widget widget;

	public MainPanel() {
		super(Unit.EM);
		addNorth(new HeaderPanel(), 5);
		addSouth(new FooterPanel(), 2);
		addWest(new MenuPanel(this), 15);
		widget = new HomePanel();
		add(widget);
	}

	public void showPanel(Widget widget) {
		remove(this.widget);
		this.widget = widget;
		add(widget);
	}
}
