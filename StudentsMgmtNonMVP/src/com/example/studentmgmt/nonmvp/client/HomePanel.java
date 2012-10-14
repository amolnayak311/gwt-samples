/**
 * 
 */
package com.example.studentmgmt.nonmvp.client;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.LayoutPanel;

/**
 * @author Amol
 *
 */
public class HomePanel extends Composite {

	public HomePanel() {
		LayoutPanel panel = new LayoutPanel();
		HTML text = new HTML("<b>Some text in the home page</b>");		
		panel.add(text);
		panel.setWidgetLeftRight(text, 3, Unit.PCT, 3, Unit.PCT);
		panel.setWidgetTopBottom(text, 3, Unit.PCT, 3, Unit.PCT);
		initWidget(panel);
	}
}
