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
public class HeaderPanel extends Composite {

	public HeaderPanel() {
		HTML text = new HTML("<h2>Header</h2>");
		LayoutPanel panel = new LayoutPanel();
		panel.add(text);
		panel.setWidgetLeftRight(text, 1, Unit.PCT, 1, Unit.PCT);
		panel.setWidgetTopBottom(text, 1, Unit.PCT, 1, Unit.PCT);
		initWidget(panel);
	}	
}
