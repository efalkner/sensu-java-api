package com.commercehub.sensu.api;

import com.google.gson.JsonObject;
import feign.Headers;
import feign.RequestLine;

import javax.inject.Named;
import java.util.List;

/**
 * Client for the Sensu REST API.
 *
 * @see <a href="http://sensuapp.org/docs/0.12/api">The Sensu API</a>
 */
public interface SensuApi {
    /**
     * Returns a list of stash paths.
     *
     * @return a list of stash paths
     */
    @RequestLine("GET /stashes")
    @Headers("Accept: application/json")
    List<StashPath> getStashes() throws SensuErrorException;

    /**
     * Returns a list of stash paths.
     *
     * @param limit  the number of stashes to return
     * @param offset the number of stashes to offset before returning items
     * @return a list of stash paths
     */
    @RequestLine("GET /stashes?limit={limit}&offset={offset}")
    @Headers("Accept: application/json")
    List<StashPath> getStashes(@Named("limit") int limit, @Named("offset") int offset) throws SensuErrorException;

    /**
     * Creates a stash.
     *
     * @param stashPath information about the desired stash
     */
    @RequestLine("POST /stashes")
    @Headers("Content-Type: application/json")
    void createStash(StashPath stashPath) throws SensuMalformedDataException, SensuErrorException;

    /**
     * Creates a stash.  If you want the stash to expire, use {@link #createStash(StashPath)} instead.
     *
     * @param path the path for the stash
     * @param stash the stash to create
     */
    @RequestLine("POST /stashes/{path}")
    @Headers("Content-Type: application/json")
    void createStash(@Named("path") String path, JsonObject stash) throws SensuMalformedDataException, SensuErrorException;

    /**
     * Returns the stash with the specified path.
     *
     * @param path the path for the stash
     * @return the stash with the specified path
     */
    @RequestLine("GET /stashes/{path}")
    @Headers("Accept: application/json")
    JsonObject getStash(@Named("path") String path) throws SensuNotFoundException, SensuErrorException;

    /**
     * Deletes the stash with the specified path.
     *
     * @param path the path for the stash
     */
    @RequestLine("DELETE /stashes/{path}")
    void deleteStash(@Named("path") String path) throws SensuNotFoundException, SensuErrorException;
}
