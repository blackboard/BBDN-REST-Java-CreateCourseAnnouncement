package bbdn.rest;
/**
 * Options is a base class for handling standard query parameters. This can be extended for GET requests like courses that
 * allow several endpoint-specific parameters
 */
public class Options {

  /** Offset is the query parameter used to specifiy the start location during paging of datasets */
  private Integer offset;
  /** Limit is the query parameter used to specifiy how many records to return during paging of datasets */
  private Integer limit;

  /** Basic constructor for Options */
	public Options() {

  }

  /**
   * Full constructor for Options
   * @param offset: the number of records to skip
   * @param limit: the number of records to include in the result set
   */
	public Options(Integer offset, Integer limit) {
    this.offset = offset;
    this.limit = limit;
  }

  /**
   * Get the offset for this Options object
   * @return offset
   */
	public Integer getOffset() {
		return offset;
	}

  /**
   * Set the offset for this Options object
   * @param offset Offset is an Integer describing the query parameter used to specifiy the start location during paging of datasets
   */
	public void setOffset(Integer offset) {
		this.offset = offset;
	}

  /**
   * Get the limit for this Options object
   * @return limit
   */
  public Integer getLimit() {
		return limit;
	}
  /**
   * Set the offset for this Options object
   * @param limit Limit is an Integer describing the query parameter used to specifiy how many records to return during paging of
   *              datasets
   */
	public void setLimit(Integer limit) {
		this.limit = limit;
	}

  /**
   * Overridden toString() method for easy logging.
   */
	@Override
	public String toString() {
		return "Options [offset=" + offset + "limit=" + limit + "]";
	}
}
