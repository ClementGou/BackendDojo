/*
 * Created on 2018-04-16 ( Date ISO 2018-04-16 - Time 11:56:16 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */

package org.demo.web.rest.commons;

import java.util.logging.Logger;

/**
 * Abstract REST resource controller providing a logger <br>
 *  
 * @author Telosys
 *
 */
public abstract class AbstractResourceController {

	protected final Logger logger ;
	
	/**
	 * Constructor
	 */
	public AbstractResourceController() {
		super();
		this.logger = Logger.getLogger(this.getClass().getCanonicalName()); 

		this.logger.setLevel(LoggerLevel.LEVEL);
	}
}