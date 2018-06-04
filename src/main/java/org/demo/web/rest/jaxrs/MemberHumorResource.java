/*
 * Created on 2018-04-30 ( Time 15:10:24 )
 * Generated by Telosys Tools Generator ( version 3.0.0 )
 */
package org.demo.web.rest.jaxrs;

import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

//--- Entities
import org.demo.data.record.MemberHumorRecord;
import org.demo.data.record.listitem.MemberHumorListItem;
//--- Services 
import org.demo.persistence.MemberHumorPersistence;
// import org.demo.business.service.impl.MemberHumorServiceImpl;
import org.demo.persistence.commons.PersistenceServiceProvider;
import org.demo.web.rest.commons.AbstractResourceController;

/**
 * JAXRS Jersey controller for 'MemberHumor' management.
 */
@Path("/memberHumor")
public class MemberHumorResource extends AbstractResourceController {

	private MemberHumorPersistence memberHumorService = PersistenceServiceProvider.getService(
			MemberHumorPersistence.class);

	/**
	 * Constructor
	 */
	public MemberHumorResource() {
		super();
		logger.info("Constructor.");
	}

	/**
	 * Get all memberHumor entities.
	 * 
	 * @return list with all entities found
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<MemberHumorRecord> findAll() {
		logger.info("findAll()...");
		return memberHumorService.findAll();
	}

	/**
	 * Retrieves a memberHumor using the given id.
	 * 
	 * @param id
	 *            id
	 * @return 200 + body if found, 404 if not found
	 */
	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findById(@PathParam("id") Integer id) {
		logger.info("findById(" + id + ")...");
		MemberHumorRecord record = memberHumorService.findById(id);
		if (record != null) {
			return Response.ok(record).build();
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	/**
	 * Creates a new memberHumor.
	 * 
	 * @param memberHumor
	 *            memberHumor
	 * @return 201 with body if created, 409 conflict if duplicate key
	 */
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response create(MemberHumorRecord memberHumor) {
		logger.info("create()...");
		if (memberHumorService.exists(memberHumor)) {
			logger.info("create() : already exists -> conflict");
			return Response.status(Status.CONFLICT).build();
		} else {
			logger.info("create() : doesn't exist -> create");
			MemberHumorRecord record = memberHumorService.create(memberHumor);
			return Response.status(Status.CREATED).entity(record).build();
		}
	}

	// ------------------------------------------------------------
	/**
	 * Updates the memberHumor identified by the given id
	 * 
	 * @param memberHumor
	 *            memberHumor entity
	 * @param id
	 *            id
	 * @return 200 if found and updated, 404 if not found
	 */
	@PUT
	@Path("{id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	// public MemberHumorRecord update(MemberHumorRecord memberHumor,
	// @PathParam("id") Integer id) {
	public Response update(MemberHumorRecord memberHumor, @PathParam("id") Integer id) {
		logger.info("update()...");
		// force the id (use the id provided by the URL)
		memberHumor.setId(id);
		boolean updated = memberHumorService.update(memberHumor);
		if (updated) {
			// Actually updated (found and updated) => 200 OK
			return Response.status(Status.OK).build();
		} else {
			// Not updated with no error => 404 not found
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	/**
	 * Save (create or update) the given memberHumor.
	 * 
	 * @param memberHumor
	 *            memberHumor entity
	 * @return 200 if found and updated, 201 if not found and created
	 */
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response save(MemberHumorRecord memberHumor) {
		logger.info("save()...");
		Status status = Status.OK; // 200 OK
		if (!memberHumorService.exists(memberHumor)) {
			status = Status.CREATED; // 201 CREATED
		}
		MemberHumorRecord record = memberHumorService.save(memberHumor);
		// Response ( code 200 or 201 )
		return Response.status(status).entity(record).build();
	}

	// ------------------------------------------------------------
	/**
	 * Delete a memberHumor.
	 * 
	 * @param id
	 *            id
	 */
	@DELETE
	@Path("{id}")
	// @Consumes({MediaType.APPLICATION_JSON})
	// public void delete(@PathParam("id") Integer id) {
	public Response delete(@PathParam("id") Integer id) {
		logger.info("delete(" + id + ")...");
		// memberHumorService.deleteById(id);
		boolean deleted = memberHumorService.deleteById(id);
		if (deleted) {
			// Actually deleted (found and deleted) => 204 "No Content" because no body in
			// the response
			return Response.status(Status.NO_CONTENT).build();
		} else {
			// Not deleted with no error => 404 "Not found"
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	@GET
	@Path("/memberHumors-list-items")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<MemberHumorListItem> listItems() {
		logger.info("listItems()...");
		List<MemberHumorRecord> list = memberHumorService.findAll();
		List<MemberHumorListItem> items = new LinkedList<MemberHumorListItem>();
		for (MemberHumorRecord memberHumor : list) {
			items.add(new MemberHumorListItem(memberHumor));
		}
		return items;
	}

}
