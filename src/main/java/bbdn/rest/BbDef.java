package bbdn.rest;
/**
 * This class contains all of the constants and enums used throughout the library.
 */
public abstract class BbDef {

  /**
   * The id type to specify which ID to use in the URL or query parameter, allowing calls to send a String and
   * an IDType rather than sending a different value for each type.
   * <ul><li>PRIMARY: PK1
   * <li>EXTERNALID: BatchUID
   * <li>COURSEID: Text Course ID displayed in the UI
   * <li>UUID: Universal Unique Identifier, used in conjunction with location
   * <li>USERNAME: User Name for identifying users
   * <li>FINALGRADE: Tells GET Columns to return the column marked 'Final Grade'</ul>
   */
  public class IDType {
      public final static String PRIMARY = "";
      public final static String EXTERNALID = "externalId:";
      public final static String COURSEID = "courseId:";
      public final static String UUID = "uuid:";
      public final static String USERNAME = "userName:";
      public final static String FINALGRADE = "finalGrade:";
  }

  /**
   * The id name describing the ID to be placed in the REST endpoint path. Possible values are:
   * <ul><li>ANNOUNCEMENT
   * <li>COURSE
   * <li>CHILDCOURSE
   * <li>TASK
   * <li>CONTENT
   * <li>ATTACHMENT
   * <li>GROUP
   * <li>USER
   * <li>DATASOURCE
   * <li>PLACEMENT
   * <li>TERM
   * <li>COLUMN
   * <li>ATTEMPT
   * <li>DATASET</ul>
   */
  public enum IDName {
      ANNOUNCEMENT, COURSE, CHILDCOURSE, TASK, CONTENT, ATTACHMENT, GROUP, USER, DATASOURCE, PLACEMENT, TERM, COLUMN, ATTEMPT, DATASET
  }

  /**
   * The grant_type to use during token request.
   * <ul><li>CLIENT: grant_type=client_credentials
   * <li>CODE: grant_type=authorization_code
   * <li>REFRESH: grant_type=refresh_token</ul>
   */
  public class GrantType {
    public final static String CLIENT = "client_credentials";
    public final static String CODE = "authorization_code";
    public final static String REFRESH = "refresh_token";
  }

  /**
   * The comparison operator for searching by created date.
   * <ul><li>GREATEROREQUAL: Search for a created date greater than or equal to the supplied value. This is the default.
   * <li>LESSTHAN: Search for a created date less than the supplied value</ul>
   */
  public class Compare {
    public final static String LESSTHAN = "lessThan";
    public final static String GREATEROREQUAL = "greaterOrEqual";
  }

  /**
   * The status of the course.
   * <ul><li>UNDECIDED: Course is set to let the instructor decide, who hasn't.
   * <li>ULTRA: This is an Ultra course.
   * <li>CLASSIC: This is an Original course.
   * <li>ULTRAPREVIEW: This course is being previewed in Ultra by the instructor.</ul>
   */
  public class UltraStatus {
    public final static String UNDECIDED = "Undecided";
    public final static String ULTRA = "Ultra";
    public final static String CLASSIC = "Classic";
    public final static String ULTRAPREVIEW = "UltraPreview";
  }

  /**
   * The availability status of an object.
   * <ul><li>YES: Object is Enabled and Available
   * <li>NO: Object is Enabled and Unavailable.
   * <li>DISABLED: Object is Disabled and Unavailable.
   * <li>TERM: Object Enabled and Available based on TERM status. Not available for all objects.</ul>
   */
  public class AvailabilityStatus {
    public final static String YES = "Yes";
    public final static String NO = "No";
    public final static String DISABLED = "Disabled";
    public final static String TERM = "Term";
    public final static String SIGNUPLIST = "SignupOnly";
  }

  /**
   * The course enrollment setting.
   * <ul><li>INSTRUCTOR: Course enrollment is managed by the instructor.
   * <li>SELF: Students may enroll themselves.
   * <li>EMAIL: Enrollments are handled via email.</ul>
   */
  public class CourseEnrollment {
    public final static String INSTRUCTOR = "InstructorLed";
    public final static String SELF = "SelfEnrollment";
    public final static String EMAIL = "EmailEnrollment";
  }

  /**
   * The duration.
   * <ul><li>CONTINUOUS: The course is active on an ongoing basis. This is the default.
   * <li>DATERANGE: The course will only be available between specific date ranges.
   * <li>FIXED: The course will only be available for a set number of days.
   * <li>TERM: The course's parent term duration settings will be used.</ul>
   */
  public class Duration {
    public final static String CONTINUOUS = "Continuous";
    public final static String DATERANGE = "DateRange";
    public final static String FIXED = "FixedNumDays";
    public final static String TERM = "Term";
  }

  /**
   * The locale id.
   * <ul><li>CONTINUOUS: The course is active on an ongoing basis. This is the default.
   * <li>DATERANGE: The course will only be available between specific date ranges.
   * <li>FIXED: The course will only be available for a set number of days.
   * <li>TERM: The course's parent term duration settings will be used.</ul>
   */
  public class LocaleId {
    public final static String US = "en_US";
    public final static String SPANISH = "es_ES";
    public final static String FRENCH = "fr_FR";
    public final static String ARABIC = "ar_SA";
  }

  /**
   * The content handler associated with a content item.
   * <ul><li>DOCUMENT: standard content item
   * <li>FOLDER: a folder containing other content items
   * <li>COURSELINK: a weblink in a course
   * <li>FORUMLINK: a link to a discussion board
   * <li>BLTILINK: an Content Item is the form of an LTI link
   * <li>FILE: a file</ul>
   */
  public class ContentHandler {
    public final static String DOCUMENT = "resource/x-bb-document";
    public final static String FOLDER = "resource/x-bb-folder";
    public final static String COURSELINK = "resource/x-bb-courselink";
    public final static String FORUMLINK = "resource/x-bb-forumlink";
    public final static String BLTILINK = "resource/x-bb-blti-link";
    public final static String FILE = "resource/x-bb-file";
  }

  /**
   * Course roles.
   * <ul><li>STUDENT: Has no access to the Control Panel. This is the default role.
   * <li>GUEST: Has no access to the Control Panel. Areas within the course are made available to guests, but typically they can only view
   *    course materials; they do not have access to tests or assessments, and do not have permission to post on discussion boards.
   *    Out  of the box, Learn also comes with the following roles, although they are customizable and may have different capabilities
   *    from what is documented here:
   * <li>INSTRUCTOR: Has access to all areas in the Control Panel. This role is generally given to those developing, teaching, or
   *    facilitating the class. Instructors may access a course that is unavailable to students.
   * <li>TEACHINGASSISTANT: The teaching assistant role is that of a co-teacher. Teaching assistants are able to administer all areas of a
   *    course. Their only limitations are those imposed by the instructor or Blackboard administrator at your school.
   * <li>COURSEBUILDER: Manages the course without having access to student grades.
   * <li>GRADER: Assists the instructor in the creation, management, delivery, and grading of items. These roles are also valid for an
   *    organization, although they are named differently in the UI.</ul>
   */
  public class CourseRoles {
    public final static String STUDENT = "Student";
    public final static String GUEST = "Guest";
    public final static String INSTRUCTOR = "Instructor";
    public final static String TEACHINGASSISTANT = "TeachingAssistant";
    public final static String COURSEBUILDER = "CourseBuilder";
    public final static String GRADER = "Grader";
  }

  /**
   * The type of LTI placement.
   * <ul><li>APPLICATION: Tool
   * <li>CONTENTHANDLER: A content item
   * <li>CONTENTITEMMESSAGE: A placement that allows for creating multiple content items, based on the IMS Global LTI Content Item Message
   * <li>SYSTEM: A system tool.</ul>
   */
  public class PlacementType {
    public final static String APPLICATION = "Application";
    public final static String CONTENTHANDLER = "ContentHandler";
    public final static String CONTENTITEMMESSAGE = "ContentItemMessage";
    public final static String SYSTEM = "System";
  }

  /**
   * The user's education level.
   * <ul><li>K8: Kindergarten through 8th grade
   * <li>HIGHSCHOOL: High School
   * <li>FRESHMAN: College Freshman
   * <li>SOPHOMORE: College Sophomore
   * <li>JUNIOR: College Junior
   * <li>SENIOR: College Senior
   * <li>GRADUATESCHOOL: Graduate school
   * <li>POSTGRADUATESCHOOL: Post graduate school
   * <li>UNKNOWN: Unknown</ul>
   */
  public class EducationLevel {
    public final static String K8 = "K8";
    public final static String HIGHSCHOOL = "HighSchool";
    public final static String FRESHMAN = "Freshman";
    public final static String SOPHOMORE = "Sophomore";
    public final static String JUNIOR = "Junior";
    public final static String SENIOR = "Senior";
    public final static String GRADUATESCHOOL = "GraduateSchool";
    public final static String POSTGRADUATESCHOOL = "PostGraduateSchool";
    public final static String UNKNOWN = "Unknown";
  }

  /**
   * Gender.
   * <ul><li>MALE: Male
   * <li>FEMALE: Female
   * <li>UNKNOWN: Unknown, undefined, or undisclosed</ul>
   */
  public class Gender {
    public final static String MALE = "Male";
    public final static String FEMALE = "Female";
    public final static String UNKNOWN = "Unknown";
  }

  /**
   * Calendar type for user's locale.
   * <ul><li>GREGORIAN: Gregorian
   * <li>GREGORIANHIJRI: Gregorian Hijri
   * <li>HIJRI: Hijri
   * <li>HIJRIGREGORIAN: Hijri Gregorian</ul>
   */
  public class Calendar {
    public final static String GREGORIAN = "Gregorian";
    public final static String GREGORIANHIJRI = "GregorianHijri";
    public final static String HIJRI = "Hijri";
    public final static String HIJRIGREGORIAN = "HijriGregorian";
  }

  /**
   * Determines what day the week starts in the user's locale
   * <ul><li>SUNDAY: Sunday
   * <li>MONDAY: Monday
   * <li>SATURDAY: Saturday</ul>
   */
  public class FirstWeekDay {
    public final static String SUNDAY = "Sunday";
    public final static String MONDAY = "Monday";
    public final static String SATURDAY = "Saturday";
  }

  /**
   * The type of Grading settings for this Grade Column
   * <ul><li>MANUAL: Manual
   * <li>CALCULATED: Calculated
   * <li>ATTEMPTS: Attempts</ul>
   */
  public class GradeType {
    public final static String MANUAL = "Manual";
    public final static String CALCULATED = "Calculated";
    public final static String ATTEMPTS = "Attempts";
  }

  /**
   * The scoring model for the submitted grade column attempts.
   * <ul><li>LAST: Last
   * <li>HIGHEST: Highest
   * <li>LOWEST: Lowest
   * <li>FIRST: First
   * <li>AVERAGE: Average</ul>
   */
  public class ScoringModel {
    public final static String LAST = "Last";
    public final static String HIGHEST = "Highest";
    public final static String LOWEST = "Lowest";
    public final static String FIRST = "First";
    public final static String AVERAGE = "Average";
  }

  /**
   * The type of AnonymousGrading settings for this Attempts based Grade Column
   * <ul><li>NONE: None
   * <li>DATE: Date
   * <li>AFTERALLGRADED: AfterAllGraded</ul>
   */
  public class AnonymousGrading {
    public final static String NONE = "None";
    public final static String DATE = "Date";
    public final static String AFTERALLGRADED = "AfterAllGraded";
  }

  /**
   * The status of a student attempt in the gradebook.
   * <ul><li>NONATTEMPTED: Has not been started
   * <li>ABANDONED: Has been abandoned
   * <li>INPROGRESS: Currently being worked on
   * <li>SUSPENDED: Attempt started, but not currently in progress
   * <li>CANCELED: Attempt was aborted
   * <li>NEEDSGRADING: Attempt is submitted, pending grading
   * <li>COMPLETED: Attempt is submitted and graded
   * <li>INMOREPROGRESS: Attempt was submitted, is now being redone
   * <li>NEEDSMOREGRADING: Attempt was submitted, reworked, and submitted again, and is pending grading</ul>
   */
  public class AttemptStatus {
    public final static String NOTATTEMPTED = "NotAttempted";
    public final static String ABANDONED = "Abandoned";
    public final static String INPROGRESS = "InProgress";
    public final static String SUSPENDED = "Suspended";
    public final static String CANCELED = "Canceled";
    public final static String NEEDSGRADING = "NeedsGrading";
    public final static String COMPLETED = "Completed";
    public final static String INMOREPROGRESS = "InMoreProgress";
    public final static String NEEDSMOREGRADING = "NeedsMoreGrading";
  }

  /**
   * The type of Grade Column Grading Schema used when creating the displayed grade
   * <ul><li>PERCENT: Percent
   * <li>SCORE: Score
   * <li>TABULAR: Tabular
   * <li>TEXT: Text
   * <li>COMPLETE: Complete</ul>
   */
  public class GradingSchema {
    public final static String PERCENT = "Percent";
    public final static String SCORE = "Score";
    public final static String TABULAR = "Tabular";
    public final static String TEXT = "Text";
    public final static String COMPLETE = "Complete";
  }

  /**
   * The group enrollment setting.
   * <ul><li>INSTRUCTOR: Group enrollment is managed by the instructor.
   * <li>SELF: Students may enroll themselves.</ul>
   */
  public class GroupEnrollment {
    public final static String INSTRUCTOR = "InstructorOnly";
    public final static String SELF = "SelfEnrollment";
  }

  /**
   * LogLevel, used for specifying the detail of the SIS Logging to request.
   * <ul><li>DEBUG: All Messages
   * <li>INFORMATION: Informational Messages
   * <li>WARNING: Warning Messages
   * <li>ERROR: Error Messages</ul>
   */
  public class LogLevel {
    public final static String DEBUG = "Debug";
    public final static String INFORMATION = "Information";
    public final static String WARNING = "Warning";
    public final static String ERROR = "Error";
  }

  /**
   * When specifying a field to sort results, they can be specified as ascending or descending.
   * <ul><li>ASCENDING: Sort in ascending order. This is the default.
   * <li>DESCENDING: Sort in descending order</ul>
   */
  public class SortMethod {
    public final static String ASCENDING = "";
    public final static String DESCENDING = "(desc)";
  }
}
