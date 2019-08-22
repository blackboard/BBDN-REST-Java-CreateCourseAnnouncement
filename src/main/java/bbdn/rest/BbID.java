package bbdn.rest;
/**
 * BbID is a class for passing IDs to a method for inclusion in an endpoint.
 */

import bbdn.rest.BbDef.IDName;
import bbdn.rest.BbDef.IDType;

public class BbID {

  /** @see #IDName is an enum describing the ID to be placed in the REST endpoint path */
  private IDName id;
  /** Value is the actual value to be placed in the REST Endpoint path */
  private String value;
  /** @see #IDType is an String constant describing the type of ID to be specified. Default is IDType.PRIMARY */
  private String type;


  /** Basic constructor for BbID. Sets type to IDType.PRIMARY. Expects other values to be set manually. */
	public BbID() {
    this.type = IDType.PRIMARY;
  }

  /**
   * Constructor for BbID. Sets type to IDType.PRIMARY.
   * @param id Enum describing the name of id. @see #IDName
   * @param value String describing the actual id of the object
   */
	public BbID(IDName id, String value) {
    this.id = id;
    this.value = value;
    this.type = IDType.PRIMARY;
  }

  /**
   * Constructor for BbID.
   * @param id Enum describing the name of id. @see #IDName
   * @param value String describing the actual id of the object
   * @param type String describing the type of id. @see #IDType
   */
	public BbID(IDName id, String value, String type) {
    this.id = id;
    this.value = value;
    this.type = type;
  }

  /**
   * Get the @see #IDName for this BbID object
   * @return id
   */
	public IDName getId() {
		return id;
	}

  /**
   * Set the @see #IDName for this BbID object
   * @param id Enum describing the name of id. @see #IDName
   */
	public void setId(IDName id) {
		this.id = id;
	}

  /**
   * Get the value for this BbID object
   * @return value
   */
  public String getValue() {
		return value;
	}
  /**
   * Set the value for this BbID object
   * @param value String describing the actual id of the object
   */
	public void setValue(String value) {
		this.value = value;
	}
    /**
     * Get the @see #IDType for this BbID object
     * @return type
     */
  	public String getType() {
  		return type;
  	}

    /**
     * Set the @see #IDType for this BbID object
     * @param type Enum describing the type of id. @see #IDType
     */
  	public void setType(String type) {
  		this.type = type;
  	}


  /**
   * Overridden toString() method for easy logging.
   */
	@Override
	public String toString() {
		return "BbID [id=" + id + ", value=" + value + ", type=" + type + "]";
	}
}
