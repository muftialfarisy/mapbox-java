package com.mapbox.api.directions.v5.models;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.mapbox.api.directions.v5.DirectionsAdapterFactory;
import com.mapbox.api.directions.v5.DirectionsCriteria;
import com.mapbox.api.directions.v5.WalkingOptions;
import com.mapbox.api.directions.v5.WalkingOptionsAdapterFactory;
import com.mapbox.geojson.Point;
import com.mapbox.geojson.PointAsCoordinatesTypeAdapter;

import java.util.List;

/**
 * Provides information connected to your request that help when a new directions request is needing
 * using the identical parameters as the original request.
 * <p>
 * For example, if I request a driving (profile) with alternatives and continueStraight set to true.
 * I make the request but loose reference and information which built the original request. Thus, If
 * I only want to change a single variable such as the destination coordinate, i'd have to have all
 * the other route information stores so the request was made identical to the previous but only now
 * using this new destination point.
 * <p>
 * Using this class can provide you wth the information used when the {@link DirectionsRoute} was
 * made.
 *
 * @since 3.0.0
 */
@AutoValue
public abstract class RouteOptions extends DirectionsJsonObject {

  /**
   * Build a new instance of this RouteOptions class optionally settling values.
   *
   * @return {@link RouteOptions.Builder}
   * @since 3.0.0
   */
  public static Builder builder() {
    return new AutoValue_RouteOptions.Builder();
  }

  /**
   * The same base URL which was used during the request that resulted in this root directions
   * response.
   *
   * @return string value representing the base URL
   * @since 3.0.0
   */
  @NonNull
  public abstract String baseUrl();

  /**
   * The same user which was used during the request that resulted in this root directions response.
   *
   * @return string value representing the user
   * @since 3.0.0
   */
  @NonNull
  public abstract String user();

  /**
   * The same profile which was used during the request that resulted in this root directions
   * response. <tt>MapboxDirections.Builder</tt> ensures that a profile is always set even if the
   * <tt>MapboxDirections</tt> requesting object doesn't specifically set a profile.
   *
   * @return string value representing the profile
   * @since 3.0.0
   */
  @NonNull
  public abstract String profile();

  /**
   * The coordinates used for the routes origin, destination, and optionally, waypoints. Note that
   * these coordinates are different than the direction responses {@link DirectionsWaypoint}s in
   * that these are the non-snapped coordinates.
   *
   * @return a list of {@link Point}s which represent the route origin, destination,
   *   and optionally, waypoints
   * @since 3.0.0
   */
  @NonNull
  public abstract List<Point> coordinates();

  /**
   * The same alternative setting which were used during the request that resulted in this root
   * directions response.
   *
   * @return boolean object representing the setting for alternatives
   * @since 3.0.0
   */
  @Nullable
  public abstract Boolean alternatives();

  /**
   * The same language which was used during the request that resulted in this root directions
   * response.
   *
   * @return the language as a string used during the request,
   *   if english, this will most likely be empty
   * @since 3.0.0
   */
  @Nullable
  public abstract String language();

  /**
   * The same radiuses were used during the request that resulted in this root directions response.
   *
   * @return a list of radiuses
   * @since 3.0.0
   */
  @Nullable
  public abstract List<Double> radiuses();

  /**
   * The same bearings which were used during the request that resulted in this root directions
   * response. Note that even though these are saved. it's a good idea to recalculate any bearings
   * being used and use the newer values for the directions request.
   *
   * @return a string representing the bearings used in the original request
   * @since 3.0.0
   */
  @Nullable
  public abstract List<List<Double>> bearings();

  /**
   * The same continueStraight setting which was used during the request that resulted in this root
   * directions response.
   *
   * @return a boolean value representing whether or not continueStraight was enabled or
   *   not during the initial request
   * @since 3.0.0
   */
  @SerializedName("continue_straight")
  @Nullable
  public abstract Boolean continueStraight();

  /**
   * This is set to true if you want to enable instructions while exiting roundabouts
   * and rotaries.
   *
   * @return a boolean value representing whether or not roundaboutExits was enabled or disabled
   *   during the initial route request
   * @since 3.1.0
   */
  @SerializedName("roundabout_exits")
  @Nullable
  public abstract Boolean roundaboutExits();

  /**
   * Geometry type used to make the initial directions request.
   *
   * @return String geometry type used to make the initial directions request.
   * @since 3.1.0
   */
  public abstract String geometries();

  /**
   * Type of returned overview geometry that was used to make the initial directions request.
   *
   * @return null or one of the options found in
   *   {@link DirectionsCriteria.OverviewCriteria}
   * @since 3.1.0
   */
  @Nullable
  public abstract String overview();

  /**
   * Boolean value used to determine whether to return steps and turn-by-turn instructions in the
   * initial directions request.
   *
   * @return true if you'd like step information, false otherwise
   * @since 3.1.0
   */
  @Nullable
  public abstract Boolean steps();

  /**
   * The same annotations in String format which were used during the request that resulted in this
   * root directions response.
   *
   * @return a string containing any of the annotations that were used during the request
   * @since 3.0.0
   */
  @Nullable
  public abstract String annotations();

  /**
   * The same exclusions the user originally made when the request was made.
   *
   * @return a string matching one of the {@link DirectionsCriteria} exclusions
   * @since 3.0.0
   */
  @Nullable
  public abstract String exclude();

  /**
   * Whether or not the request had voice instructions set to true or not.
   *
   * @return true if the original request included voice instructions
   * @since 3.0.0
   */
  @SerializedName("voice_instructions")
  @Nullable
  public abstract Boolean voiceInstructions();

  /**
   * Whether or not the request had banner instructions set to true or not.
   *
   * @return true if the original request included banner instructions
   * @since 3.0.0
   */
  @SerializedName("banner_instructions")
  @Nullable
  public abstract Boolean bannerInstructions();

  /**
   * Whether or not the units used inside the voice instruction's string are in imperial or metric.
   *
   * @return a string matching either imperial or metric
   * @since 3.0.0
   */
  @SerializedName("voice_units")
  @Nullable
  public abstract String voiceUnits();

  /**
   * A valid Mapbox access token used to making the request.
   *
   * @return a string representing the Mapbox access token
   * @since 3.0.0
   */
  @SerializedName("access_token")
  @NonNull
  public abstract String accessToken();

  /**
   * A universally unique identifier (UUID) for identifying and executing a similar specific route
   * in the future. <tt>MapboxDirections</tt> always waits for the response object which ensures
   * this value will never be null.
   *
   * @return a string containing the request UUID
   * @since 3.0.0
   */
  @SerializedName("uuid")
  @NonNull
  public abstract String requestUuid();

  /**
   * Indicates from which side of the road to approach a waypoint.
   * Accepts  unrestricted (default) or  curb . If set to  unrestricted ,
   * the route can approach waypoints from either side of the road.
   * If set to curb, the route will be returned so that on arrival,
   * the waypoint will be found on the side that corresponds with the driving_side of the region
   * in which the returned route is located.
   * If provided, the list of approaches must be the same length as the list of waypoints.
   * However, you can skip a coordinate and show its position in the list with the ; separator.
   *
   * @return a list of strings representing approaches for each waypoint
   * @since 3.2.0
   */

  @Nullable
  public abstract List<String> approaches();

  /**
   * Indicates which input coordinates should be treated as waypoints.
   * <p>
   * Most useful in combination with  steps=true and requests based on traces
   * with high sample rates. Can be an index corresponding to any of the input coordinates,
   * but must contain the first ( 0 ) and last coordinates' index separated by  ; .
   * {@link #steps()}
   * </p>
   *
   * @return a List of Integers representing indices to be used as waypoints
   * @since 4.4.0
   */
  @SerializedName("waypoints")
  @Nullable
  public abstract List<Integer> waypointIndices();

  /**
   * Custom names for waypoints used for the arrival instruction in banners and voice instructions,
   * each separated by  ; . Values can be any string and total number of all characters cannot
   * exceed 500. If provided, the list of waypoint_names must be the same length as the list of
   * coordinates, but you can skip a coordinate and show its position with the ; separator.
   * @return  a list of strings representing names for each waypoint
   * @since 3.3.0
   */
  @SerializedName("waypoint_names")
  @Nullable
  public abstract List<String> waypointNames();


  /**
   * A semicolon-separated list of coordinate pairs used to specify drop-off
   * locations that are distinct from the locations specified in coordinates.
   * If this parameter is provided, the Directions API will compute the side of the street,
   * left or right, for each target based on the waypoint_targets and the driving direction.
   * The maneuver.modifier, banner and voice instructions will be updated with the computed
   * side of street. The number of waypoint targets must be the same as the number of coordinates,
   * but you can skip a coordinate pair and show its position in the list with the ; separator.
   * Must be used with steps=true.
   * @return  a list of Points representing coordinate pairs for drop-off locations
   * @since 4.3.0
   */
  @SerializedName("waypoint_targets")
  @Nullable
  public abstract List<Point> waypointTargets();

  /**
   * To be used to specify settings for use with the walking profile.
   *
   * @return options to use for walking profile
   * @since 4.8.0
   */
  @Nullable
  public abstract WalkingOptions walkingOptions();

  /**
   * A list of coordinates corresponding to locations leading up to the origin
   * in the Directions API request.
   */
  @SerializedName("origin_trace")
  @Nullable
  public abstract List<Point> originTrace();

  /**
   * A list of radius values corresponding to the accuracy of the origin_trace
   * locations.
   */
  @SerializedName("origin_trace_radiuses")
  @Nullable
  public abstract List<Integer> originTraceRadiuses();

  /**
   * A list of timestamp values corresponding to timestamps of the origin_trace
   * locations.
   */
  @Nullable
  @SerializedName("origin_trace_timestamps")
  public abstract List<Long> originTraceTimestamps();

  /**
   * Gson type adapter for parsing Gson to this class.
   *
   * @param gson the built {@link Gson} object
   * @return the type adapter for this class
   * @since 3.0.0
   */
  public static TypeAdapter<RouteOptions> typeAdapter(Gson gson) {
    return new AutoValue_RouteOptions.GsonTypeAdapter(gson);
  }

  /**
   * Create a new instance of this class by passing in a formatted valid JSON String.
   *
   * @param json a formatted valid JSON string defining a RouteOptions
   * @return a new instance of this class defined by the values passed inside this static factory
   *   method
   * @since 3.4.0
   */
  public static RouteOptions fromJson(String json) {
    GsonBuilder gson = new GsonBuilder();
    gson.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
    gson.registerTypeAdapter(Point.class, new PointAsCoordinatesTypeAdapter());
    gson.registerTypeAdapterFactory(WalkingOptionsAdapterFactory.create());
    return gson.create().fromJson(json, RouteOptions.class);
  }

  /**
   * Convert the current {@link RouteOptions} to its builder holding the currently assigned
   * values. This allows you to modify a single property and then rebuild the object resulting in
   * an updated and modified {@link RouteOptions}.
   *
   * @return a {@link RouteOptions.Builder} with the same values set to match the ones defined
   *   in this {@link RouteOptions}
   */
  @NonNull
  public abstract Builder toBuilder();

  /**
   * This builder can be used to set the values describing the {@link RouteOptions}.
   *
   * @since 3.0.0
   */
  @AutoValue.Builder
  public abstract static class Builder {

    /**
     * The base URL that was used during the request time and resulted in this responses
     * result.
     *
     * @param baseUrl base URL used for original request
     * @return this builder for chaining options together
     * @since 3.0.0
     */
    public abstract Builder baseUrl(@NonNull String baseUrl);

    /**
     * The user value that was used during the request.
     *
     * @param user string representing the user field in the calling url
     * @return this builder for chaining options together
     * @since 3.0.0
     */
    public abstract Builder user(@NonNull String user);

    /**
     * The directions profile that was used during the request time and resulted in this responses
     * result.
     *
     * @param profile One of the direction profiles defined in
     *                {@link DirectionsCriteria#DirectionsCriteria()}
     * @return this builder for chaining options together
     * @since 3.0.0
     */
    public abstract Builder profile(@NonNull @DirectionsCriteria.ProfileCriteria String profile);

    /**
     * The coordinates used for the routes origin, destination, and optionally, waypoints. Note that
     * these coordinates are different than the direction responses {@link DirectionsWaypoint}s in
     * that these are the non-snapped coordinates.
     *
     * @param coordinates a list of {@link Point}s which represent the route origin, destination,
     *                    and optionally, waypoints
     * @return this builder for chaining options together
     * @since 3.0.0
     */
    public abstract Builder coordinates(@NonNull List<Point> coordinates);

    /**
     * Whether the alternatives value was set to true or not.
     *
     * @param alternatives true if the request contained additional route request, otherwise false
     * @return this builder for chaining options together
     * @since 3.0.0
     */
    public abstract Builder alternatives(@Nullable Boolean alternatives);

    /**
     * The language for instructions to be in when the response is given.
     *
     * @param language a string with the language which was requested in the url
     * @return this builder for chaining options together
     * @since 3.0.0
     */
    public abstract Builder language(String language);

    /**
     * The radiuses in string format that were used during the original request.
     *
     * @param radiuses a list of radius values
     * @return this builder for chaining options together
     * @since 3.0.0
     */
    public abstract Builder radiuses(List<Double> radiuses);

    /**
     * The bearing values the user used for the original request which resulted in this response.
     * It is best to recalculate these values since they are probably outdated already.
     *
     * @param bearings List of list on doubles representing bearings
     * @return this builder for chaining options together
     * @since 3.0.0
     */
    public abstract Builder bearings(List<List<Double>> bearings);

    /**
     * Whether the original request wanted continueStraight enabled or not.
     *
     * @param continueStraight true if you'd like the user to continue straight from the starting
     *                         point
     * @return this builder for chaining options together
     * @since 3.0.0
     */
    public abstract Builder continueStraight(Boolean continueStraight);

    /**
     * This is set to true if you want to enable instructions while exiting roundabouts
     * and rotaries.
     *
     * @param roundaboutExits true if you'd like extra roundabout instructions
     * @return this builder for chaining options together
     * @since 3.1.0
     */
    public abstract Builder roundaboutExits(@Nullable Boolean roundaboutExits);

    /**
     * alter the default geometry being returned for the directions route. A null value will reset
     * this field to the APIs default value vs this SDKs default value of
     * {@link DirectionsCriteria#GEOMETRY_POLYLINE6}.
     *
     * @param geometries null if you'd like the default geometry, else one of the options found in
     *                   {@link DirectionsCriteria.GeometriesCriteria}.
     * @return this builder for chaining options together
     * @since 3.1.0
     */
    public abstract Builder geometries(@DirectionsCriteria.GeometriesCriteria String geometries);

    /**
     * Type of returned overview geometry that was used to make the initial directions request.
     *
     * @param overview null or one of the options found in
     *                 {@link DirectionsCriteria.OverviewCriteria}
     * @return this builder for chaining options together
     * @since 3.1.0
     */
    public abstract Builder overview(
      @Nullable @DirectionsCriteria.OverviewCriteria String overview
    );

    /**
     * Boolean value used to determine whether to return steps and turn-by-turn instructions in the
     * initial directions request.
     *
     * @param steps true if you'd like step information, false otherwise
     * @return this builder for chaining options together
     * @since 3.1.0
     */
    public abstract Builder steps(@Nullable Boolean steps);

    /**
     * The annotation which were used during the request process.
     *
     * @param annotations in string format and separated by commas if more than one annotation was
     *                    requested
     * @return this builder for chaining options together
     * @since 3.0.0
     */
    public abstract Builder annotations(String annotations);

    /**
     * Whether or not the request had voice instructions set to true or not.
     *
     * @param voiceInstructions true if the original request included voice instructions
     * @return this builder for chaining options together
     * @since 3.0.0
     */
    public abstract Builder voiceInstructions(Boolean voiceInstructions);

    /**
     * Whether or not the request had banner instructions set to true or not.
     *
     * @param bannerInstructions true if the original request included banner instructions
     * @return this builder for chaining options together
     * @since 3.0.0
     */
    public abstract Builder bannerInstructions(Boolean bannerInstructions);

    /**
     * Whether or not the units used inside the voice instruction's string are
     * in imperial or metric.
     *
     * @param voiceUnits string matching either imperial or metric
     * @return this builder for chaining options together
     * @since 3.0.0
     */
    public abstract Builder voiceUnits(@Nullable String voiceUnits);

    /**
     * A valid Mapbox access token used to making the request.
     *
     * @param accessToken a string containing a valid Mapbox access token
     * @return this builder for chaining options together
     * @since 3.0.0
     */
    public abstract Builder accessToken(@NonNull String accessToken);

    /**
     * A universally unique identifier (UUID) for identifying and executing a similar specific route
     * in the future.
     *
     * @param requestUuid a string containing the request UUID
     * @return this builder for chaining options together
     * @since 3.0.0
     */
    public abstract Builder requestUuid(@NonNull String requestUuid);

    /**
     * The same exclusions the user originally made when the request was made.
     *
     * @param exclude a string matching one of the {@link DirectionsCriteria} exclusions
     * @return this builder for chaining options together
     * @since 3.0.0
     */
    public abstract Builder exclude(@NonNull String exclude);

    /**
     * The same approaches the user originally made when the request was made.
     *
     * @param approaches a list of Strings
     * @return this builder for chaining options together
     * @since 3.2.0
     */
    public abstract Builder approaches(List<String> approaches);

    /**
     * The same waypoint indices the user originally made when the request was made.
     *
     * @param indices to be used as waypoints
     * @return this builder for chaining options together
     * @since 4.4.0
     */
    public abstract Builder waypointIndices(@Nullable List<Integer> indices);

    /**
     * The same waypoint names the user originally made when the request was made.
     *
     * @param waypointNames a list of Strings
     * @return this builder for chaining options together
     * @since 3.3.0
     */
    public abstract Builder waypointNames(@Nullable List<String> waypointNames);

    /**
     * The same waypoint targets the user originally made when the request was made.
     *
     * @param waypointTargets list of Points for drop-off locations
     * @return this builder for chaining options together
     * @since 4.3.0
     */
    public abstract Builder waypointTargets(@Nullable List<Point> waypointTargets);

    /**
     * To be used to specify settings for use with the walking profile.
     *
     * @param walkingOptions options to use for walking profile
     * @return this builder for chaining options together
     * @since 4.8.0
     */
    public abstract Builder walkingOptions(@NonNull WalkingOptions walkingOptions);

    /**
     * The origin_trace query parameter is a list of coordinates corresponding to locations leading
     * up to the origin in the Directions API request.
     *
     * @param originTrace list of coordinates corresponding to locations leading up to the origin
     *                    in the Directions API request
     * @return this builder for chaining options together
     */
    public abstract Builder originTrace(@NonNull List<Point> originTrace);

    /**
     * The origin_trace_radiuses query parameter is a list of radius values corresponding to the
     * accuracy of the origin_trace locations.
     *
     * @param originTraceRadiuses list of radius values corresponding to the accuracy of the
     *                            origin_trace locations
     * @return this builder for chaining options together
     */
    public abstract Builder originTraceRadiuses(@NonNull List<Integer> originTraceRadiuses);

    /**
     * The origin_trace_timestamps query parameter is a list of timestamp values corresponding to
     * timestamps of the origin_trace locations.
     *
     * @param originTraceTimestamps list of timestamp values corresponding to timestamps of the
     *                              origin_trace locations
     * @return this builder for chaining options together
     */
    public abstract Builder originTraceTimestamps(@NonNull List<Long> originTraceTimestamps);

    /**
     * Builds a new instance of the {@link RouteOptions} object.
     *
     * @return a new {@link RouteOptions} instance
     * @since 3.0.0
     */
    public abstract RouteOptions build();
  }
}
