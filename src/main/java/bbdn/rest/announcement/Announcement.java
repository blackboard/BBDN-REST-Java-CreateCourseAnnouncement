package bbdn.rest.announcement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import bbdn.rest.common.Availability;
import bbdn.rest.BaseObject;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Announcement extends BaseObject {

	@JsonProperty("id")
	private String id;

	@JsonProperty("title")
	private String title;

	@JsonProperty("body")
	private String body;

	@JsonProperty("creator")
	private String creator;

	@JsonProperty("draft")
	private boolean draft;

	@JsonProperty("availability")
	private Availability availability;

	@JsonProperty("created")
	private String created;

	@JsonProperty("modified")
	private String modified;

	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	@JsonProperty("participants")
	private int participants;

	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	@JsonProperty("position")
	private int position;

	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	@JsonProperty("readCount")
	private String readCount;


	public Announcement() {
		super();
		this.availability = new Availability();
	}


	public Announcement(String id, String title, String body, String creator, boolean draft, Availability availability, String created, String modified, int participants, int position, String readCount) {
		this.id = id;
		this.title = title;
		this.body = body;
		this.creator = creator;
		this.draft = draft;
		this.availability = availability;
		this.created = created;
		this.modified = modified;
		this.participants = participants;
		this.position = position;
		this.readCount = readCount;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return this.body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getCreator() {
		return this.creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public boolean isDraft() {
		return this.draft;
	}

	public void setDraft(boolean draft) {
		this.draft = draft;
	}

	public Availability getAvailability() {
		return this.availability;
	}

	public void setAvailability(Availability availability) {
		this.availability = availability;
	}

	public String getCreated() {
		return this.created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getModified() {
		return this.modified;
	}

	public void setModified(String modified) {
		this.modified = modified;
	}

	public int getParticipants() {
		return this.participants;
	}

	public void setParticipants(int participants) {
		this.participants = participants;
	}

	public int getPosition() {
		return this.position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getReadCount() {
		return this.readCount;
	}

	public void setReadCount(String readCount) {
		this.readCount = readCount;
	}

	@Override
	public String toString() {
		return "{" +
			" id='" + getId() + "'" +
			", title='" + getTitle() + "'" +
			", body='" + getBody() + "'" +
			", creator='" + getCreator() + "'" +
			", draft='" + isDraft() + "'" +
			", availability='" + getAvailability() + "'" +
			", created='" + getCreated() + "'" +
			", modified='" + getModified() + "'" +
			", participants='" + getParticipants() + "'" +
			", position='" + getPosition() + "'" +
			", readCount='" + getReadCount() + "'" +
			", " + super.toString() +
			"}";
	}


}
