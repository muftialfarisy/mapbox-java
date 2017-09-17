package com.mapbox.services.constants;

/**
 * Includes common variables used throughout the Mapbox Service modules.
 *
 * @since 3.0.0
 */
public final class Constants {

  protected Constants() {
    // Empty constructor prevents users from initializing this class
  }

  /**
   * A Mercator project has a finite longitude values, this constant represents the lowest value
   * available to represent a geolocation.
   *
   * @since 3.0.0
   */
  public static final double MIN_LONGITUDE = -180;

  /**
   * A Mercator project has a finite longitude values, this constant represents the highest value
   * available to represent a geolocation.
   *
   * @since 3.0.0
   */
  public static final double MAX_LONGITUDE = 180;

  /**
   * While on a Mercator projected map the width (longitude) has a finite values, the height
   * (latitude) can be infinitely long. This constant restrains the lower latitude value to -90 in
   * order to preserve map readability and allows easier logic for tile selection.
   *
   * @since 3.0.0
   */
  public static final double MIN_LATITUDE = -90;

  /**
   * While on a Mercator projected map the width (longitude) has a finite values, the height
   * (latitude) can be infinitely long. This constant restrains the upper latitude value to 90 in
   * order to preserve map readability and allows easier logic for tile selection.
   *
   * @since 3.0.0
   */
  public static final double MAX_LATITUDE = 90;

  /**
   * User agent for HTTP requests.
   *
   * @since 1.0.0
   */
  public static final String HEADER_USER_AGENT = "TODO"; // TODO
//    String.format(Locale.US, "MapboxJava/%s (%s)", BuildConfig.VERSION, BuildConfig.GIT_REVISION);

  /**
   * Base URL for all API calls, not hardcoded to enable testing
   *
   * @since 1.0.0
   */
  public static final String BASE_API_URL = "https://api.mapbox.com";

  public static final String MAPBOX_USER = "mapbox";
}
