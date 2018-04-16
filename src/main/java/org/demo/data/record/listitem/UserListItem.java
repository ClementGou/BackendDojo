/*
 * Created on 2018-04-16 ( Date ISO 2018-04-16 - Time 11:56:07 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */
package org.demo.data.record.listitem;

import org.demo.data.record.UserRecord;
import org.demo.commons.ListItem;

public class UserListItem implements ListItem {

	private final String value ;
	private final String label ;
	
	public UserListItem(UserRecord user) {
		super();

		this.value = ""
			 + user.getId()
		;

		//TODO : Define here the attributes to be displayed as the label
		this.label = user.toString();
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public String getLabel() {
		return label;
	}

}
