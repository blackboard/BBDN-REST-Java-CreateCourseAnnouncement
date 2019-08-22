package bbdn.rest.announcement;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import bbdn.caching.CacheUtil;
import bbdn.rest.BaseService;
import bbdn.rest.BbID;
import bbdn.rest.Options;
import bbdn.rest.RestConstants;
import bbdn.rest.RestConfig;
import bbdn.rest.common.Availability;
import bbdn.rest.announcement.Announcement;
import bbdn.rest.announcement.Announcements;
import bbdn.rest.util.UrlUtil;
import bbdn.unsecurity.UnSecurityUtil;

/**
	Announcement Service is the main service point for interacting with the announcements endpoint.
 */

public class AnnouncementService implements BaseService<Announcement,Options> {

	private Logger log = null;

	/**
	 * This is the constuctor, which essentially just sets up logging.
	 */
	public AnnouncementService () {
		System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "TRACE");
		log = LoggerFactory.getLogger(AnnouncementService.class);
	}

	/**
	 * Create a announcement. This is a POST /learn/api/public/v1/courses/:courseId:/announcements.
	 * @param announcement: A @see #Announcement object to be created.
	 * @param ids: An array of @see BbID objects that tells us the @see #BbDef.IDType, the @see #BbDef.IDName, and the actual id to
	 *							fill out the URL above.
	 * @param fields: a string array containing any fields to filter the returned data.
	 * @return The @see #Announcement object returned from the API call.
	 */
	public Announcement create(Announcement announcement, BbID[] ids, String[] fields) {
		log.info("CREATE");
		String endpoint = RestConstants.ANNOUNCEMENT_PATH + "/" + ids[0].getType() + ids[0].getValue() + "/announcements";

		if(fields != null) {
			endpoint = UrlUtil.processFields(endpoint,fields);
		}

		List<Announcement> announcements = sendRequest(endpoint, HttpMethod.POST, announcement, false);

		log.info(announcements.toString());
		return announcements.get(0);
	}

	/**
	 * Read an individual announcement. Calls GET /learn/api/public/v1/announcement/[idtype:]id
	 * @param ids: An array of @see BbID objects that tells us the @see #BbDef.IDType, the @see #BbDef.IDName, and the actual id to
	 *							fill out the URL above.
	 * @param fields: a string array containing any fields to filter the returned data.
	 * @return The @see #Announcement object returned from the API call.
	 */
	public Announcement read(BbID[] ids, String[] fields) {
		log.info("READ");

		String endpoint = RestConstants.ANNOUNCEMENT_PATH + "/" + ids[0].getType() + ids[0].getValue() + "/announcements/" + ids[1].getType() + ids[1].getValue();

		if(fields != null) {
			endpoint = UrlUtil.processFields(endpoint,fields);
		}

		List<Announcement> announcements = sendRequest(endpoint, HttpMethod.GET, new Announcement(), false);

		return announcements.get(0);
	}

	/**
	 * Read all announcements. Calls GET /learn/api/public/v1/announcements
	 * @param options: A @see Options objects that provides and query parameters to filter the results.
	 * @param fields: a string array containing any fields to filter the returned data.
	 * @return An array of @see #Announcement objects returned from the API call.
	 */
	public List<Announcement> readAll(Options options, String[] fields) {
		log.info("READALL");

		String endpoint = RestConstants.ANNOUNCEMENT_PATH;

		if(fields != null) {
			endpoint = UrlUtil.processFields(endpoint,fields);
		}

		if(options != null) {
			endpoint = processOptions(endpoint, options, (fields != null));
		}

		List<Announcement> announcements = sendRequest(endpoint, HttpMethod.GET, new Announcement(), true);

		log.info("Size of READALL announcements: " + String.valueOf(announcements.size()));
		log.info("First READALL Result: " + announcements.get(0));
		log.info("Last READALL Result: " + announcements.get(announcements.size()-1));

		return(announcements);
	}

	/**
	 * Update a announcement. Calls PATCH /learn/api/public/v1/announcements/[idtype:]id
	 * @param announcement: a @see #Announcement object containing the updated values.
	 * @param ids: An array of @see BbID objects that tells us the @see #BbDef.IDType, the @see #BbDef.IDName, and the actual id to
	 *							fill out the URL above.
	 * @param fields: a string array containing any fields to filter the returned data.
	 * @return The @see #Announcement object returned from the API call.
	 */
	 public Announcement update(Announcement announcement, BbID[] ids, String[] fields) {
		log.info("UPDATE");

		String endpoint = RestConstants.ANNOUNCEMENT_PATH + "/" + ids[0].getType() + ids[0].getValue();

		if(fields != null)
			endpoint = UrlUtil.processFields(endpoint,fields);

		List<Announcement> announcements = sendRequest(endpoint, HttpMethod.PATCH, announcement, false);

		return announcements.get(0);
	}

	/**
	 * Delete a announcement. Calls DELETE /learn/api/public/v1/announcements/[idtype:]id
	 * @param ids: An array of @see BbID objects that tells us the @see #BbDef.IDType, the @see #BbDef.IDName, and the actual id to
	 *							fill out the URL above.
	 * @return boolean indicating success of the deletion. True = deleted, False = not deleted.
	 */
	public boolean delete(BbID[] ids) {
		log.info("DELETE");

		String endpoint = RestConstants.ANNOUNCEMENT_PATH + "/" + ids[0].getType() + ids[0].getValue();

		@SuppressWarnings("unused")
		List<Announcement> announcements = sendRequest(endpoint, HttpMethod.DELETE, new Announcement(), false);

		return(true);
	}

	private List<Announcement> sendRequest(String sUri, HttpMethod method, Announcement body, boolean isCollection) {

			List<Announcement> announcementList = new ArrayList();
			RestTemplate restTemplate = null;

			try {

				restTemplate = UnSecurityUtil.getRestTemplate();

		    URI uri = null;
				try {
					uri = new URI(RestConfig.host + sUri);
					log.info("URI is " + uri);
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				HttpHeaders headers = new HttpHeaders();

				headers.add("Authorization", "Bearer " + CacheUtil.getValidToken());
				headers.setContentType(MediaType.APPLICATION_JSON);
				log.info("Request Headers: " + headers.toString());

				HttpEntity<Announcement> request = new HttpEntity<Announcement>(body, headers);
				log.info("Request Body: " + request.getBody());

				if(isCollection) {
					Announcement lastAnnouncement = new Announcement();
					log.info("in isCollection, URI is " +uri.toString());

					while(uri != null) {
						log.info("getting announcements");
						ResponseEntity<Announcements> response = restTemplate.exchange(uri, method, request, Announcements.class );

						log.info("setting tempAnnouncements");
						Announcements tempAnnouncements = response.getBody();

						log.info("getting results");
						Announcement[] results = tempAnnouncements.getResults();

						log.info("if");
						if(lastAnnouncement != null && results.length > 0 ) {
							log.info("nextIf");
							if(results[results.length-1].getId() != lastAnnouncement.getId()) {
								log.info("startFor");
				         for(int i = 0; i < results.length; i++) {
									log.info("forLastAnnouncement");
				         	lastAnnouncement = results[i];
									log.info("forAnnouncementAdd");
									announcementList.add(results[i]);
				         }
								 try {
									uri = new URI(RestConfig.host + tempAnnouncements.getPaging().getNextPage());
					 				log.info("NewURI is " + uri);
					 			} catch (URISyntaxException e) {
					 				// TODO Auto-generated catch block
									log.info("setNewURIEx");
					 				e.printStackTrace();
					 			} catch (NullPointerException npe) {
									log.info("Next Page is null, that means we are done!");
									uri = null;
								}
							} else {
								log.info("nextIfFalse");
				         uri = null;
				    	}
			    	} else {
							log.info("ifFalse");
			         uri = null;
			    	}
					}
					log.info("exit while");

				} else {
					ResponseEntity<Announcement> response = restTemplate.exchange(uri, method, request, Announcement.class );
					log.info("Response: " + response);

					Announcement announcement = response.getBody();
			    log.info("Announcement: " + announcement.toString());

					announcementList.add(announcement);
				}
			}
			catch (Exception e) {
				if( method.equals(HttpMethod.DELETE )) {

				} else {
					log.error("Exception encountered");
					e.printStackTrace();
				}
			}

	        return (announcementList);
		}

		private String processOptions(String endpoint, Options options, boolean hasFields) {

			if(options.getOffset() != null || options.getLimit() != null ) {
				if(hasFields) {
					endpoint += "&";
				} else {
					endpoint += "?";
				}

				if(options.getOffset() != null) {
					endpoint += "offset=" + String.valueOf(options.getOffset());
				}

				if(options.getLimit() != null) {
					if(options.getOffset() != null) {
						endpoint += "&";
					}
					endpoint += "limit=" + String.valueOf(options.getLimit());
				}
			} else {
				return endpoint;
			}

			return endpoint;
		}
}
