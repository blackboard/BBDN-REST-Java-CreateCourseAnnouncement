package bbdn.rest;

import java.util.List;

import bbdn.rest.BbID;

/**
 * Base interface for all Service handlers. These methods MUST be included in each Service, however, these
 * methods will be overloaded to handle more arguments in individual objects, as appropriate.
 */

public interface BaseService<T,O> {
  /**
   * Create a new entity. This is equivalent to HTTP POST in most cases.
   * @param obj A class object to build the JSON package from.
   * @param fields A string array of fields to include in the response or null for all. In the rare case that 'fields' is not valid,
   *               null will be accepted and the method will be overloaded with a method not requiring this parameter.
   * @return the created object
   */
  public T create(T obj, BbID[] ids, String[] fields);

  /**
   * Read a specific entity.
   * @param ids A representation of the object ids @see #BbID.
   * @param fields A string array of fields to include in the response or null for all. In the rare case that 'fields' is not valid,
   *               null will be accepted and the method will be overloaded with a method not requiring this parameter.
   * @return the requested object
   */
   public T read(BbID[] ids, String[] fields);

   /**
    * Read all entities
    * @param options An @see #Options object containing any query paramters and filters requested. Individual services may overload this *                method to allow for an additional set of options, i.e. {@code Course[] courses = courseService(Options,
    *                CourseOptions)}.
    * @param fields A string array of fields to include in the response or null for all. In the rare case that 'fields' is not valid,
    *               null will be accepted and the method will be overloaded with a method not requiring this parameter.
    * @return object array
    */
    public List<T> readAll(O options, String[] fields);

    /**
     * Update a specific entity.
     * @param obj A class object to build the JSON payload for the update.
     * @param ids A representation of the object ids @see #BbID.
     * @param fields A string array of fields to include in the response or null for all. In the rare case that 'fields' is not valid,
     *               null will be accepted and the method will be overloaded with a method not requiring this parameter.
     * @return the updated object
     */
     public T update(T obj, BbID[] ids, String[] fields);

     /**
      * Delete a specific entity.
      * @param ids A representation of the object ids @see #BbID.
      * @return boolean: True - Delete Successful, False - Delete Failed
      */
      public boolean delete(BbID[] ids);
}
