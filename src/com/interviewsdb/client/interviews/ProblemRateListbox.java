package com.interviewsdb.client.interviews;

import com.google.gwt.user.client.ui.ListBox;

public class ProblemRateListbox extends ListBox {

	public ProblemRateListbox(final String rate) {

		this.setWidth("350px");

		this.addItem("");

		this.addItem("5 - I MUST HAVE a solution for this problem.", "5");
		this.addItem(
				"4 - It will be NICE TO HAVE a solution for this problem.", "4");
		this.addItem("3 - MAYBE, I don't care about a solution for this problem.", "3");
		this.addItem("2 - I DON'T NEED a solution for this problem.", "2");
		this.addItem("1 - I DON'T HAVE this problem.", "1");

		if ("5".equals(rate)) {

			this.setSelectedIndex(1);

		} else if ("4".equals(rate)) {

			this.setSelectedIndex(2);

		} else if ("3".equals(rate)) {

			this.setSelectedIndex(3);

		} else if ("2".equals(rate)) {

			this.setSelectedIndex(4);

		} else if ("1".equals(rate)) {

			this.setSelectedIndex(5);

		}
	}
}
